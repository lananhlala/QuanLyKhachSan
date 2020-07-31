package lananh.ptit.thithuqlks.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;
import lananh.ptit.thithuqlks.Room;
import lananh.ptit.thithuqlks.RoomAdapter;

public class ClientHomeActivity extends AppCompatActivity {
    private ListView lvRoom;
    private Database database;
    private ArrayList<Room> listRoom;
    private RoomAdapter roomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);
        lvRoom = findViewById(R.id.lvRoom);
        database = new Database(this, "qlks", null, 1);
        listRoom = database.getAllRoom();
        roomAdapter = new RoomAdapter(ClientHomeActivity.this, R.layout.a_room, listRoom);
        lvRoom.setAdapter(roomAdapter);
    }
}