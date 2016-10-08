import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfv
  extends Thread
{
  public gfv(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(1600L);
      QAVNotification localQAVNotification = QAVNotification.a(this.a);
      if (localQAVNotification != null) {
        localQAVNotification.a();
      }
      this.a.e();
      if (QLog.isColorLevel()) {
        QLog.d(VideoAppInterface.a, 2, "force exit video process ...");
      }
      System.exit(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        System.exit(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */