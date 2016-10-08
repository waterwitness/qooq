package com.tencent.mobileqq.msf.core.auth;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  public static final int a = 604800000;
  public static final int b = 21600000;
  public static final int c = 1800000;
  public static final int d = 1000;
  public static ConcurrentHashMap f = new ConcurrentHashMap();
  public static final String g = "_new_version_never_change_token";
  public static boolean h = true;
  private static final String i = "MSF.C.TokenChecker";
  private static final String j = "_lastchecktokentime";
  private static final int k = 1800000;
  private static long l = -1L;
  private static int m = 5;
  b e;
  
  public d(b paramb)
  {
    this.e = paramb;
    if (TextUtils.isEmpty(MsfStore.getNativeConfigStore().getConfig("_new_version_never_change_token"))) {}
    for (h = false;; h = true)
    {
      if (!h) {
        MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(0));
      }
      QLog.d("MSF.C.TokenChecker", 1, "msf init ct");
      return;
    }
  }
  
  private long a(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 64);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 262144);
    if (l1 > l2) {
      return l2;
    }
    return l1;
  }
  
  private long b(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 4096);
    long l3 = this.e.a.getWtLoginCenter().a(paramString, 131072);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 32);
    long l4 = this.e.a.getWtLoginCenter().a(paramString, 1048576);
    if (l1 > l3)
    {
      l1 = l3;
      if (l1 <= l2) {
        break label105;
      }
      l1 = l2;
    }
    label105:
    for (;;)
    {
      if (l1 <= l4) {
        return l1;
      }
      return l4;
      break;
    }
    return l1;
  }
  
  private long d()
  {
    long l1 = 0L;
    try
    {
      int n = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = n - 900000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.TokenChecker", 4, "RandomRevise: " + l1);
    }
    return l1;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (l == -1L)
    {
      str = MsfStore.getNativeConfigStore().getConfig("_lastchecktokentime");
      if (str != null) {}
    }
    while ((l1 < l) || (l1 - l >= com.tencent.mobileqq.msf.core.a.a.C()))
    {
      do
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.TokenChecker", 2, "doCheck, lastCheckTime=" + l + ", now=" + l1);
        }
        l = l1;
        MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(l1));
        b();
        return;
        l = Long.parseLong(str);
      } while (l1 - l >= com.tencent.mobileqq.msf.core.a.a.C());
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = paramFromServiceMsg.getUin();
              paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
              if (paramFromServiceMsg.isSuccess()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("MSF.C.TokenChecker", 2, "onChangeTokenResult fail, uin=" + str + ", errorcode=" + paramFromServiceMsg.getBusinessFailCode());
            return;
            if (!paramToServiceMsg.equals("login.chgTok_A2D2")) {
              break;
            }
            paramToServiceMsg = (RespondCustomSig)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
          } while (paramToServiceMsg == null);
          Iterator localIterator = paramToServiceMsg.SigList.iterator();
          paramFromServiceMsg = null;
          CustomSigContent localCustomSigContent = null;
          paramToServiceMsg = (ToServiceMsg)localObject;
          localObject = localCustomSigContent;
          while (localIterator.hasNext())
          {
            localCustomSigContent = (CustomSigContent)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "onChangeTokenResult, content.ulSigType=" + localCustomSigContent.ulSigType + ", uin=" + str);
            }
            QLog.d("MSF.C.TokenChecker", 1, "iSimplified for " + MsfSdkUtils.getShortUin(str));
            if (localCustomSigContent.ulSigType == 0L) {
              localObject = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 18L) {
              paramFromServiceMsg = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 20L) {
              paramToServiceMsg = localCustomSigContent.SigContent;
            }
          }
        } while ((localObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null));
        l1 = System.currentTimeMillis();
      } while (l1 - this.e.m(str).z() <= 1800000L);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 succ, uin=" + str);
      }
      this.e.a(str, (byte[])localObject, paramFromServiceMsg, paramToServiceMsg, l1);
      if (com.tencent.mobileqq.msf.core.a.a.k())
      {
        QLog.d("MSF.C.TokenChecker", 1, "reloadkey add uin:" + MsfSdkUtils.getShortUin(str));
        f.put(str, Boolean.valueOf(true));
        return;
      }
      QLog.d("MSF.C.TokenChecker", 1, "give up reloading key for uin:" + MsfSdkUtils.getShortUin(str));
      return;
    } while ((!paramToServiceMsg.equals("login.chgTok_WEBVIEW_KEY")) || (!QLog.isColorLevel()));
    QLog.d("MSF.C.TokenChecker", 2, "renew webview key succ for " + str);
  }
  
  public void b()
  {
    new e(this, "threadCheckToken").start();
  }
  
  void c()
  {
    long l3 = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject4 = this.e.d();
    Object localObject2 = new ArrayList();
    Object localObject3 = localObject4;
    if (com.tencent.mobileqq.msf.core.a.a.ah())
    {
      localObject4 = ((ArrayList)localObject4).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (SimpleAccount)((Iterator)localObject4).next();
        if (((SimpleAccount)localObject3).isLogined()) {
          ((List)localObject2).add(localObject3);
        }
        if (!((SimpleAccount)localObject3).getUin().equals(this.e.i())) {
          break label812;
        }
        localObject1 = localObject3;
      }
    }
    label786:
    label809:
    label812:
    for (;;)
    {
      break;
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new f(this));
        if (((List)localObject2).size() <= m) {
          break label809;
        }
        localObject2 = ((List)localObject2).subList(0, m);
      }
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (!((List)localObject2).contains(localObject1))
          {
            ((List)localObject2).remove(((List)localObject2).size() - 1);
            ((List)localObject2).add(localObject1);
            localObject3 = localObject2;
          }
        }
        localObject1 = ((List)localObject3).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((SimpleAccount)((Iterator)localObject1).next()).getUin();
          int n = 0;
          int i1 = 0;
          long l4;
          long l1;
          if (this.e.h((String)localObject2))
          {
            l4 = a((String)localObject2);
            long l2 = com.tencent.mobileqq.msf.core.a.a.af();
            l1 = l2;
            if (l2 <= 0L) {
              l1 = 604800000L;
            }
            n = i1;
            if (l3 - l4 > l1 + d())
            {
              localObject3 = new ToServiceMsg("", (String)localObject2, "login.chgTok_A2D2");
              ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_refreToken);
              ((ToServiceMsg)localObject3).getAttributes().put("to_login_token_cmdhead", Integer.valueOf(9));
              ((ToServiceMsg)localObject3).getAttributes().put("refresh_token_src", "AccountTokenChecker");
              ((ToServiceMsg)localObject3).setRequestSsoSeq(MsfCore.getNextSeq());
              ((ToServiceMsg)localObject3).setAppId(this.e.a.getMsfAppid());
              ((ToServiceMsg)localObject3).setTimeout(30000L);
              localObject4 = new HashMap();
              RequestCustomSig localRequestCustomSig = new RequestCustomSig();
              localRequestCustomSig.ulCustumFlag = 35000416L;
              localRequestCustomSig.reserved = new byte[0];
              ((HashMap)localObject4).put("RequestCustomSig", localRequestCustomSig);
              ((ToServiceMsg)localObject3).getAttributes().put("to_login_token_map", localObject4);
              this.e.a.changeTokenAfterLogin((ToServiceMsg)localObject3, true);
              i1 = 1;
              n = i1;
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 for " + (String)localObject2);
                n = i1;
              }
            }
            l4 = b((String)localObject2);
            l2 = com.tencent.mobileqq.msf.core.a.a.ag();
            l1 = l2;
            if (l2 <= 0L) {
              l1 = 21600000L;
            }
            l1 = d() + l1;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder().append("MainService onTicketChanged, now: ").append(l3).append(" lastCheckWebviewKeyTime: ").append(l4).append(" interval: ").append(l3 - l4).append(" needChangeToken: ");
              if (l3 - l4 <= l1) {
                break label786;
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            QLog.d("MSF.C.TokenChecker", 2, bool);
            if ((!h) || (l3 - l4 > l1) || (this.e.a.getWtLoginCenter().b((String)localObject2)))
            {
              localObject3 = new ToServiceMsg("", (String)localObject2, "login.chgTok_WEBVIEW_KEY");
              ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_refreToken);
              ((ToServiceMsg)localObject3).setRequestSsoSeq(MsfCore.getNextSeq());
              ((ToServiceMsg)localObject3).setAppId(this.e.a.getMsfAppid());
              ((ToServiceMsg)localObject3).setTimeout(30000L);
              ((ToServiceMsg)localObject3).getAttributes().put("refresh_token_src", "AccountTokenChecker");
              this.e.a.changeTokenAfterLogin((ToServiceMsg)localObject3, true);
              i1 = 1;
              n = i1;
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.TokenChecker", 2, "renew webview key for " + (String)localObject2);
                n = i1;
              }
            }
            if (n == 0) {
              break;
            }
            try
            {
              Thread.sleep(com.tencent.mobileqq.msf.core.a.a.D());
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            break;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "checkToken, no active account");
            }
            return;
          }
        }
        h = true;
        MsfStore.getNativeConfigStore().n_setConfig("_new_version_never_change_token", String.valueOf(true));
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\auth\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */