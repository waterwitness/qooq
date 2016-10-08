package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QQWIFIPlugin$CampusWifiStateReceiver
  extends BroadcastReceiver
{
  public String callback;
  
  private QQWIFIPlugin$CampusWifiStateReceiver(QQWIFIPlugin paramQQWIFIPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (("campus_wifi_state_changed".equals(paramIntent.getAction())) && (!TextUtils.isEmpty(this.callback)))
      {
        int i = paramIntent.getIntExtra("state", -1);
        paramContext = new JSONObject();
        paramContext.put("state", i);
        paramContext = paramContext.toString();
        QLog.i("QQWIFIPlugin", 2, "state callback:" + this.callback + " jsonstring:" + paramContext);
        this.this$0.callJs(this.callback, new String[] { paramContext });
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWIFIPlugin", 2, "campus wifi state receive erro ", paramContext);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQWIFIPlugin$CampusWifiStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */