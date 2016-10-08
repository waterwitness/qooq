package com.tencent.upload.network.b;

import com.tencent.upload.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class i
{
  private static String a = "upload_recent_route";
  private final int b;
  private HashMap<String, h> c;
  
  public i(int paramInt)
  {
    this.b = paramInt;
    this.c = new HashMap();
    b();
  }
  
  private static String a(int paramInt)
  {
    return a + "_" + paramInt;
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: ldc 53
    //   2: ldc 55
    //   4: invokestatic 60	com/tencent/upload/a/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore_1
    //   9: invokestatic 65	com/tencent/upload/common/f:a	()Landroid/content/Context;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +12 -> 26
    //   17: ldc 53
    //   19: ldc 67
    //   21: invokestatic 70	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   30: ifnull +136 -> 166
    //   33: aload_0
    //   34: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   37: invokevirtual 74	java/util/HashMap:keySet	()Ljava/util/Set;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +124 -> 166
    //   45: aload_3
    //   46: invokeinterface 80 1 0
    //   51: astore_3
    //   52: aload_3
    //   53: invokeinterface 85 1 0
    //   58: ifeq +108 -> 166
    //   61: aload_3
    //   62: invokeinterface 89 1 0
    //   67: checkcast 91	java/lang/String
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   76: aload 4
    //   78: invokevirtual 95	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 97	com/tencent/upload/network/b/h
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull -36 -> 52
    //   91: aload 5
    //   93: invokevirtual 100	com/tencent/upload/network/b/h:c	()J
    //   96: lstore 6
    //   98: lload 6
    //   100: lconst_0
    //   101: lcmp
    //   102: ifeq -50 -> 52
    //   105: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   108: lload 6
    //   110: invokestatic 110	com/tencent/upload/common/UploadConfiguration:getRecentRouteExpire	()J
    //   113: ladd
    //   114: lcmp
    //   115: ifle -63 -> 52
    //   118: aload_3
    //   119: invokeinterface 113 1 0
    //   124: ldc 53
    //   126: new 35	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 115
    //   132: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload 4
    //   137: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 120
    //   142: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   149: aload 4
    //   151: invokevirtual 124	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   154: invokevirtual 127	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   157: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 129	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto -111 -> 52
    //   166: new 131	java/io/ObjectOutputStream
    //   169: dup
    //   170: new 133	java/io/BufferedOutputStream
    //   173: dup
    //   174: aload_2
    //   175: aload_0
    //   176: getfield 24	com/tencent/upload/network/b/i:b	I
    //   179: invokestatic 135	com/tencent/upload/network/b/i:a	(I)Ljava/lang/String;
    //   182: iconst_0
    //   183: invokevirtual 141	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   186: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   189: invokespecial 145	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   192: astore_2
    //   193: aload_2
    //   194: astore_1
    //   195: aload_2
    //   196: aload_0
    //   197: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   200: invokevirtual 149	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_0
    //   206: invokespecial 151	com/tencent/upload/network/b/i:c	()V
    //   209: aload_2
    //   210: invokevirtual 154	java/io/ObjectOutputStream:close	()V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_1
    //   216: ldc 53
    //   218: ldc -100
    //   220: aload_1
    //   221: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -11 -> 213
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: astore_1
    //   232: ldc 53
    //   234: ldc -95
    //   236: aload_3
    //   237: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_2
    //   241: ifnull -28 -> 213
    //   244: aload_2
    //   245: invokevirtual 154	java/io/ObjectOutputStream:close	()V
    //   248: goto -35 -> 213
    //   251: astore_1
    //   252: ldc 53
    //   254: ldc -100
    //   256: aload_1
    //   257: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -47 -> 213
    //   263: astore_3
    //   264: aload_1
    //   265: astore_2
    //   266: aload_3
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 154	java/io/ObjectOutputStream:close	()V
    //   276: aload_1
    //   277: athrow
    //   278: astore_2
    //   279: ldc 53
    //   281: ldc -100
    //   283: aload_2
    //   284: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: goto -11 -> 276
    //   290: astore_3
    //   291: aload_1
    //   292: astore_2
    //   293: aload_3
    //   294: astore_1
    //   295: goto -27 -> 268
    //   298: astore_3
    //   299: goto -69 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	i
    //   8	197	1	localObject1	Object
    //   215	6	1	localException1	Exception
    //   231	1	1	localObject2	Object
    //   251	14	1	localException2	Exception
    //   267	28	1	localObject3	Object
    //   12	261	2	localObject4	Object
    //   278	6	2	localException3	Exception
    //   292	1	2	localObject5	Object
    //   40	79	3	localObject6	Object
    //   227	10	3	localException4	Exception
    //   263	4	3	localObject7	Object
    //   290	4	3	localObject8	Object
    //   298	1	3	localException5	Exception
    //   70	80	4	str	String
    //   84	8	5	localh	h
    //   96	13	6	l	long
    // Exception table:
    //   from	to	target	type
    //   209	213	215	java/lang/Exception
    //   166	193	227	java/lang/Exception
    //   244	248	251	java/lang/Exception
    //   166	193	263	finally
    //   272	276	278	java/lang/Exception
    //   195	203	290	finally
    //   205	209	290	finally
    //   232	240	290	finally
    //   195	203	298	java/lang/Exception
    //   205	209	298	java/lang/Exception
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: ldc 53
    //   2: ldc -91
    //   4: invokestatic 60	com/tencent/upload/a/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 65	com/tencent/upload/common/f:a	()Landroid/content/Context;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +12 -> 24
    //   15: ldc 53
    //   17: ldc -89
    //   19: invokestatic 70	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_3
    //   25: aload_0
    //   26: getfield 24	com/tencent/upload/network/b/i:b	I
    //   29: invokestatic 135	com/tencent/upload/network/b/i:a	(I)Ljava/lang/String;
    //   32: invokevirtual 171	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   35: astore_1
    //   36: new 173	java/io/ObjectInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 176	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 179	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   49: astore_1
    //   50: aload_1
    //   51: instanceof 26
    //   54: ifeq +11 -> 65
    //   57: aload_0
    //   58: aload_1
    //   59: checkcast 26	java/util/HashMap
    //   62: putfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   65: aload_0
    //   66: getfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   69: ifnonnull +93 -> 162
    //   72: aload_0
    //   73: new 26	java/util/HashMap
    //   76: dup
    //   77: invokespecial 27	java/util/HashMap:<init>	()V
    //   80: putfield 29	com/tencent/upload/network/b/i:c	Ljava/util/HashMap;
    //   83: aload_2
    //   84: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_1
    //   90: ldc 53
    //   92: new 35	java/lang/StringBuilder
    //   95: dup
    //   96: ldc -74
    //   98: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield 24	com/tencent/upload/network/b/i:b	I
    //   105: invokestatic 135	com/tencent/upload/network/b/i:a	(I)Ljava/lang/String;
    //   108: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 185	com/tencent/upload/a/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_1
    //   120: ldc 53
    //   122: ldc -69
    //   124: aload_1
    //   125: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto -41 -> 87
    //   131: astore_1
    //   132: ldc 53
    //   134: ldc -67
    //   136: aload_1
    //   137: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: aload_0
    //   142: getfield 24	com/tencent/upload/network/b/i:b	I
    //   145: invokestatic 135	com/tencent/upload/network/b/i:a	(I)Ljava/lang/String;
    //   148: invokevirtual 193	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   151: pop
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: invokespecial 151	com/tencent/upload/network/b/i:c	()V
    //   166: aload_2
    //   167: invokevirtual 180	java/io/ObjectInputStream:close	()V
    //   170: iconst_1
    //   171: ireturn
    //   172: astore_1
    //   173: ldc 53
    //   175: ldc -69
    //   177: aload_1
    //   178: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: goto -21 -> 160
    //   184: astore_1
    //   185: ldc 53
    //   187: ldc -69
    //   189: aload_1
    //   190: invokestatic 159	com/tencent/upload/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -23 -> 170
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_2
    //   199: goto -67 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	i
    //   35	24	1	localObject	Object
    //   89	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   119	6	1	localException1	Exception
    //   131	6	1	localException2	Exception
    //   172	6	1	localException3	Exception
    //   184	6	1	localException4	Exception
    //   196	1	1	localException5	Exception
    //   44	155	2	localObjectInputStream	java.io.ObjectInputStream
    //   10	131	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   24	36	89	java/io/FileNotFoundException
    //   83	87	119	java/lang/Exception
    //   45	65	131	java/lang/Exception
    //   65	83	131	java/lang/Exception
    //   120	128	131	java/lang/Exception
    //   162	166	131	java/lang/Exception
    //   156	160	172	java/lang/Exception
    //   166	170	184	java/lang/Exception
    //   36	45	196	java/lang/Exception
  }
  
  private void c()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      h localh = (h)this.c.get(str);
      if (localh != null) {
        b.b("RouteSetStorage", "mRecentRouteSetMap key=" + str + ",value=" + localh);
      }
    }
  }
  
  public final h a(String paramString)
  {
    return (h)this.c.get(paramString);
  }
  
  public final void a(String paramString, h paramh)
  {
    this.c.put(paramString, paramh);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */