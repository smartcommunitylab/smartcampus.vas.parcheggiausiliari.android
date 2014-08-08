package smartcampus.vas.parcheggiausiliari.android.activity;

import java.util.ArrayList;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.bonuspack.overlays.Polyline;
import org.osmdroid.util.GeoPoint;

import android.content.Context;
import android.util.Log;

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
				toRtn = toRtn || (linePointDist(a, b, point, true)<= 0.0005);

		}
		return toRtn;
	}

	
	
	double dot(IGeoPoint A, IGeoPoint B, IGeoPoint C){
		 	double[] AB = new double[2];
		 	double[] BC = new double[2];
	        AB[0] = B.getLongitude()-A.getLongitude();
	        AB[1] = B.getLatitude()-A.getLatitude();
	        BC[0] = C.getLongitude()-B.getLongitude();
	        BC[1] = C.getLatitude()-B.getLatitude();
	        double dot = AB[0] * BC[0] + AB[1] * BC[1];
	        return dot;
	    }
	    //Compute the cross product AB x AC
	double cross(IGeoPoint A, IGeoPoint B, IGeoPoint C){
	    	double[] AB = new double[2];
	    	double[] AC = new double[2];
	        AB[0] = B.getLongitude()-A.getLongitude();
	        AB[1] = B.getLatitude()-A.getLatitude();
	        AC[0] = C.getLongitude()-A.getLongitude();
	        AC[1] = C.getLatitude()-A.getLatitude();
	        double cross = AB[0] * AC[1] - AB[1] * AC[0];
	        return cross;
	    }
	    //Compute the distance from A to B
	    double distance(IGeoPoint A, IGeoPoint B){
	    	double d1 = A.getLongitude() - B.getLongitude();
	    	double d2 = A.getLatitude() - B.getLatitude();
	        return Math.sqrt(d1*d1+d2*d2);
	    }
	    //Compute the distance from AB to C
	    //if isSegment is true, AB is a segment, not a line.
	    double linePointDist(IGeoPoint A, IGeoPoint B, IGeoPoint C, boolean isSegment){
	    		double dist = cross(A,B,C) / distance(A,B);
	        	if(isSegment){
	        	double dot1 = dot(A,B,C);
	            if(dot1 > 0)return distance(B,C);
	            double dot2 = dot(B,A,C);
	            if(dot2 > 0)return distance(A,C);
	        }
	        return Math.abs(dist);
	    }
}
