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
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IMG{
	//Private member of this class. Class is like a more powerful struct in C, you can have member variables
		// and member methods
		private Bitmap mBitMap;
		private TextView mTextView;
		private ImageView mImage;
		private int mImgWidth, mImgHeight;
		private float mAngle = 90.0f;
		private int mIndex = 0;
		private int[] mImgs = new int[3]; // We have three images for you to play with
		private MainActivity parent;


	
		public IMG(MainActivity parent)
		{
			
			this.parent = parent;
			mImgs[0] = R.drawable.cat1;
			mImgs[1] = R.drawable.cat2;
			mImgs[2] = R.drawable.cat3;
			
			mImage = (ImageView) parent.findViewById(R.id.imageView1);
			mTextView = (TextView) parent.findViewById(R.id.textView1);
			mBitMap = BitmapFactory.decodeResource(parent.getResources(), mImgs[mIndex]);
			mImage.setImageResource(mImgs[mIndex]);  // Easiest way to show a image
			updateSize();
			
		}
		// The View passed into the method is a reference to the widget that was clicked.
		public void ZoomIn(View view) {
			mImgHeight += 50;
			mImgWidth += 50;
			mBitMap = Bitmap.createScaledBitmap(mBitMap, mImgWidth, mImgHeight, true);
			mImage.setImageBitmap(mBitMap);
			updateSize();
		}

		public void ZoomOut(View view) {
			mImgHeight -= 50;
			mImgWidth -= 50;
			// If overflow, we keep the size unchanged
			if (mImgHeight < 0 || mImgWidth < 0) {
				mImgHeight += 50;
				mImgWidth += 50;
			}     
			mBitMap = Bitmap.createScaledBitmap(mBitMap, mImgWidth, mImgHeight, true);
			mImage.setImageBitmap(mBitMap);
			updateSize();
		}

		public void Change(View view) {
			mIndex++;
			if (mIndex == 3) { mIndex = 0; }  // Overflow
			mBitMap = BitmapFactory.decodeResource(parent.getResources(), mImgs[mIndex]);
			mImage.setImageBitmap(mBitMap);
			updateSize();
		}

		public void Rotate(View view) {
			Matrix matrix = new Matrix();
			Log.d("test", "" + mAngle);
			matrix.postRotate(mAngle); // Each time we rotate for 90 degree
			mBitMap = Bitmap.createBitmap(mBitMap, 0, 0, mImgWidth, mImgHeight, matrix, true);
			mImage.setImageBitmap(mBitMap);
			updateSize();
		}

		private void updateSize() {
			// Grab information about size of image
			mImgHeight = mBitMap.getHeight();
			mImgWidth = mBitMap.getWidth();
			mTextView.setText("The width is " + mImgWidth + ", the height is " + mImgHeight + ".");
		}
	}
