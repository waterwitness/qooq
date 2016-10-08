import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;

public class wfi
  implements Runnable
{
  public wfi(StepAlarmReceiver paramStepAlarmReceiver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: invokestatic 32	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   6: invokestatic 38	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9: astore 4
    //   11: getstatic 44	com/tencent/mobileqq/vashealth/StepAlarmReceiver:c	Ljava/lang/String;
    //   14: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +26 -> 43
    //   20: aload 4
    //   22: getstatic 44	com/tencent/mobileqq/vashealth/StepAlarmReceiver:c	Ljava/lang/String;
    //   25: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifne +15 -> 43
    //   31: fconst_0
    //   32: putstatic 57	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_Float	F
    //   35: ldc 59
    //   37: iconst_1
    //   38: ldc 61
    //   40: invokestatic 67	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload 4
    //   45: putstatic 44	com/tencent/mobileqq/vashealth/StepAlarmReceiver:c	Ljava/lang/String;
    //   48: new 69	com/tencent/qphone/base/util/Cryptor
    //   51: dup
    //   52: invokespecial 70	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   55: astore 5
    //   57: new 72	java/io/RandomAccessFile
    //   60: dup
    //   61: getstatic 73	com/tencent/mobileqq/vashealth/SSOHttpUtils:c	Ljava/lang/String;
    //   64: ldc 75
    //   66: invokespecial 78	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: invokevirtual 81	java/io/RandomAccessFile:length	()J
    //   76: l2i
    //   77: newarray <illegal type>
    //   79: astore 6
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: aload 6
    //   86: invokevirtual 85	java/io/RandomAccessFile:read	([B)I
    //   89: pop
    //   90: aload_3
    //   91: astore_2
    //   92: new 87	org/json/JSONObject
    //   95: dup
    //   96: new 34	java/lang/String
    //   99: dup
    //   100: aload 5
    //   102: aload 6
    //   104: ldc 89
    //   106: invokevirtual 93	java/lang/String:getBytes	()[B
    //   109: invokevirtual 97	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   112: invokespecial 100	java/lang/String:<init>	([B)V
    //   115: invokespecial 103	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   118: astore 5
    //   120: aload_3
    //   121: astore_2
    //   122: aload 5
    //   124: new 105	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   131: aload 4
    //   133: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 112
    //   138: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokevirtual 120	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   147: istore 8
    //   149: aload_3
    //   150: astore_2
    //   151: aload 5
    //   153: new 105	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   160: aload 4
    //   162: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 122
    //   167: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 120	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: istore 7
    //   178: aload_3
    //   179: astore_2
    //   180: aload 5
    //   182: new 105	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   189: aload 4
    //   191: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 124
    //   196: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 120	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   205: iload 8
    //   207: iload 7
    //   209: isub
    //   210: iadd
    //   211: i2f
    //   212: getstatic 57	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_Float	F
    //   215: fsub
    //   216: fstore_1
    //   217: aload_3
    //   218: astore_2
    //   219: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   222: getstatic 132	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_Long	J
    //   225: lsub
    //   226: lstore 9
    //   228: aload_3
    //   229: astore_2
    //   230: aload 5
    //   232: invokevirtual 133	org/json/JSONObject:toString	()Ljava/lang/String;
    //   235: astore 4
    //   237: fload_1
    //   238: ldc -122
    //   240: fcmpl
    //   241: ifle +221 -> 462
    //   244: lload 9
    //   246: ldc2_w 135
    //   249: lcmp
    //   250: ifgt +6 -> 256
    //   253: goto +209 -> 462
    //   256: aload_3
    //   257: astore_2
    //   258: new 105	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   265: ldc -118
    //   267: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: astore 5
    //   272: fload_1
    //   273: ldc -122
    //   275: fcmpl
    //   276: ifle +95 -> 371
    //   279: lload 9
    //   281: ldc2_w 135
    //   284: lcmp
    //   285: ifle +86 -> 371
    //   288: iconst_1
    //   289: istore 11
    //   291: aload_3
    //   292: astore_2
    //   293: aload 5
    //   295: iload 11
    //   297: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   300: ldc -113
    //   302: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: astore 5
    //   307: lload 9
    //   309: ldc2_w 144
    //   312: lcmp
    //   313: ifle +64 -> 377
    //   316: fload_1
    //   317: ldc -110
    //   319: fcmpl
    //   320: ifle +57 -> 377
    //   323: iload 12
    //   325: istore 11
    //   327: aload_3
    //   328: astore_2
    //   329: ldc 59
    //   331: iconst_1
    //   332: aload 5
    //   334: iload 11
    //   336: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   339: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 67	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_3
    //   346: astore_2
    //   347: aload 4
    //   349: invokestatic 148	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	(Ljava/lang/String;)V
    //   352: aload_3
    //   353: astore_2
    //   354: aload_3
    //   355: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   358: iconst_0
    //   359: ifeq +11 -> 370
    //   362: new 153	java/lang/NullPointerException
    //   365: dup
    //   366: invokespecial 154	java/lang/NullPointerException:<init>	()V
    //   369: athrow
    //   370: return
    //   371: iconst_0
    //   372: istore 11
    //   374: goto -83 -> 291
    //   377: iconst_0
    //   378: istore 11
    //   380: goto -53 -> 327
    //   383: astore 4
    //   385: aconst_null
    //   386: astore_3
    //   387: aload_3
    //   388: astore_2
    //   389: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +31 -> 423
    //   395: aload_3
    //   396: astore_2
    //   397: ldc -96
    //   399: iconst_2
    //   400: new 105	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   407: ldc -94
    //   409: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 4
    //   414: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: aload_3
    //   424: ifnull -54 -> 370
    //   427: aload_3
    //   428: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   431: return
    //   432: astore_2
    //   433: return
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_2
    //   437: aload_2
    //   438: ifnull +7 -> 445
    //   441: aload_2
    //   442: invokevirtual 151	java/io/RandomAccessFile:close	()V
    //   445: aload_3
    //   446: athrow
    //   447: astore_2
    //   448: return
    //   449: astore_2
    //   450: goto -5 -> 445
    //   453: astore_3
    //   454: goto -17 -> 437
    //   457: astore 4
    //   459: goto -72 -> 387
    //   462: lload 9
    //   464: ldc2_w 144
    //   467: lcmp
    //   468: ifle -116 -> 352
    //   471: fload_1
    //   472: ldc -110
    //   474: fcmpl
    //   475: ifle -123 -> 352
    //   478: goto -222 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	wfi
    //   216	256	1	f	float
    //   71	326	2	localRandomAccessFile1	java.io.RandomAccessFile
    //   432	1	2	localIOException1	java.io.IOException
    //   436	6	2	localObject1	Object
    //   447	1	2	localIOException2	java.io.IOException
    //   449	1	2	localIOException3	java.io.IOException
    //   69	359	3	localRandomAccessFile2	java.io.RandomAccessFile
    //   434	12	3	localObject2	Object
    //   453	1	3	localObject3	Object
    //   9	339	4	str	String
    //   383	30	4	localException1	Exception
    //   457	1	4	localException2	Exception
    //   55	278	5	localObject4	Object
    //   79	24	6	arrayOfByte	byte[]
    //   176	34	7	i	int
    //   147	63	8	j	int
    //   226	237	9	l	long
    //   289	90	11	bool1	boolean
    //   1	323	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   48	70	383	java/lang/Exception
    //   427	431	432	java/io/IOException
    //   48	70	434	finally
    //   362	370	447	java/io/IOException
    //   441	445	449	java/io/IOException
    //   72	81	453	finally
    //   83	90	453	finally
    //   92	120	453	finally
    //   122	149	453	finally
    //   151	178	453	finally
    //   180	217	453	finally
    //   219	228	453	finally
    //   230	237	453	finally
    //   258	272	453	finally
    //   293	307	453	finally
    //   329	345	453	finally
    //   347	352	453	finally
    //   354	358	453	finally
    //   389	395	453	finally
    //   397	423	453	finally
    //   72	81	457	java/lang/Exception
    //   83	90	457	java/lang/Exception
    //   92	120	457	java/lang/Exception
    //   122	149	457	java/lang/Exception
    //   151	178	457	java/lang/Exception
    //   180	217	457	java/lang/Exception
    //   219	228	457	java/lang/Exception
    //   230	237	457	java/lang/Exception
    //   258	272	457	java/lang/Exception
    //   293	307	457	java/lang/Exception
    //   329	345	457	java/lang/Exception
    //   347	352	457	java/lang/Exception
    //   354	358	457	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */