package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import syd;

public class TroopApiPlugin
  extends WebViewPlugin
{
  public static final String a = "troopApi";
  protected static final String b = "openRewardDetail";
  protected static final String c = "previewRewardVideo";
  private static final String d = "createReward";
  private static final String e = "callback";
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public TroopApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.mPluginNameSpace = "troopApi";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troopApi".equals(paramString2)) {
      return false;
    }
    if ("createReward".equals(paramString3)) {}
    for (;;)
    {
      int i;
      try
      {
        this.mRuntime.a();
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString2 = paramJsBridgeListener.optString("callback");
        paramString3 = paramJsBridgeListener.optString("mediaID");
        i = paramJsBridgeListener.optInt("rewardType");
        j = paramJsBridgeListener.optInt("rewardMoney");
        paramString1 = paramJsBridgeListener.optString("rewardContent");
        paramVarArgs = paramJsBridgeListener.optString("gc");
        k = paramJsBridgeListener.optInt("imageMaxWidthPixels", 1080);
        m = paramJsBridgeListener.optInt("imageMaxHeightPixels", 1920);
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.isLogin()))
        {
          callJs(paramString2, new String[] { "{\"ret\":1, \"errMsg\":\"not login\"}" });
          return true;
        }
        paramJsBridgeListener = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          break label546;
        }
        paramJsBridgeListener = BaseApplicationImpl.a().getString(2131365285);
      }
      catch (JSONException paramJsBridgeListener)
      {
        int j;
        int k;
        int m;
        if (!QLog.isDevelopLevel()) {
          break label235;
        }
        QLog.d(this.TAG, 4, "payReward failed:" + paramJsBridgeListener);
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramVarArgs, j, paramJsBridgeListener, paramString3, i, k, m);
      callJs(paramString2, new String[] { "{\"ret\":0, \"errMsg\":\"ok\"}" });
      return true;
      label235:
      label546:
      do
      {
        for (;;)
        {
          return true;
          if ("openRewardDetail".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = this.mRuntime.a();
              paramString1 = new Intent(paramJsBridgeListener, TroopRewardDetailActivity.class);
              paramString2 = new TroopRewardInfo();
              paramString3 = new JSONObject(paramVarArgs[0]);
              paramString2.troopUin = paramString3.optString("troopUin");
              paramString2.rewardId = paramString3.optString("rewardId");
              paramString2.ownerUin = paramString3.optString("ownerUin");
              paramString2.type = paramString3.optInt("type");
              paramString2.msg = paramString3.optString("msg");
              paramString2.rewardFee = paramString3.optInt("rewardFee");
              paramString2.videoDuration = paramString3.optInt("videoDuration");
              paramString2.payMemberNum = paramString3.optInt("payMemberNum");
              paramString1.putExtra("rewardInfo", paramString2);
              paramJsBridgeListener.startActivity(paramString1);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isDevelopLevel()) {
              QLog.e(this.TAG, 4, "openRewardDetail, exception:", paramJsBridgeListener);
            }
          }
          else if ("previewRewardVideo".equals(paramString3))
          {
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "previewRewardVideo:" + paramString2);
              }
              paramJsBridgeListener = paramString2.optString("troopUin");
              paramString1 = paramString2.optString("rewardId");
              long l1 = paramString2.optLong("videoSize");
              long l2 = paramString2.optLong("videoDuration");
              paramString2 = paramString2.optString("callback");
              this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, new syd(this, l1, l2, paramString2));
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramJsBridgeListener);
            }
          }
        }
        if (i == 1) {
          break;
        }
      } while (i != 2);
    }
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\TroopApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */