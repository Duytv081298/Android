package com.android.btvn_buoi7.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.btvn_buoi7.R;
import com.android.btvn_buoi7.models.Student;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder>{
    private ArrayList<Student> data;
    private LayoutInflater inflater;
    private StudentItemListener listener;

    public StudentAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Student> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(StudentItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item, parent,false);
        return new StudentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {
        Student item = data.get(position);
        holder.bindData(item);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFaceItemClick(position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onFaceItemLongClick(position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView tv_name;
        private TextView tv_fname;
        private TextView tv_subjects;
        private TextView tv_point;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_fname = itemView.findViewById(R.id.tv_fname);
            tv_subjects = itemView.findViewById(R.id.tv_sub);
            tv_point = itemView.findViewById(R.id.tv_point);
        }
        public void bindData(Student item) {    // Đổ dữ liệu lên view
            icon.setImageResource(item.getIcon());
            tv_name.setText(item.getTv_name());
            tv_fname.setText(item.getTv_fname());
            tv_subjects.setText(item.getTv_subjects());
            tv_point.setText(item.getTv_point());
        }

    }
    public interface StudentItemListener {
        //trong interface mặc định public đối với phương thức
        //public static final đối với thuộc tính
        void onFaceItemClick(int position);

        void onFaceItemLongClick(int position);
    }

}
