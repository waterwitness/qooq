import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class quj
  extends Handler
{
  private QQAnimationDrawable a;
  
  public quj(QQAnimationDrawable paramQQAnimationDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAnimationDrawable;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof Long)) {
      this.a.scheduleSelf(this.a, ((Long)paramMessage.obj).longValue());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\quj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */