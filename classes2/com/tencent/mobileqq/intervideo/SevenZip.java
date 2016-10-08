package com.tencent.mobileqq.intervideo;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.LzmaUtils;

public class SevenZip
{
  public SevenZip()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "lib/armeabi", "7z");
    return LzmaUtils.a(paramContext, paramString2 + "lib/armeabi/armeabi.7z", paramString2) == 0;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 46
    //   3: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifeq +281 -> 287
    //   9: aload_1
    //   10: astore 5
    //   12: sipush 1024
    //   15: newarray <illegal type>
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 7
    //   30: astore_1
    //   31: aload 8
    //   33: astore 4
    //   35: new 54	java/util/zip/ZipFile
    //   38: dup
    //   39: new 56	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 62	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   50: astore 10
    //   52: aload 7
    //   54: astore_1
    //   55: aload 8
    //   57: astore 4
    //   59: aload 10
    //   61: invokevirtual 66	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   64: astore 7
    //   66: aload 6
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_0
    //   72: astore 4
    //   74: aload 7
    //   76: invokeinterface 72 1 0
    //   81: ifeq +237 -> 318
    //   84: aload_0
    //   85: astore_1
    //   86: aload_0
    //   87: astore 4
    //   89: aload 7
    //   91: invokeinterface 76 1 0
    //   96: checkcast 78	java/util/zip/ZipEntry
    //   99: astore 6
    //   101: aload_2
    //   102: ifnull +20 -> 122
    //   105: aload_0
    //   106: astore_1
    //   107: aload_0
    //   108: astore 4
    //   110: aload 6
    //   112: invokevirtual 81	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   115: aload_2
    //   116: invokevirtual 84	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   119: ifeq -50 -> 69
    //   122: aload_3
    //   123: ifnull +20 -> 143
    //   126: aload_0
    //   127: astore_1
    //   128: aload_0
    //   129: astore 4
    //   131: aload 6
    //   133: invokevirtual 81	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   136: aload_3
    //   137: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   140: ifeq -71 -> 69
    //   143: aload_0
    //   144: astore_1
    //   145: aload_0
    //   146: astore 4
    //   148: new 56	java/io/File
    //   151: dup
    //   152: new 26	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   159: aload 5
    //   161: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 6
    //   166: invokevirtual 81	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   169: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 8
    //   180: aload_0
    //   181: astore_1
    //   182: aload_0
    //   183: astore 4
    //   185: aload 8
    //   187: invokevirtual 88	java/io/File:getParentFile	()Ljava/io/File;
    //   190: invokevirtual 91	java/io/File:exists	()Z
    //   193: ifne +17 -> 210
    //   196: aload_0
    //   197: astore_1
    //   198: aload_0
    //   199: astore 4
    //   201: aload 8
    //   203: invokevirtual 88	java/io/File:getParentFile	()Ljava/io/File;
    //   206: invokevirtual 94	java/io/File:mkdirs	()Z
    //   209: pop
    //   210: aload_0
    //   211: astore_1
    //   212: aload_0
    //   213: astore 4
    //   215: new 96	java/io/FileOutputStream
    //   218: dup
    //   219: aload 8
    //   221: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: astore_0
    //   225: aload 10
    //   227: aload 6
    //   229: invokevirtual 101	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   232: astore_1
    //   233: aload_1
    //   234: aload 9
    //   236: invokevirtual 107	java/io/InputStream:read	([B)I
    //   239: istore 11
    //   241: iload 11
    //   243: ifle +68 -> 311
    //   246: aload_0
    //   247: aload 9
    //   249: iconst_0
    //   250: iload 11
    //   252: invokevirtual 113	java/io/OutputStream:write	([BII)V
    //   255: goto -22 -> 233
    //   258: astore_1
    //   259: aload_0
    //   260: astore 4
    //   262: aload_1
    //   263: astore_0
    //   264: aload 4
    //   266: astore_1
    //   267: aload_0
    //   268: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   271: aload 4
    //   273: ifnull +8 -> 281
    //   276: aload 4
    //   278: invokevirtual 119	java/io/OutputStream:close	()V
    //   281: iconst_0
    //   282: istore 12
    //   284: iload 12
    //   286: ireturn
    //   287: new 26	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   294: aload_1
    //   295: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 46
    //   300: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore 5
    //   308: goto -296 -> 12
    //   311: aload_0
    //   312: invokevirtual 122	java/io/OutputStream:flush	()V
    //   315: goto -246 -> 69
    //   318: iconst_1
    //   319: istore 12
    //   321: aload_0
    //   322: ifnull -38 -> 284
    //   325: aload_0
    //   326: invokevirtual 119	java/io/OutputStream:close	()V
    //   329: iconst_1
    //   330: ireturn
    //   331: astore_0
    //   332: aload_0
    //   333: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   336: iconst_1
    //   337: ireturn
    //   338: astore_0
    //   339: aload_0
    //   340: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   343: goto -62 -> 281
    //   346: astore_0
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 119	java/io/OutputStream:close	()V
    //   355: aload_0
    //   356: athrow
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   362: goto -7 -> 355
    //   365: astore_2
    //   366: aload_0
    //   367: astore_1
    //   368: aload_2
    //   369: astore_0
    //   370: goto -23 -> 347
    //   373: astore_0
    //   374: goto -110 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString1	String
    //   0	377	1	paramString2	String
    //   0	377	2	paramString3	String
    //   0	377	3	paramString4	String
    //   33	244	4	localObject	Object
    //   10	297	5	str	String
    //   26	202	6	localZipEntry	java.util.zip.ZipEntry
    //   20	70	7	localEnumeration	java.util.Enumeration
    //   23	197	8	localFile	java.io.File
    //   17	231	9	arrayOfByte	byte[]
    //   50	176	10	localZipFile	java.util.zip.ZipFile
    //   239	12	11	i	int
    //   282	38	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   225	233	258	java/io/IOException
    //   233	241	258	java/io/IOException
    //   246	255	258	java/io/IOException
    //   311	315	258	java/io/IOException
    //   325	329	331	java/io/IOException
    //   276	281	338	java/io/IOException
    //   35	52	346	finally
    //   59	66	346	finally
    //   74	84	346	finally
    //   89	101	346	finally
    //   110	122	346	finally
    //   131	143	346	finally
    //   148	180	346	finally
    //   185	196	346	finally
    //   201	210	346	finally
    //   215	225	346	finally
    //   267	271	346	finally
    //   351	355	357	java/io/IOException
    //   225	233	365	finally
    //   233	241	365	finally
    //   246	255	365	finally
    //   311	315	365	finally
    //   35	52	373	java/io/IOException
    //   59	66	373	java/io/IOException
    //   74	84	373	java/io/IOException
    //   89	101	373	java/io/IOException
    //   110	122	373	java/io/IOException
    //   131	143	373	java/io/IOException
    //   148	180	373	java/io/IOException
    //   185	196	373	java/io/IOException
    //   201	210	373	java/io/IOException
    //   215	225	373	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\SevenZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */