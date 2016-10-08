import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class smg
  implements Runnable
{
  public smg(ForwardShareCardOption paramForwardShareCardOption, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   6: lstore 6
    //   8: iconst_1
    //   9: aload_0
    //   10: getfield 18	smg:jdField_a_of_type_Int	I
    //   13: if_icmpne +328 -> 341
    //   16: invokestatic 47	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   19: ifeq +133 -> 152
    //   22: getstatic 52	com/tencent/mobileqq/app/AppConstants:bG	Ljava/lang/String;
    //   25: astore_1
    //   26: new 54	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 61
    //   39: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_1
    //   46: new 67	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 73	java/io/File:exists	()Z
    //   59: ifeq +99 -> 158
    //   62: iconst_1
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +6 -> 73
    //   70: ldc 75
    //   72: astore_1
    //   73: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +38 -> 114
    //   79: ldc 82
    //   81: iconst_2
    //   82: new 54	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   89: ldc 84
    //   91: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   97: lload 6
    //   99: lsub
    //   100: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   103: ldc 89
    //   105: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   118: aload_0
    //   119: getfield 20	smg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload_1
    //   123: invokestatic 98	com/tencent/mobileqq/forward/ForwardShareCardOption:a	(Lcom/tencent/mobileqq/forward/ForwardShareCardOption;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   130: invokevirtual 101	com/tencent/mobileqq/forward/ForwardShareCardOption:r	()V
    //   133: aload_0
    //   134: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   137: getfield 104	com/tencent/mobileqq/forward/ForwardShareCardOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   140: new 106	smh
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 109	smh:<init>	(Lsmg;)V
    //   148: invokevirtual 115	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   151: return
    //   152: ldc 117
    //   154: astore_1
    //   155: goto -129 -> 26
    //   158: aload_2
    //   159: invokevirtual 120	java/io/File:createNewFile	()Z
    //   162: pop
    //   163: new 122	java/io/FileOutputStream
    //   166: dup
    //   167: aload_2
    //   168: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_3
    //   172: invokestatic 130	com/tencent/mobileqq/utils/ImageUtil:d	()Landroid/graphics/drawable/Drawable;
    //   175: checkcast 132	android/graphics/drawable/BitmapDrawable
    //   178: invokevirtual 136	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   181: getstatic 142	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   184: bipush 100
    //   186: aload_3
    //   187: invokevirtual 148	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   190: istore 8
    //   192: iload 8
    //   194: ifeq +385 -> 579
    //   197: iconst_1
    //   198: istore 5
    //   200: aload_1
    //   201: astore_2
    //   202: aload_2
    //   203: astore_1
    //   204: iload 5
    //   206: istore 4
    //   208: aload_3
    //   209: ifnull -144 -> 65
    //   212: aload_3
    //   213: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   216: aload_2
    //   217: astore_1
    //   218: iload 5
    //   220: istore 4
    //   222: goto -157 -> 65
    //   225: astore_3
    //   226: aload_2
    //   227: astore_1
    //   228: iload 5
    //   230: istore 4
    //   232: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq -170 -> 65
    //   238: ldc 82
    //   240: iconst_2
    //   241: ldc 75
    //   243: aload_3
    //   244: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_2
    //   248: astore_1
    //   249: iload 5
    //   251: istore 4
    //   253: goto -188 -> 65
    //   256: astore_2
    //   257: aconst_null
    //   258: astore_1
    //   259: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   269: aload_1
    //   270: ifnull +301 -> 571
    //   273: aload_1
    //   274: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   277: aconst_null
    //   278: astore_1
    //   279: iconst_0
    //   280: istore 4
    //   282: goto -217 -> 65
    //   285: astore_1
    //   286: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +12 -> 301
    //   292: ldc 82
    //   294: iconst_2
    //   295: ldc 75
    //   297: aload_1
    //   298: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aconst_null
    //   302: astore_1
    //   303: iconst_0
    //   304: istore 4
    //   306: goto -241 -> 65
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_2
    //   312: aload_2
    //   313: ifnull +7 -> 320
    //   316: aload_2
    //   317: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   320: aload_1
    //   321: athrow
    //   322: astore_2
    //   323: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -6 -> 320
    //   329: ldc 82
    //   331: iconst_2
    //   332: ldc 75
    //   334: aload_2
    //   335: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -18 -> 320
    //   341: aload_0
    //   342: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   345: getfield 160	com/tencent/mobileqq/forward/ForwardShareCardOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   348: bipush 101
    //   350: aload_0
    //   351: getfield 20	smg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   354: iconst_0
    //   355: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   363: getfield 160	com/tencent/mobileqq/forward/ForwardShareCardOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   366: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   369: astore_2
    //   370: aload_1
    //   371: invokestatic 172	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   374: ifeq +137 -> 511
    //   377: new 174	java/util/ArrayList
    //   380: dup
    //   381: invokespecial 175	java/util/ArrayList:<init>	()V
    //   384: astore_3
    //   385: aload_3
    //   386: aload_1
    //   387: invokevirtual 179	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   390: pop
    //   391: aload_3
    //   392: aload_2
    //   393: aload_0
    //   394: getfield 22	smg:b	Ljava/lang/String;
    //   397: ldc -75
    //   399: invokestatic 186	cooperation/qzone/QZoneShareManager:a	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   402: astore_1
    //   403: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +40 -> 446
    //   409: ldc 82
    //   411: iconst_4
    //   412: new 54	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   419: ldc -68
    //   421: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_1
    //   425: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   428: ldc -63
    //   430: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: getfield 24	smg:jdField_a_of_type_Boolean	Z
    //   437: invokevirtual 196	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   440: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_1
    //   447: ifnull +115 -> 562
    //   450: aload_1
    //   451: invokevirtual 200	java/util/ArrayList:size	()I
    //   454: ifle +108 -> 562
    //   457: aload_1
    //   458: iconst_0
    //   459: invokevirtual 204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   462: checkcast 206	java/lang/String
    //   465: astore_2
    //   466: aload_2
    //   467: astore_1
    //   468: iload 5
    //   470: istore 4
    //   472: aload_2
    //   473: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   476: ifne -411 -> 65
    //   479: aload_2
    //   480: ldc -42
    //   482: invokevirtual 217	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   485: ifne +18 -> 503
    //   488: aload_2
    //   489: astore_1
    //   490: iload 5
    //   492: istore 4
    //   494: aload_2
    //   495: ldc -37
    //   497: invokevirtual 217	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   500: ifeq -435 -> 65
    //   503: iconst_1
    //   504: istore 4
    //   506: aload_2
    //   507: astore_1
    //   508: goto -443 -> 65
    //   511: aload_0
    //   512: getfield 24	smg:jdField_a_of_type_Boolean	Z
    //   515: ifeq +47 -> 562
    //   518: aload_0
    //   519: getfield 16	smg:jdField_a_of_type_ComTencentMobileqqForwardForwardShareCardOption	Lcom/tencent/mobileqq/forward/ForwardShareCardOption;
    //   522: getfield 160	com/tencent/mobileqq/forward/ForwardShareCardOption:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   525: bipush 6
    //   527: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   530: checkcast 224	com/tencent/mobileqq/app/DiscussionHandler
    //   533: aload_0
    //   534: getfield 20	smg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   537: iconst_1
    //   538: invokevirtual 227	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Z)V
    //   541: return
    //   542: astore_1
    //   543: aload_3
    //   544: astore_2
    //   545: goto -233 -> 312
    //   548: astore_3
    //   549: aload_1
    //   550: astore_2
    //   551: aload_3
    //   552: astore_1
    //   553: goto -241 -> 312
    //   556: astore_2
    //   557: aload_3
    //   558: astore_1
    //   559: goto -300 -> 259
    //   562: aconst_null
    //   563: astore_1
    //   564: iload 5
    //   566: istore 4
    //   568: goto -503 -> 65
    //   571: aconst_null
    //   572: astore_1
    //   573: iconst_0
    //   574: istore 4
    //   576: goto -511 -> 65
    //   579: aconst_null
    //   580: astore_2
    //   581: iconst_0
    //   582: istore 5
    //   584: goto -382 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	smg
    //   25	254	1	localObject1	Object
    //   285	13	1	localIOException1	java.io.IOException
    //   302	1	1	localObject2	Object
    //   309	12	1	localObject3	Object
    //   358	150	1	localObject4	Object
    //   542	8	1	localObject5	Object
    //   552	21	1	localObject6	Object
    //   54	194	2	localObject7	Object
    //   256	10	2	localIOException2	java.io.IOException
    //   311	6	2	localObject8	Object
    //   322	13	2	localIOException3	java.io.IOException
    //   369	182	2	localObject9	Object
    //   556	1	2	localIOException4	java.io.IOException
    //   580	1	2	localObject10	Object
    //   171	42	3	localFileOutputStream	java.io.FileOutputStream
    //   225	19	3	localIOException5	java.io.IOException
    //   384	160	3	localArrayList	java.util.ArrayList
    //   548	10	3	localObject11	Object
    //   63	512	4	i	int
    //   1	582	5	j	int
    //   6	92	6	l	long
    //   190	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   212	216	225	java/io/IOException
    //   158	172	256	java/io/IOException
    //   273	277	285	java/io/IOException
    //   158	172	309	finally
    //   316	320	322	java/io/IOException
    //   172	192	542	finally
    //   259	269	548	finally
    //   172	192	556	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\smg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */