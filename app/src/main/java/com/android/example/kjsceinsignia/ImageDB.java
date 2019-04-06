package com.android.example.kjsceinsignia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ImageDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ImageDatabase";
    private static final String TABLE_IMAGES= "images";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BYTES = "bytes";

    public ImageDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_IMAGES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT UNIQUE,"
                + KEY_BYTES + " BLOB UNIQUE" + ")";
        db.execSQL(CREATE_IMAGE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGES);

        // Create tables again
        onCreate(db);
    }

    void addImage(Image img) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, img.getName());
        values.put(KEY_BYTES, img.getBytes());

        db.insert(TABLE_IMAGES, null, values);
        db.close();
    }

    public List<Image> getAllImages() {
        String selectQuery = "SELECT  * FROM " + TABLE_IMAGES;
        List<Image> imageList = new ArrayList<Image>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Image img = new Image();
                img.setId(Integer.parseInt(cursor.getString(0)));
                img.setName(cursor.getString(1));
                img.setBytes(cursor.getBlob(2));

                imageList.add(img);
            } while (cursor.moveToNext());
        }
        return imageList;
    }

    public void deleteImage(Image img) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGES, KEY_NAME + " = ?",
                new String[] { String.valueOf(img.getName()) });
        db.close();
    }
}
