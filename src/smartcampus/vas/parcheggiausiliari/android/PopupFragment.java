package smartcampus.vas.parcheggiausiliari.android;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PopupFragment extends DialogFragment {

	private String message;
	private String title;

	static PopupFragment newInstance(String title, String message) {
		PopupFragment f = new PopupFragment();
		// Supply num input as an argument.
		Bundle args = new Bundle();
		args.putString("Message", message);
		args.putString("Title", title);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		message = getArguments().getString("Message");
		title = getArguments().getString("Title");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.popup_street, container, false);
		TextView tv = (TextView) v.findViewById(R.id.txtMessage);
		tv.setText(message);
		Button btnStorico = (Button) v.findViewById(R.id.btnStorico);
		btnStorico.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.wtf("TAG", "Pressed");
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.setCustomAnimations(R.anim.enter, R.anim.exit);
				/*Fragment a;
				if ((a = getFragmentManager().findFragmentByTag(
						getString(R.string.storico_fragment))) != null)
					ft.remove(a);*/
				ft.replace(R.id.container, new StoricoFragment(),
						getString(R.string.storico_fragment))
						.addToBackStack(null).commit();
				dismiss();
			}
		});
		getDialog().setTitle(title);
		return v;
	}
}
