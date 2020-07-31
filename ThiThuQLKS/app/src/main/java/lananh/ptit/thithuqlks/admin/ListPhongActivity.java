package lananh.ptit.thithuqlks.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;
import lananh.ptit.thithuqlks.Room;
import lananh.ptit.thithuqlks.RoomAdapter;
import lananh.ptit.thithuqlks.client.ClientHomeActivity;

public class ListPhongActivity extends AppCompatActivity {
    private ListView lvRoom;
    private Database database;
    private ArrayList<Room> listRoom;
    private RoomAdapter roomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_phong);
        lvRoom = findViewById(R.id.lvRoom);
        database = new Database(this, "qlks", null, 1);
        listRoom = database.getAllRoom();
        roomAdapter = new RoomAdapter(ListPhongActivity.this, R.layout.a_room, listRoom);
        lvRoom.setAdapter(roomAdapter);
    }
}