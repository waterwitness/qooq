import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqq
  implements Handler.Callback
{
  public gqq(CallbackWaitingActivityExt paramCallbackWaitingActivityExt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!CallbackWaitingActivityExt.a(this.a))
      {
        CallbackWaitingActivityExt.a(this.a).a().f = true;
        paramMessage = CallbackWaitingActivityExt.a(this.a).a();
        Intent localIntent = new Intent(paramMessage, PSTNC2CActivity.class);
        localIntent.setFlags(268566528);
        paramMessage.startActivity(localIntent);
        continue;
        CallbackWaitingActivityExt.b(this.a);
        this.a.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */