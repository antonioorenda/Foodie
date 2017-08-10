package hr.tvz.foodie.web.controller;

import hr.tvz.foodie.core.model.User;
import hr.tvz.foodie.core.service.FoodieService;
import hr.tvz.foodie.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class Registration {

	@Autowired
	private FoodieService foodieService;

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String saveUser(Model model, @Valid @ModelAttribute("User") User user, BindingResult bindingResult,
						   HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("registrationError", true);

			return "registration";
		}

		User foundUser = foodieService.fetchUserByUsername(user);

		if (foundUser != null) {
			model.addAttribute("usernameExists", true);

			return "registration";
		}

		String password = PasswordUtil.hashPassword(user.getPassword());

		user.setPassword(password);
		user.setDateRegistered(new Date());
		user.setIsAdminUser(false);

		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("username", user.getUsername());

		foodieService.saveOrUpdateUser(user);

		model.addAttribute("registrationError", false);

		return "home";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getUser(Model model, @ModelAttribute("User") User user, HttpServletRequest request) {

		String password = PasswordUtil.hashPassword(user.getPassword());
		user.setPassword(password);

		User foundUser = foodieService.fetchUserByUsernameAndPassword(user);

		String page = getPage(request);

		if (foundUser == null) {
			model.addAttribute("loginError", true);

			return page;
		}

		request.getSession().setAttribute("user", foundUser);
		request.getSession().setAttribute("username", foundUser.getUsername());

		if (foundUser.getIsAdminUser()) {
			request.getSession().setAttribute("adminUser", true);
		}

		return "redirect:" + page;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("username");
		request.getSession().setAttribute("adminUser", false);

		return "redirect:home";
	}

	public String getPage(HttpServletRequest request) {
		String referrer = request.getHeader("referer");
		String[] parts = referrer.split("/");

		if (parts[parts.length - 1].equals("foodie") || parts[parts.length - 1].equals("login")) {
			return "home";
		}

		return parts[parts.length - 1];
	}

}
