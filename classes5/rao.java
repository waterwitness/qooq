import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class rao
  implements Runnable
{
  public rao(ConfigServlet paramConfigServlet, File paramFile, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 9
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   10: invokevirtual 39	java/io/File:getName	()Ljava/lang/String;
    //   13: ldc 41
    //   15: invokevirtual 47	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +403 -> 423
    //   23: aload_3
    //   24: arraylength
    //   25: iconst_3
    //   26: if_icmpne +397 -> 423
    //   29: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +11 -> 43
    //   35: ldc 55
    //   37: iconst_2
    //   38: ldc 57
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_3
    //   44: iconst_0
    //   45: aaload
    //   46: astore_1
    //   47: lload 9
    //   49: lstore 7
    //   51: aload_1
    //   52: ifnull +51 -> 103
    //   55: lload 9
    //   57: lstore 7
    //   59: aload_1
    //   60: invokevirtual 64	java/lang/String:trim	()Ljava/lang/String;
    //   63: ldc 66
    //   65: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +35 -> 103
    //   71: aload_1
    //   72: ldc 72
    //   74: invokevirtual 76	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   77: istore 5
    //   79: aload_1
    //   80: iconst_0
    //   81: iload 5
    //   83: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   86: invokestatic 86	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: pop2
    //   90: aload_1
    //   91: iload 5
    //   93: iconst_1
    //   94: iadd
    //   95: invokevirtual 89	java/lang/String:substring	(I)Ljava/lang/String;
    //   98: invokestatic 86	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   101: lstore 7
    //   103: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   106: lload 7
    //   108: lcmp
    //   109: ifge +470 -> 579
    //   112: aconst_null
    //   113: astore_1
    //   114: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +11 -> 128
    //   120: ldc 55
    //   122: iconst_2
    //   123: ldc 97
    //   125: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 99	java/io/FileInputStream
    //   131: dup
    //   132: aload_0
    //   133: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   136: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 106	java/io/FileInputStream:available	()I
    //   144: newarray <illegal type>
    //   146: astore_1
    //   147: aload_2
    //   148: aload_1
    //   149: invokevirtual 110	java/io/FileInputStream:read	([B)I
    //   152: pop
    //   153: new 43	java/lang/String
    //   156: dup
    //   157: aload_1
    //   158: ldc 112
    //   160: invokespecial 115	java/lang/String:<init>	([BLjava/lang/String;)V
    //   163: astore 4
    //   165: aload 4
    //   167: ifnull +252 -> 419
    //   170: aload 4
    //   172: invokevirtual 118	java/lang/String:length	()I
    //   175: iconst_5
    //   176: if_icmple +243 -> 419
    //   179: new 35	java/io/File
    //   182: dup
    //   183: new 120	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   190: aload_0
    //   191: getfield 18	rao:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_3
    //   198: iconst_1
    //   199: aaload
    //   200: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +15 -> 226
    //   214: aload_1
    //   215: invokevirtual 134	java/io/File:exists	()Z
    //   218: ifeq +8 -> 226
    //   221: aload_1
    //   222: invokevirtual 137	java/io/File:delete	()Z
    //   225: pop
    //   226: aload_0
    //   227: getfield 14	rao:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   230: invokevirtual 143	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   233: checkcast 145	com/tencent/common/app/AppInterface
    //   236: aload 4
    //   238: aload_1
    //   239: invokestatic 150	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   242: istore 11
    //   244: iload 6
    //   246: istore 5
    //   248: iload 11
    //   250: ifeq +104 -> 354
    //   253: aload_1
    //   254: invokevirtual 134	java/io/File:exists	()Z
    //   257: istore 12
    //   259: iload 6
    //   261: istore 5
    //   263: iload 12
    //   265: ifeq +89 -> 354
    //   268: aload_1
    //   269: invokestatic 156	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   272: aload_3
    //   273: iconst_1
    //   274: aaload
    //   275: invokevirtual 160	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   278: ifeq +365 -> 643
    //   281: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +11 -> 295
    //   287: ldc 55
    //   289: iconst_2
    //   290: ldc -94
    //   292: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: new 35	java/io/File
    //   298: dup
    //   299: new 120	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   306: aload_0
    //   307: getfield 18	rao:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_3
    //   314: iconst_0
    //   315: aaload
    //   316: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc -89
    //   321: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_3
    //   325: iconst_1
    //   326: aaload
    //   327: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc -89
    //   332: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_3
    //   336: iconst_2
    //   337: aaload
    //   338: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: invokevirtual 170	java/io/File:createNewFile	()Z
    //   350: pop
    //   351: iconst_1
    //   352: istore 5
    //   354: iload 11
    //   356: ifeq +8 -> 364
    //   359: iload 5
    //   361: ifne +58 -> 419
    //   364: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +11 -> 378
    //   370: ldc 55
    //   372: iconst_2
    //   373: ldc -84
    //   375: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_1
    //   379: ifnull +15 -> 394
    //   382: aload_1
    //   383: invokevirtual 134	java/io/File:exists	()Z
    //   386: ifeq +8 -> 394
    //   389: aload_1
    //   390: invokevirtual 137	java/io/File:delete	()Z
    //   393: pop
    //   394: aload_0
    //   395: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   398: ifnull +21 -> 419
    //   401: aload_0
    //   402: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   405: invokevirtual 134	java/io/File:exists	()Z
    //   408: ifeq +11 -> 419
    //   411: aload_0
    //   412: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   415: invokevirtual 137	java/io/File:delete	()Z
    //   418: pop
    //   419: aload_2
    //   420: invokevirtual 175	java/io/FileInputStream:close	()V
    //   423: return
    //   424: astore_3
    //   425: aload_3
    //   426: invokevirtual 178	java/io/FileNotFoundException:printStackTrace	()V
    //   429: iload 6
    //   431: istore 5
    //   433: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq -82 -> 354
    //   439: ldc 55
    //   441: iconst_2
    //   442: ldc -76
    //   444: aload_3
    //   445: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   448: iload 6
    //   450: istore 5
    //   452: goto -98 -> 354
    //   455: astore_3
    //   456: aload_2
    //   457: astore_1
    //   458: aload_3
    //   459: astore_2
    //   460: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +12 -> 475
    //   466: ldc 55
    //   468: iconst_2
    //   469: ldc -71
    //   471: aload_2
    //   472: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: aload_0
    //   476: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   479: ifnull +21 -> 500
    //   482: aload_0
    //   483: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   486: invokevirtual 134	java/io/File:exists	()Z
    //   489: ifeq +11 -> 500
    //   492: aload_0
    //   493: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   496: invokevirtual 137	java/io/File:delete	()Z
    //   499: pop
    //   500: aload_1
    //   501: invokevirtual 175	java/io/FileInputStream:close	()V
    //   504: return
    //   505: astore_1
    //   506: aload_1
    //   507: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   510: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -90 -> 423
    //   516: ldc 55
    //   518: iconst_2
    //   519: ldc -68
    //   521: aload_1
    //   522: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   525: return
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   531: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq -111 -> 423
    //   537: ldc 55
    //   539: iconst_2
    //   540: ldc -68
    //   542: aload_1
    //   543: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   546: return
    //   547: astore_1
    //   548: aconst_null
    //   549: astore_2
    //   550: aload_2
    //   551: invokevirtual 175	java/io/FileInputStream:close	()V
    //   554: aload_1
    //   555: athrow
    //   556: astore_2
    //   557: aload_2
    //   558: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   561: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq -10 -> 554
    //   567: ldc 55
    //   569: iconst_2
    //   570: ldc -68
    //   572: aload_2
    //   573: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   576: goto -22 -> 554
    //   579: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +11 -> 593
    //   585: ldc 55
    //   587: iconst_2
    //   588: ldc -66
    //   590: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload_0
    //   594: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   597: ifnull -174 -> 423
    //   600: aload_0
    //   601: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   604: invokevirtual 134	java/io/File:exists	()Z
    //   607: ifeq -184 -> 423
    //   610: aload_0
    //   611: getfield 16	rao:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   614: invokevirtual 137	java/io/File:delete	()Z
    //   617: pop
    //   618: return
    //   619: astore_1
    //   620: goto -70 -> 550
    //   623: astore_3
    //   624: aload_1
    //   625: astore_2
    //   626: aload_3
    //   627: astore_1
    //   628: goto -78 -> 550
    //   631: astore_2
    //   632: goto -172 -> 460
    //   635: astore_1
    //   636: lload 9
    //   638: lstore 7
    //   640: goto -537 -> 103
    //   643: iconst_0
    //   644: istore 5
    //   646: goto -292 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	rao
    //   46	455	1	localObject1	Object
    //   505	17	1	localException1	Exception
    //   526	17	1	localException2	Exception
    //   547	8	1	localObject2	Object
    //   619	6	1	localObject3	Object
    //   627	1	1	localObject4	Object
    //   635	1	1	localException3	Exception
    //   139	412	2	localObject5	Object
    //   556	17	2	localException4	Exception
    //   625	1	2	localObject6	Object
    //   631	1	2	localException5	Exception
    //   18	318	3	arrayOfString	String[]
    //   424	21	3	localFileNotFoundException	java.io.FileNotFoundException
    //   455	4	3	localException6	Exception
    //   623	4	3	localObject7	Object
    //   163	74	4	str	String
    //   77	568	5	i	int
    //   4	445	6	j	int
    //   49	590	7	l1	long
    //   1	636	9	l2	long
    //   242	113	11	bool1	boolean
    //   257	7	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   268	295	424	java/io/FileNotFoundException
    //   295	351	424	java/io/FileNotFoundException
    //   140	165	455	java/lang/Exception
    //   170	210	455	java/lang/Exception
    //   214	226	455	java/lang/Exception
    //   226	244	455	java/lang/Exception
    //   253	259	455	java/lang/Exception
    //   268	295	455	java/lang/Exception
    //   295	351	455	java/lang/Exception
    //   364	378	455	java/lang/Exception
    //   382	394	455	java/lang/Exception
    //   394	419	455	java/lang/Exception
    //   425	429	455	java/lang/Exception
    //   433	448	455	java/lang/Exception
    //   500	504	505	java/lang/Exception
    //   419	423	526	java/lang/Exception
    //   114	128	547	finally
    //   128	140	547	finally
    //   550	554	556	java/lang/Exception
    //   140	165	619	finally
    //   170	210	619	finally
    //   214	226	619	finally
    //   226	244	619	finally
    //   253	259	619	finally
    //   268	295	619	finally
    //   295	351	619	finally
    //   364	378	619	finally
    //   382	394	619	finally
    //   394	419	619	finally
    //   425	429	619	finally
    //   433	448	619	finally
    //   460	475	623	finally
    //   475	500	623	finally
    //   114	128	631	java/lang/Exception
    //   128	140	631	java/lang/Exception
    //   71	103	635	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */