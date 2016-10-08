package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import qph;

public class ArNativeSoLoader
{
  public static final String a = "ArConfig_ArNativeSoLoader";
  public static boolean a = false;
  private static final byte[] a;
  public static final String b = "ar_native_so_version";
  public static boolean b = false;
  public static final String c = "ar_native_";
  public static final String d = "HiarQ";
  public static final String e = "HiarQ_jni";
  public static final String f = "ARGLRenderer";
  public static final String g = "/ar_native_config.xml";
  private static final String h = "ar_native_so_load_result";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public static byte a(String paramString)
  {
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = a() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArNativeSoLoader", 2, "start arNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!jdField_a_of_type_Boolean) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("ArConfig_ArNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArConfig_ArNativeSoLoader", 2, "load from ar dir failed: " + localUnsatisfiedLinkError.getMessage());
        b1 = -3;
        continue;
      }
      a(paramString, b1);
      return b1;
      b2 = -2;
      byte b1 = b2;
      if (QLog.isColorLevel())
      {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "no ar so in ar dir");
        b1 = b2;
      }
    }
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/ar";
  }
  
  private static void a(String paramString, byte paramByte)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0);
    byte b1 = localSharedPreferences.getInt("ar_native_so_load_result" + paramString, 0);
    if ((!b) || (b1 != paramByte))
    {
      b = true;
      ThreadManager.a(new qph(paramString, paramByte, localSharedPreferences), 5, null, true);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if ((!jdField_a_of_type_Boolean) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (jdField_a_of_type_ArrayOfByte)
        {
          String str2 = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).getString("ar_native_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(PortalUtils.a(str1)))
            {
              break label172;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label172:
        boolean bool1 = true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, HashMap paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ArConfig_ArNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label188;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("HiarQ"))
      {
        paramHashMap.put("HiarQ", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("HiarQ_jni"))
        {
          paramHashMap.put("HiarQ_jni", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("ARGLRenderer")) {
          continue;
        }
        paramHashMap.put("ARGLRenderer", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label188:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  /* Error */
  public static byte b(String arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 84	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   4: aload_0
    //   5: invokestatic 54	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   8: invokestatic 234	com/tencent/mobileqq/ar/ArConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: new 182	java/util/HashMap
    //   14: dup
    //   15: invokespecial 235	java/util/HashMap:<init>	()V
    //   18: astore 5
    //   20: getstatic 111	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   23: ldc -128
    //   25: iconst_0
    //   26: invokevirtual 132	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: invokeinterface 239 1 0
    //   34: astore 4
    //   36: new 79	java/io/File
    //   39: dup
    //   40: new 50	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 54	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 29
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 87	java/io/File:exists	()Z
    //   69: ifeq +311 -> 380
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_3
    //   75: invokestatic 244	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   78: astore_3
    //   79: aload_3
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +274 -> 356
    //   85: aload_0
    //   86: aload 5
    //   88: invokestatic 246	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   91: ifeq +265 -> 356
    //   94: getstatic 41	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_ArrayOfByte	[B
    //   97: astore_0
    //   98: aload_0
    //   99: monitorenter
    //   100: aload 5
    //   102: invokevirtual 250	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   105: invokeinterface 256 1 0
    //   110: astore_3
    //   111: aload_3
    //   112: invokeinterface 261 1 0
    //   117: ifeq +283 -> 400
    //   120: aload_3
    //   121: invokeinterface 264 1 0
    //   126: checkcast 266	java/util/Map$Entry
    //   129: astore 5
    //   131: new 50	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 54	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   141: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 60
    //   146: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokeinterface 269 1 0
    //   156: checkcast 162	java/lang/String
    //   159: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 62
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 7
    //   172: new 79	java/io/File
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 87	java/io/File:exists	()Z
    //   188: ifeq +163 -> 351
    //   191: aload 7
    //   193: invokestatic 160	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 7
    //   198: aload 5
    //   200: invokeinterface 272 1 0
    //   205: checkcast 162	java/lang/String
    //   208: aload 7
    //   210: invokevirtual 165	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: ifne +84 -> 297
    //   216: aload 6
    //   218: invokevirtual 275	java/io/File:delete	()Z
    //   221: pop
    //   222: iconst_2
    //   223: istore_1
    //   224: aload 4
    //   226: invokeinterface 280 1 0
    //   231: pop
    //   232: aload_0
    //   233: monitorexit
    //   234: iconst_0
    //   235: putstatic 84	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   238: iload_1
    //   239: ireturn
    //   240: astore_0
    //   241: iconst_0
    //   242: putstatic 84	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   245: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +32 -> 280
    //   251: ldc 8
    //   253: iconst_2
    //   254: new 50	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 282
    //   264: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: invokevirtual 283	java/io/IOException:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: invokestatic 54	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   283: iconst_0
    //   284: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   287: iconst_m1
    //   288: ireturn
    //   289: astore_3
    //   290: aload_3
    //   291: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   294: goto -213 -> 81
    //   297: aload 4
    //   299: new 50	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   306: ldc 17
    //   308: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 5
    //   313: invokeinterface 269 1 0
    //   318: checkcast 162	java/lang/String
    //   321: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aload 5
    //   329: invokeinterface 272 1 0
    //   334: checkcast 162	java/lang/String
    //   337: invokeinterface 293 3 0
    //   342: pop
    //   343: goto -232 -> 111
    //   346: astore_3
    //   347: aload_0
    //   348: monitorexit
    //   349: aload_3
    //   350: athrow
    //   351: iconst_3
    //   352: istore_1
    //   353: goto -129 -> 224
    //   356: iconst_4
    //   357: istore_2
    //   358: iload_2
    //   359: istore_1
    //   360: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq -129 -> 234
    //   366: ldc 8
    //   368: iconst_2
    //   369: ldc_w 295
    //   372: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: iload_2
    //   376: istore_1
    //   377: goto -143 -> 234
    //   380: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +12 -> 395
    //   386: ldc 8
    //   388: iconst_2
    //   389: ldc_w 297
    //   392: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: iconst_0
    //   396: istore_1
    //   397: goto -163 -> 234
    //   400: iconst_0
    //   401: istore_1
    //   402: goto -178 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   223	179	1	b1	byte
    //   357	19	2	b2	byte
    //   64	57	3	localObject1	Object
    //   289	2	3	localIOException	java.io.IOException
    //   346	4	3	localObject2	Object
    //   34	264	4	localEditor	android.content.SharedPreferences.Editor
    //   18	310	5	localObject3	Object
    //   181	36	6	localFile	File
    //   170	39	7	str	String
    // Exception table:
    //   from	to	target	type
    //   4	11	240	java/io/IOException
    //   74	79	289	java/io/IOException
    //   100	111	346	finally
    //   111	222	346	finally
    //   224	234	346	finally
    //   297	343	346	finally
    //   347	349	346	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArNativeSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */