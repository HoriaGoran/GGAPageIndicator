package com.example.ggapageindicatortest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.gizmogadgetsappz.pageindicator.GGAPageIndicator;

public class MainActivity extends FragmentActivity
{
	private ViewPager viewPager;
	private ViewPagerAdapter adapter;
	private GGAPageIndicator ggaPageIndicator;
	private String [] strings = { "PAGE 1", "PAGE 2", "PAGE 3", "PAGE 4" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.viewpager_id);
		
		adapter = new ViewPagerAdapter(getSupportFragmentManager(), strings);
		viewPager.setAdapter(adapter);
		
		if(adapter.getCount() > 1)
		{
			ggaPageIndicator = new GGAPageIndicator(viewPager, GGAPageIndicator.HORIZONTAL);
			ggaPageIndicator.setCurrentPageColor(Color.GREEN);
			ggaPageIndicator.setOtherPageColor(Color.GRAY);
			ggaPageIndicator.setSize(10);
			ggaPageIndicator.create();
		}
	}

	
	private class ViewPagerAdapter extends FragmentPagerAdapter
	{
		private String [] strings;
		
		public ViewPagerAdapter(FragmentManager fm, String [] strings)
		{
			super(fm);
			this.strings = strings;
		}

		@Override
		public Fragment getItem(int position)
		{
			Bundle b = new Bundle();
			b.putSerializable(ViewPagerFragment.KEY, strings[position]);
			
			ViewPagerFragment f = new ViewPagerFragment();
			f.setArguments(b);
			
			return f;
		}

		@Override
		public int getCount()
		{
			return strings.length;
		}
	}
}