package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ColorRingJsPlugin$1
  implements Runnable
{
  ColorRingJsPlugin$1(ColorRingJsPlugin paramColorRingJsPlugin, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject;
      ExtensionInfo localExtensionInfo;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (ColorRingJsPlugin.access$000(this.this$0) != null)
        {
          localObject = ColorRingJsPlugin.access$000(this.this$0).a(null).createEntityManager();
          localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).a(ExtensionInfo.class, ColorRingJsPlugin.access$000(this.this$0).getAccount());
          ((EntityManager)localObject).a();
          localJSONObject.put("result", 0);
          localObject = new JSONObject();
          if (localExtensionInfo == null)
          {
            ((JSONObject)localObject).put("currentId", 0);
            localJSONObject.put("data", localObject);
          }
        }
        else
        {
          ColorRingJsPlugin.access$100(this.this$0).runOnUiThread(new ColorRingJsPlugin.1.1(this, localJSONObject));
          return;
        }
        if (this.val$type.equals("colorring"))
        {
          ((JSONObject)localObject).put("currentId", localExtensionInfo.colorRingId);
          continue;
        }
        String str;
        if (!this.val$type.equals("comering")) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        str = localJSONException.getMessage();
        ColorRingJsPlugin.access$100(this.this$0).runOnUiThread(new ColorRingJsPlugin.1.2(this, str));
        return;
      }
      ((JSONObject)localObject).put("currentId", localExtensionInfo.commingRingId);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ColorRingJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */