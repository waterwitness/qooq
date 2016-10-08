import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ouz
  implements Runnable
{
  public ouz(PreloadManager paramPreloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: new 29	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 12	ouz:a	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;
    //   13: getfield 34	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   16: invokestatic 37	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   19: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 44	java/io/File:exists	()Z
    //   27: ifne +26 -> 53
    //   30: aload_1
    //   31: invokevirtual 48	java/io/File:getParentFile	()Ljava/io/File;
    //   34: invokevirtual 44	java/io/File:exists	()Z
    //   37: ifne +11 -> 48
    //   40: aload_1
    //   41: invokevirtual 48	java/io/File:getParentFile	()Ljava/io/File;
    //   44: invokevirtual 51	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload_1
    //   49: invokevirtual 54	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: new 56	java/io/FileOutputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 59	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_1
    //   62: new 61	java/io/ByteArrayOutputStream
    //   65: dup
    //   66: invokespecial 62	java/io/ByteArrayOutputStream:<init>	()V
    //   69: astore 4
    //   71: new 64	java/io/ObjectOutputStream
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 67	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore_3
    //   81: aload_3
    //   82: aload_0
    //   83: getfield 12	ouz:a	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;
    //   86: getfield 70	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   89: invokevirtual 74	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   92: aload_3
    //   93: invokevirtual 77	java/io/ObjectOutputStream:flush	()V
    //   96: aload 4
    //   98: aload_1
    //   99: invokevirtual 80	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   102: aload_3
    //   103: ifnull +7 -> 110
    //   106: aload_3
    //   107: invokevirtual 83	java/io/ObjectOutputStream:close	()V
    //   110: aload 4
    //   112: ifnull +8 -> 120
    //   115: aload 4
    //   117: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   134: return
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_3
    //   141: aload 4
    //   143: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   146: aload_3
    //   147: ifnull +7 -> 154
    //   150: aload_3
    //   151: invokevirtual 83	java/io/ObjectOutputStream:close	()V
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   162: aload_2
    //   163: ifnull -35 -> 128
    //   166: aload_2
    //   167: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   170: return
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   176: return
    //   177: astore_1
    //   178: aconst_null
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_3
    //   183: aload 5
    //   185: astore_2
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 83	java/io/ObjectOutputStream:close	()V
    //   194: aload 4
    //   196: ifnull +8 -> 204
    //   199: aload 4
    //   201: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   219: goto -7 -> 212
    //   222: astore 5
    //   224: aconst_null
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_1
    //   230: astore_2
    //   231: aload 5
    //   233: astore_1
    //   234: goto -48 -> 186
    //   237: astore 5
    //   239: aconst_null
    //   240: astore_3
    //   241: aload_1
    //   242: astore_2
    //   243: aload 5
    //   245: astore_1
    //   246: goto -60 -> 186
    //   249: astore 5
    //   251: aload_1
    //   252: astore_2
    //   253: aload 5
    //   255: astore_1
    //   256: goto -70 -> 186
    //   259: astore 5
    //   261: aload_1
    //   262: astore 4
    //   264: aload 5
    //   266: astore_1
    //   267: goto -81 -> 186
    //   270: astore 4
    //   272: aconst_null
    //   273: astore_3
    //   274: aconst_null
    //   275: astore 5
    //   277: aload_1
    //   278: astore_2
    //   279: aload 5
    //   281: astore_1
    //   282: goto -141 -> 141
    //   285: astore_2
    //   286: aload 4
    //   288: astore_3
    //   289: aconst_null
    //   290: astore 5
    //   292: aload_2
    //   293: astore 4
    //   295: aload_1
    //   296: astore_2
    //   297: aload_3
    //   298: astore_1
    //   299: aload 5
    //   301: astore_3
    //   302: goto -161 -> 141
    //   305: astore_2
    //   306: aload 4
    //   308: astore 5
    //   310: aload_2
    //   311: astore 4
    //   313: aload_1
    //   314: astore_2
    //   315: aload 5
    //   317: astore_1
    //   318: goto -177 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	ouz
    //   22	103	1	localObject1	Object
    //   129	2	1	localIOException1	java.io.IOException
    //   138	21	1	localObject2	Object
    //   171	2	1	localIOException2	java.io.IOException
    //   177	53	1	localObject3	Object
    //   233	85	1	localObject4	Object
    //   4	205	2	localObject5	Object
    //   214	2	2	localIOException3	java.io.IOException
    //   230	49	2	localObject6	Object
    //   285	8	2	localException1	Exception
    //   296	1	2	localObject7	Object
    //   305	6	2	localException2	Exception
    //   314	1	2	localObject8	Object
    //   80	222	3	localObject9	Object
    //   69	47	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   135	7	4	localException3	Exception
    //   179	84	4	localObject10	Object
    //   270	17	4	localException4	Exception
    //   293	19	4	localException5	Exception
    //   1	183	5	localObject11	Object
    //   222	10	5	localObject12	Object
    //   237	7	5	localObject13	Object
    //   249	5	5	localObject14	Object
    //   259	6	5	localObject15	Object
    //   275	41	5	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   106	110	129	java/io/IOException
    //   115	120	129	java/io/IOException
    //   124	128	129	java/io/IOException
    //   5	48	135	java/lang/Exception
    //   48	53	135	java/lang/Exception
    //   53	62	135	java/lang/Exception
    //   150	154	171	java/io/IOException
    //   158	162	171	java/io/IOException
    //   166	170	171	java/io/IOException
    //   5	48	177	finally
    //   48	53	177	finally
    //   53	62	177	finally
    //   190	194	214	java/io/IOException
    //   199	204	214	java/io/IOException
    //   208	212	214	java/io/IOException
    //   62	71	222	finally
    //   71	81	237	finally
    //   81	102	249	finally
    //   141	146	259	finally
    //   62	71	270	java/lang/Exception
    //   71	81	285	java/lang/Exception
    //   81	102	305	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */