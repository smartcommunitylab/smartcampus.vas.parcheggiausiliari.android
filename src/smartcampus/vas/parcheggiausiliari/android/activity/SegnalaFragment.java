package smartcampus.vas.parcheggiausiliari.android.activity;

import smartcampus.vas.parcheggiausiliari.android.R;
import smartcampus.vas.parcheggiausiliari.android.model.BaseDT;
import smartcampus.vas.parcheggiausiliari.android.model.Parking;
import smartcampus.vas.parcheggiausiliari.android.model.Street;
import smartcampus.vas.parcheggiausiliari.android.views.NumberPicker;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SegnalaFragment extends Fragment {

	private static final String MY_PREFERENCES = "Ausiliari";
	private NumberPicker pickerFree;
	private NumberPicker pickerWork;
	private NumberPicker pickerPayment;
	private NumberPicker pickerTimed;

	private int val1;
	private int val2;
	private int val3;
	private int val4;
	private Button btnAnnulla;
	private BaseDT obj;
	private TextView txt;
	private Button btnSend;
	private TextView txtFree;
	private TextView txtPayment;
	private TextView txtTimed;

	public SegnalaFragment(BaseDT obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	static SegnalaFragment newInstance(BaseDT obj, int val1, int val2,
			int val3, int val4) {
		SegnalaFragment f = new SegnalaFragment(obj);
		Bundle args = new Bundle();
		args.putInt("val1", val1);
		args.putInt("val2", val2);
		args.putInt("val3", val3);
		args.putInt("val4", val4);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_details, container,
				false);
		txt = (TextView) rootView.findViewById(R.id.txtTitle);
		txt.setText(obj.getName());
		pickerFree = (NumberPicker) rootView.findViewById(R.id.NumberPicker01);
		pickerWork = (NumberPicker) rootView.findViewById(R.id.NumberPicker04);
		LinearLayout btnsStreet = (LinearLayout) rootView
				.findViewById(R.id.streetBtns);
		if (Parking.class.isInstance(obj)) {
			btnsStreet.setVisibility(View.GONE);

		}
		pickerPayment = (NumberPicker) rootView
				.findViewById(R.id.NumberPicker02);
		pickerTimed = (NumberPicker) rootView.findViewById(R.id.NumberPicker03);
		btnAnnulla = (Button) rootView.findViewById(R.id.btnReset);
		btnAnnulla.setOnClickListener(new MyCLickListener());

		txtFree = (TextView) rootView.findViewById(R.id.txtMaxFree);
		txtPayment = (TextView) rootView.findViewById(R.id.txtMaxPayment);
		txtTimed = (TextView) rootView.findViewById(R.id.txtMaxTimed);
		int a = 0;
		if (Parking.class.isInstance(obj)) {
			txtFree.setText("/" + ((Parking) obj).getSlotsTotal());
			pickerFree.setRange(0, ((Parking) obj).getSlotsTotal());
			a += ((Parking) obj).getSlotsTotal();
		} else {
			a += ((Street) obj).getSlotsFree()
					+ ((Street) obj).getSlotsPaying()
					+ ((Street) obj).getSlotsTimed();
			txtFree.setText("/" + ((Street) obj).getSlotsFree());
			pickerFree.setRange(0, ((Street) obj).getSlotsFree());
			txtPayment.setText("/" + ((Street) obj).getSlotsPaying());
			pickerPayment.setRange(0, ((Street) obj).getSlotsPaying());
			txtTimed.setText("/" + ((Street) obj).getSlotsTimed());
			pickerTimed.setRange(0, ((Street) obj).getSlotsTimed());
		}

		// TODO ??????????????????
		pickerWork.setRange(0, a);

		btnSend = (Button) rootView.findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		return rootView;

	}

	private class MyCLickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pickerFree.setCurrent(val1);
			pickerWork.setCurrent(val2);
			pickerPayment.setCurrent(val3);
			pickerTimed.setCurrent(val4);

			SharedPreferences prefs = getActivity().getSharedPreferences(
					MY_PREFERENCES, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.remove(obj.getId()).commit();
		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		SharedPreferences prefs = getActivity().getSharedPreferences(
				MY_PREFERENCES, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		if (Parking.class.isInstance(obj))
			editor.putString(
					obj.getId(),
					"" + pickerFree.getCurrent() + " "
							+ pickerWork.getCurrent() + " "
							+ pickerPayment.getCurrent() + " "
							+ pickerTimed.getCurrent());
		else
			editor.putString(obj.getId(), "" + pickerFree.getCurrent() + " "
					+ pickerWork.getCurrent());
		editor.commit();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences prefs = getActivity().getSharedPreferences(
				MY_PREFERENCES, Context.MODE_PRIVATE);
		String load = prefs.getString(obj.getId(), null);
		if (load != null) {
			Log.e("LOAD", load);
			String[] splitted = load.split(" ");
			pickerFree.setCurrent(Integer.parseInt(splitted[0]));
			pickerWork.setCurrent(Integer.parseInt(splitted[1]));
			if (splitted.length > 4) {
				pickerPayment.setCurrent(Integer.parseInt(splitted[2]));
				pickerTimed.setCurrent(Integer.parseInt(splitted[3]));
			}
		} else {

			val1 = getArguments().getInt("val1");
			val2 = getArguments().getInt("val2");
			val3 = getArguments().getInt("val3");
			val4 = getArguments().getInt("val4");
		}

	}
}
