package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "apollo";
  private static final int DEFAULT_HEIGHT = (int)(DeviceInfoUtil.k() * 0.4D / DeviceInfoUtil.a());
  private static final int DEFAULT_WIDTH;
  private static final String FAKE_CALLBACK_ID = "FAKE_CALLBACK_ID";
  public static final int INITFROM_GETLOCALINFO = 3;
  public static final int INITFROM_GETROLE = 2;
  public static final int INITFROM_GETSWITCH = 4;
  public static final String TAG = "ApolloJsPlugin";
  public static int sResponseKey;
  private static int sRoleGender;
  private int mApolloStatus;
  private String mCurrentUin;
  private boolean mDataInited;
  private int[] mDressIds;
  public Bundle mReqBundle;
  private int mRoleId = -1;
  private String mTab;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    DEFAULT_WIDTH = (int)((float)(DeviceInfoUtil.j() >> 1) / DeviceInfoUtil.a());
  }
  
  public ApolloJsPlugin()
  {
    this.mPluginNameSpace = "apollo";
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString1 + " errorMsg" + paramString2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, localException.getMessage());
        }
      }
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      super.callJs(paramString + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString.getMessage());
    }
  }
  
  boolean checkSdcard(Context paramContext)
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(paramContext, "请安装存储卡后再使用", 0).a();
      return false;
    }
    return true;
  }
  
  public int getRemoteKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"apollo".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramVarArgs = null;
    for (;;)
    {
      try
      {
        i = paramString1.indexOf("=");
        if ((i != -1) && (i + 1 <= paramString1.length() - 1)) {
          continue;
        }
        paramJsBridgeListener = new JSONObject();
        paramString2 = paramJsBridgeListener.optString("callback");
        if (paramString2 != null) {
          continue;
        }
        try
        {
          throw new Exception("need callbackId");
        }
        catch (Throwable paramJsBridgeListener)
        {
          paramString1 = paramString2;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        int j;
        paramString1 = paramVarArgs;
        continue;
        i += 1;
        continue;
        boolean bool1 = false;
        continue;
        j += 1;
        continue;
        int i = 0;
        continue;
        i = 2;
        continue;
        bool1 = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ApolloJsPlugin", 2, paramJsBridgeListener.getMessage());
      }
      try
      {
        paramString2 = new JSONObject();
        paramString2.put("result", 1);
        paramString2.put("msg", paramJsBridgeListener.getMessage());
        super.callJs(paramString1 + "(" + paramString2.toString() + ");");
        return true;
        paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 2, "json:" + paramJsBridgeListener);
        }
        Activity localActivity = this.mRuntime.a();
        if ((localActivity == null) || (this.isDestroy) || (localActivity.isFinishing()))
        {
          callbackError(paramString2, "当前页面已经销毁或非商城页面");
          return true;
        }
        if ("openApolloShareFloatView".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("backgroundImage");
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            ((IApolloActivityJsCallBack)localActivity).a(paramJsBridgeListener);
            continue;
          }
          callbackError(paramString2, "非商城界面");
          continue;
        }
        if ("openDiyActionFloatView".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("defaultText");
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            ((IApolloActivityJsCallBack)localActivity).a(paramJsBridgeListener);
            continue;
          }
          callbackError(paramString2, "非商城界面");
          continue;
        }
        if ("sayHi".equals(paramString3))
        {
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            paramJsBridgeListener = ((IApolloActivityJsCallBack)localActivity).b();
            super.callJs(paramString2 + "(" + paramJsBridgeListener + ");");
            continue;
          }
          callbackError(paramString2, "非商城界面");
          continue;
        }
        if ("openBox".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("uin");
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            paramJsBridgeListener = ((IApolloActivityJsCallBack)localActivity).a(paramJsBridgeListener);
            super.callJs(paramString2 + "(" + paramJsBridgeListener + ");");
            continue;
          }
          callbackError(paramString2, "非商城界面");
          continue;
        }
        int k;
        int m;
        if ("initAvatar".equals(paramString3))
        {
          if (!ApolloStoreActivity.class.isInstance(localActivity))
          {
            ApolloUtil.a(localActivity, null, "share");
            ThreadManager.b().postDelayed(new ApolloJsPlugin.1(this, localActivity), 2000L);
          }
          j = paramJsBridgeListener.optInt("type");
          k = paramJsBridgeListener.optInt("x", DEFAULT_WIDTH);
          m = paramJsBridgeListener.optInt("y", DEFAULT_HEIGHT);
          this.mTab = paramJsBridgeListener.optString("tab");
          float f = (float)paramJsBridgeListener.optDouble("rate", 0.0D);
          paramVarArgs = paramJsBridgeListener.optString("uin");
          paramString3 = this.mRuntime.a().a();
          paramString1 = paramVarArgs;
          if (TextUtils.isEmpty(paramVarArgs)) {
            paramString1 = paramString3;
          }
          this.mCurrentUin = paramString1;
          int n = paramJsBridgeListener.optInt("roleId");
          paramVarArgs = null;
          JSONArray localJSONArray = paramJsBridgeListener.optJSONArray("dressIds");
          paramJsBridgeListener = paramVarArgs;
          int i1;
          if (localJSONArray != null)
          {
            paramJsBridgeListener = paramVarArgs;
            if (localJSONArray.length() > 0)
            {
              i1 = localJSONArray.length();
              paramVarArgs = new int[i1];
              i = 0;
              if (i < i1)
              {
                paramVarArgs[i] = localJSONArray.getInt(i);
                i += 1;
                continue;
              }
              paramJsBridgeListener = paramVarArgs;
              if (this.mCurrentUin.equals(paramString3))
              {
                this.mRoleId = n;
                this.mDressIds = paramVarArgs;
                paramJsBridgeListener = paramVarArgs;
              }
            }
          }
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            paramString3 = (IApolloActivityJsCallBack)localActivity;
            bool1 = false;
            boolean bool2 = bool1;
            if (n > 0)
            {
              bool2 = bool1;
              if (paramJsBridgeListener != null)
              {
                bool2 = bool1;
                if (localJSONArray.length() > 0)
                {
                  bool1 = ApolloUtil.c(n);
                  i1 = paramJsBridgeListener.length;
                  i = 0;
                  bool2 = bool1;
                  if (i < i1)
                  {
                    int i2 = paramJsBridgeListener[i];
                    if ((!bool1) || (!ApolloUtil.b(i2))) {
                      continue;
                    }
                    bool1 = true;
                    continue;
                  }
                }
              }
            }
            if (!bool2)
            {
              this.mReqBundle.clear();
              this.mReqBundle.putIntArray("apollo_dressIds", paramJsBridgeListener);
              this.mReqBundle.putInt("apollo_roleId", n);
              this.mReqBundle.putInt("apollo_x", k);
              this.mReqBundle.putInt("apollo_y", m);
              this.mReqBundle.putInt("apollo_type", j);
              this.mReqBundle.putFloat("apollo_rate", f);
              this.mReqBundle.putString("apollo_uin", paramString1);
              super.sendRemoteReq(DataFactory.a("ipc_apollo_initavatar", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
              paramString3.a(true, k, m);
              continue;
            }
            paramJsBridgeListener = paramString3.a(f, j, this.mApolloStatus, k, m, n, paramJsBridgeListener, paramString1, this.mTab);
            super.callJs(paramString2 + "(" + paramJsBridgeListener + ");");
            continue;
          }
          callbackError(paramString2, "非商城页面");
          continue;
        }
        if ("getRoleId".equals(paramString3))
        {
          if (!this.mDataInited)
          {
            this.mReqBundle.clear();
            this.mReqBundle.putInt("apollo_initFrom", 2);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return true;
          }
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("msg", "");
          paramString1 = new JSONObject();
          paramString1.put("roleId", this.mRoleId);
          paramJsBridgeListener.put("data", paramString1);
          super.callJs(paramString2 + "(" + paramJsBridgeListener.toString() + ");");
          continue;
        }
        if ("getLocalInfo".equals(paramString3))
        {
          if (!this.mDataInited)
          {
            this.mReqBundle.clear();
            this.mReqBundle.putInt("apollo_initFrom", 3);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return true;
          }
          if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
          {
            callbackError(paramString2, "默认角色或获取本人信息失败");
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
            continue;
          }
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("msg", "");
          paramString1 = new JSONObject();
          paramString3 = new JSONArray();
          paramVarArgs = this.mDressIds;
          j = paramVarArgs.length;
          i = 0;
          if (i < j)
          {
            paramString3.put(Integer.valueOf(paramVarArgs[i]));
            i += 1;
            continue;
          }
          paramString1.put("dressIds", paramString3);
          paramJsBridgeListener.put("data", paramString1);
          super.callJs(paramString2 + "(" + paramJsBridgeListener.toString() + ");");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloJsPlugin", 2, "array->" + paramString3);
          continue;
        }
        if ("preview".equals(paramString3))
        {
          if (!checkSdcard(localActivity))
          {
            callbackError(paramString2, "sdcard未装");
            return true;
          }
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            paramJsBridgeListener = paramJsBridgeListener.optJSONArray("dressIds");
            if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
            {
              j = paramJsBridgeListener.length();
              paramString1 = new int[j];
              i = 0;
              if (i < j)
              {
                paramString1[i] = paramJsBridgeListener.getInt(i);
                i += 1;
                continue;
              }
              k = paramString1.length;
              i = 1;
              j = 0;
              if (j < k)
              {
                m = paramString1[j];
                if ((i == 0) || (!ApolloUtil.b(m))) {
                  continue;
                }
                i = 1;
                continue;
              }
              if (i != 0)
              {
                paramJsBridgeListener = ((IApolloActivityJsCallBack)localActivity).a(paramString1);
                super.callJs(paramString2 + "(" + paramJsBridgeListener + ");");
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString2 + " callbackOk" + paramJsBridgeListener);
                continue;
              }
              this.mReqBundle.clear();
              this.mReqBundle.putIntArray("apollo_dressIds", paramString1);
              super.sendRemoteReq(DataFactory.a("ipc_apollo_preview", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
              continue;
            }
            callbackError(paramString2, "dressIds为空");
            continue;
          }
          callbackError(paramString2, "非商城页面");
          continue;
        }
        if ("previewAction".equals(paramString3))
        {
          if (!checkSdcard(localActivity))
          {
            callbackError(paramString2, "sdcard未装");
            return true;
          }
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            i = paramJsBridgeListener.optInt("actionId");
            j = paramJsBridgeListener.optInt("type");
            k = paramJsBridgeListener.optInt("isSpecial");
            this.mReqBundle.clear();
            this.mReqBundle.putInt("apollo_previewAction", i);
            paramString1 = this.mReqBundle;
            if (sRoleGender != 2) {
              continue;
            }
            i = 1;
            paramString1.putInt("apollo_partnerRoleId", i);
            this.mReqBundle.putInt("apollo_type", j);
            this.mReqBundle.putInt("apollo_isSpecial", k);
            this.mReqBundle.putString("apollo_json", paramJsBridgeListener.toString());
            super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
            continue;
          }
          callbackError(paramString2, "非商城页面");
          continue;
        }
        if ("setup".equals(paramString3))
        {
          paramString1 = paramJsBridgeListener.optJSONArray("dressIds");
          if ((paramString1 != null) && (paramString1.length() > 0))
          {
            j = paramString1.length();
            this.mDressIds = new int[j];
            i = 0;
            if (i < j)
            {
              this.mDressIds[i] = paramString1.getInt(i);
              i += 1;
              continue;
            }
          }
          if ((localActivity instanceof IApolloActivityJsCallBack))
          {
            this.mApolloStatus = 1;
            ((IApolloActivityJsCallBack)localActivity).a(this.mRoleId, this.mDressIds);
            callbackOk(paramString2);
            this.mReqBundle.clear();
            paramJsBridgeListener = paramJsBridgeListener.optString("userData");
            this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_setup", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            continue;
          }
          callbackError(paramString2, "非商城页面");
          continue;
        }
        if ("changeRole".equals(paramString3))
        {
          if (!checkSdcard(localActivity))
          {
            callbackError(paramString2, "sdcard未装");
            return true;
          }
          j = paramJsBridgeListener.getInt("roleId");
          if (j > 0) {
            this.mRoleId = j;
          }
          paramString1 = paramJsBridgeListener.optJSONArray("dressIds");
          if ((j > 0) && (paramString1 != null) && (paramString1.length() > 0))
          {
            k = paramString1.length();
            this.mDressIds = new int[k];
            i = 0;
            if (i < k)
            {
              this.mDressIds[i] = paramString1.getInt(i);
              i += 1;
              continue;
            }
            paramJsBridgeListener = paramJsBridgeListener.optString("userData");
            sRoleGender = new JSONObject(paramJsBridgeListener).optInt("sex");
            this.mRoleId = j;
            this.mReqBundle.clear();
            this.mReqBundle.putIntArray("apollo_dressIds", this.mDressIds);
            this.mReqBundle.putInt("apollo_roleId", this.mRoleId);
            this.mReqBundle.putInt("apollo_fromSelf", 0);
            this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_changerole", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
            continue;
          }
          callbackError(paramString2, "roleId 或 dressIds 为空");
          continue;
        }
        if ("closeWebview".equals(paramString3))
        {
          localActivity.finish();
          if (!(localActivity instanceof ApolloStoreActivity)) {
            localActivity.overridePendingTransition(0, 0);
          }
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("msg", "");
          super.callJs(paramString2 + "(" + paramJsBridgeListener.toString() + ");");
          continue;
        }
        if ("getSwitch".equals(paramString3))
        {
          if (!this.mDataInited)
          {
            this.mReqBundle.clear();
            this.mReqBundle.putInt("apollo_initFrom", 4);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return true;
          }
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("msg", "");
          paramString1 = new JSONObject();
          paramString1.put("status", this.mApolloStatus);
          paramJsBridgeListener.put("data", paramString1);
          super.callJs(paramString2 + "(" + paramJsBridgeListener.toString() + ");");
          continue;
        }
        if ("openFloatTransparentView".equals(paramString3))
        {
          if (localActivity != null)
          {
            paramString1 = paramJsBridgeListener.getString("url");
            i = paramJsBridgeListener.getInt("closeBtn");
            paramJsBridgeListener = new Intent(localActivity, ApolloFloatActivity.class);
            paramJsBridgeListener.putExtra("extra_key_click_time", System.currentTimeMillis());
            paramJsBridgeListener.putExtra("extra_key_weburl", paramString1);
            if (i != 1) {
              continue;
            }
            bool1 = true;
            paramJsBridgeListener.putExtra("extra_key_close_btn", bool1);
            localActivity.startActivity(paramJsBridgeListener);
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            paramJsBridgeListener.put("msg", "");
            super.callJs(paramString2 + "(" + paramJsBridgeListener.toString() + ");");
            continue;
          }
          callbackError(paramString2, "当前页面已经销毁或非商城页面");
          continue;
        }
        if ("openApolloShow".equals(paramString3))
        {
          paramString1 = paramJsBridgeListener.optString("nick");
          paramJsBridgeListener = paramJsBridgeListener.optString("uin");
          paramString3 = new Intent(localActivity, ApolloGuestsStateActivity.class);
          paramString3.putExtra("extra_guest_nick", paramString1);
          paramString3.putExtra("extra_guest_uin", paramJsBridgeListener);
          localActivity.startActivity(paramString3);
          localActivity.overridePendingTransition(0, 0);
          callbackOk(paramString2);
          continue;
        }
        if ("getFriendsByOpenApollo".equals(paramString3))
        {
          this.mReqBundle.clear();
          super.sendRemoteReq(DataFactory.a("ipc_apollo_get_openapollo_friends", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          continue;
        }
        if ("sendActionToFrd".equals(paramString3))
        {
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putInt("forward_type", 26);
          paramString1 = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
          paramString1.addFlags(268435456);
          paramString1.addFlags(67108864);
          paramString1.putExtras(paramJsBridgeListener);
          this.mRuntime.a().startActivity(paramString1);
          continue;
        }
        if ("refreshAction".equals(paramString3))
        {
          this.mReqBundle.clear();
          super.sendRemoteReq(DataFactory.a("ipc_apollo_refresh_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call refreshAction");
          continue;
        }
        if ("getLocalFavAction".equals(paramString3))
        {
          this.mReqBundle.clear();
          super.sendRemoteReq(DataFactory.a("ipc_apollo_getfav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call getLocalFavAction");
          continue;
        }
        if ("addCustomAction".equals(paramString3))
        {
          this.mReqBundle.clear();
          i = paramJsBridgeListener.optInt("actionId");
          j = paramJsBridgeListener.optInt("textType");
          paramJsBridgeListener = paramJsBridgeListener.optString("actionText");
          this.mReqBundle.putInt("actionId", i);
          this.mReqBundle.putString("actionText", paramJsBridgeListener);
          this.mReqBundle.putInt("textType", j);
          super.sendRemoteReq(DataFactory.a("ipc_apollo_add_fav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call addCustomAction");
          continue;
        }
        if (!"delLocalFavAction".equals(paramString3)) {
          continue;
        }
        this.mReqBundle.clear();
        this.mReqBundle.putString("delJson", paramJsBridgeListener.opt("favActionDel").toString());
        super.sendRemoteReq(DataFactory.a("ipc_apollo_del_fav_list", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call delLocalFavList");
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloJsPlugin", 2, paramJsBridgeListener.getMessage());
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    sResponseKey = this.mOnRemoteResp.key;
    if ((this.mRuntime.a() instanceof IApolloActivityJsCallBack))
    {
      super.sendRemoteReq(DataFactory.a("ipc_apollo_check_action", "", this.mOnRemoteResp.key, this.mReqBundle), false, true);
      this.mReqBundle.clear();
      this.mReqBundle.putInt("apollo_initFrom", 3);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", "FAKE_CALLBACK_ID", this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject3;
    String str1;
    Object localObject1;
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject3 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject1 = paramBundle.getBundle("response");
      if ((localObject3 != null) && (localObject1 != null))
      {
        localObject2 = this.mRuntime.a();
        if ((localObject2 != null) && (!this.isDestroy) && (!((Activity)localObject2).isFinishing())) {
          break label95;
        }
        callbackError(str1, "当前页面已经销毁或非商城页面");
      }
    }
    for (;;)
    {
      return;
      try
      {
        label95:
        if (!"ipc_apollo_preview".equals(localObject3)) {
          break label275;
        }
        if (!(localObject2 instanceof IApolloActivityJsCallBack)) {
          break label265;
        }
        paramBundle = (IApolloActivityJsCallBack)localObject2;
        localObject2 = ((Bundle)localObject1).getIntArray("apollo_dressIds");
        if ((((Bundle)localObject1).getInt("apollo_result") == 0) && (localObject2 != null))
        {
          paramBundle = paramBundle.a((int[])localObject2);
          super.callJs(str1 + "(" + paramBundle + ");");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ApolloJsPlugin", 2, "callbackId->" + str1 + " callbackOk" + paramBundle);
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, paramBundle.getMessage());
        }
        callbackError(str1, "调用失败");
        return;
      }
      callbackError(str1, "参数不对，未下载成功");
      return;
      label265:
      callbackError(str1, "非商城页面");
      return;
      label275:
      int i;
      int j;
      int k;
      int m;
      int n;
      if ("ipc_apollo_preview_action".equals(localObject3))
      {
        if ((localObject2 instanceof IApolloActivityJsCallBack))
        {
          paramBundle = (IApolloActivityJsCallBack)localObject2;
          i = ((Bundle)localObject1).getInt("apollo_previewAction");
          j = ((Bundle)localObject1).getInt("apollo_apolloVipFlag");
          k = ((Bundle)localObject1).getInt("apollo_apolloVipLevel");
          localObject3 = new JSONObject(((Bundle)localObject1).getString("apollo_json"));
          m = ((JSONObject)localObject3).optInt("type");
          n = ((JSONObject)localObject3).optInt("isSpecial");
          int i1 = ((JSONObject)localObject3).optInt("vipLevel");
          int i2 = ((JSONObject)localObject3).optInt("feeType");
          int i3 = ((JSONObject)localObject3).optInt("isDiyAction");
          int i4 = ((JSONObject)localObject3).optInt("textType");
          localObject2 = ((JSONObject)localObject3).optString("text");
          localObject3 = ((JSONObject)localObject3).optString("animationName");
          int i5 = ((Bundle)localObject1).getInt("apollo_result");
          int i6 = ((Bundle)localObject1).getInt("apollo_partnerRoleId");
          if ((i5 == 0) && (i > 0))
          {
            paramBundle = paramBundle.a(i, m, n, i1, j, k, (String)localObject3, i2, i6, i3, i4, (String)localObject2);
            super.callJs(str1 + "(" + paramBundle + ");");
            if (QLog.isColorLevel()) {
              QLog.e("ApolloJsPlugin", 2, "callbackId->" + str1 + " callbackOk" + paramBundle);
            }
          }
          else
          {
            callbackError(str1, "参数不对，未下载成功");
          }
        }
        else
        {
          callbackError(str1, "非商城页面");
        }
      }
      else if ("ipc_apollo_initavatar".equals(localObject3))
      {
        if ((localObject2 instanceof IApolloActivityJsCallBack))
        {
          localObject3 = (IApolloActivityJsCallBack)localObject2;
          i = ((Bundle)localObject1).getInt("apollo_result");
          j = ((Bundle)localObject1).getInt("apollo_x", DEFAULT_WIDTH);
          k = ((Bundle)localObject1).getInt("apollo_y", DEFAULT_HEIGHT);
          m = ((Bundle)localObject1).getInt("apollo_type");
          n = ((Bundle)localObject1).getInt("apollo_roleId");
          float f = ((Bundle)localObject1).getFloat("apollo_rate");
          String str2 = ((Bundle)localObject1).getString("apollo_uin");
          if ((this.mCurrentUin == null) || (this.mCurrentUin.equals(str2)))
          {
            localObject1 = ((Bundle)localObject1).getIntArray("apollo_dressIds");
            if (i == 0)
            {
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (localObject1.length > 0) {}
              }
              else
              {
                paramBundle = ApolloResDownloader.a(n);
              }
              paramBundle = ((IApolloActivityJsCallBack)localObject3).a(f, m, this.mApolloStatus, j, k, n, paramBundle, str2, this.mTab);
              super.callJs(str1 + "(" + paramBundle + ");");
              return;
            }
            QQToast.a((Context)localObject2, "下载素材角色装扮素材失败", 1).a();
            callbackError(str1, "下载素材角色装扮素材失败");
            if (QLog.isColorLevel()) {
              QLog.d("ApolloJsPlugin", 2, "下载素材角色装扮素材失败->mRoleId" + this.mRoleId + " mDressIds->" + this.mDressIds);
            }
          }
        }
      }
      else
      {
        if ("ipc_apollo_changerole".equals(localObject3))
        {
          i = ((Bundle)localObject1).getInt("apollo_result");
          j = ((Bundle)localObject1).getInt("apollo_roleId");
          localObject1 = ((Bundle)localObject1).getIntArray("apollo_dressIds");
          if (localObject1 != null)
          {
            paramBundle = (Bundle)localObject1;
            if (localObject1.length > 0) {}
          }
          else
          {
            paramBundle = ApolloResDownloader.a(j);
          }
          this.mDressIds = paramBundle;
          this.mRoleId = j;
          this.mApolloStatus = 1;
          if ((i == 0) && (paramBundle != null) && (paramBundle.length > 0))
          {
            callbackOk(str1);
            return;
          }
          callbackError(str1, "参数不对，未下载成功");
          return;
        }
        if ("ipc_apollo_get_apollo_data".equals(localObject3))
        {
          this.mDataInited = true;
          i = ((Bundle)localObject1).getInt("apollo_initFrom");
          this.mRoleId = ((Bundle)localObject1).getInt("apollo_roleId");
          j = ((Bundle)localObject1).getInt("apollo_gender");
          this.mApolloStatus = ((Bundle)localObject1).getInt("apollo_apolloStatus");
          this.mDressIds = ((Bundle)localObject1).getIntArray("apollo_dressIds");
          sRoleGender = ((Bundle)localObject1).getInt("apollo_roleGender");
          if ("FAKE_CALLBACK_ID".equals(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloJsPlugin", 2, "初始化个人信息，不用callback");
            }
            if ((localObject2 instanceof IApolloActivityJsCallBack)) {
              ((IApolloActivityJsCallBack)localObject2).c(this.mApolloStatus);
            }
          }
          else
          {
            if (this.mRoleId <= 0)
            {
              if ((j != 1) && (j != 0)) {
                break label1148;
              }
              this.mRoleId = 1;
            }
            for (;;)
            {
              if (3 == i)
              {
                if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                {
                  callbackError(str1, "默认角色或获取本人信息失败");
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                  return;
                  label1148:
                  this.mRoleId = 2;
                  continue;
                }
                paramBundle = new JSONObject();
                paramBundle.put("result", 0);
                paramBundle.put("msg", "");
                localObject1 = new JSONObject();
                localObject2 = new JSONArray();
                localObject3 = this.mDressIds;
                j = localObject3.length;
                i = 0;
                while (i < j)
                {
                  ((JSONArray)localObject2).put(Integer.valueOf(localObject3[i]));
                  i += 1;
                }
                ((JSONObject)localObject1).put("dressIds", localObject2);
                paramBundle.put("data", localObject1);
                super.callJs(str1 + "(" + paramBundle.toString() + ");");
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloJsPlugin", 2, "dressIds.array->" + localObject2);
                return;
              }
            }
            if (2 == i)
            {
              if (this.mRoleId <= 0)
              {
                callbackError(str1, "默认角色或获取本人信息失败");
                return;
              }
              paramBundle = new JSONObject();
              paramBundle.put("result", 0);
              paramBundle.put("msg", "");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("roleId", this.mRoleId);
              paramBundle.put("data", localObject1);
              super.callJs(str1 + "(" + paramBundle.toString() + ");");
              return;
            }
            if (4 == i)
            {
              paramBundle = new JSONObject();
              paramBundle.put("result", 0);
              paramBundle.put("msg", "");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("status", this.mApolloStatus);
              paramBundle.put("data", localObject1);
              super.callJs(str1 + "(" + paramBundle.toString() + ");");
            }
          }
        }
        else if ("ipc_apollo_get_openapollo_friends".equals(localObject3))
        {
          i = ((Bundle)localObject1).getInt("apollo_result");
          paramBundle = ((Bundle)localObject1).getString("apollo_data");
          if (i == 0)
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("result", 0);
            ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
            super.callJs(str1 + "(" + ((JSONObject)localObject1).toString() + ");");
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS onResponse dataStr is:" + paramBundle);
            return;
            callbackError(str1, "数据为空或查询数据有误");
          }
        }
        else if ("ipc_apollo_query_mine_redinfo".equals(localObject3))
        {
          i = ((Bundle)localObject1).getInt("isNewFlag");
          if ((i == 1) && ((localObject2 instanceof IApolloActivityJsCallBack))) {
            ((IApolloActivityJsCallBack)localObject2).b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_QUERY_MINE_REDINFO onResponse dataInt is:" + i);
          }
        }
        else if ("ipc_apollo_getfav_action".equals(localObject3))
        {
          paramBundle = ((Bundle)localObject1).getString("getFavResult");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
          ((JSONObject)localObject1).put("result", 0);
          super.callJs(str1 + "(" + ((JSONObject)localObject1).toString() + ");");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GETFAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
          }
        }
        else if ("ipc_apollo_add_fav_action".equals(localObject3))
        {
          paramBundle = ((Bundle)localObject1).getString("addFavAction");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
          ((JSONObject)localObject1).put("result", 0);
          super.callJs(str1 + "(" + ((JSONObject)localObject1).toString() + ");");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_ADD_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
          }
        }
        else
        {
          if (!"ipc_apollo_del_fav_action".equals(localObject3)) {
            break;
          }
          paramBundle = ((Bundle)localObject1).getString("delFavAction");
          i = new JSONObject(paramBundle).optInt("ret");
          localObject1 = new JSONObject();
          if (i == 0)
          {
            ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
            ((JSONObject)localObject1).put("result", 0);
            super.callJs(str1 + "(" + ((JSONObject)localObject1).toString() + ");");
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
            return;
            if (i == 1) {
              callbackError(str1, "本地没有该动作");
            } else if (i == 2) {
              callbackError(str1, "删除动作失败");
            } else {
              callbackError(str1, "删除动作异常");
            }
          }
        }
      }
    }
    if ("ipc_apollo_del_fav_list".equals(localObject3))
    {
      paramBundle = new JSONObject(((Bundle)localObject1).getString("delFavListAction"));
      localObject1 = new JSONObject();
      if (paramBundle.optBoolean("delHasError")) {
        ((JSONObject)localObject1).put("result", 1);
      }
      for (;;)
      {
        ((JSONObject)localObject1).put("data", paramBundle.opt("errorList"));
        super.callJs(str1 + "(" + ((JSONObject)localObject1).toString() + ");");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_List onResponse data is:" + ((JSONObject)localObject1).toString());
        return;
        ((JSONObject)localObject1).put("result", 0);
      }
    }
    super.onResponse(paramBundle);
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.sendRemoteReq(paramBundle, paramBoolean1, paramBoolean2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ApolloJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */