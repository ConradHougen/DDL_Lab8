package com.example.digitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText text;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (EditText) findViewById(R.id.inputField);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.hide_option:
		{
			EditText instr = (EditText) findViewById(R.id.editText1);
			instr.setText("");
			break;
		}
		case R.id.show_option:
		{
			EditText instr = (EditText) findViewById(R.id.editText1);
			instr.setText("Enter decimal number, pick conversion type, hit convert");
			break;
		}
		
		}
		return super.onContextItemSelected(item);
	}

	// This method is called at button click because we assigned the name to the
	// "OnClick property" of the button
	public void myClickHandler(View view) {
		switch (view.getId()) {
		case R.id.button1:
			RadioButton binaryButton = (RadioButton) findViewById(R.id.radioButton1);
			RadioButton hexButton = (RadioButton) findViewById(R.id.radioButton2);
			RadioButton octalButton = (RadioButton) findViewById(R.id.radioButton3);
			if (text.getText().length() == 0) {
				Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
				return;
			}
			
			int inputValue = Integer.parseInt(text.getText().toString());
			if (binaryButton.isChecked() && hexButton.isChecked() ||
					binaryButton.isChecked() && octalButton.isChecked() ||
					octalButton.isChecked() && hexButton.isChecked())
			{
				// too many radio buttons are checked
				Toast.makeText(this, "Please only check one option for conversion",
						Toast.LENGTH_LONG).show();
				return;
			}
				
			if (binaryButton.isChecked()) {
				text.setText(String.valueOf(convertToBinary(inputValue)));
				binaryButton.setChecked(false);
				hexButton.setChecked(true);
				octalButton.setChecked(false);
			}
			else if (hexButton.isChecked()) {
				text.setText(String.valueOf(convertToHex(inputValue)));
				binaryButton.setChecked(false);
				hexButton.setChecked(false);
				octalButton.setChecked(true);
			}
			else if (octalButton.isChecked()) {
				text.setText(String.valueOf(convertToOctal(inputValue)));
				binaryButton.setChecked(true);
				hexButton.setChecked(false);
				octalButton.setChecked(false);
			}
			else {
				Toast.makeText(this, "Please choose a base for conversion",
						Toast.LENGTH_LONG).show();
				return;
			}
			break;
		}
	}
	
	// Converts to Binary
	private String convertToBinary(int decimal) {
		return Integer.toBinaryString(decimal);
	}
	
	// Converts to Hexadecimal
	private String convertToHex(int decimal) {
		return Integer.toHexString(decimal);
	}
	
	// Converts to Octal
	private String convertToOctal(int decimal) {
		return Integer.toOctalString(decimal);
	}
}
