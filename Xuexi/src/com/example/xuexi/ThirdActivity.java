package com.example.xuexi;

import com.example.dbdao.DatabaseHelper;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends Activity {

	private Button buttonInsert;
	private Button buttonUpdate;
	private Button buttonSelect;
	private Button buttonCreate;

	private DatabaseHelper dbHelper = new DatabaseHelper(this, "BookStore.db", null, 1);
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_third);
		getWidget();

	}

	private void getWidget() {
		buttonInsert = (Button) findViewById(R.id.buttonInsert);
		buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
		buttonSelect = (Button) findViewById(R.id.buttonSelect);
		buttonCreate = (Button) findViewById(R.id.buttonCreate);

		buttonInsert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonInsert_onClick(v);
			}
		});
		buttonUpdate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonUpdate_onClick(v);

			}
		});

		buttonSelect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonSelect_onClick(v);
			}
		});

		buttonCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonCreate_onClick(v);
			}
		});
	}

	public void buttonInsert_onClick(View v) {
		db = dbHelper.getWritableDatabase();
		db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
				new String[] { "The Da Vinci Code", "Dan Brown", "454", "16.96" });
		db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
				new String[] { "The Lost Symbol", "Dan Brown", "510", "19.95" });
	}

	public void buttonUpdate_onClick(View v) {
		db = dbHelper.getWritableDatabase();
		db.execSQL("update Book set price = ? where name = ?", new String[] { "10.99", "The Da Vinci Code" });
	}

	public void buttonSelect_onClick(View v) {
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from Book", null);
		while (cursor.moveToNext()) {
			Toast.makeText(ThirdActivity.this, cursor.getString(cursor.getColumnIndex("price")), Toast.LENGTH_SHORT)
					.show();
			break;
		}
	}

	public void buttonCreate_onClick(View v) {
		db = dbHelper.getWritableDatabase();
	}
}
