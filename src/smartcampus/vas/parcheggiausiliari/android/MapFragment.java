package smartcampus.vas.parcheggiausiliari.android;

import java.util.ArrayList;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.MyLocationOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import android.graphics.Color;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MapFragment extends Fragment {

	private MapView map;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_map, container,
				false);
		Button btnParkings = (Button) rootView.findViewById(R.id.btnParking);
		btnParkings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.setCustomAnimations(R.anim.enter, R.anim.exit);
				Fragment a;
				if ((a = getFragmentManager().findFragmentByTag(
						getString(R.string.parklist_fragment))) != null)
					ft.remove(a);
				ft.replace(R.id.container, new ParkListFragment(),
						getString(R.string.parklist_fragment))
						.addToBackStack(null)
						// Start the animated transition.
						.commit();
			}
		});

		Button btnStreets = (Button) rootView.findViewById(R.id.btnVie);
		btnStreets.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.setCustomAnimations(R.anim.enter, R.anim.exit);
				Fragment a;
				if ((a = getFragmentManager().findFragmentByTag(
						getString(R.string.streetlist_fragment))) != null)
					ft.remove(a);
				ft.replace(R.id.container, new StreetListFragment(),
						getString(R.string.streetlist_fragment))
						.addToBackStack(null)// Start the animated transition.
						.commit();
			}
		});

		map = (MapView) rootView.findViewById(R.id.mapview);
		map.setMultiTouchControls(true);
		map.setMinZoomLevel(3);
		MyLocationOverlay myLoc = new MyLocationOverlay(getActivity(), map);
		myLoc.enableCompass();
		map.getOverlays().add(myLoc);
		GPSTracker pos = new GPSTracker(getActivity());
		map.getController().setZoom(18);
		center(new GeoPoint(pos.getLatitude(), pos.getLongitude()));
		// map.addMarkerOnLongClick();
		map.getOverlays().add(new LongPressOverlay(getActivity()) {
			@Override
			public void onLongPressGesture(MotionEvent event) {
				Log.e("", "ASDF");
				IGeoPoint point = map.getProjection().fromPixels(event.getX(),
						event.getY());
				showPopup(map,/* "Lat: " + (point.getLatitudeE6() / 10E5)
						+ " ,  Lon: " + (point.getLongitudeE6() / 10E5));*/
						OSMGeocoding.FromPointToAddress(new GeoPoint(point.getLatitudeE6(),point.getLongitudeE6()),getActivity()).get(0).getAddressLine(0));
			}
		});
		map.invalidate();
		
		MyPathOverlay p = new MyPathOverlay(Color.argb(128, 128, 0, 128),
				getActivity());
		p.getPaint().setStyle(Style.FILL);
		for (GeoPoint pt : AusiliariHelper.Parks()) {
			p.addPoint(pt);
		}
		map.getOverlays().add(p);
		
		
		ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
		for (GeoPoint pt : AusiliariHelper.Parks()) {
			OverlayItem item = new OverlayItem("PARK1", "Description", pt );
			item.setMarker(getResources().getDrawable(R.drawable.marker_poi_generic));
			items.add(item);
		}
		
//		map.addMarkers(items , new OnItemGestureListener<OverlayItem>() {
//			
//			@Override
//			public boolean onItemLongPress(int arg0, OverlayItem arg1) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public boolean onItemSingleTapUp(int arg0, OverlayItem arg1) {
//				showPopup(map, arg1.getTitle());
//				return true;
//			}
//		});
		map.getOverlays().add(new ItemizedOverlayWithFocus<OverlayItem>(items , new OnItemGestureListener<OverlayItem>() {
			
			@Override
			public boolean onItemLongPress(int arg0, OverlayItem arg1) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onItemSingleTapUp(int arg0, OverlayItem arg1) {
				showPopup(map, arg1.getTitle());
				return true;
			}
		},map.getResourceProxy()));
		
		return rootView;
	}

	public void showPopup(View anchorView, String text) {
		DialogFragment df = PopupFragment.newInstance("Parcheggio Zuffo", text);
		df.show(getFragmentManager(), getTag());
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	public void center(GeoPoint geopoint) {
		map.getController().animateTo(geopoint);
	}
}
