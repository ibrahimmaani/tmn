package com.example.commerce.views.detail;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.commerce.models.entities.FavModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arie-Ezio on 11-Apr-18.
 */

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<FavModel> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, FavModel favModel) {
        List<FavModel> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<FavModel>();
        favorites.add(favModel);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, FavModel favModel) {
        ArrayList<FavModel> favorites = getFavorites(context);
        ArrayList<FavModel> favModels = new ArrayList<>();
        //favModels.add(favModel);
        if (favorites != null) {
//            favorites.remove(favModels.get(0));
//            System.out.println(favorites.size());
//            saveFavorites(context, favorites);
            for (FavModel product : favorites) {
                if (!favModel.getId().equals(product.getId())) {
                    favModels.add(product);
                }
            }
            saveFavorites(context, favModels);
        }
    }

    public ArrayList<FavModel> getFavorites(Context context) {
        SharedPreferences settings;
        List<FavModel> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            FavModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    FavModel[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<FavModel>(favorites);
        } else
            return null;

        return (ArrayList<FavModel>) favorites;
    }
}
