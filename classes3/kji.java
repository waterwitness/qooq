import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kji
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public kji(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramAddFriendVerifyActivity.getIntent().getIntExtra("friend_setting", 0) != 0) {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = (paramString + "?_wv=1031&troopUin=" + paramAddFriendVerifyActivity.c + "&isVerify=" + i);
  }
  
  public void run()
  {
    if (SearchProtocol.a != -1.0F) {}
    for (long l1 = (SearchProtocol.a * 1000000.0F);; l1 = -1L)
    {
      if (SearchProtocol.b != -1.0F) {}
      for (long l2 = (SearchProtocol.b * 1000000.0F);; l2 = -1L)
      {
        if ((System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) && (l1 == -1L) && (l2 == -1L))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.postDelayed(this, 100L);
          return;
        }
        if ((l1 != -1L) && (l2 != -1L)) {
          this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&lat=" + l1 + "&lon=" + l2);
        }
        Intent localIntent = new Intent();
        localIntent.setAction("start_recomend_page");
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.sendBroadcast(localIntent);
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("hide_left_button", true);
        localIntent.putExtra("show_right_close_button", true);
        localIntent.putExtra("finish_animation_up_down", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.overridePendingTransition(2130968592, 2130968589);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.finish();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */