package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Verify
{
  public Verify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 24	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: astore_1
    //   8: aload_2
    //   9: ifnonnull +6 -> 15
    //   12: ldc 26
    //   14: astore_1
    //   15: new 28	MAAccessClient/AcCode
    //   18: dup
    //   19: aload_1
    //   20: getstatic 33	com/tencent/common/config/AppSetting:a	I
    //   23: invokestatic 39	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   26: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   29: invokestatic 48	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: getstatic 53	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   35: invokestatic 58	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;)I
    //   38: invokespecial 61	MAAccessClient/AcCode:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   41: invokevirtual 65	MAAccessClient/AcCode:toByteArray	()[B
    //   44: astore 4
    //   46: aload_0
    //   47: invokevirtual 70	android/content/Context:getPackageName	()Ljava/lang/String;
    //   50: astore 5
    //   52: aload 5
    //   54: invokevirtual 74	java/lang/String:length	()I
    //   57: istore 7
    //   59: bipush 16
    //   61: iload 7
    //   63: idiv
    //   64: istore 6
    //   66: bipush 16
    //   68: iload 7
    //   70: irem
    //   71: istore 7
    //   73: ldc 26
    //   75: astore_1
    //   76: iload 6
    //   78: ifle +32 -> 110
    //   81: new 76	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   88: aload_1
    //   89: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 5
    //   94: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_1
    //   101: iload 6
    //   103: iconst_1
    //   104: isub
    //   105: istore 6
    //   107: goto -31 -> 76
    //   110: aload_1
    //   111: astore_2
    //   112: iload 7
    //   114: ifle +29 -> 143
    //   117: new 76	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 5
    //   130: iconst_0
    //   131: iload 7
    //   133: invokevirtual 88	java/lang/String:substring	(II)Ljava/lang/String;
    //   136: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 91	java/lang/String:getBytes	()[B
    //   147: astore_1
    //   148: new 93	com/tencent/qphone/base/util/Cryptor
    //   151: dup
    //   152: invokespecial 94	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   155: aload 4
    //   157: aload_1
    //   158: invokevirtual 98	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +154 -> 317
    //   166: aload_0
    //   167: invokestatic 104	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   170: astore_0
    //   171: new 106	java/io/File
    //   174: dup
    //   175: new 76	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   182: aload_0
    //   183: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 108
    //   188: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 115	java/io/File:getParentFile	()Ljava/io/File;
    //   202: astore_2
    //   203: aload_2
    //   204: invokevirtual 119	java/io/File:exists	()Z
    //   207: ifeq +10 -> 217
    //   210: aload_2
    //   211: invokevirtual 122	java/io/File:isDirectory	()Z
    //   214: ifne +8 -> 222
    //   217: aload_2
    //   218: invokevirtual 125	java/io/File:mkdirs	()Z
    //   221: pop
    //   222: aload_0
    //   223: invokevirtual 119	java/io/File:exists	()Z
    //   226: ifeq +8 -> 234
    //   229: aload_0
    //   230: invokevirtual 128	java/io/File:delete	()Z
    //   233: pop
    //   234: aload_0
    //   235: invokevirtual 131	java/io/File:createNewFile	()Z
    //   238: pop
    //   239: new 133	java/io/FileOutputStream
    //   242: dup
    //   243: aload_0
    //   244: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   247: astore_0
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 140	java/io/FileOutputStream:write	([B)V
    //   253: aload_0
    //   254: ifnull +7 -> 261
    //   257: aload_0
    //   258: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   261: iconst_1
    //   262: ireturn
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -104 -> 162
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_0
    //   272: aload_0
    //   273: ifnull +44 -> 317
    //   276: aload_0
    //   277: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   280: iconst_0
    //   281: ireturn
    //   282: astore_0
    //   283: iconst_0
    //   284: ireturn
    //   285: astore_0
    //   286: aload_3
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   296: aload_0
    //   297: athrow
    //   298: astore_0
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_1
    //   302: goto -6 -> 296
    //   305: astore_2
    //   306: aload_0
    //   307: astore_1
    //   308: aload_2
    //   309: astore_0
    //   310: goto -22 -> 288
    //   313: astore_1
    //   314: goto -42 -> 272
    //   317: iconst_0
    //   318: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramContext	Context
    //   7	243	1	localObject1	Object
    //   263	1	1	localException1	Exception
    //   265	28	1	localObject2	Object
    //   301	1	1	localException2	Exception
    //   307	1	1	localContext	Context
    //   313	1	1	localException3	Exception
    //   5	213	2	localObject3	Object
    //   305	4	2	localObject4	Object
    //   1	286	3	localObject5	Object
    //   44	112	4	arrayOfByte	byte[]
    //   50	79	5	str	String
    //   64	42	6	i	int
    //   57	75	7	j	int
    // Exception table:
    //   from	to	target	type
    //   148	162	263	java/lang/Exception
    //   234	248	269	java/lang/Exception
    //   276	280	282	java/lang/Exception
    //   234	248	285	finally
    //   257	261	298	java/lang/Exception
    //   292	296	301	java/lang/Exception
    //   248	253	305	finally
    //   248	253	313	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    String str = "";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      if (localPackageInfo.signatures.length >= 1) {
        str = MD5.a(localPackageInfo.signatures[(localPackageInfo.signatures.length - 1)].toCharsString());
      }
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramString2)))
      {
        int i = ApkInfoParser.a(paramContext, paramString1);
        if (i < paramInt) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: invokestatic 104	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   10: astore_1
    //   11: new 106	java/io/File
    //   14: dup
    //   15: new 76	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   22: aload_1
    //   23: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 108
    //   28: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: iload 8
    //   40: istore 7
    //   42: aload_1
    //   43: invokevirtual 119	java/io/File:exists	()Z
    //   46: ifeq +354 -> 400
    //   49: iload 8
    //   51: istore 7
    //   53: aload_1
    //   54: invokevirtual 189	java/io/File:isFile	()Z
    //   57: ifeq +343 -> 400
    //   60: new 191	java/io/FileInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: astore_2
    //   69: new 194	java/io/ByteArrayOutputStream
    //   72: dup
    //   73: sipush 128
    //   76: invokespecial 197	java/io/ByteArrayOutputStream:<init>	(I)V
    //   79: astore_1
    //   80: sipush 128
    //   83: newarray <illegal type>
    //   85: astore_3
    //   86: aload_2
    //   87: aload_3
    //   88: invokevirtual 201	java/io/FileInputStream:read	([B)I
    //   91: istore 5
    //   93: iload 5
    //   95: ifle +21 -> 116
    //   98: aload_1
    //   99: aload_3
    //   100: iconst_0
    //   101: iload 5
    //   103: invokevirtual 204	java/io/ByteArrayOutputStream:write	([BII)V
    //   106: aload_2
    //   107: aload_3
    //   108: invokevirtual 201	java/io/FileInputStream:read	([B)I
    //   111: istore 5
    //   113: goto -20 -> 93
    //   116: aload_1
    //   117: invokevirtual 205	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: astore_3
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   129: aload_3
    //   130: astore_1
    //   131: aload_2
    //   132: ifnull +9 -> 141
    //   135: aload_2
    //   136: invokevirtual 207	java/io/FileInputStream:close	()V
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: invokevirtual 70	android/content/Context:getPackageName	()Ljava/lang/String;
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 74	java/lang/String:length	()I
    //   150: istore 6
    //   152: bipush 16
    //   154: iload 6
    //   156: idiv
    //   157: istore 5
    //   159: bipush 16
    //   161: iload 6
    //   163: irem
    //   164: istore 6
    //   166: ldc 26
    //   168: astore_0
    //   169: iload 5
    //   171: ifle +86 -> 257
    //   174: new 76	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   181: aload_0
    //   182: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_3
    //   186: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore_0
    //   193: iload 5
    //   195: iconst_1
    //   196: isub
    //   197: istore 5
    //   199: goto -30 -> 169
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   215: aload_2
    //   216: ifnull +248 -> 464
    //   219: aload_2
    //   220: invokevirtual 207	java/io/FileInputStream:close	()V
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -84 -> 141
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_1
    //   231: goto -90 -> 141
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_1
    //   240: ifnull +7 -> 247
    //   243: aload_1
    //   244: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 207	java/io/FileInputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: aload_0
    //   258: astore_2
    //   259: iload 6
    //   261: ifle +28 -> 289
    //   264: new 76	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   271: aload_0
    //   272: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_3
    //   276: iconst_0
    //   277: iload 6
    //   279: invokevirtual 88	java/lang/String:substring	(II)Ljava/lang/String;
    //   282: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 91	java/lang/String:getBytes	()[B
    //   293: astore_0
    //   294: new 93	com/tencent/qphone/base/util/Cryptor
    //   297: dup
    //   298: invokespecial 94	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   301: aload_1
    //   302: aload_0
    //   303: invokevirtual 210	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   306: astore_0
    //   307: aload 4
    //   309: astore_1
    //   310: aload_0
    //   311: ifnull +25 -> 336
    //   314: new 212	com/qq/taf/jce/JceInputStream
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 214	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   322: astore_0
    //   323: new 28	MAAccessClient/AcCode
    //   326: dup
    //   327: invokespecial 215	MAAccessClient/AcCode:<init>	()V
    //   330: astore_1
    //   331: aload_1
    //   332: aload_0
    //   333: invokevirtual 219	MAAccessClient/AcCode:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   336: getstatic 53	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   339: invokestatic 58	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;)I
    //   342: istore 5
    //   344: iload 8
    //   346: istore 7
    //   348: aload_1
    //   349: ifnull +51 -> 400
    //   352: aload_1
    //   353: getfield 223	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   356: ifnull +16 -> 372
    //   359: aload_1
    //   360: getfield 223	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   363: invokestatic 24	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   366: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifeq +40 -> 409
    //   372: getstatic 33	com/tencent/common/config/AppSetting:a	I
    //   375: invokestatic 39	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   378: aload_1
    //   379: getfield 226	MAAccessClient/AcCode:appid	Ljava/lang/String;
    //   382: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   385: ifeq +24 -> 409
    //   388: iload 5
    //   390: aload_1
    //   391: getfield 229	MAAccessClient/AcCode:versionCode	I
    //   394: if_icmpne +15 -> 409
    //   397: iconst_1
    //   398: istore 7
    //   400: iload 7
    //   402: ireturn
    //   403: astore_0
    //   404: aconst_null
    //   405: astore_0
    //   406: goto -99 -> 307
    //   409: iconst_0
    //   410: istore 7
    //   412: goto -12 -> 400
    //   415: astore_1
    //   416: goto -287 -> 129
    //   419: astore_1
    //   420: aload_3
    //   421: astore_1
    //   422: goto -281 -> 141
    //   425: astore_1
    //   426: goto -211 -> 215
    //   429: astore_1
    //   430: goto -183 -> 247
    //   433: astore_1
    //   434: goto -179 -> 255
    //   437: astore_0
    //   438: aload 4
    //   440: astore_1
    //   441: goto -105 -> 336
    //   444: astore_0
    //   445: aconst_null
    //   446: astore_1
    //   447: goto -208 -> 239
    //   450: astore_0
    //   451: goto -212 -> 239
    //   454: astore_1
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -250 -> 207
    //   460: astore_3
    //   461: goto -254 -> 207
    //   464: aconst_null
    //   465: astore_1
    //   466: goto -325 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramContext	Context
    //   10	131	1	localObject1	Object
    //   202	1	1	localException1	Exception
    //   204	21	1	localObject2	Object
    //   228	1	1	localException2	Exception
    //   230	161	1	localObject3	Object
    //   415	1	1	localException3	Exception
    //   419	1	1	localException4	Exception
    //   421	1	1	localObject4	Object
    //   425	1	1	localException5	Exception
    //   429	1	1	localException6	Exception
    //   433	1	1	localException7	Exception
    //   440	7	1	localObject5	Object
    //   454	1	1	localException8	Exception
    //   456	10	1	localObject6	Object
    //   68	222	2	localObject7	Object
    //   85	336	3	localObject8	Object
    //   460	1	3	localException9	Exception
    //   4	435	4	localObject9	Object
    //   91	304	5	i	int
    //   150	128	6	j	int
    //   40	371	7	bool1	boolean
    //   1	344	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   60	69	202	java/lang/Exception
    //   219	223	228	java/lang/Exception
    //   60	69	234	finally
    //   294	307	403	java/lang/Exception
    //   125	129	415	java/lang/Exception
    //   135	139	419	java/lang/Exception
    //   211	215	425	java/lang/Exception
    //   243	247	429	java/lang/Exception
    //   251	255	433	java/lang/Exception
    //   314	336	437	java/lang/Exception
    //   69	80	444	finally
    //   80	93	450	finally
    //   98	113	450	finally
    //   116	121	450	finally
    //   69	80	454	java/lang/Exception
    //   80	93	460	java/lang/Exception
    //   98	113	460	java/lang/Exception
    //   116	121	460	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\Verify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */