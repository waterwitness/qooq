package com.tencent.mobileqq.vaswebviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class ThemeJsPlugin$2
  implements Runnable
{
  ThemeJsPlugin$2(ThemeJsPlugin paramThemeJsPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str1 = ThemeUtil.getThemePreferences(ThemeJsPlugin.access$000(this.this$0)).getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal userThemeStr=" + str1);
    }
    String str3 = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      Object localObject;
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject3 = new JSONObject();
        if ((str1 == null) || (str1.length() <= 0)) {
          break label488;
        }
        JSONObject localJSONObject4 = new JSONObject(str1);
        Iterator localIterator = localJSONObject4.keys();
        if (!localIterator.hasNext()) {
          break label488;
        }
        String str4 = String.valueOf(localIterator.next());
        JSONObject localJSONObject5 = localJSONObject4.getJSONObject(str4);
        i = localJSONObject5.getInt("downsize");
        int j = localJSONObject5.getInt("size");
        str1 = localJSONObject5.getString("status");
        if (j > 0)
        {
          i = (int)Math.floor(i * 1.0D / j * 100.0D);
          i = Math.min(100, i);
          if ((ThemeJsPlugin.access$200(this.this$0).containsKey(str4)) || (!str1.equals("2"))) {
            break label630;
          }
          localObject = ThemeUtil.getThemeInfo(ThemeJsPlugin.access$000(this.this$0), str4);
          if (localObject == null) {
            break label633;
          }
          if (!ThemeJsPlugin.access$300(this.this$0, ((ThemeUtil.ThemeInfo)localObject).themeId, ((ThemeUtil.ThemeInfo)localObject).version, ((ThemeUtil.ThemeInfo)localObject).size)) {
            break label476;
          }
          ((ThemeUtil.ThemeInfo)localObject).status = "3";
          ((ThemeUtil.ThemeInfo)localObject).downsize = ((ThemeUtil.ThemeInfo)localObject).size;
          i = 100;
          str1 = "3";
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "queryLocal, modify theme download status to " + ((ThemeUtil.ThemeInfo)localObject).status);
          }
          ThemeUtil.setThemeInfo(ThemeJsPlugin.access$000(this.this$0), (ThemeUtil.ThemeInfo)localObject);
          localObject = str1;
          if (str1.equals("5")) {
            localObject = "3";
          }
          localJSONObject5.put("progress", i);
          localJSONObject5.put("status", localObject);
          localJSONObject5.remove("downsize");
          localJSONObject5.remove("size");
          localJSONObject3.put(str4, localJSONObject5);
          continue;
        }
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ThemeJsPlugin", 1, "queryLocal Exception：" + localThrowable.getMessage());
        this.this$0.callJsOnError(this.val$callbackId, localThrowable.getMessage());
        this.this$0.reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.t, -35, "0", "");
        return;
      }
      continue;
      label476:
      ((ThemeUtil.ThemeInfo)localObject).status = "4";
      String str2 = "4";
      continue;
      label488:
      int i = ThemeUtil.getUinThemePreferences(ThemeJsPlugin.access$100(this.this$0)).getInt("stripUserTheme", 0);
      if (i != 0) {
        ThemeUtil.getUinThemePreferences(ThemeJsPlugin.access$100(this.this$0)).edit().remove("stripUserTheme").commit();
      }
      localJSONObject2.put("localInfo", localJSONObject3);
      localJSONObject2.put("currentId", str3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "ok");
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("authResult", i);
      this.this$0.callJs(this.val$callbackId, new String[] { localJSONObject1.toString() });
      return;
      label630:
      continue;
      label633:
      str2 = "4";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */