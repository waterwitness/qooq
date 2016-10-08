import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class tjf
  implements Runnable
{
  public tjf(NearbyGuideActivity paramNearbyGuideActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 13	tjf:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   9: invokevirtual 36	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:getResources	()Landroid/content/res/Resources;
    //   12: ldc 37
    //   14: invokevirtual 43	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   17: istore 9
    //   19: iconst_0
    //   20: istore 6
    //   22: iconst_0
    //   23: istore 8
    //   25: iconst_0
    //   26: istore 7
    //   28: new 45	java/io/FileInputStream
    //   31: dup
    //   32: new 47	java/io/File
    //   35: dup
    //   36: aload_0
    //   37: getfield 15	tjf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_1
    //   47: iload 8
    //   49: istore 6
    //   51: aload_1
    //   52: astore_2
    //   53: new 55	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 56	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 5
    //   62: iload 8
    //   64: istore 6
    //   66: aload_1
    //   67: astore_2
    //   68: aload 5
    //   70: aload_1
    //   71: iload 9
    //   73: iload 9
    //   75: invokestatic 61	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   78: d2i
    //   79: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: iload 8
    //   84: istore 6
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 70	java/io/InputStream:close	()V
    //   92: aload 4
    //   94: astore_3
    //   95: aload_0
    //   96: getfield 15	tjf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: aload 5
    //   101: invokestatic 75	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: astore 4
    //   106: aload 4
    //   108: astore_2
    //   109: aload 4
    //   111: ifnull +22 -> 133
    //   114: aload 4
    //   116: astore_3
    //   117: aload 4
    //   119: aload 4
    //   121: invokevirtual 81	android/graphics/Bitmap:getWidth	()I
    //   124: aload 4
    //   126: invokevirtual 84	android/graphics/Bitmap:getHeight	()I
    //   129: invokestatic 87	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   132: astore_2
    //   133: aload_2
    //   134: ifnonnull +119 -> 253
    //   137: aload_0
    //   138: getfield 13	tjf:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   141: iconst_1
    //   142: ldc 89
    //   144: invokevirtual 92	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	(ILjava/lang/String;)V
    //   147: return
    //   148: astore 4
    //   150: aconst_null
    //   151: astore_1
    //   152: iload 7
    //   154: istore 6
    //   156: aload_1
    //   157: astore_2
    //   158: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +20 -> 181
    //   164: iload 7
    //   166: istore 6
    //   168: aload_1
    //   169: astore_2
    //   170: ldc 100
    //   172: iconst_2
    //   173: aload 4
    //   175: invokevirtual 104	java/lang/Throwable:toString	()Ljava/lang/String;
    //   178: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_3
    //   182: astore_2
    //   183: iload 7
    //   185: ifne -52 -> 133
    //   188: aload_3
    //   189: astore_2
    //   190: aload_1
    //   191: ifnull -58 -> 133
    //   194: aload_1
    //   195: invokevirtual 70	java/io/InputStream:close	()V
    //   198: aload_3
    //   199: astore_2
    //   200: goto -67 -> 133
    //   203: astore_1
    //   204: aload_3
    //   205: astore_2
    //   206: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   209: ifeq -76 -> 133
    //   212: aload_1
    //   213: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   216: aload_3
    //   217: astore_2
    //   218: goto -85 -> 133
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_1
    //   224: iload 6
    //   226: ifne +11 -> 237
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 70	java/io/InputStream:close	()V
    //   237: aload_3
    //   238: athrow
    //   239: astore_1
    //   240: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   243: ifeq -6 -> 237
    //   246: aload_1
    //   247: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   250: goto -13 -> 237
    //   253: aload_2
    //   254: ifnull -107 -> 147
    //   257: invokestatic 120	android/os/Message:obtain	()Landroid/os/Message;
    //   260: astore_1
    //   261: aload_1
    //   262: iconst_2
    //   263: putfield 123	android/os/Message:what	I
    //   266: aload_1
    //   267: aload_2
    //   268: putfield 127	android/os/Message:obj	Ljava/lang/Object;
    //   271: aload_0
    //   272: getfield 13	tjf:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   275: getfield 130	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	Landroid/os/Handler;
    //   278: aload_1
    //   279: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   282: pop
    //   283: return
    //   284: astore_3
    //   285: aload_2
    //   286: astore_1
    //   287: goto -63 -> 224
    //   290: astore_3
    //   291: iconst_1
    //   292: istore 6
    //   294: goto -70 -> 224
    //   297: astore 4
    //   299: goto -147 -> 152
    //   302: astore 4
    //   304: iconst_1
    //   305: istore 7
    //   307: goto -155 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	tjf
    //   46	149	1	localFileInputStream	java.io.FileInputStream
    //   203	10	1	localIOException1	java.io.IOException
    //   223	11	1	localObject1	Object
    //   239	8	1	localIOException2	java.io.IOException
    //   260	27	1	localObject2	Object
    //   52	234	2	localObject3	Object
    //   4	213	3	localBitmap1	android.graphics.Bitmap
    //   221	17	3	localObject4	Object
    //   284	1	3	localObject5	Object
    //   290	1	3	localObject6	Object
    //   1	124	4	localBitmap2	android.graphics.Bitmap
    //   148	26	4	localThrowable1	Throwable
    //   297	1	4	localThrowable2	Throwable
    //   302	1	4	localThrowable3	Throwable
    //   60	40	5	localOptions	android.graphics.BitmapFactory.Options
    //   20	273	6	i	int
    //   26	280	7	j	int
    //   23	60	8	k	int
    //   17	57	9	m	int
    // Exception table:
    //   from	to	target	type
    //   28	47	148	java/lang/Throwable
    //   194	198	203	java/io/IOException
    //   28	47	221	finally
    //   233	237	239	java/io/IOException
    //   53	62	284	finally
    //   68	82	284	finally
    //   88	92	284	finally
    //   158	164	284	finally
    //   170	181	284	finally
    //   95	106	290	finally
    //   117	133	290	finally
    //   53	62	297	java/lang/Throwable
    //   68	82	297	java/lang/Throwable
    //   88	92	297	java/lang/Throwable
    //   95	106	302	java/lang/Throwable
    //   117	133	302	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */