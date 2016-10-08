package com.tencent.mobileqq.jsp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebStatisticsInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONException;
import org.json.JSONObject;
import sxk;
import sxo;

public class DataApiPlugin
  extends WebViewPlugin
{
  static final String jdField_a_of_type_JavaLangString = "callback";
  public static final String b = "data";
  public static final String c = DataApiPlugin.class.getSimpleName();
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public Client.onRemoteRespObserver a;
  private WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface;
  private WebUiUtils.WebStatisticsInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface;
  private WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface;
  private WebUiUtils.WebviewReportSpeedInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DataApiPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new sxk(this);
    this.mPluginNameSpace = "data";
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    long l = 0L;
    String str = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.a();
      l = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface.c();
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        int j = paramArrayOfString.getJSONObject("data").getInt("status");
        paramString = "onFirstLine";
        if ((j != 12) && (j != 13))
        {
          if ((i < j) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQBrowser_report", 2, "try report web status, " + paramString + ", step: " + j + ", stepTime: " + (System.currentTimeMillis() - l) + ", totalTime: " + (System.currentTimeMillis() - l) + ", \n " + this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.b_(j);
              this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.a(System.currentTimeMillis());
            }
          }
          else
          {
            paramArrayOfString.optString("callback");
            return;
            paramString = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
            str = paramString;
            if (paramString == null) {
              continue;
            }
            i = paramString.a.jdField_a_of_type_Int;
            l = paramString.b;
            str = paramString;
            continue;
            paramString = "onPageFinished";
            continue;
          }
          if (str == null) {
            continue;
          }
          str.a.jdField_a_of_type_Int = j;
          str.a.jdField_a_of_type_Long = System.currentTimeMillis();
          continue;
        }
        if (j != 12) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      paramString = "onPageVisible";
    }
  }
  
  public void a(String paramString)
  {
    String str1;
    int i;
    String str2;
    JSONObject localJSONObject;
    String str3;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    String str4;
    Object localObject1;
    int k;
    int j;
    String str5;
    try
    {
      str1 = VasUserData.a(this.mRuntime.a(), "ticketInterval");
      if (TextUtils.isEmpty(str1)) {
        break label948;
      }
      i = Integer.parseInt(str1);
      localObject2 = new JSONObject(paramString);
      str2 = ((JSONObject)localObject2).optString("callback");
      localJSONObject = new JSONObject();
      if (!this.mRuntime.a().isLogin())
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", "用户未登录");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      str3 = this.mRuntime.a().a();
      localSharedPreferences = this.mRuntime.a().getApplication().getSharedPreferences(str3 + "_get_ticket_interval", 0);
      localEditor = localSharedPreferences.edit();
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      }
      str4 = this.mRuntime.a().getUrl();
      str1 = null;
      localObject1 = null;
      paramString = null;
      k = 0;
      j = 0;
      str5 = ((JSONObject)localObject2).optString("key");
      if (!TextUtils.isEmpty(str5)) {
        break label319;
      }
      localJSONObject.put("result", -2);
      localJSONObject.put("message", "参数key为空");
      callJs(str2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      if (!QLog.isColorLevel()) {
        break label956;
      }
    }
    QLog.e(c, 2, "updateLoginInfo error: " + paramString.getMessage());
    return;
    label319:
    Object localObject2 = new WUserSigInfo();
    long l;
    if ("skey".equals(str5))
    {
      l = localSharedPreferences.getLong("skey", 0L);
      if (System.currentTimeMillis() - l > i * 1000)
      {
        localEditor.putLong("skey", System.currentTimeMillis());
        localEditor.commit();
        i = j;
        if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(str4)) {
          break label957;
        }
        i = 4096;
        break label957;
      }
    }
    label948:
    label956:
    label957:
    label960:
    for (;;)
    {
      if (i == 0)
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", "权限不足");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", 1);
        localJSONObject.put("message", "频率过快");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        if ("pskey".equals(str5))
        {
          str1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(str4);
          l = localSharedPreferences.getLong("pskey_" + str1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pskey_" + str1, System.currentTimeMillis());
            localEditor.commit();
            i = k;
            if (TextUtils.isEmpty(str1)) {
              break label960;
            }
            ((WUserSigInfo)localObject2)._domains.add(str1);
            i = 1048576;
            break label960;
          }
          localJSONObject.put("result", 1);
          localJSONObject.put("message", "频率过快");
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        paramString = (String)localObject1;
        if ("pt4_token".equals(str5))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(str4);
          l = localSharedPreferences.getLong("pt4_token_" + (String)localObject1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pt4_token_" + (String)localObject1, System.currentTimeMillis());
            localEditor.commit();
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((WUserSigInfo)localObject2)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
              i = 135266304;
              paramString = (String)localObject1;
            }
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("message", "频率过快");
            callJs(str2, new String[] { localJSONObject.toString() });
          }
        }
      }
      else
      {
        localObject1 = new WtloginHelper(this.mRuntime.a().getApplication());
        ((WtloginHelper)localObject1).setCallSource(30);
        ((WtloginHelper)localObject1).SetListener(new sxo(this, str4, str2, str1, paramString));
        ((WtloginHelper)localObject1).GetStWithoutPasswd(str3, 16L, 16L, 1L, i, (WUserSigInfo)localObject2);
        return;
      }
      i = 0;
      continue;
      i = 28800;
      break;
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -2);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(c, 2, "updateLoginInfo error: " + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      a(paramString2, "get WUserSigInfo = null");
      return;
    }
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Util.a(paramString1, 1);
    int j = i;
    Object localObject1;
    if ((paramInt & 0x1000) != 0)
    {
      Object localObject2 = null;
      Ticket localTicket = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4096);
      localObject1 = localObject2;
      if (localTicket != null)
      {
        localObject1 = localObject2;
        if (localTicket._sig != null) {
          localObject1 = new String(localTicket._sig);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        j = -2;
        localStringBuilder.append("skey获取失败;");
      }
    }
    else
    {
      label113:
      i = j;
      if ((0x100000 & paramInt) != 0)
      {
        i = j;
        if ((0x8000000 & paramInt) == 0)
        {
          localObject1 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
          if (localObject1 != null) {
            break label328;
          }
          i = -2;
          localStringBuilder.append("pskey获取失败;Ticket = null");
        }
      }
      label166:
      if ((0x8000000 & paramInt) == 0) {
        break label530;
      }
      paramWUserSigInfo = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if (paramWUserSigInfo != null) {
        break label432;
      }
      paramInt = -2;
      localStringBuilder.append("pt4token获取失败;Ticket = null");
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", paramInt);
        if (paramInt < 0) {
          paramString1.put("message", localStringBuilder.toString());
        }
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(c, 2, "updateLoginInfo error: " + paramString1.getMessage());
      return;
      localObject1 = String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject1, str });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject1);
      j = i;
      break label113;
      label328:
      localObject1 = new String((byte[])((Ticket)localObject1)._pskey_map.get(paramString3));
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = -2;
        localStringBuilder.append("pskey获取失败;pskey = null");
        break label166;
      }
      paramString3 = "p_skey=" + (String)localObject1 + "; PATH=/; DOMAIN=." + paramString3 + ';';
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramString3);
      i = j;
      break label166;
      label432:
      paramWUserSigInfo = new String((byte[])paramWUserSigInfo._pt4token_map.get(paramString4));
      if (TextUtils.isEmpty(paramWUserSigInfo))
      {
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;pt4token = null");
      }
      for (;;)
      {
        paramWUserSigInfo = "pt4_token=" + paramWUserSigInfo + "; PATH=/; DOMAIN=." + paramString4 + ';';
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramWUserSigInfo);
        break;
        paramInt = i;
      }
      label530:
      paramInt = i;
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 11
    //   2: aload_3
    //   3: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +4952 -> 4958
    //   9: ldc_w 444
    //   12: aload 4
    //   14: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1138 -> 1155
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1131 -> 1155
    //   27: new 69	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc 8
    //   40: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 6
    //   45: aload_0
    //   46: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   49: invokevirtual 264	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   52: invokevirtual 269	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +4954 -> 5013
    //   62: aload 5
    //   64: ldc_w 446
    //   67: invokevirtual 449	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +4943 -> 5013
    //   73: aload 5
    //   75: invokestatic 454	com/tencent/biz/common/offline/HtmlOffline:f	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   84: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   87: astore 12
    //   89: aload 5
    //   91: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 12
    //   99: invokevirtual 203	com/tencent/common/app/AppInterface:isLogin	()Z
    //   102: ifne +29 -> 131
    //   105: aload 6
    //   107: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +21 -> 131
    //   113: aload_0
    //   114: aload 6
    //   116: iconst_1
    //   117: anewarray 218	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 456
    //   125: aastore
    //   126: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   135: ifnonnull +10 -> 145
    //   138: aload_0
    //   139: invokestatic 261	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   142: putfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   145: aload_0
    //   146: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   149: aload 5
    //   151: invokevirtual 458	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +907 -> 1064
    //   160: iconst_1
    //   161: istore 14
    //   163: aload_0
    //   164: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   167: aload 5
    //   169: invokevirtual 306	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   172: istore 17
    //   174: aload_0
    //   175: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   178: aload 5
    //   180: invokevirtual 459	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 8
    //   185: aload_0
    //   186: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   189: aload 5
    //   191: invokevirtual 330	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 11
    //   196: aload_0
    //   197: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   200: aload 5
    //   202: invokevirtual 314	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 13
    //   207: aload 12
    //   209: iconst_2
    //   210: invokevirtual 463	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   213: checkcast 465	mqq/manager/TicketManager
    //   216: astore 9
    //   218: new 69	org/json/JSONObject
    //   221: dup
    //   222: invokespecial 198	org/json/JSONObject:<init>	()V
    //   225: astore 7
    //   227: aload 12
    //   229: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   232: astore 10
    //   234: aload 7
    //   236: ldc_w 470
    //   239: aload 10
    //   241: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload 12
    //   247: invokevirtual 228	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   250: new 96	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   257: getstatic 476	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   260: invokevirtual 477	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   263: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 10
    //   268: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 480	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_1
    //   279: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifeq +4726 -> 5008
    //   285: invokestatic 486	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   288: invokevirtual 492	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   291: astore_2
    //   292: aload_2
    //   293: new 96	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 494
    //   303: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 10
    //   308: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 500	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   317: aconst_null
    //   318: ldc_w 502
    //   321: iconst_1
    //   322: anewarray 218	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload 10
    //   329: aastore
    //   330: aconst_null
    //   331: invokevirtual 508	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   334: astore_2
    //   335: aload_2
    //   336: ifnull +4666 -> 5002
    //   339: aload_2
    //   340: astore_3
    //   341: aload_2
    //   342: invokeinterface 513 1 0
    //   347: ifeq +4655 -> 5002
    //   350: aload_2
    //   351: astore_3
    //   352: aload_2
    //   353: aload_2
    //   354: ldc_w 515
    //   357: invokeinterface 518 2 0
    //   362: invokeinterface 522 2 0
    //   367: astore 4
    //   369: aload_2
    //   370: astore_3
    //   371: aload 4
    //   373: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +4623 -> 4999
    //   379: aload_2
    //   380: astore_3
    //   381: new 218	java/lang/String
    //   384: dup
    //   385: aload 4
    //   387: invokevirtual 526	java/lang/String:getBytes	()[B
    //   390: ldc_w 528
    //   393: invokespecial 531	java/lang/String:<init>	([BLjava/lang/String;)V
    //   396: invokestatic 534	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 4
    //   401: aload 4
    //   403: astore_1
    //   404: aload_1
    //   405: astore 4
    //   407: aload_2
    //   408: astore_3
    //   409: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +35 -> 447
    //   415: aload_2
    //   416: astore_3
    //   417: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   420: iconst_2
    //   421: new 96	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 536
    //   431: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 539	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: aload_1
    //   445: astore 4
    //   447: aload 4
    //   449: astore_3
    //   450: aload_2
    //   451: ifnull +12 -> 463
    //   454: aload_2
    //   455: invokeinterface 542 1 0
    //   460: aload 4
    //   462: astore_3
    //   463: aload 7
    //   465: ldc_w 544
    //   468: aload_3
    //   469: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   472: pop
    //   473: iload 14
    //   475: ifeq +3 -> 478
    //   478: iload 17
    //   480: ifeq +556 -> 1036
    //   483: aload 5
    //   485: invokestatic 546	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   488: astore_1
    //   489: aload_0
    //   490: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   493: ifnonnull +18 -> 511
    //   496: aload_0
    //   497: invokestatic 250	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   500: putfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   503: aload_0
    //   504: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   507: iconst_1
    //   508: invokevirtual 254	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   511: aload 9
    //   513: aload 10
    //   515: invokeinterface 549 2 0
    //   520: astore_2
    //   521: aload 7
    //   523: ldc_w 286
    //   526: aload_2
    //   527: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload_2
    //   532: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: ifne +90 -> 625
    //   538: ldc_w 407
    //   541: iconst_2
    //   542: anewarray 342	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: aload_2
    //   548: aastore
    //   549: dup
    //   550: iconst_1
    //   551: aload_1
    //   552: aastore
    //   553: invokestatic 410	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   556: astore_1
    //   557: aload_0
    //   558: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   561: aload 5
    //   563: aload_1
    //   564: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +55 -> 625
    //   573: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   576: iconst_2
    //   577: new 96	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 551
    //   587: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_1
    //   591: iconst_0
    //   592: anewarray 218	java/lang/String
    //   595: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   598: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 556
    //   604: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 5
    //   609: iconst_0
    //   610: anewarray 218	java/lang/String
    //   613: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   616: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: aload 13
    //   627: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   630: ifne +137 -> 767
    //   633: aload 9
    //   635: aload 10
    //   637: aload 13
    //   639: invokeinterface 562 3 0
    //   644: astore_1
    //   645: aload_1
    //   646: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   649: ifne +118 -> 767
    //   652: aload 7
    //   654: ldc_w 564
    //   657: aload_1
    //   658: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   661: pop
    //   662: new 96	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 428
    //   672: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_1
    //   676: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 430
    //   682: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload 13
    //   687: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: bipush 59
    //   692: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   695: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: astore_1
    //   699: aload_0
    //   700: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   703: aload 5
    //   705: aload_1
    //   706: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   709: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +55 -> 767
    //   715: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   718: iconst_2
    //   719: new 96	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 551
    //   729: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_1
    //   733: iconst_0
    //   734: anewarray 218	java/lang/String
    //   737: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   740: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: ldc_w 556
    //   746: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 5
    //   751: iconst_0
    //   752: anewarray 218	java/lang/String
    //   755: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   758: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: aload 11
    //   769: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   772: ifne +133 -> 905
    //   775: aload 12
    //   777: aload 11
    //   779: invokestatic 567	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:a	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   782: astore_1
    //   783: aload_1
    //   784: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   787: ifne +118 -> 905
    //   790: aload 7
    //   792: ldc_w 328
    //   795: aload_1
    //   796: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   799: pop
    //   800: new 96	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 440
    //   810: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_1
    //   814: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 430
    //   820: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 11
    //   825: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: bipush 59
    //   830: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   833: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: astore_1
    //   837: aload_0
    //   838: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   841: aload 5
    //   843: aload_1
    //   844: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   850: ifeq +55 -> 905
    //   853: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   856: iconst_2
    //   857: new 96	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 551
    //   867: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload_1
    //   871: iconst_0
    //   872: anewarray 218	java/lang/String
    //   875: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   878: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc_w 556
    //   884: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload 5
    //   889: iconst_0
    //   890: anewarray 218	java/lang/String
    //   893: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   896: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload 8
    //   907: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   910: ifne +126 -> 1036
    //   913: aload 9
    //   915: aload 10
    //   917: invokeinterface 570 2 0
    //   922: astore_1
    //   923: aload_1
    //   924: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   927: ifne +109 -> 1036
    //   930: new 96	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 572
    //   940: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload_1
    //   944: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: ldc_w 430
    //   950: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload 8
    //   955: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 574
    //   961: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: astore_1
    //   968: aload_0
    //   969: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   972: aload 5
    //   974: aload_1
    //   975: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   978: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   981: ifeq +55 -> 1036
    //   984: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   987: iconst_2
    //   988: new 96	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   995: ldc_w 551
    //   998: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: aload_1
    //   1002: iconst_0
    //   1003: anewarray 218	java/lang/String
    //   1006: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1009: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: ldc_w 556
    //   1015: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 5
    //   1020: iconst_0
    //   1021: anewarray 218	java/lang/String
    //   1024: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1027: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1036: aload 6
    //   1038: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1041: ifne +21 -> 1062
    //   1044: aload_0
    //   1045: aload 6
    //   1047: iconst_1
    //   1048: anewarray 218	java/lang/String
    //   1051: dup
    //   1052: iconst_0
    //   1053: aload 7
    //   1055: invokevirtual 219	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1058: aastore
    //   1059: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1062: iconst_1
    //   1063: ireturn
    //   1064: iconst_0
    //   1065: istore 14
    //   1067: goto -904 -> 163
    //   1070: astore 4
    //   1072: aconst_null
    //   1073: astore_2
    //   1074: aload_2
    //   1075: astore_3
    //   1076: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq +36 -> 1115
    //   1082: aload_2
    //   1083: astore_3
    //   1084: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   1087: iconst_2
    //   1088: new 96	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 576
    //   1098: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload 4
    //   1103: invokestatic 580	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1106: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: aload_1
    //   1116: astore_3
    //   1117: aload_2
    //   1118: ifnull -655 -> 463
    //   1121: aload_2
    //   1122: invokeinterface 542 1 0
    //   1127: aload_1
    //   1128: astore_3
    //   1129: goto -666 -> 463
    //   1132: astore_1
    //   1133: aload_1
    //   1134: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   1137: goto -75 -> 1062
    //   1140: astore_1
    //   1141: aconst_null
    //   1142: astore_3
    //   1143: aload_3
    //   1144: ifnull +9 -> 1153
    //   1147: aload_3
    //   1148: invokeinterface 542 1 0
    //   1153: aload_1
    //   1154: athrow
    //   1155: ldc_w 585
    //   1158: aload 4
    //   1160: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1163: ifeq +25 -> 1188
    //   1166: new 587	sxl
    //   1169: dup
    //   1170: aload_0
    //   1171: aload 5
    //   1173: iconst_0
    //   1174: aaload
    //   1175: invokespecial 590	sxl:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;)V
    //   1178: bipush 8
    //   1180: aconst_null
    //   1181: iconst_1
    //   1182: invokestatic 595	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1185: goto -123 -> 1062
    //   1188: ldc_w 597
    //   1191: aload 4
    //   1193: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1196: ifeq +222 -> 1418
    //   1199: aload_0
    //   1200: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1203: invokevirtual 600	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1206: invokevirtual 606	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1209: astore_1
    //   1210: aload_1
    //   1211: ldc_w 608
    //   1214: iconst_m1
    //   1215: invokevirtual 614	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1218: istore 14
    //   1220: new 69	org/json/JSONObject
    //   1223: dup
    //   1224: invokespecial 198	org/json/JSONObject:<init>	()V
    //   1227: astore_2
    //   1228: aload_0
    //   1229: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1232: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1235: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1238: astore_3
    //   1239: new 69	org/json/JSONObject
    //   1242: dup
    //   1243: aload 5
    //   1245: iconst_0
    //   1246: aaload
    //   1247: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1250: ldc 8
    //   1252: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1255: astore 4
    //   1257: aload_2
    //   1258: ldc_w 470
    //   1261: aload_3
    //   1262: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1265: pop
    //   1266: iload 14
    //   1268: iconst_m1
    //   1269: if_icmpne +63 -> 1332
    //   1272: aload_2
    //   1273: ldc_w 616
    //   1276: ldc_w 618
    //   1279: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1282: pop
    //   1283: aload 4
    //   1285: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1288: ifne -226 -> 1062
    //   1291: aload_0
    //   1292: aload 4
    //   1294: iconst_1
    //   1295: anewarray 218	java/lang/String
    //   1298: dup
    //   1299: iconst_0
    //   1300: aload_2
    //   1301: invokevirtual 219	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1304: aastore
    //   1305: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1308: goto -246 -> 1062
    //   1311: astore_1
    //   1312: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1315: ifeq -253 -> 1062
    //   1318: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   1321: iconst_2
    //   1322: ldc_w 620
    //   1325: aload_1
    //   1326: invokestatic 624	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1329: goto -267 -> 1062
    //   1332: iload 14
    //   1334: iconst_1
    //   1335: if_icmpne +47 -> 1382
    //   1338: aload_2
    //   1339: ldc_w 626
    //   1342: aload_1
    //   1343: ldc_w 628
    //   1346: invokevirtual 631	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1349: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1352: pop
    //   1353: aload_2
    //   1354: ldc_w 616
    //   1357: ldc_w 633
    //   1360: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1363: pop
    //   1364: aload_2
    //   1365: ldc_w 635
    //   1368: aload_1
    //   1369: ldc_w 637
    //   1372: invokevirtual 631	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1375: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1378: pop
    //   1379: goto -96 -> 1283
    //   1382: iload 14
    //   1384: sipush 3000
    //   1387: if_icmpne +17 -> 1404
    //   1390: aload_2
    //   1391: ldc_w 616
    //   1394: ldc_w 639
    //   1397: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1400: pop
    //   1401: goto -37 -> 1364
    //   1404: aload_2
    //   1405: ldc_w 616
    //   1408: ldc_w 641
    //   1411: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1414: pop
    //   1415: goto -51 -> 1364
    //   1418: ldc_w 643
    //   1421: aload 4
    //   1423: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1426: ifeq +104 -> 1530
    //   1429: new 69	org/json/JSONObject
    //   1432: dup
    //   1433: aload 5
    //   1435: iconst_0
    //   1436: aaload
    //   1437: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1440: astore_2
    //   1441: aload_2
    //   1442: ldc 8
    //   1444: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1447: astore_1
    //   1448: aload_2
    //   1449: ldc_w 470
    //   1452: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1455: astore_2
    //   1456: aload_2
    //   1457: aload_0
    //   1458: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1461: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1464: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1467: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1470: ifeq -408 -> 1062
    //   1473: aload_1
    //   1474: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1477: ifne -415 -> 1062
    //   1480: new 645	android/os/Bundle
    //   1483: dup
    //   1484: invokespecial 646	android/os/Bundle:<init>	()V
    //   1487: astore_3
    //   1488: aload_3
    //   1489: ldc_w 470
    //   1492: aload_2
    //   1493: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1496: ldc_w 651
    //   1499: aload_1
    //   1500: aload_0
    //   1501: getfield 47	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1504: getfield 655	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1507: aload_3
    //   1508: invokestatic 660	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1511: astore_1
    //   1512: invokestatic 665	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   1515: aload_1
    //   1516: invokevirtual 668	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   1519: goto -457 -> 1062
    //   1522: astore_1
    //   1523: aload_1
    //   1524: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   1527: goto -465 -> 1062
    //   1530: ldc_w 670
    //   1533: aload 4
    //   1535: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1538: ifeq +365 -> 1903
    //   1541: aload 5
    //   1543: arraylength
    //   1544: iconst_1
    //   1545: if_icmpne +358 -> 1903
    //   1548: new 69	org/json/JSONObject
    //   1551: dup
    //   1552: aload 5
    //   1554: iconst_0
    //   1555: aaload
    //   1556: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1559: astore 5
    //   1561: aload 5
    //   1563: ldc_w 672
    //   1566: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1569: astore_3
    //   1570: aload 5
    //   1572: ldc 8
    //   1574: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1577: astore 4
    //   1579: aload_3
    //   1580: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1583: ifne +23 -> 1606
    //   1586: aload_3
    //   1587: ldc_w 674
    //   1590: invokevirtual 449	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1593: ifne +46 -> 1639
    //   1596: aload_3
    //   1597: ldc_w 676
    //   1600: invokevirtual 449	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1603: ifne +36 -> 1639
    //   1606: aload 4
    //   1608: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1611: ifne +3405 -> 5016
    //   1614: aload_0
    //   1615: aload 4
    //   1617: iconst_2
    //   1618: anewarray 218	java/lang/String
    //   1621: dup
    //   1622: iconst_0
    //   1623: ldc_w 678
    //   1626: aastore
    //   1627: dup
    //   1628: iconst_1
    //   1629: ldc_w 680
    //   1632: aastore
    //   1633: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1636: goto +3380 -> 5016
    //   1639: aconst_null
    //   1640: astore_1
    //   1641: aload 5
    //   1643: ldc_w 682
    //   1646: invokevirtual 685	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1649: astore 6
    //   1651: aload 6
    //   1653: ifnull +72 -> 1725
    //   1656: new 645	android/os/Bundle
    //   1659: dup
    //   1660: invokespecial 646	android/os/Bundle:<init>	()V
    //   1663: astore_2
    //   1664: aload 6
    //   1666: invokevirtual 689	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1669: astore 7
    //   1671: aload_2
    //   1672: astore_1
    //   1673: aload 7
    //   1675: invokeinterface 694 1 0
    //   1680: ifeq +45 -> 1725
    //   1683: aload 7
    //   1685: invokeinterface 698 1 0
    //   1690: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1693: astore_1
    //   1694: aload 6
    //   1696: aload_1
    //   1697: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1700: astore 8
    //   1702: aload 8
    //   1704: ifnull -33 -> 1671
    //   1707: aload_2
    //   1708: aload_1
    //   1709: aload 8
    //   1711: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1714: goto -43 -> 1671
    //   1717: astore_1
    //   1718: aload_1
    //   1719: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   1722: goto -660 -> 1062
    //   1725: aload 5
    //   1727: ldc_w 703
    //   1730: invokevirtual 685	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1733: astore_2
    //   1734: aload_2
    //   1735: ifnull +161 -> 1896
    //   1738: ldc_w 705
    //   1741: aload_2
    //   1742: ldc_w 707
    //   1745: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1748: invokevirtual 710	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1751: ifeq +145 -> 1896
    //   1754: ldc_w 705
    //   1757: astore_2
    //   1758: new 645	android/os/Bundle
    //   1761: dup
    //   1762: invokespecial 646	android/os/Bundle:<init>	()V
    //   1765: astore 5
    //   1767: aload_0
    //   1768: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1771: ifnonnull +18 -> 1789
    //   1774: aload_0
    //   1775: invokestatic 250	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   1778: putfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1781: aload_0
    //   1782: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1785: iconst_1
    //   1786: invokevirtual 254	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   1789: aload_0
    //   1790: getfield 244	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1793: aload_3
    //   1794: invokevirtual 713	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   1797: astore 6
    //   1799: aload 6
    //   1801: ifnull +71 -> 1872
    //   1804: aload 5
    //   1806: ldc_w 715
    //   1809: aload 6
    //   1811: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1814: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1817: ifeq +55 -> 1872
    //   1820: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   1823: iconst_2
    //   1824: new 96	java/lang/StringBuilder
    //   1827: dup
    //   1828: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1831: ldc_w 717
    //   1834: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: aload 6
    //   1839: iconst_0
    //   1840: anewarray 218	java/lang/String
    //   1843: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1846: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: ldc_w 719
    //   1852: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_3
    //   1856: iconst_0
    //   1857: anewarray 218	java/lang/String
    //   1860: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1863: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1869: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1872: new 721	sxm
    //   1875: dup
    //   1876: aload_0
    //   1877: aload_3
    //   1878: aload_2
    //   1879: aload_1
    //   1880: aload 5
    //   1882: aload 4
    //   1884: invokespecial 724	sxm:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)V
    //   1887: iconst_5
    //   1888: aconst_null
    //   1889: iconst_1
    //   1890: invokestatic 595	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1893: goto -831 -> 1062
    //   1896: ldc_w 726
    //   1899: astore_2
    //   1900: goto -142 -> 1758
    //   1903: ldc_w 728
    //   1906: aload 4
    //   1908: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1911: ifeq +137 -> 2048
    //   1914: aload 5
    //   1916: arraylength
    //   1917: iconst_1
    //   1918: if_icmpne +130 -> 2048
    //   1921: new 69	org/json/JSONObject
    //   1924: dup
    //   1925: aload 5
    //   1927: iconst_0
    //   1928: aaload
    //   1929: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1932: astore_1
    //   1933: aload_1
    //   1934: ldc 8
    //   1936: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1939: astore_2
    //   1940: aload_2
    //   1941: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1944: ifne -882 -> 1062
    //   1947: ldc_w 730
    //   1950: aload_1
    //   1951: ldc_w 271
    //   1954: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1957: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1960: ifeq +23 -> 1983
    //   1963: aload_0
    //   1964: aload_2
    //   1965: iconst_1
    //   1966: anewarray 218	java/lang/String
    //   1969: dup
    //   1970: iconst_0
    //   1971: getstatic 735	com/tencent/mobileqq/activity/QQBrowserActivity:K	I
    //   1974: invokestatic 737	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1977: aastore
    //   1978: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1981: iconst_1
    //   1982: ireturn
    //   1983: aconst_null
    //   1984: astore_1
    //   1985: aload_0
    //   1986: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1989: invokevirtual 600	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1992: astore_3
    //   1993: aload_3
    //   1994: ifnull +14 -> 2008
    //   1997: aload_3
    //   1998: invokevirtual 606	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   2001: ldc_w 739
    //   2004: invokevirtual 631	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2007: astore_1
    //   2008: aload_1
    //   2009: ifnonnull +31 -> 2040
    //   2012: ldc_w 741
    //   2015: astore_1
    //   2016: aload_0
    //   2017: aload_2
    //   2018: iconst_1
    //   2019: anewarray 218	java/lang/String
    //   2022: dup
    //   2023: iconst_0
    //   2024: aload_1
    //   2025: aastore
    //   2026: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2029: goto -967 -> 1062
    //   2032: astore_1
    //   2033: aload_1
    //   2034: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   2037: goto -975 -> 1062
    //   2040: aload_1
    //   2041: invokestatic 743	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2044: astore_1
    //   2045: goto -29 -> 2016
    //   2048: ldc_w 745
    //   2051: aload 4
    //   2053: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2056: ifeq +126 -> 2182
    //   2059: aload 5
    //   2061: arraylength
    //   2062: iconst_1
    //   2063: if_icmpne +119 -> 2182
    //   2066: new 69	org/json/JSONObject
    //   2069: dup
    //   2070: aload 5
    //   2072: iconst_0
    //   2073: aaload
    //   2074: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2077: astore_1
    //   2078: aload_1
    //   2079: ldc_w 747
    //   2082: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2085: astore_2
    //   2086: aload_1
    //   2087: ldc 8
    //   2089: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2092: astore_1
    //   2093: aload_2
    //   2094: ifnonnull +2902 -> 4996
    //   2097: ldc_w 741
    //   2100: astore_2
    //   2101: invokestatic 486	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2104: ldc_w 749
    //   2107: invokevirtual 753	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2110: checkcast 755	android/text/ClipboardManager
    //   2113: astore_3
    //   2114: aload_3
    //   2115: ifnull +32 -> 2147
    //   2118: aload_3
    //   2119: aload_2
    //   2120: invokevirtual 759	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   2123: aload_1
    //   2124: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2127: ifne +18 -> 2145
    //   2130: aload_0
    //   2131: aload_1
    //   2132: iconst_1
    //   2133: anewarray 218	java/lang/String
    //   2136: dup
    //   2137: iconst_0
    //   2138: ldc_w 761
    //   2141: aastore
    //   2142: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2145: iconst_1
    //   2146: ireturn
    //   2147: aload_1
    //   2148: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2151: ifne -1089 -> 1062
    //   2154: aload_0
    //   2155: aload_1
    //   2156: iconst_1
    //   2157: anewarray 218	java/lang/String
    //   2160: dup
    //   2161: iconst_0
    //   2162: ldc_w 763
    //   2165: aastore
    //   2166: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2169: goto -1107 -> 1062
    //   2172: astore_2
    //   2173: aconst_null
    //   2174: astore_1
    //   2175: aload_2
    //   2176: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   2179: goto -32 -> 2147
    //   2182: ldc_w 765
    //   2185: aload 4
    //   2187: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2190: ifeq +124 -> 2314
    //   2193: aload 5
    //   2195: arraylength
    //   2196: iconst_1
    //   2197: if_icmpne +117 -> 2314
    //   2200: new 69	org/json/JSONObject
    //   2203: dup
    //   2204: aload 5
    //   2206: iconst_0
    //   2207: aaload
    //   2208: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2211: ldc 8
    //   2213: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2216: astore_2
    //   2217: aload_2
    //   2218: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2221: ifne -1159 -> 1062
    //   2224: invokestatic 486	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2227: ldc_w 749
    //   2230: invokevirtual 753	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2233: checkcast 755	android/text/ClipboardManager
    //   2236: astore_1
    //   2237: aload_1
    //   2238: ifnull +2751 -> 4989
    //   2241: aload_1
    //   2242: invokevirtual 769	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   2245: astore_1
    //   2246: aload_1
    //   2247: ifnull +2742 -> 4989
    //   2250: aload_1
    //   2251: invokeinterface 772 1 0
    //   2256: astore_1
    //   2257: aload_0
    //   2258: aload_2
    //   2259: iconst_1
    //   2260: anewarray 218	java/lang/String
    //   2263: dup
    //   2264: iconst_0
    //   2265: aload_1
    //   2266: invokestatic 743	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2269: aastore
    //   2270: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2273: goto -1211 -> 1062
    //   2276: astore_1
    //   2277: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   2280: iconst_1
    //   2281: new 96	java/lang/StringBuilder
    //   2284: dup
    //   2285: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   2288: ldc_w 774
    //   2291: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: aload_1
    //   2295: invokevirtual 278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2298: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2304: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2307: aload_1
    //   2308: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   2311: goto -1249 -> 1062
    //   2314: ldc_w 777
    //   2317: aload 4
    //   2319: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2322: ifeq +200 -> 2522
    //   2325: aload 5
    //   2327: arraylength
    //   2328: iconst_1
    //   2329: if_icmpne +193 -> 2522
    //   2332: new 69	org/json/JSONObject
    //   2335: dup
    //   2336: aload 5
    //   2338: iconst_0
    //   2339: aaload
    //   2340: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2343: astore_1
    //   2344: aload_1
    //   2345: ldc_w 779
    //   2348: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2351: astore_2
    //   2352: aload_1
    //   2353: ldc_w 781
    //   2356: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2359: astore_3
    //   2360: aload_1
    //   2361: ldc_w 783
    //   2364: iconst_1
    //   2365: invokevirtual 787	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2368: istore 17
    //   2370: aload_1
    //   2371: ldc 8
    //   2373: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2376: astore 4
    //   2378: new 69	org/json/JSONObject
    //   2381: dup
    //   2382: invokespecial 198	org/json/JSONObject:<init>	()V
    //   2385: astore 5
    //   2387: aload_2
    //   2388: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2391: ifne +108 -> 2499
    //   2394: aload_3
    //   2395: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2398: ifne +101 -> 2499
    //   2401: aload_0
    //   2402: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2405: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2408: astore_1
    //   2409: aload_1
    //   2410: instanceof 789
    //   2413: ifeq +2571 -> 4984
    //   2416: aload_1
    //   2417: checkcast 789	com/tencent/mobileqq/app/QQAppInterface
    //   2420: astore_1
    //   2421: aload_1
    //   2422: aload_2
    //   2423: aload_3
    //   2424: iload 17
    //   2426: invokestatic 794	com/tencent/mobileqq/statistics/DcReportUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2429: aload 5
    //   2431: ldc -51
    //   2433: iconst_0
    //   2434: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2437: pop
    //   2438: aload 5
    //   2440: ldc -45
    //   2442: ldc_w 796
    //   2445: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2448: pop
    //   2449: aload 4
    //   2451: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2454: ifne -1392 -> 1062
    //   2457: aload_0
    //   2458: aload 4
    //   2460: iconst_1
    //   2461: anewarray 218	java/lang/String
    //   2464: dup
    //   2465: iconst_0
    //   2466: aload 5
    //   2468: invokevirtual 219	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2471: aastore
    //   2472: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2475: goto -1413 -> 1062
    //   2478: astore_1
    //   2479: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2482: ifeq -1420 -> 1062
    //   2485: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   2488: iconst_2
    //   2489: aload_1
    //   2490: invokevirtual 278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2493: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2496: goto -1434 -> 1062
    //   2499: aload 5
    //   2501: ldc -51
    //   2503: iconst_m1
    //   2504: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2507: pop
    //   2508: aload 5
    //   2510: ldc -45
    //   2512: ldc_w 800
    //   2515: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2518: pop
    //   2519: goto -70 -> 2449
    //   2522: ldc_w 802
    //   2525: aload 4
    //   2527: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2530: ifeq +475 -> 3005
    //   2533: aload 5
    //   2535: arraylength
    //   2536: iconst_1
    //   2537: if_icmpne +468 -> 3005
    //   2540: new 69	org/json/JSONObject
    //   2543: dup
    //   2544: aload 5
    //   2546: iconst_0
    //   2547: aaload
    //   2548: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2551: astore_1
    //   2552: aload_1
    //   2553: ldc_w 804
    //   2556: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2559: astore_3
    //   2560: aload_1
    //   2561: ldc_w 806
    //   2564: invokevirtual 76	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2567: astore_1
    //   2568: aload_0
    //   2569: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2572: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2575: astore_2
    //   2576: ldc_w 808
    //   2579: aload_3
    //   2580: invokevirtual 710	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2583: ifeq +233 -> 2816
    //   2586: aload_1
    //   2587: ldc_w 810
    //   2590: ldc_w 741
    //   2593: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2596: astore_3
    //   2597: aload_1
    //   2598: ldc_w 814
    //   2601: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2604: astore 4
    //   2606: aload_1
    //   2607: ldc_w 818
    //   2610: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2613: astore 5
    //   2615: aload_1
    //   2616: ldc_w 820
    //   2619: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2622: astore 6
    //   2624: aload_1
    //   2625: ldc_w 822
    //   2628: ldc_w 741
    //   2631: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2634: astore 7
    //   2636: aload_1
    //   2637: ldc_w 824
    //   2640: iconst_0
    //   2641: invokevirtual 827	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2644: istore 14
    //   2646: aload_1
    //   2647: ldc_w 829
    //   2650: iconst_1
    //   2651: invokevirtual 827	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2654: istore 15
    //   2656: aload_1
    //   2657: ldc_w 831
    //   2660: iconst_0
    //   2661: invokevirtual 827	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2664: istore 16
    //   2666: aload_1
    //   2667: ldc_w 833
    //   2670: ldc_w 741
    //   2673: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2676: astore 8
    //   2678: aload_1
    //   2679: ldc_w 835
    //   2682: ldc_w 741
    //   2685: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2688: astore 9
    //   2690: aload_1
    //   2691: ldc_w 837
    //   2694: ldc_w 741
    //   2697: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2700: astore 10
    //   2702: aload_1
    //   2703: ldc_w 839
    //   2706: ldc_w 741
    //   2709: invokevirtual 812	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2712: astore 11
    //   2714: aconst_null
    //   2715: astore_1
    //   2716: aload_2
    //   2717: instanceof 789
    //   2720: ifeq +8 -> 2728
    //   2723: aload_2
    //   2724: checkcast 789	com/tencent/mobileqq/app/QQAppInterface
    //   2727: astore_1
    //   2728: aload_2
    //   2729: invokevirtual 203	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2732: ifeq +54 -> 2786
    //   2735: aload_1
    //   2736: aload 4
    //   2738: aload_3
    //   2739: aload 7
    //   2741: aload 5
    //   2743: aload 6
    //   2745: iload 14
    //   2747: iload 15
    //   2749: iload 16
    //   2751: aload 8
    //   2753: aload 9
    //   2755: aload 10
    //   2757: aload 11
    //   2759: invokestatic 844	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2762: goto -1700 -> 1062
    //   2765: astore_1
    //   2766: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2769: ifeq -1707 -> 1062
    //   2772: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   2775: iconst_2
    //   2776: aload_1
    //   2777: invokevirtual 845	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2780: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2783: goto -1721 -> 1062
    //   2786: aload_1
    //   2787: aload 4
    //   2789: aload_3
    //   2790: aload 7
    //   2792: aload 5
    //   2794: aload 6
    //   2796: iload 14
    //   2798: iload 15
    //   2800: iload 16
    //   2802: aload 8
    //   2804: aload 9
    //   2806: aload 10
    //   2808: aload 11
    //   2810: invokestatic 847	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2813: goto -1751 -> 1062
    //   2816: ldc_w 849
    //   2819: aload_3
    //   2820: invokevirtual 710	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2823: ifeq +163 -> 2986
    //   2826: aload_1
    //   2827: ldc_w 851
    //   2830: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2833: astore_3
    //   2834: aload_1
    //   2835: ldc_w 853
    //   2838: iconst_1
    //   2839: invokevirtual 787	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2842: istore 17
    //   2844: aload_1
    //   2845: ldc_w 855
    //   2848: iconst_1
    //   2849: invokevirtual 787	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2852: istore 18
    //   2854: aload_1
    //   2855: ldc_w 857
    //   2858: iconst_0
    //   2859: invokevirtual 827	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2862: istore 14
    //   2864: aload_1
    //   2865: ldc_w 859
    //   2868: iconst_0
    //   2869: invokevirtual 827	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2872: istore 15
    //   2874: new 861	java/util/HashMap
    //   2877: dup
    //   2878: invokespecial 862	java/util/HashMap:<init>	()V
    //   2881: astore 4
    //   2883: aload_1
    //   2884: ldc_w 864
    //   2887: invokevirtual 685	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2890: astore_1
    //   2891: aload_1
    //   2892: ifnull +53 -> 2945
    //   2895: aload_1
    //   2896: invokevirtual 689	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2899: astore 5
    //   2901: aload 5
    //   2903: ifnull +42 -> 2945
    //   2906: aload 5
    //   2908: invokeinterface 694 1 0
    //   2913: ifeq +32 -> 2945
    //   2916: aload 5
    //   2918: invokeinterface 698 1 0
    //   2923: checkcast 218	java/lang/String
    //   2926: astore 6
    //   2928: aload 4
    //   2930: aload 6
    //   2932: aload_1
    //   2933: aload 6
    //   2935: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2938: invokevirtual 867	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2941: pop
    //   2942: goto -41 -> 2901
    //   2945: aconst_null
    //   2946: astore_1
    //   2947: aload_2
    //   2948: invokevirtual 203	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2951: ifeq +8 -> 2959
    //   2954: aload_2
    //   2955: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2958: astore_1
    //   2959: aconst_null
    //   2960: invokestatic 872	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2963: aload_1
    //   2964: aload_3
    //   2965: iload 18
    //   2967: iload 14
    //   2969: i2l
    //   2970: iload 15
    //   2972: i2l
    //   2973: aload 4
    //   2975: ldc_w 741
    //   2978: iload 17
    //   2980: invokevirtual 875	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2983: goto -1921 -> 1062
    //   2986: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2989: ifeq -1927 -> 1062
    //   2992: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   2995: iconst_2
    //   2996: ldc_w 877
    //   2999: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3002: goto -1940 -> 1062
    //   3005: ldc_w 879
    //   3008: aload 4
    //   3010: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3013: ifeq +181 -> 3194
    //   3016: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3019: ifeq +13 -> 3032
    //   3022: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3025: iconst_2
    //   3026: ldc_w 879
    //   3029: invokestatic 539	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3032: new 69	org/json/JSONObject
    //   3035: dup
    //   3036: aload 5
    //   3038: iconst_0
    //   3039: aaload
    //   3040: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3043: astore_2
    //   3044: aload_2
    //   3045: ldc 8
    //   3047: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3050: astore_1
    //   3051: aload_2
    //   3052: ldc_w 470
    //   3055: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3058: astore_2
    //   3059: aload_1
    //   3060: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3063: ifne +112 -> 3175
    //   3066: new 645	android/os/Bundle
    //   3069: dup
    //   3070: invokespecial 646	android/os/Bundle:<init>	()V
    //   3073: astore_3
    //   3074: aload_2
    //   3075: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3078: ifne +77 -> 3155
    //   3081: aload_3
    //   3082: ldc_w 470
    //   3085: aload_2
    //   3086: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3089: ldc_w 881
    //   3092: aload_1
    //   3093: aload_0
    //   3094: getfield 47	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   3097: getfield 655	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   3100: aload_3
    //   3101: invokestatic 660	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3104: astore_1
    //   3105: invokestatic 665	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3108: aload_1
    //   3109: invokevirtual 668	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   3112: goto -2050 -> 1062
    //   3115: astore_1
    //   3116: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3119: ifeq -2057 -> 1062
    //   3122: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3125: iconst_2
    //   3126: new 96	java/lang/StringBuilder
    //   3129: dup
    //   3130: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3133: ldc_w 883
    //   3136: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3139: aload_1
    //   3140: invokevirtual 845	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3143: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3146: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3149: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3152: goto -2090 -> 1062
    //   3155: aload_3
    //   3156: ldc_w 470
    //   3159: aload_0
    //   3160: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3163: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3166: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3169: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3172: goto -83 -> 3089
    //   3175: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3178: ifeq -2116 -> 1062
    //   3181: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3184: iconst_2
    //   3185: ldc_w 885
    //   3188: invokestatic 539	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3191: goto -2129 -> 1062
    //   3194: ldc_w 887
    //   3197: aload 4
    //   3199: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3202: ifeq +117 -> 3319
    //   3205: aload 5
    //   3207: arraylength
    //   3208: iconst_1
    //   3209: if_icmpne +110 -> 3319
    //   3212: new 69	org/json/JSONObject
    //   3215: dup
    //   3216: aload 5
    //   3218: iconst_0
    //   3219: aaload
    //   3220: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3223: ldc 8
    //   3225: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3228: astore_1
    //   3229: aload_1
    //   3230: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3233: ifne -2171 -> 1062
    //   3236: aload_0
    //   3237: aload_1
    //   3238: iconst_1
    //   3239: anewarray 218	java/lang/String
    //   3242: dup
    //   3243: iconst_0
    //   3244: new 96	java/lang/StringBuilder
    //   3247: dup
    //   3248: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3251: ldc_w 889
    //   3254: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: getstatic 892	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   3260: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3263: ldc_w 894
    //   3266: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3269: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3272: aastore
    //   3273: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3276: goto -2214 -> 1062
    //   3279: astore_1
    //   3280: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3283: ifeq -2221 -> 1062
    //   3286: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3289: iconst_2
    //   3290: new 96	java/lang/StringBuilder
    //   3293: dup
    //   3294: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3297: ldc_w 896
    //   3300: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: aload_1
    //   3304: invokevirtual 845	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3307: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3310: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3313: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3316: goto -2254 -> 1062
    //   3319: ldc_w 898
    //   3322: aload 4
    //   3324: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3327: ifeq +523 -> 3850
    //   3330: aload 5
    //   3332: arraylength
    //   3333: iconst_1
    //   3334: if_icmpne +516 -> 3850
    //   3337: new 69	org/json/JSONObject
    //   3340: dup
    //   3341: aload 5
    //   3343: iconst_0
    //   3344: aaload
    //   3345: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3348: astore_1
    //   3349: aload_1
    //   3350: ldc 8
    //   3352: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3355: astore_3
    //   3356: aload_1
    //   3357: ldc_w 900
    //   3360: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3363: astore_1
    //   3364: aload_1
    //   3365: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3368: ifne +1610 -> 4978
    //   3371: aload_1
    //   3372: invokevirtual 903	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3375: astore 4
    //   3377: aload_0
    //   3378: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3381: invokevirtual 179	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3384: astore_2
    //   3385: aload_2
    //   3386: ifnull +1592 -> 4978
    //   3389: aload_2
    //   3390: invokevirtual 203	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3393: ifeq +1585 -> 4978
    //   3396: aload_2
    //   3397: invokevirtual 468	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3400: astore_1
    //   3401: aload_2
    //   3402: iconst_2
    //   3403: invokevirtual 463	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3406: checkcast 465	mqq/manager/TicketManager
    //   3409: astore_2
    //   3410: aload_2
    //   3411: aload_1
    //   3412: aload 4
    //   3414: invokeinterface 562 3 0
    //   3419: astore 8
    //   3421: aload_2
    //   3422: aload_1
    //   3423: aload 4
    //   3425: invokeinterface 906 3 0
    //   3430: astore 5
    //   3432: aload 8
    //   3434: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3437: ifne +1541 -> 4978
    //   3440: new 96	java/lang/StringBuilder
    //   3443: dup
    //   3444: bipush 111
    //   3446: invokespecial 908	java/lang/StringBuilder:<init>	(I)V
    //   3449: astore_2
    //   3450: aload_1
    //   3451: invokevirtual 911	java/lang/String:length	()I
    //   3454: bipush 10
    //   3456: if_icmpge +32 -> 3488
    //   3459: aload_1
    //   3460: invokevirtual 911	java/lang/String:length	()I
    //   3463: istore 14
    //   3465: iload 14
    //   3467: bipush 10
    //   3469: if_icmpge +19 -> 3488
    //   3472: aload_2
    //   3473: bipush 48
    //   3475: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3478: pop
    //   3479: iload 14
    //   3481: iconst_1
    //   3482: iadd
    //   3483: istore 14
    //   3485: goto -20 -> 3465
    //   3488: aload_2
    //   3489: aload_1
    //   3490: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: pop
    //   3494: invokestatic 250	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3497: astore 6
    //   3499: aload 6
    //   3501: iconst_1
    //   3502: invokevirtual 254	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3505: new 96	java/lang/StringBuilder
    //   3508: dup
    //   3509: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3512: ldc_w 674
    //   3515: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: aload 4
    //   3520: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3523: bipush 47
    //   3525: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3528: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3531: astore 7
    //   3533: new 96	java/lang/StringBuilder
    //   3536: dup
    //   3537: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3540: ldc_w 913
    //   3543: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3546: aload_2
    //   3547: invokevirtual 916	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3550: ldc_w 430
    //   3553: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload 4
    //   3558: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: bipush 59
    //   3563: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3566: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3569: astore 9
    //   3571: aload 6
    //   3573: aload 7
    //   3575: aload 9
    //   3577: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3580: ldc_w 741
    //   3583: astore_1
    //   3584: ldc_w 741
    //   3587: astore_2
    //   3588: aload 8
    //   3590: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3593: ifne +49 -> 3642
    //   3596: new 96	java/lang/StringBuilder
    //   3599: dup
    //   3600: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3603: ldc_w 428
    //   3606: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3609: aload 8
    //   3611: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: ldc_w 430
    //   3617: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3620: aload 4
    //   3622: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: bipush 59
    //   3627: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3630: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3633: astore_1
    //   3634: aload 6
    //   3636: aload 7
    //   3638: aload_1
    //   3639: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3642: aload 5
    //   3644: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3647: ifne +49 -> 3696
    //   3650: new 96	java/lang/StringBuilder
    //   3653: dup
    //   3654: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3657: ldc_w 440
    //   3660: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3663: aload 5
    //   3665: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3668: ldc_w 430
    //   3671: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3674: aload 4
    //   3676: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3679: bipush 59
    //   3681: invokevirtual 433	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3684: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3687: astore_2
    //   3688: aload 6
    //   3690: aload 7
    //   3692: aload_2
    //   3693: invokevirtual 413	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3696: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3699: ifeq +1319 -> 5018
    //   3702: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3705: iconst_2
    //   3706: new 96	java/lang/StringBuilder
    //   3709: dup
    //   3710: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3713: ldc_w 551
    //   3716: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: aload 9
    //   3721: iconst_0
    //   3722: anewarray 218	java/lang/String
    //   3725: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3728: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3731: aload_1
    //   3732: iconst_0
    //   3733: anewarray 218	java/lang/String
    //   3736: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3739: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3742: aload_2
    //   3743: iconst_0
    //   3744: anewarray 218	java/lang/String
    //   3747: invokestatic 554	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3750: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3753: ldc_w 556
    //   3756: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3759: aload 7
    //   3761: iconst_0
    //   3762: anewarray 218	java/lang/String
    //   3765: invokestatic 558	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3768: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3774: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3777: goto +1241 -> 5018
    //   3780: aload_3
    //   3781: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3784: ifne -2722 -> 1062
    //   3787: aload_0
    //   3788: aload_3
    //   3789: iconst_1
    //   3790: anewarray 218	java/lang/String
    //   3793: dup
    //   3794: iconst_0
    //   3795: new 96	java/lang/StringBuilder
    //   3798: dup
    //   3799: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   3802: ldc_w 918
    //   3805: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3808: iload 14
    //   3810: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3813: ldc_w 894
    //   3816: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3819: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3822: aastore
    //   3823: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3826: goto -2764 -> 1062
    //   3829: astore_1
    //   3830: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3833: ifeq -2771 -> 1062
    //   3836: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   3839: iconst_2
    //   3840: ldc_w 920
    //   3843: aload_1
    //   3844: invokestatic 624	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3847: goto -2785 -> 1062
    //   3850: ldc_w 922
    //   3853: aload 4
    //   3855: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3858: ifeq +13 -> 3871
    //   3861: aload_0
    //   3862: aload_2
    //   3863: aload 5
    //   3865: invokespecial 924	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3868: goto -2806 -> 1062
    //   3871: ldc_w 926
    //   3874: aload 4
    //   3876: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3879: ifeq +139 -> 4018
    //   3882: aconst_null
    //   3883: astore_2
    //   3884: aload_2
    //   3885: astore_1
    //   3886: new 69	org/json/JSONObject
    //   3889: dup
    //   3890: aload 5
    //   3892: iconst_0
    //   3893: aaload
    //   3894: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3897: astore_3
    //   3898: aload_2
    //   3899: astore_1
    //   3900: aload_3
    //   3901: ldc 8
    //   3903: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3906: astore_2
    //   3907: aload_2
    //   3908: astore_1
    //   3909: aload_3
    //   3910: ldc_w 470
    //   3913: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3916: astore_3
    //   3917: aload_2
    //   3918: astore_1
    //   3919: invokestatic 665	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3922: invokevirtual 928	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Z
    //   3925: ifeq -2863 -> 1062
    //   3928: aload_2
    //   3929: astore_1
    //   3930: new 645	android/os/Bundle
    //   3933: dup
    //   3934: invokespecial 646	android/os/Bundle:<init>	()V
    //   3937: astore 4
    //   3939: aload_2
    //   3940: astore_1
    //   3941: aload 4
    //   3943: ldc_w 470
    //   3946: aload_3
    //   3947: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3950: aload_2
    //   3951: astore_1
    //   3952: ldc_w 930
    //   3955: aload_2
    //   3956: aload_0
    //   3957: getfield 47	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   3960: getfield 655	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   3963: aload 4
    //   3965: invokestatic 660	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3968: astore_3
    //   3969: aload_2
    //   3970: astore_1
    //   3971: invokestatic 665	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3974: aload_3
    //   3975: invokevirtual 668	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   3978: goto -2916 -> 1062
    //   3981: astore_2
    //   3982: aload_1
    //   3983: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3986: ifne -2924 -> 1062
    //   3989: aload_0
    //   3990: aload_1
    //   3991: iconst_1
    //   3992: anewarray 218	java/lang/String
    //   3995: dup
    //   3996: iconst_0
    //   3997: ldc_w 932
    //   4000: iconst_1
    //   4001: anewarray 342	java/lang/Object
    //   4004: dup
    //   4005: iconst_0
    //   4006: aload_2
    //   4007: aastore
    //   4008: invokestatic 410	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4011: aastore
    //   4012: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4015: goto -2953 -> 1062
    //   4018: ldc_w 934
    //   4021: aload 4
    //   4023: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4026: ifeq +130 -> 4156
    //   4029: new 69	org/json/JSONObject
    //   4032: dup
    //   4033: aload 5
    //   4035: iconst_0
    //   4036: aaload
    //   4037: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4040: astore_1
    //   4041: ldc_w 936
    //   4044: aload_1
    //   4045: ldc_w 938
    //   4048: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4051: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4054: ifeq +24 -> 4078
    //   4057: aload_0
    //   4058: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4061: invokevirtual 600	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4064: astore_2
    //   4065: aload_2
    //   4066: ifnull +12 -> 4078
    //   4069: aload_2
    //   4070: iconst_m1
    //   4071: invokevirtual 941	android/app/Activity:setResult	(I)V
    //   4074: aload_2
    //   4075: invokevirtual 944	android/app/Activity:finish	()V
    //   4078: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4081: ifeq -3019 -> 1062
    //   4084: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4087: iconst_2
    //   4088: new 96	java/lang/StringBuilder
    //   4091: dup
    //   4092: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   4095: ldc_w 946
    //   4098: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: aload_1
    //   4102: invokevirtual 949	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4105: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4108: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4111: goto -3049 -> 1062
    //   4114: astore_1
    //   4115: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4118: ifeq +14 -> 4132
    //   4121: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4124: iconst_2
    //   4125: ldc_w 951
    //   4128: aload_1
    //   4129: invokestatic 624	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4132: aload_0
    //   4133: getfield 174	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4136: invokevirtual 600	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4139: astore_1
    //   4140: aload_1
    //   4141: ifnull -3079 -> 1062
    //   4144: aload_1
    //   4145: iconst_0
    //   4146: invokevirtual 941	android/app/Activity:setResult	(I)V
    //   4149: aload_1
    //   4150: invokevirtual 944	android/app/Activity:finish	()V
    //   4153: goto -3091 -> 1062
    //   4156: ldc_w 953
    //   4159: aload 4
    //   4161: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4164: ifeq +381 -> 4545
    //   4167: aload 5
    //   4169: arraylength
    //   4170: iconst_1
    //   4171: if_icmpne +374 -> 4545
    //   4174: new 69	org/json/JSONObject
    //   4177: dup
    //   4178: aload 5
    //   4180: iconst_0
    //   4181: aaload
    //   4182: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4185: astore_3
    //   4186: aload_3
    //   4187: ldc 8
    //   4189: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4192: astore_2
    //   4193: aload_3
    //   4194: ldc_w 955
    //   4197: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4200: astore 4
    //   4202: aload_3
    //   4203: ldc_w 900
    //   4206: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4209: astore_1
    //   4210: aload_0
    //   4211: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4214: ifnonnull +10 -> 4224
    //   4217: aload_0
    //   4218: invokestatic 261	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   4221: putfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4224: iconst_0
    //   4225: istore 18
    //   4227: iload 18
    //   4229: istore 17
    //   4231: aload 4
    //   4233: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4236: ifne +71 -> 4307
    //   4239: iload 18
    //   4241: istore 17
    //   4243: aload_1
    //   4244: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4247: ifne +60 -> 4307
    //   4250: new 96	java/lang/StringBuilder
    //   4253: dup
    //   4254: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   4257: ldc_w 674
    //   4260: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4263: aload_1
    //   4264: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: ldc_w 957
    //   4270: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4273: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4276: astore_1
    //   4277: ldc_w 959
    //   4280: aload 4
    //   4282: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4285: ifeq +68 -> 4353
    //   4288: aload_3
    //   4289: ldc_w 961
    //   4292: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4295: astore_3
    //   4296: aload_0
    //   4297: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4300: aload_1
    //   4301: aload_3
    //   4302: invokevirtual 964	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4305: istore 17
    //   4307: iload 17
    //   4309: ifeq +229 -> 4538
    //   4312: ldc_w 966
    //   4315: astore_1
    //   4316: aload_0
    //   4317: aload_2
    //   4318: iconst_1
    //   4319: anewarray 218	java/lang/String
    //   4322: dup
    //   4323: iconst_0
    //   4324: aload_1
    //   4325: aastore
    //   4326: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4329: goto -3267 -> 1062
    //   4332: astore_1
    //   4333: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4336: ifeq -3274 -> 1062
    //   4339: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4342: iconst_2
    //   4343: ldc_w 968
    //   4346: aload_1
    //   4347: invokestatic 624	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4350: goto -3288 -> 1062
    //   4353: ldc_w 286
    //   4356: aload 4
    //   4358: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4361: ifeq +16 -> 4377
    //   4364: aload_0
    //   4365: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4368: aload_1
    //   4369: invokevirtual 306	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   4372: istore 17
    //   4374: goto -67 -> 4307
    //   4377: ldc_w 970
    //   4380: aload 4
    //   4382: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4385: ifeq +23 -> 4408
    //   4388: aload_0
    //   4389: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4392: aload_1
    //   4393: invokevirtual 458	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4396: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4399: ifne +625 -> 5024
    //   4402: iconst_1
    //   4403: istore 17
    //   4405: goto -98 -> 4307
    //   4408: ldc_w 312
    //   4411: aload 4
    //   4413: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4416: ifeq +23 -> 4439
    //   4419: aload_0
    //   4420: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4423: aload_1
    //   4424: invokevirtual 314	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4427: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4430: ifne +600 -> 5030
    //   4433: iconst_1
    //   4434: istore 17
    //   4436: goto -129 -> 4307
    //   4439: ldc_w 972
    //   4442: aload 4
    //   4444: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4447: ifeq +25 -> 4472
    //   4450: aload_3
    //   4451: ldc_w 972
    //   4454: invokevirtual 816	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4457: astore_3
    //   4458: aload_0
    //   4459: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4462: aload_1
    //   4463: aload_3
    //   4464: invokevirtual 974	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4467: istore 17
    //   4469: goto -162 -> 4307
    //   4472: ldc_w 328
    //   4475: aload 4
    //   4477: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4480: ifeq +23 -> 4503
    //   4483: aload_0
    //   4484: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4487: aload_1
    //   4488: invokevirtual 330	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   4491: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4494: ifne +542 -> 5036
    //   4497: iconst_1
    //   4498: istore 17
    //   4500: goto -193 -> 4307
    //   4503: iload 18
    //   4505: istore 17
    //   4507: ldc_w 976
    //   4510: aload 4
    //   4512: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4515: ifeq -208 -> 4307
    //   4518: aload_0
    //   4519: getfield 256	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4522: aload_1
    //   4523: invokevirtual 459	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   4526: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4529: ifne +513 -> 5042
    //   4532: iconst_1
    //   4533: istore 17
    //   4535: goto -228 -> 4307
    //   4538: ldc_w 978
    //   4541: astore_1
    //   4542: goto -226 -> 4316
    //   4545: ldc_w 980
    //   4548: aload 4
    //   4550: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4553: ifeq +111 -> 4664
    //   4556: new 69	org/json/JSONObject
    //   4559: dup
    //   4560: aload 5
    //   4562: iconst_0
    //   4563: aaload
    //   4564: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4567: astore_1
    //   4568: aload_1
    //   4569: ldc -51
    //   4571: iconst_0
    //   4572: invokevirtual 787	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4575: istore 17
    //   4577: aload_0
    //   4578: getfield 982	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4581: ifnonnull +17 -> 4598
    //   4584: aload_0
    //   4585: invokestatic 987	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4588: putfield 982	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4591: aload_0
    //   4592: getfield 982	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4595: invokevirtual 989	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4598: aload_0
    //   4599: getfield 982	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4602: iload 17
    //   4604: invokevirtual 991	com/tencent/biz/troop/TroopMemberApiClient:a	(Z)V
    //   4607: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4610: ifeq -3548 -> 1062
    //   4613: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4616: iconst_2
    //   4617: new 96	java/lang/StringBuilder
    //   4620: dup
    //   4621: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   4624: ldc_w 993
    //   4627: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4630: aload_1
    //   4631: invokevirtual 949	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4634: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4637: invokestatic 798	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4640: goto -3578 -> 1062
    //   4643: astore_1
    //   4644: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4647: ifeq -3585 -> 1062
    //   4650: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4653: iconst_2
    //   4654: ldc_w 951
    //   4657: aload_1
    //   4658: invokestatic 624	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4661: goto -3599 -> 1062
    //   4664: ldc_w 995
    //   4667: aload 4
    //   4669: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4672: ifeq +147 -> 4819
    //   4675: new 69	org/json/JSONObject
    //   4678: dup
    //   4679: aload 5
    //   4681: iconst_0
    //   4682: aaload
    //   4683: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4686: astore_1
    //   4687: aload_1
    //   4688: ldc_w 997
    //   4691: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4694: astore_2
    //   4695: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4698: ifeq +30 -> 4728
    //   4701: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4704: iconst_2
    //   4705: new 96	java/lang/StringBuilder
    //   4708: dup
    //   4709: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   4712: ldc_w 999
    //   4715: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4718: aload_2
    //   4719: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4722: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4725: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4728: aload_0
    //   4729: getfield 86	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface	Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4732: invokeinterface 1002 1 0
    //   4737: astore_2
    //   4738: aload_2
    //   4739: ifnull -3677 -> 1062
    //   4742: aload_2
    //   4743: invokevirtual 1005	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4746: astore_2
    //   4747: aload_2
    //   4748: iconst_1
    //   4749: anewarray 218	java/lang/String
    //   4752: dup
    //   4753: iconst_0
    //   4754: ldc_w 1007
    //   4757: aastore
    //   4758: invokevirtual 1012	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	([Ljava/lang/String;)V
    //   4761: aload_2
    //   4762: ldc_w 1007
    //   4765: invokevirtual 1015	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4768: astore_2
    //   4769: aload_2
    //   4770: ifnull -3708 -> 1062
    //   4773: aload_2
    //   4774: instanceof 1017
    //   4777: ifeq -3715 -> 1062
    //   4780: aload_2
    //   4781: checkcast 1017	com/tencent/biz/webviewplugin/UrlCheckPlugin
    //   4784: aload_1
    //   4785: ldc_w 1019
    //   4788: invokevirtual 82	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4791: aload_1
    //   4792: ldc_w 1021
    //   4795: invokevirtual 82	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4798: aload_1
    //   4799: ldc_w 1023
    //   4802: invokevirtual 82	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4805: invokevirtual 1026	com/tencent/biz/webviewplugin/UrlCheckPlugin:a	(III)V
    //   4808: goto -3746 -> 1062
    //   4811: astore_1
    //   4812: aload_1
    //   4813: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   4816: goto -3754 -> 1062
    //   4819: ldc_w 1028
    //   4822: aload 4
    //   4824: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4827: ifeq -3765 -> 1062
    //   4830: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4833: ifeq +31 -> 4864
    //   4836: getstatic 36	com/tencent/mobileqq/jsp/DataApiPlugin:c	Ljava/lang/String;
    //   4839: iconst_2
    //   4840: new 96	java/lang/StringBuilder
    //   4843: dup
    //   4844: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   4847: ldc_w 1030
    //   4850: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4853: aload 5
    //   4855: invokevirtual 949	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4858: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4861: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4864: aload 5
    //   4866: ifnull -3804 -> 1062
    //   4869: aload 5
    //   4871: arraylength
    //   4872: ifle -3810 -> 1062
    //   4875: new 69	org/json/JSONObject
    //   4878: dup
    //   4879: aload 5
    //   4881: iconst_0
    //   4882: aaload
    //   4883: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4886: astore_1
    //   4887: aload_1
    //   4888: ldc_w 1032
    //   4891: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4894: astore_2
    //   4895: aload_1
    //   4896: ldc 8
    //   4898: invokevirtual 145	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4901: astore_1
    //   4902: aload_1
    //   4903: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4906: ifne -3844 -> 1062
    //   4909: aload_2
    //   4910: invokestatic 1035	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4913: astore_2
    //   4914: new 69	org/json/JSONObject
    //   4917: dup
    //   4918: invokespecial 198	org/json/JSONObject:<init>	()V
    //   4921: astore_3
    //   4922: aload_3
    //   4923: ldc_w 1037
    //   4926: aload_2
    //   4927: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4930: pop
    //   4931: aload_0
    //   4932: aload_1
    //   4933: iconst_1
    //   4934: anewarray 218	java/lang/String
    //   4937: dup
    //   4938: iconst_0
    //   4939: aload_3
    //   4940: invokevirtual 219	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4943: aastore
    //   4944: invokevirtual 222	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4947: goto -3885 -> 1062
    //   4950: astore_1
    //   4951: aload_1
    //   4952: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   4955: goto -3893 -> 1062
    //   4958: iconst_0
    //   4959: ireturn
    //   4960: astore_2
    //   4961: goto -2786 -> 2175
    //   4964: astore_1
    //   4965: goto -3822 -> 1143
    //   4968: astore 4
    //   4970: goto -3896 -> 1074
    //   4973: astore 4
    //   4975: goto -3901 -> 1074
    //   4978: iconst_1
    //   4979: istore 14
    //   4981: goto -1201 -> 3780
    //   4984: aconst_null
    //   4985: astore_1
    //   4986: goto -2565 -> 2421
    //   4989: ldc_w 741
    //   4992: astore_1
    //   4993: goto -2736 -> 2257
    //   4996: goto -2895 -> 2101
    //   4999: goto -4595 -> 404
    //   5002: aload_1
    //   5003: astore 4
    //   5005: goto -4558 -> 447
    //   5008: aload_1
    //   5009: astore_3
    //   5010: goto -4547 -> 463
    //   5013: goto -4933 -> 80
    //   5016: iconst_1
    //   5017: ireturn
    //   5018: iconst_0
    //   5019: istore 14
    //   5021: goto -1241 -> 3780
    //   5024: iconst_0
    //   5025: istore 17
    //   5027: goto -720 -> 4307
    //   5030: iconst_0
    //   5031: istore 17
    //   5033: goto -726 -> 4307
    //   5036: iconst_0
    //   5037: istore 17
    //   5039: goto -732 -> 4307
    //   5042: iconst_0
    //   5043: istore 17
    //   5045: goto -738 -> 4307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5048	0	this	DataApiPlugin
    //   0	5048	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5048	2	paramString1	String
    //   0	5048	3	paramString2	String
    //   0	5048	4	paramString3	String
    //   0	5048	5	paramVarArgs	String[]
    //   43	3646	6	localObject1	Object
    //   225	3535	7	localObject2	Object
    //   183	3427	8	str1	String
    //   216	3504	9	localObject3	Object
    //   232	2575	10	str2	String
    //   194	2615	11	str3	String
    //   87	689	12	localAppInterface	AppInterface
    //   205	481	13	str4	String
    //   161	4859	14	i	int
    //   2654	317	15	j	int
    //   2664	137	16	k	int
    //   172	4872	17	bool1	boolean
    //   2852	1652	18	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   292	335	1070	java/lang/Exception
    //   27	57	1132	org/json/JSONException
    //   62	80	1132	org/json/JSONException
    //   80	105	1132	org/json/JSONException
    //   105	129	1132	org/json/JSONException
    //   131	145	1132	org/json/JSONException
    //   145	160	1132	org/json/JSONException
    //   163	292	1132	org/json/JSONException
    //   454	460	1132	org/json/JSONException
    //   463	473	1132	org/json/JSONException
    //   483	511	1132	org/json/JSONException
    //   511	625	1132	org/json/JSONException
    //   625	767	1132	org/json/JSONException
    //   767	905	1132	org/json/JSONException
    //   905	1036	1132	org/json/JSONException
    //   1036	1062	1132	org/json/JSONException
    //   1121	1127	1132	org/json/JSONException
    //   1147	1153	1132	org/json/JSONException
    //   1153	1155	1132	org/json/JSONException
    //   292	335	1140	finally
    //   1239	1266	1311	org/json/JSONException
    //   1272	1283	1311	org/json/JSONException
    //   1283	1308	1311	org/json/JSONException
    //   1338	1364	1311	org/json/JSONException
    //   1364	1379	1311	org/json/JSONException
    //   1390	1401	1311	org/json/JSONException
    //   1404	1415	1311	org/json/JSONException
    //   1429	1519	1522	org/json/JSONException
    //   1548	1606	1717	org/json/JSONException
    //   1606	1636	1717	org/json/JSONException
    //   1641	1651	1717	org/json/JSONException
    //   1656	1671	1717	org/json/JSONException
    //   1673	1702	1717	org/json/JSONException
    //   1707	1714	1717	org/json/JSONException
    //   1725	1734	1717	org/json/JSONException
    //   1738	1754	1717	org/json/JSONException
    //   1758	1789	1717	org/json/JSONException
    //   1789	1799	1717	org/json/JSONException
    //   1804	1872	1717	org/json/JSONException
    //   1872	1893	1717	org/json/JSONException
    //   1921	1981	2032	org/json/JSONException
    //   1985	1993	2032	org/json/JSONException
    //   1997	2008	2032	org/json/JSONException
    //   2016	2029	2032	org/json/JSONException
    //   2040	2045	2032	org/json/JSONException
    //   2066	2093	2172	org/json/JSONException
    //   2200	2237	2276	java/lang/Exception
    //   2241	2246	2276	java/lang/Exception
    //   2250	2257	2276	java/lang/Exception
    //   2257	2273	2276	java/lang/Exception
    //   2332	2421	2478	java/lang/Exception
    //   2421	2449	2478	java/lang/Exception
    //   2449	2475	2478	java/lang/Exception
    //   2499	2519	2478	java/lang/Exception
    //   2540	2714	2765	org/json/JSONException
    //   2716	2728	2765	org/json/JSONException
    //   2728	2762	2765	org/json/JSONException
    //   2786	2813	2765	org/json/JSONException
    //   2816	2891	2765	org/json/JSONException
    //   2895	2901	2765	org/json/JSONException
    //   2906	2942	2765	org/json/JSONException
    //   2947	2959	2765	org/json/JSONException
    //   2959	2983	2765	org/json/JSONException
    //   2986	3002	2765	org/json/JSONException
    //   3032	3089	3115	org/json/JSONException
    //   3089	3112	3115	org/json/JSONException
    //   3155	3172	3115	org/json/JSONException
    //   3175	3191	3115	org/json/JSONException
    //   3212	3276	3279	org/json/JSONException
    //   3337	3385	3829	org/json/JSONException
    //   3389	3465	3829	org/json/JSONException
    //   3472	3479	3829	org/json/JSONException
    //   3488	3580	3829	org/json/JSONException
    //   3588	3642	3829	org/json/JSONException
    //   3642	3696	3829	org/json/JSONException
    //   3696	3777	3829	org/json/JSONException
    //   3780	3826	3829	org/json/JSONException
    //   3886	3898	3981	org/json/JSONException
    //   3900	3907	3981	org/json/JSONException
    //   3909	3917	3981	org/json/JSONException
    //   3919	3928	3981	org/json/JSONException
    //   3930	3939	3981	org/json/JSONException
    //   3941	3950	3981	org/json/JSONException
    //   3952	3969	3981	org/json/JSONException
    //   3971	3978	3981	org/json/JSONException
    //   4029	4065	4114	java/lang/Exception
    //   4069	4078	4114	java/lang/Exception
    //   4078	4111	4114	java/lang/Exception
    //   4174	4224	4332	org/json/JSONException
    //   4231	4239	4332	org/json/JSONException
    //   4243	4307	4332	org/json/JSONException
    //   4316	4329	4332	org/json/JSONException
    //   4353	4374	4332	org/json/JSONException
    //   4377	4402	4332	org/json/JSONException
    //   4408	4433	4332	org/json/JSONException
    //   4439	4469	4332	org/json/JSONException
    //   4472	4497	4332	org/json/JSONException
    //   4507	4532	4332	org/json/JSONException
    //   4556	4598	4643	java/lang/Exception
    //   4598	4640	4643	java/lang/Exception
    //   4675	4728	4811	org/json/JSONException
    //   4728	4738	4811	org/json/JSONException
    //   4742	4769	4811	org/json/JSONException
    //   4773	4808	4811	org/json/JSONException
    //   4875	4947	4950	org/json/JSONException
    //   2101	2114	4960	org/json/JSONException
    //   2118	2145	4960	org/json/JSONException
    //   341	350	4964	finally
    //   352	369	4964	finally
    //   371	379	4964	finally
    //   381	401	4964	finally
    //   409	415	4964	finally
    //   417	444	4964	finally
    //   1076	1082	4964	finally
    //   1084	1115	4964	finally
    //   341	350	4968	java/lang/Exception
    //   352	369	4968	java/lang/Exception
    //   371	379	4968	java/lang/Exception
    //   381	401	4968	java/lang/Exception
    //   409	415	4973	java/lang/Exception
    //   417	444	4973	java/lang/Exception
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebStatisticsInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface = ((WebUiUtils.WebStatisticsInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\DataApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */