package com.marco.www.mymvprxjaveretrofit_master;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.marco.www.mymvprxjaveretrofit_master.ui.ImagesFragment;
import com.marco.www.mymvprxjaveretrofit_master.ui.NewsFragment;
import com.marco.www.mymvprxjaveretrofit_master.util.Constants;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener
{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewpager;
    MainPagerAdapter mMainPagerAdapter;

    @Override
    protected int getLayoutResource()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void initData()
    {
        tabLayout.setTabTextColors(getResources().getColor(R.color.whiteTrans80), getResources().getColor(R.color.white));
        viewpager.setAdapter(mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void initView()
    {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        viewpager = (ViewPager) findViewById(R.id.fragent_content);

        toolbar.setTitle("Marco -- 想要随时给");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_home);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        navView.setCheckedItem(R.id.nav_new);
    }

    public class MainPagerAdapter extends FragmentStatePagerAdapter
    {
        public MainPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    return new NewsFragment();
                default:
                    return new ImagesFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return "段子";
                default:
                    return "图片";
            }
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.nav_new:
                break;
            case R.id.nav_xingan:
                break;
            case R.id.nav_shaonv:
                break;
            case R.id.nav_mr:
                break;
            case R.id.nav_sw:
                break;
            case R.id.nav_xz:
                break;
            case R.id.nav_wallpaper:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_personal:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
