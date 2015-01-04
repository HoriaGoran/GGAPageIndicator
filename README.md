GGAPageIndicator
================

PageIndicator Library for Android (used with ViewPager or other similar piece of UI).
Can be used with Android 2.2 and above.

Setup
==============
- reference the GGAPageIndicator library in your project propreties.
- create the layout with a RelativeLayout as the parent layout for the ViewPager (this is a must!)
```
<RelativeLayout
	android:id="@+id/viewpager_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

	    <android.support.v4.view.ViewPager
	        android:id="@+id/viewpager_id"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent"
	        android:background="#FFFFFF" />
	        
</RelativeLayout>
```
- setup the ViewPager and the GGAPageIndicator:
```
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
```

![GGAColorPicker1](https://raw.githubusercontent.com/HoriaGoran/GGAPageIndicator/master/GGAPageIndicatorTest/assets/image.png)
