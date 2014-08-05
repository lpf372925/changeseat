package com.example.changeseat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "log_db";
	private final static int DATABASE_VERSION = 1;
	
	private final static String LOGIN_TABLE_NAME = "account";
	private final static String LOGIN_USER = "admin";
	private final static String LOGIN_PWD = "password";
	

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table "+LOGIN_TABLE_NAME+" ("
				+LOGIN_USER+" text,"
				+LOGIN_PWD+" text )";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql = "drop table if exists "+LOGIN_TABLE_NAME;
		db.execSQL(sql);
		onCreate(db);
	}
	
	public long insertPWD(String password){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(LOGIN_USER, LOGIN_USER);
		cv.put(LOGIN_PWD, password);
		return db.insert(LOGIN_TABLE_NAME, null, cv);
	}
	
}
