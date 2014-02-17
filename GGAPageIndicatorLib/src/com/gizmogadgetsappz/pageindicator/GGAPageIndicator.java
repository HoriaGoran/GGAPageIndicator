package com.gizmogadgetsappz.pageindicator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GGAPageIndicator
{
	public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
	public static final int VERTICAL = LinearLayout.VERTICAL;
	private Context context;
	private int count;
	private int color_current;
	private int color_other;
	private int radius;
	private int current_item;
	private LinearLayout layout;
	private RelativeLayout parent;
	
	public GGAPageIndicator(ViewPager viewpager, int orientation)
	{
		if(null == viewpager)
		{
			throw new NullPointerException("GGAPageIndicator - viewpager was null");
		}
		
		try
		{
			parent = (RelativeLayout) viewpager.getParent();
		}
		catch(Exception e)
		{
			throw new ClassCastException("GGAPageIndicator - the viewpager's parent must be RelativeLayout");
		}
		
		if(orientation != HORIZONTAL && orientation != VERTICAL)
		{
			throw new IllegalArgumentException("GGAPageIndicator - orientation has to be either HORIZONTAL or VERTICAL");
		}
		
		context = viewpager.getContext();
		count = viewpager.getAdapter().getCount();
		current_item = viewpager.getCurrentItem();
		
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.bottomMargin = 5;
		
		layout = new LinearLayout(context);
		layout.setOrientation(orientation);
		layout.setLayoutParams(params);
		layout.setGravity(Gravity.CENTER);

		viewpager.setOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int position)
			{
				for(int i = 0; i < layout.getChildCount(); i ++)
				{
					View view = layout.getChildAt(i);
					if(i == position)
					{
						view.setBackgroundDrawable(newGradient(color_current));
					}
					else
					{
						view.setBackgroundDrawable(newGradient(color_other));
					}
				}
			}
			
			@Override
			public void onPageScrolled(int position, float offset, int offsetPixels)
			{
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state)
			{
				
			}
		});
	}
	
	
	public void setCurrentPageColor(int color)
	{
		color_current = color;
	}
	
	public void setOtherPageColor(int color)
	{
		color_other = color;
	}
	
	public void setSize(int size)
	{
		radius = size;
	}
	
	
	public void create()
	{
		for(int i = 0; i < count; i++)
		{
			GradientDrawable gd = null;
			
			if(i == current_item)
			{
				gd = newGradient(color_current);
			}
			else
			{
				gd = newGradient(color_other);
			}
			
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(radius, radius);
			params.leftMargin = 2;
			params.rightMargin = 2;
			params.topMargin = 2;
			params.bottomMargin = 2;
			
			View view = new View(context);
			view.setLayoutParams(params);
			view.setBackgroundDrawable(gd);
			
			layout.addView(view);
		}
		
		parent.addView(layout);
		parent.bringChildToFront(layout);
	}
	
	
	private GradientDrawable newGradient(int color)
	{
		GradientDrawable gd = new GradientDrawable();
		gd.setShape(GradientDrawable.RADIAL_GRADIENT);
		gd.setColor(color);
		
		return gd;
	}
}