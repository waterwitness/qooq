package com.tencent.bugly.proguard;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public final class w
{
  public static boolean a;
  private static SimpleDateFormat b = null;
  private static int c;
  private static StringBuilder d;
  private static StringBuilder e;
  private static a f;
  private static String g;
  private static String h;
  private static Context i;
  private static String j;
  private static boolean k;
  private static int l;
  private static Object m;
  private static Object n;
  private static Method o;
  
  static
  {
    a = true;
    c = 5120;
    m = new Object();
    n = null;
    o = null;
    try
    {
      b = new SimpleDateFormat("MM-dd HH:mm:ss");
      o = Class.forName("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler").getDeclaredMethod("appendLogToNative", new Class[] { String.class, String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(int paramInt)
  {
    synchronized (m)
    {
      c = paramInt;
      if (paramInt < 0) {
        c = 0;
      }
      while (paramInt <= 10240) {
        return;
      }
      c = 10240;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/bugly/proguard/w:k	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: getstatic 40	com/tencent/bugly/proguard/w:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +7 -> 25
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 85	java/lang/StringBuilder
    //   28: dup
    //   29: iconst_0
    //   30: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   33: putstatic 89	com/tencent/bugly/proguard/w:e	Ljava/lang/StringBuilder;
    //   36: new 85	java/lang/StringBuilder
    //   39: dup
    //   40: iconst_0
    //   41: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   44: putstatic 91	com/tencent/bugly/proguard/w:d	Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: putstatic 93	com/tencent/bugly/proguard/w:i	Landroid/content/Context;
    //   51: aload_0
    //   52: invokestatic 98	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   55: astore_0
    //   56: aload_0
    //   57: getfield 100	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   60: putstatic 102	com/tencent/bugly/proguard/w:g	Ljava/lang/String;
    //   63: aload_0
    //   64: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   67: pop
    //   68: ldc 108
    //   70: putstatic 110	com/tencent/bugly/proguard/w:h	Ljava/lang/String;
    //   73: new 85	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 93	com/tencent/bugly/proguard/w:i	Landroid/content/Context;
    //   83: invokevirtual 117	android/content/Context:getFilesDir	()Ljava/io/File;
    //   86: invokevirtual 123	java/io/File:getPath	()Ljava/lang/String;
    //   89: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc -127
    //   94: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: getstatic 102	com/tencent/bugly/proguard/w:g	Ljava/lang/String;
    //   100: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc -125
    //   105: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 110	com/tencent/bugly/proguard/w:h	Ljava/lang/String;
    //   111: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc -123
    //   116: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: putstatic 138	com/tencent/bugly/proguard/w:j	Ljava/lang/String;
    //   125: invokestatic 144	android/os/Process:myPid	()I
    //   128: putstatic 146	com/tencent/bugly/proguard/w:l	I
    //   131: iconst_1
    //   132: putstatic 83	com/tencent/bugly/proguard/w:k	Z
    //   135: goto -114 -> 21
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	138	finally
    //   13	17	138	finally
    //   25	131	138	finally
    //   131	135	138	finally
    //   25	131	144	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String arg0, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/bugly/proguard/w:k	Z
    //   6: ifeq +13 -> 19
    //   9: getstatic 40	com/tencent/bugly/proguard/w:a	Z
    //   12: istore 5
    //   14: iload 5
    //   16: ifne +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: invokestatic 150	com/tencent/bugly/proguard/w:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   29: pop
    //   30: invokestatic 153	android/os/Process:myTid	()I
    //   33: istore 4
    //   35: getstatic 91	com/tencent/bugly/proguard/w:d	Ljava/lang/StringBuilder;
    //   38: iconst_0
    //   39: invokevirtual 156	java/lang/StringBuilder:setLength	(I)V
    //   42: aload_2
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 159	java/lang/String:length	()I
    //   48: sipush 30720
    //   51: if_icmple +22 -> 73
    //   54: aload_2
    //   55: aload_2
    //   56: invokevirtual 159	java/lang/String:length	()I
    //   59: sipush 30720
    //   62: isub
    //   63: aload_2
    //   64: invokevirtual 159	java/lang/String:length	()I
    //   67: iconst_1
    //   68: isub
    //   69: invokevirtual 163	java/lang/String:substring	(II)Ljava/lang/String;
    //   72: astore_3
    //   73: new 165	java/util/Date
    //   76: dup
    //   77: invokespecial 166	java/util/Date:<init>	()V
    //   80: astore_2
    //   81: getstatic 38	com/tencent/bugly/proguard/w:b	Ljava/text/SimpleDateFormat;
    //   84: ifnull +131 -> 215
    //   87: getstatic 38	com/tencent/bugly/proguard/w:b	Ljava/text/SimpleDateFormat;
    //   90: aload_2
    //   91: invokevirtual 170	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   94: astore_2
    //   95: getstatic 91	com/tencent/bugly/proguard/w:d	Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc -84
    //   104: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: getstatic 146	com/tencent/bugly/proguard/w:l	I
    //   110: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc -84
    //   115: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc -84
    //   125: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc -84
    //   134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc -79
    //   143: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc -77
    //   152: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: getstatic 91	com/tencent/bugly/proguard/w:d	Ljava/lang/StringBuilder;
    //   159: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_1
    //   163: getstatic 47	com/tencent/bugly/proguard/w:m	Ljava/lang/Object;
    //   166: astore_0
    //   167: aload_0
    //   168: monitorenter
    //   169: getstatic 89	com/tencent/bugly/proguard/w:e	Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: monitorexit
    //   179: getstatic 89	com/tencent/bugly/proguard/w:e	Ljava/lang/StringBuilder;
    //   182: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   185: getstatic 42	com/tencent/bugly/proguard/w:c	I
    //   188: if_icmple -169 -> 19
    //   191: invokestatic 185	com/tencent/bugly/proguard/u:a	()Lcom/tencent/bugly/proguard/u;
    //   194: new 6	com/tencent/bugly/proguard/w$1
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 186	com/tencent/bugly/proguard/w$1:<init>	(Ljava/lang/String;)V
    //   202: invokevirtual 189	com/tencent/bugly/proguard/u:a	(Ljava/lang/Runnable;)Z
    //   205: pop
    //   206: goto -187 -> 19
    //   209: astore_0
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    //   215: aload_2
    //   216: invokevirtual 190	java/util/Date:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: goto -125 -> 95
    //   223: astore_1
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	1	paramString2	String
    //   0	228	2	paramString3	String
    //   43	104	3	str	String
    //   33	86	4	i1	int
    //   12	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	14	209	finally
    //   23	42	209	finally
    //   44	73	209	finally
    //   73	95	209	finally
    //   95	169	209	finally
    //   179	206	209	finally
    //   215	220	209	finally
    //   224	228	209	finally
    //   169	179	223	finally
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    Object localObject2 = paramThrowable.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = new StringBuilder().append((String)localObject1).append('\n');
    if (paramThrowable == null) {}
    for (paramThrowable = "";; paramThrowable = ((StringWriter)localObject2).toString())
    {
      a(paramString1, paramString2, paramThrowable);
      return;
      localObject2 = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject2);
      paramThrowable.printStackTrace(localPrintWriter);
      localPrintWriter.flush();
    }
  }
  
  /* Error */
  public static byte[] a(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/bugly/proguard/w:a	Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: getstatic 47	com/tencent/bugly/proguard/w:m	Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_0
    //   15: ifeq +49 -> 64
    //   18: getstatic 78	com/tencent/bugly/proguard/w:f	Lcom/tencent/bugly/proguard/w$a;
    //   21: ifnull +43 -> 64
    //   24: getstatic 78	com/tencent/bugly/proguard/w:f	Lcom/tencent/bugly/proguard/w$a;
    //   27: invokestatic 219	com/tencent/bugly/proguard/w$a:d	(Lcom/tencent/bugly/proguard/w$a;)Z
    //   30: ifeq +34 -> 64
    //   33: getstatic 78	com/tencent/bugly/proguard/w:f	Lcom/tencent/bugly/proguard/w$a;
    //   36: invokestatic 222	com/tencent/bugly/proguard/w$a:a	(Lcom/tencent/bugly/proguard/w$a;)Ljava/io/File;
    //   39: astore_1
    //   40: getstatic 89	com/tencent/bugly/proguard/w:e	Ljava/lang/StringBuilder;
    //   43: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +21 -> 69
    //   51: aload_1
    //   52: ifnonnull +17 -> 69
    //   55: aload_2
    //   56: monitorexit
    //   57: aconst_null
    //   58: areturn
    //   59: astore_1
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -26 -> 40
    //   69: aload_1
    //   70: getstatic 89	com/tencent/bugly/proguard/w:e	Ljava/lang/StringBuilder;
    //   73: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 227	com/tencent/bugly/proguard/a:a	(Ljava/io/File;Ljava/lang/String;)[B
    //   79: astore_1
    //   80: aload_2
    //   81: monitorexit
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_2
    //   86: monitorexit
    //   87: aconst_null
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramBoolean	boolean
    //   39	13	1	localFile	File
    //   59	4	1	localObject1	Object
    //   65	18	1	localObject2	Object
    //   84	1	1	localThrowable	Throwable
    //   11	75	2	localObject3	Object
    //   46	2	3	i1	int
    // Exception table:
    //   from	to	target	type
    //   18	40	59	finally
    //   40	47	59	finally
    //   55	57	59	finally
    //   69	80	59	finally
    //   80	82	59	finally
    //   18	40	84	java/lang/Throwable
    //   40	47	84	java/lang/Throwable
    //   69	80	84	java/lang/Throwable
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (o == null) {
      return false;
    }
    if (n == null)
    {
      Object localObject = a.a("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler", "getInstance", null, null, null);
      n = localObject;
      if (localObject == null) {
        return false;
      }
    }
    try
    {
      boolean bool = ((Boolean)o.invoke(n, new Object[] { paramString1, paramString2, paramString3 })).booleanValue();
      return bool;
    }
    catch (Throwable paramString1)
    {
      Log.w(v.b, paramString1.getMessage());
    }
    return false;
  }
  
  public static final class a
  {
    private boolean a;
    private File b;
    private String c;
    private long d;
    private long e = 30720L;
    
    public a(String paramString)
    {
      if ((paramString == null) || (paramString.equals(""))) {
        return;
      }
      this.c = paramString;
      this.a = a();
    }
    
    private boolean a()
    {
      boolean bool = false;
      try
      {
        this.b = new File(this.c);
        if ((this.b.exists()) && (!this.b.delete())) {}
        for (this.a = false;; this.a = false)
        {
          return bool;
          if (this.b.createNewFile()) {
            break;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.a = false;
          bool = true;
        }
      }
      finally {}
    }
    
    /* Error */
    public final boolean a(String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aload_0
      //   4: monitorenter
      //   5: aload_0
      //   6: getfield 39	com/tencent/bugly/proguard/w$a:a	Z
      //   9: istore 6
      //   11: iload 6
      //   13: ifne +8 -> 21
      //   16: aload_0
      //   17: monitorexit
      //   18: iload 5
      //   20: ireturn
      //   21: new 63	java/io/FileOutputStream
      //   24: dup
      //   25: aload_0
      //   26: getfield 43	com/tencent/bugly/proguard/w$a:b	Ljava/io/File;
      //   29: iconst_1
      //   30: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   33: astore_2
      //   34: aload_1
      //   35: ldc 68
      //   37: invokevirtual 72	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   40: astore_1
      //   41: aload_2
      //   42: aload_1
      //   43: invokevirtual 76	java/io/FileOutputStream:write	([B)V
      //   46: aload_2
      //   47: invokevirtual 79	java/io/FileOutputStream:flush	()V
      //   50: aload_2
      //   51: invokevirtual 82	java/io/FileOutputStream:close	()V
      //   54: aload_0
      //   55: getfield 84	com/tencent/bugly/proguard/w$a:d	J
      //   58: lstore_3
      //   59: aload_0
      //   60: aload_1
      //   61: arraylength
      //   62: i2l
      //   63: lload_3
      //   64: ladd
      //   65: putfield 84	com/tencent/bugly/proguard/w$a:d	J
      //   68: iconst_1
      //   69: istore 5
      //   71: goto -55 -> 16
      //   74: astore_1
      //   75: aload_0
      //   76: iconst_0
      //   77: putfield 39	com/tencent/bugly/proguard/w$a:a	Z
      //   80: goto -64 -> 16
      //   83: astore_1
      //   84: aload_0
      //   85: monitorexit
      //   86: aload_1
      //   87: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	a
      //   0	88	1	paramString	String
      //   33	18	2	localFileOutputStream	java.io.FileOutputStream
      //   58	6	3	l	long
      //   1	69	5	bool1	boolean
      //   9	3	6	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   21	68	74	java/lang/Throwable
      //   5	11	83	finally
      //   21	68	83	finally
      //   75	80	83	finally
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */