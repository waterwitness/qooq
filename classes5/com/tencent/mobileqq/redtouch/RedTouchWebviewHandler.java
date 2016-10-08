package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ufg;

public class RedTouchWebviewHandler
  extends VasWebviewJsPlugin
{
  private static final String ERRMSG_EXCEPTION = "exception";
  private static final String ERRMSG_FAILED = "failed";
  private static final String ERRMSG_NO_DATA = "data not prepared or cannot find the path, try again.";
  private static final String ERRMSG_SUCCESS = "success";
  public static final int INTVALUE_UNKNOWN = -1;
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_ERROR_MSG = "errorMessage";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESULT = "ret";
  public static final String KEY_SRC_TYPE = "srcType";
  public static final String KEY_TYPE = "type";
  public static final int LEBA_ITEM_OFF = 0;
  public static final int LEBA_ITEM_ON = 1;
  public static final String METHOD_GET_LEBA_STATE = "getDynamicState";
  public static final String METHOD_SET_LEBA_STATE = "setDynamicState";
  private static final String OBJECT_NAME = "redpoint";
  public static final String PLUGIN_NAMESPACE = "redpoint";
  public static final String REDBUFFERJSON_2722 = "2722";
  public static final String REDBUFFERJSON_PARAM = "param";
  public static String TAG = "RedTouchWebviewHandler";
  public static final int VALUE_EXCEPTION = -1;
  public static final int VALUE_FAILED = 1;
  public static final int VALUE_SUCCESS = 0;
  private AppInterface browserApp;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedTouchWebviewHandler()
  {
    this.mPluginNameSpace = "redpoint";
  }
  
  private void IPCItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(DataFactory.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
  }
  
  private BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    if ((this.browserApp == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfo path or browserapp = null");
      }
      paramString = null;
    }
    Object localObject1;
    label145:
    do
    {
      return paramString;
      localObject1 = new File(this.browserApp.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.browserApp.a());
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
      }
      catch (IOException paramString)
      {
        try
        {
          localObject1 = FileUtils.a((File)localObject1);
          if (localObject1 != null) {
            break label145;
          }
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo body = null");
          }
          return null;
        }
        finally {}
        paramString = paramString;
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo create file exception ");
        }
        return null;
      }
      try
      {
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom((byte[])localObject1);
        if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo localTimeRspBody null ");
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo mergeFrom exception ");
        }
        return null;
      }
      Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
      } while (!((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get().equals(paramString));
      paramString = (String)localObject1;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getappinfo path= " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get() + ";inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get());
    return (BusinessInfoCheckUpdate.AppInfo)localObject1;
    return null;
  }
  
  private JSONObject getRedBufferJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("param");
        if (localJSONObject2 == null) {
          return null;
        }
        Iterator localIterator = localJSONObject2.keys();
        paramJSONObject = localJSONObject1;
        if (localIterator.hasNext())
        {
          paramJSONObject = localJSONObject2.getJSONObject((String)localIterator.next());
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  private String getReportBufferString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    JSONArray localJSONArray;
    JSONObject localJSONObject1;
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray();
        localJSONObject1 = new JSONObject();
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString == null) {
            break;
          }
          Iterator localIterator = paramString.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          JSONObject localJSONObject2 = new JSONObject();
          String str = (String)localIterator.next();
          localObject = paramString.getJSONObject(str);
          if (!((JSONObject)localObject).has("stat")) {
            break label176;
          }
          i = ((JSONObject)localObject).getInt("stat");
          if (i != 1) {
            continue;
          }
          if (!((JSONObject)localObject).has("content")) {
            break label182;
          }
          localObject = ((JSONObject)localObject).getString("content");
          localJSONObject2.put(str, localObject);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      continue;
      label176:
      int i = -1;
      continue;
      label182:
      Object localObject = "";
    }
    localJSONObject1.put("msg", localJSONArray);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  /* Error */
  private void handleRedInfoResponse(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 320
    //   4: invokevirtual 326	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: invokevirtual 330	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   10: aload_2
    //   11: ldc_w 332
    //   14: invokevirtual 333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +181 -> 200
    //   22: ldc_w 335
    //   25: aload_3
    //   26: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +222 -> 251
    //   32: ldc_w 337
    //   35: astore 4
    //   37: new 276	org/json/JSONObject
    //   40: dup
    //   41: invokespecial 277	org/json/JSONObject:<init>	()V
    //   44: astore 5
    //   46: aload 4
    //   48: astore_3
    //   49: aload_2
    //   50: ldc_w 339
    //   53: invokevirtual 343	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   56: checkcast 320	com/tencent/mobileqq/redtouch/RedAppInfo
    //   59: astore 6
    //   61: aload 4
    //   63: astore_3
    //   64: aload_2
    //   65: ldc 29
    //   67: invokevirtual 333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 7
    //   72: aload 4
    //   74: astore_2
    //   75: aload 6
    //   77: ifnull +72 -> 149
    //   80: aload 4
    //   82: astore_2
    //   83: aload 4
    //   85: astore_3
    //   86: aload 6
    //   88: invokevirtual 346	com/tencent/mobileqq/redtouch/RedAppInfo:b	()I
    //   91: ifeq +58 -> 149
    //   94: aload 4
    //   96: astore_3
    //   97: aload_0
    //   98: new 276	org/json/JSONObject
    //   101: dup
    //   102: aload 6
    //   104: invokevirtual 347	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/lang/String;
    //   107: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: invokespecial 349	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getRedBufferJson	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   113: astore 8
    //   115: aload 4
    //   117: astore_2
    //   118: aload 8
    //   120: ifnull +29 -> 149
    //   123: aload 4
    //   125: astore_3
    //   126: aload 8
    //   128: ldc_w 351
    //   131: invokevirtual 297	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   134: ifeq +67 -> 201
    //   137: aload 4
    //   139: astore_3
    //   140: aload 8
    //   142: ldc_w 351
    //   145: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_2
    //   149: aload_2
    //   150: astore_3
    //   151: aload 5
    //   153: ldc_w 353
    //   156: aload_2
    //   157: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload_2
    //   162: astore_3
    //   163: aload_0
    //   164: aload 6
    //   166: invokestatic 358	com/tencent/mobileqq/redtouch/RedTouchUtils:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   169: sipush 1002
    //   172: invokespecial 362	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:onReportRed	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;I)V
    //   175: aload_2
    //   176: astore_3
    //   177: aload_0
    //   178: aload 7
    //   180: invokespecial 364	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:IPCItemClick	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: aload_1
    //   185: iconst_1
    //   186: anewarray 250	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: aload 5
    //   193: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: aastore
    //   197: invokevirtual 368	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   200: return
    //   201: ldc_w 337
    //   204: astore_2
    //   205: goto -56 -> 149
    //   208: astore_2
    //   209: aload_2
    //   210: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   213: aload 5
    //   215: ldc_w 353
    //   218: aload_3
    //   219: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: aload_1
    //   225: iconst_1
    //   226: anewarray 250	java/lang/String
    //   229: dup
    //   230: iconst_0
    //   231: aload 5
    //   233: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   236: aastore
    //   237: invokevirtual 368	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   240: goto -57 -> 183
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   248: goto -65 -> 183
    //   251: ldc_w 370
    //   254: aload_3
    //   255: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifne -58 -> 200
    //   261: ldc_w 372
    //   264: aload_3
    //   265: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   268: ifeq +590 -> 858
    //   271: new 276	org/json/JSONObject
    //   274: dup
    //   275: invokespecial 277	org/json/JSONObject:<init>	()V
    //   278: astore_3
    //   279: aload_2
    //   280: ldc_w 339
    //   283: invokevirtual 343	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   286: checkcast 320	com/tencent/mobileqq/redtouch/RedAppInfo
    //   289: astore 6
    //   291: aload_2
    //   292: ldc 29
    //   294: invokevirtual 333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   297: astore 7
    //   299: aload_2
    //   300: ldc_w 374
    //   303: invokevirtual 333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: astore_2
    //   307: new 276	org/json/JSONObject
    //   310: dup
    //   311: aload_2
    //   312: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   315: astore 5
    //   317: aload_0
    //   318: getfield 378	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   321: invokevirtual 383	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   324: astore_2
    //   325: new 385	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   328: dup
    //   329: invokespecial 386	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   332: astore 4
    //   334: aload 4
    //   336: getfield 390	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: aload_0
    //   340: getfield 378	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   343: invokevirtual 393	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   346: invokevirtual 175	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   349: invokestatic 399	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   352: invokevirtual 405	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   355: aload 4
    //   357: getfield 408	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   360: ldc_w 410
    //   363: invokevirtual 412	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   366: aload 4
    //   368: getfield 416	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   371: bipush 109
    //   373: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   376: aload 4
    //   378: getfield 424	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   381: aload 7
    //   383: invokestatic 428	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)I
    //   386: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   389: aload 4
    //   391: getfield 431	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   394: new 165	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   401: getstatic 436	android/os/Build$VERSION:SDK_INT	I
    //   404: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc_w 287
    //   410: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokevirtual 412	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   419: aload 6
    //   421: invokevirtual 438	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   424: ifnull +16 -> 440
    //   427: aload 4
    //   429: getfield 442	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   432: aload 6
    //   434: invokevirtual 438	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   437: invokevirtual 447	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   440: new 449	java/util/ArrayList
    //   443: dup
    //   444: invokespecial 450	java/util/ArrayList:<init>	()V
    //   447: astore 6
    //   449: aload 5
    //   451: invokevirtual 284	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   454: astore 7
    //   456: aload 7
    //   458: invokeinterface 235 1 0
    //   463: ifeq +153 -> 616
    //   466: aload 7
    //   468: invokeinterface 239 1 0
    //   473: checkcast 250	java/lang/String
    //   476: astore 8
    //   478: new 452	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData
    //   481: dup
    //   482: invokespecial 453	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   485: astore 9
    //   487: aload 9
    //   489: getfield 456	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   492: aload 8
    //   494: invokevirtual 412	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   497: aload 9
    //   499: getfield 459	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   502: aload 5
    //   504: aload 8
    //   506: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   509: invokevirtual 412	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   512: aload 6
    //   514: aload 9
    //   516: invokeinterface 462 2 0
    //   521: pop
    //   522: getstatic 468	java/lang/System:out	Ljava/io/PrintStream;
    //   525: new 165	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 470
    //   535: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 9
    //   540: getfield 456	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   543: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   546: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 472
    //   552: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 9
    //   557: getfield 459	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   560: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   563: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokevirtual 477	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   572: goto -116 -> 456
    //   575: astore_2
    //   576: aload_3
    //   577: ldc_w 479
    //   580: iconst_m1
    //   581: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload_3
    //   586: ldc 26
    //   588: ldc_w 484
    //   591: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   594: pop
    //   595: aload_2
    //   596: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   599: aload_0
    //   600: aload_1
    //   601: iconst_1
    //   602: anewarray 250	java/lang/String
    //   605: dup
    //   606: iconst_0
    //   607: aload_3
    //   608: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   611: aastore
    //   612: invokevirtual 368	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   615: return
    //   616: new 276	org/json/JSONObject
    //   619: dup
    //   620: invokespecial 277	org/json/JSONObject:<init>	()V
    //   623: astore 5
    //   625: aload 5
    //   627: ifnull +13 -> 640
    //   630: aload 5
    //   632: ldc_w 486
    //   635: iconst_5
    //   636: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   639: pop
    //   640: aload 4
    //   642: getfield 489	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   645: aload 5
    //   647: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   650: invokevirtual 412	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   653: aload 4
    //   655: getfield 492	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   658: aload 6
    //   660: invokevirtual 493	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   663: new 495	com/tencent/qphone/base/remote/ToServiceMsg
    //   666: dup
    //   667: ldc_w 497
    //   670: aload_0
    //   671: getfield 378	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   674: invokevirtual 393	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   677: invokevirtual 175	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   680: ldc_w 499
    //   683: invokespecial 502	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   686: astore 5
    //   688: aload 5
    //   690: aload 4
    //   692: invokevirtual 506	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   695: invokevirtual 510	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   698: aload 5
    //   700: getfield 514	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   703: ldc_w 516
    //   706: iconst_1
    //   707: invokevirtual 520	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   710: aload 5
    //   712: invokevirtual 523	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   715: arraylength
    //   716: i2l
    //   717: lstore 16
    //   719: lload 16
    //   721: l2i
    //   722: iconst_4
    //   723: iadd
    //   724: newarray <illegal type>
    //   726: astore 4
    //   728: aload 4
    //   730: iconst_0
    //   731: ldc2_w 524
    //   734: lload 16
    //   736: ladd
    //   737: invokestatic 530	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BIJ)V
    //   740: aload 4
    //   742: iconst_4
    //   743: aload 5
    //   745: invokevirtual 523	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   748: lload 16
    //   750: l2i
    //   751: invokestatic 533	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BI)V
    //   754: aload 5
    //   756: aload 4
    //   758: invokevirtual 510	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   761: new 535	mqq/app/NewIntent
    //   764: dup
    //   765: aload_2
    //   766: invokevirtual 540	android/app/Activity:getApplication	()Landroid/app/Application;
    //   769: ldc_w 542
    //   772: invokespecial 545	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   775: astore_2
    //   776: aload_2
    //   777: ldc_w 495
    //   780: invokevirtual 548	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   783: aload 5
    //   785: invokevirtual 552	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   788: pop
    //   789: aload_0
    //   790: getfield 378	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   793: invokevirtual 393	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   796: aload_2
    //   797: invokevirtual 556	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   800: aload_3
    //   801: ldc_w 479
    //   804: iconst_0
    //   805: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   808: pop
    //   809: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq -213 -> 599
    //   815: getstatic 76	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   818: iconst_2
    //   819: new 165	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   826: ldc_w 558
    //   829: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload_3
    //   833: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   836: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: goto -246 -> 599
    //   848: astore 4
    //   850: aload 4
    //   852: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   855: goto -260 -> 595
    //   858: ldc_w 560
    //   861: aload_3
    //   862: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   865: ifeq +897 -> 1762
    //   868: new 276	org/json/JSONObject
    //   871: dup
    //   872: invokespecial 277	org/json/JSONObject:<init>	()V
    //   875: astore 7
    //   877: new 276	org/json/JSONObject
    //   880: dup
    //   881: invokespecial 277	org/json/JSONObject:<init>	()V
    //   884: astore 6
    //   886: aload_2
    //   887: ldc_w 562
    //   890: invokevirtual 333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   893: astore 8
    //   895: aload_2
    //   896: ldc_w 339
    //   899: invokevirtual 343	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   902: checkcast 320	com/tencent/mobileqq/redtouch/RedAppInfo
    //   905: invokestatic 358	com/tencent/mobileqq/redtouch/RedTouchUtils:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   908: astore 10
    //   910: bipush -2
    //   912: istore 14
    //   914: ldc_w 287
    //   917: astore_2
    //   918: iconst_0
    //   919: istore 13
    //   921: ldc_w 287
    //   924: astore 5
    //   926: new 449	java/util/ArrayList
    //   929: dup
    //   930: invokespecial 450	java/util/ArrayList:<init>	()V
    //   933: astore 9
    //   935: aload 5
    //   937: astore_3
    //   938: aload_2
    //   939: astore 4
    //   941: aload 10
    //   943: ifnull +131 -> 1074
    //   946: aload 10
    //   948: getfield 566	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   951: getfield 571	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   954: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   957: astore 11
    //   959: aload 10
    //   961: getfield 244	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   964: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   967: astore 4
    //   969: aload_2
    //   970: astore_3
    //   971: aload 10
    //   973: getfield 573	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   976: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   979: iconst_m1
    //   980: if_icmpne +286 -> 1266
    //   983: bipush -3
    //   985: istore 14
    //   987: iconst_0
    //   988: istore 13
    //   990: aload_2
    //   991: astore_3
    //   992: aload 9
    //   994: ldc_w 287
    //   997: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1000: pop
    //   1001: aload_2
    //   1002: astore_3
    //   1003: aload 7
    //   1005: ldc_w 479
    //   1008: bipush -3
    //   1010: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1013: pop
    //   1014: aload_2
    //   1015: astore_3
    //   1016: aload 7
    //   1018: ldc 26
    //   1020: ldc_w 577
    //   1023: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1026: pop
    //   1027: aload_2
    //   1028: astore_3
    //   1029: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1032: ifeq +36 -> 1068
    //   1035: aload_2
    //   1036: astore_3
    //   1037: getstatic 76	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1040: iconst_2
    //   1041: new 165	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 579
    //   1051: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload 7
    //   1056: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1059: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1068: aload 4
    //   1070: astore_3
    //   1071: aload_2
    //   1072: astore 4
    //   1074: new 426	com/tencent/mobileqq/redtouch/RedTouchManager
    //   1077: dup
    //   1078: aload_0
    //   1079: getfield 378	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1082: invokevirtual 393	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1085: invokespecial 582	com/tencent/mobileqq/redtouch/RedTouchManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   1088: invokevirtual 583	com/tencent/mobileqq/redtouch/RedTouchManager:a	()Ljava/lang/String;
    //   1091: astore_2
    //   1092: iload 13
    //   1094: istore 15
    //   1096: aload_3
    //   1097: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1100: ifne +18 -> 1118
    //   1103: iload 13
    //   1105: istore 15
    //   1107: aload_3
    //   1108: aload_2
    //   1109: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1112: ifeq +6 -> 1118
    //   1115: iconst_1
    //   1116: istore 15
    //   1118: new 87	android/os/Bundle
    //   1121: dup
    //   1122: invokespecial 88	android/os/Bundle:<init>	()V
    //   1125: astore_2
    //   1126: aload_2
    //   1127: ldc 32
    //   1129: iload 14
    //   1131: invokestatic 587	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1134: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1137: aload_2
    //   1138: ldc_w 588
    //   1141: aload 4
    //   1143: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1146: aload_2
    //   1147: ldc_w 590
    //   1150: iload 15
    //   1152: invokestatic 587	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1155: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1158: aload_2
    //   1159: ldc_w 592
    //   1162: aload 9
    //   1164: invokevirtual 596	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1167: aload_2
    //   1168: ldc 29
    //   1170: aload_3
    //   1171: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: aload_2
    //   1175: ldc_w 562
    //   1178: aload 8
    //   1180: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1183: aload_2
    //   1184: ldc 23
    //   1186: aload_1
    //   1187: invokevirtual 92	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1190: aload_0
    //   1191: ldc_w 598
    //   1194: aload_1
    //   1195: aload_0
    //   1196: getfield 122	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1199: getfield 602	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1202: aload_2
    //   1203: invokestatic 100	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1206: iconst_0
    //   1207: iconst_1
    //   1208: invokespecial 104	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1211: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq +34 -> 1248
    //   1217: getstatic 76	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1220: iconst_2
    //   1221: new 165	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1228: ldc_w 604
    //   1231: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: aload 7
    //   1236: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1239: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1245: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1248: aload_0
    //   1249: aload_1
    //   1250: iconst_1
    //   1251: anewarray 250	java/lang/String
    //   1254: dup
    //   1255: iconst_0
    //   1256: aload 7
    //   1258: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1261: aastore
    //   1262: invokevirtual 368	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1265: return
    //   1266: aload_2
    //   1267: astore_3
    //   1268: aload 7
    //   1270: ldc_w 479
    //   1273: iconst_0
    //   1274: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1277: pop
    //   1278: aload_2
    //   1279: astore_3
    //   1280: aload 6
    //   1282: ldc_w 606
    //   1285: aload 10
    //   1287: getfield 609	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1290: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1293: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1296: pop
    //   1297: aload_2
    //   1298: astore_3
    //   1299: aload 6
    //   1301: ldc_w 610
    //   1304: aload 10
    //   1306: getfield 262	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1309: invokevirtual 267	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1312: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1315: pop
    //   1316: aload_2
    //   1317: astore_3
    //   1318: aload 10
    //   1320: getfield 262	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1323: invokevirtual 267	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1326: istore 14
    //   1328: aload_2
    //   1329: astore_3
    //   1330: new 289	org/json/JSONArray
    //   1333: dup
    //   1334: invokespecial 290	org/json/JSONArray:<init>	()V
    //   1337: astore 5
    //   1339: iconst_0
    //   1340: istore 13
    //   1342: aload_2
    //   1343: astore_3
    //   1344: iload 13
    //   1346: aload 10
    //   1348: getfield 612	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1351: invokevirtual 615	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1354: if_icmpge +48 -> 1402
    //   1357: aload_2
    //   1358: astore_3
    //   1359: aload 5
    //   1361: aload 10
    //   1363: getfield 612	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1366: iload 13
    //   1368: invokevirtual 618	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1371: invokevirtual 315	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1374: pop
    //   1375: aload_2
    //   1376: astore_3
    //   1377: aload 9
    //   1379: aload 10
    //   1381: getfield 612	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1384: iload 13
    //   1386: invokevirtual 618	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1389: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1392: pop
    //   1393: iload 13
    //   1395: iconst_1
    //   1396: iadd
    //   1397: istore 13
    //   1399: goto -57 -> 1342
    //   1402: aload_2
    //   1403: astore_3
    //   1404: new 276	org/json/JSONObject
    //   1407: dup
    //   1408: invokespecial 277	org/json/JSONObject:<init>	()V
    //   1411: astore 12
    //   1413: aload 11
    //   1415: ifnull +116 -> 1531
    //   1418: iconst_0
    //   1419: istore 13
    //   1421: aload_2
    //   1422: astore_3
    //   1423: iload 13
    //   1425: aload 11
    //   1427: invokeinterface 619 1 0
    //   1432: if_icmpge +99 -> 1531
    //   1435: aload_2
    //   1436: astore_3
    //   1437: aload 12
    //   1439: ldc_w 621
    //   1442: aload 11
    //   1444: iload 13
    //   1446: invokeinterface 622 2 0
    //   1451: checkcast 624	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1454: getfield 626	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1457: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1460: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1463: pop
    //   1464: aload_2
    //   1465: astore_3
    //   1466: aload 12
    //   1468: ldc_w 628
    //   1471: aload 11
    //   1473: iload 13
    //   1475: invokeinterface 622 2 0
    //   1480: checkcast 624	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1483: getfield 630	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1486: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1489: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1492: pop
    //   1493: aload_2
    //   1494: astore_3
    //   1495: aload 12
    //   1497: ldc_w 632
    //   1500: aload 11
    //   1502: iload 13
    //   1504: invokeinterface 622 2 0
    //   1509: checkcast 624	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1512: getfield 634	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1515: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1518: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1521: pop
    //   1522: iload 13
    //   1524: iconst_1
    //   1525: iadd
    //   1526: istore 13
    //   1528: goto -107 -> 1421
    //   1531: aload_2
    //   1532: astore_3
    //   1533: aload 6
    //   1535: ldc_w 339
    //   1538: aload 12
    //   1540: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1543: pop
    //   1544: aload_2
    //   1545: astore_3
    //   1546: aload 6
    //   1548: ldc_w 592
    //   1551: aload 5
    //   1553: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1556: pop
    //   1557: aload_2
    //   1558: astore_3
    //   1559: aload 6
    //   1561: ldc 38
    //   1563: aload 10
    //   1565: getfield 573	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1568: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1571: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1574: pop
    //   1575: aload_2
    //   1576: astore_3
    //   1577: aload 6
    //   1579: ldc_w 588
    //   1582: aload 10
    //   1584: getfield 635	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1587: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1590: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1593: pop
    //   1594: aload_2
    //   1595: astore_3
    //   1596: aload 6
    //   1598: ldc 29
    //   1600: aload 10
    //   1602: getfield 244	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1605: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1608: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1611: pop
    //   1612: aload_2
    //   1613: astore_3
    //   1614: aload 6
    //   1616: ldc_w 637
    //   1619: aload 10
    //   1621: getfield 639	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1624: invokevirtual 267	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1627: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1630: pop
    //   1631: aload_2
    //   1632: astore_3
    //   1633: aload 6
    //   1635: ldc_w 641
    //   1638: aload 10
    //   1640: getfield 643	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1643: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1646: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1649: pop
    //   1650: aload_2
    //   1651: astore_3
    //   1652: aload 6
    //   1654: ldc_w 645
    //   1657: aload 10
    //   1659: getfield 647	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1662: invokevirtual 267	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1665: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1668: pop
    //   1669: aload_2
    //   1670: astore_3
    //   1671: aload 6
    //   1673: ldc_w 649
    //   1676: aload 10
    //   1678: getfield 651	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1681: invokevirtual 574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1684: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1687: pop
    //   1688: aload_2
    //   1689: astore_3
    //   1690: aload 7
    //   1692: ldc_w 653
    //   1695: aload 6
    //   1697: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1700: pop
    //   1701: aload_2
    //   1702: astore_3
    //   1703: aload_0
    //   1704: aload 10
    //   1706: getfield 635	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1709: invokevirtual 248	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1712: invokespecial 116	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   1715: astore_2
    //   1716: iload 14
    //   1718: istore 13
    //   1720: iconst_0
    //   1721: istore 14
    //   1723: goto -696 -> 1027
    //   1726: astore 6
    //   1728: aload 5
    //   1730: astore 4
    //   1732: aload 6
    //   1734: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   1737: bipush -4
    //   1739: istore 14
    //   1741: iconst_0
    //   1742: istore 13
    //   1744: aload 9
    //   1746: ldc_w 287
    //   1749: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1752: pop
    //   1753: aload 4
    //   1755: astore_3
    //   1756: aload_2
    //   1757: astore 4
    //   1759: goto -685 -> 1074
    //   1762: ldc_w 655
    //   1765: aload_3
    //   1766: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1769: ifeq -1569 -> 200
    //   1772: aload_2
    //   1773: ldc_w 339
    //   1776: invokevirtual 343	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1779: checkcast 320	com/tencent/mobileqq/redtouch/RedAppInfo
    //   1782: astore_3
    //   1783: new 276	org/json/JSONObject
    //   1786: dup
    //   1787: invokespecial 277	org/json/JSONObject:<init>	()V
    //   1790: astore_2
    //   1791: new 276	org/json/JSONObject
    //   1794: dup
    //   1795: invokespecial 277	org/json/JSONObject:<init>	()V
    //   1798: astore 4
    //   1800: aload_3
    //   1801: ifnonnull +75 -> 1876
    //   1804: aload_2
    //   1805: ldc_w 479
    //   1808: iconst_m1
    //   1809: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1812: pop
    //   1813: aload_2
    //   1814: ldc 26
    //   1816: ldc_w 657
    //   1819: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1822: pop
    //   1823: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1826: ifeq +33 -> 1859
    //   1829: getstatic 76	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1832: iconst_2
    //   1833: new 165	java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   1840: ldc_w 659
    //   1843: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: aload_2
    //   1847: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1850: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: aload_0
    //   1860: aload_1
    //   1861: iconst_1
    //   1862: anewarray 250	java/lang/String
    //   1865: dup
    //   1866: iconst_0
    //   1867: aload_2
    //   1868: invokevirtual 316	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1871: aastore
    //   1872: invokevirtual 368	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1875: return
    //   1876: aload_3
    //   1877: invokevirtual 662	com/tencent/mobileqq/redtouch/RedAppInfo:c	()I
    //   1880: iconst_m1
    //   1881: if_icmpne +61 -> 1942
    //   1884: aload_2
    //   1885: ldc_w 479
    //   1888: bipush -3
    //   1890: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1893: pop
    //   1894: aload_2
    //   1895: ldc 26
    //   1897: ldc_w 577
    //   1900: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1903: pop
    //   1904: goto -81 -> 1823
    //   1907: astore_3
    //   1908: aload_3
    //   1909: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   1912: aload_2
    //   1913: ldc_w 479
    //   1916: iconst_m1
    //   1917: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1920: pop
    //   1921: aload_2
    //   1922: ldc 26
    //   1924: ldc_w 664
    //   1927: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1930: pop
    //   1931: goto -72 -> 1859
    //   1934: astore_3
    //   1935: aload_3
    //   1936: invokevirtual 285	org/json/JSONException:printStackTrace	()V
    //   1939: goto -80 -> 1859
    //   1942: aload_2
    //   1943: ldc_w 479
    //   1946: iconst_0
    //   1947: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1950: pop
    //   1951: aload 4
    //   1953: ldc_w 666
    //   1956: aload_3
    //   1957: invokevirtual 662	com/tencent/mobileqq/redtouch/RedAppInfo:c	()I
    //   1960: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1963: pop
    //   1964: aload 4
    //   1966: ldc_w 668
    //   1969: aload_3
    //   1970: invokevirtual 671	com/tencent/mobileqq/redtouch/RedAppInfo:f	()I
    //   1973: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1976: pop
    //   1977: aload 4
    //   1979: ldc_w 673
    //   1982: aload_3
    //   1983: invokevirtual 346	com/tencent/mobileqq/redtouch/RedAppInfo:b	()I
    //   1986: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1989: pop
    //   1990: aload_2
    //   1991: ldc_w 653
    //   1994: aload 4
    //   1996: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1999: pop
    //   2000: goto -177 -> 1823
    //   2003: astore 6
    //   2005: aload_3
    //   2006: astore_2
    //   2007: goto -275 -> 1732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2010	0	this	RedTouchWebviewHandler
    //   0	2010	1	paramString	String
    //   0	2010	2	paramBundle	Bundle
    //   17	1860	3	localObject1	Object
    //   1907	2	3	localJSONException1	JSONException
    //   1934	72	3	localJSONException2	JSONException
    //   35	722	4	localObject2	Object
    //   848	3	4	localJSONException3	JSONException
    //   939	1056	4	localObject3	Object
    //   44	1685	5	localObject4	Object
    //   59	1637	6	localObject5	Object
    //   1726	7	6	localJSONException4	JSONException
    //   2003	1	6	localJSONException5	JSONException
    //   70	1621	7	localObject6	Object
    //   113	1066	8	localObject7	Object
    //   485	1260	9	localObject8	Object
    //   908	797	10	localAppInfo	BusinessInfoCheckUpdate.AppInfo
    //   957	544	11	localList	List
    //   1411	128	12	localJSONObject	JSONObject
    //   919	824	13	i	int
    //   912	828	14	j	int
    //   1094	57	15	k	int
    //   717	32	16	l	long
    // Exception table:
    //   from	to	target	type
    //   49	61	208	org/json/JSONException
    //   64	72	208	org/json/JSONException
    //   86	94	208	org/json/JSONException
    //   97	115	208	org/json/JSONException
    //   126	137	208	org/json/JSONException
    //   140	149	208	org/json/JSONException
    //   151	161	208	org/json/JSONException
    //   163	175	208	org/json/JSONException
    //   177	183	208	org/json/JSONException
    //   213	240	243	org/json/JSONException
    //   307	440	575	org/json/JSONException
    //   440	456	575	org/json/JSONException
    //   456	572	575	org/json/JSONException
    //   616	625	575	org/json/JSONException
    //   630	640	575	org/json/JSONException
    //   640	845	575	org/json/JSONException
    //   576	595	848	org/json/JSONException
    //   946	969	1726	org/json/JSONException
    //   1804	1823	1907	org/json/JSONException
    //   1823	1859	1907	org/json/JSONException
    //   1876	1904	1907	org/json/JSONException
    //   1942	2000	1907	org/json/JSONException
    //   1912	1931	1934	org/json/JSONException
    //   971	983	2003	org/json/JSONException
    //   992	1001	2003	org/json/JSONException
    //   1003	1014	2003	org/json/JSONException
    //   1016	1027	2003	org/json/JSONException
    //   1029	1035	2003	org/json/JSONException
    //   1037	1068	2003	org/json/JSONException
    //   1268	1278	2003	org/json/JSONException
    //   1280	1297	2003	org/json/JSONException
    //   1299	1316	2003	org/json/JSONException
    //   1318	1328	2003	org/json/JSONException
    //   1330	1339	2003	org/json/JSONException
    //   1344	1357	2003	org/json/JSONException
    //   1359	1375	2003	org/json/JSONException
    //   1377	1393	2003	org/json/JSONException
    //   1404	1413	2003	org/json/JSONException
    //   1423	1435	2003	org/json/JSONException
    //   1437	1464	2003	org/json/JSONException
    //   1466	1493	2003	org/json/JSONException
    //   1495	1522	2003	org/json/JSONException
    //   1533	1544	2003	org/json/JSONException
    //   1546	1557	2003	org/json/JSONException
    //   1559	1575	2003	org/json/JSONException
    //   1577	1594	2003	org/json/JSONException
    //   1596	1612	2003	org/json/JSONException
    //   1614	1631	2003	org/json/JSONException
    //   1633	1650	2003	org/json/JSONException
    //   1652	1669	2003	org/json/JSONException
    //   1671	1688	2003	org/json/JSONException
    //   1690	1701	2003	org/json/JSONException
    //   1703	1716	2003	org/json/JSONException
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
  
  public void getAppInfo(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfo js startime : " + l);
    }
    ThreadManager.a(new ufg(this, paramString, l), 8, null, true);
  }
  
  public void getDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = ((JSONObject)localObject).getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", RedTouchManager.a(((JSONObject)localObject).getString("path")));
        paramString = str;
        sendRemoteReq(DataFactory.a("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void getIndividuationType(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("path", "100005.100022");
      localBundle.putString("subCmd", "redTouch_getIndividuationType");
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getRedPointShowInfo(String paramString)
  {
    localObject2 = "callback";
    localJSONObject = new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      int i;
      String str;
      if (!((JSONObject)localObject3).isNull("set"))
      {
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject3).getString("set");
        try
        {
          i = Integer.parseInt((String)localObject2);
          if ((i != 0) && (i != 1) && (i != 2))
          {
            localObject1 = paramString;
            localJSONObject.put("code", -3);
            localObject1 = paramString;
            localJSONObject.put("errorMessage", "redPoint showInfo not found");
            localObject1 = paramString;
            callJs(paramString, new String[] { localJSONObject.toString() });
            return;
          }
        }
        catch (Exception localException)
        {
          str = paramString;
          localJSONObject.put("code", -3);
          str = paramString;
          localJSONObject.put("errorMessage", "redPoint showInfo not found");
          str = paramString;
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing callback");
        callJs(str, new String[] { localJSONObject.toString() });
        return;
        str = paramString;
        localObject2 = new Bundle();
        str = paramString;
        ((Bundle)localObject2).putInt("setId", i);
        str = paramString;
        super.sendRemoteReq(DataFactory.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
        return;
        str = paramString;
        if (!((JSONObject)localObject3).isNull("path"))
        {
          str = paramString;
          localObject2 = ((JSONObject)localObject3).getString("path");
          str = paramString;
          localObject3 = new Bundle();
          str = paramString;
          ((Bundle)localObject3).putString("path", (String)localObject2);
          str = paramString;
          ((Bundle)localObject3).putString("subCmd", "redTouch_getRedPointShowInfo_path");
          str = paramString;
          super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
          return;
        }
        str = paramString;
        localJSONObject.put("code", -1);
        str = paramString;
        localJSONObject.put("errorMessage", "missing set and path");
        str = paramString;
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getServerTime(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getString("callback");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject1.put("time", NetConnInfoCenter.getServerTimeMillis());
          localJSONObject2.put("data", localJSONObject1);
          localJSONObject2.put("code", 0);
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        paramString = "callback";
      }
      try
      {
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("redpoint"))) {
      return false;
    }
    paramJsBridgeListener = new ArrayList();
    while (i < paramVarArgs.length)
    {
      paramJsBridgeListener.add(paramVarArgs[i]);
      i += 1;
    }
    return call(paramString3, paramJsBridgeListener);
  }
  
  public void isEnterFromRedPoint(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getString("path");
          if (!new RedTouchManager(this.mRuntime.a()).a().equals(localObject))
          {
            localJSONObject.put("code", 0);
            localJSONObject.put("data", 0);
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "isEnterFromRedPoint:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          localJSONObject.put("data", 1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.browserApp = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    int j = -1;
    int i = 1;
    if (paramBundle == null) {}
    String str1;
    Object localObject;
    label172:
    label214:
    label334:
    label340:
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      String str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject = paramBundle.getBundle("response");
      if ("leba_item_set".equals(str2))
      {
        if (localObject == null)
        {
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set leba item result: " + i);
          }
          paramBundle = new JSONObject();
        }
        for (;;)
        {
          try
          {
            paramBundle.put("ret", i);
            if (i != 0) {
              break label172;
            }
            paramBundle.put("errorMessage", "success");
            callJs(str1, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          i = ((Bundle)localObject).getInt("ret");
          break;
          paramBundle.put("errorMessage", "failed");
        }
      }
      if ("leba_item_get".equals(str2))
      {
        if (localObject == null)
        {
          if (i != 0) {
            break label334;
          }
          j = ((Bundle)localObject).getInt("type", -1);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get leba item result: " + i + ", type: " + j);
          }
          paramBundle = new JSONObject();
        }
        for (;;)
        {
          try
          {
            paramBundle.put("ret", i);
            paramBundle.put("type", j);
            if (i != 0) {
              break label340;
            }
            paramBundle.put("errorMessage", "success");
            callJs(str1, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          i = ((Bundle)localObject).getInt("ret");
          break;
          j = -1;
          break label214;
          paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
        }
      }
      if ("redTouch_setAppInfo".equals(str2))
      {
        i = ((Bundle)localObject).getInt("iret");
        paramBundle = new JSONObject();
        for (;;)
        {
          try
          {
            paramBundle.put("code", i);
            if (i != -3) {
              continue;
            }
            paramBundle.put("errorMessage", "appInfo not found");
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "setAppInfo:" + paramBundle.toString());
            }
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            continue;
          }
          callJs(str1, new String[] { paramBundle.toString() });
          return;
          if (i == -4) {
            paramBundle.put("errorMessage", "failed to set appInfo");
          }
        }
      }
      if ("redTouch_getRedPointShowInfo_set".equals(localJSONException1))
      {
        paramBundle = new JSONObject();
        RedTypeInfo localRedTypeInfo = (RedTypeInfo)((Bundle)localObject).getSerializable("redInfo");
        localObject = new JSONObject();
        for (;;)
        {
          try
          {
            paramBundle.put("code", 0);
            if (localRedTypeInfo == null) {
              continue;
            }
            j = localRedTypeInfo.getRed_type();
            i = 1;
            ((JSONObject)localObject).put("hintType", j);
            ((JSONObject)localObject).put("number", 0);
            ((JSONObject)localObject).put("isShow", i);
            paramBundle.put("data", localObject);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "getRedPointShowInfo:" + paramBundle.toString());
            }
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
            try
            {
              paramBundle.put("code", -1);
              paramBundle.put("errorMessage", "missing callback");
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            continue;
          }
          callJs(str1, new String[] { paramBundle.toString() });
          return;
          i = 0;
        }
      }
    } while (!"redTouch_getRedInfo".equals(localJSONException3));
    handleRedInfoResponse(str1, (Bundle)localObject);
  }
  
  public void reportBusinessRedTouch(String paramString)
  {
    String str2 = "callback";
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = str2;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      str1 = str2;
      paramString = localJSONObject2.getString("callback");
      str1 = paramString;
      localJSONObject2.remove("callback");
      str1 = paramString;
      str2 = localJSONObject2.getString("path");
      str1 = paramString;
      localJSONObject2.remove("path");
      str1 = paramString;
      Bundle localBundle = new Bundle();
      str1 = paramString;
      localBundle.putString("path", str2);
      str1 = paramString;
      localBundle.putString("json", localJSONObject2.toString());
      str1 = paramString;
      localBundle.putString("subCmd", "redTouch_reportBusinessRedTouch");
      str1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject1.put("code", -1);
      localJSONObject1.put("errorMessage", "missing path or callback");
      callJs(str1, new String[] { localJSONObject1.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    ArrayList localArrayList = new ArrayList();
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject3).getString("path");
      localObject1 = paramString;
      j = ((JSONObject)localObject3).getInt("isWithRedPoint");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).optJSONArray("missions");
      if (localObject3 == null) {
        break label141;
      }
      localObject1 = paramString;
      if (((JSONArray)localObject3).length() <= 0) {
        break label141;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        int i;
        String str;
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
          callJs((String)localObject1, new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        i += 1;
      }
    }
    localObject1 = paramString;
    if (i < ((JSONArray)localObject3).length())
    {
      localObject1 = paramString;
      str = ((JSONArray)localObject3).getString(i);
      localObject1 = paramString;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = paramString;
        localArrayList.add(str);
      }
    }
    else
    {
      label141:
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putString("path", (String)localObject2);
      localObject1 = paramString;
      ((Bundle)localObject3).putInt("isWithRedPoint", j);
      localObject1 = paramString;
      if (localArrayList.size() > 0)
      {
        localObject1 = paramString;
        ((Bundle)localObject3).putStringArrayList("missions", localArrayList);
      }
      localObject1 = paramString;
      ((Bundle)localObject3).putString("subCmd", "redTouch_reportRedTouch");
      localObject1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      localObject1 = paramString;
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("code", 0);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          localObject1 = paramString;
          QLog.i(TAG, 2, "reportRedTouch:" + ((JSONObject)localObject2).toString());
        }
        localObject1 = paramString;
        callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = paramString;
          QLog.e(TAG, 1, "reportRedTouch: Exception e = " + localException.getMessage());
          localObject1 = paramString;
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void setAppInfo(String paramString)
  {
    Object localObject2 = "callback";
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).getJSONObject("appInfo");
      localObject1 = paramString;
      localObject2 = new BusinessInfoCheckUpdate.AppInfo();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.set(((JSONObject)localObject3).getInt("appID"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(((JSONObject)localObject3).getInt("iNewFlag"));
      localObject1 = paramString;
      JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("missions");
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.add(localJSONArray.getString(i));
        i += 1;
      }
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.set(((JSONObject)localObject3).getInt("type"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.set(((JSONObject)localObject3).getString("buffer"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.set(((JSONObject)localObject3).getString("path"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.set(((JSONObject)localObject3).getInt("appset"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set(((JSONObject)localObject3).getInt("modify_ts"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).num.set(((JSONObject)localObject3).getInt("num"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.set(((JSONObject)localObject3).getInt("push_red_ts"));
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putParcelable("red", RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
      localObject1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
      callJs((String)localObject1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = ((JSONObject)localObject).getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", RedTouchManager.a(((JSONObject)localObject).getString("path")));
        paramString = str;
        localBundle.putInt("type", ((JSONObject)localObject).getInt("type"));
        paramString = str;
        sendRemoteReq(DataFactory.a("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedTouchWebviewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */