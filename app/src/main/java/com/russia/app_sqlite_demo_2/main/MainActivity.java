package com.russia.app_sqlite_demo_2.main;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.russia.app_sqlite_demo_2.R;
import com.russia.app_sqlite_demo_2.database.DataSqlite;
import com.russia.app_sqlite_demo_2.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTenSV;
    Button btnThemSV;
    ListView lvShowList;
    DataSqlite dataSqlite;
    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        dataSqlite = new DataSqlite(this, "Demo.sqlite", null, 1);
        dataSqlite.requestNonGetData("create table if not exists QuanLySinhVien(ID Integer primary key autoincrement, tenSV varchar)");
        loadData();
        btnThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTenSV.getText().toString().trim().equals("")) {
                    dataSqlite.requestNonGetData("insert into QuanLySinhVien values (null, '" + editTenSV.getText().toString().trim() + "')");
                    Toast.makeText(MainActivity.this, "Them thanh cong sinh vien" + editTenSV.getText().toString(), Toast.LENGTH_SHORT).show();
                    editTenSV.setText("");
                    loadData();
                } else {
                    Toast.makeText(MainActivity.this, "Hay nhap ten sinh vien", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadData() {
        Cursor cursor = dataSqlite.rquestGetData("select * from QuanLySinhVien");
        while (cursor.moveToNext()) {
            studentArrayList.add(new Student(cursor.getInt(0), cursor.getString(1)));
        }
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, studentArrayList);
        lvShowList.setAdapter(adapter);
        adapter.setNotifyOnChange(true);
    }

    private void connectView() {
        editTenSV = findViewById(R.id.edt_tenSinhVien);
        btnThemSV = findViewById(R.id.btn_themSV);
        lvShowList = findViewById(R.id.lv_showList);
    }
}
