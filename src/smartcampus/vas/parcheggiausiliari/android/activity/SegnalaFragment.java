package smartcampus.vas.parcheggiausiliari.android.activity;

import smartcampus.vas.parcheggiausiliari.android.R;
import smartcampus.vas.parcheggiausiliari.android.views.NumberPicker;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SegnalaFragment extends Fragment {

	private NumberPicker n1;
	private NumberPicker n2;
	private NumberPicker n3;
	private NumberPicker n4;

	private int val1;
	private int val2;
	private int val3;
	private int val4;
	private Button btnAnnulla;

	static SegnalaFragment newInstance(int val1, int val2, int val3, int val4) {
		SegnalaFragment f = new SegnalaFragment();
		// Supply num input as an argument.
		Bundle args = new Bundle();
		args.putInt("val1", val1);
		args.putInt("val2", val2);
		args.putInt("val3", val3);
		args.putInt("val4", val4);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		val1 = getArguments().getInt("val1");
		val2 = getArguments().getInt("val2");
		val3 = getArguments().getInt("val3");
		val4 = getArguments().getInt("val4");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_streetdetails,
				container, false);

		n1 = (NumberPicker) rootView.findViewById(R.id.NumberPicker01);
		n2 = (NumberPicker) rootView.findViewById(R.id.NumberPicker02);
		n3 = (NumberPicker) rootView.findViewById(R.id.NumberPicker03);
		n4 = (NumberPicker) rootView.findViewById(R.id.NumberPicker04);

		btnAnnulla = (Button) rootView.findViewById(R.id.btnReset);
		btnAnnulla.setOnClickListener(new MyCLickListener());

		return rootView;

	}

	private class MyCLickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			n1.setCurrent(val1);
			n2.setCurrent(val2);
			n3.setCurrent(val3);
			n4.setCurrent(val4);
		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

}
