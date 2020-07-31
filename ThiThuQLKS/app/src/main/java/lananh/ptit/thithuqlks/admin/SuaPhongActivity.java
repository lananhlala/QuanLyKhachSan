package lananh.ptit.thithuqlks.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;

public class SuaPhongActivity extends AppCompatActivity {
    private TextView tvSoP;
    private EditText etLoaiP, etGiaP;
    private Button btSua, btXoa;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_phong);
        tvSoP = findViewById(R.id.tvSoP);
        etLoaiP = findViewById(R.id.etLoai);
        etGiaP = findViewById(R.id.etGiaP);
        btSua = findViewById(R.id.btSua);
        btXoa = findViewById(R.id.btXoa);
    }
}