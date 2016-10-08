import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class syo
  extends BroadcastReceiver
{
  public syo(UiApiPlugin paramUiApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    label171:
    do
    {
      do
      {
        boolean bool;
        int k;
        do
        {
          int j;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  i = paramIntent.getIntExtra("mode", 0);
                  bool = paramIntent.getBooleanExtra("exclude", false);
                  j = paramIntent.getIntExtra("number", 0);
                  k = paramIntent.getIntExtra("sender", 0);
                  paramContext = this.a.mRuntime.a();
                } while ((paramContext == null) || (paramContext.isFinishing()));
                if (j <= 0) {
                  break label171;
                }
                if (k != this.a.e) {
                  break;
                }
              } while (bool);
              paramContext.finish();
              return;
              if ((this.a.e < k - j) || (this.a.e >= k)) {
                break;
              }
            } while ((i != 0) && (i != 2));
            paramContext.finish();
            return;
          } while ((this.a.e <= k) || (this.a.e > j + k) || ((i != 0) && (i != 1)));
          paramContext.finish();
          return;
          if (k != this.a.e) {
            break;
          }
        } while (bool);
        paramContext.finish();
        return;
        if (k <= this.a.e) {
          break;
        }
      } while ((i != 0) && (i != 2));
      paramContext.finish();
      return;
    } while ((i != 0) && (i != 1));
    paramContext.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */