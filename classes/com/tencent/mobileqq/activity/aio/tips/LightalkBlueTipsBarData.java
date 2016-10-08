package com.tencent.mobileqq.activity.aio.tips;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LightalkBlueTipsBarData
{
  private static LightalkBlueTipsBarData a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "aio_lightalk_tips_config";
  public static final String c = "__";
  public static final String d = jdField_a_of_type_JavaLangString + File.separator + "aio_lightalk_tips_icon";
  public String e;
  public String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "lightalkfiles";
  }
  
  public static LightalkBlueTipsBarData a()
  {
    long l1 = SystemClock.uptimeMillis();
    c();
    long l2 = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("read config cost ").append(l2 - l1).append(" , result is ");
      if (jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData != null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LightalkBlueTipsBar", 2, bool);
      return jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData = null;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 95
    //   8: iconst_2
    //   9: new 24	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   16: ldc 106
    //   18: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: new 45	java/io/File
    //   34: dup
    //   35: getstatic 63	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:b	Ljava/lang/String;
    //   38: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 112	java/io/File:exists	()Z
    //   46: ifeq +8 -> 54
    //   49: aload_3
    //   50: invokevirtual 115	java/io/File:delete	()Z
    //   53: pop
    //   54: aload_0
    //   55: invokestatic 120	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   58: ifeq +4 -> 62
    //   61: return
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_3
    //   65: invokevirtual 123	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: new 24	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_0
    //   81: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: ldc 11
    //   89: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 4
    //   95: aload_1
    //   96: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: ldc 125
    //   107: invokevirtual 131	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   110: astore 4
    //   112: new 133	java/io/FileOutputStream
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_1
    //   124: aload 4
    //   126: invokevirtual 140	java/io/FileOutputStream:write	([B)V
    //   129: aload_1
    //   130: astore_0
    //   131: aload_1
    //   132: invokevirtual 143	java/io/FileOutputStream:flush	()V
    //   135: aload_1
    //   136: ifnull -75 -> 61
    //   139: aload_1
    //   140: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   143: return
    //   144: astore_0
    //   145: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -87 -> 61
    //   151: ldc 95
    //   153: iconst_2
    //   154: ldc -108
    //   156: aload_0
    //   157: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: return
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: astore_0
    //   166: aload_2
    //   167: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   170: aload_1
    //   171: ifnull -110 -> 61
    //   174: aload_1
    //   175: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   178: return
    //   179: astore_0
    //   180: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq -122 -> 61
    //   186: ldc 95
    //   188: iconst_2
    //   189: ldc -108
    //   191: aload_0
    //   192: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_0
    //   197: aload_2
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_1
    //   210: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -6 -> 207
    //   216: ldc 95
    //   218: iconst_2
    //   219: ldc -108
    //   221: aload_1
    //   222: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: goto -18 -> 207
    //   228: astore_2
    //   229: aload_0
    //   230: astore_1
    //   231: aload_2
    //   232: astore_0
    //   233: goto -34 -> 199
    //   236: astore_2
    //   237: goto -73 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString1	String
    //   0	240	1	paramString2	String
    //   63	1	2	localObject1	Object
    //   161	37	2	localIOException1	java.io.IOException
    //   228	4	2	localObject2	Object
    //   236	1	2	localIOException2	java.io.IOException
    //   41	76	3	localFile	File
    //   76	49	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   139	143	144	java/io/IOException
    //   64	121	161	java/io/IOException
    //   174	178	179	java/io/IOException
    //   64	121	196	finally
    //   203	207	209	java/io/IOException
    //   123	129	228	finally
    //   131	135	228	finally
    //   166	170	228	finally
    //   123	129	236	java/io/IOException
    //   131	135	236	java/io/IOException
  }
  
  public static void b()
  {
    try
    {
      File localFile1 = new File(b);
      File localFile2 = new File(d);
      if (localFile1.exists()) {
        localFile1.delete();
      }
      if (localFile2.exists()) {
        localFile2.delete();
      }
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("lightalkttips", 2, "delete config error");
    }
  }
  
  /* Error */
  private static void c()
  {
    // Byte code:
    //   0: getstatic 93	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   3: ifnull +4 -> 7
    //   6: return
    //   7: new 45	java/io/File
    //   10: dup
    //   11: getstatic 63	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:b	Ljava/lang/String;
    //   14: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 45	java/io/File
    //   21: dup
    //   22: getstatic 67	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:d	Ljava/lang/String;
    //   25: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 112	java/io/File:exists	()Z
    //   33: ifeq +204 -> 237
    //   36: aload_0
    //   37: invokevirtual 169	java/io/File:length	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle +195 -> 237
    //   45: aload_1
    //   46: invokevirtual 112	java/io/File:exists	()Z
    //   49: ifeq +188 -> 237
    //   52: new 171	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 176	java/io/FileInputStream:available	()I
    //   67: newarray <illegal type>
    //   69: astore_2
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 180	java/io/FileInputStream:read	([B)I
    //   77: pop
    //   78: aload_1
    //   79: astore_0
    //   80: new 127	java/lang/String
    //   83: dup
    //   84: aload_2
    //   85: ldc 125
    //   87: invokespecial 183	java/lang/String:<init>	([BLjava/lang/String;)V
    //   90: ldc 11
    //   92: invokevirtual 187	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: astore_0
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_2
    //   101: if_icmpne +37 -> 138
    //   104: aload_1
    //   105: astore_0
    //   106: new 2	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData
    //   109: dup
    //   110: invokespecial 188	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:<init>	()V
    //   113: putstatic 93	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   116: aload_1
    //   117: astore_0
    //   118: getstatic 93	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   121: aload_2
    //   122: iconst_0
    //   123: aaload
    //   124: putfield 190	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:e	Ljava/lang/String;
    //   127: aload_1
    //   128: astore_0
    //   129: getstatic 93	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   132: aload_2
    //   133: iconst_1
    //   134: aaload
    //   135: putfield 192	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Ljava/lang/String;
    //   138: aload_1
    //   139: ifnull -133 -> 6
    //   142: aload_1
    //   143: invokevirtual 193	java/io/FileInputStream:close	()V
    //   146: return
    //   147: astore_0
    //   148: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq -145 -> 6
    //   154: ldc 95
    //   156: iconst_2
    //   157: ldc -108
    //   159: aload_0
    //   160: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: return
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: astore_0
    //   169: aload_2
    //   170: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   173: aload_1
    //   174: astore_0
    //   175: aconst_null
    //   176: putstatic 93	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBarData	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   179: aload_1
    //   180: ifnull -174 -> 6
    //   183: aload_1
    //   184: invokevirtual 193	java/io/FileInputStream:close	()V
    //   187: return
    //   188: astore_0
    //   189: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -186 -> 6
    //   195: ldc 95
    //   197: iconst_2
    //   198: ldc -108
    //   200: aload_0
    //   201: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: return
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 193	java/io/FileInputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_0
    //   219: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -6 -> 216
    //   225: ldc 95
    //   227: iconst_2
    //   228: ldc -108
    //   230: aload_0
    //   231: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: goto -18 -> 216
    //   237: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -234 -> 6
    //   243: ldc 95
    //   245: iconst_2
    //   246: ldc -60
    //   248: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: astore_1
    //   253: goto -45 -> 208
    //   256: astore_2
    //   257: goto -90 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	112	0	localObject1	Object
    //   147	13	0	localIOException1	java.io.IOException
    //   168	7	0	localObject2	Object
    //   188	13	0	localIOException2	java.io.IOException
    //   207	6	0	localObject3	Object
    //   218	13	0	localIOException3	java.io.IOException
    //   28	156	1	localObject4	Object
    //   205	12	1	localObject5	Object
    //   252	1	1	localObject6	Object
    //   69	64	2	localObject7	Object
    //   164	6	2	localException1	Exception
    //   256	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   142	146	147	java/io/IOException
    //   52	61	164	java/lang/Exception
    //   183	187	188	java/io/IOException
    //   52	61	205	finally
    //   212	216	218	java/io/IOException
    //   63	70	252	finally
    //   72	78	252	finally
    //   80	96	252	finally
    //   98	104	252	finally
    //   106	116	252	finally
    //   118	127	252	finally
    //   129	138	252	finally
    //   169	173	252	finally
    //   175	179	252	finally
    //   63	70	256	java/lang/Exception
    //   72	78	256	java/lang/Exception
    //   80	96	256	java/lang/Exception
    //   98	104	256	java/lang/Exception
    //   106	116	256	java/lang/Exception
    //   118	127	256	java/lang/Exception
    //   129	138	256	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\LightalkBlueTipsBarData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */