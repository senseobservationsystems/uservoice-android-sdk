package com.uservoice.uservoicesdk.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.uservoice.uservoicesdk.R;
import com.uservoice.uservoicesdk.ui.MixedSearchAdapter;

public class BaseActivity extends ActionBarActivity {

	protected ActionBar.Tab allTab;
	protected ActionBar.Tab articlesTab;
	protected ActionBar.Tab ideasTab;
	protected MixedSearchAdapter searchAdapter;
	protected ActionBar actionBar;
	protected static TextView textTitle;
	protected static TextView back;

	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		super.onCreate(savedInstanceState);
		if (hasActionBar()) {
			ActionBar bar = getSupportActionBar();
			bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white30)));
			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			bar.setCustomView(R.layout.uv_action_bar);

			textTitle = (TextView) findViewById(R.id.title);

			back = (TextView) findViewById(R.id.back);
			back.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					onBackPressed();
				}
			});
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("NewApi")
	public boolean hasActionBar() {
		return getSupportActionBar() != null;
	}
}
