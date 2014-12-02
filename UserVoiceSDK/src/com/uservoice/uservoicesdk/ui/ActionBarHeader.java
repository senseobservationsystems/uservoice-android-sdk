package com.uservoice.uservoicesdk.ui;

import com.uservoice.uservoicesdk.R;
import com.uservoice.uservoicesdk.activity.BaseActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActionBarHeader extends RelativeLayout {
	public ActionBarHeader(Context context) {
		super(context);
		init(context);
	}

	public ActionBarHeader(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ActionBarHeader(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.uv_action_bar_view, this, true);
		
		final BaseActivity activity = ((BaseActivity) context);
		
		TextView back = (TextView) findViewById(R.id.top_bar_back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.onBackPressed();
			}
		});
	}
}
