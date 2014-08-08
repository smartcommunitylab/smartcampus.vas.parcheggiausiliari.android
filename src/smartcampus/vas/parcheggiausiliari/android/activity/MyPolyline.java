package smartcampus.vas.parcheggiausiliari.android.activity;

import java.util.ArrayList;
import java.util.List;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.bonuspack.overlays.Polyline;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MyPolyline extends Polyline {

	public MyPolyline(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public MyPolyline(ResourceProxy resourceProxy) {
		super(resourceProxy);
		// TODO Auto-generated constructor stub
	}

	public boolean isOnLine(IGeoPoint point) {
		boolean toRtn = false;
		ArrayList<GeoPoint> points = (ArrayList<GeoPoint>) getPoints();
		for (int i = 0; i < getNumberOfPoints() - 1; i++) {
			GeoPoint a = points.get(i);
			GeoPoint b = points.get(i + 1);
			toRtn = toRtn || (linePointDist(a, b, point, true) <= 0.0005);
		}
		return toRtn;
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e, MapView mapView) {
		// TODO Auto-generated method stub
		if (isOnLine(mapView.getProjection().fromPixels((int) e.getX(),
				(int) e.getX())))
			// Log.d("DEBUG", "Path Pressed");
			Toast.makeText(mapView.getContext(), "PATH PRESSED",
					Toast.LENGTH_SHORT).show();
		return super.onLongPress(e, mapView);
	}

	private double dot(IGeoPoint A, IGeoPoint B, IGeoPoint C) {
		double[] AB = new double[2];
		double[] BC = new double[2];
		AB[0] = B.getLongitude() - A.getLongitude();
		AB[1] = B.getLatitude() - A.getLatitude();
		BC[0] = C.getLongitude() - B.getLongitude();
		BC[1] = C.getLatitude() - B.getLatitude();
		double dot = AB[0] * BC[0] + AB[1] * BC[1];
		return dot;
	}

	// Compute the cross product AB x AC
	private double cross(IGeoPoint A, IGeoPoint B, IGeoPoint C) {
		double[] AB = new double[2];
		double[] AC = new double[2];
		AB[0] = B.getLongitude() - A.getLongitude();
		AB[1] = B.getLatitude() - A.getLatitude();
		AC[0] = C.getLongitude() - A.getLongitude();
		AC[1] = C.getLatitude() - A.getLatitude();
		double cross = AB[0] * AC[1] - AB[1] * AC[0];
		return cross;
	}

	// Compute the distance from A to B
	private double distance(IGeoPoint A, IGeoPoint B) {
		double d1 = A.getLongitude() - B.getLongitude();
		double d2 = A.getLatitude() - B.getLatitude();
		return Math.sqrt(d1 * d1 + d2 * d2);
	}

	// Compute the distance from AB to C
	// if isSegment is true, AB is a segment, not a line.
	private double linePointDist(IGeoPoint A, IGeoPoint B, IGeoPoint C,
			boolean isSegment) {
		double dist = cross(A, B, C) / distance(A, B);
		if (isSegment) {
			double dot1 = dot(A, B, C);
			if (dot1 > 0)
				return distance(B, C);
			double dot2 = dot(B, A, C);
			if (dot2 > 0)
				return distance(A, C);
		}
		return Math.abs(dist);
	}

	private static List<GeoPoint> decodePoly(String encoded) {
		List<GeoPoint> poly = new ArrayList<GeoPoint>();

		int index = 0, len = encoded.length();
		int lat = 0, lng = 0;

		while (index < len) {
			int b, shift = 0, result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lat += dlat;

			shift = 0;
			result = 0;
			if (index >= len) {
				break;
			}
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lng += dlng;

			GeoPoint p = new GeoPoint((int) (((double) lat / 1E5) * 1E6),
					(int) (((double) lng / 1E5) * 1E6));
			poly.add(p);
		}

		return poly;
	}
	
	public static MyPolyline decode(Context ctx, String encoded)
	{
		MyPolyline toRtn = new MyPolyline(ctx);
		toRtn.setPoints(decodePoly(encoded));
		for(GeoPoint p : toRtn.getPoints())
			Log.d("DECODED", ""+p.getLatitude()+"    "+p.getLongitude());
		return toRtn;
	}
	
}
