import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hwt
  implements Runnable
{
  private WeakReference a;
  
  public hwt(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramReadInJoyFeedsActivity);
  }
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)((ReadInJoyFeedsActivity)this.a.get()).app.getManager(12);
      if (localWebProcessManager != null) {
        localWebProcessManager.a(1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "enter folder preload web process");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */