package smartcampus.vas.parcheggiausiliari.android.activity;

import smartcampus.vas.parcheggiausiliari.android.R;
import smartcampus.vas.parcheggiausiliari.android.views.PagerSlidingTabStrip;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SegnalaFragment extends Fragment {
	private PagerSlidingTabStrip tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
    	View rootView = inflater.inflate(R.layout.fragment_segnala, container, false);
    	
    	return rootView;
        
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    }
    
}
