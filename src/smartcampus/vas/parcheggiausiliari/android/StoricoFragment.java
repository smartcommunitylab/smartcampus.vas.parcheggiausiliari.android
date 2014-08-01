package smartcampus.vas.parcheggiausiliari.android;

import smartcampus.vas.parcheggiausiliari.android.MainActivity.MySimpleArrayAdapter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StoricoFragment extends Fragment {
	ListView lv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_storico, container,
				false);
		lv = (ListView) rootView.findViewById(R.id.listView1);
		return rootView;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(),
				new AusiliariHelper(getActivity()).getStorico());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new onClickEvent());
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	private class onClickEvent implements OnItemClickListener {

		public onClickEvent() {
			// TODO Auto-generated constructor stub
		}

		public void showPopup() {

			/*Fragment a;
			if ((a = getFragmentManager().findFragmentByTag(
					getString(R.string.map_fragment))) != null)
				getFragmentManager().beginTransaction().remove(a);*/
			getFragmentManager()
					.beginTransaction()
					.replace(R.id.container, new MapFragment(),
							getString(R.string.map_fragment))
					.addToBackStack(null).commit();
			DialogFragment df = PopupFragment.newInstance("PROVA", "message");
			df.show(getFragmentManager(), "");
		}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			showPopup();
		}
	}
}
