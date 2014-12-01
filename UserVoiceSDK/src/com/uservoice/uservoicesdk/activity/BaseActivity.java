package com.uservoice.uservoicesdk.activity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
	protected static Button back;
	public static Typeface fReg;

	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (hasActionBar()) {
			ActionBar bar = getSupportActionBar();
			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			bar.setCustomView(R.layout.uv_action_bar);

			textTitle = (TextView) findViewById(R.id.title);

			back = (Button) findViewById(R.id.back);
			back.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					onBackPressed();
				}
			});

			fReg = Typeface.createFromAsset(getAssets(), "CALIBRIL.ttf");
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
