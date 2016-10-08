import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.SearchDataManager;
import java.util.List;
import mqq.os.MqqHandler;

public class oxw
  implements Runnable
{
  public oxw(RecentT9SearchActivity paramRecentT9SearchActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    List localList = SearchDataManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.app, RecentT9SearchActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity), this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.a.obtainMessage();
    localMessage.what = 10;
    localMessage.obj = localList;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentT9SearchActivity.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */