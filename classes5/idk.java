import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class idk
  implements Runnable
{
  public idk(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.app.getManager(12);
    if (localWebProcessManager != null) {
      localWebProcessManager.a(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(SubscriptFeedsActivity.a(), 2, "enter folder preload web process");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */