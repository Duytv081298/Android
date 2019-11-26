package com.android.buoi7.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.buoi7.MainActivity;
import com.android.buoi7.R;
import com.android.buoi7.models.Face;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {
    private ArrayList<Face> data;
    private LayoutInflater inflater;
    private FaceItemListener listener;

    public FaceAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Face> data) {
        this.data = data;
        notifyDataSetChanged();// Cập nhật lại giao diện của RecyclerView
    }

    public void setListener(FaceItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // ánh xạ view lên cho  Holder
        Log.e(getClass().getName(), "onCreateViewHolder");
        View v = inflater.inflate(R.layout.iterm_face, //id layut
                parent, //Nhóm layout
                false); // inflater load layout lên đưa nó thành 1 view lớn
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, final int position) {  // Dổ thông tin vào layout đã đk ánh xạ
        Face item = data.get(position);
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
    public int getItemCount() { // Trả vè số lượng phần tử =>
        return data == null ? 0 : data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder { // giữ tất cả những ánh xạ item view

        private ImageView imFace;
        private TextView tvFace;


        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            imFace = itemView.findViewById(R.id.im_face);
            tvFace = itemView.findViewById(R.id.tv_face);
        }

        public void bindData(Face item) {    // Đổ dữ liệu lên view
            imFace.setImageResource(item.getIcon());
            tvFace.setText(item.getName());
        }
    }

    public interface FaceItemListener {
        //trong interface mặc định public đối với phương thức
        //public static final đối với thuộc tính
        void onFaceItemClick(int position);

        void onFaceItemLongClick(int position);
    }
}

/*RecyclerView ra đời nhằm sử lý một mảng dữ liệu lớn
 *
 * với listview and gridview  thông thường 2 công việc loadlayout và bindData sẽ được thực cùng lúc
 * đối với RecyclerView các data đã load rồi sẽ chỉ được bindData lại
 * Không đồng thời load tất cả các phần tử trong data mà load số lượng phù hợp với kích thước màn hình hiển thị.
 * Khi những phần tử bị ẩn đi những phần tử đó sẽ bị giải phóng data
 *
 *
 * listview: Khi hiển thị trở lại đều cần loadlayout và bindData sẽ được thực cùng lúc
 *
 *
 * RecyclerView cũng cấp những phương thức để thay đổi:
 *       notifyDataSetChanged cập nhật lại những phần tử cần được hiển thị
 *       notifyItemChanged Thay đổi 1 phần tử
 *       notifyItemRemoved tạo animation (tránh sự thay đổi đột ngột trên màn hình)
 *
 *
 * */

