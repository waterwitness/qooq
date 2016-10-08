import android.media.MediaPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;

public class tfu
  implements Runnable
{
  public tfu(QQPlayerService paramQQPlayerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQPlayerService.a() != null)
    {
      QQPlayerService.a().release();
      QQPlayerService.a(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */