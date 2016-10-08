import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qha
  extends Thread
{
  public qha()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    com.tencent.mobileqq.app.ThreadManager.d = true;
    QLog.i("TM.global", 2, "QQ Runtime ShutDown");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */