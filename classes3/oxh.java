import android.os.Message;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class oxh
  implements Runnable
{
  public oxh(RecentCallHelper paramRecentCallHelper, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Message localMessage = new Message();
    if (LightTalkTipsData.a() != null)
    {
      localMessage.what = 2;
      localMessage.obj = Integer.valueOf(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "showLightalkTipsIfNeed show : " + RecentCallHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper) + " num + " + this.jdField_a_of_type_Int + " fromResume " + this.jdField_a_of_type_Boolean);
      }
      return;
      if (RecentCallHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper)) {
        localMessage.what = 3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */