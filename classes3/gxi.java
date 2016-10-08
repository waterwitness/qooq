import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gxi
  implements Handler.Callback
{
  public gxi(PSTNC2CActivity paramPSTNC2CActivity)
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
      if (!PSTNC2CActivity.a(this.a))
      {
        this.a.a.a().f = true;
        paramMessage = this.a.a.a();
        Intent localIntent = new Intent(paramMessage, PSTNC2CActivity.class);
        localIntent.setFlags(268566528);
        paramMessage.startActivity(localIntent);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */