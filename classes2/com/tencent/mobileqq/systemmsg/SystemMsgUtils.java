package com.tencent.mobileqq.systemmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMsgUtils
{
  private static long A = x;
  private static long B = A + (z - y);
  private static long C = 2601000000L;
  private static long D = 2652000000L;
  private static long E = 336000000L;
  private static long F = 387000000L;
  private static long G = 510000000L;
  private static long H = 2010000000L;
  private static long I = B;
  private static long J = I + (H - G);
  private static long a;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
  private static long f;
  private static long g;
  private static long h;
  private static long i;
  private static long j;
  private static long k;
  private static long l;
  private static long m;
  private static long n;
  private static long o;
  private static long p;
  private static long q;
  private static long r;
  private static long s;
  private static long t;
  private static long u;
  private static long v;
  private static long w;
  private static long x;
  private static long y;
  private static long z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = 202000000L;
    b = 213000000L;
    d = c + (b - a);
    e = 480000000L;
    f = 489000000L;
    g = d;
    h = g + (f - e);
    i = 2100000000L;
    j = 2147000000L;
    k = h;
    l = k + (j - i);
    m = 2010000000L;
    n = 2100000000L;
    o = l;
    p = o + (n - m);
    q = 2147000000L;
    r = 2200000000L;
    s = p;
    t = s + (r - q);
    u = 4100000000L;
    v = 4200000000L;
    w = t;
    x = w + (v - u);
    y = 3800000000L;
    z = 4000000000L;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {}
    switch (paramInt2)
    {
    default: 
      return paramInt1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 7;
    }
    return 8;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt2 == 11)
    {
      i1 = paramInt1;
      if (paramInt1 == 1) {
        switch (paramInt3)
        {
        default: 
          i1 = 2;
        }
      }
    }
    do
    {
      do
      {
        return i1;
        return 2;
        if (paramInt2 != 12) {
          break;
        }
        i1 = paramInt1;
      } while (paramInt1 != 1);
      switch (paramInt3)
      {
      default: 
        return 3;
      }
      return 3;
      if (paramInt2 == 13) {
        return 3;
      }
      if (paramInt2 == 14) {
        return 4;
      }
      i1 = paramInt1;
    } while (paramInt2 != 16);
    return 2;
  }
  
  public static String a(long paramLong)
  {
    long l2 = 0L;
    int i2 = -1;
    int i1 = i2;
    long l1 = l2;
    if (paramLong >= c)
    {
      i1 = i2;
      l1 = l2;
      if (paramLong < d)
      {
        l1 = paramLong - c + a;
        i1 = 0;
      }
    }
    i2 = i1;
    l2 = l1;
    if (paramLong >= g)
    {
      i2 = i1;
      l2 = l1;
      if (paramLong < h)
      {
        l2 = paramLong - g + e;
        i2 = 0;
      }
    }
    i1 = i2;
    l1 = l2;
    if (paramLong >= k)
    {
      i1 = i2;
      l1 = l2;
      if (paramLong < l)
      {
        l1 = paramLong - k + i;
        i1 = 0;
      }
    }
    i2 = i1;
    l2 = l1;
    if (paramLong >= o)
    {
      i2 = i1;
      l2 = l1;
      if (paramLong < p)
      {
        l2 = paramLong - o + m;
        i2 = 0;
      }
    }
    i1 = i2;
    l1 = l2;
    if (paramLong >= s)
    {
      i1 = i2;
      l1 = l2;
      if (paramLong < t)
      {
        l1 = paramLong - s + q;
        i1 = 0;
      }
    }
    i2 = i1;
    l2 = l1;
    if (paramLong >= w)
    {
      i2 = i1;
      l2 = l1;
      if (paramLong < x)
      {
        l2 = paramLong - w + u;
        i2 = 0;
      }
    }
    i1 = i2;
    l1 = l2;
    if (paramLong >= A)
    {
      i1 = i2;
      l1 = l2;
      if (paramLong < B)
      {
        if ((paramLong >= E) && (paramLong < F))
        {
          l1 = E;
          l1 = C;
        }
        l1 = paramLong - A + y;
        i1 = 0;
      }
    }
    i2 = i1;
    l2 = l1;
    if (paramLong >= I)
    {
      i2 = i1;
      l2 = l1;
      if (paramLong < J)
      {
        l2 = paramLong - I + G;
        i2 = 0;
      }
    }
    if (i2 == 0) {
      return String.valueOf(l2);
    }
    return null;
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2)
  {
    if (paramStructMsg != null) {
      switch (paramStructMsg.msg_type.get())
      {
      }
    }
    List localList;
    do
    {
      do
      {
        return;
        localList = paramStructMsg.msg.actions.get();
      } while ((localList == null) || (localList.size() <= paramInt1));
      str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
      paramStructMsg.msg.msg_decided.set(str);
      paramStructMsg.msg.msg_detail.set(paramString);
      paramInt1 = a(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get());
      paramStructMsg.msg.sub_type.set(paramInt1);
      paramStructMsg.msg.actions.clear();
      return;
      localList = paramStructMsg.msg.actions.get();
    } while ((localList == null) || (localList.size() <= paramInt1) || (!a(paramStructMsg.msg.sub_type.get(), paramStructMsg.msg.group_msg_type.get())));
    String str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
    paramStructMsg.msg.msg_decided.set(str);
    paramStructMsg.msg.msg_detail.set(paramString);
    paramInt1 = a(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get(), paramStructMsg.msg.group_msg_type.get());
    paramStructMsg.msg.sub_type.set(paramInt1);
    paramStructMsg.msg.actions.clear();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 13);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt1 == 3) {
      if (paramInt2 != 10)
      {
        bool1 = bool2;
        if (paramInt2 != 11) {}
      }
      else
      {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      bool1 = bool2;
      if (paramInt != 0)
      {
        if (paramStructMsg.msg_type.get() != 1) {
          break label116;
        }
        if ((paramStructMsg.msg.sub_type.get() != 9) && (paramStructMsg.msg.sub_type.get() != 10))
        {
          bool1 = bool2;
          if (paramStructMsg.msg.sub_type.get() != 1) {}
        }
        else
        {
          paramStructMsg.msg.msg_decided.set(paramString2);
          paramStructMsg.msg.msg_detail.set(paramString1);
          paramStructMsg.msg.actions.clear();
          bool1 = true;
        }
      }
    }
    label116:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramStructMsg.msg_type.get() != 2);
    paramStructMsg.msg.sub_type.set(5);
    paramStructMsg.msg.msg_decided.set(paramString2);
    paramStructMsg.msg.msg_detail.set(paramString1);
    paramStructMsg.msg.actions.clear();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\systemmsg\SystemMsgUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */