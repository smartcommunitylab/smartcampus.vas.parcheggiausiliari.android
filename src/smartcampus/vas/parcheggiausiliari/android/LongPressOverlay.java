package smartcampus.vas.parcheggiausiliari.android;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Vibrator;
import android.view.MotionEvent;
import eu.trentorise.smartcampus.osm.android.views.MapView;
import eu.trentorise.smartcampus.osm.android.views.overlay.Overlay;

public class LongPressOverlay extends Overlay
{
	long time = 0;
	float x, y;
	final float deltaX = 10;
	final float deltaY = 10;
	public Context mContext;
	public MapView mapView;

	public LongPressOverlay(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stubs
		mContext = ctx;
	}


	@Override
	public boolean onTouchEvent(MotionEvent event, MapView mapView) 
	{   
		this.mapView = mapView;
		//---when user lifts his finger---
		//Log.d("motionEvent", Integer.toString(event.getPointerCount()));
		if (event.getAction() == MotionEvent.ACTION_DOWN && event.getPointerCount() == 1){
			time = System.currentTimeMillis();
			x = event.getX();
			y = event.getY();
		}
		else if(event.getAction() == MotionEvent.ACTION_UP && (System.currentTimeMillis() - time >= 1000)&& event.getPointerCount() == 1)
		{
			if((Math.abs(event.getX() - x) <= deltaX) && (Math.abs(event.getY() - y) <= deltaY))
			{
				Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
			 // Vibrate for 500 milliseconds
			 v.vibrate(300);
				onLongPressGesture(event);
				return true;
			}
			else if(event.getPointerCount() > 1)
				time = System.currentTimeMillis();
			
		}
		return false;
	}

/**
 * What to do when you make a long press on the map.
 * @param mapView
 * @param event
 */
	public void onLongPressGesture(MotionEvent event){
	}

	@Override
	protected void draw(Canvas arg0, MapView arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}
}