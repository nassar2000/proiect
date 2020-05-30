package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[]dotstv;
    private int[]layouts;
    private Button btnSkip;
    private Button btnNext;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(isFirstTimeStartApp()){

            StartMainActivity();
            finish();
        }



        setStatusBarTransparent();

        setContentView(R.layout.activity_welcome);

        viewPager = findViewById(R.id.viewPagerW);
        linearLayout = findViewById(R.id.linearLayoutW);
        btnNext = findViewById(R.id.buttonNext);
        btnSkip = findViewById(R.id.buttonSkip);



        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMainActivity();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentPage = viewPager.getCurrentItem()+1;
                if(currentPage < layouts.length) {
                    //o mutam la urm activitate
                    viewPager.setCurrentItem(currentPage);
                } else {
                    StartMainActivity();
                }

            }
        });

        layouts = new int[]{R.layout.la1,R.layout.la2,R.layout.la3};
        pagerAdapter = new MyPagerAdapter(layouts ,getApplicationContext());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == layouts.length-1){
                    //ultima pagina
                    btnNext.setText("START");
                    btnSkip.setVisibility(View.GONE);
                }else {
                    btnNext.setText("NEXT");
                    btnSkip.setVisibility(View.VISIBLE);
                }
                setDotStatus(position);
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setDotStatus(0);


    }

    private boolean isFirstTimeStartApp() {
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag", true);
    }

    private void setFirstTimeStartStatus(boolean stt) {
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.commit();
    }



    private void setDotStatus (int page){
        linearLayout.removeAllViews();
        dotstv = new TextView[layouts.length];
        for (int i = 0; i<dotstv.length;i++){
            dotstv[i] = new TextView(this);
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(30);
            dotstv[i].setTextColor(Color.parseColor("#a9b4bb"));
            linearLayout.addView(dotstv[i]);

        }

        if(dotstv.length>0){
            dotstv[page].setTextColor(Color.parseColor("#ffffff"));
        }

    }

    private void StartMainActivity(){

        setFirstTimeStartStatus(false);

        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

    private void setStatusBarTransparent(){

        if (Build.VERSION.SDK_INT>=21){

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);



        }
    }

    }
