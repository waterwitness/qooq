package st;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class q
  extends d
{
  private static final DecimalFormat f = new DecimalFormat("0000000000");
  private static final DecimalFormat g = new DecimalFormat("0000000000000000");
  private static q h;
  x c;
  p d;
  String e;
  private String i;
  private String j;
  private final b k = new b((byte)0);
  private int l;
  private SharedPreferences m;
  private f n;
  private final Object o = new Object();
  private final d p = new d(this, (byte)0);
  private int q;
  
  private static String a(int paramInt, String paramString)
    throws Exception
  {
    if (paramString == null) {
      throw new Exception("OnlineModule: null device id, type: " + paramInt);
    }
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + g.format(l1 + l2);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      throw new Exception("OnlineModule: invalid device id, type: " + paramInt);
    }
  }
  
  private static String a(Long paramLong)
    throws Exception
  {
    if (paramLong == null) {
      throw new Exception("OnlineModule: null source id");
    }
    try
    {
      paramLong = f.format(paramLong);
      return paramLong;
    }
    catch (NumberFormatException paramLong)
    {
      paramLong.printStackTrace();
      throw new Exception("OnlineModule: invalid source id");
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      throw new Exception("OnlineModule: recover plain data upload reply: null arg");
    }
    try
    {
      paramArrayOfByte = b.1.b(i.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new Exception("the RawReply decompress failed");
    }
  }
  
  private static f a(String paramString, long paramLong)
    throws Exception
  {
    long l1;
    try
    {
      paramString = new JSONObject(paramString);
      int i1 = paramString.optInt("errorcode", -5);
      if (i1 != 0) {
        return new f(i1, null, null, (byte)0);
      }
      l1 = paramString.optLong("hitarea", 0L);
      paramString = new String(Base64.decode(paramString.optString("swdata", null), 0), "UTF-8");
      bool = w.f;
      if ((paramString.length() <= g.a) || (!paramString.startsWith("$UP,"))) {
        throw new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
      }
    }
    catch (Exception paramString)
    {
      boolean bool = w.f;
      throw new Exception("parse json data error");
    }
    switch (paramString.charAt(g.a))
    {
    default: 
    case '1': 
      do
      {
        throw new Exception("OnlineModule: unable to parse data upload reply");
      } while (paramString.length() <= g.b);
      paramString = b(paramString.substring(g.b), l1);
      paramString.g = paramLong;
      return new f(1, paramString, null, (byte)0);
    case '0': 
      if (paramString.length() > g.b) {}
      for (paramString = paramString.substring(g.b);; paramString = null) {
        return new f(0, null, paramString, (byte)0);
      }
    case '2': 
      if (paramString.length() > g.b) {}
      for (paramString = paramString.substring(g.b);; paramString = null) {
        return new f(2, null, paramString, (byte)0);
      }
    case '3': 
      if (paramString.length() > g.b) {}
      for (paramString = paramString.substring(g.b);; paramString = null) {
        return new f(3, null, paramString, (byte)0);
      }
    case '4': 
      if (paramString.length() > g.b) {}
      for (paramString = paramString.substring(g.b);; paramString = null) {
        return new f(4, null, paramString, (byte)0);
      }
    case '5': 
      if (paramString.length() > g.b) {}
      for (paramString = paramString.substring(g.b);; paramString = null) {
        return new f(5, null, paramString, (byte)0);
      }
    }
    if (paramString.length() > g.b) {}
    for (paramString = paramString.substring(g.b);; paramString = null) {
      return new f(6, null, paramString, (byte)0);
    }
  }
  
  static q b()
  {
    if (h == null) {
      h = new q();
    }
    return h;
  }
  
  /* Error */
  private static v b(String paramString, long paramLong)
    throws Exception
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_0
    //   4: ifnull +195 -> 199
    //   7: aload_0
    //   8: ldc_w 339
    //   11: iconst_m1
    //   12: invokevirtual 343	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   15: astore_0
    //   16: aload_0
    //   17: arraylength
    //   18: bipush 10
    //   20: if_icmpne +179 -> 199
    //   23: aload_0
    //   24: iconst_0
    //   25: aaload
    //   26: invokestatic 349	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   29: dstore_3
    //   30: aload_0
    //   31: iconst_1
    //   32: aaload
    //   33: invokestatic 349	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   36: dstore 5
    //   38: aload_0
    //   39: bipush 8
    //   41: aaload
    //   42: invokestatic 355	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   45: fstore 7
    //   47: aload_0
    //   48: iconst_3
    //   49: aaload
    //   50: invokestatic 361	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   53: istore 9
    //   55: aload_0
    //   56: iconst_4
    //   57: aaload
    //   58: invokestatic 361	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: pop
    //   62: aload_0
    //   63: iconst_5
    //   64: aaload
    //   65: invokestatic 361	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: pop
    //   69: aload_0
    //   70: bipush 7
    //   72: aaload
    //   73: invokestatic 361	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: istore 11
    //   78: iload 11
    //   80: istore 10
    //   82: aload_0
    //   83: bipush 9
    //   85: aaload
    //   86: invokestatic 355	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   89: pop
    //   90: new 224	st/v
    //   93: dup
    //   94: invokespecial 362	st/v:<init>	()V
    //   97: astore 8
    //   99: aload 8
    //   101: dload_3
    //   102: putfield 365	st/v:a	D
    //   105: aload 8
    //   107: dload 5
    //   109: putfield 367	st/v:b	D
    //   112: aload 8
    //   114: iload 9
    //   116: putfield 368	st/v:c	I
    //   119: aload 8
    //   121: aload_0
    //   122: bipush 6
    //   124: aaload
    //   125: putfield 369	st/v:e	Ljava/lang/String;
    //   128: aload 8
    //   130: iload 10
    //   132: putfield 371	st/v:i	I
    //   135: aload 8
    //   137: fload 7
    //   139: putfield 374	st/v:d	F
    //   142: aload 8
    //   144: getfield 377	st/v:f	Lst/v$a;
    //   147: ifnonnull +15 -> 162
    //   150: aload 8
    //   152: new 379	st/v$a
    //   155: dup
    //   156: invokespecial 380	st/v$a:<init>	()V
    //   159: putfield 377	st/v:f	Lst/v$a;
    //   162: aload 8
    //   164: lload_1
    //   165: putfield 382	st/v:h	J
    //   168: aload 8
    //   170: areturn
    //   171: astore 8
    //   173: aload 8
    //   175: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   178: iconst_0
    //   179: istore 9
    //   181: goto -126 -> 55
    //   184: astore 8
    //   186: aload 8
    //   188: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   191: goto -129 -> 62
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   199: new 81	java/lang/Exception
    //   202: dup
    //   203: ldc_w 384
    //   206: invokespecial 97	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   209: athrow
    //   210: astore 8
    //   212: aload 8
    //   214: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   217: goto -148 -> 69
    //   220: astore 8
    //   222: aload 8
    //   224: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   227: goto -145 -> 82
    //   230: astore 8
    //   232: aload 8
    //   234: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   237: goto -147 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramLong	long
    //   29	73	3	d1	double
    //   36	72	5	d2	double
    //   45	93	7	f1	float
    //   97	72	8	localv	v
    //   171	3	8	localNumberFormatException1	NumberFormatException
    //   184	3	8	localNumberFormatException2	NumberFormatException
    //   210	3	8	localNumberFormatException3	NumberFormatException
    //   220	3	8	localNumberFormatException4	NumberFormatException
    //   230	3	8	localNumberFormatException5	NumberFormatException
    //   53	127	9	i1	int
    //   1	130	10	i2	int
    //   76	3	11	i3	int
    // Exception table:
    //   from	to	target	type
    //   47	55	171	java/lang/NumberFormatException
    //   55	62	184	java/lang/NumberFormatException
    //   23	47	194	java/lang/NumberFormatException
    //   90	162	194	java/lang/NumberFormatException
    //   162	168	194	java/lang/NumberFormatException
    //   173	178	194	java/lang/NumberFormatException
    //   186	191	194	java/lang/NumberFormatException
    //   212	217	194	java/lang/NumberFormatException
    //   222	227	194	java/lang/NumberFormatException
    //   232	237	194	java/lang/NumberFormatException
    //   62	69	210	java/lang/NumberFormatException
    //   69	78	220	java/lang/NumberFormatException
    //   82	90	230	java/lang/NumberFormatException
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 73	st/q:o	Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: monitorenter
    //   12: aload_0
    //   13: invokespecial 323	st/q:i	()Landroid/content/SharedPreferences;
    //   16: ldc_w 325
    //   19: ldc_w 327
    //   22: invokeinterface 332 3 0
    //   27: astore_2
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   35: aload_2
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 193	java/lang/String:length	()I
    //   51: ldc_w 390
    //   54: isub
    //   55: istore 4
    //   57: aload_2
    //   58: astore_1
    //   59: iload 4
    //   61: ifle +28 -> 89
    //   64: aload_2
    //   65: ldc_w 392
    //   68: iload 4
    //   70: invokevirtual 395	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   73: istore 5
    //   75: iload 5
    //   77: iload 4
    //   79: if_icmplt +49 -> 128
    //   82: aload_2
    //   83: iload 5
    //   85: invokevirtual 219	java/lang/String:substring	(I)Ljava/lang/String;
    //   88: astore_1
    //   89: getstatic 400	android/os/Build$VERSION:SDK_INT	I
    //   92: bipush 9
    //   94: if_icmplt +41 -> 135
    //   97: aload_0
    //   98: invokespecial 323	st/q:i	()Landroid/content/SharedPreferences;
    //   101: invokeinterface 404 1 0
    //   106: ldc_w 325
    //   109: aload_1
    //   110: invokeinterface 410 3 0
    //   115: invokeinterface 413 1 0
    //   120: aload_3
    //   121: monitorexit
    //   122: return
    //   123: astore_1
    //   124: aload_3
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: ldc_w 327
    //   131: astore_1
    //   132: goto -43 -> 89
    //   135: aload_0
    //   136: invokespecial 323	st/q:i	()Landroid/content/SharedPreferences;
    //   139: invokeinterface 404 1 0
    //   144: ldc_w 325
    //   147: aload_1
    //   148: invokeinterface 410 3 0
    //   153: invokeinterface 416 1 0
    //   158: pop
    //   159: goto -39 -> 120
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   167: goto -47 -> 120
    //   170: astore_1
    //   171: getstatic 400	android/os/Build$VERSION:SDK_INT	I
    //   174: bipush 9
    //   176: if_icmplt +39 -> 215
    //   179: aload_0
    //   180: invokespecial 323	st/q:i	()Landroid/content/SharedPreferences;
    //   183: invokeinterface 404 1 0
    //   188: ldc_w 325
    //   191: ldc_w 327
    //   194: invokeinterface 410 3 0
    //   199: invokeinterface 413 1 0
    //   204: goto -84 -> 120
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   212: goto -92 -> 120
    //   215: aload_0
    //   216: invokespecial 323	st/q:i	()Landroid/content/SharedPreferences;
    //   219: invokeinterface 404 1 0
    //   224: ldc_w 325
    //   227: ldc_w 327
    //   230: invokeinterface 410 3 0
    //   235: invokeinterface 416 1 0
    //   240: pop
    //   241: goto -121 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	q
    //   0	244	1	paramString	String
    //   27	56	2	str	String
    //   55	25	4	i1	int
    //   73	11	5	i2	int
    // Exception table:
    //   from	to	target	type
    //   12	57	123	finally
    //   64	75	123	finally
    //   82	89	123	finally
    //   89	120	123	finally
    //   120	122	123	finally
    //   124	126	123	finally
    //   135	159	123	finally
    //   163	167	123	finally
    //   171	204	123	finally
    //   208	212	123	finally
    //   215	241	123	finally
    //   12	57	162	java/lang/Exception
    //   64	75	162	java/lang/Exception
    //   82	89	162	java/lang/Exception
    //   89	120	162	java/lang/Exception
    //   135	159	162	java/lang/Exception
    //   12	57	170	java/lang/Error
    //   64	75	170	java/lang/Error
    //   82	89	170	java/lang/Error
    //   89	120	170	java/lang/Error
    //   135	159	170	java/lang/Error
    //   171	204	207	java/lang/Exception
    //   215	241	207	java/lang/Exception
  }
  
  private static String c(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getDeviceId();
          return paramContext;
        }
        catch (Exception paramContext) {}
      }
    }
    return null;
  }
  
  private void c(String paramString, long paramLong)
  {
    Object localObject = null;
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.startsWith("&OD[]=")) {
        str = paramString;
      }
    }
    else
    {
      b(str);
      return;
    }
    paramString = b.1.b(b.1.c(paramString));
    if (paramString == null)
    {
      paramString = null;
      label44:
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramString = (String)localObject;; paramString = paramString.replace("&WD[]=", "|WD,"))
    {
      str = b.1.a(paramString, paramLong, "1");
      break;
      paramString = paramString.replace("&MD=", "|MD,");
      break label44;
    }
  }
  
  private static String d(Context paramContext)
    throws Exception
  {
    try
    {
      String str = a(0, c(paramContext));
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (paramContext != null) {}
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo();
          if (paramContext != null)
          {
            paramContext = paramContext.getMacAddress();
            if ((paramContext == null) || (paramContext.length() <= 0)) {}
          }
        }
        for (paramContext = b.1.a(paramContext);; paramContext = null)
        {
          paramContext = a(1, paramContext);
          return paramContext;
        }
        return a(1, "0");
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private String g()
  {
    try
    {
      String str = i().getString("1-115-10127", "");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  private void h()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        i().edit().remove("1-115-10127").apply();
        return;
      }
      i().edit().remove("1-115-10127").commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private SharedPreferences i()
    throws Exception
  {
    if (this.m == null) {
      throw new Exception("OnlineModule: data buffer unavailable");
    }
    return this.m;
  }
  
  private void j()
    throws Exception
  {
    String str3;
    b localb;
    try
    {
      String str1 = this.i;
      str3 = this.j;
      localb = this.k;
      if ((str1 == null) || (str3 == null)) {
        throw new Exception("OnlineModule: authenticate: null arg");
      }
    }
    finally {}
    System.arraycopy((str2 + str3).getBytes(), 0, localb.b, 0, 27);
    localb.a = 1;
  }
  
  final void a()
  {
    this.d = null;
  }
  
  final void a(Context paramContext)
  {
    try
    {
      this.i = d(paramContext);
      this.j = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.n = new f(paramContext);
      this.m = paramContext.getSharedPreferences("0-474-85242", 0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  final void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    this.c = x.a(paramHandler);
    c();
  }
  
  final void a(String paramString)
  {
    if (this.c != null) {
      this.c.a(new c(this, paramString, 0L, 1, (byte)0));
    }
  }
  
  final void b(Context paramContext) {}
  
  final void c()
  {
    if (this.c != null) {}
    try
    {
      this.c.a(d.a(this.p));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  final boolean f()
  {
    return this.k.a == 1;
  }
  
  static abstract class a
    implements Runnable
  {
    private final WeakReference<q> a;
    
    private a(q paramq)
    {
      this.a = new WeakReference(paramq);
    }
    
    final q a()
      throws Exception
    {
      q localq = (q)this.a.get();
      if (localq == null) {
        throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
      }
      return localq;
    }
  }
  
  static final class b
  {
    int a = -1;
    final byte[] b = new byte[27];
  }
  
  static final class c
    extends q.a
  {
    private final String a;
    private final long b;
    private final int c;
    
    private c(q paramq, String paramString, long paramLong, int paramInt)
    {
      super((byte)0);
      this.a = paramString;
      this.b = paramLong;
      this.c = paramInt;
    }
    
    public final void run()
    {
      try
      {
        switch (this.c)
        {
        case 0: 
          q.a(a(), this.a, this.b);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      q.a(a(), this.a);
      return;
    }
  }
  
  static final class d
    extends q.a
  {
    private boolean a;
    
    private d(q paramq)
    {
      super((byte)0);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 35	st/q$d:a	()Lst/q;
      //   4: invokestatic 37	st/q:a	(Lst/q;)V
      //   7: aload_0
      //   8: invokevirtual 35	st/q$d:a	()Lst/q;
      //   11: invokestatic 41	st/q:b	(Lst/q;)Lst/f;
      //   14: astore_2
      //   15: aload_2
      //   16: getstatic 47	android/os/Build:MODEL	Ljava/lang/String;
      //   19: putfield 52	st/f:l	Ljava/lang/String;
      //   22: aload_2
      //   23: getstatic 57	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
      //   26: putfield 60	st/f:m	Ljava/lang/String;
      //   29: aload_2
      //   30: aload_2
      //   31: getfield 64	st/f:e	Landroid/content/pm/PackageInfo;
      //   34: getfield 69	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
      //   37: putfield 72	st/f:j	Ljava/lang/String;
      //   40: aload_2
      //   41: getfield 75	st/f:a	Landroid/content/Context;
      //   44: invokevirtual 81	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
      //   47: aload_2
      //   48: getfield 84	st/f:d	Landroid/content/pm/PackageManager;
      //   51: invokevirtual 90	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   54: astore_1
      //   55: aload_1
      //   56: ifnull +143 -> 199
      //   59: aload_1
      //   60: invokevirtual 96	java/lang/Object:toString	()Ljava/lang/String;
      //   63: astore_1
      //   64: aload_2
      //   65: aload_1
      //   66: putfield 99	st/f:k	Ljava/lang/String;
      //   69: aload_2
      //   70: getfield 102	st/f:b	Landroid/telephony/TelephonyManager;
      //   73: ifnull +36 -> 109
      //   76: aload_2
      //   77: aload_2
      //   78: getfield 102	st/f:b	Landroid/telephony/TelephonyManager;
      //   81: invokevirtual 107	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
      //   84: putfield 110	st/f:f	Ljava/lang/String;
      //   87: aload_2
      //   88: aload_2
      //   89: getfield 102	st/f:b	Landroid/telephony/TelephonyManager;
      //   92: invokevirtual 113	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
      //   95: putfield 116	st/f:g	Ljava/lang/String;
      //   98: aload_2
      //   99: aload_2
      //   100: getfield 102	st/f:b	Landroid/telephony/TelephonyManager;
      //   103: invokevirtual 119	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
      //   106: putfield 122	st/f:h	Ljava/lang/String;
      //   109: aload_2
      //   110: getfield 126	st/f:c	Landroid/hardware/SensorManager;
      //   113: ifnull +80 -> 193
      //   116: aload_2
      //   117: getfield 126	st/f:c	Landroid/hardware/SensorManager;
      //   120: iconst_1
      //   121: invokevirtual 132	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
      //   124: astore_1
      //   125: aload_2
      //   126: getfield 126	st/f:c	Landroid/hardware/SensorManager;
      //   129: iconst_4
      //   130: invokevirtual 132	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
      //   133: astore_3
      //   134: aload_2
      //   135: getfield 126	st/f:c	Landroid/hardware/SensorManager;
      //   138: iconst_2
      //   139: invokevirtual 132	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
      //   142: astore 4
      //   144: aload_2
      //   145: getfield 126	st/f:c	Landroid/hardware/SensorManager;
      //   148: bipush 11
      //   150: invokevirtual 132	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
      //   153: astore 5
      //   155: aload_1
      //   156: ifnull +8 -> 164
      //   159: aload_2
      //   160: iconst_1
      //   161: putfield 136	st/f:n	I
      //   164: aload_3
      //   165: ifnull +8 -> 173
      //   168: aload_2
      //   169: iconst_1
      //   170: putfield 139	st/f:o	I
      //   173: aload 4
      //   175: ifnull +8 -> 183
      //   178: aload_2
      //   179: iconst_1
      //   180: putfield 142	st/f:p	I
      //   183: aload 5
      //   185: ifnull +8 -> 193
      //   188: aload_2
      //   189: iconst_1
      //   190: putfield 145	st/f:q	I
      //   193: aload_0
      //   194: iconst_0
      //   195: putfield 22	st/q$d:a	Z
      //   198: return
      //   199: ldc -109
      //   201: astore_1
      //   202: goto -138 -> 64
      //   205: astore_1
      //   206: aload_1
      //   207: invokevirtual 150	java/lang/Exception:printStackTrace	()V
      //   210: goto -17 -> 193
      //   213: astore_1
      //   214: aload_1
      //   215: invokevirtual 150	java/lang/Exception:printStackTrace	()V
      //   218: goto -25 -> 193
      //   221: astore_1
      //   222: aload_1
      //   223: invokevirtual 151	java/lang/Error:printStackTrace	()V
      //   226: goto -33 -> 193
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	229	0	this	d
      //   54	148	1	localObject	Object
      //   205	2	1	localException1	Exception
      //   213	2	1	localException2	Exception
      //   221	2	1	localError	Error
      //   14	175	2	localf	f
      //   133	32	3	localSensor1	android.hardware.Sensor
      //   142	32	4	localSensor2	android.hardware.Sensor
      //   153	31	5	localSensor3	android.hardware.Sensor
      // Exception table:
      //   from	to	target	type
      //   15	55	205	java/lang/Exception
      //   59	64	205	java/lang/Exception
      //   64	109	205	java/lang/Exception
      //   109	155	205	java/lang/Exception
      //   159	164	205	java/lang/Exception
      //   168	173	205	java/lang/Exception
      //   178	183	205	java/lang/Exception
      //   188	193	205	java/lang/Exception
      //   0	15	213	java/lang/Exception
      //   206	210	213	java/lang/Exception
      //   222	226	213	java/lang/Exception
      //   15	55	221	java/lang/Error
      //   59	64	221	java/lang/Error
      //   64	109	221	java/lang/Error
      //   109	155	221	java/lang/Error
      //   159	164	221	java/lang/Error
      //   168	173	221	java/lang/Error
      //   178	183	221	java/lang/Error
      //   188	193	221	java/lang/Error
    }
  }
  
  static final class e
    extends q.a
  {
    private final String a;
    private final long b;
    private final long c;
    private final int d;
    
    private e(q paramq, String paramString, long paramLong1, long paramLong2, int paramInt)
    {
      super((byte)0);
      this.a = paramString;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramInt;
    }
    
    public final void run()
    {
      try
      {
        q.a(a(), this.a, this.b, this.c, this.d);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  static final class f
    extends o
  {
    final int a;
    final v b;
    final String c;
    final boolean d;
    
    private f(int paramInt, v paramv, String paramString)
    {
      super();
      this.a = paramInt;
      this.b = paramv;
      this.c = paramString;
      if ((this.a >= 0) && (this.a != 4) && (this.a != 2)) {}
      for (boolean bool = true;; bool = false)
      {
        this.d = bool;
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */