package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bitapp.utils.LruCache;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.utils.Md5Utils;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import whn;
import whp;
import whq;
import whr;
import whs;
import wht;
import whu;
import whv;

public class SwiftBrowserCookieMonster
{
  private static final String A = "a2";
  private static final String B = "pt4_token";
  public static final int a = 1;
  public static final long a = 1L;
  private static final LruCache jdField_a_of_type_ComTencentBitappUtilsLruCache = new LruCache(8);
  public static volatile String a;
  public static final AtomicInteger a;
  private static volatile whv jdField_a_of_type_Whv;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final int b = 2;
  public static final long b = 2L;
  public static volatile String b;
  public static final int c = 3;
  public static final long c = 4L;
  public static volatile String c;
  public static final long d = 8L;
  public static volatile String d;
  public static final long e = 16L;
  public static volatile String e;
  public static final long f = 32L;
  public static final long g = 64L;
  public static final long h = 128L;
  private static final String m = "SwiftBrowserCookieMonster";
  private static final String n = "http://%s/";
  private static final String o = "https://%s/";
  private static final String p = "%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;";
  private static final String q = "%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure; HttpOnly;";
  private static final String r = "ptlogin2.qq.com";
  private static final String s = "file:";
  private static final String t = "superuin";
  private static final String u = "uin";
  private static final String v = "p_uin";
  private static final String w = "skey";
  private static final String x = "superkey";
  private static final String y = "supertoken";
  private static final String z = "p_skey";
  public final AuthorizeConfig a;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private final AtomicInteger b;
  public String f;
  public String g;
  public String h;
  private long i;
  public String i;
  public String j;
  public String k;
  public final String l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  }
  
  private SwiftBrowserCookieMonster(String paramString)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.l = paramString;
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    jdField_a_of_type_ComTencentBitappUtilsLruCache.put(paramString, this);
    f();
  }
  
  private SwiftBrowserCookieMonster.CookiesMap a(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramIntent = new SwiftBrowserCookieMonster.CookiesMap();
    if (!a(paramIntent, paramAppRuntime)) {
      QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
    {
      if (!b(paramIntent, paramAppRuntime)) {}
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        c(paramIntent, paramAppRuntime);
        return paramIntent;
        bool = false;
      }
    }
    a(paramIntent, paramAppRuntime);
    return paramIntent;
  }
  
  /* Error */
  public static SwiftBrowserCookieMonster a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 180	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +34 -> 46
    //   15: getstatic 113	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:jdField_a_of_type_ComTencentBitappUtilsLruCache	Lcom/tencent/bitapp/utils/LruCache;
    //   18: aload_2
    //   19: invokevirtual 190	com/tencent/bitapp/utils/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: ifnonnull +12 -> 41
    //   32: new 2	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 192	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: aconst_null
    //   47: astore_0
    //   48: goto -7 -> 41
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   25	4	1	localSwiftBrowserCookieMonster	SwiftBrowserCookieMonster
    //   7	30	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	26	51	finally
    //   32	41	51	finally
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i1 = paramString.length();
        while (i1 < 10)
        {
          ((StringBuilder)localObject).append("0");
          i1 += 1;
        }
        localObject = paramString;
      }
    }
    else {
      return (String)localObject;
    }
    return "o" + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { paramString1, paramString2, paramString3 });
    }
    return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure; HttpOnly;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private String a(String paramString, AppRuntime paramAppRuntime)
  {
    int i2 = 2;
    Object localObject = paramString;
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
      }
      if (TextUtils.isEmpty(d)) {
        break label230;
      }
      if (this.k == null) {
        break label198;
      }
      i1 = 1;
      if (this.jdField_i_of_type_JavaLangString == null) {
        break label204;
      }
      label52:
      VipUtils.a(null, "webview_report", "0X80060AC", "0X80060AC", 0, i1 | i2, new String[] { paramString });
      boolean bool = b(paramAppRuntime);
      StringBuilder localStringBuilder = new StringBuilder("http");
      if (!bool) {
        break label210;
      }
      localObject = "s";
      label101:
      localStringBuilder = localStringBuilder.append((String)localObject).append("://");
      if (!bool) {
        break label217;
      }
      localObject = "ssl.";
      label122:
      localObject = localStringBuilder.append((String)localObject).append("ptlogin2.qq.com/jump?clientuin=").append(paramAppRuntime.getAccount()).append("&clientkey=").append(d).append("&keyindex=19&pt_mq=");
      if (!paramString.startsWith("http://s.p.qq.com")) {
        break label224;
      }
    }
    label198:
    label204:
    label210:
    label217:
    label224:
    for (paramAppRuntime = "1";; paramAppRuntime = "0")
    {
      localObject = paramAppRuntime + "&u1=" + URLEncoder.encode(paramString);
      return (String)localObject;
      i1 = 0;
      break;
      i2 = 0;
      break label52;
      localObject = "";
      break label101;
      localObject = "";
      break label122;
    }
    label230:
    if (QLog.isColorLevel()) {
      QLog.w("SwiftBrowserCookieMonster", 2, "Can't do ptlogin jumping because STwxWeb is empty!");
    }
    this.jdField_i_of_type_Long |= 0x8;
    return paramString;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.format("http://%s/", new Object[] { paramString });
    }
    return String.format("https://%s/", new Object[] { paramString });
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = (TicketManager)paramAppRuntime.getManager(2);
      long l1 = System.currentTimeMillis();
      paramAppRuntime = paramAppRuntime.getAccount();
      String str = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
      wht localwht = new wht(paramString, l1);
      localObject = ((TicketManager)localObject).GetPskey(paramAppRuntime, 16L, new String[] { str }, localwht);
      paramAppRuntime = null;
      if (localObject != null) {
        paramAppRuntime = ((Ticket)localObject).getPt4Token(paramString);
      }
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(paramAppRuntime)) {
          break label180;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache success for " + paramString + ", token is: " + Util.c(new StringBuilder().append("pt4_token=").append(paramAppRuntime).toString(), new String[0]));
      }
      while (paramAppRuntime != null)
      {
        return paramAppRuntime;
        label180:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + paramString);
      }
      return "";
    }
    return "";
  }
  
  private void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCookiesMap.addCookie(a(str, true), a("skey", "", str, false));
    }
    paramCookiesMap.addCookie(a("ptlogin2.qq.com", true), a("superkey", "", "ptlogin2.qq.com", true));
    if (!TextUtils.isEmpty(this.k)) {
      paramCookiesMap.addCookie(this.l, a("p_skey", "", this.k, false));
    }
    if (!TextUtils.isEmpty(this.h)) {
      paramCookiesMap.addCookie(this.l, a("a2", "", this.h, true));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserCookieMonster", 2, Util.b(this.l, new String[0]) + " forbidden login state, remove all login key");
    }
  }
  
  private void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    Object localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis() + 10000L));
    String str = this.l;
    if (paramAppRuntime == null)
    {
      localObject = "login_key_set_failed=NullRuntime; EXPIRES=" + (String)localObject + ";";
      paramCookiesMap.addCookie(str, (String)localObject);
      a(paramCookiesMap, this.l, "aq.qq.com");
      if (paramAppRuntime != null) {
        break label163;
      }
    }
    label163:
    for (int i1 = 1;; i1 = 0)
    {
      VipUtils.a(null, "webview_report", "0X8006117", "0X8006117", i1, 0, new String[] { this.l });
      return;
      localObject = "login_key_set_failed=AlreadyLogout; EXPIRES=" + (String)localObject + ";";
      break;
    }
  }
  
  private void a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    paramCookiesMap = paramCookiesMap.entrySet().iterator();
    while (paramCookiesMap.hasNext())
    {
      Object localObject = (Map.Entry)paramCookiesMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ArrayList)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localHashMap.put(str, ((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]));
      }
    }
    if (localHashMap.size() > 0)
    {
      CookieManager.getInstance().setCookies(localHashMap);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(BaseApplicationImpl.a());
        CookieSyncManager.getInstance().sync();
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (!paramStringBuilder.toString().endsWith(";")) {
        break label33;
      }
      paramStringBuilder.append(" ");
    }
    label33:
    while (paramStringBuilder.toString().endsWith("; ")) {
      return;
    }
    paramStringBuilder.append("; ");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      a(paramStringBuilder);
      paramStringBuilder.append(paramString2).append(paramString1);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, paramString2 + "is empty");
      }
    } while (TextUtils.isEmpty(paramString3));
    a(paramStringBuilder);
    paramStringBuilder.append(paramString2).append(paramString3);
  }
  
  public static void a(AppRuntime arg0)
  {
    int i1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (3 != i1)
    {
      if (1 == i1)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = BaseApplicationImpl.a().a();
        }
        a(localAppRuntime);
      }
    }
    else {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      for (;;)
      {
        i1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        if (2 == i1) {
          try
          {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      i1 = 0;
      if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        break label170;
      }
    }
    label170:
    for (int i2 = 0;; i2 = 1)
    {
      VipUtils.a(null, "webview_report", "0X800619D", "0X800619D", 0, 0, new String[] { "" + i1, "" + i2 });
      return;
      i1 = 1;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    ThreadManager.a(new whr(paramAppRuntime, paramIntent), new whs(), false);
  }
  
  public static boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756"))
    {
      paramCookiesMap.addCookie(paramString1, a("dvid1", HexUtil.a(NetConnInfoCenter.GUID), paramString2, true));
      paramString2 = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid5", HexUtil.a(NetConnInfoCenter.GUID), paramString2, true));
      }
      paramString2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid4", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid2", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      paramString2 = DeviceInfoUtil.b(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramString2)) {
        paramCookiesMap.addCookie(paramString1, a("dvid3", HexUtil.a(NetConnInfoCenter.GUID), Md5Utils.getMD5(paramString2), true));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {}
    for (paramAppRuntime = a(paramAppRuntime.getAccount());; paramAppRuntime = "")
    {
      paramCookiesMap.addCookie(a("ptlogin2.qq.com", true), a("superuin", paramAppRuntime, "ptlogin2.qq.com", false));
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        paramCookiesMap.addCookie(a(str, true), a("uin", paramAppRuntime, str, false));
      }
      localIterator = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("pskey").iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        paramCookiesMap.addCookie(a(str, true), a("p_uin", paramAppRuntime, str, false));
      }
      if (TextUtils.isEmpty(paramAppRuntime))
      {
        this.jdField_i_of_type_Long |= 0x80;
        return false;
      }
      return true;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      paramAppRuntime = new whq(paramAppRuntime);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.a(paramAppRuntime, null, false);
      }
    }
    else
    {
      return true;
    }
    paramAppRuntime.run();
    return true;
  }
  
  private static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = Uri.parse(paramString);
        String str = ((Uri)localObject).getScheme();
        if ((("http".equals(str)) || ("https".equals(str))) && (((Uri)localObject).isHierarchical()))
        {
          localObject = a(((Uri)localObject).getHost(), "http".equals(str));
          return (String)localObject;
        }
      }
      catch (Exception localException)
      {
        QLog.e("SwiftBrowserCookieMonster", 1, "getCookieHost[" + paramString + "] error:" + localException.toString());
      }
    }
    return null;
  }
  
  private static String b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramAppRuntime = ((TicketManager)paramAppRuntime.getManager(2)).getPskey(paramAppRuntime.getAccount(), paramString);
      if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(paramAppRuntime)) {
          break label75;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "Get p_skey success for " + paramString);
      }
      while (paramAppRuntime != null)
      {
        return paramAppRuntime;
        label75:
        QLog.d("SwiftBrowserCookieMonster", 2, "Get p_skey failed for " + paramString);
      }
      return "";
    }
    return "";
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    c = "";
    d = "";
    e = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    jdField_a_of_type_ComTencentBitappUtilsLruCache.evictAll();
    jdField_a_of_type_Whv = null;
  }
  
  public static boolean b()
  {
    return (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(d)) && (!TextUtils.isEmpty(e)) && (!TextUtils.isEmpty(c));
  }
  
  private boolean b(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    String str = null;
    if ((!TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.f))) {
      this.f = b(paramAppRuntime, this.k);
    }
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (TextUtils.isEmpty(this.g))) {
      this.g = a(paramAppRuntime, this.jdField_i_of_type_JavaLangString);
    }
    paramAppRuntime = str;
    if (!TextUtils.isEmpty(this.k))
    {
      VipUtils.a(null, "webview_report", "0X80060AB", "0X80060AB", 0, 0, new String[] { this.l, this.k });
      if (!TextUtils.isEmpty(this.f))
      {
        paramAppRuntime = a("p_skey", this.f, this.k, false);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
        paramAppRuntime = str;
      }
    }
    else if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.g)) {
        break label246;
      }
      paramAppRuntime = a("pt4_token", this.g, this.jdField_i_of_type_JavaLangString, false);
      paramCookiesMap.addCookie(this.l, paramAppRuntime);
    }
    label246:
    do
    {
      return true;
      str = CookieManager.getInstance().getCookie(this.l);
      if ((!TextUtils.isEmpty(str)) && (str.contains("p_skey=")))
      {
        paramAppRuntime = str;
        if (!str.contains("p_skey=;")) {
          break;
        }
      }
      this.jdField_i_of_type_Long |= 0x20;
      return false;
      paramCookiesMap = paramAppRuntime;
      if (paramAppRuntime == null) {
        paramCookiesMap = CookieManager.getInstance().getCookie(this.l);
      }
    } while ((!TextUtils.isEmpty(paramCookiesMap)) && (paramCookiesMap.contains("pt4_token=")) && (!paramCookiesMap.contains("pt4_token=;")));
    this.jdField_i_of_type_Long |= 0x40;
    return false;
  }
  
  private static boolean b(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if (paramAppRuntime.isLogin()) {
        bool1 = localSharedPreferences.getBoolean("ptlogin_flag" + paramAppRuntime.getAccount(), false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserCookieMonster", 2, "mPtloginFlag: " + bool1);
    }
    return bool1;
  }
  
  private boolean c(SwiftBrowserCookieMonster.CookiesMap paramCookiesMap, AppRuntime paramAppRuntime)
  {
    if (!b()) {
      a(paramAppRuntime);
    }
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      try
      {
        paramAppRuntime = MessageDigest.getInstance("MD5");
        paramAppRuntime.update(jdField_b_of_type_JavaLangString.getBytes());
        paramAppRuntime = paramAppRuntime.digest();
        int i1 = paramAppRuntime.length;
        long l1 = paramAppRuntime[(i1 - 4)] & 0xFF;
        long l2 = (paramAppRuntime[(i1 - 3)] & 0xFF) << 16;
        long l3 = (paramAppRuntime[(i1 - 2)] & 0xFF) << 8;
        c = Long.toString(paramAppRuntime[(i1 - 1)] & 0xFF | l1 << 24 | l2 | l3);
      }
      catch (NoSuchAlgorithmException paramAppRuntime)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SwiftBrowserCookieMonster", 2, "Super key hash failed:" + paramAppRuntime.getMessage());
          }
          this.jdField_i_of_type_Long |= 0x4;
        }
      }
      paramAppRuntime = a("ptlogin2.qq.com", true);
      paramCookiesMap.addCookie(paramAppRuntime, a("superkey", jdField_b_of_type_JavaLangString, "ptlogin2.qq.com", true));
      paramCookiesMap.addCookie(paramAppRuntime, a("supertoken", c, "ptlogin2.qq.com", false));
      if (!TextUtils.isEmpty(this.h))
      {
        if (TextUtils.isEmpty(e)) {
          break label344;
        }
        paramAppRuntime = a("a2", e, this.h, true);
        paramCookiesMap.addCookie(this.l, paramAppRuntime);
      }
    }
    for (;;)
    {
      a(paramCookiesMap, this.l, this.h);
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        break label359;
      }
      paramAppRuntime = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("skey").iterator();
      while (paramAppRuntime.hasNext())
      {
        String str = (String)paramAppRuntime.next();
        paramCookiesMap.addCookie(a(str, true), a("skey", jdField_a_of_type_JavaLangString, str, false));
      }
      this.jdField_i_of_type_Long |= 0x2;
      break;
      label344:
      this.jdField_i_of_type_Long |= 0x10;
    }
    label359:
    this.jdField_i_of_type_Long |= 1L;
    return true;
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_i_of_type_Long = 0L;
  }
  
  private void e()
  {
    if (this.l.startsWith("file:"))
    {
      this.j = "qq.com";
      this.jdField_i_of_type_JavaLangString = "";
      this.h = "";
      this.k = "";
    }
    do
    {
      return;
      this.j = Util.c(this.l);
      this.h = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.f(this.l);
      this.k = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserCookieMonster", 2, "CookieMonsterTask:topLevelDomain=" + this.j + ",pSkeyDomain=" + this.k + ",Pt4TokenDomain=" + this.jdField_i_of_type_JavaLangString + ",a2Domain=" + this.h);
  }
  
  private static void f()
  {
    if (jdField_a_of_type_Whv == null) {
      ThreadManager.a(new whu(), null, false);
    }
  }
  
  private static void g()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement.length > 2) {
      QLog.d("SwiftBrowserCookieMonster", 4, arrayOfStackTraceElement[1] + " at " + arrayOfStackTraceElement[2].toString());
    }
  }
  
  private void h() {}
  
  public String a()
  {
    if (TextUtils.isEmpty(this.l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "srcUrl is empty");
      }
      return "";
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime == null) || (!localAppRuntime.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "runtime is error");
      }
      return "";
    }
    String str1 = "";
    try
    {
      if (CookieSyncManager.createInstance(localAppRuntime.getApplication().getApplicationContext()) != null) {
        str1 = CookieManager.getInstance().getCookie(this.l);
      }
      localObject3 = new StringBuilder();
      localTicketManager = (TicketManager)localAppRuntime.getManager(2);
      str2 = localAppRuntime.getAccount();
      str3 = a(str2);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserCookieMonster", 2, "Get cookie:" + Util.c(str1, new String[0]) + " from " + Util.b(this.l, new String[0]));
      }
      if (!TextUtils.isEmpty(str1))
      {
        ((StringBuilder)localObject3).append(str1);
        a((StringBuilder)localObject3);
        ((StringBuilder)localObject3).append("uin=").append(str3);
        if ((!TextUtils.isEmpty(str1)) && (str1.contains("skey="))) {
          break label520;
        }
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          break label513;
        }
        localObject2 = localTicketManager.getSkey(str2);
        jdField_a_of_type_JavaLangString = (String)localObject2;
        a((StringBuilder)localObject3, jdField_a_of_type_JavaLangString, "skey=", "");
        i1 = 0;
        if ((TextUtils.isEmpty(str1)) || (!str1.contains("p_skey=;"))) {
          break label567;
        }
        if (!QLog.isColorLevel()) {
          break label1093;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pskey");
        i2 = 0;
        if ((TextUtils.isEmpty(str1)) || (!str1.contains("pt4_token=;"))) {
          break label744;
        }
        if (!QLog.isColorLevel()) {
          break label1087;
        }
        QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
        i3 = 0;
        if ((i1 == 0) && (i2 == 0) && (i3 == 0)) {
          break label1082;
        }
        str1 = ((StringBuilder)localObject3).toString().replaceAll(" ", "");
        localObject2 = new StringBuilder();
        if (!str1.contains(";")) {
          break label1075;
        }
        localObject3 = str1.split(";");
        int i5 = localObject3.length;
        int i4 = 0;
        for (;;)
        {
          if (i4 >= i5) {
            break label1075;
          }
          str3 = localObject3[i4];
          if (!TextUtils.isEmpty(str3))
          {
            if (((StringBuilder)localObject2).length() != 0) {
              break;
            }
            ((StringBuilder)localObject2).append(str3);
          }
          i4 += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        TicketManager localTicketManager;
        String str2;
        String str3;
        Object localObject2;
        int i1;
        int i2;
        int i3;
        if (QLog.isColorLevel()) {
          QLog.w("SwiftBrowserCookieMonster", 2, "get cookie encounter exception!");
        }
        Object localObject1 = "";
        continue;
        if (SwiftWebViewHttpBridgeUtils.a(this.l))
        {
          VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "noCookie", 0, 0, 0, 2, this.l, "");
          continue;
          label513:
          localObject2 = jdField_a_of_type_JavaLangString;
          continue;
          label520:
          if (((String)localObject1).contains("skey=;"))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
              i1 = 0;
            }
          }
          else if (((String)localObject1).contains("skey="))
          {
            i1 = 1;
            continue;
            label567:
            localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("p_skey=")))
              {
                if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_uin=;")))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
                  }
                  label635:
                  if (!TextUtils.isEmpty(this.f)) {
                    break label720;
                  }
                }
                label720:
                for (localObject2 = localTicketManager.getPskey(str2, (String)localObject2);; localObject2 = this.f)
                {
                  this.f = ((String)localObject2);
                  a((StringBuilder)localObject3, this.f, "p_skey=", "");
                  i2 = 0;
                  break;
                  if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("p_uin="))) {
                    break label635;
                  }
                  a((StringBuilder)localObject3);
                  ((StringBuilder)localObject3).append("p_uin=").append(str3);
                  break label635;
                }
              }
              if (((String)localObject1).contains("p_skey="))
              {
                i2 = 1;
                continue;
                label744:
                localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l);
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("pt4_token=")))
                  {
                    if (TextUtils.isEmpty(this.g)) {}
                    for (localObject1 = a(localAppRuntime, (String)localObject2);; localObject1 = this.g)
                    {
                      this.g = ((String)localObject1);
                      a((StringBuilder)localObject3, this.g, "pt4_token=", "");
                      i3 = 0;
                      break;
                    }
                  }
                  if (((String)localObject1).contains("pt4_token="))
                  {
                    i3 = 1;
                    continue;
                    a((StringBuilder)localObject2);
                    if ((str3.startsWith("p_skey=")) && (i2 != 0))
                    {
                      if (TextUtils.isEmpty(this.f)) {}
                      for (localObject1 = localTicketManager.getPskey(str2, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(this.l));; localObject1 = this.f)
                      {
                        this.f = ((String)localObject1);
                        a((StringBuilder)localObject2, this.f, "p_skey=", str3);
                        break;
                      }
                    }
                    if ((str3.startsWith("skey=")) && (i1 != 0))
                    {
                      if (TextUtils.isEmpty(this.f)) {}
                      for (localObject1 = localTicketManager.getSkey(str2);; localObject1 = jdField_a_of_type_JavaLangString)
                      {
                        jdField_a_of_type_JavaLangString = (String)localObject1;
                        a((StringBuilder)localObject2, jdField_a_of_type_JavaLangString, "skey=", str3);
                        break;
                      }
                    }
                    if ((str3.startsWith("pt4_token=")) && (i3 != 0))
                    {
                      if (TextUtils.isEmpty(this.g)) {}
                      for (localObject1 = a(localAppRuntime, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(this.l));; localObject1 = this.g)
                      {
                        this.g = ((String)localObject1);
                        a((StringBuilder)localObject2, this.g, "pt4_token=", str3);
                        break;
                      }
                    }
                    ((StringBuilder)localObject2).append(str3);
                    continue;
                    label1075:
                    label1082:
                    for (localObject1 = localObject2;; localObject1 = localObject3) {
                      return ((StringBuilder)localObject1).toString();
                    }
                  }
                }
                label1087:
                i3 = 0;
                continue;
              }
            }
            label1093:
            i2 = 0;
            continue;
          }
          i1 = 0;
        }
      }
    }
  }
  
  public void a()
  {
    d();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_ComTencentBitappUtilsLruCache.remove(this.l);
  }
  
  public void a(SwiftBrowserCookieMonster.SetCookiesCallback paramSetCookiesCallback)
  {
    if (paramSetCookiesCallback != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (((CopyOnWriteArrayList)localObject).contains(paramSetCookiesCallback)) {
          ((CopyOnWriteArrayList)localObject).remove(paramSetCookiesCallback);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  public boolean a(String paramString, SwiftBrowserCookieMonster.SetCookiesCallback paramSetCookiesCallback, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (paramAppRuntime == null)
    {
      localObject1 = BaseApplicationImpl.a().a();
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) {
        break label316;
      }
      localObject2 = a(paramString, (AppRuntime)localObject1);
      if (paramSetCookiesCallback == null) {
        break label316;
      }
      if (this.jdField_i_of_type_Long > 0L)
      {
        h();
        QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.jdField_i_of_type_Long);
      }
      localObject1 = CookieManager.getInstance().getCookie(paramString);
      if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("skey="))) || (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString))) {
        break label172;
      }
      QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, retry set cookie: " + (String)localObject1 + "");
      d();
      a(paramString, paramSetCookiesCallback, paramAppRuntime, paramIntent);
    }
    label172:
    label316:
    do
    {
      return true;
      localObject1 = paramAppRuntime;
      break;
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_i_of_type_Long > 0L))
      {
        if (this.jdField_a_of_type_Boolean) {
          QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + Util.b((String)localObject2, new String[0]));
        }
        paramSetCookiesCallback.a((String)localObject2, null, this.jdField_i_of_type_Long);
        a();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "hit cookie cache, just call onSetCookiesFinished " + Util.b((String)localObject2, new String[0]) + ", errorCode: " + this.jdField_i_of_type_Long);
      }
      paramSetCookiesCallback.a((String)localObject2, null, this.jdField_i_of_type_Long);
      return true;
      if (paramSetCookiesCallback != null)
      {
        localObject2 = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        paramAppRuntime = (AppRuntime)localObject2;
        if (localObject2 == null)
        {
          paramAppRuntime = new CopyOnWriteArrayList();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramAppRuntime);
        }
        if (!paramAppRuntime.contains(paramSetCookiesCallback)) {
          paramAppRuntime.add(paramSetCookiesCallback);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, "now add callback for " + Util.b(paramString, new String[0]));
        }
      }
      Util.a("Web_qqbrowser_check_and_set_cookies");
      paramString = new whn(this, paramIntent, (AppRuntime)localObject1);
    } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2));
    CookieSyncManager.createInstance(BaseApplicationImpl.a().getApplicationContext());
    CookieManager.getInstance().setAcceptCookie(true);
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "post thread to set all cookies");
    }
    ThreadManager.a(paramString, new whp(this), false);
    return true;
  }
  
  public void b(AppRuntime arg1)
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (3 != i1)
    {
      if (1 == i1)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        a(this.l, null, localAppRuntime, null);
      }
    }
    else {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      for (;;)
      {
        i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        if (2 == i1) {
          try
          {
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
  
  @Deprecated
  public void c()
  {
    e();
    SwiftBrowserCookieMonster.CookiesMap localCookiesMap = new SwiftBrowserCookieMonster.CookiesMap();
    a(localCookiesMap, null);
    a(localCookiesMap);
    a(localCookiesMap, true);
    jdField_a_of_type_ComTencentBitappUtilsLruCache.evictAll();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserCookieMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */