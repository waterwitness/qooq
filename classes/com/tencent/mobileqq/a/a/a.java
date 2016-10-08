package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static final ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static void a()
  {
    long l = SystemClock.elapsedRealtime();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a)((Map.Entry)localObject).getValue();
      if (l - ((a)localObject).c > 480000L)
      {
        a.remove(str);
        a((a)localObject, false);
      }
    }
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    if ((parama != null) && (parama.g > 0L) && (parama.h > 0L) && (parama.g < parama.h))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      localHashMap.put("ssoSeq", "" + parama.b);
      localHashMap.put("msgSeq", "" + parama.d);
      localHashMap.put("fromUin", parama.e);
      localHashMap.put("toUin", parama.f);
      localHashMap.put("onsectime", "" + parama.g);
      localHashMap.put("normaltime", "" + parama.h);
      MsfService.core.getStatReporter().a("OneSecEffect", paramBoolean, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (String str1 = (String)paramToServiceMsg.getAttributes().get("fromUin");; str1 = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (String str2 = (String)paramToServiceMsg.getAttributes().get("uin"); (i == 64536) && (!bool) && (j <= 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)); str2 = null)
        {
          a locala = new a(null);
          locala.a = paramToServiceMsg.getUin();
          locala.b = paramToServiceMsg.getRequestSsoSeq();
          locala.c = SystemClock.elapsedRealtime();
          locala.d = l;
          locala.e = str1;
          locala.f = str2;
          a.put(str1 + str2 + l, locala);
          return;
        }
        break;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) || (!paramFromServiceMsg.isSuccess())) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (paramFromServiceMsg = (String)paramToServiceMsg.getAttributes().get("fromUin");; paramFromServiceMsg = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("uin");; paramToServiceMsg = null)
        {
          if ((i != 64536) || (bool) || (j > 0) || (TextUtils.isEmpty(paramFromServiceMsg)) || (TextUtils.isEmpty(paramToServiceMsg))) {
            break label318;
          }
          paramToServiceMsg = paramFromServiceMsg + paramToServiceMsg + l;
          paramFromServiceMsg = (a)a.get(paramToServiceMsg);
          if (paramFromServiceMsg == null) {
            break;
          }
          a.remove(paramToServiceMsg);
          if (paramFromServiceMsg.g <= 0L) {
            break;
          }
          paramFromServiceMsg.h = SystemClock.elapsedRealtime();
          a(paramFromServiceMsg, true);
          return;
        }
        label318:
        break;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (paramFromServiceMsg = (String)paramToServiceMsg.getAttributes().get("fromUin");; paramFromServiceMsg = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("uin");; paramToServiceMsg = null)
        {
          if ((i != 64536) || (bool) || (j > 0) || (TextUtils.isEmpty(paramFromServiceMsg)) || (TextUtils.isEmpty(paramToServiceMsg))) {
            break label353;
          }
          paramToServiceMsg = paramFromServiceMsg + paramToServiceMsg + l;
          paramFromServiceMsg = (a)a.get(paramToServiceMsg);
          if (paramFromServiceMsg == null) {
            break;
          }
          if (paramBoolean)
          {
            if (paramFromServiceMsg.h <= 0L)
            {
              paramFromServiceMsg.g = SystemClock.elapsedRealtime();
              return;
            }
            a.remove(paramToServiceMsg);
            return;
          }
          a.remove(paramToServiceMsg);
          if (paramFromServiceMsg.g <= 0L) {
            break;
          }
          if (paramFromServiceMsg.h <= 0L) {
            paramFromServiceMsg.h = SystemClock.elapsedRealtime();
          }
          a(paramFromServiceMsg, true);
          return;
        }
        label353:
        break;
      }
    }
  }
  
  private static class a
  {
    public String a;
    public int b;
    public long c;
    public long d;
    public String e;
    public String f;
    public long g = -1L;
    public long h = -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */