package com.tencent.mobileqq.troopreward;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import org.json.JSONException;
import org.json.JSONObject;
import vwd;

public class TroopRewardPayActivity
  extends AbsBaseWebViewActivity
{
  public static final String a = "http://pay.qq.com/h5sdk/proxy.shtml?payParams=%s";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  boolean jdField_a_of_type_Boolean;
  
  public TroopRewardPayActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vwd(this);
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject1.put("buyInfo", localJSONObject2);
      localJSONObject2.put("appid", paramString1);
      localJSONObject2.put("zoneid", 1);
      localJSONObject2.put("pf", paramString3);
      localJSONObject2.put("goodstokenurl", paramString2);
      localJSONObject2.put("openid", this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
      localJSONObject2.put("openkey", paramString4);
      paramString1 = new JSONObject();
      paramString1.put("hide_ui", 1);
      paramString1.put("https", false);
      localJSONObject1.put("opt", paramString1);
      paramString2 = new JSONObject();
      paramString2.put("from_native", 1);
      paramString2.put("direct_pay_channel", "qqwallet");
      paramString3 = new StringBuilder().append("appid#");
      paramString1 = paramString5;
      if (TextUtils.isEmpty(paramString5)) {
        paramString1 = "200000021";
      }
      paramString2.put("mqq_appinfo", paramString1 + "|channel#aio");
      localJSONObject1.put("params", paramString2);
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return localJSONObject1.toString();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.a(0);
      this.mSystemBarComp.b(0);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
    this.jdField_a_of_type_AndroidViewViewGroup = new RelativeLayout(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.titleRoot.setVisibility(4);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.a(0);
      this.mSystemBarComp.b(0);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = b(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      String str = getIntent().getStringExtra("urlParams");
      str = String.format("http://pay.qq.com/h5sdk/proxy.shtml?payParams=%s", new Object[] { URLUtil.a(a(getIntent().getStringExtra("appId"), str, getIntent().getStringExtra("pf"), getIntent().getStringExtra("skey"), getIntent().getStringExtra("qun_appid"))) });
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\TroopRewardPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */