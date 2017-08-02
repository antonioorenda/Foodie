package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class Registration {
	
	@Autowired
	private FoodieService foodieService;

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registration() {
		 
		return "registration"; 
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("User") User user, HttpServletRequest request) throws Exception {
		
		String password = PasswordUtil.hashPassword(user.getPassword());
		user.setPassword(password);
		user.setDateRegistered(new Date());
		user.setIsAdminUser(false);

		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("username", user.getUsername());
		
		foodieService.saveOrUpdateUser(user);
		
		return "redirect:home";
	}

	// TODO kod logina poruka ako ne postoji korisnik ili ako je krivo korisnicko ili pass
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getUser(@ModelAttribute("User") User user, HttpServletRequest request) throws Exception {
		
		String password = PasswordUtil.hashPassword(user.getPassword());
		user.setPassword(password);
		
		List<User> users = foodieService.fetchAllUsers();
		
		int userCount = 0;
		
		for (User existingUser : users) {
			if(existingUser.getPassword().trim().equals(user.getPassword()) && existingUser.getUsername().trim().equals(user.getUsername())){
				userCount++;
				user = existingUser;
			}
		}
				
		if(userCount == 1){
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", user.getUsername());
			
			if(user.getIsAdminUser()){
				request.getSession().setAttribute("adminuser", true);
			}
		}
		
		String referrer = request.getHeader("referer");
		String[] parts = referrer.split("/");
		
		if(parts[parts.length - 1].equals("foodie")){
			return "redirect:/";
		}
		
		return "redirect:" + parts[parts.length - 1];
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
	
		request.getSession().removeAttribute("username");
		request.getSession().setAttribute("adminuser", false);
		
		return "redirect:home";
	}
	
}
