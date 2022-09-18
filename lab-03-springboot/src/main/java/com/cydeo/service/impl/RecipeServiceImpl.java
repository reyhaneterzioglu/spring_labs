package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@Component
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private ShareService shareService;
    public Faker faker;


    @Override
    public boolean prepareRecipe() {

        for (int i = 0; i < 20; i++) {

            Arrays.stream(RecipeType.values()).forEach(recipeType -> {
                Recipe recipe = new Recipe();
                recipe.setId(UUID.randomUUID());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
                recipe.setIngredients(prepareIngredients());
                recipe.setRecipeType(recipeType);
                recipeRepository.save(recipe);
                shareService.share(recipe);
            });
        }

        return true;
    }

    private List<Ingredient> prepareIngredients() {
        List<QuantityType> quantityTypeList = List.of(QuantityType.values());

        List<Ingredient> ingredientList = new ArrayList<>();

        for (int i = 0; i < generateRandomValue(); i++) {

            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));
            ingredientList.add(ingredient);
        }

        return ingredientList;

    }

    private int generateRandomValue() {
        return new Random().nextInt(20);
    }
}
