package com.sahar.mofkrty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {

    private static  DatabaseHelper dbHelper ;
    static String DATABASE_NAME = "notedb.db";
    static int DATABASE_VERSION = 1 ;
    static String TABLE_NAME = "Note";
    static String ID   = "id";
    static String NAME = "Name";
    static String TITLE = "Title";
    static String BODY = "Body";

    public DatabaseAdapter(Context context)
    {
        dbHelper = new DatabaseHelper(context);
    }
    static class DatabaseHelper extends SQLiteOpenHelper{


        DatabaseHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE  "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+NAME+" VARCHAR(50) ,"
                    +TITLE+" VARCHAR(50) , "+BODY+" VARCHAR(255));";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


    public boolean insertNote(String userName,String title , String body)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",userName);
        contentValues.put("Title",title);
        contentValues.put("Body",body);

        long check = db.insert(TABLE_NAME,null,contentValues);
        if(check>-1)
            return  true ;
        else return false;
    }

    public String QueryNote(String userName,String title)
    {
        String resBody = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String [] selectionArgs = {userName,title};

        String selection = "Name = ? And  Title = ? ;";
        String query = "SELECT  Body  FROM  "+TABLE_NAME;
        Cursor cur = db.query(TABLE_NAME,new String[] {"Body"},selection,selectionArgs,null,null,null);
        if(cur.getCount()>0)
        {
            cur.moveToFirst();
            resBody = cur.getString(0);
        }
        return resBody ;
    }

}
