package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class AioAnimationConfigHelper
{
  private static volatile AioAnimationConfigHelper jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
  public static final String a;
  public static final String b = "Item";
  public static final String c = "id";
  public static final String d = "Keywords";
  public static final String e = "FloorLimit";
  public static final String f = "JumpLimit";
  public static final String g = "JumpImage";
  public static final String h = "type";
  public static final String i = "Emoji";
  public static final String j = "Face";
  public static final String k = "Image";
  public static final String l = "count";
  public static final String m = "IsCrazyMode";
  public static final String n = "eggs.xml";
  public static final String o;
  public static final String p = o + "eggs.xml";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AioAnimationConfigHelper.class.getSimpleName();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    o = localBaseApplication.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/";
  }
  
  public static AioAnimationConfigHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper = new AioAnimationConfigHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
    }
    finally {}
  }
  
  private ArrayList a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    int i1 = paramXmlPullParser.getEventType();
    Object localObject1 = null;
    Object localObject4 = null;
    String str1;
    Object localObject3;
    Object localObject2;
    label375:
    String str2;
    if (i1 != 1) {
      if (i1 == 2)
      {
        str1 = paramXmlPullParser.getName();
        if (str1.equalsIgnoreCase("Item"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject2 = new AioAnimationRule();
          ((AioAnimationRule)localObject2).jdField_a_of_type_Int = Integer.valueOf((String)localObject3).intValue();
          localObject3 = localObject1;
        }
        do
        {
          for (;;)
          {
            i1 = paramXmlPullParser.next();
            localObject4 = localObject2;
            localObject1 = localObject3;
            break;
            if (str1.equalsIgnoreCase("Keywords"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                localObject2 = localObject4;
                localObject3 = localObject1;
                if (!TextUtils.isEmpty(str1))
                {
                  if (((AioAnimationRule)localObject4).jdField_a_of_type_JavaUtilArrayList == null) {
                    ((AioAnimationRule)localObject4).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                  }
                  ((AioAnimationRule)localObject4).jdField_a_of_type_JavaUtilArrayList.add(str1);
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                }
              }
            }
            else if (str1.equalsIgnoreCase("FloorLimit"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                ((AioAnimationRule)localObject4).jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
            else if (str1.equalsIgnoreCase("JumpLimit"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                ((AioAnimationRule)localObject4).c = Integer.valueOf(str1).intValue();
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
            else
            {
              if (!str1.equalsIgnoreCase("IsCrazyMode")) {
                break label375;
              }
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null) {
                if (str1.equalsIgnoreCase("true"))
                {
                  ((AioAnimationRule)localObject4).jdField_a_of_type_Boolean = true;
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                }
                else
                {
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                  if (str1.equalsIgnoreCase("false"))
                  {
                    ((AioAnimationRule)localObject4).jdField_a_of_type_Boolean = false;
                    localObject2 = localObject4;
                    localObject3 = localObject1;
                  }
                }
              }
            }
          }
          localObject2 = localObject4;
          localObject3 = localObject1;
        } while (!str1.equalsIgnoreCase("JumpImage"));
        str1 = paramXmlPullParser.getAttributeValue(null, "type");
        localObject2 = paramXmlPullParser.getAttributeValue(null, "count");
        str2 = paramXmlPullParser.nextText();
        if (localObject2 == null) {
          break label741;
        }
        i1 = Integer.valueOf((String)localObject2).intValue();
      }
    }
    for (;;)
    {
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i1 <= 0) {
        break;
      }
      localObject2 = new AioAnimationRule.JumpImage();
      if (str1 != null) {
        ((AioAnimationRule.JumpImage)localObject2).e = AioAnimationRule.JumpImage.a(str1);
      }
      ((AioAnimationRule.JumpImage)localObject2).d = str2;
      if (localObject4 != null)
      {
        if (((AioAnimationRule)localObject4).jdField_b_of_type_JavaUtilArrayList == null) {
          ((AioAnimationRule)localObject4).jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        ((AioAnimationRule)localObject4).jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      }
      i1 -= 1;
      continue;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i1 != 3) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!paramXmlPullParser.getName().equalsIgnoreCase("Item")) {
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      boolean bool;
      if (localObject4 != null)
      {
        if ((((AioAnimationRule)localObject4).jdField_b_of_type_Int != 0) || (((AioAnimationRule)localObject4).c != 0)) {
          break label668;
        }
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          ((ArrayList)localObject3).add(localObject4);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "<== Item, id = " + ((AioAnimationRule)localObject4).jdField_a_of_type_Int + ",isValid = " + bool + "keywords:" + ((AioAnimationRule)localObject4).jdField_a_of_type_JavaUtilArrayList.toString());
        }
        localObject2 = null;
        break;
        label668:
        if (((AioAnimationRule)localObject4).c > ((AioAnimationRule)localObject4).jdField_b_of_type_Int)
        {
          bool = true;
          continue;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doParseRules :  cost time:" + (l2 - l1) + "ms");
          }
          return (ArrayList)localObject1;
        }
        else
        {
          bool = false;
        }
      }
      label741:
      i1 = 1;
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_2
    //   11: new 84	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload 5
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 237	java/io/File:exists	()Z
    //   27: ifeq +13 -> 40
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 240	java/io/File:isFile	()Z
    //   37: ifne +58 -> 95
    //   40: aload 5
    //   42: astore_2
    //   43: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +35 -> 81
    //   49: aload 5
    //   51: astore_2
    //   52: getstatic 65	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: iconst_2
    //   56: new 73	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   63: ldc -14
    //   65: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 245	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iconst_0
    //   82: ifeq +11 -> 93
    //   85: new 249	java/lang/NullPointerException
    //   88: dup
    //   89: invokespecial 250	java/lang/NullPointerException:<init>	()V
    //   92: athrow
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: astore_2
    //   98: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: aload 5
    //   106: astore_2
    //   107: getstatic 65	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: iconst_2
    //   111: new 73	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   118: ldc -4
    //   120: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 245	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload 5
    //   138: astore_2
    //   139: new 254	java/io/FileInputStream
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 257	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: astore_1
    //   148: invokestatic 263	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   151: invokevirtual 267	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   154: astore_2
    //   155: aload_2
    //   156: aload_1
    //   157: ldc_w 269
    //   160: invokeinterface 273 3 0
    //   165: aload_0
    //   166: aload_2
    //   167: invokespecial 275	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   170: astore_2
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 278	java/io/FileInputStream:close	()V
    //   179: aload_2
    //   180: ifnull -87 -> 93
    //   183: aload_0
    //   184: aload_2
    //   185: putfield 279	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_3
    //   191: aload 4
    //   193: astore_1
    //   194: aload_1
    //   195: astore_2
    //   196: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +16 -> 215
    //   202: aload_1
    //   203: astore_2
    //   204: getstatic 65	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: iconst_2
    //   208: ldc_w 281
    //   211: aload_3
    //   212: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload_1
    //   216: ifnull -123 -> 93
    //   219: aload_1
    //   220: invokevirtual 278	java/io/FileInputStream:close	()V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_1
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_2
    //   229: aload_3
    //   230: astore_1
    //   231: aload_2
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +16 -> 254
    //   241: aload_1
    //   242: astore_2
    //   243: getstatic 65	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: iconst_2
    //   247: ldc_w 281
    //   250: aload_3
    //   251: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload_1
    //   255: ifnull -162 -> 93
    //   258: aload_1
    //   259: invokevirtual 278	java/io/FileInputStream:close	()V
    //   262: iconst_0
    //   263: ireturn
    //   264: astore_1
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 278	java/io/FileInputStream:close	()V
    //   276: aload_1
    //   277: athrow
    //   278: astore_1
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_1
    //   282: goto -103 -> 179
    //   285: astore_2
    //   286: goto -10 -> 276
    //   289: astore_3
    //   290: aload_1
    //   291: astore_2
    //   292: aload_3
    //   293: astore_1
    //   294: goto -26 -> 268
    //   297: astore_3
    //   298: goto -65 -> 233
    //   301: astore_3
    //   302: goto -108 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	AioAnimationConfigHelper
    //   0	305	1	paramString	String
    //   10	194	2	localObject1	Object
    //   228	4	2	localOutOfMemoryError1	OutOfMemoryError
    //   234	39	2	str1	String
    //   285	1	2	localIOException	java.io.IOException
    //   291	1	2	str2	String
    //   1	1	3	localObject2	Object
    //   190	40	3	localException1	Exception
    //   232	19	3	localObject3	Object
    //   289	4	3	localObject4	Object
    //   297	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   301	1	3	localException2	Exception
    //   6	186	4	localObject5	Object
    //   3	134	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	190	java/lang/Exception
    //   23	30	190	java/lang/Exception
    //   33	40	190	java/lang/Exception
    //   43	49	190	java/lang/Exception
    //   52	81	190	java/lang/Exception
    //   98	104	190	java/lang/Exception
    //   107	136	190	java/lang/Exception
    //   139	148	190	java/lang/Exception
    //   219	223	225	java/io/IOException
    //   11	20	228	java/lang/OutOfMemoryError
    //   23	30	228	java/lang/OutOfMemoryError
    //   33	40	228	java/lang/OutOfMemoryError
    //   43	49	228	java/lang/OutOfMemoryError
    //   52	81	228	java/lang/OutOfMemoryError
    //   98	104	228	java/lang/OutOfMemoryError
    //   107	136	228	java/lang/OutOfMemoryError
    //   139	148	228	java/lang/OutOfMemoryError
    //   258	262	264	java/io/IOException
    //   11	20	267	finally
    //   23	30	267	finally
    //   33	40	267	finally
    //   43	49	267	finally
    //   52	81	267	finally
    //   98	104	267	finally
    //   107	136	267	finally
    //   139	148	267	finally
    //   196	202	267	finally
    //   204	215	267	finally
    //   235	241	267	finally
    //   243	254	267	finally
    //   85	93	278	java/io/IOException
    //   175	179	281	java/io/IOException
    //   272	276	285	java/io/IOException
    //   148	171	289	finally
    //   148	171	297	java/lang/OutOfMemoryError
    //   148	171	301	java/lang/Exception
  }
  
  private void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXmlFromRes");
    }
    paramContext = paramContext.getResources().getXml(2131099649);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        this.jdField_a_of_type_JavaUtilArrayList = paramContext;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "parseXmlFromRes doParseRules exception:", localException);
          paramContext = (Context)localObject;
        }
      }
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (FileUtils.b(p))
    {
      boolean bool = a(p);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        b(paramContext);
      }
      return;
    }
    b(paramContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i1 = 1;
    try
    {
      FileUtils.a(o, false);
      FileUtils.a(paramString, o, false);
      if (i1 != 0)
      {
        boolean bool = a(p);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          paramQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", paramLong).commit();
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i1 = 0;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip :  uncompress OOM Error =>", paramString);
        }
        i1 = 0;
      }
      b(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramQQAppInterface.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\AioAnimationConfigHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */