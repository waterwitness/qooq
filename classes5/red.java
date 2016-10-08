import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class red
  implements Runnable
{
  public red(DatingTopListActivity paramDatingTopListActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.b.a(), 0);
    if (this.jdField_a_of_type_Boolean)
    {
      localSharedPreferences.edit().putInt("toplist_show_banner_times", 4).commit();
      DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).obtainMessage(8, 8, 0).sendToTarget();
      return;
    }
    int i = localSharedPreferences.getInt("toplist_show_banner_times", 1);
    localSharedPreferences.edit().putInt("toplist_show_banner_times", i + 1).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\red.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */