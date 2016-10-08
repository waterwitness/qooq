import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;

public final class tgc
  extends Handler
{
  public tgc(QQPlayerService paramQQPlayerService, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQPlayerService.a(this.a, (Intent)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */