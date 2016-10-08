import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

public class sxs
  implements Runnable
{
  public sxs(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 42	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 43	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 17	sxs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: ldc 51
    //   23: invokevirtual 57	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   26: ifeq +35 -> 61
    //   29: aload_0
    //   30: getfield 17	sxs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: bipush 44
    //   35: invokevirtual 61	java/lang/String:indexOf	(I)I
    //   38: istore 5
    //   40: aload_2
    //   41: astore_1
    //   42: iload 5
    //   44: ifle +17 -> 61
    //   47: aload_0
    //   48: getfield 17	sxs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: iload 5
    //   53: invokevirtual 65	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: iconst_0
    //   57: invokestatic 71	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   60: astore_1
    //   61: aload_1
    //   62: ifnonnull +79 -> 141
    //   65: new 36	java/lang/IllegalArgumentException
    //   68: dup
    //   69: invokespecial 72	java/lang/IllegalArgumentException:<init>	()V
    //   72: athrow
    //   73: astore_1
    //   74: aload_3
    //   75: ldc 74
    //   77: iconst_1
    //   78: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload_3
    //   83: ldc 80
    //   85: aload 4
    //   87: ldc 81
    //   89: invokevirtual 86	android/content/Context:getString	(I)Ljava/lang/String;
    //   92: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_0
    //   97: getfield 19	sxs:b	Ljava/lang/String;
    //   100: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +144 -> 247
    //   106: aload_0
    //   107: getfield 21	sxs:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   110: iconst_0
    //   111: iconst_1
    //   112: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   115: ifeq +132 -> 247
    //   118: aload_0
    //   119: getfield 15	sxs:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   122: aload_0
    //   123: getfield 19	sxs:b	Ljava/lang/String;
    //   126: iconst_1
    //   127: anewarray 53	java/lang/String
    //   130: dup
    //   131: iconst_0
    //   132: aload_3
    //   133: invokevirtual 105	org/json/JSONObject:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokevirtual 111	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 15	sxs:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   145: aload_1
    //   146: invokestatic 114	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;[B)Ljava/lang/String;
    //   149: astore_1
    //   150: aload_3
    //   151: ldc 74
    //   153: iconst_0
    //   154: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_3
    //   159: ldc 80
    //   161: aload 4
    //   163: ldc 115
    //   165: invokevirtual 86	android/content/Context:getString	(I)Ljava/lang/String;
    //   168: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload_3
    //   173: ldc 117
    //   175: aload_1
    //   176: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: goto -84 -> 96
    //   183: astore_1
    //   184: goto -88 -> 96
    //   187: astore_1
    //   188: aload_3
    //   189: ldc 74
    //   191: iconst_2
    //   192: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_3
    //   197: ldc 80
    //   199: aload 4
    //   201: ldc 118
    //   203: invokevirtual 86	android/content/Context:getString	(I)Ljava/lang/String;
    //   206: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   209: pop
    //   210: goto -114 -> 96
    //   213: astore_1
    //   214: goto -118 -> 96
    //   217: astore_1
    //   218: aload_3
    //   219: ldc 74
    //   221: iconst_m1
    //   222: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload_3
    //   227: ldc 80
    //   229: aload 4
    //   231: ldc 119
    //   233: invokevirtual 86	android/content/Context:getString	(I)Ljava/lang/String;
    //   236: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: goto -144 -> 96
    //   243: astore_1
    //   244: goto -148 -> 96
    //   247: aload_0
    //   248: getfield 15	sxs:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   251: ldc 121
    //   253: iconst_0
    //   254: aload_3
    //   255: invokevirtual 105	org/json/JSONObject:toString	()Ljava/lang/String;
    //   258: invokestatic 125	com/tencent/mobileqq/jsp/MediaApiPlugin:d	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   261: return
    //   262: astore_1
    //   263: goto -167 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	sxs
    //   16	46	1	localObject1	Object
    //   73	73	1	localIOException	java.io.IOException
    //   149	27	1	str	String
    //   183	1	1	localJSONException1	org.json.JSONException
    //   187	1	1	localIllegalArgumentException	IllegalArgumentException
    //   213	1	1	localJSONException2	org.json.JSONException
    //   217	1	1	localOutOfMemoryError	OutOfMemoryError
    //   243	1	1	localJSONException3	org.json.JSONException
    //   262	1	1	localJSONException4	org.json.JSONException
    //   14	27	2	localObject2	Object
    //   7	248	3	localJSONObject	org.json.JSONObject
    //   11	219	4	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   38	14	5	i	int
    // Exception table:
    //   from	to	target	type
    //   17	40	73	java/io/IOException
    //   47	61	73	java/io/IOException
    //   65	73	73	java/io/IOException
    //   141	150	73	java/io/IOException
    //   150	180	73	java/io/IOException
    //   150	180	183	org/json/JSONException
    //   17	40	187	java/lang/IllegalArgumentException
    //   47	61	187	java/lang/IllegalArgumentException
    //   65	73	187	java/lang/IllegalArgumentException
    //   141	150	187	java/lang/IllegalArgumentException
    //   150	180	187	java/lang/IllegalArgumentException
    //   188	210	213	org/json/JSONException
    //   17	40	217	java/lang/OutOfMemoryError
    //   47	61	217	java/lang/OutOfMemoryError
    //   65	73	217	java/lang/OutOfMemoryError
    //   141	150	217	java/lang/OutOfMemoryError
    //   150	180	217	java/lang/OutOfMemoryError
    //   218	240	243	org/json/JSONException
    //   74	96	262	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */