package smartcampus.vas.parcheggiausiliari.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Fragment_prova extends Fragment {

	public Fragment_prova() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
    	View rootView = inflater.inflate(R.layout.fragment_prova, container, false);
    
    	WebView wv = (WebView)rootView.findViewById(R.id.webView1);
    	wv.loadUrl("https://accounts.google.com/ServiceLogin");
    	return rootView;
        
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    }
}
