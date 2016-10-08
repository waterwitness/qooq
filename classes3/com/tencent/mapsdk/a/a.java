package com.tencent.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mapsdk.a.d.e;

public final class a
{
  private static boolean a = false;
  
  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + 2];
    arrayOfByte[0] = ((byte)paramArrayOfByte1.length);
    arrayOfByte[1] = ((byte)paramArrayOfByte2.length);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfByte1.length) {
        break;
      }
      arrayOfByte[(i + 2)] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)] ^ 0x25));
      i += 1;
    }
    while (j < paramArrayOfByte2.length)
    {
      arrayOfByte[(j + 2 + paramArrayOfByte1.length)] = ((byte)(paramArrayOfByte2[j] ^ 0x36));
      j += 1;
    }
    return Base64.encodeToString(arrayOfByte, 3);
  }
  
  public static void a()
  {
    if (a) {
      return;
    }
    new Thread()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: invokestatic 19	com/tencent/mapsdk/a/a:a	(Z)Z
        //   4: pop
        //   5: invokestatic 24	com/tencent/mapsdk/a/d:a	()Lcom/tencent/mapsdk/a/d;
        //   8: invokevirtual 28	com/tencent/mapsdk/a/d:b	()J
        //   11: lstore 7
        //   13: lload 7
        //   15: lconst_0
        //   16: lcmp
        //   17: ifle +8 -> 25
        //   20: lload 7
        //   22: putstatic 33	com/tencent/mapsdk/a/b:a	J
        //   25: iconst_1
        //   26: putstatic 37	com/tencent/mapsdk/a/b:c	Z
        //   29: invokestatic 24	com/tencent/mapsdk/a/d:a	()Lcom/tencent/mapsdk/a/d;
        //   32: invokevirtual 39	com/tencent/mapsdk/a/d:c	()J
        //   35: lstore 7
        //   37: lload 7
        //   39: lconst_0
        //   40: lcmp
        //   41: ifle +8 -> 49
        //   44: lload 7
        //   46: putstatic 41	com/tencent/mapsdk/a/b:b	J
        //   49: new 43	java/lang/StringBuilder
        //   52: dup
        //   53: sipush 300
        //   56: invokespecial 46	java/lang/StringBuilder:<init>	(I)V
        //   59: astore_3
        //   60: aload_3
        //   61: ldc 48
        //   63: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: invokestatic 55	com/tencent/mapsdk/a/a:b	()Ljava/lang/String;
        //   70: astore_1
        //   71: aload_1
        //   72: ldc 57
        //   74: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   77: astore_1
        //   78: aload_3
        //   79: ldc 65
        //   81: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   84: pop
        //   85: aload_3
        //   86: aload_1
        //   87: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   90: pop
        //   91: aload_3
        //   92: ldc 67
        //   94: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   97: pop
        //   98: aload_3
        //   99: ldc 69
        //   101: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: pop
        //   105: aload_3
        //   106: ldc 71
        //   108: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: pop
        //   112: aload_3
        //   113: ldc 73
        //   115: ldc 57
        //   117: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   120: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: pop
        //   124: aload_3
        //   125: ldc 75
        //   127: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: pop
        //   131: aload_3
        //   132: getstatic 81	android/os/Build:MODEL	Ljava/lang/String;
        //   135: ldc 57
        //   137: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   140: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: pop
        //   144: aload_3
        //   145: ldc 83
        //   147: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: pop
        //   151: aload_3
        //   152: getstatic 89	android/os/Build$VERSION:SDK_INT	I
        //   155: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   158: pop
        //   159: aload_3
        //   160: ldc 94
        //   162: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   165: pop
        //   166: aload_3
        //   167: invokestatic 99	com/tencent/mapsdk/a/d/e:a	()Landroid/content/Context;
        //   170: invokevirtual 104	android/content/Context:getPackageName	()Ljava/lang/String;
        //   173: ldc 57
        //   175: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   178: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   181: pop
        //   182: aload_3
        //   183: ldc 106
        //   185: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: pop
        //   189: aload_3
        //   190: invokestatic 108	com/tencent/mapsdk/a/a:c	()Ljava/lang/String;
        //   193: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: pop
        //   197: invokestatic 99	com/tencent/mapsdk/a/d/e:a	()Landroid/content/Context;
        //   200: invokevirtual 112	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   203: astore_1
        //   204: aload_1
        //   205: invokestatic 99	com/tencent/mapsdk/a/d/e:a	()Landroid/content/Context;
        //   208: invokevirtual 104	android/content/Context:getPackageName	()Ljava/lang/String;
        //   211: iconst_0
        //   212: invokevirtual 118	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   215: astore_2
        //   216: aload_2
        //   217: getfield 124	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   220: aload_1
        //   221: invokevirtual 130	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
        //   224: invokeinterface 135 1 0
        //   229: astore_1
        //   230: aload_2
        //   231: getfield 138	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
        //   234: astore_2
        //   235: aload_2
        //   236: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   239: istore 9
        //   241: iload 9
        //   243: ifne +237 -> 480
        //   246: aload_1
        //   247: ifnull +21 -> 268
        //   250: aload_3
        //   251: ldc -110
        //   253: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   256: pop
        //   257: aload_3
        //   258: aload_1
        //   259: ldc 57
        //   261: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   264: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   267: pop
        //   268: aload_2
        //   269: ifnull +21 -> 290
        //   272: aload_3
        //   273: ldc -108
        //   275: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   278: pop
        //   279: aload_3
        //   280: aload_2
        //   281: ldc 57
        //   283: invokestatic 63	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   286: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: pop
        //   290: invokestatic 99	com/tencent/mapsdk/a/d/e:a	()Landroid/content/Context;
        //   293: invokevirtual 152	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   296: invokevirtual 158	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
        //   299: astore_1
        //   300: aload_1
        //   301: getfield 163	android/util/DisplayMetrics:densityDpi	I
        //   304: istore 4
        //   306: aload_1
        //   307: getfield 166	android/util/DisplayMetrics:widthPixels	I
        //   310: istore 5
        //   312: aload_1
        //   313: getfield 169	android/util/DisplayMetrics:heightPixels	I
        //   316: istore 6
        //   318: aload_3
        //   319: ldc -85
        //   321: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   324: pop
        //   325: aload_3
        //   326: iload 4
        //   328: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   331: pop
        //   332: aload_3
        //   333: ldc -83
        //   335: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   338: pop
        //   339: aload_3
        //   340: iload 5
        //   342: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   345: pop
        //   346: aload_3
        //   347: ldc -81
        //   349: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   352: pop
        //   353: aload_3
        //   354: iload 6
        //   356: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   359: pop
        //   360: iconst_0
        //   361: istore 4
        //   363: iload 4
        //   365: iconst_2
        //   366: if_icmpge +58 -> 424
        //   369: new 177	org/apache/http/client/methods/HttpGet
        //   372: dup
        //   373: aload_3
        //   374: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   377: invokespecial 181	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
        //   380: astore_1
        //   381: new 183	org/apache/http/impl/client/DefaultHttpClient
        //   384: dup
        //   385: invokespecial 184	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
        //   388: aload_1
        //   389: invokeinterface 190 2 0
        //   394: astore_1
        //   395: aload_1
        //   396: invokeinterface 196 1 0
        //   401: invokeinterface 202 1 0
        //   406: sipush 200
        //   409: if_icmpne +34 -> 443
        //   412: aload_1
        //   413: invokeinterface 206 1 0
        //   418: invokestatic 211	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   421: invokestatic 213	com/tencent/mapsdk/a/a:a	(Ljava/lang/String;)V
        //   424: iconst_0
        //   425: invokestatic 19	com/tencent/mapsdk/a/a:a	(Z)Z
        //   428: pop
        //   429: return
        //   430: astore_1
        //   431: aconst_null
        //   432: astore_1
        //   433: aconst_null
        //   434: astore_2
        //   435: goto -189 -> 246
        //   438: astore_1
        //   439: aload_1
        //   440: invokevirtual 216	java/lang/Exception:printStackTrace	()V
        //   443: iload 4
        //   445: iconst_1
        //   446: iadd
        //   447: istore 4
        //   449: goto -86 -> 363
        //   452: astore_1
        //   453: goto -93 -> 360
        //   456: astore_1
        //   457: goto -167 -> 290
        //   460: astore_1
        //   461: goto -193 -> 268
        //   464: astore_2
        //   465: goto -32 -> 433
        //   468: astore_1
        //   469: goto -287 -> 182
        //   472: astore_1
        //   473: goto -349 -> 124
        //   476: astore_1
        //   477: goto -386 -> 91
        //   480: aconst_null
        //   481: astore_2
        //   482: goto -236 -> 246
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	485	0	this	1
        //   70	343	1	localObject1	Object
        //   430	1	1	localException1	Exception
        //   432	1	1	localObject2	Object
        //   438	2	1	localException2	Exception
        //   452	1	1	localException3	Exception
        //   456	1	1	localException4	Exception
        //   460	1	1	localException5	Exception
        //   468	1	1	localException6	Exception
        //   472	1	1	localException7	Exception
        //   476	1	1	localException8	Exception
        //   215	220	2	localObject3	Object
        //   464	1	2	localException9	Exception
        //   481	1	2	localObject4	Object
        //   59	315	3	localStringBuilder	StringBuilder
        //   304	144	4	i	int
        //   310	31	5	j	int
        //   316	39	6	k	int
        //   11	34	7	l	long
        //   239	3	9	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   197	230	430	java/lang/Exception
        //   381	424	438	java/lang/Exception
        //   290	360	452	java/lang/Exception
        //   279	290	456	java/lang/Exception
        //   257	268	460	java/lang/Exception
        //   230	241	464	java/lang/Exception
        //   124	182	468	java/lang/Exception
        //   112	124	472	java/lang/Exception
        //   71	91	476	java/lang/Exception
      }
    }.start();
  }
  
  public static String b()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = e.a().getPackageManager().getApplicationInfo(e.a().getPackageName(), 128).metaData.getString("TencentMapSDK");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  public static String c()
  {
    try
    {
      Object localObject1 = ((TelephonyManager)e.a().getSystemService("phone")).getDeviceId();
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "noIMEI";
      }
      Object localObject3 = d();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "noMac";
      }
      localObject3 = ((String)localObject2).getBytes();
      byte[] arrayOfByte = ((String)localObject1).getBytes();
      new StringBuilder().append((String)localObject2).append("::::").append((String)localObject1);
      a((byte[])localObject3, arrayOfByte);
      return a((byte[])localObject3, arrayOfByte);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  private static String d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = ((WifiManager)e.a().getSystemService("wifi")).getConnectionInfo();
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((WifiInfo)localObject1).getBSSID();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).replace(":", "");
          if ("000000000000".equals(localObject1)) {
            break;
          }
          boolean bool = "".equals(localObject1);
          if (bool) {
            break;
          }
          return (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      Object localObject2 = null;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */