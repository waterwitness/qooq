package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class QQWIFIPlugin$WifiScanResultReceiver$1
  implements Runnable
{
  QQWIFIPlugin$WifiScanResultReceiver$1(QQWIFIPlugin.WifiScanResultReceiver paramWifiScanResultReceiver, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      synchronized (QQWIFIPlugin.access$200(this.this$1.this$0))
      {
        try
        {
          QQWIFIPlugin.WifiScanResultReceiver.access$302(this.this$1, System.currentTimeMillis());
          Object localObject1 = ((WifiManager)this.val$context.getSystemService("wifi")).getScanResults();
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label318;
          }
          localObject3 = (ScanResult)((Iterator)localObject1).next();
          if (!this.this$1.ssid.equals(((ScanResult)localObject3).SSID)) {
            continue;
          }
          localObject1 = ((ScanResult)localObject3).BSSID;
          localObject3 = new JSONObject();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          int i = QQWIFIPlugin.checkSpecifiedBssidLevel((String)localObject1, this.val$context);
          ((JSONObject)localObject3).put("hasCampusWifi", 1);
          ((JSONObject)localObject3).put("bssid", localObject1);
          ((JSONObject)localObject3).put("level", i);
          localObject1 = ((JSONObject)localObject3).toString();
          if (QLog.isColorLevel()) {
            QLog.i("QQWIFIPlugin", 2, "query callback:" + this.this$1.callback + " jsonstring:" + (String)localObject1);
          }
          this.this$1.this$0.callJs(this.this$1.callback, new String[] { localObject1 });
          this.this$1.callback = "";
          if (QQWIFIPlugin.access$400(this.this$1.this$0) != null) {
            this.this$1.this$0.mRuntime.a().unregisterReceiver(QQWIFIPlugin.access$400(this.this$1.this$0));
          }
        }
        catch (Exception localException)
        {
          Object localObject3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("QQWIFIPlugin", 2, "receive erro", localException);
          continue;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.i("QQWIFIPlugin", 2, "bssid is empty");
        }
        ((JSONObject)localObject3).put("hasCampusWifi", 2);
      }
      label318:
      String str = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQWIFIPlugin$WifiScanResultReceiver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */