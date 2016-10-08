import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jgu
  extends BroadcastReceiver
{
  public jgu(WebAIOController paramWebAIOController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.msg.newmessage".equals(paramIntent.getAction()))
    {
      WebAIOController.b = false;
      WebAIOController.c = true;
      this.a.b(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */