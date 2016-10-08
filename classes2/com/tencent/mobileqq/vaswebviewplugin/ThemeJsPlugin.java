package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeDIYActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeJsPlugin
  extends VasWebviewJsPlugin
{
  private static final int ANIMATION_DURATION = 501;
  public static final String BUSINESS_NAME = "theme";
  private static final String OBJECT_NAME = "theme";
  public static final String TAG = "ThemeJsPlugin";
  static final int THEME_OPTION_ERROR = -1;
  static final int THEME_OPTION_FILE_LOSE_ERROR = 4;
  static final int THEME_OPTION_PKG_NOT_EXISTS = 1;
  static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  static final int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  static final int THEME_OPTION_SET_SV_ERROR = 5;
  static final int THEME_OPTION_SUCCESS = 0;
  private static final String XM_3 = "Xiaomi_MI 3";
  public static String loadingThemeIdForJsCall;
  private BrowserAppInterface app;
  private Context context;
  private String currDownloadingThemeId;
  long currentTimeMillis;
  QQCustomDialog dialog;
  private HashMap downloadThemeMap;
  Bitmap drawingCache;
  boolean isAnimating;
  private boolean isDownloadingInProgress;
  public Boolean isSwitchTheme;
  Object mLock;
  ThemeJsPlugin.SwitchThemeTask mSwitchThemeTask;
  HashMap reportMap;
  View rootView;
  private String themeDownloadCallbackId;
  public QQProgressDialog themeSwitchDialog;
  ImageView tmpScreenShot;
  
  public ThemeJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.downloadThemeMap = new HashMap();
    this.isSwitchTheme = Boolean.valueOf(false);
    this.isAnimating = false;
    this.reportMap = new HashMap();
    this.mLock = new Object();
    this.currentTimeMillis = 0L;
    this.mPluginNameSpace = "theme";
  }
  
  public static int getFileNumInFile(File paramFile)
  {
    if (paramFile != null) {}
    for (;;)
    {
      int k;
      try
      {
        if (!paramFile.exists()) {
          return 0;
        }
        if (!paramFile.isDirectory()) {
          return 1;
        }
        paramFile = paramFile.listFiles();
        int i;
        int j;
        if ((paramFile != null) && (paramFile.length > 0))
        {
          i = paramFile.length;
          k = i - 1;
          i = 0;
          j = i;
          if ((k >= 0) && (paramFile[k] == null)) {}
        }
        else
        {
          String[] arrayOfString;
          return 0;
        }
      }
      catch (Exception paramFile)
      {
        try
        {
          if (paramFile[k].isDirectory())
          {
            arrayOfString = paramFile[k].list();
            if (arrayOfString != null)
            {
              j = arrayOfString.length;
              i = j + i;
            }
            else
            {
              j = 0;
              continue;
            }
          }
          else
          {
            i += 1;
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          continue;
        }
        catch (Exception paramFile)
        {
          continue;
        }
        paramFile = paramFile;
        i = 0;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("ThemeJsPlugin", 2, "ThemeJsHandler getFileNumInFile, error:" + paramFile.getMessage());
          j = i;
        }
        return j;
      }
      catch (OutOfMemoryError paramFile)
      {
        i = 0;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeJsPlugin", 2, "ThemeJsHandler getFileNumInFile, OOM:" + paramFile.getMessage());
        j = i;
        continue;
      }
      k -= 1;
    }
  }
  
  private boolean isThemeExist(String paramString1, String paramString2, long paramLong)
  {
    File localFile = new File(ThemeUtil.getThemeDownloadFilePath(this.context, paramString1, paramString2));
    if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " already exists.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " not exist.");
    }
    return false;
  }
  
  protected void doAnimation(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "doAnimation, view is null");
      }
      return;
    }
    this.isAnimating = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
    localAlphaAnimation.setDuration(501L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    paramView.setAnimation(localAlphaAnimation);
  }
  
  protected void doScreenShot()
  {
    try
    {
      if (this.rootView == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ThemeJsPlugin", 2, "doScreenShot, titleView is null");
        return;
      }
      boolean bool1 = this.rootView.isDrawingCacheEnabled();
      boolean bool2 = this.rootView.willNotCacheDrawing();
      this.rootView.setDrawingCacheEnabled(true);
      this.rootView.setWillNotCacheDrawing(false);
      Object localObject = this.rootView.getDrawingCache();
      if (localObject != null)
      {
        this.drawingCache = Bitmap.createBitmap((Bitmap)localObject);
        this.tmpScreenShot = new ImageView(this.mRuntime.a());
        this.tmpScreenShot.setImageBitmap(this.drawingCache);
        localObject = (ViewGroup)this.mRuntime.a().getWindow().getDecorView().getRootView();
        this.tmpScreenShot.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).addView(this.tmpScreenShot);
      }
      this.rootView.setDrawingCacheEnabled(bool1);
      this.rootView.setWillNotCacheDrawing(bool2);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "screen shot oom, no animation", localOutOfMemoryError);
        }
        this.drawingCache = null;
        if ((this.tmpScreenShot != null) && (this.tmpScreenShot.getParent() != null)) {
          ((ViewGroup)this.tmpScreenShot.getParent()).removeView(this.tmpScreenShot);
        }
        this.tmpScreenShot = null;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeJsPlugin", 2, "drawingCache is:" + this.drawingCache);
      return;
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934604L == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "EVENT_THEME_POSTCHANGED");
      }
      onPostThemeChanged();
      return true;
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483680L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"theme".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("illegal json");
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThemeJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
      paramString1 = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramJsBridgeListener = paramString1.getString("callback");
      if (paramJsBridgeListener == null) {
        throw new Exception("need callbackId");
      }
      if ("queryInfo".equals(paramString3))
      {
        queryInfo(paramString1, paramJsBridgeListener);
      }
      else if ("queryLocal".equals(paramString3))
      {
        queryLocal(paramString1, paramJsBridgeListener);
      }
      else if ("setup".equals(paramString3))
      {
        setup(paramString1, paramJsBridgeListener);
      }
      else if ("startDownload".equals(paramString3))
      {
        startDownload(paramString1, paramJsBridgeListener);
      }
      else if ("stopDownload".equals(paramString3))
      {
        stopDownload(paramString1, paramJsBridgeListener);
      }
      else if ("openDiyTheme".equals(paramString3))
      {
        if (System.currentTimeMillis() - this.currentTimeMillis > 2000L)
        {
          reportTheme("theme_goto_diytheme", 0, "999", 0L, "VipThemeMallGoToDiy", "0", "201", 150, "0", 0, "", "");
          loadingThemeIdForJsCall = "IN_DIY_THEME";
          this.currentTimeMillis = System.currentTimeMillis();
          super.startActivityForResult(new Intent(this.mRuntime.a(), ThemeDIYActivity.class), (byte)1);
        }
        else
        {
          reportTheme("theme_goto_diytheme", 0, "999", 0L, "VipThemeMallGoToDiy", "1", "201", 150, "1", 0, "", "");
        }
      }
      else if ("getDensity".equals(paramString3))
      {
        paramString1 = ThemeUtil.getThemeDensity(this.context);
        paramString2 = new JSONObject();
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "getDensity density:" + paramString1);
        }
        paramString2.put("result", 0);
        paramString2.put("density", paramString1);
        paramString2.put("message", "returnt density " + paramString1);
        super.callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
      }
      else
      {
        if (!"queryWeekLoopInfo".equals(paramString3)) {
          break;
        }
        queryWeekLoopInfo(paramString1, paramJsBridgeListener);
      }
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  public void handleMessage(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "handleMessage:" + paramInt + " " + paramString1 + " " + paramString2 + " " + paramLong + " ");
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramString2.startsWith(AppConstants.cG)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ThemeJsPlugin", 2, "not download theme file message" + AppConstants.cG);
          return;
          if (paramInt != 2002) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "download theme file process");
          }
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            paramString2.downsize = paramLong;
            paramString2.status = "2";
            this.downloadThemeMap.put(this.currDownloadingThemeId, paramString2);
            ThemeUtil.setThemeInfo(this.context, paramString2);
            return;
          }
        } while (this.isDownloadingInProgress != true);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "downloadThemeMap themeInfo is null,themeId=" + this.currDownloadingThemeId);
        }
        this.isDownloadingInProgress = false;
        super.callJsOnError(paramString1, "themeInfo is null");
        return;
        if (paramInt != 2003) {
          break;
        }
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            paramString2.downsize = paramLong;
            paramString2.status = "3";
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
            ThemeUtil.setThemeInfo(this.context, paramString2);
            paramString2 = new JSONObject();
            paramString2.put("result", 0);
            paramString2.put("message", "ok, Theme downloaded.");
            this.isDownloadingInProgress = false;
            super.callJs(paramString1, new String[] { paramString2.toString() });
            return;
          }
        }
        catch (Exception paramString2)
        {
          this.isDownloadingInProgress = false;
          super.callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
        this.isDownloadingInProgress = false;
        super.callJsOnError(paramString1, "themeInfo is null");
      } while (!QLog.isColorLevel());
      QLog.d("ThemeJsPlugin", 2, "downloadThemeMap themeInfo is null,themeId=" + this.currDownloadingThemeId);
      return;
      if (paramInt == 2005) {
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            paramString2.downsize = paramLong;
            paramString2.status = "4";
            ThemeUtil.setThemeInfo(this.context, paramString2);
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
          }
          paramString2 = new JSONObject();
          paramString2.put("result", -1);
          paramString2.put("message", "recv error");
          this.isDownloadingInProgress = false;
          super.callJs(paramString1, new String[] { paramString2.toString() });
          return;
        }
        catch (Exception paramString2)
        {
          super.callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeJsPlugin", 2, "" + paramInt);
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.context = this.mRuntime.a().getApplicationContext();
    super.onCreate();
    this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
    QLog.d("ThemeJsPlugin", 1, "onCreate, nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.app));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel())
    {
      if (loadingThemeIdForJsCall != null) {
        QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch to themeid " + loadingThemeIdForJsCall);
      }
    }
    else
    {
      if (this.rootView != null) {
        break label75;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "titleView is null");
      }
    }
    label75:
    do
    {
      return;
      QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch ok");
      break;
      String str = Build.MANUFACTURER + "_" + Build.MODEL;
      if ((Build.VERSION.SDK_INT >= 16) && (str.contains("Xiaomi_MI 3"))) {
        this.rootView.setLayerType(1, null);
      }
      if ((this.themeSwitchDialog != null) && (this.themeSwitchDialog.isShowing())) {
        this.themeSwitchDialog.dismiss();
      }
      if (this.drawingCache == null) {
        break label196;
      }
    } while (this.isAnimating);
    doAnimation(this.tmpScreenShot);
    this.rootView.postDelayed(new ThemeJsPlugin.6(this), 601L);
    return;
    label196:
    this.isSwitchTheme = Boolean.valueOf(false);
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("status");
    int i = paramBundle.getInt("result");
    Long localLong1 = Long.valueOf(paramBundle.getLong("readSize"));
    String str = paramBundle.getString("callbackId");
    Long localLong2 = Long.valueOf(paramBundle.getLong("downloadTime"));
    if ("onProgress".equals(localObject))
    {
      paramBundle = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
      if (paramBundle != null)
      {
        paramBundle.downsize = localLong1.longValue();
        paramBundle.status = "2";
        this.downloadThemeMap.put(this.currDownloadingThemeId, paramBundle);
        ThemeUtil.setThemeInfo(this.context, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "onProgress, " + localLong1);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.isDownloadingInProgress)
          {
            QLog.e("ThemeJsPlugin", 1, "onPushMsg onProgress Error, themeInfo is null, readSize:" + localLong1);
            reportTheme(null, 0, this.currDownloadingThemeId, 0L, null, null, "200", 153, String.valueOf(256), -37, paramBundle.version, "");
          }
          this.isDownloadingInProgress = false;
        } while ((this.currDownloadingThemeId == null) || (!this.currDownloadingThemeId.equals(loadingThemeIdForJsCall)));
        super.callJsOnError(str, "onProgress, themeInfo is null");
        return;
      } while (!"onDone".equals(localObject));
      localObject = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
      if (localObject != null)
      {
        this.downloadThemeMap.remove(this.currDownloadingThemeId);
        loadingThemeIdForJsCall = null;
        this.isDownloadingInProgress = false;
        int j = paramBundle.getInt("errCode", 0);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "onDone, result=" + i);
        }
        if ((i == 3) && (j == 0))
        {
          reportTheme("theme_download", 0, this.currDownloadingThemeId, localLong2.longValue(), "VipThemeMallDowned", "ok", "200", 153, ThemeReporter.t, 9, ((ThemeUtil.ThemeInfo)localObject).version, "");
          ((ThemeUtil.ThemeInfo)localObject).downsize = localLong1.longValue();
          ((ThemeUtil.ThemeInfo)localObject).status = "3";
          ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject);
          super.callJs(str, new String[] { "{'result':0, 'message':'OK'}" });
          return;
        }
        reportTheme("theme_download", 0, this.currDownloadingThemeId, localLong2.longValue(), "VipThemeMallDowned", "ok", "200", 153, String.valueOf(i), j, ((ThemeUtil.ThemeInfo)localObject).version, "");
        ((ThemeUtil.ThemeInfo)localObject).status = "4";
        ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject);
        QLog.e("ThemeJsPlugin", 1, "onPushMsg onDone Error, themeId:" + ((ThemeUtil.ThemeInfo)localObject).themeId + ", errCode:" + j + ", result:" + i);
        super.callJs(str, new String[] { "{'result':-1, 'message':'Failure'}" });
        return;
      }
      if (this.isDownloadingInProgress)
      {
        QLog.e("ThemeJsPlugin", 1, "onPushMsg onDone Error, themeInfo is null, readSize:" + localLong1);
        reportTheme(null, 0, this.currDownloadingThemeId, 0L, null, null, "200", 153, String.valueOf(257), -37, ((ThemeUtil.ThemeInfo)localObject).version, "");
      }
      this.isDownloadingInProgress = false;
    } while ((this.currDownloadingThemeId == null) || (!this.currDownloadingThemeId.equals(loadingThemeIdForJsCall)));
    super.callJsOnError(str, "onDone, themeInfo is null");
  }
  
  public void onResponse(Bundle paramBundle)
  {
    int i;
    Object localObject3;
    String str;
    Object localObject4;
    Object localObject1;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("respkey", 0);
      localObject3 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject4 = paramBundle.getBundle("request");
      localObject1 = paramBundle.getBundle("response");
      if (localObject1 != null) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          return;
        } while (i != this.mOnRemoteResp.key);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "response:" + (String)localObject3);
        }
      } while (localObject3 == null);
      int j = paramBundle.getInt("failcode", 1000);
      if ("startDownloadTheme".equals(localObject3))
      {
        if (1001 == j) {
          QLog.e("ThemeJsPlugin", 1, "ThemeJsPlugin.onResponse, startDownload timeOut.");
        }
        boolean bool = ((Bundle)localObject1).getBoolean("StartDownloadResult");
        if (!bool)
        {
          QLog.e("ThemeJsPlugin", 1, "ThemeJsPlugin.onResponse, startDownload fail.");
          this.isDownloadingInProgress = false;
          super.callJsOnError(str, "startDownload error.");
        }
        if (bool) {}
        for (i = 34;; i = -34)
        {
          reportTheme(null, 0, "", 0L, null, null, "200", 153, String.valueOf(i), j, "", "");
          return;
        }
      }
      if (!"stopdownload".equals(localObject3)) {
        break label401;
      }
      paramBundle = ((Bundle)localObject4).getString("id");
      localObject3 = new JSONObject();
      if (!((Bundle)localObject1).getBoolean("processor")) {
        break;
      }
      localObject1 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramBundle);
    } while (localObject1 == null);
    ((ThemeUtil.ThemeInfo)localObject1).status = "4";
    ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject1);
    this.downloadThemeMap.remove(paramBundle);
    this.isDownloadingInProgress = false;
    try
    {
      ((JSONObject)localObject3).put("result", 0);
      ((JSONObject)localObject3).put("message", "Download process paused.");
      super.callJs(str, new String[] { ((JSONObject)localObject3).toString() });
      reportTheme(null, 1, paramBundle, 0L, null, null, "200", 153, ThemeReporter.t, 21, "", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        callJsOnError(str, localJSONException.getMessage());
      }
    }
    super.callJsOnError(str, "stop failure.");
    return;
    label401:
    if ("pausedownload".equals(localObject3))
    {
      paramBundle = ((Bundle)localObject4).getString("currid");
      localObject3 = ((Bundle)localObject4).getString("id");
      localObject4 = ((Bundle)localObject4).getString("version");
      if (localJSONException.getBoolean("processor"))
      {
        ??? = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramBundle);
        if (??? != null)
        {
          ((ThemeUtil.ThemeInfo)???).status = "4";
          ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)???);
        }
        this.downloadThemeMap.remove(paramBundle);
        this.isDownloadingInProgress = false;
      }
      ??? = new JSONObject();
      try
      {
        ((JSONObject)???).put("result", 2);
        ((JSONObject)???).put("message", "pause download themeId= " + paramBundle + ",version=" + (String)localObject4 + ",for start download themeid=" + (String)localObject3);
        super.callJs(str, new String[] { ((JSONObject)???).toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        super.callJsOnError(str, paramBundle.getMessage());
        return;
      }
    }
    if ("weekLoopGetData".equals(localObject3))
    {
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("result", 0);
        localObject3 = ((Bundle)???).getString("seriesID");
        ??? = ((Bundle)???).getString("themeArray");
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "IPC_THEME_WEEK_LOOP_GET respone seriesID:" + (String)localObject3 + ", themeArr:" + (String)???);
        }
        paramBundle.put("seriesID", localObject3);
        paramBundle.put("themeArray", ???);
        paramBundle.put("message", "useSeriesID is " + (String)localObject3);
        super.callJs(str, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e("ThemeJsPlugin", 1, "IPC_THEME_WEEK_LOOP_GET respone Exception:" + paramBundle.getMessage());
        super.callJsOnError(str, paramBundle.getMessage());
        return;
      }
    }
    if ("setSVTheme".equals(localObject3))
    {
      paramBundle = ((Bundle)???).getString("themeId");
      i = ((Bundle)???).getInt("themeStatus", -1);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "IPC_THEME_SET_SERVER respone themeId:" + paramBundle + ", ret:" + i);
      }
      if (i == 0) {
        synchronized (this.mLock)
        {
          if ((this.mSwitchThemeTask != null) && (!TextUtils.isEmpty(str)) && (str.equals(this.mSwitchThemeTask.callbackId)) && (!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals(this.mSwitchThemeTask.themeId)))
          {
            this.mSwitchThemeTask.execute(new Object[] { paramBundle });
            this.mSwitchThemeTask = null;
          }
          return;
        }
      }
      ??? = new JSONObject();
      try
      {
        ((JSONObject)???).put("themeId", paramBundle);
        ((JSONObject)???).put("result", 5);
        ((JSONObject)???).put("message", "setup theme setSV error.");
        super.callJs(str, new String[] { ((JSONObject)???).toString() });
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("ThemeJsPlugin", 1, "setup theme setSV Exception:" + paramBundle.getMessage());
        super.callJsOnError(str, paramBundle.getMessage());
        return;
      }
    }
    super.onResponse(paramBundle);
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    String str;
    ThemeUtil.ThemeInfo localThemeInfo;
    JSONObject localJSONObject2;
    try
    {
      str = paramJSONObject.getString("id");
      localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str);
      JSONObject localJSONObject1;
      if (localThemeInfo == null)
      {
        localThemeInfo = ThemeUtil.getThemeInfo(this.context, str);
        paramJSONObject = Boolean.valueOf(false);
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "ok");
        localJSONObject2 = new JSONObject();
        if (!str.equals("1000")) {
          break label212;
        }
        localJSONObject2.put("status", Integer.parseInt("3"));
        localJSONObject2.put("version", 0);
        localJSONObject2.put("progress", 100);
      }
      for (;;)
      {
        localJSONObject1.put("data", localJSONObject2);
        super.callJs(paramString, new String[] { localJSONObject1.toString() });
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("ThemeJsPlugin", 2, "queryInfo,themeId=" + str + "result=" + localJSONObject1.toString());
        return;
        paramJSONObject = Boolean.valueOf(true);
        break;
        label212:
        if (localThemeInfo != null) {
          break label323;
        }
        localJSONObject2.put("status", Integer.parseInt("1"));
        localJSONObject2.put("version", 0);
        localJSONObject2.put("progress", 0);
      }
      if (!localThemeInfo.status.equals("5")) {
        break label343;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("ThemeJsPlugin", 1, "queryInfo Exception：" + paramJSONObject.getMessage());
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.t, -35, "1", "");
      return;
    }
    label323:
    localThemeInfo.status = "3";
    label343:
    if ((localThemeInfo.status.equals("2")) && (!paramJSONObject.booleanValue()))
    {
      if (isThemeExist(localThemeInfo.themeId, localThemeInfo.version, localThemeInfo.size))
      {
        localThemeInfo.status = "3";
        localThemeInfo.downsize = localThemeInfo.size;
        label397:
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, str + ",queryInfo, modify theme download status to " + localThemeInfo.status);
        }
        ThemeUtil.setThemeInfo(this.context, localThemeInfo);
      }
    }
    else
    {
      localJSONObject2.put("status", Integer.parseInt(localThemeInfo.status));
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "downsize:" + localThemeInfo.downsize + "--size:" + localThemeInfo.size);
      }
      if (localThemeInfo.size <= 0L) {
        break label588;
      }
    }
    label588:
    for (int i = (int)Math.floor(localThemeInfo.downsize * 1.0D / localThemeInfo.size * 100.0D);; i = 0)
    {
      i = Math.min(i, 100);
      localJSONObject2.put("version", localThemeInfo.version);
      localJSONObject2.put("progress", i);
      break;
      localThemeInfo.status = "4";
      break label397;
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal");
    }
    ThreadManager.a(new ThemeJsPlugin.2(this, paramString), 8, null, false);
  }
  
  void queryWeekLoopInfo(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = new Bundle();
      sendRemoteReq(DataFactory.a("weekLoopGetData", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      QLog.e("ThemeJsPlugin", 1, "queryWeekLoopInfo Exception：" + paramJSONObject.getMessage());
      reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.t, -35, "2", "");
    }
  }
  
  void reportTheme(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ThemeJsPlugin.1(this, paramString2, paramInt1, paramString1, paramLong, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramString7, paramString8, paramString6), 2000L);
  }
  
  public void setup(JSONObject arg1, String paramString)
  {
    for (;;)
    {
      String str3;
      Object localObject1;
      boolean bool1;
      label46:
      int i;
      label65:
      String str2;
      label84:
      JSONArray localJSONArray;
      label103:
      long l;
      label122:
      int j;
      try
      {
        str3 = ???.getString("id");
        if (???.has("version"))
        {
          localObject1 = ???.getString("version");
          if (!???.has("showDlgTip")) {
            break label958;
          }
          bool1 = ???.getBoolean("showDlgTip");
          if (!???.has("isSound")) {
            break label964;
          }
          i = ???.getInt("isSound");
          if (!???.has("seriesID")) {
            break label970;
          }
          str2 = ???.getString("seriesID");
          if (!???.has("themeArray")) {
            break label976;
          }
          localJSONArray = ???.getJSONArray("themeArray");
          if (!???.has("startTime")) {
            break label982;
          }
          l = ???.getLong("startTime");
          if ((TextUtils.isEmpty(str3)) || ((!TextUtils.isEmpty(str2)) && ((localJSONArray == null) || (localJSONArray.length() < 1))))
          {
            QLog.e("ThemeJsPlugin", 1, "ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=" + str2 + ",themeArray=" + localJSONArray);
            ??? = new JSONObject();
            ???.put("result", 1);
            ???.put("message", "seriesID || themeArray data error");
            super.callJs(paramString, new String[] { ???.toString() });
            reportTheme(null, 0, str3, 0L, null, null, "200", 155, ThemeReporter.t, -8, (String)localObject1, "");
            return;
          }
          ??? = ThemeUtil.getThemeInfo((BaseActivity)this.mRuntime.a(), str3);
          if (??? != null)
          {
            if (???.isVoiceTheme)
            {
              j = 1;
              break label988;
              label294:
              ???.isVoiceTheme = bool2;
              ThemeUtil.setThemeInfo((BaseActivity)this.mRuntime.a(), ???);
            }
          }
          else
          {
            label315:
            if (QLog.isColorLevel()) {
              QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup,themeId=" + str3 + ",version=" + (String)localObject1 + ",isSound=" + i);
            }
            Object localObject3 = ThemeUtil.getCurrentThemeInfo();
            ??? = ((Bundle)localObject3).getString("themeId");
            localObject3 = ((Bundle)localObject3).getString("version");
            if ((str3.equals(???)) && (((String)localObject1).equals(localObject3)))
            {
              if (QLog.isColorLevel()) {
                QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup the same theme,themeId=" + str3 + ",version=" + (String)localObject1);
              }
              ??? = new JSONObject();
              ???.put("result", 0);
              ???.put("message", "set the same theme");
              super.callJs(paramString + "(" + ???.toString() + ");");
              if (this.reportMap.containsKey(Integer.valueOf((str3 + "_" + (String)localObject1).hashCode())))
              {
                ??? = (String)this.reportMap.get(Integer.valueOf((str3 + "_" + (String)localObject1).hashCode()));
                label602:
                reportTheme(null, 1, str3, 0L, null, null, "200", 155, ???, 23, (String)localObject1, "0");
                return;
              }
            }
          }
        }
      }
      catch (Throwable ???)
      {
        callJsOnError(paramString, ???.getMessage());
        QLog.e("ThemeJsPlugin", 1, "setup theme error:" + ???.getMessage());
        return;
      }
      label950:
      label958:
      label964:
      label970:
      label976:
      label982:
      label988:
      do
      {
        bool2 = false;
        break label294;
        ??? = ThemeReporter.u;
        break label602;
        if (!this.isSwitchTheme.booleanValue()) {
          synchronized (this.mLock)
          {
            this.mSwitchThemeTask = new ThemeJsPlugin.SwitchThemeTask(this, paramString, bool1);
            this.mSwitchThemeTask.themeId = str3;
            this.mSwitchThemeTask.version = ((String)localObject1);
            this.mSwitchThemeTask.seriesID = str2;
            this.mSwitchThemeTask.themeArray = localJSONArray;
            this.mSwitchThemeTask.startTime = (l * 1000L);
            if ("1103".equals(str3))
            {
              this.mSwitchThemeTask.execute(new Object[] { str3 });
              this.mSwitchThemeTask = null;
              if (!QLog.isColorLevel()) {
                break label950;
              }
              QLog.d("ThemeJsPlugin", 2, "setup server :id:" + str3);
              return;
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("themeId", str3);
            ((Bundle)localObject1).putString("seriesID", str2);
            super.sendRemoteReq(DataFactory.a("setSVTheme", paramString, this.mOnRemoteResp.key, (Bundle)localObject1), false, true);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler return because setupping.");
        }
        ??? = new JSONObject();
        ???.put("result", 2);
        ???.put("message", "is switching theme");
        super.callJs(paramString, new String[] { ???.toString() });
        return;
        j = 0;
        break label988;
        return;
        String str1 = "0";
        break;
        bool1 = true;
        break label46;
        i = 0;
        break label65;
        str2 = null;
        break label84;
        localJSONArray = null;
        break label103;
        l = 0L;
        break label122;
        if (j == i) {
          break label315;
        }
      } while (i != 1);
      boolean bool2 = true;
    }
  }
  
  /* Error */
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1010
    //   5: aload_1
    //   6: ldc_w 1012
    //   9: invokevirtual 404	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12: invokestatic 1016	com/tencent/mobileqq/emosm/EmosmUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: aload_1
    //   18: ldc_w 787
    //   21: invokevirtual 404	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: ldc_w 774
    //   30: invokevirtual 404	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload_1
    //   36: ldc_w 1017
    //   39: invokevirtual 930	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: istore 11
    //   44: aload_1
    //   45: ldc_w 929
    //   48: invokevirtual 924	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   51: ifeq +176 -> 227
    //   54: aload_1
    //   55: ldc_w 929
    //   58: invokevirtual 930	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   61: istore 10
    //   63: new 385	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 475	org/json/JSONObject:<init>	()V
    //   70: astore_3
    //   71: aload 6
    //   73: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +24 -> 100
    //   79: aload 5
    //   81: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +16 -> 100
    //   87: aload 4
    //   89: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +8 -> 100
    //   95: iload 11
    //   97: ifne +136 -> 233
    //   100: ldc 15
    //   102: iconst_1
    //   103: new 157	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1019
    //   113: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 4
    //   118: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 1021
    //   124: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 5
    //   129: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1023
    //   135: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload 11
    //   140: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 955
    //   146: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 10
    //   151: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_3
    //   161: ldc_w 479
    //   164: bipush 8
    //   166: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_3
    //   171: ldc_w 490
    //   174: ldc_w 1025
    //   177: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: aload_0
    //   182: aload_2
    //   183: iconst_1
    //   184: anewarray 366	java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: aload_3
    //   190: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   193: aastore
    //   194: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   197: aload_0
    //   198: aconst_null
    //   199: iconst_0
    //   200: aload 5
    //   202: lconst_0
    //   203: aconst_null
    //   204: aconst_null
    //   205: ldc_w 683
    //   208: sipush 153
    //   211: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   214: bipush -8
    //   216: aload 4
    //   218: ldc_w 447
    //   221: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: monitorexit
    //   226: return
    //   227: iconst_0
    //   228: istore 10
    //   230: goto -167 -> 63
    //   233: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +63 -> 299
    //   239: ldc 15
    //   241: iconst_2
    //   242: new 157	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 1027
    //   252: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 4
    //   257: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 1021
    //   263: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 5
    //   268: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 1023
    //   274: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload 11
    //   279: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: ldc_w 955
    //   285: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 10
    //   290: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_0
    //   300: aconst_null
    //   301: iconst_0
    //   302: aload 5
    //   304: lconst_0
    //   305: aconst_null
    //   306: aconst_null
    //   307: ldc_w 683
    //   310: sipush 153
    //   313: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   316: bipush 7
    //   318: aload 4
    //   320: ldc_w 447
    //   323: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   326: invokestatic 1032	com/tencent/mobileqq/util/Utils:b	()Z
    //   329: ifne +166 -> 495
    //   332: ldc 15
    //   334: iconst_1
    //   335: ldc_w 1034
    //   338: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_3
    //   342: ldc_w 479
    //   345: bipush 7
    //   347: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload_3
    //   352: ldc_w 490
    //   355: ldc_w 1025
    //   358: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   361: pop
    //   362: aload_0
    //   363: aload_2
    //   364: iconst_1
    //   365: anewarray 366	java/lang/String
    //   368: dup
    //   369: iconst_0
    //   370: aload_3
    //   371: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   374: aastore
    //   375: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   378: aload_0
    //   379: ldc_w 701
    //   382: iconst_2
    //   383: aload 5
    //   385: lconst_0
    //   386: ldc_w 703
    //   389: ldc_w 1036
    //   392: ldc_w 683
    //   395: sipush 153
    //   398: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   401: bipush -11
    //   403: aload 4
    //   405: ldc_w 447
    //   408: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   411: goto -187 -> 224
    //   414: astore_1
    //   415: aload_0
    //   416: iconst_0
    //   417: putfield 120	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   420: aload_0
    //   421: aload_2
    //   422: aload_1
    //   423: invokevirtual 779	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   426: invokespecial 560	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: ldc 15
    //   431: iconst_1
    //   432: new 157	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 1038
    //   442: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 779	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload_0
    //   459: aconst_null
    //   460: iconst_0
    //   461: ldc_w 447
    //   464: lconst_0
    //   465: aconst_null
    //   466: aconst_null
    //   467: ldc_w 683
    //   470: sipush 153
    //   473: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   476: bipush -36
    //   478: ldc_w 447
    //   481: ldc_w 447
    //   484: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   487: goto -263 -> 224
    //   490: astore_1
    //   491: aload_0
    //   492: monitorexit
    //   493: aload_1
    //   494: athrow
    //   495: invokestatic 1040	com/tencent/mobileqq/util/Utils:b	()J
    //   498: lstore 13
    //   500: lload 13
    //   502: iload 11
    //   504: ldc_w 1041
    //   507: iadd
    //   508: i2l
    //   509: lcmp
    //   510: ifge +201 -> 711
    //   513: ldc 15
    //   515: iconst_1
    //   516: new 157	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 1043
    //   526: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload 11
    //   531: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: ldc_w 1045
    //   537: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 1041
    //   543: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc_w 1047
    //   549: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: lload 13
    //   554: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_3
    //   564: ldc_w 479
    //   567: iconst_1
    //   568: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload_3
    //   573: ldc_w 490
    //   576: ldc_w 1049
    //   579: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   582: pop
    //   583: aload_0
    //   584: ldc_w 701
    //   587: iconst_2
    //   588: aload 5
    //   590: lconst_0
    //   591: ldc_w 703
    //   594: ldc_w 1051
    //   597: ldc_w 683
    //   600: sipush 153
    //   603: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   606: bipush -12
    //   608: aload 4
    //   610: ldc_w 447
    //   613: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   616: aload_0
    //   617: aload_2
    //   618: iconst_1
    //   619: anewarray 366	java/lang/String
    //   622: dup
    //   623: iconst_0
    //   624: aload_3
    //   625: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   628: aastore
    //   629: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   632: goto -408 -> 224
    //   635: astore_1
    //   636: aload_0
    //   637: iconst_0
    //   638: putfield 120	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   641: aload_0
    //   642: aload_2
    //   643: aload_1
    //   644: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   647: invokespecial 560	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   650: ldc 15
    //   652: iconst_1
    //   653: new 157	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 1053
    //   663: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_1
    //   667: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   670: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: aload_0
    //   680: aconst_null
    //   681: iconst_0
    //   682: ldc_w 447
    //   685: lconst_0
    //   686: aconst_null
    //   687: aconst_null
    //   688: ldc_w 683
    //   691: sipush 153
    //   694: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   697: bipush -35
    //   699: ldc_w 447
    //   702: ldc_w 447
    //   705: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   708: goto -484 -> 224
    //   711: aload_0
    //   712: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   715: invokestatic 1058	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   718: ifne +82 -> 800
    //   721: ldc 15
    //   723: iconst_1
    //   724: ldc_w 1060
    //   727: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aload_3
    //   731: ldc_w 479
    //   734: iconst_5
    //   735: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload_3
    //   740: ldc_w 490
    //   743: ldc_w 1062
    //   746: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload_0
    //   751: aconst_null
    //   752: iconst_2
    //   753: aload 5
    //   755: lconst_0
    //   756: ldc_w 703
    //   759: ldc_w 1064
    //   762: ldc_w 683
    //   765: sipush 153
    //   768: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   771: bipush -13
    //   773: aload 4
    //   775: ldc_w 447
    //   778: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   781: aload_0
    //   782: aload_2
    //   783: iconst_1
    //   784: anewarray 366	java/lang/String
    //   787: dup
    //   788: iconst_0
    //   789: aload_3
    //   790: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   793: aastore
    //   794: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   797: goto -573 -> 224
    //   800: aload_0
    //   801: getfield 120	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   804: ifeq +392 -> 1196
    //   807: aload_0
    //   808: getfield 77	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   811: aload_0
    //   812: getfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   815: invokevirtual 535	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   818: checkcast 537	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   821: astore 7
    //   823: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq +43 -> 869
    //   829: ldc 15
    //   831: iconst_2
    //   832: new 157	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 1066
    //   842: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 5
    //   847: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: ldc_w 1068
    //   853: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: aload_0
    //   857: getfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   860: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   869: aload 5
    //   871: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   874: ifne +158 -> 1032
    //   877: aload 5
    //   879: aload_0
    //   880: getfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   883: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   886: ifeq +146 -> 1032
    //   889: aload 7
    //   891: ifnull +141 -> 1032
    //   894: aload 4
    //   896: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   899: ifne +133 -> 1032
    //   902: aload 4
    //   904: aload 7
    //   906: getfield 688	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   909: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   912: ifeq +120 -> 1032
    //   915: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   918: ifeq +12 -> 930
    //   921: ldc 15
    //   923: iconst_2
    //   924: ldc_w 1070
    //   927: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload_3
    //   931: ldc_w 479
    //   934: bipush 6
    //   936: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   939: pop
    //   940: aload_3
    //   941: ldc_w 490
    //   944: new 157	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 1072
    //   954: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 5
    //   959: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: ldc_w 791
    //   965: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload 4
    //   970: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: ldc_w 1074
    //   976: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   985: pop
    //   986: aload_0
    //   987: aload_2
    //   988: iconst_1
    //   989: anewarray 366	java/lang/String
    //   992: dup
    //   993: iconst_0
    //   994: aload_3
    //   995: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   998: aastore
    //   999: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1002: aload_0
    //   1003: aconst_null
    //   1004: iconst_0
    //   1005: aload 5
    //   1007: lconst_0
    //   1008: aconst_null
    //   1009: aconst_null
    //   1010: ldc_w 683
    //   1013: sipush 153
    //   1016: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1019: bipush 17
    //   1021: aload 4
    //   1023: ldc_w 447
    //   1026: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1029: goto -805 -> 224
    //   1032: aload 7
    //   1034: ifnull +162 -> 1196
    //   1037: new 653	android/os/Bundle
    //   1040: dup
    //   1041: invokespecial 893	android/os/Bundle:<init>	()V
    //   1044: astore 8
    //   1046: aload 8
    //   1048: ldc_w 1012
    //   1051: aload 7
    //   1053: getfield 1077	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1056: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload 8
    //   1061: ldc_w 786
    //   1064: aload_0
    //   1065: getfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   1068: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1071: aload 8
    //   1073: ldc_w 774
    //   1076: aload 5
    //   1078: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1081: aload 8
    //   1083: ldc_w 787
    //   1086: aload 4
    //   1088: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1091: aload_0
    //   1092: ldc_w 784
    //   1095: aload_2
    //   1096: aload_0
    //   1097: getfield 748	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1100: getfield 753	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1103: aload 8
    //   1105: invokestatic 898	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1108: iconst_0
    //   1109: iconst_1
    //   1110: invokespecial 1004	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1113: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1116: ifeq +43 -> 1159
    //   1119: ldc 15
    //   1121: iconst_2
    //   1122: new 157	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1129: ldc_w 1079
    //   1132: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload 5
    //   1137: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: ldc_w 1068
    //   1143: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload_0
    //   1147: getfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   1150: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: aload_0
    //   1160: aconst_null
    //   1161: iconst_2
    //   1162: aload 7
    //   1164: getfield 717	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1167: lconst_0
    //   1168: ldc_w 703
    //   1171: ldc_w 1081
    //   1174: ldc_w 683
    //   1177: sipush 153
    //   1180: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1183: bipush 16
    //   1185: aload 7
    //   1187: getfield 688	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1190: ldc_w 447
    //   1193: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1196: aload_0
    //   1197: aload 5
    //   1199: aload 4
    //   1201: iload 11
    //   1203: i2l
    //   1204: invokespecial 116	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isThemeExist	(Ljava/lang/String;Ljava/lang/String;J)Z
    //   1207: ifeq +206 -> 1413
    //   1210: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq +52 -> 1265
    //   1216: ldc 15
    //   1218: iconst_1
    //   1219: new 157	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1226: ldc_w 1083
    //   1229: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: aload 5
    //   1234: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: ldc_w 791
    //   1240: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: aload 4
    //   1245: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: ldc_w 1023
    //   1251: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: iload 11
    //   1256: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1265: aload_0
    //   1266: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1269: aload 5
    //   1271: invokestatic 837	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   1274: astore_1
    //   1275: aload_1
    //   1276: ifnonnull +654 -> 1930
    //   1279: new 537	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1282: dup
    //   1283: invokespecial 1084	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   1286: astore_1
    //   1287: aload_1
    //   1288: iload 11
    //   1290: i2l
    //   1291: putfield 540	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1294: aload_1
    //   1295: iload 11
    //   1297: i2l
    //   1298: putfield 862	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1301: aload_1
    //   1302: aload 5
    //   1304: putfield 717	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1307: aload_1
    //   1308: aload 4
    //   1310: putfield 688	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1313: aload_1
    //   1314: ldc_w 562
    //   1317: putfield 545	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1320: iload 10
    //   1322: iconst_1
    //   1323: if_icmpne +610 -> 1933
    //   1326: iconst_1
    //   1327: istore 15
    //   1329: aload_1
    //   1330: iload 15
    //   1332: putfield 951	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   1335: aload_0
    //   1336: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1339: aload_1
    //   1340: invokestatic 552	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1343: pop
    //   1344: aload_3
    //   1345: ldc_w 479
    //   1348: iconst_3
    //   1349: invokevirtual 483	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1352: pop
    //   1353: aload_3
    //   1354: ldc_w 490
    //   1357: ldc_w 1086
    //   1360: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1363: pop
    //   1364: aload_0
    //   1365: aload_2
    //   1366: iconst_1
    //   1367: anewarray 366	java/lang/String
    //   1370: dup
    //   1371: iconst_0
    //   1372: aload_3
    //   1373: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1376: aastore
    //   1377: invokespecial 497	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1380: aload_0
    //   1381: aconst_null
    //   1382: iconst_0
    //   1383: aload 5
    //   1385: lconst_0
    //   1386: ldc_w 703
    //   1389: ldc_w 1088
    //   1392: ldc_w 683
    //   1395: sipush 153
    //   1398: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1401: iconst_2
    //   1402: aload 4
    //   1404: ldc_w 447
    //   1407: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1410: goto -1186 -> 224
    //   1413: aload_1
    //   1414: ldc_w 1090
    //   1417: invokevirtual 924	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1420: ifeq +525 -> 1945
    //   1423: aload_1
    //   1424: ldc_w 1090
    //   1427: invokevirtual 927	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1430: ifne +509 -> 1939
    //   1433: iconst_1
    //   1434: istore 9
    //   1436: aload_0
    //   1437: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   1440: new 157	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1447: aload 5
    //   1449: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: ldc_w 610
    //   1455: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: aload 4
    //   1460: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: invokevirtual 972	java/lang/String:hashCode	()I
    //   1469: invokestatic 975	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1472: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1475: invokevirtual 548	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1478: pop
    //   1479: aload_0
    //   1480: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1483: invokestatic 1093	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   1486: istore 12
    //   1488: iload 9
    //   1490: ifeq +155 -> 1645
    //   1493: iload 12
    //   1495: iconst_1
    //   1496: if_icmple +149 -> 1645
    //   1499: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1502: ifeq +12 -> 1514
    //   1505: ldc 15
    //   1507: iconst_2
    //   1508: ldc_w 1095
    //   1511: invokestatic 348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1514: aload_0
    //   1515: new 1097	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3
    //   1518: dup
    //   1519: aload_0
    //   1520: aload_0
    //   1521: getfield 278	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1524: invokevirtual 284	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1527: ldc_w 1098
    //   1530: aload_2
    //   1531: aload 5
    //   1533: aload 4
    //   1535: invokespecial 1101	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1538: putfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1541: aload_0
    //   1542: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1545: ldc_w 1104
    //   1548: invokevirtual 1110	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   1551: aload_0
    //   1552: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1555: ldc_w 1112
    //   1558: invokevirtual 1116	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1561: pop
    //   1562: aload_0
    //   1563: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1566: ldc_w 1117
    //   1569: invokevirtual 1121	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1572: pop
    //   1573: aload_0
    //   1574: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1577: iconst_0
    //   1578: invokevirtual 1124	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   1581: aload_0
    //   1582: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1585: ldc_w 1125
    //   1588: new 1127	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   1591: dup
    //   1592: aload_0
    //   1593: aload_2
    //   1594: aload 5
    //   1596: aload 4
    //   1598: invokespecial 1130	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1601: invokevirtual 1134	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1604: pop
    //   1605: aload_0
    //   1606: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1609: ldc_w 1135
    //   1612: new 1137	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   1615: dup
    //   1616: aload_0
    //   1617: aload 5
    //   1619: aload 4
    //   1621: aload 6
    //   1623: iload 11
    //   1625: iload 10
    //   1627: aload_2
    //   1628: invokespecial 1140	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   1631: invokevirtual 1143	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1634: pop
    //   1635: aload_0
    //   1636: getfield 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1639: invokevirtual 1146	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1642: goto -1418 -> 224
    //   1645: aload_0
    //   1646: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1649: aload 5
    //   1651: aload 4
    //   1653: invokestatic 184	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1656: astore 7
    //   1658: aload_0
    //   1659: iconst_1
    //   1660: putfield 120	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   1663: aload_0
    //   1664: getfield 77	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1667: aload 5
    //   1669: invokevirtual 535	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1672: checkcast 537	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1675: astore_3
    //   1676: aload_3
    //   1677: astore_1
    //   1678: aload_3
    //   1679: ifnonnull +27 -> 1706
    //   1682: aload_0
    //   1683: getfield 104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1686: aload 5
    //   1688: invokestatic 837	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   1691: astore_3
    //   1692: aload_3
    //   1693: astore_1
    //   1694: aload_3
    //   1695: ifnull +11 -> 1706
    //   1698: aload_3
    //   1699: aload 6
    //   1701: putfield 1077	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1704: aload_3
    //   1705: astore_1
    //   1706: aload_1
    //   1707: ifnull +17 -> 1724
    //   1710: aload_1
    //   1711: astore_3
    //   1712: aload_1
    //   1713: getfield 688	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1716: aload 4
    //   1718: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1721: ifne +63 -> 1784
    //   1724: new 537	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1727: dup
    //   1728: invokespecial 1084	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   1731: astore_3
    //   1732: aload_3
    //   1733: aload 5
    //   1735: putfield 717	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1738: aload_3
    //   1739: aload 6
    //   1741: putfield 1077	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1744: aload_3
    //   1745: iload 11
    //   1747: i2l
    //   1748: putfield 862	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1751: aload_3
    //   1752: lconst_0
    //   1753: putfield 540	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1756: aload_3
    //   1757: aload 4
    //   1759: putfield 688	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1762: aload_3
    //   1763: ldc_w 468
    //   1766: putfield 545	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1769: iload 10
    //   1771: iconst_1
    //   1772: if_icmpne +152 -> 1924
    //   1775: iconst_1
    //   1776: istore 15
    //   1778: aload_3
    //   1779: iload 15
    //   1781: putfield 951	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   1784: aload_0
    //   1785: getfield 77	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1788: aload 5
    //   1790: aload_3
    //   1791: invokevirtual 548	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1794: pop
    //   1795: aload_0
    //   1796: aload 5
    //   1798: putfield 124	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   1801: aload 5
    //   1803: putstatic 455	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:loadingThemeIdForJsCall	Ljava/lang/String;
    //   1806: aload_0
    //   1807: aload_2
    //   1808: putfield 127	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeDownloadCallbackId	Ljava/lang/String;
    //   1811: new 653	android/os/Bundle
    //   1814: dup
    //   1815: invokespecial 893	android/os/Bundle:<init>	()V
    //   1818: astore_1
    //   1819: aload_1
    //   1820: ldc_w 1012
    //   1823: aload 6
    //   1825: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1828: aload_1
    //   1829: ldc_w 1148
    //   1832: aload 7
    //   1834: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1837: aload_1
    //   1838: ldc_w 774
    //   1841: aload 5
    //   1843: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1846: aload_1
    //   1847: ldc_w 787
    //   1850: aload 4
    //   1852: invokevirtual 1003	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1855: aload_1
    //   1856: ldc_w 1017
    //   1859: iload 11
    //   1861: i2l
    //   1862: invokevirtual 1152	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1865: aload_1
    //   1866: ldc_w 1154
    //   1869: aload_3
    //   1870: invokevirtual 1158	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1873: aload_0
    //   1874: ldc_w 759
    //   1877: aload_2
    //   1878: aload_0
    //   1879: getfield 748	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1882: getfield 753	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1885: aload_1
    //   1886: invokestatic 898	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1889: iconst_0
    //   1890: iconst_1
    //   1891: invokespecial 1004	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1894: aload_0
    //   1895: aconst_null
    //   1896: iconst_0
    //   1897: aload 5
    //   1899: lconst_0
    //   1900: aconst_null
    //   1901: aconst_null
    //   1902: ldc_w 683
    //   1905: sipush 153
    //   1908: getstatic 710	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1911: bipush 11
    //   1913: aload 4
    //   1915: ldc_w 447
    //   1918: invokevirtual 451	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1921: goto -1697 -> 224
    //   1924: iconst_0
    //   1925: istore 15
    //   1927: goto -149 -> 1778
    //   1930: goto -643 -> 1287
    //   1933: iconst_0
    //   1934: istore 15
    //   1936: goto -607 -> 1329
    //   1939: iconst_0
    //   1940: istore 9
    //   1942: goto -506 -> 1436
    //   1945: iconst_1
    //   1946: istore 9
    //   1948: goto -512 -> 1436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1951	0	this	ThemeJsPlugin
    //   0	1951	1	paramJSONObject	JSONObject
    //   0	1951	2	paramString	String
    //   70	1800	3	localObject1	Object
    //   24	1890	4	str1	String
    //   33	1865	5	str2	String
    //   15	1809	6	str3	String
    //   821	1012	7	localObject2	Object
    //   1044	60	8	localBundle	Bundle
    //   1434	513	9	i	int
    //   61	1712	10	j	int
    //   42	1818	11	k	int
    //   1486	11	12	m	int
    //   498	55	13	l	long
    //   1327	608	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	63	414	org/json/JSONException
    //   63	95	414	org/json/JSONException
    //   100	224	414	org/json/JSONException
    //   233	299	414	org/json/JSONException
    //   299	411	414	org/json/JSONException
    //   495	500	414	org/json/JSONException
    //   513	632	414	org/json/JSONException
    //   711	797	414	org/json/JSONException
    //   800	869	414	org/json/JSONException
    //   869	889	414	org/json/JSONException
    //   894	930	414	org/json/JSONException
    //   930	1029	414	org/json/JSONException
    //   1037	1159	414	org/json/JSONException
    //   1159	1196	414	org/json/JSONException
    //   1196	1265	414	org/json/JSONException
    //   1265	1275	414	org/json/JSONException
    //   1279	1287	414	org/json/JSONException
    //   1287	1320	414	org/json/JSONException
    //   1329	1410	414	org/json/JSONException
    //   1413	1433	414	org/json/JSONException
    //   1436	1488	414	org/json/JSONException
    //   1499	1514	414	org/json/JSONException
    //   1514	1642	414	org/json/JSONException
    //   1645	1676	414	org/json/JSONException
    //   1682	1692	414	org/json/JSONException
    //   1698	1704	414	org/json/JSONException
    //   1712	1724	414	org/json/JSONException
    //   1724	1769	414	org/json/JSONException
    //   1778	1784	414	org/json/JSONException
    //   1784	1921	414	org/json/JSONException
    //   2	63	490	finally
    //   63	95	490	finally
    //   100	224	490	finally
    //   233	299	490	finally
    //   299	411	490	finally
    //   415	487	490	finally
    //   495	500	490	finally
    //   513	632	490	finally
    //   636	708	490	finally
    //   711	797	490	finally
    //   800	869	490	finally
    //   869	889	490	finally
    //   894	930	490	finally
    //   930	1029	490	finally
    //   1037	1159	490	finally
    //   1159	1196	490	finally
    //   1196	1265	490	finally
    //   1265	1275	490	finally
    //   1279	1287	490	finally
    //   1287	1320	490	finally
    //   1329	1410	490	finally
    //   1413	1433	490	finally
    //   1436	1488	490	finally
    //   1499	1514	490	finally
    //   1514	1642	490	finally
    //   1645	1676	490	finally
    //   1682	1692	490	finally
    //   1698	1704	490	finally
    //   1712	1724	490	finally
    //   1724	1769	490	finally
    //   1778	1784	490	finally
    //   1784	1921	490	finally
    //   2	63	635	java/lang/Exception
    //   63	95	635	java/lang/Exception
    //   100	224	635	java/lang/Exception
    //   233	299	635	java/lang/Exception
    //   299	411	635	java/lang/Exception
    //   495	500	635	java/lang/Exception
    //   513	632	635	java/lang/Exception
    //   711	797	635	java/lang/Exception
    //   800	869	635	java/lang/Exception
    //   869	889	635	java/lang/Exception
    //   894	930	635	java/lang/Exception
    //   930	1029	635	java/lang/Exception
    //   1037	1159	635	java/lang/Exception
    //   1159	1196	635	java/lang/Exception
    //   1196	1265	635	java/lang/Exception
    //   1265	1275	635	java/lang/Exception
    //   1279	1287	635	java/lang/Exception
    //   1287	1320	635	java/lang/Exception
    //   1329	1410	635	java/lang/Exception
    //   1413	1433	635	java/lang/Exception
    //   1436	1488	635	java/lang/Exception
    //   1499	1514	635	java/lang/Exception
    //   1514	1642	635	java/lang/Exception
    //   1645	1676	635	java/lang/Exception
    //   1682	1692	635	java/lang/Exception
    //   1698	1704	635	java/lang/Exception
    //   1712	1724	635	java/lang/Exception
    //   1724	1769	635	java/lang/Exception
    //   1778	1784	635	java/lang/Exception
    //   1784	1921	635	java/lang/Exception
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramJSONObject);
      if (localThemeInfo != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("url", localThemeInfo.downloadUrl);
        localBundle.putString("id", paramJSONObject);
        sendRemoteReq(DataFactory.a("stopdownload", paramString, this.mOnRemoteResp.key, localBundle), true, true);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "stopDownload, url=" + localThemeInfo.downloadUrl);
        }
        reportTheme(null, 0, paramJSONObject, 0L, null, null, "200", 153, ThemeReporter.t, 22, localThemeInfo.version, "");
        return;
      }
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "not in down queue");
      super.callJs(paramString, new String[] { paramJSONObject.toString() });
      return;
    }
    catch (JSONException paramJSONObject)
    {
      super.callJsOnError(paramString, "(stopdown theme JsonException:" + paramJSONObject.getMessage() + ");");
      QLog.e("ThemeJsPlugin", 1, "stopDownload Exception：" + paramJSONObject.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */