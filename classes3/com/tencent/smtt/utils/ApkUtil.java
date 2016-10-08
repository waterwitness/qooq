package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

public class ApkUtil
{
  private static final String LOGTAG = "ApkUtil";
  public static final String TBS_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  
  public static int getApkVersion(Context paramContext, File paramFile)
  {
    int j = 0;
    int i = j;
    if (paramFile != null)
    {
      i = j;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
      i = j;
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public static String getMd5(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: bipush 16
    //   5: newarray <illegal type>
    //   7: astore_2
    //   8: aload_2
    //   9: dup
    //   10: iconst_0
    //   11: ldc 58
    //   13: castore
    //   14: dup
    //   15: iconst_1
    //   16: ldc 59
    //   18: castore
    //   19: dup
    //   20: iconst_2
    //   21: ldc 60
    //   23: castore
    //   24: dup
    //   25: iconst_3
    //   26: ldc 61
    //   28: castore
    //   29: dup
    //   30: iconst_4
    //   31: ldc 62
    //   33: castore
    //   34: dup
    //   35: iconst_5
    //   36: ldc 63
    //   38: castore
    //   39: dup
    //   40: bipush 6
    //   42: ldc 64
    //   44: castore
    //   45: dup
    //   46: bipush 7
    //   48: ldc 65
    //   50: castore
    //   51: dup
    //   52: bipush 8
    //   54: ldc 66
    //   56: castore
    //   57: dup
    //   58: bipush 9
    //   60: ldc 67
    //   62: castore
    //   63: dup
    //   64: bipush 10
    //   66: ldc 68
    //   68: castore
    //   69: dup
    //   70: bipush 11
    //   72: ldc 69
    //   74: castore
    //   75: dup
    //   76: bipush 12
    //   78: ldc 70
    //   80: castore
    //   81: dup
    //   82: bipush 13
    //   84: ldc 71
    //   86: castore
    //   87: dup
    //   88: bipush 14
    //   90: ldc 72
    //   92: castore
    //   93: dup
    //   94: bipush 15
    //   96: ldc 73
    //   98: castore
    //   99: pop
    //   100: bipush 32
    //   102: newarray <illegal type>
    //   104: astore_3
    //   105: ldc 75
    //   107: invokestatic 81	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   110: astore 4
    //   112: new 83	java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: sipush 8192
    //   126: newarray <illegal type>
    //   128: astore 5
    //   130: aload_1
    //   131: astore_0
    //   132: aload_1
    //   133: aload 5
    //   135: invokevirtual 90	java/io/FileInputStream:read	([B)I
    //   138: istore 7
    //   140: iload 7
    //   142: iconst_m1
    //   143: if_icmpeq +37 -> 180
    //   146: aload_1
    //   147: astore_0
    //   148: aload 4
    //   150: aload 5
    //   152: iconst_0
    //   153: iload 7
    //   155: invokevirtual 94	java/security/MessageDigest:update	([BII)V
    //   158: goto -28 -> 130
    //   161: astore_2
    //   162: aload_1
    //   163: astore_0
    //   164: aload_2
    //   165: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 98	java/io/FileInputStream:close	()V
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: areturn
    //   180: aload_1
    //   181: astore_0
    //   182: aload 4
    //   184: invokevirtual 102	java/security/MessageDigest:digest	()[B
    //   187: astore 4
    //   189: iconst_0
    //   190: istore 7
    //   192: goto +72 -> 264
    //   195: aload_1
    //   196: astore_0
    //   197: new 104	java/lang/String
    //   200: dup
    //   201: aload_3
    //   202: invokespecial 107	java/lang/String:<init>	([C)V
    //   205: astore_2
    //   206: aload_2
    //   207: astore_0
    //   208: aload_1
    //   209: ifnull -31 -> 178
    //   212: aload_1
    //   213: invokevirtual 98	java/io/FileInputStream:close	()V
    //   216: aload_2
    //   217: areturn
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   223: aload_2
    //   224: areturn
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_0
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 98	java/io/FileInputStream:close	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   243: goto -7 -> 236
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   251: goto -75 -> 176
    //   254: astore_1
    //   255: goto -27 -> 228
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_1
    //   261: goto -99 -> 162
    //   264: iload 6
    //   266: bipush 16
    //   268: if_icmpge -73 -> 195
    //   271: aload 4
    //   273: iload 6
    //   275: baload
    //   276: istore 8
    //   278: iload 7
    //   280: iconst_1
    //   281: iadd
    //   282: istore 9
    //   284: aload_3
    //   285: iload 7
    //   287: aload_2
    //   288: iload 8
    //   290: iconst_4
    //   291: iushr
    //   292: bipush 15
    //   294: iand
    //   295: caload
    //   296: castore
    //   297: iload 9
    //   299: iconst_1
    //   300: iadd
    //   301: istore 7
    //   303: aload_3
    //   304: iload 9
    //   306: aload_2
    //   307: iload 8
    //   309: bipush 15
    //   311: iand
    //   312: caload
    //   313: castore
    //   314: iload 6
    //   316: iconst_1
    //   317: iadd
    //   318: istore 6
    //   320: goto -56 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramFile	File
    //   120	93	1	localFileInputStream	java.io.FileInputStream
    //   225	12	1	localObject1	Object
    //   254	1	1	localObject2	Object
    //   260	1	1	localObject3	Object
    //   7	2	2	arrayOfChar1	char[]
    //   161	4	2	localException1	Exception
    //   205	19	2	str	String
    //   258	49	2	localException2	Exception
    //   104	200	3	arrayOfChar2	char[]
    //   110	162	4	localObject4	Object
    //   128	23	5	arrayOfByte	byte[]
    //   1	318	6	i	int
    //   138	164	7	j	int
    //   276	36	8	k	int
    //   282	23	9	m	int
    // Exception table:
    //   from	to	target	type
    //   123	130	161	java/lang/Exception
    //   132	140	161	java/lang/Exception
    //   148	158	161	java/lang/Exception
    //   182	189	161	java/lang/Exception
    //   197	206	161	java/lang/Exception
    //   212	216	218	java/io/IOException
    //   105	121	225	finally
    //   232	236	238	java/io/IOException
    //   172	176	246	java/io/IOException
    //   123	130	254	finally
    //   132	140	254	finally
    //   148	158	254	finally
    //   164	168	254	finally
    //   182	189	254	finally
    //   197	206	254	finally
    //   105	121	258	java/lang/Exception
  }
  
  public static boolean verifyTbsApk(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return false;
      if ((paramLong <= 0L) || (paramLong == paramFile.length())) {
        try
        {
          if (paramInt == getApkVersion(paramContext, paramFile))
          {
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(AppUtil.getSignatureFromApk(paramContext, paramFile));
            if (bool) {
              return true;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\ApkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */