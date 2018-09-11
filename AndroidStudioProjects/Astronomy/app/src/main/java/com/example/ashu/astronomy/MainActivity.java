package com.example.ashu.astronomy;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Communicator{

    String orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new AstronomyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public String handleOnClick() {
        FrameLayout detailLayout = findViewById(R.id.detailFragmentContainer);
        Log.e("DetailLayout", "handleOnClick: "+detailLayout );
        if(detailLayout == null){
            orientation = "Portrait";

        }else {
                  orientation = "Landscape";
            }
            return orientation;

    }

    @Override
    public void startContentFragment(ContentFragment contentFragment) {

        String s1 = handleOnClick();
        Log.e("HandleOnClick", "startContentFragment: "+s1 );
        String s2 = "Landsacpe";
        Log.e("ContentFragment", "startContentFragment: ");

        if(s1.equals(s2)) {
            Log.e("ContentFragment", "startContentFragment: ");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detailFragmentContainer, contentFragment)
                    .commit();

        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.viewPager,contentFragment)
                    .commit();
        }
    }

    class AstronomyPagerAdapter extends FragmentPagerAdapter{

        public AstronomyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0 :return new PlanetFragment();
                case 1 :return new StarFragment();
                case 2 :return new GalaxyFragment();
            }
            return null;
        }


        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "Planet";
                case 1:
                    return "Star";
                case 2:
                    return "Galaxy";
            }
            return "";
        }
    }
}
