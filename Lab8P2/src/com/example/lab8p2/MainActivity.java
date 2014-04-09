package com.example.lab8p2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

	private IMG mIMG;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mIMG = new IMG(this);
	
	}

	//The View passed into the method is a reference to the widget that was clicked.
	public void ZoomIn(View view) {
		mIMG.ZoomIn(view);
	}

	public void ZoomOut(View view) {
		mIMG.ZoomOut(view);
	}

	public void Change(View view) {
		mIMG.Change(view);
	}

	public void Rotate(View view) {
		mIMG.Rotate(view);
	}

}

