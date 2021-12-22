package rob.newweatherrealapp;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends MainActivityHelper {
    private static final String TAG = MainActivity.class.getSimpleName();
    //Initial
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialTabViewPager();

    }



    private void initialTabViewPager() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment as Page of TabLayout. Class and Name of Tab
        viewPagerAdapter.AddFragment(new FragmentLocationWeather(), "Current Location");
        viewPagerAdapter.AddFragment(new FragmentLocationWeather(), "Current Location");
        //Set Adapter
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_near_me);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher_background);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }

}