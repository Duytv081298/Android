package com.example.chucmungnammoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.chucmungnammoi.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Runnable{
    private final int WHAT_TIME = 1;
    private TextView hTime;
    private TextView dTime;
    private TextView happyNewYear;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        hTime =findViewById(R.id.Htime);
        dTime =findViewById(R.id.Dtime);
        happyNewYear =findViewById(R.id.HappyNewYear);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true){
            long current = System.currentTimeMillis();
            Message msg = new Message();
            msg.obj = current;
            handler.sendMessage(msg);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private Handler handler = new Handler(){
        SimpleDateFormat formatH = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String h = formatH.format(msg.obj);
            String d = formatD.format(msg.obj);
            hTime.setText(h);
            dTime.setText(d);
            int rand_int1 = rand.nextInt(6);
            text = list[rand_int1] + text;
            happyNewYear.setText(text);
        }
    };
    private String list[] =
            {
                    "\n\n\n" +"Màu xuân chi én lượn chao\n" +
                            "Canh tý năm mới, ta cùng chúc nhau.\n" +
                            "Chúc bố sức khỏe dồi dào\n" +
                            "Mẹ thêm tuổi mới, ốm đau chẳng còn.\n" +
                            "Mãi mãi sống cùng các con\n" +
                            "Cùng nhau hạnh phúc, chúng con vui vầy.\n" +
                            "Anh em con cùng đến đây\n" +
                            "Sum vầy hạnh phúc, đón vàng lộc xuân",

                    "\n\n\n" +
                            "Mai vàng nở rộ đón xuân sang\n" +
                            "Xuân đã dần qua khắp xóm làng.\n" +
                            "Ngắm hoa thấy trong lòng phơi phới\n" +
                            "Mừng đón Chúa xuân xuống Trần gian..\n" +
                            "Lộc xuân nở biếc quanh nhà\n" +
                            "Nâng ly chúc sếp thuận hòa gió mưa\n" +
                            "Chúc người đi sớm về trưa\n" +
                            "Lộc tài rủng rỉnh, suốt mùa gặp hên",

                    "\n\n\n" +
                            "Lì xì trước Tết một bài thơ\n" +
                            "Canh Tý năm nay hết thẩn thờ\n" +
                            "Lộng lẫy son vàng bên gác nhớ\n" +
                            "Đong đầy sắc thắm ở trong mơ\n" +
                            "Nên tìm hạnh phúc sau tan vỡ\n" +
                            "Ắt hẳn vẻ vang đến dại khờ\n" +
                            "Mãi mãi yên bình không bước lỡ\n" +
                            "Xuân này chắc chắn trọn duyên tơ",

                    "\n\n\n" +
                            "Tết xuân chúc bạn đôi lời\n" +
                            "Đại dương sức khỏe thảnh thơi an nhàn\n" +
                            "Gia đình sung túc giàu sang\n" +
                            "Làm ăn phát đạt thăng quan mỗi ngày.",

                    "\n\n\n" +
                    "Anh lại viết bài thơ xuân mười chín\n" +
                            "Dường như đông bịn rịn chửa nhường ngôi\n" +
                            "Gió sắt se từng đợt cứ ngậm ngùi\n" +
                            "Gieo buốt giá tới lui đầy trăn trở\n" +
                            "Câu thơ viết cũng đành lòng dang dở\n" +
                            "Bởi vần gieo còn nặng nợ nhớ nhung\n" +
                            "Lão thời gian thì vẫn mãi lạnh lùng\n" +
                            "Chẳng chịu đợi theo cùng dòng suy nghĩ\n" +
                            "Vẳng bên tai lời ai vừa thủ thỉ\n" +
                            "Xuân sắp về đừng hiềm tị vấn vương\n" +
                            "Mong ngày kia hai đứa được chung đường\n" +
                            "Câu hẹn ước đã dường như trọn vẹn\n" +
                            "Chùm hoa Khế hé mắt nhìn len lén\n" +
                            "Như ngại ngùng e thẹn với nàng xuân\n" +
                            "Giọt nắng rơi trên kẽ lá tần ngần\n" +
                            "Cánh Đào phai lần chần chờ hé nụ\n" +
                            "Chào mười chín với bao điều nhắn nhủ\n" +
                            "Đón xuân về...\n" +
                            "Ấp ủ...\n" +
                            "Vạn niềm tin!",

                    "\n\n\n" +
                            "Đầu năm gửi bạn một chữ NHÀN\n" +
                            "Để cuộc đời này hết lầm than\n" +
                            "Mọi người cuộc sống thêm sung sướng\n" +
                            "Trọn kiếp an nhàn hết thở than!\n" +
                            "Gửi tiếp cho nhau một chữ AN\n" +
                            "Để bạn yên lòng với yên an\n" +
                            "Không còn lo lắng ưu phiền não\n" +
                            "Cuộc sống muôn màu với an khang!\n" +
                            "Ta lại gửi thêm một chữ TÌNH\n" +
                            "Nụ cười luôn nở mỗi môi xinh\n" +
                            "Gia đình, bè bạn luôn êm ấm\n" +
                            "Gia đạo an lành đẹp tâm linh!\n" +
                            "- CHÚC nhau xuân về thêm hạnh phúc\n" +
                            "MỪNG cho mọi người được bình an\n" +
                            "NĂM cũ qua hết dở dang\n" +
                            "MỚI đem may mắn đến cùng thành công."};
    private String text;

}
