package com.example.commerce.views.detail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.commerce.R;
import com.example.commerce.models.entities.FavModel;

import java.util.List;

public class FavoriteListActivity extends AppCompatActivity {

    SharedPreference sharedPreference;
    List<FavModel> favorites;
    FavListAdapter favListAdapter;
    GridView favoriteGrid;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_favlist);

        sharedPreference = new SharedPreference();
        favorites = sharedPreference.getFavorites(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_fav);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (favorites == null) {
            showAlert(getResources().getString(R.string.no_favorites_items));
        } else {

            if (favorites.size() == 0) {
                showAlert(
                        getResources().getString(R.string.no_favorites_items));
            }

            favoriteGrid = (GridView) findViewById(R.id.list_product);
            if (favorites != null) {
                favListAdapter = new FavListAdapter(FavoriteListActivity.this, favorites);
                favoriteGrid.setAdapter(favListAdapter);

                favoriteGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View arg1,
                                            int position, long arg3) {

                    }
                });

                favoriteGrid
                        .setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                            @Override
                            public boolean onItemLongClick(
                                    AdapterView<?> parent, View view,
                                    int position, long id) {

                                ImageView button = (ImageView) view
                                        .findViewById(R.id.ic_love);

                                String tag = button.getTag().toString();
                                if (tag.equalsIgnoreCase("grey")) {
                                    sharedPreference.addFavorite(FavoriteListActivity.this,
                                            favorites.get(position));
                                    Toast.makeText(
                                            FavoriteListActivity.this,
                                            FavoriteListActivity.this.getResources().getString(
                                                    R.string.add_favr),
                                            Toast.LENGTH_SHORT).show();

                                    button.setTag("red");
                                    button.setImageResource(R.drawable.ic_favorite_black_18dp);
                                } else {
                                    sharedPreference.removeFavorite(FavoriteListActivity.this,
                                            favorites.get(position));
                                    button.setTag("grey");
                                    button.setImageResource(R.drawable.love);
                                    favListAdapter.remove(favorites
                                            .get(position));
                                    Toast.makeText(
                                            FavoriteListActivity.this,
                                            FavoriteListActivity.this.getResources().getString(
                                                    R.string.remove_favr),
                                            Toast.LENGTH_SHORT).show();
                                }
                                return true;
                            }
                        });
            }
        }
    }

    public void showAlert(String message) {
        if (FavoriteListActivity.this != null && !FavoriteListActivity.this.isFinishing()) {
            AlertDialog alertDialog = new AlertDialog.Builder(FavoriteListActivity.this)
                    .create();
            alertDialog.setMessage(message);
            alertDialog.setCancelable(false);

            // setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            // activity.finish();
                            getFragmentManager().popBackStackImmediate();
                        }
                    });
            alertDialog.show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
