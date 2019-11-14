package com.android.btvn_buoi7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.btvn_buoi7.adapter.StudentAdapter;
import com.android.btvn_buoi7.models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.android.btvn_buoi7.add.EXTRA_NAME;
import static com.android.btvn_buoi7.add.EXTRA_POINT;
import static com.android.btvn_buoi7.add.EXTRA_SUBJECT;

public class MainActivity extends AppCompatActivity implements StudentAdapter.StudentItemListener {

    private static final int REQUEST_ADD = 1;
    private static final int REQUEST_MODIFY = 2;
    private RecyclerView lvStudent;
    private ArrayList<Student> data;
    private StudentAdapter adapter;
    private FloatingActionButton buttonAdd;
    private int position;


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
        clickBtnAdd();

    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Student(R.drawable.circle,  "Biology", "Android", "2"));
        data.add(new Student(R.drawable.circle, "English", "java", "1.2"));
        data.add(new Student(R.drawable.circle,  "Geography", "Php", "3.7"));
        data.add(new Student(R.drawable.circle,  "History", "Asp", "2.4"));
        data.add(new Student(R.drawable.circle,  "Chemistry", "Jsp", "1.8"));
        data.add(new Student(R.drawable.circle, "Informatics", "Ios", "1.2"));
        data.add(new Student(R.drawable.circle,  "Biology", "Android", "2"));
        data.add(new Student(R.drawable.circle, "English", "java", "1.2"));
        data.add(new Student(R.drawable.circle,  "Geography", "Php", "3.7"));
        data.add(new Student(R.drawable.circle,  "History", "Asp", "2.4"));
        data.add(new Student(R.drawable.circle,  "Chemistry", "Jsp", "1.8"));
        data.add(new Student(R.drawable.circle, "Informatics", "Ios", "1.2"));
        data.add(new Student(R.drawable.circle,  "Biology", "Android", "2"));
        data.add(new Student(R.drawable.circle, "English", "java", "1.2"));
        data.add(new Student(R.drawable.circle,  "Geography", "Php", "3.7"));
        data.add(new Student(R.drawable.circle,  "History", "Asp", "2.4"));
        data.add(new Student(R.drawable.circle,  "Chemistry", "Jsp", "1.8"));
        data.add(new Student(R.drawable.circle, "Informatics", "Ios", "1.2"));
        adapter.setData(data);
    }

    @Override
    public void onStudentItemClick(int position) {
        String name = data.get(position).getTv_name();
        String subjects = data.get(position).getTv_subjects();
        String point = data.get(position).getTv_point();
        this.position = position;

        Intent intent = new Intent(this, modify.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_SUBJECT, subjects);
        intent.putExtra(EXTRA_POINT, point);
        startActivityForResult(intent, REQUEST_MODIFY);

    }

    @Override
    public void onStudentItemLongClick(final int position) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dalete")
                .setMessage("Do you want to dalete: " + data.get(position).getTv_name())
                .setNegativeButton("Cencel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position, data.size());
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    public void clickBtnAdd() {
        buttonAdd = findViewById(R.id.im_addButton);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, add.class);
                startActivityForResult(intent, REQUEST_ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra(EXTRA_NAME);
                String subjects = data.getStringExtra(EXTRA_SUBJECT);
                String point = data.getStringExtra(EXTRA_POINT);

                this.data.add(new Student(R.drawable.circle,  name, subjects, point));
                adapter.setData(this.data);

            } else {
                Toast.makeText(this,
                        "Register cancelled", Toast.LENGTH_LONG).show();
            }
        }else if (requestCode == REQUEST_MODIFY) {
            if (resultCode == 2) {
                String name = data.getStringExtra(EXTRA_NAME);
                String subjects = data.getStringExtra(EXTRA_SUBJECT);
                String point = data.getStringExtra(EXTRA_POINT);

                this.data.set(this.position, new Student(R.drawable.circle, name, subjects, point));
                adapter.setData(this.data);

            } else {
                Toast.makeText(this,
                        "Register cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}
