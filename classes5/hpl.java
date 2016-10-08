import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hpl
  extends BroadcastReceiver
{
  public hpl(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */