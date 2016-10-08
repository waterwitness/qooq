package com.tencent.mobileqq.profile.upload;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import mqq.manager.TicketManager;

public class VipUploadUtils
{
  public static final int a = 0;
  public static final String a = "qqprofile";
  public static final boolean a = false;
  public static final int b = 1;
  public static final String b = "180.153.160.39";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 0;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 19994;
  public static final int p = 13;
  public static final int q = 640;
  public static final int r = 1136;
  public static final int s = 100;
  public static final int t = 80;
  
  public VipUploadUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_1
    //   4: aload_0
    //   5: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +49 -> 57
    //   11: new 67	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 74	java/io/File:exists	()Z
    //   26: ifeq +31 -> 57
    //   29: new 76	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokestatic 85	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull +9 -> 57
    //   51: aload_0
    //   52: invokevirtual 88	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: ifnull -8 -> 57
    //   68: aload_0
    //   69: invokevirtual 88	java/io/FileInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull -26 -> 57
    //   86: aload_0
    //   87: invokevirtual 88	java/io/FileInputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 88	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: aload_2
    //   110: areturn
    //   111: astore_0
    //   112: goto -6 -> 106
    //   115: astore_1
    //   116: goto -18 -> 98
    //   119: astore_1
    //   120: goto -40 -> 80
    //   123: astore_1
    //   124: goto -62 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   3	79	1	localObject1	Object
    //   95	12	1	localObject2	Object
    //   115	1	1	localObject3	Object
    //   119	1	1	localException	Exception
    //   123	1	1	localOutOfMemoryError	OutOfMemoryError
    //   1	109	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	38	59	java/lang/OutOfMemoryError
    //   68	72	74	java/lang/Exception
    //   29	38	77	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   29	38	95	finally
    //   51	55	108	java/lang/Exception
    //   102	106	111	java/lang/Exception
    //   38	43	115	finally
    //   38	43	119	java/lang/Exception
    //   38	43	123	java/lang/OutOfMemoryError
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(paramAppInterface.a());
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 122
    //   4: invokestatic 128	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 131	java/security/MessageDigest:reset	()V
    //   12: new 76	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 135	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   26: getstatic 141	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   29: lconst_0
    //   30: aload_0
    //   31: invokevirtual 144	java/io/File:length	()J
    //   34: invokevirtual 150	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   37: invokevirtual 154	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   40: aload_3
    //   41: invokevirtual 158	java/security/MessageDigest:digest	()[B
    //   44: invokestatic 164	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 88	java/io/FileInputStream:close	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aload_2
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 88	java/io/FileInputStream:close	()V
    //   69: ldc -90
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull -7 -> 69
    //   79: aload_1
    //   80: invokevirtual 88	java/io/FileInputStream:close	()V
    //   83: goto -14 -> 69
    //   86: astore_0
    //   87: goto -18 -> 69
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -25 -> 69
    //   97: aload_1
    //   98: invokevirtual 88	java/io/FileInputStream:close	()V
    //   101: goto -32 -> 69
    //   104: astore_0
    //   105: goto -36 -> 69
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 88	java/io/FileInputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_1
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: goto -56 -> 69
    //   128: astore_1
    //   129: goto -10 -> 119
    //   132: astore_0
    //   133: goto -22 -> 111
    //   136: astore_0
    //   137: goto -44 -> 93
    //   140: astore_0
    //   141: goto -66 -> 75
    //   144: astore_0
    //   145: aload_1
    //   146: astore_0
    //   147: goto -86 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramFile	File
    //   20	96	1	localFileInputStream	java.io.FileInputStream
    //   121	1	1	localIOException1	java.io.IOException
    //   128	18	1	localIOException2	java.io.IOException
    //   1	59	2	localObject	Object
    //   7	34	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   2	21	58	java/security/NoSuchAlgorithmException
    //   2	21	72	java/io/FileNotFoundException
    //   79	83	86	java/io/IOException
    //   2	21	90	java/io/IOException
    //   97	101	104	java/io/IOException
    //   2	21	108	finally
    //   52	56	121	java/io/IOException
    //   65	69	124	java/io/IOException
    //   115	119	128	java/io/IOException
    //   21	48	132	finally
    //   21	48	136	java/io/IOException
    //   21	48	140	java/io/FileNotFoundException
    //   21	48	144	java/security/NoSuchAlgorithmException
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.length() < 204800L) {}
      for (paramString = a(paramString);; paramString = b(paramString))
      {
        String str = paramString;
        if ("".equals(paramString)) {
          str = null;
        }
        return str;
      }
    }
    return null;
  }
  
  public static byte[] a(AppInterface paramAppInterface)
  {
    return HexUtil.hexStr2Bytes(((TicketManager)paramAppInterface.getManager(2)).getA2(paramAppInterface.a()));
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokevirtual 74	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: ldc -90
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 144	java/io/File:length	()J
    //   24: lstore 5
    //   26: lload 5
    //   28: ldc2_w 196
    //   31: lcmp
    //   32: ifle +139 -> 171
    //   35: lload 5
    //   37: ldc2_w 198
    //   40: ldiv
    //   41: lstore 5
    //   43: bipush 32
    //   45: newarray <illegal type>
    //   47: astore_2
    //   48: new 76	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_0
    //   57: aload_0
    //   58: lload 5
    //   60: invokevirtual 203	java/io/FileInputStream:skip	(J)J
    //   63: pop2
    //   64: iconst_0
    //   65: istore 4
    //   67: iload 4
    //   69: iconst_4
    //   70: if_icmpge +36 -> 106
    //   73: aload_0
    //   74: aload_2
    //   75: iload 4
    //   77: bipush 8
    //   79: imul
    //   80: bipush 8
    //   82: invokevirtual 207	java/io/FileInputStream:read	([BII)I
    //   85: pop
    //   86: aload_0
    //   87: lload 5
    //   89: ldc2_w 208
    //   92: lsub
    //   93: invokevirtual 203	java/io/FileInputStream:skip	(J)J
    //   96: pop2
    //   97: iload 4
    //   99: iconst_1
    //   100: iadd
    //   101: istore 4
    //   103: goto -36 -> 67
    //   106: aload_2
    //   107: invokestatic 164	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   110: astore_1
    //   111: aload_1
    //   112: astore_2
    //   113: aload_0
    //   114: ifnull -96 -> 18
    //   117: aload_0
    //   118: invokevirtual 88	java/io/FileInputStream:close	()V
    //   121: aload_1
    //   122: areturn
    //   123: astore_0
    //   124: aload_1
    //   125: areturn
    //   126: astore_0
    //   127: aload_1
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 88	java/io/FileInputStream:close	()V
    //   137: ldc -90
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull -7 -> 137
    //   147: aload_0
    //   148: invokevirtual 88	java/io/FileInputStream:close	()V
    //   151: goto -14 -> 137
    //   154: astore_0
    //   155: goto -18 -> 137
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 88	java/io/FileInputStream:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: ldc 122
    //   173: invokestatic 128	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   176: astore_3
    //   177: aload_3
    //   178: invokevirtual 131	java/security/MessageDigest:reset	()V
    //   181: new 76	java/io/FileInputStream
    //   184: dup
    //   185: aload_0
    //   186: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: astore_1
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual 135	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   195: getstatic 141	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   198: lconst_0
    //   199: aload_0
    //   200: invokevirtual 144	java/io/File:length	()J
    //   203: invokevirtual 150	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   206: invokevirtual 154	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   209: aload_3
    //   210: invokevirtual 158	java/security/MessageDigest:digest	()[B
    //   213: invokestatic 164	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   216: astore_0
    //   217: aload_0
    //   218: astore_2
    //   219: aload_1
    //   220: ifnull -202 -> 18
    //   223: aload_1
    //   224: invokevirtual 88	java/io/FileInputStream:close	()V
    //   227: aload_0
    //   228: areturn
    //   229: astore_1
    //   230: aload_0
    //   231: areturn
    //   232: astore_0
    //   233: aload_2
    //   234: astore_0
    //   235: aload_0
    //   236: ifnull -99 -> 137
    //   239: aload_0
    //   240: invokevirtual 88	java/io/FileInputStream:close	()V
    //   243: goto -106 -> 137
    //   246: astore_0
    //   247: goto -110 -> 137
    //   250: astore_0
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull -117 -> 137
    //   257: aload_1
    //   258: invokevirtual 88	java/io/FileInputStream:close	()V
    //   261: goto -124 -> 137
    //   264: astore_0
    //   265: goto -128 -> 137
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_1
    //   272: ifnull -135 -> 137
    //   275: aload_1
    //   276: invokevirtual 88	java/io/FileInputStream:close	()V
    //   279: goto -142 -> 137
    //   282: astore_0
    //   283: goto -146 -> 137
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull +7 -> 297
    //   293: aload_1
    //   294: invokevirtual 88	java/io/FileInputStream:close	()V
    //   297: aload_0
    //   298: athrow
    //   299: astore_0
    //   300: goto -163 -> 137
    //   303: astore_0
    //   304: goto -135 -> 169
    //   307: astore_1
    //   308: goto -11 -> 297
    //   311: astore_0
    //   312: goto -23 -> 289
    //   315: astore_0
    //   316: goto -45 -> 271
    //   319: astore_0
    //   320: goto -67 -> 253
    //   323: astore_0
    //   324: aload_1
    //   325: astore_0
    //   326: goto -91 -> 235
    //   329: astore_1
    //   330: goto -169 -> 161
    //   333: astore_1
    //   334: goto -191 -> 143
    //   337: astore_1
    //   338: goto -209 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramFile	File
    //   3	125	1	str	String
    //   158	12	1	localObject1	Object
    //   189	35	1	localFileInputStream	java.io.FileInputStream
    //   229	1	1	localIOException1	java.io.IOException
    //   252	42	1	localObject2	Object
    //   307	18	1	localIOException2	java.io.IOException
    //   329	1	1	localObject3	Object
    //   333	1	1	localIOException3	java.io.IOException
    //   337	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   1	233	2	localObject4	Object
    //   176	34	3	localMessageDigest	java.security.MessageDigest
    //   65	37	4	i1	int
    //   24	64	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   117	121	123	java/io/IOException
    //   48	57	126	java/io/FileNotFoundException
    //   48	57	140	java/io/IOException
    //   147	151	154	java/io/IOException
    //   48	57	158	finally
    //   223	227	229	java/io/IOException
    //   171	190	232	java/security/NoSuchAlgorithmException
    //   239	243	246	java/io/IOException
    //   171	190	250	java/io/FileNotFoundException
    //   257	261	264	java/io/IOException
    //   171	190	268	java/io/IOException
    //   275	279	282	java/io/IOException
    //   171	190	286	finally
    //   133	137	299	java/io/IOException
    //   165	169	303	java/io/IOException
    //   293	297	307	java/io/IOException
    //   190	217	311	finally
    //   190	217	315	java/io/IOException
    //   190	217	319	java/io/FileNotFoundException
    //   190	217	323	java/security/NoSuchAlgorithmException
    //   57	64	329	finally
    //   73	97	329	finally
    //   106	111	329	finally
    //   57	64	333	java/io/IOException
    //   73	97	333	java/io/IOException
    //   106	111	333	java/io/IOException
    //   57	64	337	java/io/FileNotFoundException
    //   73	97	337	java/io/FileNotFoundException
    //   106	111	337	java/io/FileNotFoundException
  }
  
  protected int a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return (str + System.currentTimeMillis()).hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\upload\VipUploadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */