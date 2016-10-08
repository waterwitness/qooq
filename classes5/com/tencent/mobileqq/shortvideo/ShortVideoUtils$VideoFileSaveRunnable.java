package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public ShortVideoUtils$VideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +13 -> 22
    //   12: aload_0
    //   13: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 51	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   19: ifne +47 -> 66
    //   22: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +31 -> 56
    //   28: ldc 59
    //   30: iconst_2
    //   31: new 61	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   38: ldc 64
    //   40: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   60: iconst_1
    //   61: invokevirtual 82	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   64: pop
    //   65: return
    //   66: new 84	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 4
    //   79: invokestatic 91	com/tencent/util/VersionUtils:b	()Z
    //   82: ifeq +70 -> 152
    //   85: getstatic 96	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   88: invokestatic 100	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 103	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: new 84	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Ljava/lang/String;
    //   106: invokestatic 108	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload_0
    //   115: getfield 34	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_Boolean	Z
    //   118: ifne +48 -> 166
    //   121: aload 5
    //   123: invokevirtual 114	java/io/File:exists	()Z
    //   126: ifeq +40 -> 166
    //   129: aload_0
    //   130: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   133: iconst_3
    //   134: aload_0
    //   135: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   138: invokevirtual 118	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload_1
    //   147: invokevirtual 122	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   150: pop
    //   151: return
    //   152: new 84	java/io/File
    //   155: dup
    //   156: getstatic 127	com/tencent/mobileqq/app/AppConstants:bA	Ljava/lang/String;
    //   159: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore_1
    //   163: goto -71 -> 92
    //   166: new 129	java/io/FileOutputStream
    //   169: dup
    //   170: aload 5
    //   172: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   175: astore_3
    //   176: new 134	java/io/FileInputStream
    //   179: dup
    //   180: aload 4
    //   182: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   185: astore_1
    //   186: ldc -120
    //   188: newarray <illegal type>
    //   190: astore_2
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual 140	java/io/FileInputStream:read	([B)I
    //   196: istore 6
    //   198: iload 6
    //   200: iconst_m1
    //   201: if_icmpeq +68 -> 269
    //   204: aload_3
    //   205: aload_2
    //   206: iconst_0
    //   207: iload 6
    //   209: invokevirtual 144	java/io/FileOutputStream:write	([BII)V
    //   212: aload_3
    //   213: invokevirtual 147	java/io/FileOutputStream:flush	()V
    //   216: goto -25 -> 191
    //   219: astore 4
    //   221: aload_3
    //   222: astore_2
    //   223: aload 4
    //   225: astore_3
    //   226: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +12 -> 241
    //   232: ldc 59
    //   234: iconst_2
    //   235: ldc -107
    //   237: aload_3
    //   238: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   245: iconst_1
    //   246: invokevirtual 82	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   249: pop
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   258: aload_1
    //   259: ifnull -194 -> 65
    //   262: aload_1
    //   263: invokevirtual 156	java/io/FileInputStream:close	()V
    //   266: return
    //   267: astore_1
    //   268: return
    //   269: aload_0
    //   270: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   273: iconst_2
    //   274: aload 5
    //   276: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   279: invokevirtual 118	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   282: astore_2
    //   283: aload_0
    //   284: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   287: aload_2
    //   288: invokevirtual 122	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   291: pop
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   300: aload_1
    //   301: ifnull -236 -> 65
    //   304: aload_1
    //   305: invokevirtual 156	java/io/FileInputStream:close	()V
    //   308: return
    //   309: astore_1
    //   310: return
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_3
    //   317: ifnull +7 -> 324
    //   320: aload_3
    //   321: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 156	java/io/FileInputStream:close	()V
    //   332: aload_2
    //   333: athrow
    //   334: astore_2
    //   335: goto -35 -> 300
    //   338: astore_2
    //   339: goto -81 -> 258
    //   342: astore_3
    //   343: goto -19 -> 324
    //   346: astore_1
    //   347: goto -15 -> 332
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -37 -> 316
    //   356: astore_2
    //   357: goto -41 -> 316
    //   360: astore 4
    //   362: aload_2
    //   363: astore_3
    //   364: aload 4
    //   366: astore_2
    //   367: goto -51 -> 316
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -147 -> 226
    //   376: astore 4
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_3
    //   381: astore_2
    //   382: aload 4
    //   384: astore_3
    //   385: goto -159 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	VideoFileSaveRunnable
    //   91	172	1	localObject1	Object
    //   267	38	1	localIOException1	java.io.IOException
    //   309	1	1	localIOException2	java.io.IOException
    //   313	16	1	localObject2	Object
    //   346	1	1	localIOException3	java.io.IOException
    //   352	28	1	localObject3	Object
    //   1	287	2	localObject4	Object
    //   311	22	2	localObject5	Object
    //   334	1	2	localIOException4	java.io.IOException
    //   338	1	2	localIOException5	java.io.IOException
    //   350	1	2	localObject6	Object
    //   356	7	2	localObject7	Object
    //   366	16	2	localObject8	Object
    //   175	146	3	localObject9	Object
    //   342	1	3	localIOException6	java.io.IOException
    //   363	1	3	localObject10	Object
    //   370	11	3	localException1	Exception
    //   384	1	3	localException2	Exception
    //   77	104	4	localFile1	java.io.File
    //   219	5	4	localException3	Exception
    //   360	5	4	localObject11	Object
    //   376	7	4	localException4	Exception
    //   112	163	5	localFile2	java.io.File
    //   196	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   186	191	219	java/lang/Exception
    //   191	198	219	java/lang/Exception
    //   204	216	219	java/lang/Exception
    //   269	292	219	java/lang/Exception
    //   262	266	267	java/io/IOException
    //   304	308	309	java/io/IOException
    //   166	176	311	finally
    //   296	300	334	java/io/IOException
    //   254	258	338	java/io/IOException
    //   320	324	342	java/io/IOException
    //   328	332	346	java/io/IOException
    //   176	186	350	finally
    //   186	191	356	finally
    //   191	198	356	finally
    //   204	216	356	finally
    //   269	292	356	finally
    //   226	241	360	finally
    //   241	250	360	finally
    //   166	176	370	java/lang/Exception
    //   176	186	376	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoUtils$VideoFileSaveRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */