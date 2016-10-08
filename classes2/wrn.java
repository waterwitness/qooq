import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;

public class wrn
  extends Handler
{
  public wrn(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
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
        do
        {
          return;
          paramMessage = (Bitmap)paramMessage.obj;
        } while (paramMessage == null);
        paramMessage = AuthorityUtil.a(this.a, paramMessage, 50, 50);
        localMessage = Message.obtain();
        localMessage.what = 1002;
        localMessage.obj = paramMessage;
        this.a.b.sendMessage(localMessage);
        return;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      paramMessage = AuthorityActivity.a(paramMessage);
    } while (paramMessage == null);
    Message localMessage = Message.obtain();
    localMessage.what = 1003;
    localMessage.obj = paramMessage;
    this.a.b.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */