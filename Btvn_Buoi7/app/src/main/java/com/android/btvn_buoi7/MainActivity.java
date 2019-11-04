package com.android.btvn_buoi7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.android.btvn_buoi7.adapter.StudentAdapter;
import com.android.btvn_buoi7.models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StudentAdapter.StudentItemListener {

    private RecyclerView lvStudent;
    public static   ArrayList<Student> DATA;
    private StudentAdapter adapter;
    private  FloatingActionButton buttonAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }



    private void initViews() {
        lvStudent = findViewById(R.id.lv_student);
        adapter = new StudentAdapter(getLayoutInflater());
        lvStudent.setAdapter(adapter);
        adapter.setListener(this);
        buttonAdd = findViewById(R.id.im_addButton);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initData() {
        DATA = new ArrayList<>();
        DATA.add(new Student(R.drawable.circle,"B","Biology","Android","2"));
        DATA.add(new Student(R.drawable.circle,"E","English","java","1.2"));
        DATA.add(new Student(R.drawable.circle,"G","Geography","Php","3.7"));
        DATA.add(new Student(R.drawable.circle,"H","History","Asp","2.4"));
        DATA.add(new Student(R.drawable.circle,"C","Chemistry","Jsp","1.8"));
        DATA.add(new Student(R.drawable.circle,"I","Informatics","Ios","1.2"));
        DATA.add(new Student(R.drawable.circle,"B","Biology","Android","2"));
        DATA.add(new Student(R.drawable.circle,"E","English","java","1.2"));
        DATA.add(new Student(R.drawable.circle,"G","Geography","Php","3.7"));
        DATA.add(new Student(R.drawable.circle,"H","History","Asp","2.4"));
        DATA.add(new Student(R.drawable.circle,"C","Chemistry","Jsp","1.8"));
        DATA.add(new Student(R.drawable.circle,"I","Informatics","Ios","1.2"));
        DATA.add(new Student(R.drawable.circle,"B","Biology","Android","2"));
        DATA.add(new Student(R.drawable.circle,"E","English","java","1.2"));
        DATA.add(new Student(R.drawable.circle,"G","Geography","Php","3.7"));
        DATA.add(new Student(R.drawable.circle,"H","History","Asp","2.4"));
        DATA.add(new Student(R.drawable.circle,"C","Chemistry","Jsp","1.8"));
        DATA.add(new Student(R.drawable.circle,"I","Informatics","Ios","1.2"));
        adapter.setData(DATA);
    }

    @Override
    public void onFaceItemClick(int position) {

    }

    @Override
    public void onFaceItemLongClick(final int position) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dalete")
                .setMessage("Do you want to dalete: " +DATA .get(position).getTv_name())
                .setNegativeButton("Cencel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DATA.remove(position);
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position,DATA.size());
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }


}
