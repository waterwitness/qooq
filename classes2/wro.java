import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class wro
  extends Handler
{
  public wro(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (Bitmap)paramMessage.obj;
      } while (paramMessage == null);
      this.a.a.a("", "", paramMessage, true);
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    this.a.a.a("", paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */