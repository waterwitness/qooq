package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import jhc;
import jhd;
import jhe;
import jhf;
import jhg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class KeyInfo
{
  public static final int a = 1;
  private static KeyInfo jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "KeyInfo";
  public static final int b = 2;
  public static final int c = 3;
  public long a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final AtomicInteger a;
  protected volatile boolean a;
  public long b;
  public volatile String b;
  public final AtomicInteger b;
  protected volatile boolean b;
  public volatile String c = "";
  public volatile String d = "";
  protected volatile String e = "";
  protected volatile String f = "";
  protected volatile String g = "";
  protected volatile String h = "";
  protected volatile String i = "";
  protected volatile String j = "";
  protected volatile String k;
  protected volatile String l;
  protected volatile String m;
  protected volatile String n;
  protected volatile String o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private KeyInfo()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  }
  
  public static KeyInfo a()
  {
    if (jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo == null) {
        jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo = new KeyInfo();
      }
      return jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo;
    }
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      paramAppRuntime = "";
      return paramAppRuntime;
    }
    String str = ((TicketManager)paramAppRuntime.getManager(2)).getPskey(paramAppRuntime.getAccount(), paramString);
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(str)) {
        break label82;
      }
      QLog.d("KeyInfo", 2, "Get p_skey success for " + paramString);
    }
    for (;;)
    {
      paramAppRuntime = str;
      if (str != null) {
        break;
      }
      return "";
      label82:
      QLog.d("KeyInfo", 2, "Get p_skey failed for " + paramString);
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "get key info finish, now notify all with(" + paramInt + ")");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
      return;
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (!paramStringBuilder.toString().endsWith(";")) {
        break label31;
      }
      paramStringBuilder.append(" ");
    }
    label31:
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
        QLog.d("KeyInfo", 2, paramString2 + "is empty");
      }
    } while (TextUtils.isEmpty(paramString3));
    a(paramStringBuilder);
    paramStringBuilder.append(paramString2).append(paramString3);
  }
  
  private String b(String paramString)
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
  
  public static String b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      paramString = "";
      return paramString;
    }
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    paramAppRuntime = paramAppRuntime.getAccount();
    long l1 = System.currentTimeMillis();
    String str = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), paramString });
    jhe localjhe = new jhe(paramString, l1);
    localObject = ((TicketManager)localObject).GetPskey(paramAppRuntime, 16L, new String[] { str }, localjhe);
    paramAppRuntime = null;
    if (localObject != null) {
      paramAppRuntime = ((Ticket)localObject).getPt4Token(paramString);
    }
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramAppRuntime)) {
        break label149;
      }
      QLog.d("KeyInfo", 2, "Get pt4_token cache success for " + paramString);
    }
    for (;;)
    {
      paramString = paramAppRuntime;
      if (paramAppRuntime != null) {
        break;
      }
      return "";
      label149:
      QLog.d("KeyInfo", 2, "Get pt4_token cache failed for " + paramString);
    }
  }
  
  private void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "getDomainInfo finish, now notify all with(" + paramInt + ")");
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
      return;
    }
  }
  
  private boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.h));
  }
  
  public KeyInfo a(AppRuntime arg1, Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    int i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 != 3)
    {
      if (i1 == 1)
      {
        AppRuntime localAppRuntime = ???;
        if (??? == null) {
          localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        a(localAppRuntime, paramIntent);
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("KeyInfo", 2, "Preload tickets not complete, waiting for it...");
          }
          try
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
          }
          catch (InterruptedException paramIntent)
          {
            paramIntent.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.e("KeyInfo", 2, "waitKeyInfo failed");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KeyInfo", 2, "waitKeyInfo costTime=" + (System.currentTimeMillis() - l1));
    }
    return jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo;
  }
  
  public String a(String paramString)
  {
    int i4 = 0;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "url is empty");
      }
      return "";
    }
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime == null) || (!localAppRuntime.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "runtime is error");
      }
      return "";
    }
    String str1 = "";
    try
    {
      if (CookieSyncManager.createInstance(localAppRuntime.getApplication().getApplicationContext()) != null) {
        str1 = CookieManager.getInstance().getCookie(paramString);
      }
      localObject2 = new StringBuilder();
      localTicketManager = (TicketManager)localAppRuntime.getManager(2);
      str3 = localAppRuntime.getAccount();
      str4 = b(str3);
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "Get cookie:" + Util.c(str1, new String[0]) + " from " + Util.b(paramString, new String[0]));
      }
      if (!TextUtils.isEmpty(str1)) {
        ((StringBuilder)localObject2).append(str1);
      }
      a((StringBuilder)localObject2);
      ((StringBuilder)localObject2).append("uin=").append(str4);
      if ((TextUtils.isEmpty(str1)) || (!str1.contains("skey="))) {
        if (TextUtils.isEmpty(this.c))
        {
          localObject1 = localTicketManager.getSkey(str3);
          this.c = ((String)localObject1);
          a((StringBuilder)localObject2, this.c, "skey=", "");
          i1 = 0;
          if ((TextUtils.isEmpty(str1)) || (!str1.contains("p_skey=;"))) {
            break label532;
          }
          if (!QLog.isColorLevel()) {
            break label1044;
          }
          QLog.d("KeyInfo", 2, "not need set pskey");
          i2 = 0;
          if ((TextUtils.isEmpty(str1)) || (!str1.contains("pt4_token=;"))) {
            break label706;
          }
          if (!QLog.isColorLevel()) {
            break label1038;
          }
          QLog.d("KeyInfo", 2, "not need set pt4_token");
          i3 = 0;
          if ((i1 == 0) && (i2 == 0) && (i3 == 0)) {
            break label1032;
          }
          str1 = ((StringBuilder)localObject2).toString().replaceAll(" ", "");
          localObject1 = new StringBuilder();
          if (!str1.contains(";")) {
            break label1025;
          }
          localObject2 = str1.split(";");
          int i5 = localObject2.length;
          for (;;)
          {
            if (i4 >= i5) {
              break label1025;
            }
            str4 = localObject2[i4];
            if (!TextUtils.isEmpty(str4))
            {
              if (((StringBuilder)localObject1).length() != 0) {
                break;
              }
              ((StringBuilder)localObject1).append(str4);
            }
            i4 += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        TicketManager localTicketManager;
        String str3;
        String str4;
        int i2;
        int i3;
        if (QLog.isColorLevel()) {
          QLog.w("KeyInfo", 2, "get cookie encounter exception!");
        }
        String str2 = "";
        continue;
        Object localObject1 = this.c;
        continue;
        if (str2.contains("skey=;"))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("KeyInfo", 2, "not need set skey");
            i1 = 0;
          }
        }
        else if (str2.contains("skey="))
        {
          i1 = 1;
          continue;
          label532:
          localObject1 = localAuthorizeConfig.d(paramString);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if ((TextUtils.isEmpty(str2)) || (!str2.contains("p_skey=")))
            {
              if ((!TextUtils.isEmpty(str2)) && (str2.contains("p_uin=;")))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("KeyInfo", 2, "not need set p_uin");
                }
                label595:
                if (!TextUtils.isEmpty(this.d)) {
                  break label682;
                }
              }
              label682:
              for (localObject1 = localTicketManager.getPskey(str3, (String)localObject1);; localObject1 = this.d)
              {
                this.d = ((String)localObject1);
                a((StringBuilder)localObject2, this.d, "p_skey=", "");
                i2 = 0;
                break;
                if ((!TextUtils.isEmpty(str2)) && (str2.contains("p_uin="))) {
                  break label595;
                }
                a((StringBuilder)localObject2);
                ((StringBuilder)localObject2).append("p_uin=").append(str4);
                break label595;
              }
            }
            if (str2.contains("p_skey="))
            {
              i2 = 1;
              continue;
              label706:
              localObject1 = localAuthorizeConfig.e(paramString);
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                if ((TextUtils.isEmpty(str2)) || (!str2.contains("pt4_token=")))
                {
                  if (TextUtils.isEmpty(this.g)) {}
                  for (str2 = b(localAppRuntime, (String)localObject1);; str2 = this.g)
                  {
                    this.g = str2;
                    a((StringBuilder)localObject2, this.g, "pt4_token=", "");
                    i3 = 0;
                    break;
                  }
                }
                if (str2.contains("pt4_token="))
                {
                  i3 = 1;
                  continue;
                  a((StringBuilder)localObject1);
                  if ((str4.startsWith("p_skey=")) && (i2 != 0))
                  {
                    if (TextUtils.isEmpty(this.d)) {}
                    for (str2 = localTicketManager.getPskey(str3, localAuthorizeConfig.d(paramString));; str2 = this.d)
                    {
                      this.d = str2;
                      a((StringBuilder)localObject1, this.d, "p_skey=", str4);
                      break;
                    }
                  }
                  if ((str4.startsWith("skey=")) && (i1 != 0))
                  {
                    if (TextUtils.isEmpty(this.c)) {}
                    for (str2 = localTicketManager.getSkey(str3);; str2 = this.c)
                    {
                      this.c = str2;
                      a((StringBuilder)localObject1, this.c, "skey=", str4);
                      break;
                    }
                  }
                  if ((str4.startsWith("pt4_token=")) && (i3 != 0))
                  {
                    if (TextUtils.isEmpty(this.g)) {}
                    for (str2 = b(localAppRuntime, localAuthorizeConfig.e(paramString));; str2 = this.g)
                    {
                      this.g = str2;
                      a((StringBuilder)localObject1, this.g, "pt4_token=", str4);
                      break;
                    }
                  }
                  ((StringBuilder)localObject1).append(str4);
                  continue;
                  label1025:
                  label1032:
                  for (paramString = (String)localObject1;; paramString = (String)localObject2) {
                    return paramString.toString();
                  }
                }
              }
              label1038:
              i3 = 0;
              continue;
            }
          }
          label1044:
          i2 = 0;
          continue;
        }
        int i1 = 0;
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      this.jdField_b_of_type_JavaLangString = "";
      this.c = "";
      this.e = "";
      this.f = "";
      this.d = "";
      this.g = "";
      this.h = "";
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    }
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("KeyInfo", 2, "Reset KeyInfo instance");
      }
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramString2);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList1);
  }
  
  protected void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
    {
      localObject1 = AuthorizeConfig.a();
      localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      localObject2 = b(paramAppRuntime.getAccount());
      a("http://ptlogin2.qq.com/", "superuin=" + (String)localObject2 + "; PATH=/; DOMAIN=.ptlogin2.qq.com;");
      localObject3 = ((AuthorizeConfig)localObject1).a("skey").iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        a("http://www." + (String)localObject4 + '/', "uin=" + (String)localObject2 + "; PATH=/; DOMAIN=." + (String)localObject4 + ';');
      }
      localObject1 = ((AuthorizeConfig)localObject1).a("pskey");
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        a("http://www." + (String)localObject4 + '/', "p_uin=" + (String)localObject2 + "; PATH=/; DOMAIN=." + (String)localObject4 + ';');
      }
      localObject2 = new HashMap();
      localObject4 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
      if (this.jdField_a_of_type_JavaUtilHashMap.size() == 0) {}
      for (i1 = 16;; i1 = this.jdField_a_of_type_JavaUtilHashMap.size() * 256)
      {
        localObject3 = new StringBuilder(i1);
        localObject4 = ((Set)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          str = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (ArrayList)((Map.Entry)localObject5).getValue();
          if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
          {
            localObject5 = (String[])((ArrayList)localObject5).toArray(new String[((ArrayList)localObject5).size()]);
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject3).append("set cookies: ").append(str).append(", value: ").append(Util.c(Arrays.toString((Object[])localObject5), new String[0])).append("\n");
            }
            ((HashMap)localObject2).put(str, localObject5);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("KeyInfo", 2, ((StringBuilder)localObject3).toString());
      }
      if (((HashMap)localObject2).size() > 0) {
        localCookieManager.setCookies((Map)localObject2);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      CookieSyncManager.createInstance(paramAppRuntime.getApplication().getApplicationContext());
      CookieSyncManager.getInstance().sync();
      if (QLog.isColorLevel()) {
        QLog.i("KeyInfo", 2, "Set p_uin to cookie with domain:" + localObject1);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      CookieManager localCookieManager;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int i1;
      Object localObject5;
      String str;
      return;
    }
    QLog.e("KeyInfo", 2, "Fatal: setUINCookie() can't get runtime!");
  }
  
  public void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2)) {
      return;
    }
    ThreadManager.a(new jhf(this, paramAppRuntime, paramIntent), new jhg(this), false);
  }
  
  public void a(AppRuntime arg1, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("KeyInfo", 2, "Not need get domain info because url is null");
      }
    }
    do
    {
      do
      {
        return;
        int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        if (i1 == 3) {
          break;
        }
        if (i1 == 1)
        {
          AppRuntime localAppRuntime = ???;
          if (??? == null) {
            localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
          }
          b(localAppRuntime, paramString);
        }
        synchronized (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("KeyInfo", 2, "Preload domain info not complete, waiting for it...");
            }
            try
            {
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait();
            }
            catch (InterruptedException paramString)
            {
              paramString.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.e("KeyInfo", 2, "waitDomainInfo fail");
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("KeyInfo", 2, "waitDomainInfo costTime=" + (System.currentTimeMillis() - l1));
      return;
    } while (!QLog.isColorLevel());
    QLog.d("KeyInfo", 2, "Domain info was ready, return immediately");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) && (!b());
  }
  
  public void b()
  {
    this.i = this.c;
    this.j = this.e;
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("KeyInfo", 2, "Start get Tickets without url...");
    }
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    paramAppRuntime = paramAppRuntime.getAccount();
    if (TextUtils.isEmpty(this.c)) {
      this.c = localTicketManager.getSkey(paramAppRuntime);
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = localTicketManager.getSuperkey(paramAppRuntime);
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = localTicketManager.getStweb(paramAppRuntime);
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = localTicketManager.getA2(paramAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.d("KeyInfo", 2, Util.c(toString().toLowerCase(), new String[] { "stwxweb" }));
    }
    int i1;
    int i2;
    label175:
    int i3;
    if (TextUtils.isEmpty(this.c))
    {
      i1 = 0;
      if (!TextUtils.isEmpty(this.i)) {
        break label294;
      }
      i2 = 0;
      if (!TextUtils.isEmpty(this.e)) {
        break label300;
      }
      i3 = 0;
      label188:
      if (!TextUtils.isEmpty(this.j)) {
        break label306;
      }
    }
    label294:
    label300:
    label306:
    for (int i4 = 0;; i4 = 2)
    {
      VipUtils.a(null, "webview_report", "0X800619D", "0X800619D", 0, 0, new String[] { "" + (i1 + i2), "" + (i3 + i4) });
      this.i = "";
      this.j = "";
      a(3);
      return;
      i1 = 1;
      break;
      i2 = 2;
      break label175;
      i3 = 1;
      break label188;
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString)
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2)) {
      return;
    }
    ThreadManager.a(new jhc(this, paramAppRuntime, paramString), new jhd(this), false);
  }
  
  public void c(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.i("KeyInfo", 2, "Start getDomainInfo for " + paramString);
    }
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
    if (paramString.startsWith("file:"))
    {
      this.k = "";
      this.jdField_a_of_type_Boolean = false;
      this.l = "qq.com";
      this.m = "";
      this.n = "";
      this.o = "";
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      b(3);
      return;
      Uri localUri = Uri.parse(paramString);
      Object localObject1 = localObject3;
      if (localUri != null) {}
      try
      {
        localObject1 = localUri.getQueryParameter("refer");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (("Qzone".equals(localObject1)) || ("qqreader".equals(localObject1))))
        {
          this.k = "";
          if (TextUtils.isEmpty(this.k)) {
            break label429;
          }
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_b_of_type_Boolean = localAuthorizeConfig.c(paramString);
          this.l = Util.c(paramString);
          this.o = localAuthorizeConfig.f(paramString);
          this.m = localAuthorizeConfig.d(paramString);
          if ((!TextUtils.isEmpty(this.m)) && (TextUtils.isEmpty(this.d))) {
            this.d = a(paramAppRuntime, this.m);
          }
          this.n = localAuthorizeConfig.e(paramString);
          if ((!TextUtils.isEmpty(this.n)) && (TextUtils.isEmpty(this.g))) {
            this.g = b(paramAppRuntime, this.n);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("KeyInfo", 2, "KeyInfo needVkey=" + this.jdField_b_of_type_Boolean + ",topLevelDomain=" + this.l + ",pSkeyDomain=" + this.m + ",Pt4TokenDomain=" + this.n + ",a2Domain=" + this.o + ",needVkey=" + this.jdField_b_of_type_Boolean);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          localException.printStackTrace();
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("KeyInfo", 2, "GetKeyPluin: invalid refer");
            localObject2 = localObject3;
            continue;
            this.k = localAuthorizeConfig.a(paramString);
            continue;
            label429:
            bool = false;
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "KeyInfo include Vkey=" + this.jdField_b_of_type_JavaLangString + "; Skey=" + this.c + "; Superkey=" + this.e + "; STwxWeb=" + this.f + "; pSkeyDomain=" + this.m + "; pSkey=" + this.d + "; Pt4TokenDomain=" + this.n + "; Pt4Token=" + this.g + "; a2Domain=" + this.o + ";";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\KeyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */