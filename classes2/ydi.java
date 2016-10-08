import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.photoplus.PhotoPlusBridgeActivity;

public class ydi
  implements Runnable
{
  public ydi(PhotoPlusBridgeActivity paramPhotoPlusBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 41
    //   8: iconst_4
    //   9: ldc 43
    //   11: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 49	org/apache/http/client/methods/HttpGet
    //   17: dup
    //   18: invokestatic 54	cooperation/photoplus/PhotoPlusBridgeActivity:a	()Ljava/lang/String;
    //   21: invokespecial 57	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: new 59	org/apache/http/impl/client/DefaultHttpClient
    //   28: dup
    //   29: invokespecial 60	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: aload_1
    //   35: invokeinterface 66 2 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 72 1 0
    //   47: invokeinterface 78 1 0
    //   52: sipush 200
    //   55: if_icmpne +255 -> 310
    //   58: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   61: ifeq +11 -> 72
    //   64: ldc 41
    //   66: iconst_4
    //   67: ldc 80
    //   69: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_1
    //   73: invokeinterface 84 1 0
    //   78: invokeinterface 90 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: invokestatic 96	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   88: astore_3
    //   89: aload_1
    //   90: invokevirtual 101	java/io/InputStream:close	()V
    //   93: new 103	java/io/File
    //   96: dup
    //   97: invokestatic 106	cooperation/photoplus/PhotoPlusBridgeActivity:b	()Ljava/lang/String;
    //   100: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 110	java/io/File:exists	()Z
    //   108: ifne +8 -> 116
    //   111: aload_1
    //   112: invokevirtual 113	java/io/File:mkdirs	()Z
    //   115: pop
    //   116: new 103	java/io/File
    //   119: dup
    //   120: invokestatic 106	cooperation/photoplus/PhotoPlusBridgeActivity:b	()Ljava/lang/String;
    //   123: ldc 115
    //   125: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 110	java/io/File:exists	()Z
    //   133: ifeq +8 -> 141
    //   136: aload_1
    //   137: invokevirtual 121	java/io/File:delete	()Z
    //   140: pop
    //   141: new 123	java/io/BufferedOutputStream
    //   144: dup
    //   145: new 125	java/io/FileOutputStream
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   153: invokespecial 131	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: aload_3
    //   160: getstatic 137	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   163: bipush 90
    //   165: aload_2
    //   166: invokevirtual 143	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   169: pop
    //   170: aload_2
    //   171: astore_1
    //   172: aload_2
    //   173: invokevirtual 146	java/io/BufferedOutputStream:flush	()V
    //   176: aload_2
    //   177: astore_1
    //   178: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   181: ifeq +13 -> 194
    //   184: aload_2
    //   185: astore_1
    //   186: ldc 41
    //   188: iconst_4
    //   189: ldc -108
    //   191: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   202: aload_0
    //   203: getfield 12	ydi:a	Lcooperation/photoplus/PhotoPlusBridgeActivity;
    //   206: invokestatic 155	cooperation/photoplus/PhotoPlusBridgeActivity:a	(Lcooperation/photoplus/PhotoPlusBridgeActivity;)Lcom/tencent/util/MqqWeakReferenceHandler;
    //   209: sipush 1004
    //   212: invokevirtual 161	com/tencent/util/MqqWeakReferenceHandler:obtainMessage	(I)Landroid/os/Message;
    //   215: invokevirtual 166	android/os/Message:sendToTarget	()V
    //   218: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   221: ifeq +11 -> 232
    //   224: ldc 41
    //   226: iconst_4
    //   227: ldc -88
    //   229: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: return
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: astore_1
    //   238: aload_3
    //   239: invokevirtual 171	java/io/FileNotFoundException:printStackTrace	()V
    //   242: aload_2
    //   243: ifnull -41 -> 202
    //   246: aload_2
    //   247: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   250: goto -48 -> 202
    //   253: astore_1
    //   254: goto -52 -> 202
    //   257: astore_3
    //   258: aconst_null
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: aload_3
    //   263: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   266: aload_2
    //   267: ifnull -65 -> 202
    //   270: aload_2
    //   271: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   274: goto -72 -> 202
    //   277: astore_1
    //   278: goto -76 -> 202
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 152	java/io/BufferedOutputStream:close	()V
    //   292: aload_2
    //   293: athrow
    //   294: astore_1
    //   295: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   298: ifeq -66 -> 232
    //   301: ldc 41
    //   303: iconst_4
    //   304: ldc -82
    //   306: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: return
    //   310: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   313: ifeq -81 -> 232
    //   316: ldc 41
    //   318: iconst_4
    //   319: ldc -77
    //   321: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: astore_1
    //   326: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   329: ifeq -97 -> 232
    //   332: ldc 41
    //   334: iconst_4
    //   335: ldc -75
    //   337: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: return
    //   341: astore_1
    //   342: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   345: ifeq -113 -> 232
    //   348: ldc 41
    //   350: iconst_4
    //   351: ldc -73
    //   353: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: return
    //   357: astore_1
    //   358: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   361: ifeq -129 -> 232
    //   364: invokestatic 39	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   367: ifeq -135 -> 232
    //   370: ldc 41
    //   372: iconst_4
    //   373: ldc -71
    //   375: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: astore_1
    //   380: goto -178 -> 202
    //   383: astore_1
    //   384: goto -92 -> 292
    //   387: astore_2
    //   388: goto -104 -> 284
    //   391: astore_3
    //   392: goto -132 -> 260
    //   395: astore_3
    //   396: goto -160 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	ydi
    //   24	214	1	localObject1	Object
    //   253	1	1	localException1	Exception
    //   261	1	1	localObject2	Object
    //   277	1	1	localException2	Exception
    //   283	6	1	localObject3	Object
    //   294	1	1	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   325	1	1	localIOException1	java.io.IOException
    //   341	1	1	localException3	Exception
    //   357	1	1	localOutOfMemoryError	OutOfMemoryError
    //   379	1	1	localException4	Exception
    //   383	1	1	localException5	Exception
    //   32	239	2	localObject4	Object
    //   281	12	2	localObject5	Object
    //   387	1	2	localObject6	Object
    //   88	72	3	localBitmap	android.graphics.Bitmap
    //   233	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   257	6	3	localIOException2	java.io.IOException
    //   391	1	3	localIOException3	java.io.IOException
    //   395	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   141	157	233	java/io/FileNotFoundException
    //   246	250	253	java/lang/Exception
    //   141	157	257	java/io/IOException
    //   270	274	277	java/lang/Exception
    //   141	157	281	finally
    //   33	72	294	org/apache/http/client/ClientProtocolException
    //   72	116	294	org/apache/http/client/ClientProtocolException
    //   116	141	294	org/apache/http/client/ClientProtocolException
    //   198	202	294	org/apache/http/client/ClientProtocolException
    //   202	232	294	org/apache/http/client/ClientProtocolException
    //   246	250	294	org/apache/http/client/ClientProtocolException
    //   270	274	294	org/apache/http/client/ClientProtocolException
    //   288	292	294	org/apache/http/client/ClientProtocolException
    //   292	294	294	org/apache/http/client/ClientProtocolException
    //   310	324	294	org/apache/http/client/ClientProtocolException
    //   33	72	325	java/io/IOException
    //   72	116	325	java/io/IOException
    //   116	141	325	java/io/IOException
    //   198	202	325	java/io/IOException
    //   202	232	325	java/io/IOException
    //   246	250	325	java/io/IOException
    //   270	274	325	java/io/IOException
    //   288	292	325	java/io/IOException
    //   292	294	325	java/io/IOException
    //   310	324	325	java/io/IOException
    //   33	72	341	java/lang/Exception
    //   72	116	341	java/lang/Exception
    //   116	141	341	java/lang/Exception
    //   202	232	341	java/lang/Exception
    //   292	294	341	java/lang/Exception
    //   310	324	341	java/lang/Exception
    //   33	72	357	java/lang/OutOfMemoryError
    //   72	116	357	java/lang/OutOfMemoryError
    //   116	141	357	java/lang/OutOfMemoryError
    //   198	202	357	java/lang/OutOfMemoryError
    //   202	232	357	java/lang/OutOfMemoryError
    //   246	250	357	java/lang/OutOfMemoryError
    //   270	274	357	java/lang/OutOfMemoryError
    //   288	292	357	java/lang/OutOfMemoryError
    //   292	294	357	java/lang/OutOfMemoryError
    //   310	324	357	java/lang/OutOfMemoryError
    //   198	202	379	java/lang/Exception
    //   288	292	383	java/lang/Exception
    //   159	170	387	finally
    //   172	176	387	finally
    //   178	184	387	finally
    //   186	194	387	finally
    //   238	242	387	finally
    //   262	266	387	finally
    //   159	170	391	java/io/IOException
    //   172	176	391	java/io/IOException
    //   178	184	391	java/io/IOException
    //   186	194	391	java/io/IOException
    //   159	170	395	java/io/FileNotFoundException
    //   172	176	395	java/io/FileNotFoundException
    //   178	184	395	java/io/FileNotFoundException
    //   186	194	395	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */