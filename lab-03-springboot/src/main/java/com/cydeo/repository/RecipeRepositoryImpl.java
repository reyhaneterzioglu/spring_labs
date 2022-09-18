package com.cydeo.repository;

import com.cydeo.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {

    public List<Recipe> recipeList;

    @Override
    public boolean save(Recipe recipe) {

        return recipeList.add(recipe);
    }
}
