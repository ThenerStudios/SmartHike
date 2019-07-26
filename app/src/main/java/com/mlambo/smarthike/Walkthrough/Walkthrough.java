package com.mlambo.smarthike.Walkthrough;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mlambo.smarthike.Adapters.SliderAdapter;
import com.mlambo.smarthike.Authentication.PhoneAuth;
import com.mlambo.smarthike.R;

public class Walkthrough extends AppCompatActivity {

    private ViewPager msliderviewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private Button mPrev;
    private Button mNext;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        msliderviewPager = findViewById(R.id.slider_layout);
        mDotLayout = findViewById(R.id.dot_layout);

        mPrev = findViewById(R.id.back);
        mPrev.setVisibility(View.INVISIBLE);
        mNext = findViewById(R.id.next);

        SliderAdapter sliderAdapter = new SliderAdapter(this);
        msliderviewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        msliderviewPager.addOnPageChangeListener(pageChangeListener);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msliderviewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msliderviewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

    }
    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.line));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.text));
        }

    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0)
            {
                mNext.setEnabled(true);
                mPrev.setEnabled(false);
                mPrev.setVisibility(View.INVISIBLE);

                mNext.setText("Next");
                mPrev.setText("");

            }else if (i == mDots.length - 1) {

                mNext.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);

                mNext.setText("Sign In");
                mPrev.setText("Back");


                mNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Walkthrough.this, PhoneAuth.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }else {

                mNext.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);

                mNext.setText("Next");
                mPrev.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
