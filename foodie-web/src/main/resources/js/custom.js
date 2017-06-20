var ingredient_form ='<div class="form-group ingredients">';
ingredient_form += $(".ingredients").last().clone().html();
ingredient_form += '<div>';

var ingredient_num = 1;

$(document).on("click", "#add_ingredients", function(){
	
	 ingredient_num++;
	
	 $("#add_ingredients").remove();
	 
     $(".ingredients").last().after( ingredient_form );
     
     $(".ingredients").last().find('input').first().attr("placeholder", "Ingredient  " + ingredient_num);
     
     $(".label1").last().text("");
     
});

var allergen_form ='<div class="control-group allergens">';
allergen_form += $(".allergens").last().clone().html();
allergen_form += '<div>';

var allergen_num = 1;

$(document).on("click", "#add_allergens", function(){
	
	allergen_num++;
	
	$("#add_ingredients").remove();
	 
    $(".allergens").last().after( allergen_form );
    
    $(".allergens").last().find('input').first().attr("placeholder", "Allergen  " + allergen_num);
        
});

var stage_form ='<div class="form-group stages">';
stage_form += $(".stages").last().clone().html();
stage_form += '<div>';

var stage_num = 1;

$(document).on("click", "#add_stages", function(){
	
	 stage_num++;
	
	 $("#add_stages").remove();
	 
     $(".stages").last().after( stage_form );
     
     $(".stages").last().find("textarea").attr("placeholder", "Stage " + stage_num + ". description");
     
     $(".label2").last().text("");
     
});

//$("#saveButton").click(function(){
//	
//	var saveRecipeForm = $("#saveRecipeForm").serialize();
//	
//	$.ajax({
//	    type:"post",
//	    data:saveRecipeForm,
//	    url:"saveNewRecipe",
//	    dataType: "json",
//	    success: function(data){
//	       alert("success");
//	       $("#displaySuccess").css("display", "block");
//	    }
//	});
//	
//});