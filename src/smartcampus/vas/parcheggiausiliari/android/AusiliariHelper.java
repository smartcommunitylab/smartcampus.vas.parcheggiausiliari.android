package smartcampus.vas.parcheggiausiliari.android;


import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.osmdroid.util.GeoPoint;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class AusiliariHelper {
	private static Context mContext;
	private static AusiliariHelper helper;


	public AusiliariHelper(Context ctx) {
		this.mContext = ctx;
	}
	public static boolean isInstantiated() {
		return (helper != null);
	}
	
	public static ArrayList<GeoPoint> Parks() {
		ArrayList<GeoPoint> toRtn = new ArrayList<GeoPoint>();
		toRtn.add(new GeoPoint(46.068654, 11.150679));
		toRtn.add(new GeoPoint(46.069968, 11.150350));
		toRtn.add(new GeoPoint(46.070765, 11.150815));
		toRtn.add(new GeoPoint(46.070502, 11.151732));
		toRtn.add(new GeoPoint(46.069911, 11.151480));
		toRtn.add(new GeoPoint(	46.069386, 11.151389));
		toRtn.add(new GeoPoint(	46.068686, 11.150823));
		return toRtn;
	}
	
	
	public static ArrayList<String> getStorico(){
		ArrayList<String> toRtn = new ArrayList<String>();
		try {
			GetStoricoTask ast = (GetStoricoTask) new GetStoricoTask();
			ast.execute();
			toRtn = ast.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toRtn;
	}
	private static class GetStoricoTask extends AsyncTask<Void, Void, ArrayList<String>>{
		ProgressDialog pd;
		
		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			ArrayList<String> array= new ArrayList<String>();
			for (int i = 0; i < 10 ; i++) {
				array.add(i+ " alle: "+ new Date(System.currentTimeMillis()));
			}
			return array;
	
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd = new ProgressDialog(mContext);
			pd.setTitle("Downloading Data");
			pd.show();
		}
		@Override
		protected void onPostExecute(ArrayList<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(pd.isShowing())
				pd.dismiss();
		}
	}
	
	

}