package com.tencent.mobileqq.rn;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import java.util.Map;
import uju;

public class LBSManager
  extends ReactContextBaseJavaModule
{
  static final int FROM_AUTHORIZE = 2;
  static final int FROM_LOCATION = 1;
  public static final String TAG = LBSManager.class.getSimpleName();
  static Map sLbsMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LBSManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  public static WritableMap getConfigLbs()
  {
    return null;
  }
  
  /* Error */
  public static void initLbsConfigFromFile(Map paramMap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 44	java/io/File
    //   6: dup
    //   7: invokestatic 50	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   10: ldc 52
    //   12: invokespecial 55	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 59	java/io/File:exists	()Z
    //   20: ifeq +14 -> 34
    //   23: aload_1
    //   24: invokevirtual 62	java/io/File:isFile	()Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifne +33 -> 64
    //   34: iconst_0
    //   35: ifeq +11 -> 46
    //   38: new 64	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 66	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: ldc 2
    //   48: monitorexit
    //   49: return
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
    //   55: goto -9 -> 46
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    //   64: new 71	java/io/BufferedReader
    //   67: dup
    //   68: new 73	java/io/FileReader
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 76	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   76: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   84: astore_2
    //   85: aload_2
    //   86: ifnull +379 -> 465
    //   89: invokestatic 87	com/tencent/mobileqq/nearby/NearbyUtils:a	()Z
    //   92: ifeq +19 -> 111
    //   95: getstatic 29	com/tencent/mobileqq/rn/LBSManager:TAG	Ljava/lang/String;
    //   98: ldc 88
    //   100: iconst_1
    //   101: anewarray 90	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_2
    //   107: aastore
    //   108: invokestatic 93	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_2
    //   112: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne -35 -> 80
    //   118: aload_2
    //   119: ldc 101
    //   121: invokevirtual 107	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   124: astore 5
    //   126: aload 5
    //   128: ifnull -48 -> 80
    //   131: aload 5
    //   133: arraylength
    //   134: iconst_4
    //   135: if_icmplt -55 -> 80
    //   138: new 109	ujt
    //   141: dup
    //   142: invokespecial 110	ujt:<init>	()V
    //   145: astore 6
    //   147: iconst_0
    //   148: istore 8
    //   150: aconst_null
    //   151: astore_2
    //   152: iload 8
    //   154: aload 5
    //   156: arraylength
    //   157: if_icmpge +261 -> 418
    //   160: aload 5
    //   162: iload 8
    //   164: aaload
    //   165: ldc 112
    //   167: invokevirtual 107	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   170: astore 4
    //   172: aload_2
    //   173: astore_3
    //   174: aload 4
    //   176: ifnull +336 -> 512
    //   179: aload_2
    //   180: astore_3
    //   181: aload 4
    //   183: arraylength
    //   184: iconst_1
    //   185: if_icmple +327 -> 512
    //   188: aload 4
    //   190: iconst_0
    //   191: aaload
    //   192: astore 7
    //   194: aload 4
    //   196: iconst_1
    //   197: aaload
    //   198: astore 4
    //   200: aload_2
    //   201: astore_3
    //   202: aload 7
    //   204: ifnull +308 -> 512
    //   207: aload 4
    //   209: ifnonnull +8 -> 217
    //   212: aload_2
    //   213: astore_3
    //   214: goto +298 -> 512
    //   217: aload 7
    //   219: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   222: astore_3
    //   223: aload 4
    //   225: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   228: astore 4
    //   230: ldc 117
    //   232: aload_3
    //   233: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifne +287 -> 523
    //   239: aload_3
    //   240: ifnull +23 -> 263
    //   243: aload_3
    //   244: ldc 117
    //   246: invokevirtual 125	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   249: ifeq +14 -> 263
    //   252: aload_3
    //   253: invokevirtual 129	java/lang/String:length	()I
    //   256: iconst_4
    //   257: if_icmpne +6 -> 263
    //   260: goto +263 -> 523
    //   263: ldc -125
    //   265: aload_3
    //   266: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: istore 9
    //   271: iload 9
    //   273: ifeq +56 -> 329
    //   276: aload 6
    //   278: aload 4
    //   280: invokestatic 137	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   283: putfield 141	ujt:b	F
    //   286: aload_2
    //   287: astore_3
    //   288: goto +224 -> 512
    //   291: astore_3
    //   292: aload_3
    //   293: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   296: aload_2
    //   297: astore_3
    //   298: goto +214 -> 512
    //   301: astore_2
    //   302: aload_1
    //   303: astore_0
    //   304: aload_2
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   310: aload_0
    //   311: ifnull -265 -> 46
    //   314: aload_0
    //   315: invokevirtual 145	java/io/BufferedReader:close	()V
    //   318: goto -272 -> 46
    //   321: astore_0
    //   322: aload_0
    //   323: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
    //   326: goto -280 -> 46
    //   329: ldc -109
    //   331: aload_3
    //   332: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: istore 9
    //   337: iload 9
    //   339: ifeq +39 -> 378
    //   342: aload 6
    //   344: aload 4
    //   346: invokestatic 137	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   349: putfield 149	ujt:a	F
    //   352: aload_2
    //   353: astore_3
    //   354: goto +158 -> 512
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   362: aload_2
    //   363: astore_3
    //   364: goto +148 -> 512
    //   367: astore_0
    //   368: aload_1
    //   369: ifnull +7 -> 376
    //   372: aload_1
    //   373: invokevirtual 145	java/io/BufferedReader:close	()V
    //   376: aload_0
    //   377: athrow
    //   378: ldc -105
    //   380: aload_3
    //   381: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   384: istore 9
    //   386: aload_2
    //   387: astore_3
    //   388: iload 9
    //   390: ifeq +122 -> 512
    //   393: aload 6
    //   395: aload 4
    //   397: invokestatic 137	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   400: putfield 154	ujt:c	F
    //   403: aload_2
    //   404: astore_3
    //   405: goto +107 -> 512
    //   408: astore_3
    //   409: aload_3
    //   410: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   413: aload_2
    //   414: astore_3
    //   415: goto +97 -> 512
    //   418: invokestatic 87	com/tencent/mobileqq/nearby/NearbyUtils:a	()Z
    //   421: ifeq +24 -> 445
    //   424: getstatic 29	com/tencent/mobileqq/rn/LBSManager:TAG	Ljava/lang/String;
    //   427: ldc 88
    //   429: iconst_2
    //   430: anewarray 90	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload_2
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: aload 6
    //   441: aastore
    //   442: invokestatic 93	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: aload_2
    //   446: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne -369 -> 80
    //   452: aload_0
    //   453: aload_2
    //   454: aload 6
    //   456: invokeinterface 160 3 0
    //   461: pop
    //   462: goto -382 -> 80
    //   465: aload_1
    //   466: ifnull -420 -> 46
    //   469: aload_1
    //   470: invokevirtual 145	java/io/BufferedReader:close	()V
    //   473: goto -427 -> 46
    //   476: astore_0
    //   477: aload_0
    //   478: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
    //   481: goto -435 -> 46
    //   484: astore_1
    //   485: aload_1
    //   486: invokevirtual 69	java/lang/Throwable:printStackTrace	()V
    //   489: goto -113 -> 376
    //   492: astore_0
    //   493: aconst_null
    //   494: astore_1
    //   495: goto -127 -> 368
    //   498: astore_2
    //   499: aload_0
    //   500: astore_1
    //   501: aload_2
    //   502: astore_0
    //   503: goto -135 -> 368
    //   506: astore_1
    //   507: aconst_null
    //   508: astore_0
    //   509: goto -203 -> 306
    //   512: iload 8
    //   514: iconst_1
    //   515: iadd
    //   516: istore 8
    //   518: aload_3
    //   519: astore_2
    //   520: goto -368 -> 152
    //   523: aload 4
    //   525: astore_3
    //   526: goto -14 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramMap	Map
    //   15	455	1	localObject1	Object
    //   484	2	1	localThrowable	Throwable
    //   494	7	1	localMap	Map
    //   506	1	1	localException1	Exception
    //   84	213	2	str1	String
    //   301	153	2	localException2	Exception
    //   498	4	2	localObject2	Object
    //   519	1	2	localObject3	Object
    //   173	115	3	str2	String
    //   291	2	3	localException3	Exception
    //   297	57	3	localObject4	Object
    //   357	2	3	localException4	Exception
    //   363	42	3	localException5	Exception
    //   408	2	3	localException6	Exception
    //   414	112	3	localObject5	Object
    //   170	354	4	localObject6	Object
    //   124	37	5	arrayOfString	String[]
    //   145	310	6	localujt	ujt
    //   192	26	7	localObject7	Object
    //   148	369	8	i	int
    //   27	362	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   38	46	50	java/lang/Throwable
    //   38	46	58	finally
    //   51	55	58	finally
    //   314	318	58	finally
    //   322	326	58	finally
    //   372	376	58	finally
    //   376	378	58	finally
    //   469	473	58	finally
    //   477	481	58	finally
    //   485	489	58	finally
    //   276	286	291	java/lang/Exception
    //   80	85	301	java/lang/Exception
    //   89	111	301	java/lang/Exception
    //   111	126	301	java/lang/Exception
    //   131	147	301	java/lang/Exception
    //   152	172	301	java/lang/Exception
    //   181	188	301	java/lang/Exception
    //   217	239	301	java/lang/Exception
    //   243	260	301	java/lang/Exception
    //   263	271	301	java/lang/Exception
    //   292	296	301	java/lang/Exception
    //   329	337	301	java/lang/Exception
    //   358	362	301	java/lang/Exception
    //   378	386	301	java/lang/Exception
    //   409	413	301	java/lang/Exception
    //   418	445	301	java/lang/Exception
    //   445	462	301	java/lang/Exception
    //   314	318	321	java/lang/Throwable
    //   342	352	357	java/lang/Exception
    //   80	85	367	finally
    //   89	111	367	finally
    //   111	126	367	finally
    //   131	147	367	finally
    //   152	172	367	finally
    //   181	188	367	finally
    //   217	239	367	finally
    //   243	260	367	finally
    //   263	271	367	finally
    //   276	286	367	finally
    //   292	296	367	finally
    //   329	337	367	finally
    //   342	352	367	finally
    //   358	362	367	finally
    //   378	386	367	finally
    //   393	403	367	finally
    //   409	413	367	finally
    //   418	445	367	finally
    //   445	462	367	finally
    //   393	403	408	java/lang/Exception
    //   469	473	476	java/lang/Throwable
    //   372	376	484	java/lang/Throwable
    //   3	29	492	finally
    //   64	80	492	finally
    //   306	310	498	finally
    //   3	29	506	java/lang/Exception
    //   64	80	506	java/lang/Exception
  }
  
  public Map getConstants()
  {
    return MapBuilder.newHashMap();
  }
  
  @ReactMethod
  public void getLBSInfo(Callback paramCallback)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "getLBSInfo", new Object[0]);
    }
    SosoInterface.a(new uju(1, paramCallback));
  }
  
  public String getName()
  {
    return "LBSManager";
  }
  
  @ReactMethod
  public void isEnabledAndAuthorize(Callback paramCallback)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "isEnabledAndAuthorize", new Object[0]);
    }
    SosoInterface.a(new uju(2, paramCallback));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\LBSManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */