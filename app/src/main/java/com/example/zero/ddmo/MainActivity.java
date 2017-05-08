package com.example.zero.ddmo;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

import adapters.NavigationBaseAdapter;
import adapters.NavigationItems;

public class MainActivity extends ActionBarActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    private SliderLayout mDemoSlider;
    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView recyclerView;
    private CardView cardView;

    private ArrayList<FeedProperties> os_versions;
    private AutoCompleteTextView autoComplete;

    private CardViewAdapter mAdapter;
   // private RecyclerView.Adapter mAdapter;
    // private RecyclerView.LayoutManager mLayoutManager;

    NavigationBaseAdapter adapter;

    ArrayAdapter<String> stringAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initContrls();

        String[] colors = getResources().getStringArray(R.array.colorList);

        stringAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row, colors);






        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        autoComplete.setAdapter(stringAdapter);

        autoComplete.setTextColor(Color.BLACK);



        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Ws",R.drawable.slid1);
        file_maps.put("Ws Design",R.drawable.slid2);
        file_maps.put("Ws Android",R.drawable.slid3);
        file_maps.put("Ws Web", R.drawable.slid4);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            // textSliderView.getBundle().putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);






    }

    private void initContrls() {

        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        //  cardView = (CardView) findViewById(R.id.cardList);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");

        }

        final String[] versions = {"SHIRTS", "SHIRTS", "SHIRTS", "SHIRTS",
                "SHIRTS", "SHIRTS"};
        final int[] icons = {R.drawable.girla, R.drawable.girlb, R.drawable.girlc, R.drawable.girld, R.drawable.girle, R.drawable.girlf};


        os_versions = new ArrayList<FeedProperties>();

        for (int i = 0; i < versions.length; i++) {
            FeedProperties feed = new FeedProperties();

            feed.setTitle(versions[i]);
            feed.setThumbnail(icons[i]);
            os_versions.add(feed);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new CardViewAdapter(os_versions);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

}

