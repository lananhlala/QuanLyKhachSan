package lananh.ptit.quanlykhachsanver1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void init(Context context){
        Database database = new Database(context, "qlks",null,1);
//        database.queryData("DROP TABLE lichsuthue");
        database.queryData("CREATE TABLE IF NOT EXISTS room (soP INTEGER PRIMARY KEY, tangP INTEGER, loaiP VARCHAR(100), giaP INTEGER, trangthaiP VARCHAR(200))");
        database.queryData("CREATE TABLE IF NOT EXISTS lichsuthue (id INTEGER PRIMARY KEY AUTOINCREMENT, soP INTEGER, giaP INTEGER, " +
                "gioVao DATETIME, gioRa DATETIME, thanhTien INTEGER)");
    }
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    public void insertRoom(Room r){
        this.queryData(String.format("INSERT INTO room VALUES (%s, %s, '%s', %s, 'Trạng thái: Trống')",
                r.getSoP(),r.getTangP(),r.getLoaiP(),r.getGiaP()));
    }
    public ArrayList<Room> getListRoomByFloor(int tang){
        ArrayList<Room> listRooms = new ArrayList<>();
        Cursor c = this.getData("SELECT * FROM room WHERE tangP = " + tang);
        while (c.moveToNext()){
            Room r = new Room();
            r.setSoP(c.getInt(0));
            r.setLoaiP(c.getString(2));
            r.setGiaP(c.getInt(3));
            r.setTrangthaiP(c.getString(4));
            listRooms.add(r);
        }
        return listRooms;
    }
    public Room getRoomByNumber(int soP){
        Room r  = new Room();
        Cursor c = this.getData("SELECT * FROM room WHERE soP = "+soP);
        if(c.moveToNext()){
            r.setSoP(c.getInt(0));
            r.setTangP(c.getInt(1));
            r.setLoaiP(c.getString(2));
            r.setGiaP(c.getInt(3));
            r.setTrangthaiP(c.getString(4));
        }
        return r;
    }

    public RentHistory getRoomBusy(int soP){
        RentHistory rh = new RentHistory();
        Cursor c = this.getData("SELECT * FROM lichsuthue WHERE soP =" + soP + " AND gioRa IS null");
        if(c.moveToNext()){
            rh.setSoP(c.getInt(1));
            rh.setGiaP(c.getInt(2));
            rh.setGioVao(c.getString(3));
        }
        return rh;
    }
    public ArrayList<DoanhThu> thongKeDoanhThu(){
        ArrayList<DoanhThu> doanhThus = new ArrayList<>();
        Cursor c = this.getData("SELECT soP, SUM(thanhTien) FROM lichsuthue GROUP BY soP");
        while (c.moveToNext()){
            DoanhThu dt = new DoanhThu();
            dt.setSoP(c.getInt(0));
            dt.setDoanhthu(c.getInt(1));
            doanhThus.add(dt);
        }
        return doanhThus;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
