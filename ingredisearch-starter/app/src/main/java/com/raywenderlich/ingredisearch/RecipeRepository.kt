package com.raywenderlich.ingredisearch

/**
 * Created by ykc on 2018-02-02.
 */
interface RecipeRepository {
    fun addFavorite(item: Recipe)
    fun removeFavorite(item: Recipe)
    fun getFavoriteRecipes(): List<Recipe>
    fun getRecipes(query: String, callback: RepositroyCallback<List<Recipe>>)
}

interface RepositroyCallback<in T> {
    fun onSuccess(t: T?)
    fun onError()
}