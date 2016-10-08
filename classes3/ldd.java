import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ldd
  implements Runnable
{
  ldd(ldc paramldc, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Ldc.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      this.jdField_a_of_type_Ldc.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (this.jdField_a_of_type_Ldc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ldc.a.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(24, localMessage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */