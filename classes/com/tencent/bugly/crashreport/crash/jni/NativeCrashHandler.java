package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import java.io.File;

public class NativeCrashHandler
{
  private static NativeCrashHandler a;
  private static boolean l = false;
  private static boolean m = false;
  private final Context b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final u d;
  private NativeExceptionHandler e;
  private String f;
  private final boolean g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private com.tencent.bugly.crashreport.crash.b n;
  
  @SuppressLint({"SdCardPath"})
  private NativeCrashHandler(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, u paramu, boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (paramContext == null)
    {
      localObject = paramContext;
      this.b = ((Context)localObject);
      if (paramString == null) {
        break label115;
      }
    }
    for (;;)
    {
      try
      {
        i1 = paramString.trim().length();
        if (i1 <= 0) {
          continue;
        }
        i1 = 0;
        if (i1 != 0) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        int i1;
        Context localContext;
        label115:
        paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
        paramString = "/data/data/" + paramContext + "/app_bugly";
        continue;
      }
      this.n = paramb;
      this.f = paramString;
      this.c = parama;
      this.d = paramu;
      this.g = paramBoolean;
      return;
      localContext = paramContext.getApplicationContext();
      localObject = localContext;
      if (localContext != null) {
        break;
      }
      localObject = paramContext;
      break;
      i1 = 1;
      continue;
      paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    String str2;
    String str3;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (this.j)
        {
          v.d("native already registed!", new Object[0]);
          return;
        }
        this.e = new a(this.b, this.c, this.n, com.tencent.bugly.crashreport.common.strategy.a.a(), this.f);
        boolean bool = this.i;
        if (bool) {
          try
          {
            str2 = regist(this.f, paramBoolean, 1);
            if (str2 != null)
            {
              v.a("Native Crash Report enable!", new Object[0]);
              v.c("Check extra jni for Bugly NDK v%s", new Object[] { str2 });
              str3 = "2.1.1".replace(".", "");
              str4 = "2.3.0".replace(".", "");
              localObject3 = str2.replace(".", "");
              if (((String)localObject3).length() != 2) {
                break label275;
              }
              str1 = (String)localObject3 + "0";
            }
          }
          catch (Throwable localThrowable1)
          {
            String str4;
            String str1;
            label165:
            label213:
            label229:
            v.c("load bugly so fail", new Object[0]);
          }
        }
      }
      finally {}
      try
      {
        if (Integer.parseInt(str1) >= Integer.parseInt(str3)) {
          l = true;
        }
        if (Integer.parseInt(str1) >= Integer.parseInt(str4)) {
          m = true;
        }
      }
      catch (Throwable localThrowable3)
      {
        Object localObject2;
        continue;
      }
      if (!m) {
        break label308;
      }
      v.a("Info setting jni can be accessed.", new Object[0]);
      if (!l) {
        break label321;
      }
      v.a("Extra jni can be accessed.", new Object[0]);
      this.c.o = str2;
      this.j = true;
    }
    label257:
    label275:
    label308:
    label321:
    do
    {
      this.i = false;
      this.h = false;
      break;
      localObject2 = localObject3;
      if (((String)localObject3).length() != 1) {
        break label165;
      }
      localObject2 = (String)localObject3 + "00";
      break label165;
      v.d("Info setting jni can not be accessed.", new Object[0]);
      break label213;
      v.d("Extra jni can not be accessed.", new Object[0]);
      break label229;
      paramBoolean = this.h;
    } while (!paramBoolean);
    for (;;)
    {
      try
      {
        localObject2 = Integer.TYPE;
        localObject3 = Integer.TYPE;
        str2 = this.f;
        str3 = com.tencent.bugly.crashreport.common.info.a.a().p();
        i1 = com.tencent.bugly.crashreport.common.info.a.a().F();
        localObject3 = (String)com.tencent.bugly.proguard.a.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, localObject2, localObject3 }, new Object[] { str2, str3, Integer.valueOf(i1), Integer.valueOf(1) });
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = Integer.TYPE;
          localObject3 = this.f;
          str2 = com.tencent.bugly.crashreport.common.info.a.a().p();
          i1 = com.tencent.bugly.crashreport.common.info.a.a().F();
          localObject2 = (String)com.tencent.bugly.proguard.a.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, localObject2 }, new Object[] { localObject3, str2, Integer.valueOf(i1) });
        }
        if (localObject2 == null) {
          break label257;
        }
        this.j = true;
        com.tencent.bugly.crashreport.common.info.a.a().o = ((String)localObject2);
        com.tencent.bugly.proguard.a.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
        if (!com.tencent.bugly.b.b) {
          break label611;
        }
        i1 = 3;
        com.tencent.bugly.proguard.a.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(i1) });
      }
      catch (Throwable localThrowable2) {}
      break label257;
      label611:
      int i1 = 5;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((!this.i) || (!m)) {}
    do
    {
      return false;
      try
      {
        setNativeInfo(paramInt, paramString);
        return true;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        m = false;
        return false;
      }
      catch (Throwable paramString) {}
    } while (v.a(paramString));
    paramString.printStackTrace();
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        v.a("[native] trying to load so: %s", new Object[] { paramString });
        if (paramBoolean) {
          System.load(paramString);
        }
      }
      catch (Throwable localThrowable1)
      {
        paramBoolean = false;
      }
      try
      {
        v.a("[native] load so success: %s", new Object[] { paramString });
        return true;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramBoolean = true;
        }
      }
      System.loadLibrary(paramString);
    }
    v.d(localThrowable1.getMessage(), new Object[0]);
    v.d("[native] Failed to load so, please check.", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b()
  {
    label140:
    for (;;)
    {
      try
      {
        if (!this.j)
        {
          v.d("native already unregisted!", new Object[0]);
          return;
        }
        try
        {
          if (unregist() == null) {
            break label140;
          }
          v.a("Native Crash Report close!", new Object[0]);
          this.j = false;
        }
        catch (Throwable localThrowable1)
        {
          v.c("unregist bugly so fail", new Object[0]);
        }
        try
        {
          com.tencent.bugly.proguard.a.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(false) });
          this.j = false;
          v.c("unregist rqd so success", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          v.c("unregist rqd so fail", new Object[0]);
          this.i = false;
          this.h = false;
        }
        continue;
        v.c("unregist bugly so success", new Object[0]);
      }
      finally {}
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        startNativeMonitor();
        return;
      }
      finally {}
      b();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.k != paramBoolean)
      {
        v.a("user change native %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.k = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NativeCrashHandler getInstance()
  {
    try
    {
      NativeCrashHandler localNativeCrashHandler = a;
      return localNativeCrashHandler;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1, u paramu, boolean paramBoolean, String paramString)
  {
    try
    {
      if (a == null) {
        a = new NativeCrashHandler(paramContext, parama, paramb, paramu, paramBoolean, paramString);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  protected final void a()
  {
    long l1 = com.tencent.bugly.proguard.a.e();
    long l2 = c.f;
    Object localObject1 = new File(this.f);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0)) {}
    }
    else
    {
      return;
    }
    int i4 = "tomb_".length();
    int i5 = localObject1.length;
    int i1 = 0;
    Object localObject2;
    String str;
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      if (i1 >= i5) {
        break label192;
      }
      localObject2 = localObject1[i1];
      str = ((File)localObject2).getName();
      i3 = i2;
      if (str.startsWith("tomb_")) {}
      try
      {
        i3 = str.indexOf(".txt");
        if (i3 <= 0) {
          break;
        }
        long l3 = Long.parseLong(str.substring(i4, i3));
        if (l3 < l1 - l2) {
          break;
        }
        i3 = i2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          v.e("tomb format error delete %s", new Object[] { str });
          i3 = i2;
          if (((File)localObject2).delete()) {
            i3 = i2 + 1;
          }
        }
      }
      i1 += 1;
    }
    label192:
    v.c("clean tombs %d", new Object[] { Integer.valueOf(i2) });
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
  {
    if ((!this.i) || (!l)) {}
    do
    {
      do
      {
        return false;
      } while ((paramString1 == null) || (paramString2 == null) || (paramString3 == null));
      try
      {
        boolean bool = appendNativeLog(paramString1, paramString2, paramString3);
        return bool;
      }
      catch (UnsatisfiedLinkError paramString1)
      {
        l = false;
        return false;
      }
      catch (Throwable paramString1) {}
    } while (v.a(paramString1));
    paramString1.printStackTrace();
    return false;
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public String getDumpFilePath()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public NativeExceptionHandler getNativeExceptionHandler()
  {
    return this.e;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isUserOpened()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void onStrategyChanged(StrategyBean paramStrategyBean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +35 -> 40
    //   8: aload_1
    //   9: getfield 362	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   12: aload_0
    //   13: getfield 50	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   16: if_icmpeq +24 -> 40
    //   19: ldc_w 364
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: getfield 362	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   32: invokestatic 222	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: aastore
    //   36: invokestatic 124	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   39: pop
    //   40: invokestatic 131	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   43: invokevirtual 367	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   46: getfield 362	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   49: ifeq +44 -> 93
    //   52: aload_0
    //   53: getfield 52	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   56: ifeq +37 -> 93
    //   59: iload_2
    //   60: aload_0
    //   61: getfield 50	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   64: if_icmpeq +26 -> 90
    //   67: ldc_w 369
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: iload_2
    //   77: invokestatic 222	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: invokestatic 144	com/tencent/bugly/proguard/v:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: iload_2
    //   87: invokespecial 371	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:b	(Z)V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iconst_0
    //   94: istore_2
    //   95: goto -36 -> 59
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	NativeCrashHandler
    //   0	103	1	paramStrategyBean	StrategyBean
    //   1	94	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	40	98	finally
    //   40	59	98	finally
    //   59	90	98	finally
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2)
  {
    if ((!this.i) || (!l)) {}
    do
    {
      do
      {
        return false;
      } while ((paramString1 == null) || (paramString2 == null));
      try
      {
        boolean bool = putNativeKeyValue(paramString1, paramString2);
        return bool;
      }
      catch (UnsatisfiedLinkError paramString1)
      {
        l = false;
        return false;
      }
      catch (Throwable paramString1) {}
    } while (v.a(paramString1));
    paramString1.printStackTrace();
    return false;
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean setNativeAppVersion(String paramString)
  {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeUserId(String paramString)
  {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean)
  {
    c(paramBoolean);
    if ((com.tencent.bugly.crashreport.common.strategy.a.a().c().g) && (isUserOpened())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean != this.j)
      {
        v.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
        b(paramBoolean);
      }
      return;
    }
  }
  
  public void startNativeMonitor()
  {
    boolean bool = true;
    int i1;
    String str3;
    label86:
    label114:
    label193:
    label199:
    String str2;
    for (;;)
    {
      String str1;
      try
      {
        if ((this.i) || (this.h))
        {
          a(this.g);
          return;
        }
        str1 = this.c.n;
        if ((str1 == null) || (str1.trim().length() <= 0)) {
          break label193;
        }
        i1 = 0;
      }
      finally {}
      str3 = this.c.n;
      if ((str3 == null) || (str3.trim().length() <= 0)) {
        break label265;
      }
      i1 = 0;
      break label245;
      String str4 = this.c.n;
      if ((str4 == null) || (str4.trim().length() <= 0)) {
        break;
      }
      i1 = 0;
      break label257;
      if (c.b)
      {
        this.h = a(str1, bool);
        if (this.h) {}
      }
      else
      {
        this.i = a(str3, bool);
      }
      if ((this.i) || (this.h))
      {
        a(this.g);
        this.d.b(new Runnable()
        {
          public final void run()
          {
            if (!com.tencent.bugly.proguard.a.a(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock", 10000L))
            {
              v.a("Failed to lock file for handling native crash record.", new Object[0]);
              return;
            }
            NativeCrashHandler.this.setNativeAppVersion(NativeCrashHandler.b(NativeCrashHandler.this).l);
            NativeCrashHandler.this.setNativeUserId(NativeCrashHandler.b(NativeCrashHandler.this).e());
            CrashDetailBean localCrashDetailBean = b.a(NativeCrashHandler.a(NativeCrashHandler.this), NativeCrashHandler.c(NativeCrashHandler.this), NativeCrashHandler.d(NativeCrashHandler.this));
            if (localCrashDetailBean != null)
            {
              if (!NativeCrashHandler.e(NativeCrashHandler.this).a(localCrashDetailBean)) {
                NativeCrashHandler.e(NativeCrashHandler.this).a(localCrashDetailBean, 3000L, false);
              }
              b.b(NativeCrashHandler.c(NativeCrashHandler.this));
              v.a("get crash from native record!", new Object[0]);
            }
            NativeCrashHandler.this.a();
            com.tencent.bugly.proguard.a.b(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock");
          }
        });
        continue;
        i1 = 1;
        break label233;
        str2 = this.c.n;
      }
    }
    label227:
    label233:
    label245:
    label257:
    label265:
    label269:
    for (;;)
    {
      str3 = this.c.n;
      break label86;
      i1 = 1;
      break label257;
      bool = false;
      break label114;
      if (i1 == 0) {
        break label199;
      }
      str2 = "NativeRQD";
      break;
      for (;;)
      {
        if (i1 == 0) {
          break label269;
        }
        str3 = "Bugly";
        break;
        if (i1 != 0) {
          break label227;
        }
        break label114;
        i1 = 1;
      }
    }
  }
  
  protected native void testCrash();
  
  public void testNativeCrash()
  {
    if (!this.i)
    {
      v.d("libBugly.so has not been load! so fail!", new Object[0]);
      return;
    }
    testCrash();
  }
  
  protected native String unregist();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */