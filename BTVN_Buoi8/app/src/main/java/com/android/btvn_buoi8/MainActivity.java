package com.android.btvn_buoi8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.btvn_buoi8.Models.Story;
import com.android.btvn_buoi8.adapter.StoryAdapter;

import java.util.ArrayList;

import static com.android.btvn_buoi8.Detail_Story.POSITION;

public class MainActivity extends AppCompatActivity implements StoryAdapter.StoryListener {
    private static final int REQUEST_DETAIL = 1 ;
    private RecyclerView lvStory;
    public static ArrayList<Story> LISTSTORY;
    private StoryAdapter storyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initData() {
        LISTSTORY = new ArrayList<>();
        LISTSTORY.add(new Story(R.drawable.anime1,"Đấu la đại lục","Chương 335","Lặng Thầm", "2017-06-03 21:52:52", listNoiDung[0]));
        LISTSTORY.add(new Story(R.drawable.anime2,"Đấu Phá Thương Khung","Chương 664","Thiên Tàm Thổ Đậu", "2019-05-04 24:00:00", listNoiDung[1]));
        LISTSTORY.add(new Story(R.drawable.anime3,"Độc Tôn Tam Giới","Chương 455","Lê Thiên", "2019-06-09 04:15:15", listNoiDung[2]));
        LISTSTORY.add(new Story(R.drawable.anime4,"Linh Vũ Thiên Hạ","Chương 887","Vũ Phong", "2019-07-05 22:30:40", listNoiDung[3]));
        LISTSTORY.add(new Story(R.drawable.anime5,"Phi Thiên","Chương 555","Dược Thiên Sầu", "2019-02-07 13:15:19", listNoiDung[4]));
        LISTSTORY.add(new Story(R.drawable.anime6,"Lấy Chông Bạc Tỷ","Chương 999","Mộc Thất Thất", "2019-06-12 14:13:00", listNoiDung[5]));
        LISTSTORY.add(new Story(R.drawable.anime7,"Hạ Tuyết","Chương 445","Võ Anh Thơ", "2019-01-03 22:50:00", listNoiDung[6]));
        LISTSTORY.add(new Story(R.drawable.anime8,"Người Tình Trí Mạng","Chương 624","Ân Tầm", "2019-09-15 07:15:00", listNoiDung[7]));
        LISTSTORY.add(new Story(R.drawable.anime9," Cô Vợ Thay Thế","Chương 240","Lạt Tiêu", "2019-07-15 09:30:00", listNoiDung[8]));
        LISTSTORY.add(new Story(R.drawable.anime2,"Đấu Phá Thương Khung","Chương 664","Thiên Tàm Thổ Đậu", "2019-05-04 24:00:00", listNoiDung[1]));
        LISTSTORY.add(new Story(R.drawable.anime2,"Đấu Phá Thương Khung","Chương 664","Thiên Tàm Thổ Đậu", "2019-05-04 24:00:00", listNoiDung[1]));
        storyAdapter.setListStory(LISTSTORY);
    }

    private void initViews() {
        lvStory = findViewById(R.id.lv_story);
        storyAdapter = new StoryAdapter(getLayoutInflater());
        lvStory.setAdapter(storyAdapter);
        storyAdapter.setListener(this);
    }

    @Override
    public void onStoryItemClick(int position) {
        Intent intent = new Intent(this, Detail_Story.class);
        intent.putExtra(POSITION, position +"");
        startActivityForResult(intent, REQUEST_DETAIL);
    }

    @Override
    public void onStoryItemLongClick(int position) {

    }

