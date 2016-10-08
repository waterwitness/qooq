package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import heb;
import hec;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  public static final int a = -1;
  protected static final long a = 1800000L;
  protected static final ArrayMap a;
  protected static AuthorizeConfig a;
  static final String jdField_a_of_type_JavaLangString = "AuthorizeConfig";
  static final boolean jdField_a_of_type_Boolean = false;
  protected static final String[] a;
  public static final int b = 0;
  public static volatile long b = 0L;
  protected static final String b = "http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json";
  public static final int c = 1;
  protected static final String c = "domainCmdRight";
  public static final int d = 2;
  protected static final String d = "cmdConfig";
  protected static final String e = "sid";
  protected static final String f = "lastUpdate";
  protected static final String g = "extra";
  protected static final String h = "jump";
  protected static final String i = "schemes";
  protected static final String j = "offlineHtml";
  public static final String k = "skey";
  public static final String l = "pskey";
  public static final String m = "a1";
  public static final String n = "a2";
  public static final String o = "ptlogin2";
  public static final String p = "pt4_token";
  protected static final String q = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}";
  protected static final String r = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}";
  protected static final String s = "{\"host\": [\"*.qq.com\"]}";
  static final String t = "lastMod";
  static final String u = "qqVersion";
  static final String v = "lastVersion";
  public Context a;
  public SharedPreferences a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  protected volatile JSONArray a;
  public volatile JSONObject a;
  public final ConcurrentHashMap b;
  public volatile JSONArray b;
  public volatile JSONObject b;
  protected volatile JSONArray c;
  public volatile JSONObject c;
  public volatile JSONObject d;
  public volatile JSONObject e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pskey", "[\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a1", "");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    jdField_b_of_type_Long = -1L;
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
  }
  
  public static AuthorizeConfig a()
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      if (!jdField_a_of_type_ComTencentBizAuthorizeConfig.a(true)) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
      }
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  public static AuthorizeConfig a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(paramContext);
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a(true);
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  public static AuthorizeConfig a(boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramBoolean);
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2, Set paramSet)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2)))
      {
        localObject1 = "";
        return (String)localObject1;
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1)) {
            paramSet = (Set)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSet;
      if (!QLog.isColorLevel()) {
        break;
      }
      if (!TextUtils.isEmpty(paramSet))
      {
        QLog.d("AuthorizeConfig", 2, paramSet + " need " + paramString1 + " which extract from " + paramString2);
        return paramSet;
        localObject2 = paramSet.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramSet = (String)((Iterator)localObject2).next();
        } while (!((String)localObject1).endsWith("." + paramSet));
      }
      else
      {
        QLog.d("AuthorizeConfig", 2, paramString2 + " not need " + paramString1);
        return paramSet;
        paramSet = "";
      }
    }
  }
  
  private JSONArray a(String paramString)
  {
    int i2 = 0;
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new JSONArray();
    }
    Object localObject3;
    do
    {
      return (JSONArray)localObject1;
      localObject3 = (JSONArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject3;
    } while (localObject3 != null);
    label459:
    label462:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (JSONArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
          if (localObject3 == null) {
            break label459;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.w("AuthorizeConfig", 2, "Decode " + paramString + " Config error");
        break label462;
        if (!QLog.isColorLevel()) {
          break;
        }
        Object localObject4;
        QLog.e("AuthorizeConfig", 2, "Decode builtin " + paramString + " config failed " + ((JSONException)localObject4).getMessage());
        break;
        boolean bool = "pskey".equals(paramString);
        if (bool)
        {
          for (;;)
          {
            try
            {
              localJSONArray = new JSONArray((String)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get("pskey"));
            }
            catch (JSONException localJSONException6)
            {
              int i1;
              Object localObject2;
              JSONArray localJSONArray = null;
              continue;
            }
            try
            {
              i1 = localJSONArray.length();
              if (i2 >= i1) {
                continue;
              }
              ((JSONArray)localObject1).put(localJSONArray.optString(i2));
              i2 += 1;
              continue;
            }
            catch (JSONException localJSONException3)
            {
              continue;
            }
            ((JSONException)localObject4).printStackTrace();
            i1 = 0;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "p_skey need merge server and local config");
          }
        }
        continue;
      }
    }
  }
  
  private JSONObject a()
  {
    Object localObject3 = this.jdField_b_of_type_OrgJsonJSONObject;
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return (JSONObject)localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  private JSONObject b()
  {
    Object localObject3 = this.c;
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.c = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return (JSONObject)localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) {
          break label101;
        }
        bool1 = "com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getProcessName());
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        long l1 = System.currentTimeMillis() - jdField_b_of_type_Long;
        if (l1 < 0L) {
          break label107;
        }
        if (l1 >= 1800000L)
        {
          break label107;
          return bool1;
        }
      }
      int i1 = 0;
      break label109;
      label101:
      boolean bool1 = false;
      continue;
      label107:
      i1 = 1;
      label109:
      if (!bool1)
      {
        bool1 = bool2;
        if (i1 == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return 0;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        int i1 = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return b().optInt(paramString, paramInt);
  }
  
  public Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(b().optBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 200	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 204	android/net/Uri:getScheme	()Ljava/lang/String;
    //   18: astore_3
    //   19: ldc_w 423
    //   22: aload_3
    //   23: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +8 -> 34
    //   29: iconst_1
    //   30: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   33: areturn
    //   34: ldc -50
    //   36: aload_3
    //   37: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne +17 -> 57
    //   43: ldc -44
    //   45: aload_3
    //   46: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifne +8 -> 57
    //   52: iconst_0
    //   53: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: areturn
    //   57: aload_1
    //   58: invokevirtual 218	android/net/Uri:getHost	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload_1
    //   63: astore_3
    //   64: aload_1
    //   65: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +8 -> 76
    //   71: aload_1
    //   72: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 425	com/tencent/biz/AuthorizeConfig:d	Lorg/json/JSONObject;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnonnull +251 -> 333
    //   85: aload_0
    //   86: getfield 167	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   89: ldc 43
    //   91: aconst_null
    //   92: invokeinterface 277 3 0
    //   97: astore 4
    //   99: aload 4
    //   101: ifnull +102 -> 203
    //   104: new 328	org/json/JSONObject
    //   107: dup
    //   108: aload 4
    //   110: invokespecial 329	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   113: astore 4
    //   115: aload 4
    //   117: astore_1
    //   118: aload_1
    //   119: ifnonnull +211 -> 330
    //   122: new 328	org/json/JSONObject
    //   125: dup
    //   126: ldc 76
    //   128: invokespecial 329	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   131: astore 4
    //   133: aload 4
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: putfield 425	com/tencent/biz/AuthorizeConfig:d	Lorg/json/JSONObject;
    //   141: aload_1
    //   142: ldc_w 427
    //   145: invokevirtual 430	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   148: astore 4
    //   150: aload 4
    //   152: invokevirtual 311	org/json/JSONArray:length	()I
    //   155: istore 6
    //   157: iconst_0
    //   158: istore 5
    //   160: iload 5
    //   162: iload 6
    //   164: if_icmpge +57 -> 221
    //   167: aload 4
    //   169: iload 5
    //   171: invokevirtual 315	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   174: aload_3
    //   175: invokestatic 432	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   178: ifeq +33 -> 211
    //   181: iconst_1
    //   182: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   185: areturn
    //   186: astore 4
    //   188: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +12 -> 203
    //   194: ldc 15
    //   196: iconst_2
    //   197: ldc_w 434
    //   200: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: goto -85 -> 118
    //   206: astore 4
    //   208: goto -72 -> 136
    //   211: iload 5
    //   213: iconst_1
    //   214: iadd
    //   215: istore 5
    //   217: goto -57 -> 160
    //   220: astore_3
    //   221: aload_1
    //   222: ldc_w 436
    //   225: invokevirtual 430	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   228: astore_3
    //   229: aload_3
    //   230: invokevirtual 311	org/json/JSONArray:length	()I
    //   233: istore 6
    //   235: iconst_0
    //   236: istore 5
    //   238: iload 5
    //   240: iload 6
    //   242: if_icmpge +31 -> 273
    //   245: aload_3
    //   246: iload 5
    //   248: invokevirtual 315	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   251: aload_2
    //   252: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: ifeq +8 -> 263
    //   258: iconst_1
    //   259: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   262: areturn
    //   263: iload 5
    //   265: iconst_1
    //   266: iadd
    //   267: istore 5
    //   269: goto -31 -> 238
    //   272: astore_3
    //   273: aload_1
    //   274: ldc_w 438
    //   277: invokevirtual 430	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 311	org/json/JSONArray:length	()I
    //   285: istore 6
    //   287: iconst_0
    //   288: istore 5
    //   290: iload 5
    //   292: iload 6
    //   294: if_icmpge +31 -> 325
    //   297: aload_1
    //   298: iload 5
    //   300: invokevirtual 315	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   303: aload_2
    //   304: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq +8 -> 315
    //   310: iconst_1
    //   311: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   314: areturn
    //   315: iload 5
    //   317: iconst_1
    //   318: iadd
    //   319: istore 5
    //   321: goto -31 -> 290
    //   324: astore_1
    //   325: iconst_0
    //   326: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   329: areturn
    //   330: goto -194 -> 136
    //   333: goto -192 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	AuthorizeConfig
    //   0	336	1	paramString1	String
    //   0	336	2	paramString2	String
    //   18	157	3	str	String
    //   220	1	3	localJSONException1	JSONException
    //   228	18	3	localJSONArray	JSONArray
    //   272	1	3	localJSONException2	JSONException
    //   97	71	4	localObject	Object
    //   186	1	4	localJSONException3	JSONException
    //   206	1	4	localJSONException4	JSONException
    //   158	162	5	i1	int
    //   155	140	6	i2	int
    // Exception table:
    //   from	to	target	type
    //   104	115	186	org/json/JSONException
    //   122	133	206	org/json/JSONException
    //   141	157	220	org/json/JSONException
    //   167	181	220	org/json/JSONException
    //   221	235	272	org/json/JSONException
    //   245	258	272	org/json/JSONException
    //   273	287	324	org/json/JSONException
    //   297	310	324	org/json/JSONException
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  public Set a(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new HashSet();
    }
    Object localObject2;
    do
    {
      return (Set)localObject1;
      localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    for (;;)
    {
      int i1;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label213;
        }
        localObject2 = new HashSet(32);
        localObject1 = a(paramString);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          int i2 = ((JSONArray)localObject1).length();
          i1 = 0;
          if (i1 < i2) {
            if ("skey".equals(paramString)) {
              ((Set)localObject2).add(b(((JSONArray)localObject1).optString(i1, ""), "*."));
            } else {
              ((Set)localObject2).add(((JSONArray)localObject1).optString(i1, ""));
            }
          }
        }
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AuthorizeConfig", 2, paramString + " domain white list: " + localObject2);
        localObject1 = localObject2;
      }
      label213:
      return (Set)localObject1;
      i1 += 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.b(new heb(this));
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    String str1 = "";
    localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    try
    {
      localObject1 = new JSONObject();
      localObject2 = paramJSONObject.getJSONArray("allow");
      i4 = ((JSONArray)localObject2).length();
      i1 = 0;
    }
    catch (Exception localJSONException4)
    {
      for (;;)
      {
        int i1;
        int i2;
        String str2;
        try
        {
          int i5;
          String str3;
          JSONArray localJSONArray2;
          int i6;
          localObject1 = paramJSONObject.getJSONArray("sid");
          this.jdField_b_of_type_OrgJsonJSONArray = ((JSONArray)localObject1);
          localEditor.putString("sid", ((JSONArray)localObject1).toString());
        }
        catch (JSONException localJSONException4)
        {
          try
          {
            localObject1 = paramJSONObject.getJSONObject("offline");
            this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
            localEditor.putString("offlineHtml", ((JSONObject)localObject1).toString());
          }
          catch (JSONException localJSONException4)
          {
            try
            {
              localObject1 = paramJSONObject.getJSONObject("ext");
              this.c = ((JSONObject)localObject1);
              localEditor.putString("extra", ((JSONObject)localObject1).toString());
            }
            catch (JSONException localJSONException4)
            {
              try
              {
                localObject1 = paramJSONObject.getJSONObject("jump");
                this.d = ((JSONObject)localObject1);
                localEditor.putString("jump", ((JSONObject)localObject1).toString());
              }
              catch (JSONException localJSONException4)
              {
                try
                {
                  int i4;
                  Object localObject3;
                  Object localObject1 = new JSONObject();
                  localObject2 = paramJSONObject.getJSONArray("schemes");
                  int i3 = ((JSONArray)localObject2).length();
                  i1 = 0;
                  if (i1 < i3)
                  {
                    localObject3 = ((JSONArray)localObject2).getJSONObject(i1);
                    localJSONArray1 = ((JSONObject)localObject3).getJSONArray("scheme");
                    localObject3 = ((JSONObject)localObject3).getJSONArray("match");
                    i2 = 0;
                    i4 = ((JSONArray)localObject3).length();
                    if (i2 < i4)
                    {
                      ((JSONObject)localObject1).put(((JSONArray)localObject3).getString(i2), localJSONArray1);
                      i2 += 1;
                      continue;
                      localException1 = localException1;
                      str2 = "" + localException1.getMessage();
                      continue;
                      localJSONException1 = localJSONException1;
                      str2 = str2 + "|" + localJSONException1.getMessage();
                      continue;
                      localJSONException2 = localJSONException2;
                      str2 = str2 + "|" + localJSONException2.getMessage();
                      continue;
                      localJSONException3 = localJSONException3;
                      str2 = str2 + "|" + localJSONException3.getMessage();
                      continue;
                      localJSONException4 = localJSONException4;
                      str2 = str2 + "|" + localJSONException4.getMessage();
                      continue;
                    }
                    i1 += 1;
                    continue;
                  }
                  this.e = localJSONException4;
                  localEditor.putString("schemes", localJSONException4.toString());
                }
                catch (Exception localException2)
                {
                  try
                  {
                    Object localObject2;
                    String[] arrayOfString;
                    JSONArray localJSONArray1 = paramJSONObject.getJSONArray((String)localObject2);
                    localEditor.putString((String)localObject2, localJSONArray1.toString());
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("AuthorizeConfig", 2, "Server " + (String)localObject2 + " config= " + localJSONArray1);
                    i1 += 1;
                    continue;
                    localException2 = localException2;
                    str2 = str2 + "|" + localException2.getMessage();
                  }
                  catch (JSONException localJSONException5)
                  {
                    str2 = str2 + "|" + localJSONException5.getMessage();
                    continue;
                  }
                }
                arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
                i2 = arrayOfString.length;
                i1 = 0;
                if (i1 < i2) {
                  localObject2 = arrayOfString[i1];
                }
                if (!TextUtils.isEmpty(str2)) {
                  break label933;
                }
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        localEditor.putLong("lastUpdate", System.currentTimeMillis());
        localEditor.putString("qqVersion", "2013 6.5.5");
        localEditor.putString(paramString2, paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "White list update completed as version=" + paramString1);
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
        for (;;)
        {
          localEditor.commit();
          b();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          return;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("AuthorizeConfig", 2, "Authorize config parse failed include: " + str2);
          }
        }
        i2 += 1;
        continue;
        i1 += 1;
      }
    }
    if (i1 < i4)
    {
      localObject3 = ((JSONArray)localObject2).getJSONObject(i1);
      localJSONArray1 = ((JSONObject)localObject3).getJSONArray("api");
      localObject3 = ((JSONObject)localObject3).getJSONArray("match");
      i5 = ((JSONArray)localObject3).length();
      i2 = 0;
      if (i2 >= i5) {
        break label1015;
      }
      str3 = ((JSONArray)localObject3).getString(i2);
      localJSONArray2 = ((JSONObject)localObject1).optJSONArray(str3);
      if (localJSONArray2 != null)
      {
        i3 = 0;
        i6 = localJSONArray1.length();
        while (i3 < i6)
        {
          localJSONArray2.put(localJSONArray1.get(i3));
          i3 += 1;
        }
      }
      ((JSONObject)localObject1).put(str3, localJSONArray1);
    }
    else
    {
      this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
      localEditor.putString("cmdConfig", ((JSONObject)localObject1).toString());
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_cgi_whitelist", 4).getString("whitelist_config_json", null);
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "CgiConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    localObject = a("skey");
    int i2 = ((JSONArray)localObject).length();
    int i1 = 0;
    while (i1 < i2)
    {
      if (b(((JSONArray)localObject).optString(i1), paramString)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    Object localObject3 = Uri.parse(paramString1);
    Object localObject1 = ((Uri)localObject3).getScheme();
    if ("file".equals(localObject1)) {
      return true;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return paramString1.startsWith("http://qqweb.qq.com/m/whitelist/testing/");
    }
    localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    paramString1 = (String)localObject1;
    if (localObject1 == null)
    {
      paramString1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmdConfig", null);
      if (paramString1 == null) {
        break label155;
      }
    }
    JSONArray localJSONArray;
    label155:
    label188:
    label232:
    label287:
    label299:
    label323:
    label325:
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1 != null) {
          break label325;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
      }
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
        paramString1 = (String)localObject1;
      }
      catch (JSONException localJSONException)
      {
        continue;
        localObject3 = ((Uri)localObject3).getHost();
        Object localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label188;
        }
        localObject2 = ((String)localObject3).toLowerCase();
        int i3 = localJSONArray.length();
        int i1 = 0;
        if (i1 >= i3) {
          break label287;
        }
        localObject3 = localJSONArray.optString(i1);
        if (b((String)localObject3, (String)localObject2)) {
          break label232;
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject3 = paramString1.optJSONArray((String)localObject3);
          if (localObject3 != null)
          {
            int i4 = ((JSONArray)localObject3).length();
            int i2 = 0;
            while (i2 < i4)
            {
              if (b(((JSONArray)localObject3).optString(i2), paramString2)) {
                return true;
              }
              i2 += 1;
            }
          }
        }
        if (!"publicAccountNew.config".equals(paramString2)) {
          break label299;
        }
        return true;
        if (!PublicAccountH5AbilityPlugin.b) {
          break label323;
        }
        return (!TextUtils.isEmpty(paramString2)) && (PublicAccountH5AbilityPlugin.a(paramString2));
        return false;
      }
      this.jdField_a_of_type_OrgJsonJSONObject = paramString1;
      localJSONArray = paramString1.names();
      if (localJSONArray == null)
      {
        return false;
        paramString1 = (String)localObject1;
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.d(new hec(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  public void b()
  {
    boolean bool2 = false;
    Object localObject1 = BaseApplicationImpl.a().a();
    if (!(localObject1 instanceof QQAppInterface)) {}
    while ((!((AppRuntime)localObject1).isLogin()) && (!"com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getProcessName()))) {
      return;
    }
    if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject1).getManager(2);
      Object localObject2 = a("pt4_token");
      String[] arrayOfString = new String[((Set)localObject2).size()];
      localObject2 = ((Set)localObject2).iterator();
      int i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        arrayOfString[i1] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject2).next() });
        i1 += 1;
      }
      localObject1 = ((AppRuntime)localObject1).getAccount();
      boolean bool1 = bool2;
      if (localTicketManager.GetPskey((String)localObject1, 16L, arrayOfString, null) != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localTicketManager.getSkey((String)localObject1))) {
          bool1 = true;
        }
      }
      QLog.d("AuthorizeConfig", 1, "pre hits result : " + bool1);
      return;
    }
    QLog.d("AuthorizeConfig", 1, "do not support preload.");
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_a_of_type_OrgJsonJSONArray == null) && (!a()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "CgiConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            if ((this.jdField_a_of_type_OrgJsonJSONArray.length() != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              int i2 = this.jdField_a_of_type_OrgJsonJSONArray.length();
              i1 = 0;
              if (i1 < i2)
              {
                String str2 = this.jdField_a_of_type_OrgJsonJSONArray.optString(i1, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label242;
                }
                if (!QLog.isColorLevel()) {
                  break label240;
                }
                QLog.d("AuthorizeConfig", 2, "CgiConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label240;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "CgiConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label240:
      return true;
      label242:
      i1 += 1;
    }
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
    return null;
  }
  
  public boolean c(String paramString)
  {
    return false;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (!"about:blank".equalsIgnoreCase(paramString1)) {}
    }
    else
    {
      localObject1 = "http://localhost/";
    }
    Object localObject3 = Uri.parse((String)localObject1);
    paramString1 = ((Uri)localObject3).getScheme();
    if ("file".equals(paramString1)) {
      return true;
    }
    if ((!"http".equals(paramString1)) && (!"https".equals(paramString1))) {
      return false;
    }
    Object localObject1 = this.e;
    paramString1 = (String)localObject1;
    if (localObject1 == null)
    {
      paramString1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("schemes", null);
      if (paramString1 == null) {
        break label151;
      }
    }
    JSONArray localJSONArray;
    label151:
    label184:
    label228:
    label283:
    label285:
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1 != null) {
          break label285;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
      }
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
        paramString1 = (String)localObject1;
      }
      catch (JSONException localJSONException)
      {
        continue;
        localObject3 = ((Uri)localObject3).getHost();
        Object localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label184;
        }
        localObject2 = ((String)localObject3).toLowerCase();
        int i3 = localJSONArray.length();
        int i1 = 0;
        if (i1 >= i3) {
          break label283;
        }
        localObject3 = localJSONArray.optString(i1);
        if (b((String)localObject3, (String)localObject2)) {
          break label228;
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject3 = paramString1.optJSONArray((String)localObject3);
          if (localObject3 != null)
          {
            int i4 = ((JSONArray)localObject3).length();
            int i2 = 0;
            while (i2 < i4)
            {
              if (b(((JSONArray)localObject3).optString(i2), paramString2)) {
                return true;
              }
              i2 += 1;
            }
          }
        }
        return false;
      }
      this.e = paramString1;
      localJSONArray = paramString1.names();
      if (localJSONArray == null)
      {
        return false;
        paramString1 = (String)localObject1;
      }
    }
  }
  
  public String d(String paramString)
  {
    return a("p_skey", paramString, a("pskey"));
  }
  
  public boolean d(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = a("a1");
    paramString = Uri.parse(paramString).getHost();
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    }
    for (;;)
    {
      if (((Set)localObject).contains(paramString)) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (b((String)((Iterator)localObject).next(), paramString)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public String e(String paramString)
  {
    return a("pt4_token", paramString, a("pt4_token"));
  }
  
  public String f(String paramString)
  {
    return a("a2", paramString, a("a2"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\AuthorizeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */