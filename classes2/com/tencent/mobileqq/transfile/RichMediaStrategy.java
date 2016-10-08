package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RichMediaStrategy
{
  public static final int a = 2;
  public static RichMediaStrategy.NetPolicy a = new RichMediaStrategy.G2();
  public static final int b = 9;
  public static RichMediaStrategy.NetPolicy b = new RichMediaStrategy.G3();
  public static final int c = 3;
  public static RichMediaStrategy.NetPolicy c = new RichMediaStrategy.WIFI();
  public static final int d = 480000;
  public static final int e = 25;
  public static final int f = 450000;
  public static final int g = 2;
  public static final int h = 90000;
  public static final int i = 89500;
  public static final int j = 3;
  public static final int k = 3;
  public static final int l = 5;
  private static int m;
  private static int n;
  private static int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    m = 18;
    n = 6;
    o = 600000;
  }
  
  public static int a()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 1;
    }
    return (int)('ᝰ' * Math.pow(2.0D, (i1 - 1) / 2));
  }
  
  public static int a(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int i2 = 1;
    int i1 = 0;
    boolean bool;
    int i3;
    if (!d(paramInt1))
    {
      bool = false;
      i3 = paramNetPolicy.f();
      if (paramInt2 != 0) {
        break label259;
      }
      paramInt2 = i2;
    }
    label259:
    for (;;)
    {
      i2 = (int)(i3 * Math.pow(2.0D, (paramInt2 - 1) / 2));
      if (!a(paramInt1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + paramInt2 + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + i1);
        }
        if (bool)
        {
          return i1;
          if (paramInt2 < paramNetPolicy.c())
          {
            bool = true;
            break;
          }
          if (paramInt2 >= paramNetPolicy.b())
          {
            bool = false;
            break;
          }
          if (paramBoolean)
          {
            if ((paramInt3 < 3) && (paramLong < paramNetPolicy.a()))
            {
              bool = true;
              break;
            }
            bool = false;
            break;
          }
          if (paramLong < paramNetPolicy.a())
          {
            bool = true;
            break;
          }
          bool = false;
          break;
        }
        return -1;
        i1 = i2;
      }
    }
  }
  
  public static RichMediaStrategy.NetPolicy a(int paramInt)
  {
    RichMediaStrategy.NetPolicy localNetPolicy = a;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return localNetPolicy;
    case 1: 
    case 4: 
    case 5: 
      return c;
    }
    return b;
  }
  
  public static void a(String paramString)
  {
    int i1 = 0;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.length() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString = " + paramString);
          }
          paramString = paramString.split("\\|");
          int i2;
          if (paramString != null)
          {
            i2 = paramString.length;
            if (i2 == 3) {
              if (i1 >= 3) {
                continue;
              }
            }
          }
          try
          {
            i2 = Integer.valueOf(paramString[i1]).intValue();
            if (i2 > 0) {
              continue;
            }
          }
          catch (NumberFormatException paramString)
          {
            QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", paramString);
            continue;
          }
          return;
          i1 += 1;
          continue;
          m = Integer.valueOf(paramString[0]).intValue();
          n = Integer.valueOf(paramString[1]).intValue();
          o = Integer.valueOf(paramString[2]).intValue() * 1000;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RichMediaStrategy", 2, "updataFromDpc: TryCount_dpc = " + m + " FixSchedulTryCount_dpc = " + n + " TryTime_dpc = " + o);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int i2 = 1;
    int i1 = 0;
    boolean bool;
    int i3;
    if (!d(paramInt1))
    {
      bool = false;
      i3 = paramNetPolicy.f();
      if (paramInt2 != 0) {
        break label278;
      }
      paramInt2 = i2;
    }
    label278:
    for (;;)
    {
      i2 = (int)(i3 * Math.pow(2.0D, (paramInt2 - 1) / 2));
      if (!a(paramInt1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + paramInt2 + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + i1);
        }
        if ((bool) && (i1 > 0)) {
          paramLong = i1;
        }
        try
        {
          Thread.sleep(paramLong);
          return bool;
        }
        catch (InterruptedException paramNetPolicy)
        {
          paramNetPolicy.printStackTrace();
          return bool;
        }
        if (paramInt2 < paramNetPolicy.c())
        {
          bool = true;
          break;
        }
        if (paramInt2 >= paramNetPolicy.b())
        {
          bool = false;
          break;
        }
        if (paramBoolean)
        {
          if ((paramInt3 < 3) && (paramLong < paramNetPolicy.a()))
          {
            bool = true;
            break;
          }
          bool = false;
          break;
        }
        if (paramLong < paramNetPolicy.a())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        i1 = i2;
      }
    }
  }
  
  public static int b()
  {
    try
    {
      int i1 = n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054) || (paramInt == 9014) || (paramInt == 9051) || (paramInt == 9047) || (paramInt == 9360)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (!d(paramInt1)) {
      bool = false;
    }
    for (;;)
    {
      int i2 = paramNetPolicy.f();
      int i1 = paramInt2;
      if (paramInt2 == 0) {
        i1 = 1;
      }
      paramInt2 = (int)(i2 * Math.pow(2.0D, (i1 - 1) / 2));
      if (!a(paramInt1)) {
        paramInt2 = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "msgDown policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + i1 + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + paramInt2);
      }
      if ((bool) && (paramInt2 > 0)) {
        paramLong = paramInt2;
      }
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
      if (paramInt2 < 2) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return bool;
  }
  
  public static int c()
  {
    try
    {
      int i1 = o;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9361) || (paramInt == 9037)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean d(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 9020) || (paramInt == 9048) || (paramInt == 9042) || (paramInt == 9070) || (paramInt == 9036) || (paramInt == 9063) || (paramInt == 9071) || (paramInt == 9302) || (paramInt == 9072) || (paramInt == 9041) || (paramInt == 9040) || (paramInt == 9037)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\RichMediaStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */