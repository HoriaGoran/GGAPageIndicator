package com.example.ggapageindicatortest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment
{
	public static final String KEY = "fragment_key";
	private TextView tv;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_layout, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		
		String string = null;
		Bundle b = getArguments();
		if(null != b)
		{
			string = b.getString(KEY);
		}
		
		tv = (TextView) view.findViewById(R.id.text_id);
		tv.setText(string);
	}
}