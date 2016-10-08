import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class yrq
  extends BroadcastReceiver
{
  public yrq(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      QzoneQunFeedJsPlugin.a(this.a, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */