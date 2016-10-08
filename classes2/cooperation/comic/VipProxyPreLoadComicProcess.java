package cooperation.comic;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.webprocess.PreloadService.PreloadImpl;
import java.util.concurrent.atomic.AtomicInteger;
import yaj;

public class VipProxyPreLoadComicProcess
  extends PluginProxyBroadcastReceiver
{
  private static final String a = "VipProxyPreLoadComicProcess";
  
  public VipProxyPreLoadComicProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (paramIntent.getBooleanExtra("isPreloadProcess", false))
    {
      VipComicReportUtils.a.set(2);
      int i = paramIntent.getIntExtra("preloadEntry", 0);
      VipComicReportUtils.b.set(i);
    }
    ThreadManager.a(new yaj(this, paramContext), null, false);
    new PreloadService.PreloadImpl().a(paramContext, -9L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipProxyPreLoadComicProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */