package com.tencent.mobileqq.activity.recent;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LightTalkTipsData
{
  private static LightTalkTipsData a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "lightalk_tips_config";
  public static final String c = "__";
  public static final String d = jdField_a_of_type_JavaLangString + File.separator + "qq_aio_tips_lightalk_icon";
  public String e;
  public String f;
  private String g;
  private String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "lightalkfiles";
  }
  
  public static LightTalkTipsData a()
  {
    long l1 = SystemClock.uptimeMillis();
    c();
    long l2 = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("read config cost ").append(l2 - l1).append(" , result is ");
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData != null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("lightalktips", 2, bool);
      return jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData = null;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 111	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   4: ifne +24 -> 28
    //   7: aload_1
    //   8: invokestatic 111	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   11: ifne +17 -> 28
    //   14: aload_2
    //   15: invokestatic 111	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: aload_3
    //   22: invokestatic 111	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   25: ifeq +18 -> 43
    //   28: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 97
    //   36: iconst_2
    //   37: ldc 113
    //   39: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: new 47	java/io/File
    //   46: dup
    //   47: getstatic 61	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 119	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: new 47	java/io/File
    //   60: dup
    //   61: getstatic 65	com/tencent/mobileqq/activity/recent/LightTalkTipsData:b	Ljava/lang/String;
    //   64: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 5
    //   71: invokevirtual 122	java/io/File:exists	()Z
    //   74: ifeq +9 -> 83
    //   77: aload 5
    //   79: invokevirtual 125	java/io/File:delete	()Z
    //   82: pop
    //   83: aconst_null
    //   84: astore 4
    //   86: aload 5
    //   88: invokevirtual 128	java/io/File:createNewFile	()Z
    //   91: pop
    //   92: new 26	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_0
    //   104: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: ldc 11
    //   112: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 6
    //   118: aload_1
    //   119: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 6
    //   125: ldc 11
    //   127: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 6
    //   133: aload_2
    //   134: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 6
    //   140: ldc 11
    //   142: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: aload_3
    //   149: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 6
    //   155: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: ldc -126
    //   160: invokevirtual 136	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   163: astore_2
    //   164: new 138	java/io/FileOutputStream
    //   167: dup
    //   168: aload 5
    //   170: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   173: astore_1
    //   174: aload_1
    //   175: astore_0
    //   176: aload_1
    //   177: aload_2
    //   178: invokevirtual 145	java/io/FileOutputStream:write	([B)V
    //   181: aload_1
    //   182: astore_0
    //   183: aload_1
    //   184: invokevirtual 148	java/io/FileOutputStream:flush	()V
    //   187: aload_1
    //   188: ifnull -146 -> 42
    //   191: aload_1
    //   192: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   195: return
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   201: return
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_1
    //   206: astore_0
    //   207: aload_2
    //   208: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   211: aload_1
    //   212: ifnull -170 -> 42
    //   215: aload_1
    //   216: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   219: return
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   225: return
    //   226: astore_0
    //   227: aload 4
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   245: goto -7 -> 238
    //   248: astore_2
    //   249: aload_0
    //   250: astore_1
    //   251: aload_2
    //   252: astore_0
    //   253: goto -23 -> 230
    //   256: astore_2
    //   257: goto -52 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramString1	String
    //   0	260	1	paramString2	String
    //   0	260	2	paramString3	String
    //   0	260	3	paramString4	String
    //   84	144	4	localObject	Object
    //   67	102	5	localFile	File
    //   99	55	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   191	195	196	java/io/IOException
    //   86	174	202	java/io/IOException
    //   215	219	220	java/io/IOException
    //   86	174	226	finally
    //   234	238	240	java/io/IOException
    //   176	181	248	finally
    //   183	187	248	finally
    //   207	211	248	finally
    //   176	181	256	java/io/IOException
    //   183	187	256	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LightTalkTipsData localLightTalkTipsData = a();
    if ((localLightTalkTipsData != null) && (((localLightTalkTipsData.e != null) && (paramString1 != null) && (!paramString1.equals(localLightTalkTipsData.e))) || ((localLightTalkTipsData.f != null) && (paramString2 != null) && (!paramString2.equals(localLightTalkTipsData.f))) || ((localLightTalkTipsData.g != null) && (paramString3 != null) && (!paramString3.equals(localLightTalkTipsData.g))) || ((localLightTalkTipsData.h != null) && (paramString4 != null) && (!paramString4.equals(localLightTalkTipsData.h))))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        b();
      }
      return bool;
    }
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
    //   0: getstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   3: ifnull +18 -> 21
    //   6: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 97
    //   14: iconst_2
    //   15: ldc -71
    //   17: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: new 47	java/io/File
    //   24: dup
    //   25: getstatic 65	com/tencent/mobileqq/activity/recent/LightTalkTipsData:b	Ljava/lang/String;
    //   28: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: new 47	java/io/File
    //   35: dup
    //   36: getstatic 69	com/tencent/mobileqq/activity/recent/LightTalkTipsData:d	Ljava/lang/String;
    //   39: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 122	java/io/File:exists	()Z
    //   47: ifeq -27 -> 20
    //   50: aload_0
    //   51: invokevirtual 188	java/io/File:length	()J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle -36 -> 20
    //   59: aload_1
    //   60: invokevirtual 122	java/io/File:exists	()Z
    //   63: ifeq -43 -> 20
    //   66: new 190	java/io/FileInputStream
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 191	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 195	java/io/FileInputStream:available	()I
    //   81: newarray <illegal type>
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 199	java/io/FileInputStream:read	([B)I
    //   91: pop
    //   92: aload_1
    //   93: astore_0
    //   94: new 132	java/lang/String
    //   97: dup
    //   98: aload_2
    //   99: ldc -126
    //   101: invokespecial 202	java/lang/String:<init>	([BLjava/lang/String;)V
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +76 -> 182
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: ldc 11
    //   114: invokevirtual 206	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   117: astore_2
    //   118: aload_1
    //   119: astore_0
    //   120: aload_2
    //   121: arraylength
    //   122: iconst_4
    //   123: if_icmpne +59 -> 182
    //   126: aload_1
    //   127: astore_0
    //   128: new 2	com/tencent/mobileqq/activity/recent/LightTalkTipsData
    //   131: dup
    //   132: invokespecial 207	com/tencent/mobileqq/activity/recent/LightTalkTipsData:<init>	()V
    //   135: putstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   138: aload_1
    //   139: astore_0
    //   140: getstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   143: aload_2
    //   144: iconst_0
    //   145: aaload
    //   146: putfield 159	com/tencent/mobileqq/activity/recent/LightTalkTipsData:e	Ljava/lang/String;
    //   149: aload_1
    //   150: astore_0
    //   151: getstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   154: aload_2
    //   155: iconst_1
    //   156: aaload
    //   157: putfield 165	com/tencent/mobileqq/activity/recent/LightTalkTipsData:f	Ljava/lang/String;
    //   160: aload_1
    //   161: astore_0
    //   162: getstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   165: aload_2
    //   166: iconst_2
    //   167: aaload
    //   168: putfield 167	com/tencent/mobileqq/activity/recent/LightTalkTipsData:g	Ljava/lang/String;
    //   171: aload_1
    //   172: astore_0
    //   173: getstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   176: aload_2
    //   177: iconst_3
    //   178: aaload
    //   179: putfield 169	com/tencent/mobileqq/activity/recent/LightTalkTipsData:h	Ljava/lang/String;
    //   182: aload_1
    //   183: ifnull -163 -> 20
    //   186: aload_1
    //   187: invokevirtual 208	java/io/FileInputStream:close	()V
    //   190: return
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   196: return
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   206: aload_1
    //   207: astore_0
    //   208: aconst_null
    //   209: putstatic 95	com/tencent/mobileqq/activity/recent/LightTalkTipsData:jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData	Lcom/tencent/mobileqq/activity/recent/LightTalkTipsData;
    //   212: aload_1
    //   213: ifnull -193 -> 20
    //   216: aload_1
    //   217: invokevirtual 208	java/io/FileInputStream:close	()V
    //   220: return
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_0
    //   231: ifnull +7 -> 238
    //   234: aload_0
    //   235: invokevirtual 208	java/io/FileInputStream:close	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   245: goto -7 -> 238
    //   248: astore_1
    //   249: goto -19 -> 230
    //   252: astore_2
    //   253: goto -53 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	142	0	localObject1	Object
    //   191	2	0	localIOException1	java.io.IOException
    //   201	7	0	localObject2	Object
    //   221	2	0	localIOException2	java.io.IOException
    //   229	6	0	localObject3	Object
    //   240	2	0	localIOException3	java.io.IOException
    //   42	175	1	localObject4	Object
    //   227	12	1	localObject5	Object
    //   248	1	1	localObject6	Object
    //   83	94	2	localObject7	Object
    //   197	6	2	localException1	Exception
    //   252	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   186	190	191	java/io/IOException
    //   66	75	197	java/lang/Exception
    //   216	220	221	java/io/IOException
    //   66	75	227	finally
    //   234	238	240	java/io/IOException
    //   77	84	248	finally
    //   86	92	248	finally
    //   94	105	248	finally
    //   111	118	248	finally
    //   120	126	248	finally
    //   128	138	248	finally
    //   140	149	248	finally
    //   151	160	248	finally
    //   162	171	248	finally
    //   173	182	248	finally
    //   202	206	248	finally
    //   208	212	248	finally
    //   77	84	252	java/lang/Exception
    //   86	92	252	java/lang/Exception
    //   94	105	252	java/lang/Exception
    //   111	118	252	java/lang/Exception
    //   120	126	252	java/lang/Exception
    //   128	138	252	java/lang/Exception
    //   140	149	252	java/lang/Exception
    //   151	160	252	java/lang/Exception
    //   162	171	252	java/lang/Exception
    //   173	182	252	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\LightTalkTipsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */