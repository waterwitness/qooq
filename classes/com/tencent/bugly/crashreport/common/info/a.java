package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import com.tencent.bugly.proguard.v;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class a
{
  private static a X = null;
  public boolean A = false;
  private final Context B;
  private String C;
  private String D;
  private String E = "unknown";
  private String F = "unknown";
  private String G = "";
  private String H = null;
  private String I = null;
  private String J = null;
  private String K = null;
  private long L = -1L;
  private long M = -1L;
  private long N = -1L;
  private String O = null;
  private String P = null;
  private Map<String, PlugInBean> Q = null;
  private boolean R = true;
  private String S = null;
  private String T = null;
  private Boolean U = null;
  private String V = null;
  private Map<String, PlugInBean> W = null;
  private int Y = -1;
  private int Z = -1;
  public final long a = System.currentTimeMillis();
  private Map<String, String> aa = new HashMap();
  private Map<String, String> ab = new HashMap();
  private HashMap<String, String> ac = new HashMap();
  private String ad = null;
  private String ae = null;
  private String af = null;
  private String ag = null;
  private final Object ah = new Object();
  private final Object ai = new Object();
  private final Object aj = new Object();
  public final byte b;
  public String c;
  public final String d;
  public String e;
  public boolean f;
  public final String g;
  public final String h;
  public final String i;
  public String j;
  public long k;
  public String l = null;
  public String m = null;
  public String n = null;
  public String o = null;
  public List<String> p = null;
  public boolean q;
  public String r = "unknown";
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public String w = null;
  public String x = null;
  public String y = null;
  public boolean z = false;
  
  private a(Context paramContext)
  {
    Object localObject1;
    if (paramContext == null) {
      localObject1 = paramContext;
    }
    for (;;)
    {
      this.B = ((Context)localObject1);
      this.b = 1;
      localObject1 = AppInfo.b(paramContext);
      if (localObject1 != null)
      {
        this.l = AppInfo.a((PackageInfo)localObject1);
        this.w = this.l;
        this.x = AppInfo.b((PackageInfo)localObject1);
      }
      this.c = AppInfo.a(paramContext);
      this.d = AppInfo.c(paramContext);
      this.g = b.l();
      this.h = b.a();
      this.i = ("Android " + b.b() + ",level " + b.c());
      new StringBuilder().append(this.h).append(";").append(this.i).toString();
      localObject1 = AppInfo.d(paramContext);
      if (localObject1 != null) {}
      try
      {
        this.p = AppInfo.a((Map)localObject1);
        localObject2 = (String)((Map)localObject1).get("BUGLY_APPID");
        if (localObject2 != null) {
          this.T = ((String)localObject2);
        }
        localObject2 = (String)((Map)localObject1).get("BUGLY_APP_VERSION");
        if (localObject2 != null) {
          this.l = ((String)localObject2);
        }
        localObject2 = (String)((Map)localObject1).get("BUGLY_APP_CHANNEL");
        if (localObject2 != null) {
          this.m = ((String)localObject2);
        }
        localObject2 = (String)((Map)localObject1).get("BUGLY_ENABLE_DEBUG");
        if (localObject2 != null) {
          ((String)localObject2).toLowerCase().equals("true");
        }
        localObject1 = (String)((Map)localObject1).get("com.tencent.rdm.uuid");
        if (localObject1 != null) {
          this.y = ((String)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          for (;;)
          {
            if (!paramContext.getDatabasePath("bugly_db_").exists())
            {
              this.A = true;
              v.c("App is first time to be installed on the device.", new Object[0]);
            }
            v.c("com info create end", new Object[0]);
            return;
            Object localObject2 = paramContext.getApplicationContext();
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = paramContext;
            break;
            localThrowable = localThrowable;
            if (!v.a(localThrowable)) {
              localThrowable.printStackTrace();
            }
          }
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            if (com.tencent.bugly.b.b) {
              paramContext.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static a a()
  {
    try
    {
      a locala = X;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (X == null) {
        X = new a(paramContext);
      }
      paramContext = X;
      return paramContext;
    }
    finally {}
  }
  
  private void b(String paramString1, String paramString2)
  {
    int i2 = 0;
    if (paramString1 != null) {}
    for (;;)
    {
      int i1;
      try
      {
        if (paramString1.trim().length() > 0)
        {
          i1 = 0;
          if (i1 == 0)
          {
            if ((paramString2 != null) && (paramString2.trim().length() > 0))
            {
              i1 = i2;
              break label123;
            }
          }
          else {
            v.d("server key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
          }
        }
        else
        {
          i1 = 1;
          continue;
        }
        i1 = 1;
      }
      finally {}
      this.ab.put(paramString1, paramString2);
      continue;
      label123:
      if (i1 == 0) {}
    }
  }
  
  /* Error */
  public final Map<String, String> A()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 154	com/tencent/bugly/crashreport/common/info/a:ab	Ljava/util/Map;
    //   6: invokeinterface 354 1 0
    //   11: istore_2
    //   12: iload_2
    //   13: ifgt +9 -> 22
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 149	java/util/HashMap
    //   25: dup
    //   26: aload_0
    //   27: getfield 154	com/tencent/bugly/crashreport/common/info/a:ab	Ljava/util/Map;
    //   30: invokespecial 357	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   33: astore_1
    //   34: goto -16 -> 18
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	a
    //   17	17	1	localObject1	Object
    //   37	4	1	localObject2	Object
    //   11	2	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	12	37	finally
    //   22	34	37	finally
  }
  
  public final int B()
  {
    try
    {
      int i1 = this.Y;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int C()
  {
    try
    {
      int i1 = this.Z;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean D()
  {
    try
    {
      boolean bool = AppInfo.f(this.B);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Map<String, PlugInBean> E()
  {
    try
    {
      Map localMap = this.W;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int F()
  {
    try
    {
      int i1 = b.c();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String G()
  {
    if (this.ad == null) {
      this.ad = b.m();
    }
    return this.ad;
  }
  
  public final String H()
  {
    if (this.ae == null) {
      this.ae = b.i(this.B);
    }
    return this.ae;
  }
  
  public final String I()
  {
    return b.j(this.B);
  }
  
  public final String J()
  {
    Context localContext = this.B;
    return b.n();
  }
  
  public final String K()
  {
    if (this.af == null) {
      this.af = b.k(this.B);
    }
    return this.af;
  }
  
  public final long L()
  {
    Context localContext = this.B;
    return b.o();
  }
  
  public final void a(int paramInt)
  {
    try
    {
      int i1 = this.Y;
      if (i1 != paramInt)
      {
        this.Y = paramInt;
        v.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.Y) });
      }
      return;
    }
    finally {}
  }
  
  public final void a(Boolean paramBoolean)
  {
    try
    {
      this.U = paramBoolean;
      return;
    }
    finally
    {
      paramBoolean = finally;
      throw paramBoolean;
    }
  }
  
  public final void a(String paramString)
  {
    this.T = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int i2 = 0;
    if (paramString1 != null) {}
    for (;;)
    {
      int i1;
      try
      {
        if (paramString1.trim().length() > 0)
        {
          i1 = 0;
          if (i1 == 0)
          {
            if ((paramString2 != null) && (paramString2.trim().length() > 0))
            {
              i1 = i2;
              break label123;
            }
          }
          else {
            v.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
          }
        }
        else
        {
          i1 = 1;
          continue;
        }
        i1 = 1;
      }
      finally {}
      this.aa.put(paramString1, paramString2);
      continue;
      label123:
      if (i1 == 0) {}
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.W = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (this.Q == null) {
          this.Q = new HashMap();
        }
        this.Q.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        v.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b()
  {
    synchronized (this.ah)
    {
      this.C = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.E = str;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String c()
  {
    if (this.C == null) {}
    synchronized (this.ah)
    {
      if (this.C == null) {
        this.C = UUID.randomUUID().toString();
      }
      return this.C;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.D = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
  {
    String str = this.e;
    if ((str != null) && (str.trim().length() > 0)) {}
    for (int i1 = 0; i1 == 0; i1 = 1) {
      return this.e;
    }
    return this.T;
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.F = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.E;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.G = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final String f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 411	com/tencent/bugly/crashreport/common/info/a:D	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 411	com/tencent/bugly/crashreport/common/info/a:D	Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 234	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: invokevirtual 415	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   30: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 417
    //   36: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 419	com/tencent/bugly/crashreport/common/info/a:k	()Ljava/lang/String;
    //   43: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 417
    //   49: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 420	com/tencent/bugly/crashreport/common/info/a:l	()Ljava/lang/String;
    //   56: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: putfield 411	com/tencent/bugly/crashreport/common/info/a:D	Ljava/lang/String;
    //   65: aload_0
    //   66: getfield 411	com/tencent/bugly/crashreport/common/info/a:D	Ljava/lang/String;
    //   69: astore_1
    //   70: goto -56 -> 14
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	a
    //   13	57	1	str	String
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	73	finally
    //   18	70	73	finally
  }
  
  /* Error */
  public final void f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 423 2 0
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	a
    //   0	37	1	paramString	String
    //   10	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   6	11	32	finally
    //   18	29	32	finally
  }
  
  public final String g()
  {
    try
    {
      String str = this.F;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void g(String paramString)
  {
    this.S = paramString;
  }
  
  public final String h()
  {
    try
    {
      String str = this.G;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final String h(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +51 -> 56
    //   8: aload_1
    //   9: invokevirtual 339	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 342	java/lang/String:length	()I
    //   15: ifle +41 -> 56
    //   18: iload_2
    //   19: ifeq +42 -> 61
    //   22: ldc_w 426
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: new 234	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 346	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -40 -> 18
    //   61: aload_0
    //   62: getfield 152	com/tencent/bugly/crashreport/common/info/a:aa	Ljava/util/Map;
    //   65: aload_1
    //   66: invokeinterface 423 2 0
    //   71: checkcast 277	java/lang/String
    //   74: astore_1
    //   75: goto -23 -> 52
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   0	83	1	paramString	String
    //   1	57	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   8	18	78	finally
    //   22	50	78	finally
    //   61	75	78	finally
  }
  
  /* Error */
  public final String i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/tencent/bugly/crashreport/common/info/a:R	Z
    //   6: ifne +10 -> 16
    //   9: ldc 97
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 101	com/tencent/bugly/crashreport/common/info/a:H	Ljava/lang/String;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 200	com/tencent/bugly/crashreport/common/info/a:B	Landroid/content/Context;
    //   28: invokestatic 427	com/tencent/bugly/crashreport/common/info/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   31: putfield 101	com/tencent/bugly/crashreport/common/info/a:H	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 101	com/tencent/bugly/crashreport/common/info/a:H	Ljava/lang/String;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   11	28	1	str	String
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	42	finally
    //   16	34	42	finally
    //   34	39	42	finally
  }
  
  /* Error */
  public final String i(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +51 -> 56
    //   8: aload_1
    //   9: invokevirtual 339	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 342	java/lang/String:length	()I
    //   15: ifle +41 -> 56
    //   18: iload_2
    //   19: ifeq +42 -> 61
    //   22: ldc_w 426
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: new 234	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 346	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -40 -> 18
    //   61: aload_0
    //   62: getfield 152	com/tencent/bugly/crashreport/common/info/a:aa	Ljava/util/Map;
    //   65: aload_1
    //   66: invokeinterface 275 2 0
    //   71: checkcast 277	java/lang/String
    //   74: astore_1
    //   75: goto -23 -> 52
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   0	83	1	paramString	String
    //   1	57	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   8	18	78	finally
    //   22	50	78	finally
    //   61	75	78	finally
  }
  
  /* Error */
  public final String j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/tencent/bugly/crashreport/common/info/a:R	Z
    //   6: ifne +10 -> 16
    //   9: ldc 97
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 103	com/tencent/bugly/crashreport/common/info/a:I	Ljava/lang/String;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 200	com/tencent/bugly/crashreport/common/info/a:B	Landroid/content/Context;
    //   28: invokestatic 429	com/tencent/bugly/crashreport/common/info/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   31: putfield 103	com/tencent/bugly/crashreport/common/info/a:I	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 103	com/tencent/bugly/crashreport/common/info/a:I	Ljava/lang/String;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   11	28	1	str	String
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	42	finally
    //   16	34	42	finally
    //   34	39	42	finally
  }
  
  /* Error */
  public final String k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/tencent/bugly/crashreport/common/info/a:R	Z
    //   6: ifne +10 -> 16
    //   9: ldc 97
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 105	com/tencent/bugly/crashreport/common/info/a:J	Ljava/lang/String;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 200	com/tencent/bugly/crashreport/common/info/a:B	Landroid/content/Context;
    //   28: invokestatic 431	com/tencent/bugly/crashreport/common/info/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   31: putfield 105	com/tencent/bugly/crashreport/common/info/a:J	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 105	com/tencent/bugly/crashreport/common/info/a:J	Ljava/lang/String;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   11	28	1	str	String
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	42	finally
    //   16	34	42	finally
    //   34	39	42	finally
  }
  
  /* Error */
  public final String l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/tencent/bugly/crashreport/common/info/a:R	Z
    //   6: ifne +10 -> 16
    //   9: ldc 97
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 107	com/tencent/bugly/crashreport/common/info/a:K	Ljava/lang/String;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 200	com/tencent/bugly/crashreport/common/info/a:B	Landroid/content/Context;
    //   28: invokestatic 432	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   31: putfield 107	com/tencent/bugly/crashreport/common/info/a:K	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 107	com/tencent/bugly/crashreport/common/info/a:K	Ljava/lang/String;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   11	28	1	str	String
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	42	finally
    //   16	34	42	finally
    //   34	39	42	finally
  }
  
  public final long m()
  {
    try
    {
      if (this.L <= 0L) {
        this.L = b.e();
      }
      long l1 = this.L;
      return l1;
    }
    finally {}
  }
  
  public final long n()
  {
    try
    {
      if (this.M <= 0L) {
        this.M = b.g();
      }
      long l1 = this.M;
      return l1;
    }
    finally {}
  }
  
  public final long o()
  {
    try
    {
      if (this.N <= 0L) {
        this.N = b.i();
      }
      long l1 = this.N;
      return l1;
    }
    finally {}
  }
  
  public final String p()
  {
    try
    {
      if (this.O == null) {
        this.O = b.d();
      }
      String str = this.O;
      return str;
    }
    finally {}
  }
  
  public final String q()
  {
    if (this.P == null) {}
    synchronized (this.ai)
    {
      if (this.P == null) {
        this.P = b.g(this.B);
      }
      return this.P;
    }
  }
  
  public final void r()
  {
    try
    {
      Object localObject2 = this.B.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject2).isEmpty()) {
        synchronized (this.aj)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
              try
              {
                this.ac.put(localEntry1.getKey(), localEntry1.getValue().toString());
              }
              catch (Throwable localThrowable2)
              {
                v.a(localThrowable2);
              }
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      Iterator localIterator;
      Map.Entry localEntry2;
      return;
    }
    catch (Throwable localThrowable1)
    {
      v.a(localThrowable1);
      for (;;)
      {
        if (this.ac.isEmpty()) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localIterator = this.ac.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry2 = (Map.Entry)localIterator.next();
          localStringBuilder.append("[");
          localStringBuilder.append((String)localEntry2.getKey());
          localStringBuilder.append(",");
          localStringBuilder.append((String)localEntry2.getValue());
          localStringBuilder.append("] ");
        }
      }
      b("SDK_INFO", localStringBuilder.toString());
    }
  }
  
  public final String s()
  {
    if (this.ag == null) {
      this.ag = AppInfo.e(this.B);
    }
    return this.ag;
  }
  
  /* Error */
  public final Map<String, PlugInBean> t()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   13: invokeinterface 354 1 0
    //   18: istore_2
    //   19: iload_2
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: new 149	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   37: invokeinterface 354 1 0
    //   42: invokespecial 501	java/util/HashMap:<init>	(I)V
    //   45: astore_1
    //   46: aload_1
    //   47: aload_0
    //   48: getfield 121	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/util/Map;
    //   51: invokeinterface 504 2 0
    //   56: goto -31 -> 25
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   24	23	1	localObject1	Object
    //   59	4	1	localObject2	Object
    //   18	2	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	19	59	finally
    //   29	56	59	finally
  }
  
  public final String u()
  {
    if (this.S == null) {
      this.S = b.k();
    }
    return this.S;
  }
  
  public final Boolean v()
  {
    try
    {
      if (this.U == null) {
        this.U = Boolean.valueOf(b.h(this.B));
      }
      Boolean localBoolean = this.U;
      return localBoolean;
    }
    finally {}
  }
  
  public final String w()
  {
    try
    {
      if (this.V == null)
      {
        this.V = b.f(this.B);
        v.a("rom:%s", new Object[] { this.V });
      }
      String str = this.V;
      return str;
    }
    finally {}
  }
  
  /* Error */
  public final Map<String, String> x()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	com/tencent/bugly/crashreport/common/info/a:aa	Ljava/util/Map;
    //   6: invokeinterface 354 1 0
    //   11: istore_2
    //   12: iload_2
    //   13: ifgt +9 -> 22
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 149	java/util/HashMap
    //   25: dup
    //   26: aload_0
    //   27: getfield 152	com/tencent/bugly/crashreport/common/info/a:aa	Ljava/util/Map;
    //   30: invokespecial 357	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   33: astore_1
    //   34: goto -16 -> 18
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	a
    //   17	17	1	localObject1	Object
    //   37	4	1	localObject2	Object
    //   11	2	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	12	37	finally
    //   22	34	37	finally
  }
  
  public final int y()
  {
    try
    {
      int i1 = this.aa.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Set<String> z()
  {
    try
    {
      Set localSet = this.aa.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */