import android.graphics.Bitmap;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jia
  extends Thread
{
  public jia(Share paramShare, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, Bitmap paramBitmap, int paramInt)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 46	java/util/HashMap
    //   3: dup
    //   4: invokespecial 47	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 18	jia:jdField_a_of_type_Boolean	Z
    //   12: ifeq +14 -> 26
    //   15: aload_3
    //   16: ldc 49
    //   18: aload_0
    //   19: getfield 20	jia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: invokevirtual 53	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: aload_0
    //   27: getfield 22	jia:b	Z
    //   30: ifeq +17 -> 47
    //   33: aload_3
    //   34: ldc 55
    //   36: aload_0
    //   37: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   40: getfield 60	com/tencent/biz/webviewplugin/Share:d	Ljava/lang/String;
    //   43: invokevirtual 53	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: aload_3
    //   48: invokestatic 65	com/tencent/biz/common/util/HttpUtil:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 18	jia:jdField_a_of_type_Boolean	Z
    //   56: ifeq +258 -> 314
    //   59: aload_3
    //   60: ldc 49
    //   62: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 71	java/lang/String
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   74: getfield 73	com/tencent/biz/webviewplugin/Share:c	Ljava/lang/String;
    //   77: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifeq +243 -> 323
    //   83: aload 5
    //   85: astore 9
    //   87: aload_0
    //   88: getfield 22	jia:b	Z
    //   91: ifeq +244 -> 335
    //   94: aload_3
    //   95: ldc 55
    //   97: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 71	java/lang/String
    //   103: astore 10
    //   105: aload_0
    //   106: getfield 24	jia:c	Z
    //   109: ifeq +250 -> 359
    //   112: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   115: aload_0
    //   116: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   119: getfield 60	com/tencent/biz/webviewplugin/Share:d	Ljava/lang/String;
    //   122: ldc 87
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokestatic 90	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   129: astore_3
    //   130: aload_3
    //   131: ifnull +270 -> 401
    //   134: aload_3
    //   135: iconst_0
    //   136: aload_3
    //   137: arraylength
    //   138: invokestatic 96	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   141: astore_3
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: ifnull +139 -> 285
    //   149: aload_3
    //   150: astore 6
    //   152: aload_3
    //   153: astore 7
    //   155: aload_3
    //   156: astore 8
    //   158: aload_3
    //   159: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   162: istore 11
    //   164: aload_3
    //   165: astore 6
    //   167: aload_3
    //   168: astore 7
    //   170: aload_3
    //   171: astore 8
    //   173: aload_3
    //   174: invokevirtual 105	android/graphics/Bitmap:getHeight	()I
    //   177: istore 12
    //   179: aload_3
    //   180: astore 4
    //   182: iload 11
    //   184: iload 12
    //   186: imul
    //   187: sipush 8000
    //   190: if_icmple +67 -> 257
    //   193: aload_3
    //   194: astore 6
    //   196: aload_3
    //   197: astore 7
    //   199: aload_3
    //   200: astore 8
    //   202: ldc2_w 106
    //   205: iload 11
    //   207: iload 12
    //   209: imul
    //   210: i2d
    //   211: ddiv
    //   212: invokestatic 113	java/lang/Math:sqrt	(D)D
    //   215: dstore_1
    //   216: aload_3
    //   217: astore 6
    //   219: aload_3
    //   220: astore 7
    //   222: aload_3
    //   223: astore 8
    //   225: aload_3
    //   226: iload 11
    //   228: i2d
    //   229: dload_1
    //   230: dmul
    //   231: d2i
    //   232: iload 12
    //   234: i2d
    //   235: dload_1
    //   236: dmul
    //   237: d2i
    //   238: iconst_1
    //   239: invokestatic 117	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   242: astore 4
    //   244: aload_3
    //   245: astore 6
    //   247: aload_3
    //   248: astore 7
    //   250: aload_3
    //   251: astore 8
    //   253: aload_3
    //   254: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   257: aload 4
    //   259: astore 6
    //   261: aload 4
    //   263: astore 7
    //   265: aload 4
    //   267: astore 8
    //   269: aload_0
    //   270: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   273: new 122	java/lang/ref/WeakReference
    //   276: dup
    //   277: aload 4
    //   279: invokespecial 125	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   282: putfield 128	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   285: aload 4
    //   287: astore_3
    //   288: aload_0
    //   289: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   292: getfield 131	com/tencent/biz/webviewplugin/Share:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   295: new 133	jib
    //   298: dup
    //   299: aload_0
    //   300: aload 9
    //   302: aload 5
    //   304: aload 10
    //   306: aload_3
    //   307: invokespecial 136	jib:<init>	(Ljia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   310: invokevirtual 142	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   313: return
    //   314: aload_0
    //   315: getfield 20	jia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   318: astore 5
    //   320: goto -250 -> 70
    //   323: aload_0
    //   324: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   327: getfield 73	com/tencent/biz/webviewplugin/Share:c	Ljava/lang/String;
    //   330: astore 9
    //   332: goto -245 -> 87
    //   335: aload_0
    //   336: getfield 16	jia:jdField_a_of_type_ComTencentBizWebviewpluginShare	Lcom/tencent/biz/webviewplugin/Share;
    //   339: getfield 60	com/tencent/biz/webviewplugin/Share:d	Ljava/lang/String;
    //   342: astore 10
    //   344: goto -239 -> 105
    //   347: astore 4
    //   349: aconst_null
    //   350: astore_3
    //   351: aload 4
    //   353: invokevirtual 145	java/lang/IllegalArgumentException:printStackTrace	()V
    //   356: goto -68 -> 288
    //   359: aload_0
    //   360: getfield 26	jia:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   363: astore_3
    //   364: goto -76 -> 288
    //   367: astore 4
    //   369: aload 6
    //   371: astore_3
    //   372: goto -21 -> 351
    //   375: astore_3
    //   376: aconst_null
    //   377: astore_3
    //   378: goto -90 -> 288
    //   381: astore_3
    //   382: aload 7
    //   384: astore_3
    //   385: goto -97 -> 288
    //   388: astore_3
    //   389: aconst_null
    //   390: astore_3
    //   391: goto -103 -> 288
    //   394: astore_3
    //   395: aload 8
    //   397: astore_3
    //   398: goto -110 -> 288
    //   401: aconst_null
    //   402: astore 4
    //   404: goto -119 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	jia
    //   215	21	1	d	double
    //   7	365	3	localObject1	Object
    //   375	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   377	1	3	localObject2	Object
    //   381	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   384	1	3	localObject3	Object
    //   388	1	3	localIOException1	java.io.IOException
    //   390	1	3	localObject4	Object
    //   394	1	3	localIOException2	java.io.IOException
    //   397	1	3	localObject5	Object
    //   143	143	4	localObject6	Object
    //   347	5	4	localIllegalArgumentException1	IllegalArgumentException
    //   367	1	4	localIllegalArgumentException2	IllegalArgumentException
    //   402	1	4	localObject7	Object
    //   68	251	5	str1	String
    //   150	220	6	localObject8	Object
    //   153	230	7	localObject9	Object
    //   156	240	8	localObject10	Object
    //   85	246	9	str2	String
    //   103	240	10	str3	String
    //   162	65	11	i	int
    //   177	56	12	j	int
    // Exception table:
    //   from	to	target	type
    //   112	130	347	java/lang/IllegalArgumentException
    //   134	142	347	java/lang/IllegalArgumentException
    //   158	164	367	java/lang/IllegalArgumentException
    //   173	179	367	java/lang/IllegalArgumentException
    //   202	216	367	java/lang/IllegalArgumentException
    //   225	244	367	java/lang/IllegalArgumentException
    //   253	257	367	java/lang/IllegalArgumentException
    //   269	285	367	java/lang/IllegalArgumentException
    //   112	130	375	java/lang/OutOfMemoryError
    //   134	142	375	java/lang/OutOfMemoryError
    //   158	164	381	java/lang/OutOfMemoryError
    //   173	179	381	java/lang/OutOfMemoryError
    //   202	216	381	java/lang/OutOfMemoryError
    //   225	244	381	java/lang/OutOfMemoryError
    //   253	257	381	java/lang/OutOfMemoryError
    //   269	285	381	java/lang/OutOfMemoryError
    //   112	130	388	java/io/IOException
    //   134	142	388	java/io/IOException
    //   158	164	394	java/io/IOException
    //   173	179	394	java/io/IOException
    //   202	216	394	java/io/IOException
    //   225	244	394	java/io/IOException
    //   253	257	394	java/io/IOException
    //   269	285	394	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */