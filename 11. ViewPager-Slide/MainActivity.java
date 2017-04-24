package com.matchslide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.matchslide.fragment.MatchListFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int NUM_PAGES = 10000;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private TextView tvleft, tvRight, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvleft = (TextView) findViewById(R.id.content_main_tv_left_arrow);
        tvRight = (TextView) findViewById(R.id.content_main_tv_right_arrow);

        tvDate = (TextView) findViewById(R.id.content_main_tv_date);

        tvleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.arrowScroll(View.FOCUS_LEFT);
            }
        });

        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.arrowScroll(View.FOCUS_RIGHT);
            }
        });

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.content_main_viewpager);
        mPager.post(new Runnable() {
            public void run() {
                mPager.setCurrentItem(5000, false);
            }
        });
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(0);

//        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
////                NUM_PAGES++;
////                mPagerAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        Calendar calendar = Calendar.getInstance();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        tvDate.setText(sdf.format(calendar.getTime()));
//
//        Log.d("date", "set");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Calendar calendar = Calendar.getInstance();

            Log.d("position", "" + mPager.getCurrentItem());

            calendar.add(Calendar.DATE, (mPager.getCurrentItem() - 5000));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            tvDate.setText(sdf.format(calendar.getTime()));

            MatchListFragment screenSlidePageFragment = new MatchListFragment();

            return screenSlidePageFragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return FragmentStatePagerAdapter.POSITION_NONE;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
