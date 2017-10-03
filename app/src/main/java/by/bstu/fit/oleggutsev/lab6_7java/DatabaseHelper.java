package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "labaJava.db"; // название бд
    private static final int SCHEMA = 5; // версия базы данных
    // названия столбцов
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_MIDDLENAME = "middleName";
    public static final String COLUMN_SURNAME = "surname";

    //students parameters
    public static final String TABLESTUDENT = "students";
    public static final String COLUMN_SPECIALITY = "speciality";
    public static final String COLUMN_FACULTY = "faculty";

    //listener parameters
    public static final String TABLELISTENER = "listeners"; // название таблицы в бд
    public static final String COLUMN_COUNTHOURS = "countHours";
    public static final String COLUMN_ORGANIZATION = "organization";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLESTUDENT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SURNAME + " TEXT,"
                + COLUMN_MIDDLENAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_FACULTY + " TEXT,"
                + COLUMN_SPECIALITY + " TEXT);");

        db.execSQL("CREATE TABLE " + TABLELISTENER + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SURNAME + " TEXT,"
                + COLUMN_MIDDLENAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_COUNTHOURS + " TEXT,"
                + COLUMN_ORGANIZATION + " TEXT);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLESTUDENT);
        onCreate(db);
    }
}