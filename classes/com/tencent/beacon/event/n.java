package com.tencent.beacon.event;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.d.c;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.regex.Pattern;

public final class n
{
  private static n a = null;
  private byte[] b = { 57, -16, 34, -64, -79, -74, 14, -78, 99, -60, -123, -111, -19, -95, -113, 96, -7, -35, -112, -117, 91, 86, 10, 68 };
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  
  private n(Context paramContext)
  {
    Object localObject = this.b;
    localObject = this.b;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    if (paramContext == null) {
      a.d(" UADeviceInfo context == null? pls check!", new Object[0]);
    }
    a.b(" start to create UADeviceInfo", new Object[0]);
    long l1 = System.currentTimeMillis();
    f.a(paramContext);
    this.c = f.b();
    new StringBuilder().append(f.c()).toString();
    localObject = f.h(paramContext);
    if (localObject == null)
    {
      localObject = "";
      this.d = ((String)localObject);
      this.e = f.e();
      this.f = "";
      this.g = (f.f() + "m");
      this.h = (f.g() + "m");
      this.i = f.i();
      this.j = f.j();
      this.k = f.j(paramContext);
      this.l = f.k();
      this.m = c(paramContext);
      this.n = (t() + "m");
      this.o = v();
      this.p = s();
      if (!u()) {
        break label690;
      }
      localObject = "Y";
      label599:
      this.q = ((String)localObject);
      this.r = d(paramContext);
      if (!c.a().b()) {
        break label696;
      }
    }
    label690:
    label696:
    for (paramContext = "Y";; paramContext = "N")
    {
      this.s = paramContext;
      a.b(" detail create cost： %d  values:\n %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), toString() });
      return;
      localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
      break;
      localObject = "N";
      break label599;
    }
  }
  
  public static n a()
  {
    try
    {
      n localn = a;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new n(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String b(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    if (paramContext == null) {
      return "N";
    }
    paramContext = paramContext.getAllProviders();
    if (paramContext == null) {
      return "N";
    }
    if (paramContext.contains("gps")) {
      return "Y";
    }
    return "N";
  }
  
  private static int c(Context paramContext)
  {
    if (paramContext == null) {
      return 160;
    }
    for (;;)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (localDisplayMetrics.density == 1.0F) {
          break;
        }
        if (localDisplayMetrics.density <= 0.75D) {
          return 120;
        }
        if (localDisplayMetrics.density == 1.5D) {
          return 240;
        }
        if (localDisplayMetrics.density == 2.0D) {
          return 320;
        }
        float f1 = localDisplayMetrics.density;
        if (f1 == 3.0D)
        {
          i1 = 480;
          return i1;
        }
      }
      catch (Throwable paramContext)
      {
        a.a(paramContext);
        return 160;
      }
      int i1 = 160;
    }
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null)
    {
      a.d("getSensor2 but context == null!", new Object[0]);
      return null;
    }
    a.a("getSensor2 start", new Object[0]);
    Object localObject1 = "X";
    Object localObject2 = "X";
    Object localObject3 = "X";
    int i1;
    String str;
    label63:
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if ((WifiManager)paramContext.getSystemService("wifi") == null)
    {
      i1 = 0;
      if (i1 == 0) {
        break label228;
      }
      str = "Y";
      if (Integer.parseInt(Build.VERSION.SDK) < 10) {
        break label282;
      }
      localObject4 = localObject3;
      localObject6 = localObject2;
      localObject5 = localObject1;
    }
    for (;;)
    {
      try
      {
        SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(1) == null) {
          continue;
        }
        localObject1 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(5) == null) {
          break label301;
        }
        localObject2 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
          break label307;
        }
        localObject3 = "N";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
          continue;
        }
        localObject4 = "Y";
        paramContext = (Context)localObject3;
        localObject3 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject4;
      }
      catch (Throwable paramContext)
      {
        label228:
        localObject2 = localObject6;
        localObject3 = localObject5;
        a.d("getSensor2 error!", new Object[0]);
        localObject1 = localObject4;
        paramContext = "X";
        continue;
      }
      return str + (String)localObject3 + (String)localObject2 + (String)localObject1 + paramContext;
      i1 = 1;
      break;
      str = "N";
      break label63;
      localObject1 = "N";
      continue;
      paramContext = "N";
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      continue;
      label282:
      paramContext = "X";
      localObject1 = "X";
      localObject2 = "X";
      localObject3 = "X";
      continue;
      label301:
      localObject2 = "N";
      continue;
      label307:
      localObject3 = "Y";
    }
  }
  
  /* Error */
  private static String s()
  {
    // Byte code:
    //   0: ldc 65
    //   2: astore_2
    //   3: new 320	java/io/BufferedReader
    //   6: dup
    //   7: new 322	java/io/InputStreamReader
    //   10: dup
    //   11: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 330	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 332
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 334
    //   29: aastore
    //   30: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull +36 -> 89
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: ldc_w 355
    //   62: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq -22 -> 43
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: aload_3
    //   72: ldc_w 360
    //   75: invokevirtual 363	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   78: iconst_1
    //   79: iadd
    //   80: invokevirtual 367	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_1
    //   90: invokevirtual 373	java/io/BufferedReader:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   111: aload_2
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull -21 -> 93
    //   117: aload_1
    //   118: invokevirtual 373	java/io/BufferedReader:close	()V
    //   121: ldc 65
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   129: ldc 65
    //   131: areturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_3
    //   138: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull -51 -> 93
    //   147: aload_1
    //   148: invokevirtual 373	java/io/BufferedReader:close	()V
    //   151: ldc 65
    //   153: areturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   159: ldc 65
    //   161: areturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 373	java/io/BufferedReader:close	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: aload_0
    //   177: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   180: goto -7 -> 173
    //   183: astore_1
    //   184: goto -19 -> 165
    //   187: astore_3
    //   188: goto -53 -> 135
    //   191: astore_3
    //   192: goto -87 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	69	0	localObject1	Object
    //   124	2	0	localIOException1	java.io.IOException
    //   136	7	0	localObject2	Object
    //   154	2	0	localIOException2	java.io.IOException
    //   164	6	0	localObject3	Object
    //   175	2	0	localIOException3	java.io.IOException
    //   42	48	1	localBufferedReader	java.io.BufferedReader
    //   95	2	1	localIOException4	java.io.IOException
    //   104	44	1	localObject4	Object
    //   162	12	1	localObject5	Object
    //   183	1	1	localObject6	Object
    //   2	140	2	str1	String
    //   49	39	3	str2	String
    //   102	6	3	localIOException5	java.io.IOException
    //   132	6	3	localThrowable1	Throwable
    //   187	1	3	localThrowable2	Throwable
    //   191	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   3	43	102	java/io/IOException
    //   117	121	124	java/io/IOException
    //   3	43	132	java/lang/Throwable
    //   147	151	154	java/io/IOException
    //   3	43	162	finally
    //   169	173	175	java/io/IOException
    //   45	50	183	finally
    //   58	68	183	finally
    //   70	87	183	finally
    //   107	111	183	finally
    //   137	141	183	finally
    //   45	50	187	java/lang/Throwable
    //   58	68	187	java/lang/Throwable
    //   70	87	187	java/lang/Throwable
    //   45	50	191	java/io/IOException
    //   58	68	191	java/io/IOException
    //   70	87	191	java/io/IOException
  }
  
  /* Error */
  private static int t()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: new 320	java/io/BufferedReader
    //   12: dup
    //   13: new 322	java/io/InputStreamReader
    //   16: dup
    //   17: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: iconst_2
    //   21: anewarray 330	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 332
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc_w 375
    //   35: aastore
    //   36: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   39: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   42: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_0
    //   49: aload_0
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +17 -> 74
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   66: invokestatic 288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   69: sipush 1000
    //   72: idiv
    //   73: istore_3
    //   74: aload_0
    //   75: invokevirtual 373	java/io/BufferedReader:close	()V
    //   78: iload_3
    //   79: ireturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   85: iload_3
    //   86: ireturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: aload_2
    //   93: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   96: iload 4
    //   98: istore_3
    //   99: aload_0
    //   100: ifnull -22 -> 78
    //   103: aload_0
    //   104: invokevirtual 373	java/io/BufferedReader:close	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_1
    //   117: aload_2
    //   118: astore_0
    //   119: aload_1
    //   120: astore_2
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   127: iload 4
    //   129: istore_3
    //   130: aload_0
    //   131: ifnull -53 -> 78
    //   134: aload_0
    //   135: invokevirtual 373	java/io/BufferedReader:close	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 373	java/io/BufferedReader:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore_1
    //   159: aload_1
    //   160: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   163: goto -7 -> 156
    //   166: astore_0
    //   167: goto -19 -> 148
    //   170: astore_2
    //   171: goto -50 -> 121
    //   174: astore_2
    //   175: goto -85 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	27	0	localBufferedReader	java.io.BufferedReader
    //   80	2	0	localIOException1	java.io.IOException
    //   89	15	0	localObject1	Object
    //   109	2	0	localIOException2	java.io.IOException
    //   118	17	0	localIOException3	java.io.IOException
    //   140	2	0	localIOException4	java.io.IOException
    //   147	10	0	localObject2	Object
    //   166	1	0	localObject3	Object
    //   6	86	1	localObject4	Object
    //   116	4	1	localThrowable1	Throwable
    //   122	31	1	localObject5	Object
    //   158	2	1	localIOException5	java.io.IOException
    //   8	55	2	str	String
    //   87	31	2	localIOException6	java.io.IOException
    //   120	4	2	localThrowable2	Throwable
    //   170	1	2	localThrowable3	Throwable
    //   174	1	2	localIOException7	java.io.IOException
    //   4	126	3	i1	int
    //   1	127	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   9	49	87	java/io/IOException
    //   103	107	109	java/io/IOException
    //   9	49	116	java/lang/Throwable
    //   134	138	140	java/io/IOException
    //   9	49	147	finally
    //   123	127	147	finally
    //   152	156	158	java/io/IOException
    //   51	56	166	finally
    //   62	74	166	finally
    //   92	96	166	finally
    //   51	56	170	java/lang/Throwable
    //   62	74	170	java/lang/Throwable
    //   51	56	174	java/io/IOException
    //   62	74	174	java/io/IOException
  }
  
  /* Error */
  private static boolean u()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: new 320	java/io/BufferedReader
    //   13: dup
    //   14: new 322	java/io/InputStreamReader
    //   17: dup
    //   18: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   21: iconst_2
    //   22: anewarray 330	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 332
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc_w 334
    //   36: aastore
    //   37: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_0
    //   50: aload_0
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore_2
    //   57: iload 5
    //   59: istore 4
    //   61: aload_2
    //   62: ifnull +24 -> 86
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 378	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   71: ldc_w 380
    //   74: invokevirtual 363	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   77: istore_3
    //   78: iconst_m1
    //   79: iload_3
    //   80: if_icmpeq -30 -> 50
    //   83: iconst_1
    //   84: istore 4
    //   86: aload_0
    //   87: invokevirtual 373	java/io/BufferedReader:close	()V
    //   90: iload 4
    //   92: ireturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   98: iload 4
    //   100: ireturn
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   110: iload 6
    //   112: istore 4
    //   114: aload_0
    //   115: ifnull -25 -> 90
    //   118: aload_0
    //   119: invokevirtual 373	java/io/BufferedReader:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: aload_1
    //   135: astore_2
    //   136: aload_0
    //   137: astore_1
    //   138: aload_2
    //   139: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   142: iload 6
    //   144: istore 4
    //   146: aload_0
    //   147: ifnull -57 -> 90
    //   150: aload_0
    //   151: invokevirtual 373	java/io/BufferedReader:close	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_0
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 373	java/io/BufferedReader:close	()V
    //   172: aload_0
    //   173: athrow
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   179: goto -7 -> 172
    //   182: astore_0
    //   183: goto -19 -> 164
    //   186: astore_2
    //   187: goto -51 -> 136
    //   190: astore_2
    //   191: goto -87 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	38	0	localBufferedReader	java.io.BufferedReader
    //   93	2	0	localIOException1	java.io.IOException
    //   103	16	0	localObject1	Object
    //   124	2	0	localIOException2	java.io.IOException
    //   133	18	0	localIOException3	java.io.IOException
    //   156	2	0	localIOException4	java.io.IOException
    //   163	10	0	localObject2	Object
    //   182	1	0	localObject3	Object
    //   7	99	1	localObject4	Object
    //   131	4	1	localThrowable1	Throwable
    //   137	32	1	localObject5	Object
    //   174	2	1	localIOException5	java.io.IOException
    //   9	59	2	str	String
    //   101	32	2	localIOException6	java.io.IOException
    //   135	4	2	localThrowable2	Throwable
    //   186	1	2	localThrowable3	Throwable
    //   190	1	2	localIOException7	java.io.IOException
    //   77	4	3	i1	int
    //   59	86	4	bool1	boolean
    //   4	54	5	bool2	boolean
    //   1	142	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   86	90	93	java/io/IOException
    //   10	50	101	java/io/IOException
    //   118	122	124	java/io/IOException
    //   10	50	131	java/lang/Throwable
    //   150	154	156	java/io/IOException
    //   10	50	163	finally
    //   138	142	163	finally
    //   168	172	174	java/io/IOException
    //   52	57	182	finally
    //   67	78	182	finally
    //   106	110	182	finally
    //   52	57	186	java/lang/Throwable
    //   67	78	186	java/lang/Throwable
    //   52	57	190	java/io/IOException
    //   67	78	190	java/io/IOException
  }
  
  private static int v()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new a());
      if (arrayOfFile == null) {
        return 1;
      }
      int i1 = arrayOfFile.length;
      return i1;
    }
    catch (Exception localException)
    {
      a.d("CPU Count: Failed.", new Object[0]);
      a.a(localException);
    }
    return 1;
  }
  
  public final String b()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String c()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String e()
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
  
  public final String f()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String h()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String j()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String k()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String l()
  {
    return this.m;
  }
  
  public final String m()
  {
    return this.n;
  }
  
  public final String n()
  {
    return this.o;
  }
  
  public final String o()
  {
    return this.p;
  }
  
  public final String p()
  {
    return this.q;
  }
  
  public final String q()
  {
    return this.r;
  }
  
  public final String r()
  {
    return this.s;
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\event\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */