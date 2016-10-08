import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class tft
  implements Runnable
{
  public tft(QQPlayerService paramQQPlayerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      QQPlayerService.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQPlayerService", 2, "initMediaPlayer", localThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */