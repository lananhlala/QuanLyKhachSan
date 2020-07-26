package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import lananh.ptit.quanlykhachsanver1.R;

public class QuanLyTangActivity extends AppCompatActivity {
    private EditText etTang, etPhong;
    private Button btGen;
    private ListView lvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tang);
        etTang = findViewById(R.id.etTang);
        etPhong = findViewById(R.id.etPhong);
        btGen = findViewById(R.id.btGen);
        lvResult = findViewById(R.id.lvResult);
        btGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tang = Integer.parseInt(etTang.getText().toString());
                int phong = Integer.parseInt(etPhong.getText().toString());
                ArrayList<Integer> listTang = new ArrayList<>();
                for(int i=tang*100+1;i<=tang*100+phong;i++){
                    listTang.add(i);
                }
                ArrayAdapter phongAdapter = new ArrayAdapter<Integer>(QuanLyTangActivity.this,android.R.layout.simple_list_item_1,listTang);
                lvResult.setAdapter(phongAdapter);
            }
        });

    }
}