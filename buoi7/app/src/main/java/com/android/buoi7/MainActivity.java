package com.android.buoi7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.android.buoi7.adapter.FaceAdapter;
import com.android.buoi7.models.Face;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceItemListener {

    private RecyclerView lvFace;
    private ArrayList<Face> data;
    private FaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initViews() {
    lvFace = findViewById(R.id.lv_face);
    adapter = new FaceAdapter(getLayoutInflater());
    lvFace.setAdapter(adapter);
    adapter.setListener(this);
    }
    private void initData() {
        data = new ArrayList<>();
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        data.add(new Face(R.drawable.beauty,"beauty"));
        data.add(new Face(R.drawable.oh,"oh"));
        data.add(new Face(R.drawable.too_sad,"too_sad"));
        data.add(new Face(R.drawable.what,"what"));
        adapter.setData(data);
    }




    @Override
    public void onFaceItemClick(int position) {
        Toast.makeText(this, "Click"+data.get(position).getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaceItemLongClick(final int position) {
        Toast.makeText(this, "Long Click"+data.get(position).getName(),Toast.LENGTH_SHORT).show();
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Dalete")
                .setMessage("Do you want to dalete: " +data .get(position).getName())
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
                        adapter.notifyItemRangeChanged(position,data.size());
                        dialog.dismiss();
                    }
                })
                .create();
//            dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false); //click ra ngoai
        dialog.show();

    }


}
