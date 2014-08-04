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

public class Fragment_prova extends Fragment {
	private PagerSlidingTabStrip tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
    	View rootView = inflater.inflate(R.layout.fragment_prova, container, false);
    	ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);
    	tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
    	pager.setAdapter(new MyPagerAdapter(getFragmentManager()));
    	// Bind the tabs to the ViewPager
    	tabs.setViewPager(pager);
    	return rootView;
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    }
    
    public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Segnala", "Storico"};

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			
			if(getCount()<= 3)
				tabs.setShouldExpand(true);
			
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			if(position == 0)
				return new StoricoFragment();
			else
				return new ParkListFragment();
		}

	}
}
