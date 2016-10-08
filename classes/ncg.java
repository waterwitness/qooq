import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

public final class ncg
  implements WebProcessManager.WebProcessStartListener
{
  public ncg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "preStart QWeb Process");
      }
      AIOOpenWebMonitor.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */