package com.example.ikemura.listfragmentoverscrolltest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ikemurakazutaka on 15/02/23.
 */
public class MainFragment extends Fragment {

	public interface OnButtonClickListener {
		public void onClicked(String str);
	}

	private OnButtonClickListener mOnButtonClickListener;

	public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
		mOnButtonClickListener = onButtonClickListener;
	}

	public MainFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof OnButtonClickListener == false) {
			throw new ClassCastException("activityがOnButtonClickListenerを実装していません。");
		}
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		Button button = (Button) rootView.findViewById(R.id.fragment_main_button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mOnButtonClickListener != null) {
					mOnButtonClickListener.onClicked(getClass().getName());
				}
			}
		});

		return rootView;
	}
}
