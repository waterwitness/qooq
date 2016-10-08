package com.tencent.bitapp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QQNativeModule
  extends ReactContextBaseJavaModule
{
  static final String TAG = "QQNativeModule";
  
  public QQNativeModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String getString(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return paramString2;
  }
  
  @ReactMethod
  public void drawFirst(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNativeModule", 4, "firstDraw(tag: " + paramInt + ", msgId: " + paramString + ")");
    }
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)) && (RNPreDownloadFacade.a()))
    {
      paramString = BitAppInstanceManager.getInstance();
      if ((paramString != null) && (paramString.getCurrentReactContext() != null))
      {
        paramString = (UIManagerModule)paramString.getCurrentReactContext().getNativeModule(UIManagerModule.class);
        if ((paramString != null) && (paramString.mUIImplementation != null))
        {
          paramString = paramString.mUIImplementation.mNativeViewHierarchyManager;
          if (paramString != null)
          {
            paramString = paramString.getView(paramInt);
            if ((paramString != null) && ((paramString instanceof BitAppBaseView))) {
              ((BitAppBaseView)paramString).firstDraw();
            }
          }
        }
      }
    }
    label137:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          break label137;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d("QQNativeModule", 4, "firstDraw but NativeViewHierarchyManager is null");
          return;
        } while (!QLog.isColorLevel());
        QLog.d("QQNativeModule", 4, "firstDraw but UIManagerModule is null");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QQNativeModule", 4, "firstDraw but BitAppInstanceManager is null");
      return;
    }
    QLog.d("QQNativeModule", 4, "firstDraw but tag < 0");
  }
  
  public String getName()
  {
    return "QQNativeModule";
  }
  
  @ReactMethod
  public void gotoWebview(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNativeModule", 2, "gotoWebview tag: " + paramInt + " | url: " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localReactApplicationContext = getReactApplicationContext();
      localIntent = new Intent(localReactApplicationContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.addFlags(268435456);
      localReactApplicationContext.startActivity(localIntent);
    }
    while (!QLog.isColorLevel())
    {
      ReactApplicationContext localReactApplicationContext;
      Intent localIntent;
      return;
    }
    QLog.d("QQNativeModule", 4, "gotoWebview url is null");
  }
  
  @ReactMethod
  public void jsRequest(String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQNativeModule", 2, "jsRequest ... BaseActivity.sTopActivity == null, url: " + paramString);
      }
    }
    do
    {
      do
      {
        return;
        if (!new WebViewPluginEngine(null, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getAppInterface()).a(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQNativeModule", 4, "jsRequest ... url: " + paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("QQNativeModule", 2, "jsRequest ... can not handle this url: " + paramString);
  }
  
  @ReactMethod
  public void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQNativeModule", 2, "subAction or actionName cannot be null");
      }
    }
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = BaseActivity.sTopActivity.getAppInterface();
      if (localAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQNativeModule", 4, "runtime cannot be null");
    return;
    String str = getString(paramString1, "P_CliOper");
    paramString2 = getString(paramString2, "Pb_account_lifeservice");
    paramString3 = getString(paramString3, localAppInterface.getAccount());
    if ((localAppInterface instanceof QQAppInterface)) {}
    for (paramString1 = (QQAppInterface)localAppInterface;; paramString1 = null)
    {
      ReportController.b(paramString1, str, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      return;
    }
  }
  
  @ReactMethod
  public void setMsgState(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNativeModule", 2, "setFinalStateInAio peerUin: " + paramString1 + " | type: " + paramString2 + " | msgid: " + paramString3 + " | state: " + paramInt + " | thumbNailUrl" + paramString4);
    }
    int i = -1;
    long l1 = -1L;
    try
    {
      j = Integer.parseInt(paramString2);
      i = j;
      long l2 = Long.parseLong(paramString3);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                paramString2.printStackTrace();
                j = i;
              }
              paramString2 = BaseActivity.sTopActivity.getAppInterface();
              if (!(paramString2 instanceof QQAppInterface)) {
                break label403;
              }
              QQMessageFacade localQQMessageFacade = ((QQAppInterface)paramString2).a();
              paramString2 = localQQMessageFacade.a(paramString1, j, l1);
              if (paramString2 == null) {
                break label349;
              }
              if (!(paramString2 instanceof MessageForBitApp)) {
                break;
              }
              paramString3 = ((MessageForBitApp)paramString2).bitAppMsg;
              if (paramString3 != null)
              {
                paramString3.mState = paramInt;
                paramString3.mThumbNailURl = paramString4;
                paramString2 = null;
                try
                {
                  paramString3 = paramString3.getBytes();
                  paramString2 = paramString3;
                }
                catch (Exception paramString3)
                {
                  for (;;)
                  {
                    paramString3.printStackTrace();
                  }
                }
                localQQMessageFacade.a(paramString1, j, l1, paramString2);
                return;
              }
            } while (!QLog.isColorLevel());
            QLog.d("QQNativeModule", 4, "Find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1 + " bitAppMsg is null");
            return;
          } while (!QLog.isColorLevel());
          QLog.d("QQNativeModule", 4, "Find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1 + " isn't MessageForBitApp");
          return;
        } while (!QLog.isColorLevel());
        QLog.d("QQNativeModule", 4, "Can't find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QQNativeModule", 4, "Current runtime isn't QQAppInterface");
    }
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNativeModule", 4, "setMsgState msgId error");
      }
      return;
    }
    label349:
    label403:
    return;
  }
  
  @ReactMethod
  public void ssoReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, ReadableMap paramReadableMap)
  {
    AppInterface localAppInterface = BaseActivity.sTopActivity.getAppInterface();
    if (localAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNativeModule", 4, "runtime cannot be null");
      }
      return;
    }
    String str1 = getString(paramString1, "P_CliOper");
    paramString2 = getString(paramString2, "Pb_account_lifeservice");
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString3 = getString(paramString7, "click_ad_msg");
    paramString7 = getString(paramString8, String.valueOf(NetConnInfoCenter.getServerTime()));
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    paramString8 = new JSONObject();
    try
    {
      while (localReadableMapKeySetIterator.hasNextKey())
      {
        String str2 = localReadableMapKeySetIterator.nextKey();
        paramString8.put(str2, paramReadableMap.getString(str2));
      }
      return;
    }
    catch (JSONException paramReadableMap)
    {
      paramReadableMap.printStackTrace();
      paramReadableMap = new ArrayList();
      paramReadableMap.add(paramString6);
      paramReadableMap.add(paramString1);
      PAReportUtil.a(localAppInterface, str1, paramString2, localAppInterface.getAccount(), paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString3, paramString7, paramString8.toString(), paramReadableMap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\QQNativeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */