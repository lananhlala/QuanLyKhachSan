package lananh.ptit.thithuqlks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    public void init(Context context){
        this.queryData("CREATE TABLE IF NOT EXISTS room (soP INTEGER PRIMARY KEY, tang INTEGER, loaiP VARCHAR(100)," +
                "giaP INTEGER, trangthai VARCHAR(200))");
    }
    public void insertRoom(Room r){
        this.queryData(String.format("INSERT INTO room VALUES (%s, %s, '%s', %s, 'Trang thai: Trong')",r.getSoP(), r.getTang(), r.getLoaiP(), r.getGiaP()));
        this.queryData("CREATE TABLE IF NOT EXISTS lichsuthue (id INTEGER PRIMARY KEY AUTOINCREMENT, soP INTEGER, giaP INTEGER, " +
                "gioVao DATETIME, gioRa DATETIME, thanhTien INTEGER)");
    }
    public Room getRoom(int soP){
        Room r = new Room();
        Cursor c = this.getData("SELECT * FROM room WHERE soP = "+soP);
        while (c.moveToNext()){
            r.setSoP(c.getInt(0));
            r.setTang(c.getInt(1));
            r.setLoaiP(c.getString(2));
            r.setGiaP(c.getInt(3));
            r.setTrangthai(c.getString(4));
        }
        return r;
    }
    public ArrayList<Room> getAllRoom(){
        ArrayList<Room> listRoom = new ArrayList<>();
        Cursor c = this.getData("SELECT * FROM room");
        while (c.moveToNext()){
            Room r = new Room();
            r.setSoP(c.getInt(0));
            r.setTang(c.getInt(1));
            r.setLoaiP(c.getString(2));
            r.setGiaP(c.getInt(3));
            r.setTrangthai(c.getString(4));
            listRoom.add(r);
        }
        return listRoom;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
