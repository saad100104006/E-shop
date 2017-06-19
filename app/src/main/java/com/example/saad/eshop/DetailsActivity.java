package com.example.saad.eshop;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends ActionBarActivity {


    TextView tv1,tv2,tv3,tv4;


    ImageView imagemain,imagev1,imagev2,imagev3,imagev4;

    private Toolbar toolbar;




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        nitView();
        if (toolbar != null) {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
        }






        imagemain =(ImageView)findViewById(R.id.imagemain);

        imagemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onOpenDialog(v);


            }
        });




        imagev1 =(ImageView)findViewById(R.id.imagev1);
        imagev2 =(ImageView)findViewById(R.id.imagev2);
        imagev3 =(ImageView)findViewById(R.id.imagev3);
        imagev4 =(ImageView)findViewById(R.id.imagev4);

        imagev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagemain.setImageResource(R.drawable.side);

            }
        });

        imagev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagemain.setImageResource(R.drawable.back);

            }
        });

        imagev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagemain.setImageResource(R.drawable.frient);

            }
        });

        imagev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagemain.setImageResource(R.drawable.cloth);

            }
        });





        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);






        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setview("1");
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setview("2");
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setview("3");
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setview("4");
            }
        });





    }

    private void nitView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);


    }

    public void setview(String t) {


        tv1.setBackgroundResource(R.drawable.text_round1);
        tv2.setBackgroundResource(R.drawable.text_round1);
        tv3.setBackgroundResource(R.drawable.text_round1);
        tv4.setBackgroundResource(R.drawable.text_round1);
        tv1.setTextColor(getResources().getColor(R.color.pro_cart_textcolor));
        tv2.setTextColor(getResources().getColor(R.color.pro_cart_textcolor));
        tv3.setTextColor(getResources().getColor(R.color.pro_cart_textcolor));
        tv4.setTextColor(getResources().getColor(R.color.pro_cart_textcolor));


        if(t.equalsIgnoreCase("1")) {

            tv1.setBackgroundResource(R.drawable.text_round);
            tv1.setTextColor(getResources().getColor(R.color.colorWhite));


        }
        else if(t.equalsIgnoreCase("2")){

            tv2.setBackgroundResource(R.drawable.text_round);
            tv2.setTextColor(getResources().getColor(R.color.colorWhite));
        }

        else if(t.equalsIgnoreCase("3")){

            tv3.setBackgroundResource(R.drawable.text_round);
            tv3.setTextColor(getResources().getColor(R.color.colorWhite));

        }
        else if(t.equalsIgnoreCase("4")){

            tv4.setBackgroundResource(R.drawable.text_round);
            tv4.setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }


    public void onOpenDialog(View v)
    {
        FragmentManager fm = getSupportFragmentManager();
        DialogActivity overlay = new DialogActivity();
        overlay.show(fm, "FragmentDialog");
    }

}
