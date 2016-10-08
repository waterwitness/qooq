import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class oll
  implements Runnable
{
  public oll(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "WL_DEBUG updateTabCallNotify.run");
    }
    try
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).d();
      if (localRedTypeInfo != null) {
        localRedTypeInfo.red_type.set(0);
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(4);
      localMessage.obj = localRedTypeInfo;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MainAssistObserver", 2, "WL_DEBUG updateTabCallNotify.run error : " + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */