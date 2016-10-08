import android.os.Handler;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pyy
  implements Runnable
{
  public pyy(HotchatSCHelper paramHotchatSCHelper, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long - Math.abs(l1 - this.b);
    if (l2 < 0L) {
      l1 = 100L;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
      return;
      l1 = l2;
      if (l2 > this.jdField_a_of_type_Long) {
        l1 = this.jdField_a_of_type_Long;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */