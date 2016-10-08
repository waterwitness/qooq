import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.QzoneFamousSpaceWebViewLogic;

public class yrj
  extends BroadcastReceiver
{
  public yrj(QzoneFamousSpaceWebViewLogic paramQzoneFamousSpaceWebViewLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("NativeCallJsAction".equals(paramIntent.getAction().toString())) {
      this.a.a(paramIntent.getLongExtra("uin", 0L), paramIntent.getIntExtra("isconcern", -1));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */