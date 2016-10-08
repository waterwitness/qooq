import android.os.Message;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CallTabLightalkConfig;
import mqq.os.MqqHandler;

public class oxk
  implements Runnable
{
  public oxk(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (CallTabLightalkConfig.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) != null) && (RecentCallHelper.a(this.a) != null) && (this.a.i))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.obj = Boolean.valueOf(true);
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */