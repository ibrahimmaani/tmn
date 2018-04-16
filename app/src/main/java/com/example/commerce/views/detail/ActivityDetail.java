package com.example.commerce.views.detail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commerce.R;
import com.example.commerce.models.entities.FavModel;
import com.example.commerce.models.entities.Product;
import com.example.commerce.models.networks.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import at.blogc.android.views.ExpandableTextView;

public class ActivityDetail extends AppCompatActivity {

    List<Data> data;
    RecyclerView recycle_horizontal;
    HorizontalAdapter horizontalAdapter;
    Context context;
    ImageButton down, up,  share;
    ImageView image;
    TextView brand, price, buttonToggle;
    Toolbar toolbar;
    SharedPreference sharedPreference;
    SharedPreferences sharedPreferences;
    at.markushi.ui.CircleButton addFavorite;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Price = "priceKey";
    public static final String Image = "imageKey";

    Spinner spinner;
    Button button, addcart;

    ExpandableTextView description;

    String url;
    Product product;
    FavModel favoriteModel;
    List<FavModel> products;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dtl1);
        down = (ImageButton) findViewById(R.id.down);
        up = (ImageButton) findViewById(R.id.up);
        brand = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        image = (ImageView) findViewById(R.id.img);
        description = (ExpandableTextView) findViewById(R.id.description);
        addcart = (Button) findViewById(R.id.add_chart);
        addFavorite = (at.markushi.ui.CircleButton) findViewById(R.id.ic_love);


        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        sharedPreference = new SharedPreference();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recycle_horizontal = (RecyclerView) findViewById(R.id.inner_recyclerView);
        data = fill_with_data();
        horizontalAdapter = new HorizontalAdapter(data, getApplication());
        recycle_horizontal.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        recycle_horizontal.setAdapter(horizontalAdapter);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        final TextView name = (TextView) findViewById(R.id.name);
        TextView price = (TextView) findViewById(R.id.price);
        TextView description = (TextView) findViewById(R.id.description);
        ImageView image = (ImageView) findViewById(R.id.img);
        at.markushi.ui.CircleButton share = (at.markushi.ui.CircleButton) findViewById(R.id.ic_share);
        final ExpandableTextView expandableTextView = (ExpandableTextView) this.findViewById(R.id.description);
//        final TextView buttonToggle = (TextView) this.findViewById(R.id.show_more);

        Spinner spinner = (Spinner) findViewById(R.id.qty);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.qty, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "here is share content body";
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "like to share this");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "share via"));
            }
        });




        final Product product = (Product) getIntent().getParcelableExtra("value");
        final String url = (String) getIntent().getStringExtra("image");

        String getName = product.getName();
        name.setText(getName);

        String getPrice = String.valueOf(product.getPrice());
        price.setText(getPrice);

        String getDescription = product.getDescription();
        description.setText(getDescription);


        Picasso.with(context).load(ApiClient.ASSETS_URL + url).into(image);





        /*Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {

            String getName = (String) bd.get("name");
            name.setText(getName);


            Integer getPrice = (Integer) bd.get("price");
            price.setText(String.valueOf(getPrice));


            String getDescription = (String) bd.get("description");
            expandableTextView.setText(getDescription);

            scrollView.scrollTo(0,0);
        }*/


        // set animation duration via code, but preferable in your layout files by using the animation_duration attribute
        expandableTextView.setAnimationDuration(750L);
        // set interpolators for both expanding and collapsing animations
        expandableTextView.setInterpolator(new OvershootInterpolator());

        // or set them separately
        expandableTextView.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView.setCollapseInterpolator(new OvershootInterpolator());

        if (checkFavoriteItem(product)) {
            addFavorite.setImageResource(R.drawable.ic_favorite_black_18dp);
            addFavorite.setTag("red");
        } else {
            addFavorite.setImageResource(R.drawable.love);
            addFavorite.setTag("grey");
        }


        down.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                down.setVisibility(View.GONE);
                up.setVisibility(View.VISIBLE);
                expandableTextView.setMaxLines(Integer.MAX_VALUE);

            }
        });

        up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                up.setVisibility(View.GONE);
                down.setVisibility(View.VISIBLE);
                expandableTextView.setMaxLines(5);

            }
        });

        addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavModel favModel = new FavModel();
                favModel.setName(product.getName());
                favModel.setPrice(product.getPrice());
                favModel.setUrl(url);
                favModel.setId(product.getId());
                at.markushi.ui.CircleButton  button = (at.markushi.ui.CircleButton ) findViewById(R.id.ic_love);

                String tag = button.getTag().toString();
                if (tag.equalsIgnoreCase("grey")) {
                    sharedPreference.addFavorite(ActivityDetail.this, favModel);
                    Toast.makeText(ActivityDetail.this,
                            ActivityDetail.this.getResources().getString(R.string.add_favr),
                            Toast.LENGTH_SHORT).show();

                    button.setTag("red");
                    button.setImageResource(R.drawable.ic_favorite_black_18dp);
                } else {
                    sharedPreference.removeFavorite(ActivityDetail.this, favModel);
                    Toast.makeText(ActivityDetail.this,
                            ActivityDetail.this.getResources().getString(R.string.remove_favr),
                            Toast.LENGTH_SHORT).show();
                    button.setTag("grey");
                    button.setImageResource(R.drawable.love);

                }
                return;
            }
        });

//        nestedScrollView.getParent().requestChildFocus(nestedScrollView, nestedScrollView);
    }

    public boolean checkFavoriteItem(Product produk) {
        boolean check = false;
        products = sharedPreference.getFavorites(this);
        if (products != null) {
            for (FavModel product: products) {
                if (product.getId().equals(product.getId())) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    public List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.home1, "image1"));
        data.add(new Data(R.drawable.detail2, "image2"));
        data.add(new Data(R.drawable.detail3, "image3"));
        return data;
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu_detail) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu_detail);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}