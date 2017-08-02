var ingredient_form = '<div class="form-group ingredients">';
ingredient_form += $(".ingredients").last().clone().html();
ingredient_form += '<div>';

var ingredient_num = 1;

$(document).on("click", "#add_ingredients", function () {
    ingredient_num++;

    $("#add_ingredients").remove();

    $(".ingredients").last().after(ingredient_form);

    $(".ingredients").last().find('input').first().attr("placeholder", "Ingredient  " + ingredient_num);

    $(".ingredients").last().find('#ingredients').first().attr("value", "");
    $(".ingredients").last().find('#amount').first().attr("value", "");

    $(".label1").last().text("");

    var stage_count = $(".ingredients").find('#ingredients').size() - 1;

    $(".ingredients").last().find('#ingredients').first().attr("name", "ingredients[" + stage_count + "].title");
    $(".ingredients").last().find('#amount').first().attr("name", "ingredients[" + stage_count + "].amount");

    $(".subtract_ingredient").removeClass("display-none");
    $(".subtract_ingredient").last().addClass("display-none");
});

$(document).on("click", ".subtract_ingredient", function () {
    $(this).closest(".ingredients").remove();
});

var allergen_form = '<div class="control-group allergens">';
allergen_form += $(".allergens").last().clone().html();
allergen_form += '<div>';

var allergen_num = 1;

$(document).on("click", "#add_allergens", function () {
    allergen_num++;

    $("#add_allergens").remove();

    $(".allergens").last().after(allergen_form);

    $(".allergens").last().find('input').first().attr("placeholder", "Allergen  " + allergen_num);

    $(".allergens").last().find('#allergens').first().attr("value", "");

    $(".subtract_allergen").removeClass("display-none");
    $(".subtract_allergen").last().addClass("display-none");
});

$(document).on("click", ".subtract_allergen", function () {
    $(this).closest(".allergens").remove();
});

var stage_form = '<div class="form-group stages">';
stage_form += $(".stages").last().clone().html();
stage_form += '<div>';

var stage_num = 1;

$(document).on("click", "#add_stages", function () {
    stage_num++;

    $("#add_stages").remove();

    $(".stages").last().after(stage_form);

    $(".stages").last().find("textarea").attr("placeholder", "Stage " + stage_num + ". description");

    $(".stages").last().find('.stage').first().val("");

    var stage_count = $(".stages").find('.stage').size() - 1;

    $(".stages").last().find('.stage').first().attr("name", "stages[" + stage_count + "].stage");

    $(".label2").last().text("");

    $(".subtract_stage").removeClass("display-none");
    $(".subtract_stage").last().addClass("display-none");
});

$(document).on("click", ".subtract_stage", function () {
    $(this).closest(".stages").remove();
});


$(document).on("click", "#dismissLogin", function () {
    if (location.href.match("/newRecipe$") || location.href.match("/updateRecipe")) {
        location.href = window.location.origin + "/foodie/home";
    }
});