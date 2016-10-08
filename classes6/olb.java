import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class olb
  implements Runnable
{
  public olb(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject2 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        }
      }
      if (localObject1 != null) {
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(0);
      ((Message)localObject2).obj = localObject1;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage((Message)localObject2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */