import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofv
  implements Runnable
{
  public ofv(BlessManager paramBlessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   4: iconst_1
    //   5: invokestatic 30	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   13: invokevirtual 34	com/tencent/mobileqq/activity/bless/BlessManager:g	()Ljava/lang/String;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnonnull +13 -> 33
    //   23: aload_0
    //   24: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   27: iconst_0
    //   28: invokestatic 30	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   31: pop
    //   32: return
    //   33: new 36	java/io/File
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 43	java/io/File:exists	()Z
    //   45: ifeq +189 -> 234
    //   48: new 45	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   59: getfield 50	com/tencent/mobileqq/activity/bless/BlessManager:j	Ljava/lang/String;
    //   62: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   69: invokestatic 57	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   72: getfield 62	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFolderName	Ljava/lang/String;
    //   75: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 65	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 45	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   95: aload_2
    //   96: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   103: invokestatic 57	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   106: getfield 71	com/tencent/mobileqq/activity/bless/BlessTask:starVideoCoverFileName	Ljava/lang/String;
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_1
    //   116: new 36	java/io/File
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 43	java/io/File:exists	()Z
    //   129: ifeq +8 -> 137
    //   132: aload_2
    //   133: invokevirtual 74	java/io/File:delete	()Z
    //   136: pop
    //   137: aload_2
    //   138: invokevirtual 77	java/io/File:mkdirs	()Z
    //   141: pop
    //   142: new 36	java/io/File
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_2
    //   157: astore_1
    //   158: new 79	android/media/MediaMetadataRetriever
    //   161: dup
    //   162: invokespecial 80	android/media/MediaMetadataRetriever:<init>	()V
    //   165: astore 6
    //   167: aload_2
    //   168: astore_1
    //   169: aload 6
    //   171: aload 5
    //   173: invokevirtual 83	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   176: aload_2
    //   177: astore_1
    //   178: aload 6
    //   180: lconst_0
    //   181: invokevirtual 87	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +303 -> 491
    //   191: aload_2
    //   192: astore_1
    //   193: new 89	java/io/FileOutputStream
    //   196: dup
    //   197: aload 4
    //   199: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   202: astore_2
    //   203: aload 5
    //   205: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   208: bipush 100
    //   210: aload_2
    //   211: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   214: pop
    //   215: aload_2
    //   216: invokevirtual 107	java/io/FileOutputStream:flush	()V
    //   219: aload_0
    //   220: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   223: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   234: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +12 -> 249
    //   240: getstatic 119	com/tencent/mobileqq/activity/bless/BlessManager:a	Ljava/lang/String;
    //   243: iconst_2
    //   244: ldc 121
    //   246: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   253: iconst_0
    //   254: invokestatic 30	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;Z)Z
    //   257: pop
    //   258: return
    //   259: astore_1
    //   260: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -29 -> 234
    //   266: getstatic 119	com/tencent/mobileqq/activity/bless/BlessManager:a	Ljava/lang/String;
    //   269: iconst_2
    //   270: new 45	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   277: ldc 127
    //   279: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: goto -61 -> 234
    //   298: astore_1
    //   299: aload_3
    //   300: astore_2
    //   301: aload_1
    //   302: astore_3
    //   303: aload_2
    //   304: astore_1
    //   305: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +34 -> 342
    //   311: aload_2
    //   312: astore_1
    //   313: getstatic 119	com/tencent/mobileqq/activity/bless/BlessManager:a	Ljava/lang/String;
    //   316: iconst_2
    //   317: new 45	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   324: ldc -124
    //   326: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_3
    //   330: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload 4
    //   344: ifnull +21 -> 365
    //   347: aload_2
    //   348: astore_1
    //   349: aload 4
    //   351: invokevirtual 43	java/io/File:exists	()Z
    //   354: ifeq +11 -> 365
    //   357: aload_2
    //   358: astore_1
    //   359: aload 4
    //   361: invokevirtual 74	java/io/File:delete	()Z
    //   364: pop
    //   365: aload_0
    //   366: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   369: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   372: aload_2
    //   373: ifnull -139 -> 234
    //   376: aload_2
    //   377: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   380: goto -146 -> 234
    //   383: astore_1
    //   384: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -153 -> 234
    //   390: getstatic 119	com/tencent/mobileqq/activity/bless/BlessManager:a	Ljava/lang/String;
    //   393: iconst_2
    //   394: new 45	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   401: ldc 127
    //   403: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   410: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: goto -185 -> 234
    //   422: astore_3
    //   423: aload_1
    //   424: astore_2
    //   425: aload_3
    //   426: astore_1
    //   427: aload_0
    //   428: getfield 12	ofv:a	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   431: invokestatic 109	com/tencent/mobileqq/activity/bless/BlessManager:a	(Lcom/tencent/mobileqq/activity/bless/BlessManager;)V
    //   434: aload_2
    //   435: ifnull +7 -> 442
    //   438: aload_2
    //   439: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   442: aload_1
    //   443: athrow
    //   444: astore_2
    //   445: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq -6 -> 442
    //   451: getstatic 119	com/tencent/mobileqq/activity/bless/BlessManager:a	Ljava/lang/String;
    //   454: iconst_2
    //   455: new 45	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   462: ldc 127
    //   464: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_2
    //   468: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: goto -38 -> 442
    //   483: astore_1
    //   484: goto -57 -> 427
    //   487: astore_3
    //   488: goto -185 -> 303
    //   491: aconst_null
    //   492: astore_2
    //   493: goto -274 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	ofv
    //   115	78	1	localObject1	Object
    //   259	24	1	localException1	Exception
    //   298	4	1	localException2	Exception
    //   304	55	1	localObject2	Object
    //   383	41	1	localException3	Exception
    //   426	17	1	localObject3	Object
    //   483	1	1	localObject4	Object
    //   87	352	2	localObject5	Object
    //   444	24	2	localException4	Exception
    //   492	1	2	localObject6	Object
    //   155	175	3	localException5	Exception
    //   422	4	3	localObject7	Object
    //   487	1	3	localException6	Exception
    //   150	210	4	localFile	java.io.File
    //   16	188	5	localObject8	Object
    //   165	14	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   230	234	259	java/lang/Exception
    //   158	167	298	java/lang/Exception
    //   169	176	298	java/lang/Exception
    //   178	186	298	java/lang/Exception
    //   193	203	298	java/lang/Exception
    //   376	380	383	java/lang/Exception
    //   158	167	422	finally
    //   169	176	422	finally
    //   178	186	422	finally
    //   193	203	422	finally
    //   305	311	422	finally
    //   313	342	422	finally
    //   349	357	422	finally
    //   359	365	422	finally
    //   438	442	444	java/lang/Exception
    //   203	219	483	finally
    //   203	219	487	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */