package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "IndividuationUIPlugin";
  RedTouch myIndividuationRedTouch;
  String path;
  RedTouchManager rtm;
  
  public IndividuationUIPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.path = "100005.100022";
    this.rtm = null;
  }
  
  private void onReportRed(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      new RedTouchManager(this.mRuntime.a()).b(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.ab = super.decodeUrl(this.activity.ab);
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationUIPlugin", 2, this.activity.ab);
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934593L == paramLong)
    {
      if (this.rtm == null) {
        this.rtm = new RedTouchManager(this.mRuntime.a());
      }
      paramString = this.rtm.a(this.path);
      this.myIndividuationRedTouch = new RedTouch(this.activity, this.activity.getRightTextView()).a(53).a();
      this.myIndividuationRedTouch.a(paramString);
      onReportRed(this.rtm.a(this.path), 1001);
      this.activity.setRightButton(2131367846, new IndividuationUIPlugin.1(this));
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 1048576L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\IndividuationUIPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */