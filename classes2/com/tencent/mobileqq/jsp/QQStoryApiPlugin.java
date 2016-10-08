package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryApiPlugin
  extends WebViewPlugin
{
  static final String a = QQStoryApiPlugin.class.getSimpleName();
  public static final String b = "story";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQStoryApiPlugin()
  {
    this.mPluginNameSpace = "story";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"story".equals(paramString2)) {}
    long l;
    do
    {
      return false;
      paramString1 = this.mRuntime.a();
      if (paramString3.equals("openIndex"))
      {
        paramString1.startActivity(new Intent(paramString1, QQStoryMainActivity.class));
        return true;
      }
      if (paramString3.equals("newStory"))
      {
        paramJsBridgeListener = new Intent(paramString1, QQStoryMainActivity.class);
        paramJsBridgeListener.putExtra("action", 1);
        paramString1.startActivity(paramJsBridgeListener);
        return true;
      }
      if (paramString3.equals("playStory"))
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("vid", "");
          l = paramString2.optLong("uin", 0L);
          if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (l > 0L))
          {
            paramString2 = new Intent(paramString1, JumpActivity.class);
            paramString2.setData(Uri.parse("mqqapi://qstory/openVideo?videoOwnerUin=" + l + "&videoId=" + paramJsBridgeListener));
            paramString1.startActivity(paramString2);
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w(a, 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
            }
          }
        }
        return true;
      }
    } while (!paramString3.equals("openLive"));
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      int i = paramJsBridgeListener.optInt("type", 0);
      l = paramJsBridgeListener.optLong("roomId", 0L);
      int j = paramJsBridgeListener.optInt("fromId", 0);
      paramJsBridgeListener = paramJsBridgeListener.optJSONObject("extras");
      if (i == 1)
      {
        paramString2 = new Intent(paramString1, JumpActivity.class);
        paramString3 = new StringBuilder().append("mqqapi://qstory/openNow?roomid=").append(l).append("&fromid=").append(j).append("&extras=");
        if (paramJsBridgeListener == null) {}
        for (paramJsBridgeListener = "";; paramJsBridgeListener = paramJsBridgeListener.toString())
        {
          paramString2.setData(Uri.parse(paramJsBridgeListener));
          paramString1.startActivity(paramString2);
          break;
        }
      }
      return true;
    }
    catch (JSONException paramJsBridgeListener) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\QQStoryApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */