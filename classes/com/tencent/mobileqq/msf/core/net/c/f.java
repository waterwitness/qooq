package com.tencent.mobileqq.msf.core.net.c;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.msf.service.protocol.push.a.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class f
{
  static final String a = "MSF.C.QualityTestManager";
  public static d b;
  public static b c;
  public static MsfCore d;
  public static String e = "";
  public static ArrayList f = new ArrayList();
  public static ArrayList g = new ArrayList();
  static int h = 1;
  static int i;
  
  private static String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      localObject = "";
    }
    Iterator localIterator;
    do
    {
      return (String)localObject;
      localIterator = paramArrayList.iterator();
      paramArrayList = "";
      localObject = paramArrayList;
    } while (!localIterator.hasNext());
    Object localObject = (Long)localIterator.next();
    if (localObject != null) {}
    for (paramArrayList = paramArrayList + localObject + ";";; paramArrayList = paramArrayList + "-1;") {
      break;
    }
  }
  
  public static void a()
  {
    b = null;
    c = null;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    UniPacket localUniPacket;
    try
    {
      if (!paramFromServiceMsg.isSuccess()) {
        break label985;
      }
      if (b != null) {
        break label976;
      }
      localUniPacket = new UniPacket(true);
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = localUniPacket.getFuncName();
      if (!paramFromServiceMsg.equals("QualityTest")) {
        break label807;
      }
      b = (d)localUniPacket.getByClass("QualityTest", new d());
      QLog.d("MSF.C.QualityTestManager", 1, "Quality getted, start now " + b.a);
      if ((NetConnInfoCenterImpl.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() >= 10)) {
        break label343;
      }
      e = "NotWiFi";
      if (b.a == 1)
      {
        new Thread(new a(b, c, a.a.a, h, i)).start();
        return;
      }
      if (b.a == 2)
      {
        new Thread(new a(b, c, a.a.b, h, i)).start();
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityManager error, ", paramFromServiceMsg);
      return;
    }
    if (b.a == 3)
    {
      new Thread(new a(b, c, a.a.c, h, i)).start();
      return;
    }
    if (b.a == 5)
    {
      new Thread(new a(b, c, a.a.e, h, i)).start();
      return;
    }
    if (b.a == 6)
    {
      new Thread(new a(b, c, a.a.d, h, i)).start();
      return;
    }
    a();
    return;
    label343:
    if ((b.m & 0xFF) == 1L)
    {
      e = "WiFi";
      if (b.a == 5)
      {
        new Thread(new a(b, c, a.a.e, h, i)).start();
        return;
      }
      if (b.a != 6) {
        break label994;
      }
      new Thread(new a(b, c, a.a.d, h, i)).start();
    }
    for (;;)
    {
      if (j < 2)
      {
        if (b.a == 1)
        {
          new Thread(new a(b, c, a.a.a, 2, j)).start();
          break label999;
        }
        if (b.a == 2)
        {
          new Thread(new a(b, c, a.a.b, 2, j)).start();
          break label999;
        }
        if (b.a == 3)
        {
          new Thread(new a(b, c, a.a.c, 2, j)).start();
          break label999;
        }
        a();
        return;
        e = "WiFi";
        if (b.a == 1)
        {
          new Thread(new a(b, c, a.a.a, h, i)).start();
          return;
        }
        if (b.a == 2)
        {
          new Thread(new a(b, c, a.a.b, h, i)).start();
          return;
        }
        if (b.a == 3)
        {
          new Thread(new a(b, c, a.a.c, h, i)).start();
          return;
        }
        if (b.a == 5)
        {
          new Thread(new a(b, c, a.a.e, h, i)).start();
          return;
        }
        if (b.a == 6)
        {
          new Thread(new a(b, c, a.a.d, h, i)).start();
          return;
        }
        a();
        return;
        label807:
        if (paramFromServiceMsg.equals("MtuTest"))
        {
          c = (b)localUniPacket.getByClass("MtuTest", new b());
          QLog.d("MSF.C.QualityTestManager", 1, "MtuTest getted, start now");
          if (c.a == 1)
          {
            new Thread(new a(b, c, a.a.a, h, i)).start();
            return;
          }
          if (c.a == 2)
          {
            new Thread(new a(b, c, a.a.b, h, i)).start();
            return;
          }
          if (c.a == 3)
          {
            new Thread(new a(b, c, a.a.c, h, i)).start();
            return;
          }
          a();
          return;
          label976:
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted too frequently drop now");
          return;
          label985:
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted, return fail do nothing");
        }
      }
      return;
      label994:
      int j = 0;
      continue;
      label999:
      j += 1;
    }
  }
  
  public static void a(boolean paramBoolean, d paramd, b paramb, int paramInt1, int paramInt2)
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    int k;
    if (paramd != null)
    {
      localHashMap.put("TestType", "QualityTest");
      localHashMap.put("ProtoType", "" + paramd.a);
      paramb = new StringBuilder().append("");
      if (paramd.b != null)
      {
        k = paramd.b.size();
        localHashMap.put("IpNum", k);
        localHashMap.put("PkgNum", "" + paramd.c);
        paramb = new StringBuilder().append("");
        if (paramd.e == null) {
          break label334;
        }
        k = paramd.e.length;
        label159:
        localHashMap.put("PkgDataSize", k);
        localHashMap.put("RepeatTimes", "" + paramd.f);
        paramb = new StringBuilder().append("");
        if (paramd.g != null) {
          j = paramd.g.length;
        }
        localHashMap.put("HeadDataSize", j);
        localHashMap.put("testPacketRecved", "" + paramInt1);
        localHashMap.put("testPacketSend", "" + paramInt2);
      }
    }
    for (;;)
    {
      d.getStatReporter().a("dim.Msf.NetTestResult", paramBoolean, 0L, paramInt1 + paramInt2, localHashMap, false, false);
      return;
      k = -1;
      break;
      label334:
      k = -1;
      break label159;
      if (paramb != null)
      {
        localHashMap.put("TestType", "MtuTest");
        localHashMap.put("ProtoType", "" + paramb.a);
        paramd = new StringBuilder().append("");
        if (paramb.b != null) {
          j = paramb.b.size();
        }
        localHashMap.put("IpNum", j);
        localHashMap.put("PkgNum", "" + paramb.g);
        localHashMap.put("PkgDataSize", b(paramb.c));
        localHashMap.put("RepeatTimes", a(paramb.d));
        localHashMap.put("HeadDataSize", b(paramb.e));
        localHashMap.put("testPacketRecved", "" + paramInt1);
        localHashMap.put("testPacketSend", "" + paramInt2);
      }
    }
  }
  
  private static String b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      localObject = "";
    }
    Iterator localIterator;
    do
    {
      return (String)localObject;
      localIterator = paramArrayList.iterator();
      paramArrayList = "";
      localObject = paramArrayList;
    } while (!localIterator.hasNext());
    Object localObject = (byte[])localIterator.next();
    if (localObject != null) {}
    for (paramArrayList = paramArrayList + localObject.length + ";";; paramArrayList = paramArrayList + "-1;") {
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */