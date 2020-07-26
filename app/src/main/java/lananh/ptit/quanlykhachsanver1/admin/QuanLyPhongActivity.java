package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.R;
import lananh.ptit.quanlykhachsanver1.Room;
import lananh.ptit.quanlykhachsanver1.RoomAdapter;
import lananh.ptit.quanlykhachsanver1.client.ClientHomeActivity;

public class QuanLyPhongActivity extends AppCompatActivity {
    private TextView tvQLphong, tvChoose;
    private Spinner spTang;
    private ListView lvRoom;
    private Database database;
    private ArrayList<Room> listRooms;
    private RoomAdapter adapterRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phong);
        database = new Database(this, "qlks", null, 1);
        database.init(this);
        tvQLphong = findViewById(R.id.tvQLphong);
        tvChoose = findViewById(R.id.tvChoose);
        spTang = findViewById(R.id.spTang);
        lvRoom = findViewById(R.id.lvRoom);
        final String tang[] = {"Tầng 1", "Tầng 2", "Tầng 3"};
        final ArrayAdapter<String> adapterTang = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tang);
        adapterTang.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spTang.setAdapter(adapterTang);
        spTang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listRooms = new ArrayList<>();
                listRooms = database.getListRoomByFloor(position+1);
                adapterRoom = new RoomAdapter(QuanLyPhongActivity.this,R.layout.a_room,listRooms);
                lvRoom.setAdapter(adapterRoom);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}