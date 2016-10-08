import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hma
  extends Handler
{
  public hma(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      this.a.R();
      return;
    case 1: 
      if (this.a.c)
      {
        this.a.i();
        this.a.J();
        return;
      }
      this.a.i();
      return;
    }
    paramMessage = new Intent();
    paramMessage.putExtra("isNeedFinish", true);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */