package com.tencent.smtt.sdk;

public class DeviceInfo
{
  public static int GPU_ENABLE_BOUNDS = 600;
  private static int totalRAM = 0;
  
  /* Error */
  public static int getTotalRAM()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   9: ifle +7 -> 16
    //   12: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   15: ireturn
    //   16: new 25	java/io/BufferedReader
    //   19: dup
    //   20: new 27	java/io/FileReader
    //   23: dup
    //   24: ldc 29
    //   26: invokespecial 32	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   29: sipush 8192
    //   32: invokespecial 35	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 39	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: iload 4
    //   45: istore_3
    //   46: aload_2
    //   47: ifnull +91 -> 138
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: ldc 41
    //   55: invokevirtual 47	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   58: istore_3
    //   59: iconst_m1
    //   60: iload_3
    //   61: if_icmpeq -25 -> 36
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: iload_3
    //   68: ldc 41
    //   70: invokevirtual 50	java/lang/String:length	()I
    //   73: iadd
    //   74: invokevirtual 54	java/lang/String:substring	(I)Ljava/lang/String;
    //   77: invokevirtual 57	java/lang/String:trim	()Ljava/lang/String;
    //   80: astore_2
    //   81: iload 4
    //   83: istore_3
    //   84: aload_2
    //   85: ifnull +53 -> 138
    //   88: iload 4
    //   90: istore_3
    //   91: aload_1
    //   92: astore_0
    //   93: aload_2
    //   94: invokevirtual 50	java/lang/String:length	()I
    //   97: ifeq +41 -> 138
    //   100: iload 4
    //   102: istore_3
    //   103: aload_1
    //   104: astore_0
    //   105: aload_2
    //   106: ldc 59
    //   108: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   111: ifeq +27 -> 138
    //   114: aload_1
    //   115: astore_0
    //   116: aload_2
    //   117: iconst_0
    //   118: aload_2
    //   119: ldc 59
    //   121: invokevirtual 47	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   124: invokevirtual 66	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: invokevirtual 57	java/lang/String:trim	()Ljava/lang/String;
    //   130: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   133: sipush 1024
    //   136: idiv
    //   137: istore_3
    //   138: iload_3
    //   139: istore 4
    //   141: aload_1
    //   142: ifnull +10 -> 152
    //   145: aload_1
    //   146: invokevirtual 74	java/io/BufferedReader:close	()V
    //   149: iload_3
    //   150: istore 4
    //   152: iload 4
    //   154: putstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   157: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   160: ireturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   166: iload_3
    //   167: istore 4
    //   169: goto -17 -> 152
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: astore_0
    //   177: aload_2
    //   178: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   181: iload 5
    //   183: istore 4
    //   185: aload_1
    //   186: ifnull -34 -> 152
    //   189: aload_1
    //   190: invokevirtual 74	java/io/BufferedReader:close	()V
    //   193: iload 5
    //   195: istore 4
    //   197: goto -45 -> 152
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   205: iload 5
    //   207: istore 4
    //   209: goto -57 -> 152
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_1
    //   215: aload_1
    //   216: astore_0
    //   217: aload_2
    //   218: invokevirtual 78	java/lang/Throwable:printStackTrace	()V
    //   221: iload 5
    //   223: istore 4
    //   225: aload_1
    //   226: ifnull -74 -> 152
    //   229: aload_1
    //   230: invokevirtual 74	java/io/BufferedReader:close	()V
    //   233: iload 5
    //   235: istore 4
    //   237: goto -85 -> 152
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   245: iload 5
    //   247: istore 4
    //   249: goto -97 -> 152
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 74	java/io/BufferedReader:close	()V
    //   263: aload_1
    //   264: athrow
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   270: goto -7 -> 263
    //   273: astore_1
    //   274: goto -19 -> 255
    //   277: astore_2
    //   278: goto -63 -> 215
    //   281: astore_2
    //   282: goto -107 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	79	0	localBufferedReader1	java.io.BufferedReader
    //   161	2	0	localIOException1	java.io.IOException
    //   176	1	0	localBufferedReader2	java.io.BufferedReader
    //   200	2	0	localIOException2	java.io.IOException
    //   216	1	0	localBufferedReader3	java.io.BufferedReader
    //   240	2	0	localIOException3	java.io.IOException
    //   254	6	0	localObject1	Object
    //   265	2	0	localIOException4	java.io.IOException
    //   35	195	1	localBufferedReader4	java.io.BufferedReader
    //   252	12	1	localObject2	Object
    //   273	1	1	localObject3	Object
    //   42	77	2	str	String
    //   172	6	2	localIOException5	java.io.IOException
    //   212	6	2	localThrowable1	Throwable
    //   277	1	2	localThrowable2	Throwable
    //   281	1	2	localIOException6	java.io.IOException
    //   45	122	3	i	int
    //   4	244	4	j	int
    //   1	245	5	k	int
    // Exception table:
    //   from	to	target	type
    //   145	149	161	java/io/IOException
    //   16	36	172	java/io/IOException
    //   189	193	200	java/io/IOException
    //   16	36	212	java/lang/Throwable
    //   229	233	240	java/io/IOException
    //   16	36	252	finally
    //   259	263	265	java/io/IOException
    //   38	43	273	finally
    //   52	59	273	finally
    //   66	81	273	finally
    //   93	100	273	finally
    //   105	114	273	finally
    //   116	138	273	finally
    //   177	181	273	finally
    //   217	221	273	finally
    //   38	43	277	java/lang/Throwable
    //   52	59	277	java/lang/Throwable
    //   66	81	277	java/lang/Throwable
    //   93	100	277	java/lang/Throwable
    //   105	114	277	java/lang/Throwable
    //   116	138	277	java/lang/Throwable
    //   38	43	281	java/io/IOException
    //   52	59	281	java/io/IOException
    //   66	81	281	java/io/IOException
    //   93	100	281	java/io/IOException
    //   105	114	281	java/io/IOException
    //   116	138	281	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */