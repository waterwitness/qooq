package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.TaskThread;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wta;
import wtb;
import wtc;
import wtd;
import wte;
import wtf;

public class BaseJsCallBack
  extends BaseInterface
{
  public static final String LOG_TAG = "BaseJsCallBack";
  public static final String PLUGIN_NAMESPACE = "qqZoneAppList";
  public static boolean isUpdateAssets;
  public Activity activity;
  LastDownloadAction lastActionRecord;
  protected Handler mHandler;
  public String timePointParams;
  protected String urlParams;
  
  public BaseJsCallBack(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.urlParams = "";
    this.timePointParams = "";
    this.lastActionRecord = null;
    this.activity = paramActivity;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean appIsExists(String paramString)
  {
    return AppUtil.a(paramString);
  }
  
  public String appIsExistsBatch(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return "";
    }
    Object localObject = paramString1.split(paramString2);
    if (localObject.length == 0) {
      return "";
    }
    paramString1 = new LinkedHashMap();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if ((str != null) && (str.length() > 0))
      {
        if (!AppUtil.a(str)) {
          break label99;
        }
        paramString1.put(str, Integer.valueOf(1));
      }
      for (;;)
      {
        i += 1;
        break;
        label99:
        paramString1.put(str, Integer.valueOf(0));
      }
    }
    localObject = new StringBuilder();
    paramString1 = paramString1.entrySet().iterator();
    while (paramString1.hasNext()) {
      ((StringBuilder)localObject).append(((Map.Entry)paramString1.next()).getValue()).append(paramString2);
    }
    if (((StringBuilder)localObject).length() == 0) {
      return "";
    }
    LogUtility.c("BaseJsCallBack", "appIsExistsBatch >>>" + ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1));
    return ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
  }
  
  public void back()
  {
    this.activity.finish();
  }
  
  public void cgiReport(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      int i = Integer.parseInt(paramString3);
      ReportManager.a().a(paramString1, SystemClock.elapsedRealtime() - l, 0L, 0L, i, CommonDataAdapter.a().a(), "1000002", null);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void changeLoadingTip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.post(new wtf(this, paramString));
  }
  
  public void checkUpdateRes()
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--checkUpdateRes");
    ((AppViewBaseActivity)this.activity).n();
  }
  
  public void clearJS()
  {
    LogUtility.e("BaseJsCallBack", "clearJS");
    TaskThread.a().a(13);
  }
  
  public int getAPNType()
  {
    int k = -1;
    Object localObject = (ConnectivityManager)this.activity.getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while (localObject == null);
    i = k;
    for (;;)
    {
      try
      {
        j = ((NetworkInfo)localObject).getType();
        if (j != 0) {
          continue;
        }
        j = k;
        i = k;
        if (((NetworkInfo)localObject).getExtraInfo() == null) {
          j = 2;
        }
        i = j;
        boolean bool = ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.ENGLISH).equals("cmnet");
        if (!bool) {
          continue;
        }
        i = 3;
      }
      catch (Exception localException)
      {
        int j;
        LogUtility.c("BaseJsCallBack", "getAPNType EX >>> ", localException);
        continue;
        i = -1;
        continue;
      }
      return i;
      i = 2;
      continue;
      if (j != 1) {
        continue;
      }
      i = 1;
    }
  }
  
  public String getAgentVersion()
  {
    return CommonDataAdapter.a().d();
  }
  
  public String getAppVersionCode(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("packageName");
      localObject = ((JSONObject)localObject).optString("appid");
      int i = 0;
      if (AppUtil.a(paramString)) {
        i = AppUtil.a(paramString);
      }
      paramString = new JSONObject();
      paramString.put("installedVersionCode", i);
      paramString.put("downloadedVersionCode ", AppUtil.b(DownloadManager.a().a((String)localObject)));
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAppVersionCodeBatch(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          if (localObject2 == null) {
            break label146;
          }
          Object localObject1 = ((JSONObject)localObject2).getString("packageName");
          localObject2 = ((JSONObject)localObject2).getString("appid");
          if (!AppUtil.a((String)localObject1)) {
            break label140;
          }
          j = AppUtil.a((String)localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("installedVersionCode", j);
          ((JSONObject)localObject1).put("downloadedVersionCode", AppUtil.b(DownloadManager.a().a((String)localObject2)));
          localJSONObject.put((String)localObject2, localObject1);
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "getAppVersionCode ", paramString);
      }
      return localJSONObject.toString();
      label140:
      int j = 0;
      continue;
      label146:
      i += 1;
    }
  }
  
  public String getCurrentVersion()
  {
    return CommonDataAdapter.a().b();
  }
  
  public String getDisplay()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    return i + "x" + j;
  }
  
  protected String[] getFileUrl(String paramString)
  {
    return Common.a(paramString);
  }
  
  public String getInterfaceName()
  {
    return "qqZoneAppList";
  }
  
  public String getMobileInfo()
  {
    return MobileInfoUtil.i();
  }
  
  public String getPageTimePoint()
  {
    return this.timePointParams;
  }
  
  public String getParams()
  {
    return this.urlParams;
  }
  
  public String getPlatform()
  {
    return CommonDataAdapter.a().g();
  }
  
  public String getSid()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return CommonDataAdapter.a().a();
  }
  
  public String getUin()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return String.valueOf(CommonDataAdapter.a().a());
  }
  
  public void goOldDetail(String paramString)
  {
    AppClient.a(this.activity, paramString);
  }
  
  public void goToDetailPage(String paramString1, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    Object localObject;
    boolean bool1;
    boolean bool2;
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = new Bundle();
      paramString2.putString(DownloadConstants.a, paramString1.optString("appid"));
      paramString2.putString(DownloadConstants.e, paramString1.optString("packageName"));
      paramString2.putString(DownloadConstants.h, paramString1.optString("via"));
      paramString2.putString(DownloadConstants.b, paramString1.optString("myAppId"));
      paramString2.putString(DownloadConstants.c, paramString1.optString("apkId"));
      paramString2.putInt(DownloadConstants.d, paramString1.optInt("versionCode"));
      localObject = paramString1.optString("via");
      String str = paramString1.optString("appid");
      int i = paramString1.optInt("actionCode");
      if (this.lastActionRecord == null) {
        this.lastActionRecord = new LastDownloadAction(str, (String)localObject, i);
      }
      while (!this.lastActionRecord.a(str, (String)localObject, i))
      {
        bool1 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoDownload"));
        bool2 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoInstall"));
        localObject = DownloadManager.a().a(paramString1.optString("appid"));
        if (localObject != null) {
          break label270;
        }
        if (!MyAppApi.a().c()) {
          break;
        }
        ThreadManager.b().post(new wtb(this, paramString2, bool1, bool2));
        return;
      }
      return;
      goUrl(paramString1.optString("url"), true);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("BaseJsCallBack", "goToDetailPage>>>", paramString1);
      return;
    }
    label270:
    if ((((DownloadInfo)localObject).h == 1) && (MyAppApi.a().b()))
    {
      ThreadManager.b().post(new wtc(this, paramString2, bool1, bool2));
      return;
    }
    goUrl(paramString1.optString("url"), true);
  }
  
  public void goToDownloadTaskList(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new JSONObject(paramString);
      localBundle.putString(DownloadConstants.h, paramString.optString("via"));
      ThreadManager.b().post(new wtd(this, localBundle));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtility.c("BaseJsCallBack", "goToDetailPage>>>", paramString);
    }
  }
  
  public void goUrl(String paramString)
  {
    boolean bool = true;
    if (!hasRight()) {
      return;
    }
    LogUtility.c("BaseJsCallBack", paramString);
    Object localObject3;
    JSONArray localJSONArray;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      localObject3 = paramString.optString("url");
      localJSONArray = paramString.optJSONArray("titleInfo");
      j = paramString.optInt("current");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        LogUtility.e("BaseJsCallBack", "gourl strUrl == null");
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramString = getFileUrl((String)localObject3);
    Object localObject1 = paramString[0];
    Object localObject2 = paramString[1];
    paramString = (String)localObject1;
    if (((String)localObject1).equals(localObject3)) {
      if (((String)localObject1).indexOf("?") != -1) {
        break label315;
      }
    }
    label315:
    for (localObject1 = (String)localObject1 + "?";; localObject1 = (String)localObject1 + "&")
    {
      paramString = (String)localObject1;
      if (((String)localObject1).indexOf("{UIN}") > 0) {
        paramString = ((String)localObject1).replaceAll("\\{UIN\\}", CommonDataAdapter.a().a() + "");
      }
      localObject1 = new Intent(this.activity, QZoneAppWebViewActivity.class);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("APP_URL", paramString);
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        ((Bundle)localObject3).putString("APP_PARAMS", (String)localObject2);
      }
      if (localJSONArray == null) {
        break label416;
      }
      int k = localJSONArray.length();
      paramString = new ArrayList();
      localObject2 = new ArrayList();
      int i = 0;
      while (i < k)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        paramString.add(localJSONObject.optString("name"));
        ((ArrayList)localObject2).add(localJSONObject.optString("tipNum"));
        i += 1;
      }
    }
    ((Bundle)localObject3).putStringArrayList("titleName", paramString);
    ((Bundle)localObject3).putStringArrayList("titleTip", (ArrayList)localObject2);
    if (paramString.size() > 0) {}
    for (;;)
    {
      ((Bundle)localObject3).putBoolean("showTitle", bool);
      LogUtility.c("BaseJsCallBack", "array = " + paramString.toString() + " | " + paramString.size());
      label416:
      ((Bundle)localObject3).putInt("current", j);
      ((Bundle)localObject3).putString("uin", String.valueOf(CommonDataAdapter.a().a()));
      ((Bundle)localObject3).putString("sid", CommonDataAdapter.a().a());
      ((Intent)localObject1).putExtras((Bundle)localObject3);
      this.activity.startActivityForResult((Intent)localObject1, 200);
      return;
      bool = false;
    }
  }
  
  protected void goUrl(String paramString, boolean paramBoolean)
  {
    if (!hasRight()) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(this.activity.getString(2131363041));
      localJSONObject.put("url", paramString);
      localJSONObject.put("titleName", localJSONArray);
      goUrl(localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("BaseJsCallBack", "gourl(onlyurl) error ", paramString);
    }
  }
  
  /* Error */
  public void goWebApp(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 383	com/tencent/open/appcommon/js/BaseJsCallBack:hasRight	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: ldc 33
    //   10: astore_2
    //   11: iconst_0
    //   12: istore 32
    //   14: iconst_0
    //   15: istore 13
    //   17: iconst_0
    //   18: istore 31
    //   20: iconst_0
    //   21: istore 14
    //   23: iconst_0
    //   24: istore 30
    //   26: iconst_0
    //   27: istore 15
    //   29: iconst_0
    //   30: istore 29
    //   32: iconst_0
    //   33: istore 16
    //   35: iconst_0
    //   36: istore 28
    //   38: iconst_0
    //   39: istore 17
    //   41: ldc 33
    //   43: astore 10
    //   45: ldc 33
    //   47: astore_3
    //   48: ldc 33
    //   50: astore 11
    //   52: aload_3
    //   53: astore 4
    //   55: aload 10
    //   57: astore 6
    //   59: iload 17
    //   61: istore 18
    //   63: iload 16
    //   65: istore 20
    //   67: iload 15
    //   69: istore 22
    //   71: iload 14
    //   73: istore 24
    //   75: iload 13
    //   77: istore 26
    //   79: aload_2
    //   80: astore 8
    //   82: aload_3
    //   83: astore 5
    //   85: aload 10
    //   87: astore 7
    //   89: iload 28
    //   91: istore 19
    //   93: iload 29
    //   95: istore 21
    //   97: iload 30
    //   99: istore 23
    //   101: iload 31
    //   103: istore 25
    //   105: iload 32
    //   107: istore 27
    //   109: aload_2
    //   110: astore 9
    //   112: new 277	org/json/JSONObject
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 279	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore 12
    //   122: aload_3
    //   123: astore 4
    //   125: aload 10
    //   127: astore 6
    //   129: iload 17
    //   131: istore 18
    //   133: iload 16
    //   135: istore 20
    //   137: iload 15
    //   139: istore 22
    //   141: iload 14
    //   143: istore 24
    //   145: iload 13
    //   147: istore 26
    //   149: aload_2
    //   150: astore 8
    //   152: aload_3
    //   153: astore 5
    //   155: aload 10
    //   157: astore 7
    //   159: iload 28
    //   161: istore 19
    //   163: iload 29
    //   165: istore 21
    //   167: iload 30
    //   169: istore 23
    //   171: iload 31
    //   173: istore 25
    //   175: iload 32
    //   177: istore 27
    //   179: aload_2
    //   180: astore 9
    //   182: aload 12
    //   184: ldc_w 286
    //   187: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore_1
    //   191: aload_3
    //   192: astore 4
    //   194: aload_1
    //   195: astore 6
    //   197: iload 17
    //   199: istore 18
    //   201: iload 16
    //   203: istore 20
    //   205: iload 15
    //   207: istore 22
    //   209: iload 14
    //   211: istore 24
    //   213: iload 13
    //   215: istore 26
    //   217: aload_2
    //   218: astore 8
    //   220: aload_3
    //   221: astore 5
    //   223: aload_1
    //   224: astore 7
    //   226: iload 28
    //   228: istore 19
    //   230: iload 29
    //   232: istore 21
    //   234: iload 30
    //   236: istore 23
    //   238: iload 31
    //   240: istore 25
    //   242: iload 32
    //   244: istore 27
    //   246: aload_2
    //   247: astore 9
    //   249: aload 12
    //   251: ldc_w 606
    //   254: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore_2
    //   258: aload_3
    //   259: astore 4
    //   261: aload_1
    //   262: astore 6
    //   264: iload 17
    //   266: istore 18
    //   268: iload 16
    //   270: istore 20
    //   272: iload 15
    //   274: istore 22
    //   276: iload 14
    //   278: istore 24
    //   280: iload 13
    //   282: istore 26
    //   284: aload_2
    //   285: astore 8
    //   287: aload_3
    //   288: astore 5
    //   290: aload_1
    //   291: astore 7
    //   293: iload 28
    //   295: istore 19
    //   297: iload 29
    //   299: istore 21
    //   301: iload 30
    //   303: istore 23
    //   305: iload 31
    //   307: istore 25
    //   309: iload 32
    //   311: istore 27
    //   313: aload_2
    //   314: astore 9
    //   316: aload 12
    //   318: ldc_w 608
    //   321: invokevirtual 434	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   324: istore 13
    //   326: aload_3
    //   327: astore 4
    //   329: aload_1
    //   330: astore 6
    //   332: iload 17
    //   334: istore 18
    //   336: iload 16
    //   338: istore 20
    //   340: iload 15
    //   342: istore 22
    //   344: iload 14
    //   346: istore 24
    //   348: iload 13
    //   350: istore 26
    //   352: aload_2
    //   353: astore 8
    //   355: aload_3
    //   356: astore 5
    //   358: aload_1
    //   359: astore 7
    //   361: iload 28
    //   363: istore 19
    //   365: iload 29
    //   367: istore 21
    //   369: iload 30
    //   371: istore 23
    //   373: iload 31
    //   375: istore 25
    //   377: iload 13
    //   379: istore 27
    //   381: aload_2
    //   382: astore 9
    //   384: aload 12
    //   386: ldc_w 610
    //   389: invokevirtual 434	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   392: istore 14
    //   394: aload_3
    //   395: astore 4
    //   397: aload_1
    //   398: astore 6
    //   400: iload 17
    //   402: istore 18
    //   404: iload 16
    //   406: istore 20
    //   408: iload 15
    //   410: istore 22
    //   412: iload 14
    //   414: istore 24
    //   416: iload 13
    //   418: istore 26
    //   420: aload_2
    //   421: astore 8
    //   423: aload_3
    //   424: astore 5
    //   426: aload_1
    //   427: astore 7
    //   429: iload 28
    //   431: istore 19
    //   433: iload 29
    //   435: istore 21
    //   437: iload 30
    //   439: istore 23
    //   441: iload 14
    //   443: istore 25
    //   445: iload 13
    //   447: istore 27
    //   449: aload_2
    //   450: astore 9
    //   452: aload 12
    //   454: ldc_w 612
    //   457: invokevirtual 434	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   460: istore 15
    //   462: aload_3
    //   463: astore 4
    //   465: aload_1
    //   466: astore 6
    //   468: iload 17
    //   470: istore 18
    //   472: iload 16
    //   474: istore 20
    //   476: iload 15
    //   478: istore 22
    //   480: iload 14
    //   482: istore 24
    //   484: iload 13
    //   486: istore 26
    //   488: aload_2
    //   489: astore 8
    //   491: aload_3
    //   492: astore 5
    //   494: aload_1
    //   495: astore 7
    //   497: iload 28
    //   499: istore 19
    //   501: iload 29
    //   503: istore 21
    //   505: iload 15
    //   507: istore 23
    //   509: iload 14
    //   511: istore 25
    //   513: iload 13
    //   515: istore 27
    //   517: aload_2
    //   518: astore 9
    //   520: aload 12
    //   522: ldc_w 614
    //   525: invokevirtual 434	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   528: istore 16
    //   530: aload_3
    //   531: astore 4
    //   533: aload_1
    //   534: astore 6
    //   536: iload 17
    //   538: istore 18
    //   540: iload 16
    //   542: istore 20
    //   544: iload 15
    //   546: istore 22
    //   548: iload 14
    //   550: istore 24
    //   552: iload 13
    //   554: istore 26
    //   556: aload_2
    //   557: astore 8
    //   559: aload_3
    //   560: astore 5
    //   562: aload_1
    //   563: astore 7
    //   565: iload 28
    //   567: istore 19
    //   569: iload 16
    //   571: istore 21
    //   573: iload 15
    //   575: istore 23
    //   577: iload 14
    //   579: istore 25
    //   581: iload 13
    //   583: istore 27
    //   585: aload_2
    //   586: astore 9
    //   588: aload 12
    //   590: ldc_w 616
    //   593: invokevirtual 434	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   596: istore 17
    //   598: aload_3
    //   599: astore 4
    //   601: aload_1
    //   602: astore 6
    //   604: iload 17
    //   606: istore 18
    //   608: iload 16
    //   610: istore 20
    //   612: iload 15
    //   614: istore 22
    //   616: iload 14
    //   618: istore 24
    //   620: iload 13
    //   622: istore 26
    //   624: aload_2
    //   625: astore 8
    //   627: aload_3
    //   628: astore 5
    //   630: aload_1
    //   631: astore 7
    //   633: iload 17
    //   635: istore 19
    //   637: iload 16
    //   639: istore 21
    //   641: iload 15
    //   643: istore 23
    //   645: iload 14
    //   647: istore 25
    //   649: iload 13
    //   651: istore 27
    //   653: aload_2
    //   654: astore 9
    //   656: aload 12
    //   658: ldc_w 618
    //   661: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   664: astore_3
    //   665: aload_3
    //   666: astore 4
    //   668: aload_1
    //   669: astore 6
    //   671: iload 17
    //   673: istore 18
    //   675: iload 16
    //   677: istore 20
    //   679: iload 15
    //   681: istore 22
    //   683: iload 14
    //   685: istore 24
    //   687: iload 13
    //   689: istore 26
    //   691: aload_2
    //   692: astore 8
    //   694: aload_3
    //   695: astore 5
    //   697: aload_1
    //   698: astore 7
    //   700: iload 17
    //   702: istore 19
    //   704: iload 16
    //   706: istore 21
    //   708: iload 15
    //   710: istore 23
    //   712: iload 14
    //   714: istore 25
    //   716: iload 13
    //   718: istore 27
    //   720: aload_2
    //   721: astore 9
    //   723: aload 12
    //   725: ldc_w 620
    //   728: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   731: astore 10
    //   733: aload 10
    //   735: astore 4
    //   737: aload 12
    //   739: ldc_w 622
    //   742: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   745: astore 5
    //   747: ldc 8
    //   749: new 91	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 624
    //   759: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_2
    //   763: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: ldc_w 579
    //   769: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: iload 13
    //   774: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   777: ldc_w 579
    //   780: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: iload 15
    //   785: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   788: ldc_w 579
    //   791: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: iload 14
    //   796: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   799: ldc_w 579
    //   802: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: iload 16
    //   807: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: ldc_w 579
    //   813: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload_3
    //   817: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 579
    //   823: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 4
    //   828: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: ldc_w 579
    //   834: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: iload 17
    //   839: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: ldc_w 579
    //   845: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_1
    //   849: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc_w 579
    //   855: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload 5
    //   860: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: ldc_w 579
    //   866: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: iconst_0
    //   870: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   873: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 141	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: new 534	android/content/Intent
    //   882: dup
    //   883: aload_0
    //   884: getfield 41	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   887: ldc_w 626
    //   890: invokespecial 539	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   893: astore 5
    //   895: new 404	android/os/Bundle
    //   898: dup
    //   899: invokespecial 405	android/os/Bundle:<init>	()V
    //   902: astore 6
    //   904: aload 6
    //   906: ldc_w 483
    //   909: aload_2
    //   910: invokevirtual 412	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   913: aload 6
    //   915: ldc_w 608
    //   918: iload 13
    //   920: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   923: aload 6
    //   925: ldc_w 612
    //   928: iload 15
    //   930: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   933: aload 6
    //   935: ldc_w 610
    //   938: iload 14
    //   940: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   943: aload 6
    //   945: ldc_w 614
    //   948: iload 16
    //   950: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   953: aload 6
    //   955: ldc_w 618
    //   958: aload_3
    //   959: invokevirtual 412	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   962: aload 6
    //   964: ldc_w 620
    //   967: aload 4
    //   969: invokevirtual 412	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   972: aload 6
    //   974: ldc_w 616
    //   977: iload 17
    //   979: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   982: aload 6
    //   984: ldc_w 628
    //   987: aload_1
    //   988: invokevirtual 412	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: aload 5
    //   993: aload 6
    //   995: invokevirtual 587	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 41	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   1003: aload 5
    //   1005: invokevirtual 632	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1008: return
    //   1009: astore 5
    //   1011: ldc 33
    //   1013: astore 7
    //   1015: aload 8
    //   1017: astore_2
    //   1018: iload 26
    //   1020: istore 13
    //   1022: iload 24
    //   1024: istore 14
    //   1026: iload 22
    //   1028: istore 15
    //   1030: iload 20
    //   1032: istore 16
    //   1034: iload 18
    //   1036: istore 17
    //   1038: aload 6
    //   1040: astore_1
    //   1041: aload 4
    //   1043: astore_3
    //   1044: aload 7
    //   1046: astore 4
    //   1048: aload 5
    //   1050: invokevirtual 515	org/json/JSONException:printStackTrace	()V
    //   1053: ldc 8
    //   1055: ldc_w 634
    //   1058: aload 5
    //   1060: invokestatic 269	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1063: aload 11
    //   1065: astore 5
    //   1067: goto -320 -> 747
    //   1070: astore 6
    //   1072: ldc 33
    //   1074: astore 4
    //   1076: aload 9
    //   1078: astore_2
    //   1079: iload 27
    //   1081: istore 13
    //   1083: iload 25
    //   1085: istore 14
    //   1087: iload 23
    //   1089: istore 15
    //   1091: iload 21
    //   1093: istore 16
    //   1095: iload 19
    //   1097: istore 17
    //   1099: aload 7
    //   1101: astore_1
    //   1102: aload 5
    //   1104: astore_3
    //   1105: aload 6
    //   1107: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   1110: ldc 8
    //   1112: ldc_w 636
    //   1115: aload 6
    //   1117: invokestatic 269	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1120: aload 11
    //   1122: astore 5
    //   1124: goto -377 -> 747
    //   1127: astore 6
    //   1129: goto -24 -> 1105
    //   1132: astore 5
    //   1134: goto -86 -> 1048
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	BaseJsCallBack
    //   0	1137	1	paramString	String
    //   10	1069	2	localObject1	Object
    //   47	1058	3	localObject2	Object
    //   53	1022	4	localObject3	Object
    //   83	921	5	localObject4	Object
    //   1009	50	5	localJSONException1	JSONException
    //   1065	58	5	str1	String
    //   1132	1	5	localJSONException2	JSONException
    //   57	982	6	localObject5	Object
    //   1070	46	6	localException1	Exception
    //   1127	1	6	localException2	Exception
    //   87	1013	7	str2	String
    //   80	936	8	localObject6	Object
    //   110	967	9	localObject7	Object
    //   43	691	10	str3	String
    //   50	1071	11	str4	String
    //   120	618	12	localJSONObject	JSONObject
    //   15	1067	13	i	int
    //   21	1065	14	j	int
    //   27	1063	15	k	int
    //   33	1061	16	m	int
    //   39	1059	17	n	int
    //   61	974	18	i1	int
    //   91	1005	19	i2	int
    //   65	966	20	i3	int
    //   95	997	21	i4	int
    //   69	958	22	i5	int
    //   99	989	23	i6	int
    //   73	950	24	i7	int
    //   103	981	25	i8	int
    //   77	942	26	i9	int
    //   107	973	27	i10	int
    //   36	530	28	i11	int
    //   30	472	29	i12	int
    //   24	414	30	i13	int
    //   18	356	31	i14	int
    //   12	298	32	i15	int
    // Exception table:
    //   from	to	target	type
    //   112	122	1009	org/json/JSONException
    //   182	191	1009	org/json/JSONException
    //   249	258	1009	org/json/JSONException
    //   316	326	1009	org/json/JSONException
    //   384	394	1009	org/json/JSONException
    //   452	462	1009	org/json/JSONException
    //   520	530	1009	org/json/JSONException
    //   588	598	1009	org/json/JSONException
    //   656	665	1009	org/json/JSONException
    //   723	733	1009	org/json/JSONException
    //   112	122	1070	java/lang/Exception
    //   182	191	1070	java/lang/Exception
    //   249	258	1070	java/lang/Exception
    //   316	326	1070	java/lang/Exception
    //   384	394	1070	java/lang/Exception
    //   452	462	1070	java/lang/Exception
    //   520	530	1070	java/lang/Exception
    //   588	598	1070	java/lang/Exception
    //   656	665	1070	java/lang/Exception
    //   723	733	1070	java/lang/Exception
    //   737	747	1127	java/lang/Exception
    //   737	747	1132	org/json/JSONException
  }
  
  public void onJsAlert(String paramString)
  {
    new AlertDialog.Builder(this.activity).setTitle("javaScript dialog").setMessage(paramString).setPositiveButton(17039370, new wta(this)).setCancelable(false).create().show();
  }
  
  public void reportForVia(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("actionType");
      String str1 = ((JSONObject)localObject).optString("via");
      String str2 = ((JSONObject)localObject).optString("appid");
      String str3 = ((JSONObject)localObject).optString("jsversion");
      localObject = ((JSONObject)localObject).optString("extraData");
      Bundle localBundle = new Bundle();
      localBundle.putString("jsversion", str3);
      StaticAnalyz.a(paramString, str1, str2, (String)localObject, localBundle);
      LogUtility.c("BaseJsCallBack", "reportForvia " + paramString + " | " + str1 + " | " + str2);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportForViaBatch(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("actionType");
          String str2 = ((JSONObject)localObject).optString("via");
          String str3 = ((JSONObject)localObject).optString("appid");
          String str4 = ((JSONObject)localObject).optString("jsversion");
          localObject = ((JSONObject)localObject).optString("extraData");
          Bundle localBundle = new Bundle();
          localBundle.putString("jsversion", str4);
          StaticAnalyz.a(str1, str2, str3, (String)localObject, localBundle);
          LogUtility.c("BaseJsCallBack", "reportForvia " + str1 + " | " + str2 + " | " + str3);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public void reportPV(String paramString1, String paramString2)
  {
    if (isUpdateAssets == true)
    {
      isUpdateAssets = false;
      return;
    }
    if (AppUtil.a(paramString1))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.INSTALLED.APPDETAIL", paramString2);
      return;
    }
    if (DownloadManager.a().a(paramString2))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.UNINSTALL.APPDETAIL", paramString2);
      return;
    }
    StaticAnalyz.a("100", "ANDROIDQQ.UNDOWNLOAD.APPDETAIL", paramString2);
  }
  
  public void setActionButton(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--changeButtonStyle");
    this.mHandler.post(new wte(this, paramString));
  }
  
  public void setAllowCallBackEvent(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (!hasRight()) {
        return;
      }
      if (i == 0)
      {
        CallBackEvent.a().a(false);
        return;
      }
      CallBackEvent.a().a(true);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean setCommonReportData(String paramString)
  {
    LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        CommonDataAdapter.a().b(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData Exception", paramString);
      }
    }
    return false;
  }
  
  public void setParams(String paramString)
  {
    this.urlParams = paramString;
  }
  
  public void showToast(String paramString)
  {
    if (!hasRight()) {}
    while ((this.activity == null) || (this.activity.isFinishing())) {
      return;
    }
    ToastUtil.a().a(paramString, 1);
  }
  
  public void startApp(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString2)
      {
        LogUtility.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
  }
  
  public void startApp(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (appIsExists(paramString1))
      {
        paramString3 = this.activity.getPackageManager().getLaunchIntentForPackage(paramString1);
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = new Intent(paramString1);
          paramString2.addCategory("android.intent.category.DEFAULT");
        }
        paramString2.putExtra("platformId", "qzone_m");
        LogUtility.c("add", ">>has add platformid=qzone_m");
      }
      try
      {
        this.activity.startActivity(paramString2);
        return;
      }
      catch (Exception paramString2)
      {
        ToastUtil.a().a("启动失败", 0);
        return;
      }
      return;
    }
    catch (Exception paramString2)
    {
      LogUtility.e("startApp", "apk not exist packName = " + paramString1);
    }
  }
  
  public void startAppWithData(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString2)
      {
        LogUtility.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
  }
  
  public void startOpenApp(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString1) {}
    }
  }
  
  /* Error */
  public void startOpenApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 91	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 782
    //   12: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 784
    //   22: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_3
    //   26: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 784
    //   32: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 786	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 742	com/tencent/open/appcommon/js/BaseJsCallBack:appIsExists	(Ljava/lang/String;)Z
    //   51: istore 6
    //   53: iload 6
    //   55: ifeq +22 -> 77
    //   58: aload 5
    //   60: ldc_w 788
    //   63: invokestatic 793	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 41	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   71: aload_3
    //   72: aload_1
    //   73: aload_2
    //   74: invokestatic 796	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_1
    //   79: ldc 8
    //   81: new 91	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 798
    //   91: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 801	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 219	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: return
    //   108: astore_2
    //   109: aload 5
    //   111: astore_2
    //   112: goto -45 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	BaseJsCallBack
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramString3	String
    //   0	115	4	paramString4	String
    //   0	115	5	paramString5	String
    //   51	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	53	78	java/lang/Exception
    //   67	77	78	java/lang/Exception
    //   58	67	108	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\BaseJsCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */