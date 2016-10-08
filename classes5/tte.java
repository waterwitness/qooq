import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;

public class tte
  extends BroadcastReceiver
{
  String a;
  
  public tte(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.b = PicPreDownloader.a;
      if (!a(paramContext))
      {
        PicPreDownloader.a = bool;
        label34:
        Logger.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.a + ",lastScreenOnState:" + PicPreDownloader.b);
        if ((PicPreDownloader.b != PicPreDownloader.a) || (PicPreDownloader.a)) {
          break label138;
        }
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        PicPreDownloader.b = PicPreDownloader.a;
        PicPreDownloader.a = false;
        break label34;
      }
      if (!"android.intent.action.USER_PRESENT".equals(paramIntent)) {
        break label34;
      }
      PicPreDownloader.b = PicPreDownloader.a;
      PicPreDownloader.a = true;
      break label34;
      try
      {
        label138:
        paramContext = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a);
        if (paramContext == null) {
          continue;
        }
        paramIntent = paramContext.a();
        paramContext = (ShortVideoPreDownloader)paramContext.getManager(94);
        if (paramIntent != null)
        {
          paramIntent.f();
          paramIntent.e();
        }
        if (paramContext == null) {
          continue;
        }
        paramContext.d();
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */