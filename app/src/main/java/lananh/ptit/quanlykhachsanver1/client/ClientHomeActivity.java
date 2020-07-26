package lananh.ptit.quanlykhachsanver1.client;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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

public class ClientHomeActivity extends AppCompatActivity {
    private TextView tvInforRoom, tvChoose;
    private Spinner spTang;
    private ListView lvRoom;
    private Database database;
    private ArrayList<Room> listRooms;
    private RoomAdapter adapterRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);
        database = new Database(this, "qlks", null, 1);
        database.init(this);
//        database.queryData(String.format("UPDATE room SET trangthaiP = 'Trạng thái: Trống' WHERE trangthaiP = 'Trạng thái: Bận'"));
        tvInforRoom = findViewById(R.id.tvInfor);
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
                adapterRoom = new RoomAdapter(ClientHomeActivity.this,R.layout.a_room,listRooms);
                lvRoom.setAdapter(adapterRoom);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}