package cooperation.dingdong.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OfficeAppsCenterJSPlugin$OfficeAppsCenterBCReceiver
  extends BroadcastReceiver
{
  protected OfficeAppsCenterJSPlugin$OfficeAppsCenterBCReceiver(OfficeAppsCenterJSPlugin paramOfficeAppsCenterJSPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("officeWebCallback"))) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OfficeAppsCenterJSPlugin", 2, "onReceive:" + paramContext);
      }
      for (;;)
      {
        try
        {
          paramContext = new JSONObject(paramContext);
          i = paramContext.optInt("reqCode", 0);
          if (i != 2) {
            break;
          }
          boolean bool = paramContext.optBoolean("isSuccess", false);
          paramIntent = paramContext.optString("callback");
          OfficeAppsCenterJSPlugin localOfficeAppsCenterJSPlugin = this.a;
          if (bool)
          {
            paramContext = "true";
            localOfficeAppsCenterJSPlugin.callJs(paramIntent, new String[] { paramContext });
            return;
          }
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        paramContext = "false";
      }
    } while (i != 1);
    paramContext.optBoolean("isSuccess", false);
    int i = paramContext.optInt("retValue", 1);
    paramContext = paramContext.optString("callback");
    this.a.callJs(paramContext, new String[] { "{\"retValue\":" + i + "}" });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\webviewplugin\OfficeAppsCenterJSPlugin$OfficeAppsCenterBCReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */