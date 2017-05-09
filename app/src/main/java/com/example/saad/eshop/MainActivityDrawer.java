package com.example.saad.eshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivityDrawer extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {


    ImageView arrow;
    private static String TAG = MainActivityDrawer.class.getSimpleName();

    private static final int INDIGO_500 = 0xff3f51b5;

    // Sets variables to save the colors of each attribute
    private int mBarColor;

    Button sizex1,sizex2,sizex3,sizex4,sizex5,sizex6,sizex7,sizex8,sizex9;

    private int mConnectingLineColor;

    private int mPinColor;
    private int mTextColor;

    private int mTickColor;

    // Initializes the RangeBar in the application
    private RangeBar rangebar;

    private int mSelectorColor;



    private Toolbar mToolbar;
    FragmentDrawer drawerFragment;
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<parent> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private View mLeftDrawerView;
    private View mRightDrawerView;

    private Integer[] icon = { R.drawable.ic_cloth,
            R.drawable.ic_shoes,
            R.drawable.ic_sports,
            R.drawable.ic_bags,


    };

    Spinner spinnerDropDown;
    String[] cities = {
            "Brand",
            "Puma",
            "Adidas",
            "Nike",
            "Lee",

    };



    Spinner planetSpinner1;

    String[] cities1 = {
            "Occasion",
            "Puma",
            "Nike",
            "Lee",

    };

    private LinearLayout right_drawer;

    // Here put names of group

    private String[] name = { "CLOTHINGS","SHOES","SPORTS","BAGS & ACCESSORY"};

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("BAR_COLOR", mBarColor);
        bundle.putInt("CONNECTING_LINE_COLOR", mConnectingLineColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

       /* this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_drawer);
*/


        ImageView filter = (ImageView)findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mDrawerLayout.openDrawer(right_drawer);

            }
        });



        arrow =(ImageView)findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mDrawerLayout.closeDrawer(right_drawer);

            }
        });

        sizex1 =(Button) findViewById(R.id.sizex1);
        sizex2 =(Button) findViewById(R.id.sizex2);
        sizex3 =(Button) findViewById(R.id.sizex3);
        sizex4 =(Button) findViewById(R.id.sizex4);
        sizex5 =(Button) findViewById(R.id.sizex5);


        sizex6 =(Button) findViewById(R.id.sizex11);
        sizex7 =(Button) findViewById(R.id.sizex12);
        sizex8 =(Button) findViewById(R.id.sizex13);
        sizex9 =(Button) findViewById(R.id.sizex14);



        sizex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("XXS","1");

            }
        });


        sizex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("XS","2");

            }
        });
        sizex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("S","3");

            }
        });
        sizex4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("M","4");

            }
        });
        sizex5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("L","5");

            }
        });
        sizex6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("XL","6");

            }
        });
        sizex7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("XXL","7");

            }
        });
        sizex8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("3XL","8");

            }
        });
        sizex9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        rangebar = (RangeBar) findViewById(R.id.rangebar1);



        final Button leftIndexValue = (Button) findViewById(R.id.rang1);
        final Button rightIndexValue = (Button) findViewById(R.id.rang2);

        // Sets the display values of the indices
        rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
                leftIndexValue.setText("$" + leftPinIndex);
                rightIndexValue.setText("$" + rightPinIndex);
            }

        });


        spinnerDropDown =(Spinner)findViewById(R.id.planetSpinner);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item ,cities);

        spinnerDropDown.setAdapter(adapter);

        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                int sid = spinnerDropDown.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected City : " + cities[sid],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        planetSpinner1 =(Spinner)findViewById(R.id.planetSpinner1);

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item ,cities1);

        planetSpinner1.setAdapter(adapter1);

        planetSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                int sid = planetSpinner1.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected City : " + cities1[sid],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        right_drawer = (LinearLayout) findViewById(R.id.right_drawer);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

       /* if (item != null && id == android.R.id.home) {
            if (mNavigationDrawerFragment.isDrawerOpen(Gravity.RIGHT)) {
                mNavigationDrawerFragment.closeDrawer(Gravity.RIGHT);
            } else {
                mNavigationDrawerFragment.openDrawer(Gravity.RIGHT);
            }
            return true;
        }
        */


        listDataHeader = new ArrayList<parent>();

        for (int i = 0; i < name.length; i++) {

            parent nav = new parent(icon[i],name[i]);

            listDataHeader.add(nav);
        }



        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        expListView = (ExpandableListView)findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);



        // setting list adapter
        expListView.setAdapter(listAdapter);

//        setSupportActionBar(mToolbar);
  //      getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);




        // display the first navigation drawer view on app launch
        displayView(0);
    }

    private void clickb(String s , String t) {


        sizex1.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex2.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex3.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex4.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex5.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex6.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex7.setBackgroundResource(R.drawable.sizebutton_selector);
        sizex8.setBackgroundResource(R.drawable.sizebutton_selector);



        if(t.equalsIgnoreCase("1")) {

            sizex1.setBackgroundResource(R.drawable.sizebutton_selector1);
        }
        else if(t.equalsIgnoreCase("2")){

            sizex2.setBackgroundResource(R.drawable.sizebutton_selector1);
        }

        else if(t.equalsIgnoreCase("3")){

            sizex3.setBackgroundResource(R.drawable.sizebutton_selector1);

        }
        else if(t.equalsIgnoreCase("4")){

            sizex4.setBackgroundResource(R.drawable.sizebutton_selector1);

        }
        else if(t.equalsIgnoreCase("5")){

            sizex5.setBackgroundResource(R.drawable.sizebutton_selector1);

        }
        else if(t.equalsIgnoreCase("6")){

            sizex6.setBackgroundResource(R.drawable.sizebutton_selector1);

        }
        else if(t.equalsIgnoreCase("7")){

            sizex7.setBackgroundResource(R.drawable.sizebutton_selector1);

        }else if(t.equalsIgnoreCase("8")){

            sizex8.setBackgroundResource(R.drawable.sizebutton_selector1);

        }
        Toast.makeText(getBaseContext(), "You have selected Size : " + s,
                Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
         /*if (id == R.id.action_settings) {
             return true;
         }*/

        if(id == R.id.action_search){
            ///  Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            //  right_drawer.(Gravity.RIGHT);
            mDrawerLayout.openDrawer(right_drawer);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar2 title
//            getSupportActionBar().setTitle(title);
        }
    }


    private void prepareListData() {
        //   listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> breakfast = new ArrayList<String>();
        breakfast.add("cloth1");
        breakfast.add("cloth2");
        breakfast.add("cloth3");


        List<String> lunch = new ArrayList<String>();
        lunch.add("shoes1");
        lunch.add("shoes2");
        lunch.add("shoes3");
        lunch.add("shoes4");


        List<String> brunch = new ArrayList<String>();
        brunch.add("sports1");
        brunch.add("sports2");


        List<String> dinner = new ArrayList<String>();
        dinner.add("bag1");
        dinner.add("bag2");
        dinner.add("bag3");





       /* List<String> drink = new ArrayList<String>();
        drink.add("Pepsi");
        drink.add("Cocacola");
        drink.add("Thumpsup");

        List<String> desert = new ArrayList<String>();
        desert.add("Vannila");
        desert.add("Black forest");
*/




        listDataChild.put(listDataHeader.get(0).getName(), breakfast); // Header, Child data
        listDataChild.put(listDataHeader.get(1).getName(), lunch);
        listDataChild.put(listDataHeader.get(2).getName(), brunch);
        listDataChild.put(listDataHeader.get(3).getName(), dinner);


    }




}