    private String listNoiDung []={"Võ công ghi lại trên Huyền Thiên Bảo Lục chỉ có sáu loại, phân biệt là nội công tâm pháp Huyền Thiên Công, luyện tay phương pháp Huyền Ngọc Thủ. Luyện nhãn phương pháp Tử Cực Ma Đồng. \"Cầm nã pháp\" (phương pháp bắt) Khống Hạc Cầm Long, khinh thân phương pháp Quỷ Ảnh Mê Tung, cùng với ám khí sử dụng phương pháp, Ám Khí Bách Giải.\n" +
            "\n" +
            "Năm loại trước là trụ cột. Không có trụ cột vững chắc. như thế nào có thể phát huy hết tinh túy của Đường Môn ám khí chứ?\n" +
            "\n" +
            "Một tuổi đã bắt đầu tu luyện Huyền Thiên Công, bây giờ Đường Tam đã sắp sáu tuổi. Hắn như trước vẫn tu luyện cơ sở.","\"Đấu lực, ba đoạn\"\n" +
            "\n" +
            "Nhìn năm chữ to lớn có chút chói mắt trên trắc nghiệm ma thạch, thiếu niên mặt không chút thay đổi, thần sắc tự giễu, nắm chặt tay, bởi vì dùng lực quá mạnh làm móng tay đâm thật sâu vào trong lòng bàn tay, mang đến từng trận trận đau đớn trong tâm hồn...\n" +
            "\n" +
            "\"Tiêu Viêm, đấu lực, ba đoạn! Cấp bậc: Cấp thấp!\".\n" +
            "\n" +
            "Bên cạnh trắc nghiệm ma thạch, một vị trung niên nam tử, thoáng nhìn tin tức trên bia, ngữ khí hờ hững công bố…\n" +
            "\n" +
            "Trung niên nam tử vừa nói xong, không có gì ngoài ý muốn, đám người trên quảng trường lại nổi lên trận trận châm chọc tao động","Giang Trần cảm giác dường như trong đầu mình loạn thành một đoàn bột nhão, cảm giác này giống như là đang nằm mơ, nhưng nằm mơ thì không thể nào chân thật đến mức này được. Mỗi một tấc da thịt quanh thân, mỗi một khối xương cốt, đều đau đớn không chịu nổi.\n" +
            "\n" +
            "- Ta đã chết rồi sao? Đang chịu nỗi khổ luyện thân trong mấy tầng địa ngục sao ?\n" +
            "\n" +
            "Trực giác đầu tiên của Giang Trần là cảm giác mình đã chết. Thế nhưng, Sinh Mệnh Khí Tức như có như không của thân thể, lại phảng phất đang nhắc nhở hắn, hắn còn sống.\n","Ngay tại lúc Lục Thiếu Du đang suy nghĩ xem có phải yêu thú đang tiến về phía mình hay không thì từ trên không một chuỗi âm thanh rít gào truyền đến. Ngay lập tức trước mắt hắn như bị mây đen bao phủ. Một con chim khổng lồ dài hơn trăm thước xuất hiện trên không trung.\n" +
            "\n" +
            "Cách chim mở rộng, bay lượn ngay khoảng không trên đầu Lục Thiếu Du. Con chim này có điểm giống chim ưng nhưng phủ bên ngoài bộ lông màu xanh, dưới bụng có lông tơ màu trắng. Hai chân có móng vuốt sắc nhọn uốn cong, thoạt nhìn như lưỡi dao sắc bén, hai mắt Cự Ưng chăm chú nhìn xuống phía hắn.\n" +
            "\n" +
            "- Yêu thú, chẳng lẽ ta vừa mới xuyên qua đã phải trở thành món ăn trong bụng yêu thú sao?\n" +
            "\n" +
            "Lục Thiếu Du vô cùng kinh ngạc, ở kiếp trước lấy đâu ra một con chim ưng lớn như vậy. Lập tức, Lục Thiếu Du bất đắc dĩ mà nở nụ cười khổ, bây giờ mình không thể di chuyển, yêu thú mà muốn ăn thịt mình thì cũng chỉ có thể trơ mắt nhìn.",
            "Đừng chạy! Họ Miêu kia, ngươi không chạy thoát được đâu, đứng lại cho lão tử!\n" +
             "\n" + "Ba thiếu niên tay cầm trường đao đang chạy rất nhanh trong dãy núi đen kịt vô cùng kỳ quái, thỉnh thoảng quơ đao đe dọa bắt người đang chạy trốn trước mặt dừng lại.\n" +
              "\n" + "Đe dọa vô dụng, chẳng những người trước mặt không ngừng, ngược lại còn chạy nhanh hơn.\n" + "\n" + "Thiếu niên chạy trước tay cầm một thanh đao giết heo không thèm nghe, vừa chạy vừa quay đầu lại rống lên một tiếng:\n" + "\n" + "- Chó điên, sao không xem thử đây là địa phương nào, chẳng lẽ là đầu óc các ngươi có bệnh rồi sao?!", "“Giang Nhung, đây là thẻ ngân hàng của tôi, mật mã là 131224. Trong nhà cần mua thêm gì thì em cứ mua.\"\n" +
            "\n" +
            "Đã mấy tiếng trôi qua, nhưng bên tai Giang Nhung vẫn còn văng vẳng những lời mà chồng mới cưới nói lúc đưa cho cô tấm thẻ ngân hàng trước khi ra ngoài vào buổi sáng.\n" +
            "\n" +
            "Nói thật lòng, những gì cô biết về người đàn ông này cũng chính là chồng cô bây giờ, thực sự ít ỏi đến đáng thương.\n" +
            "\n" +
            "Ngoại trừ việc anh tự nói với cô rằng anh họ Trần tên Việt thì cô hoàn toàn không biết chuyện gì khác, ngay cả trong nhà anh có những ai cô đều không biết.\n" +
            "\n" +
            "Giang Nhung cũng không biết mình lấy đâu ra dũng khí mà lại dám đăng ký kết hôn với một người đàn ông mới chỉ gặp mặt hai lần.", "Khi lần đầu tiên trở thành PR trong quán bar Gossi, Hạ Tuyết đã nôn thốc ruột, cảm giác quặn đau của bao tử rất kinh khủng, đầu óc chẳng còn tỉnh táo vì uống quá nhiều rượu. Toàn thân mệt lả, không chút sức lực vậy mà đêm đó cô được khách \"boa\" tiền chẳng bao nhiêu...\n" +
            "\n" +
            "Tiếng nhạc xập xình, ánh đèn màu chớp tắt trong thế giới hào nhoáng mờ ảo, Hạ Tuyết đứng bên quầy rượu chờ xem có vị khách nào gọi mình không. Dẫu làm PR một thời gian nhưng cô vẫn còn cảm giác đau nhừ sống lưng, rát buốt lòng bàn chân vì phải đứng trên đôi giày gót cao năm, bảy phân trong suốt tám giờ liền. Buồn buồn, Hạ Tuyết đưa mắt quan sát xung quanh. Những cô PR khác cứ như mấy chiếc bóng, đang lượn lờ theo nhạc. Ai ai cũng ngồi tâm sự cùng với khách và uống rượu hoặc trở thành \"trò vui\" của họ. Cô nào cô đó phấn trắng phấn hồng dày cuộm, gương mặt tươi sáng, năng động ở lứa tuổi xuân thì. Các PR mặc toàn váy ngắn ôm sát người, lúc hở vai khi thì trễ xuống nửa ngực. Mỗi người mỗi vẻ. Những nụ cười khác nhau. Những hoàn cảnh khác nhau. Và, những thân phận khác nhau.", "Ở thành cổ Thương Lăng lưu truyền một lời đồn đại kinh dị về cầu Cửu Tử.\n" +
            "\n" +
            "Cây cầu này nằm trên con đường Cổ Đồng phía Tây ngoại thành, từ xa sẽ đối diện với khu bảo tồn lịch sử nằm trên con đường Tô Hà trong thành.\n" +
            "\n" +
            "Ai ai cũng kể rằng, cầu Cửu Tử một đầu gác phía dương gian, một đầu hướng về âm thế, linh hồn của người chết sẽ men theo cây cầu Cửu Tử để đi xuống địa phủ.\n" +
            "\n" +
            "Sở dĩ cây cầu lấy tên là Cửu Tử tương truyền là vì nhờ có chín người con của rồng trấn áp âm khí trên cây cầu này mà trật tự của hai thế giới âm dương mới không bị đảo lộn.\n" +
            "\n" +
            "*Theo truyền thuyết, bảy người con của rồng là bảy người con của Đông Hải Long Vương, bao gồm: Tù Ngưu, Nhai Xế, Trào Phong, Bồ Lao, Toan Nghê, Bệ Ngạn, Phụ Hí, Li Vãn." ,"Hạ Diệp Chi sững sờ ngồi trước bàn trang điểm, đợi thợ makeup vào trang điểm cho cô.\n" +
            "\n" +
            "Đột nhiên, cửa phòng bị mở ra, Tiêu Thanh Hà vội vã chạy vào.\n" +
            "\n" +
            "Bà ta nhìn thấy Hạ Diệp Chi đầu tóc rối bù, trên người mặc một chiếc áo bông dài màu xám u ám, lập tức quở trách, người nhà họ Mạc đều đã đến rồi, sao đến quần áo con còn chưa thay?\"\n" +
            "\n" +
            "Hạ Diệp Chi đẩy đẩy chiếc kính gọng đen trên mũi, mắt rũ xuống thẫn thờ, \"Mẹ, mẹ thật sự muốn gả con cho vị hôn phu của chị sao?\"\n" +
            "\n" +
            "Tiêu Thanh Hà nghĩ rằng cô đang hối hận, nên sốt ruột đến mức sắc mặt trắng bệch.\n" +
            "\n" +
            "Người của nhà họ Mạc đang đợi bên ngoài, một chút sơ suất thôi là có thể hủy hoại cả nhà họ Hạ!\n" +
            "\n" +
            "Bà ta sốt ruột đến mức \"bịch\" một tiếng quỳ xuống trước mặt Hạ Diệp Chi, \" Diệp Chi, mẹ cầu xin con, chị của con xứng đáng có thứ tốt đẹp hơn, con hãy giúp nó đi!\"\n" +
            "\n" +
            "Đôi mắt vốn thẩn thờ của Hạ Diệp Chi dần dần trở nên lạnh lùng, Tiêu Thanh Hà tuy là mẹ ruột của cô, nhưng toàn bộ tình thương đều giành cho đứa con gái của người vợ trước đã qua đời của bố.\n" +
            "\n" +
            "Vì thế, Tiêu Thanh Hà rõ ràng biết vị hôn phu của chị gái vừa xấu vừa bất lực, nhưng vẫn muốn gả Hạ Diệp Chi đi thay cho chị gái."};
}
