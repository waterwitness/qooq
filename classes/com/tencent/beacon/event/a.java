package com.tencent.beacon.event;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String g = "INSTALL_UPLOADED_DENGTA";
  private static String h = "USEAPP_UPLOADED_DENGTA";
  private Context a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private int e = 180;
  private String f = "N";
  private List<com.tencent.beacon.a.a.b> i = null;
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      a.a(a.this);
    }
  };
  private Runnable k = new Runnable()
  {
    public final void run()
    {
      a.b(a.this);
    }
  };
  private Runnable l = new Runnable()
  {
    public final void run()
    {
      a.c(a.this);
    }
  };
  
  public a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.a = paramContext;
    this.c = paramBoolean1;
    this.b = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramInt;
    paramContext = n.a();
    if (paramContext != null) {
      this.f = paramContext.r();
    }
    if (this.c)
    {
      paramContext = com.tencent.beacon.a.b.b(this.a, g, "");
      if (("".equals(paramContext)) || (!f.n().equals(paramContext))) {
        break label204;
      }
      com.tencent.beacon.d.a.a("installApp list has been uploaded today! " + paramContext, new Object[0]);
    }
    for (;;)
    {
      if (this.b)
      {
        c.a().a(this.k, 60000L);
        a(true);
      }
      return;
      label204:
      c.a().a(this.j, 60000L);
    }
  }
  
  private List<com.tencent.beacon.a.a.b> b(boolean paramBoolean)
  {
    if (this.a == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = (ActivityManager)this.a.getSystemService("activity");
        if (localObject1 == null) {
          break;
        }
        Object localObject3 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          continue;
        }
        localObject1 = new ArrayList();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        try
        {
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
          if ((localRunningAppProcessInfo.processName.startsWith("android")) || (localRunningAppProcessInfo.processName.startsWith("com.android."))) {
            continue;
          }
          if (localRunningAppProcessInfo.uid >= 10000) {
            continue;
          }
        }
        catch (Exception localException2) {}
        com.tencent.beacon.a.a.b localb = new com.tencent.beacon.a.a.b();
        localb.b = localRunningAppProcessInfo.processName;
        localb.c = localRunningAppProcessInfo.pid;
        localb.d = bool;
        ((List)localObject1).add(localb);
        continue;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2 = null;
        continue;
        continue;
        localObject2 = null;
        continue;
        bool = true;
      }
      return (List<com.tencent.beacon.a.a.b>)localObject1;
      boolean bool = false;
      if (bool) {
        if (!paramBoolean) {}
      }
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  private List<String> c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/beacon/event/a:a	Landroid/content/Context;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 71	com/tencent/beacon/event/a:a	Landroid/content/Context;
    //   13: invokevirtual 287	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull -11 -> 7
    //   21: aload_2
    //   22: iconst_0
    //   23: invokevirtual 293	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -21 -> 7
    //   31: aload_3
    //   32: invokeinterface 139 1 0
    //   37: ifle -30 -> 7
    //   40: new 205	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 206	java/util/ArrayList:<init>	()V
    //   47: astore_2
    //   48: aload_3
    //   49: invokeinterface 210 1 0
    //   54: astore_3
    //   55: aload_3
    //   56: invokeinterface 216 1 0
    //   61: ifeq +211 -> 272
    //   64: aload_3
    //   65: invokeinterface 220 1 0
    //   70: checkcast 295	android/content/pm/PackageInfo
    //   73: astore 4
    //   75: aload 4
    //   77: getfield 299	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   80: getfield 304	android/content/pm/ApplicationInfo:flags	I
    //   83: iconst_1
    //   84: iand
    //   85: ifne +204 -> 289
    //   88: iconst_1
    //   89: istore 6
    //   91: goto +183 -> 274
    //   94: new 100	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: ldc_w 263
    //   108: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 5
    //   114: aload 4
    //   116: getfield 307	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 263
    //   125: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: aload 4
    //   133: getfield 310	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   136: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 263
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 5
    //   148: aload 4
    //   150: getfield 313	android/content/pm/PackageInfo:versionCode	I
    //   153: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 263
    //   159: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: getstatic 318	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   166: invokestatic 324	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   169: bipush 9
    //   171: if_icmpge +49 -> 220
    //   174: aload 5
    //   176: ldc_w 263
    //   179: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: ldc_w 263
    //   188: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: iload 6
    //   194: ifeq +63 -> 257
    //   197: aload 5
    //   199: ldc 54
    //   201: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: aload 5
    //   208: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokeinterface 250 2 0
    //   216: pop
    //   217: goto -162 -> 55
    //   220: aload 5
    //   222: aload 4
    //   224: getfield 328	android/content/pm/PackageInfo:firstInstallTime	J
    //   227: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc_w 263
    //   233: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 5
    //   239: aload 4
    //   241: getfield 334	android/content/pm/PackageInfo:lastUpdateTime	J
    //   244: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   247: ldc_w 263
    //   250: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: goto -62 -> 192
    //   257: aload 5
    //   259: ldc_w 261
    //   262: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: goto -61 -> 205
    //   269: astore_2
    //   270: aconst_null
    //   271: areturn
    //   272: aload_2
    //   273: areturn
    //   274: iload_1
    //   275: ifne -181 -> 94
    //   278: iload 6
    //   280: ifeq -225 -> 55
    //   283: goto -189 -> 94
    //   286: astore_3
    //   287: aload_2
    //   288: areturn
    //   289: iconst_0
    //   290: istore 6
    //   292: goto -18 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	a
    //   0	295	1	paramBoolean	boolean
    //   16	190	2	localObject1	Object
    //   269	19	2	localException1	Exception
    //   26	39	3	localObject2	Object
    //   286	1	3	localException2	Exception
    //   73	167	4	localPackageInfo	android.content.pm.PackageInfo
    //   101	157	5	localStringBuilder	StringBuilder
    //   89	202	6	m	int
    // Exception table:
    //   from	to	target	type
    //   9	17	269	java/lang/Exception
    //   21	27	269	java/lang/Exception
    //   31	48	269	java/lang/Exception
    //   48	55	286	java/lang/Exception
    //   55	88	286	java/lang/Exception
    //   94	192	286	java/lang/Exception
    //   197	205	286	java/lang/Exception
    //   205	217	286	java/lang/Exception
    //   220	254	286	java/lang/Exception
    //   257	266	286	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c.a().a(110, this.l, this.e * 1000, this.e * 1000);
      return;
    }
    c.a().a(110);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\event\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */