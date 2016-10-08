import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class rav
  implements Runnable
{
  public rav(ConfigServlet paramConfigServlet, File paramFile1, String paramString1, String paramString2, File paramFile2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   7: invokevirtual 58	java/io/File:exists	()Z
    //   10: ifne +158 -> 168
    //   13: iconst_0
    //   14: istore 5
    //   16: aload_0
    //   17: getfield 19	rav:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   20: invokevirtual 64	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   23: checkcast 66	com/tencent/common/app/AppInterface
    //   26: aload_0
    //   27: getfield 23	rav:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_0
    //   31: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   34: invokestatic 71	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   37: istore 6
    //   39: iload 6
    //   41: ifeq +110 -> 151
    //   44: aload_0
    //   45: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   48: invokevirtual 58	java/io/File:exists	()Z
    //   51: ifeq +94 -> 145
    //   54: aload_0
    //   55: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   58: invokestatic 77	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 25	rav:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   68: istore 7
    //   70: iload 7
    //   72: ifne +20 -> 92
    //   75: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +11 -> 89
    //   81: ldc 90
    //   83: iconst_2
    //   84: ldc 92
    //   86: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: iconst_0
    //   90: istore 6
    //   92: iload 5
    //   94: iconst_1
    //   95: iadd
    //   96: istore 5
    //   98: iload 6
    //   100: ifne +375 -> 475
    //   103: iload 5
    //   105: iconst_2
    //   106: if_icmplt +366 -> 472
    //   109: iload 6
    //   111: ifeq +130 -> 241
    //   114: aload_0
    //   115: getfield 27	rav:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   118: invokevirtual 98	java/io/File:createNewFile	()Z
    //   121: pop
    //   122: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +11 -> 136
    //   128: ldc 90
    //   130: iconst_2
    //   131: ldc 100
    //   133: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: return
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   142: goto -50 -> 92
    //   145: iconst_0
    //   146: istore 6
    //   148: goto -56 -> 92
    //   151: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +11 -> 165
    //   157: ldc 90
    //   159: iconst_2
    //   160: ldc 108
    //   162: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: goto -73 -> 92
    //   168: aload_0
    //   169: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   172: invokestatic 77	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   175: aload_0
    //   176: getfield 25	rav:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   182: istore 7
    //   184: iload 7
    //   186: ifeq -77 -> 109
    //   189: iconst_1
    //   190: istore 6
    //   192: goto -83 -> 109
    //   195: astore_1
    //   196: aload_0
    //   197: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   200: invokevirtual 58	java/io/File:exists	()Z
    //   203: ifeq +11 -> 214
    //   206: aload_0
    //   207: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   210: invokevirtual 111	java/io/File:delete	()Z
    //   213: pop
    //   214: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +11 -> 228
    //   220: ldc 90
    //   222: iconst_2
    //   223: ldc 113
    //   225: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_1
    //   229: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   232: goto -123 -> 109
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   240: return
    //   241: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +11 -> 255
    //   247: ldc 90
    //   249: iconst_2
    //   250: ldc 116
    //   252: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: new 54	java/io/File
    //   258: dup
    //   259: new 118	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   266: aload_0
    //   267: getfield 29	rav:c	Ljava/lang/String;
    //   270: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_0
    //   274: getfield 31	rav:d	Ljava/lang/String;
    //   277: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc 125
    //   282: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_0
    //   286: getfield 25	rav:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc 125
    //   294: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: getfield 33	rav:e	Ljava/lang/String;
    //   301: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   310: astore 4
    //   312: aconst_null
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_2
    //   317: astore_1
    //   318: aload_0
    //   319: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   322: invokevirtual 58	java/io/File:exists	()Z
    //   325: ifeq +13 -> 338
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 21	rav:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   334: invokevirtual 111	java/io/File:delete	()Z
    //   337: pop
    //   338: aload_2
    //   339: astore_1
    //   340: aload 4
    //   342: invokevirtual 98	java/io/File:createNewFile	()Z
    //   345: pop
    //   346: aload_2
    //   347: astore_1
    //   348: new 134	java/io/FileOutputStream
    //   351: dup
    //   352: aload 4
    //   354: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   357: astore_2
    //   358: aload_2
    //   359: aload_0
    //   360: getfield 35	rav:f	Ljava/lang/String;
    //   363: ldc -117
    //   365: invokevirtual 143	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   368: invokevirtual 147	java/io/FileOutputStream:write	([B)V
    //   371: aload_2
    //   372: invokevirtual 150	java/io/FileOutputStream:flush	()V
    //   375: aload_2
    //   376: ifnull -240 -> 136
    //   379: aload_2
    //   380: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   389: return
    //   390: astore_1
    //   391: aload_3
    //   392: astore_2
    //   393: aload_1
    //   394: astore_3
    //   395: aload_2
    //   396: astore_1
    //   397: aload_3
    //   398: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   401: aload_2
    //   402: astore_1
    //   403: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +13 -> 419
    //   409: aload_2
    //   410: astore_1
    //   411: ldc 90
    //   413: iconst_2
    //   414: ldc -100
    //   416: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload_2
    //   420: ifnull -284 -> 136
    //   423: aload_2
    //   424: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   427: return
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   433: return
    //   434: astore_3
    //   435: aload_1
    //   436: astore_2
    //   437: aload_3
    //   438: astore_1
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   447: aload_1
    //   448: athrow
    //   449: astore_2
    //   450: aload_2
    //   451: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   454: goto -7 -> 447
    //   457: astore_1
    //   458: goto -19 -> 439
    //   461: astore_3
    //   462: goto -67 -> 395
    //   465: astore_1
    //   466: iconst_0
    //   467: istore 6
    //   469: goto -331 -> 138
    //   472: goto -456 -> 16
    //   475: goto -366 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	rav
    //   137	2	1	localThrowable1	Throwable
    //   195	34	1	localException1	Exception
    //   235	2	1	localException2	Exception
    //   317	31	1	localObject1	Object
    //   384	2	1	localIOException1	java.io.IOException
    //   390	4	1	localException3	Exception
    //   396	15	1	localObject2	Object
    //   428	8	1	localIOException2	java.io.IOException
    //   438	10	1	localObject3	Object
    //   457	1	1	localObject4	Object
    //   465	1	1	localThrowable2	Throwable
    //   313	131	2	localObject5	Object
    //   449	2	2	localIOException3	java.io.IOException
    //   315	83	3	localException4	Exception
    //   434	4	3	localObject6	Object
    //   461	1	3	localException5	Exception
    //   310	43	4	localFile	File
    //   14	93	5	i	int
    //   1	467	6	bool1	boolean
    //   68	117	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   54	70	137	java/lang/Throwable
    //   168	184	195	java/lang/Exception
    //   114	136	235	java/lang/Exception
    //   379	383	384	java/io/IOException
    //   318	328	390	java/lang/Exception
    //   330	338	390	java/lang/Exception
    //   340	346	390	java/lang/Exception
    //   348	358	390	java/lang/Exception
    //   423	427	428	java/io/IOException
    //   318	328	434	finally
    //   330	338	434	finally
    //   340	346	434	finally
    //   348	358	434	finally
    //   397	401	434	finally
    //   403	409	434	finally
    //   411	419	434	finally
    //   443	447	449	java/io/IOException
    //   358	375	457	finally
    //   358	375	461	java/lang/Exception
    //   75	89	465	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */