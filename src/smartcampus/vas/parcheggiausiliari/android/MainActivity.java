package smartcampus.vas.parcheggiausiliari.android;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import eu.trentorise.smartcampus.osm.android.util.GeoPoint;
import eu.trentorise.smartcampus.osm.android.views.MapView;
import eu.trentorise.smartcampus.osm.android.views.overlay.MyLocationOverlay;
import eu.trentorise.smartcampus.osm.android.views.overlay.OverlayItem;

public class MainActivity extends ActionBarActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
	private ArrayList<OverlayItem> pList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mTitle;
	private CharSequence mDrawerTitle;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
                ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setIcon(R.drawable.ic_drawer);
                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("open");
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        String[] strings = {"Mappa","Storico","Logout"};
        mDrawerList.setAdapter(new MySimpleArrayAdapter(getApplicationContext(), strings));
        mDrawerList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Activity2.class);
				startActivity(i);
			}
		});
        mTitle = mDrawerTitle = getTitle();
        
        
        
        MapView map = (MapView) findViewById(R.id.mapview);
        map.setMultiTouchControls(true);
        map.setMinZoomLevel(3);
        MyLocationOverlay myLoc = new MyLocationOverlay(getApplicationContext(), map);
        myLoc.enableCompass();
        map.getOverlays().add(myLoc);
        GPSTracker pos = new GPSTracker(getApplicationContext());
		map.getController().setZoom(18);
		map.getController().animateTo(new GeoPoint(pos.getLatitude(), pos.getLongitude()));
		
	}

	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent e) {
	    if (keyCode == KeyEvent.KEYCODE_MENU) {
	        // your action...

	        if (!mDrawerLayout.isDrawerOpen(mDrawerList)) {
	            mDrawerLayout.openDrawer(mDrawerList);
	        }
	        else
	        	mDrawerLayout.closeDrawer(mDrawerList);
	        return true;
	    }
	    return super.onKeyDown(keyCode, e);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.setGroupVisible(0, false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	
        public PlaceholderFragment(Context mContext) {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            
        	View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
            
        }
    }
    
    public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    	  private final Context context;
    	  private final String[] values;

    	  public MySimpleArrayAdapter(Context context, String[] values) {
    	    super(context, R.layout.rowlayout, values);
    	    this.context = context;
    	    this.values = values;
    	  }

    	  @Override
    	  public View getView(int position, View convertView, ViewGroup parent) {
    	    LayoutInflater inflater = (LayoutInflater) context
    	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
    	    TextView textView = (TextView) rowView.findViewById(R.id.textView1);
    	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
    	    textView.setText(values[position]);

    	    return rowView;
    	  }
    	} 
    
}

