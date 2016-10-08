package com.weiyun.sdk.util;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.log.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class HashSumCalc
{
  public static final String MD5_HASH_TYPE = "MD5";
  public static final String SHA_HASH_TYPE = "SHA";
  private static final String TAG = "HashSumCalc";
  private static final char[] sHexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  private static String getHash(String paramString1, String paramString2, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: sipush 8192
    //   15: newarray <illegal type>
    //   17: astore 7
    //   19: aload 6
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore 8
    //   28: aload 6
    //   30: astore_3
    //   31: new 56	java/io/BufferedInputStream
    //   34: dup
    //   35: new 58	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: aload_1
    //   48: aload 7
    //   50: invokevirtual 70	java/io/InputStream:read	([B)I
    //   53: istore 9
    //   55: iload 9
    //   57: ifle +44 -> 101
    //   60: aload 8
    //   62: aload 7
    //   64: iconst_0
    //   65: iload 9
    //   67: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   70: aload_2
    //   71: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   74: ifne -27 -> 47
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 83	java/io/InputStream:close	()V
    //   85: ldc 85
    //   87: areturn
    //   88: astore_0
    //   89: ldc 14
    //   91: aload_0
    //   92: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: goto -13 -> 85
    //   101: aload 8
    //   103: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   106: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   109: astore_2
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 83	java/io/InputStream:close	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: ldc 14
    //   123: aload_0
    //   124: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   127: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -12 -> 118
    //   133: astore_2
    //   134: aload 4
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: ldc 14
    //   141: new 105	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   148: ldc 108
    //   150: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 114
    //   159: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_1
    //   176: ifnull -91 -> 85
    //   179: aload_1
    //   180: invokevirtual 83	java/io/InputStream:close	()V
    //   183: ldc 85
    //   185: areturn
    //   186: astore_0
    //   187: ldc 14
    //   189: aload_0
    //   190: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   193: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc 85
    //   198: areturn
    //   199: astore_2
    //   200: aload 5
    //   202: astore_1
    //   203: aload_1
    //   204: astore_3
    //   205: ldc 14
    //   207: new 105	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   214: ldc 108
    //   216: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 114
    //   225: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: ifnull -157 -> 85
    //   245: aload_1
    //   246: invokevirtual 83	java/io/InputStream:close	()V
    //   249: ldc 85
    //   251: areturn
    //   252: astore_0
    //   253: ldc 14
    //   255: aload_0
    //   256: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   259: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: ldc 85
    //   264: areturn
    //   265: astore_0
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 83	java/io/InputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore_1
    //   277: ldc 14
    //   279: aload_1
    //   280: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   283: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: goto -12 -> 274
    //   289: astore_0
    //   290: aload_1
    //   291: astore_3
    //   292: goto -26 -> 266
    //   295: astore_2
    //   296: goto -93 -> 203
    //   299: astore_2
    //   300: goto -163 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramString1	String
    //   0	303	1	paramString2	String
    //   0	303	2	paramBaseJob	BaseJob
    //   11	281	3	localObject1	Object
    //   7	128	4	localObject2	Object
    //   1	200	5	localObject3	Object
    //   4	25	6	localObject4	Object
    //   17	46	7	arrayOfByte	byte[]
    //   26	76	8	localMessageDigest	MessageDigest
    //   53	13	9	i	int
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/io/IOException
    //   114	118	120	java/io/IOException
    //   12	19	133	java/io/FileNotFoundException
    //   22	28	133	java/io/FileNotFoundException
    //   31	47	133	java/io/FileNotFoundException
    //   179	183	186	java/io/IOException
    //   12	19	199	java/io/IOException
    //   22	28	199	java/io/IOException
    //   31	47	199	java/io/IOException
    //   245	249	252	java/io/IOException
    //   12	19	265	finally
    //   22	28	265	finally
    //   31	47	265	finally
    //   139	175	265	finally
    //   205	241	265	finally
    //   270	274	276	java/io/IOException
    //   47	55	289	finally
    //   60	77	289	finally
    //   101	110	289	finally
    //   47	55	295	java/io/IOException
    //   60	77	295	java/io/IOException
    //   101	110	295	java/io/IOException
    //   47	55	299	java/io/FileNotFoundException
    //   60	77	299	java/io/FileNotFoundException
    //   101	110	299	java/io/FileNotFoundException
  }
  
  public static String getMD5Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "MD5", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static HashMap<String, String> getMd5AndShaHash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramString = getMd5AndShaHash(paramString, "MD5", "SHA", paramBaseJob);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  /* Error */
  private static HashMap<String, String> getMd5AndShaHash(String paramString1, String paramString2, String paramString3, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 56	java/io/BufferedInputStream
    //   12: dup
    //   13: new 58	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: sipush 8192
    //   29: newarray <illegal type>
    //   31: astore 7
    //   33: aload_1
    //   34: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore 4
    //   39: aload_2
    //   40: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   43: astore 6
    //   45: aload 5
    //   47: aload 7
    //   49: invokevirtual 70	java/io/InputStream:read	([B)I
    //   52: istore 8
    //   54: iload 8
    //   56: ifle +59 -> 115
    //   59: aload 4
    //   61: aload 7
    //   63: iconst_0
    //   64: iload 8
    //   66: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   69: aload 6
    //   71: aload 7
    //   73: iconst_0
    //   74: iload 8
    //   76: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   79: aload_3
    //   80: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   83: istore 9
    //   85: iload 9
    //   87: ifne -42 -> 45
    //   90: aload 5
    //   92: ifnull +8 -> 100
    //   95: aload 5
    //   97: invokevirtual 83	java/io/InputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: ldc 14
    //   105: aload_0
    //   106: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   109: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -12 -> 100
    //   115: new 138	java/util/HashMap
    //   118: dup
    //   119: iconst_2
    //   120: invokespecial 141	java/util/HashMap:<init>	(I)V
    //   123: astore_3
    //   124: aload_3
    //   125: aload_1
    //   126: aload 4
    //   128: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   131: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   134: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload_3
    //   139: aload_2
    //   140: aload 6
    //   142: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   145: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   148: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload 5
    //   154: ifnull +8 -> 162
    //   157: aload 5
    //   159: invokevirtual 83	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: areturn
    //   164: astore_0
    //   165: ldc 14
    //   167: aload_0
    //   168: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -12 -> 162
    //   177: astore_2
    //   178: aload 6
    //   180: astore_1
    //   181: aload_1
    //   182: astore 4
    //   184: ldc 14
    //   186: new 105	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   193: ldc 108
    //   195: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 114
    //   204: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 83	java/io/InputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: ldc 14
    //   233: aload_0
    //   234: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   237: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -12 -> 228
    //   243: astore_2
    //   244: aload 7
    //   246: astore_1
    //   247: aload_1
    //   248: astore 4
    //   250: ldc 14
    //   252: new 105	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   259: ldc 108
    //   261: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 114
    //   270: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 83	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: ldc 14
    //   299: aload_0
    //   300: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   303: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -12 -> 294
    //   309: astore_0
    //   310: aload 4
    //   312: ifnull +8 -> 320
    //   315: aload 4
    //   317: invokevirtual 83	java/io/InputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: ldc 14
    //   325: aload_1
    //   326: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: goto -12 -> 320
    //   335: astore_0
    //   336: aload 5
    //   338: astore 4
    //   340: goto -30 -> 310
    //   343: astore_2
    //   344: aload 5
    //   346: astore_1
    //   347: goto -100 -> 247
    //   350: astore_2
    //   351: aload 5
    //   353: astore_1
    //   354: goto -173 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramString1	String
    //   0	357	1	paramString2	String
    //   0	357	2	paramString3	String
    //   0	357	3	paramBaseJob	BaseJob
    //   4	335	4	localObject	Object
    //   24	328	5	localBufferedInputStream	java.io.BufferedInputStream
    //   7	172	6	localMessageDigest	MessageDigest
    //   1	244	7	arrayOfByte	byte[]
    //   52	23	8	i	int
    //   83	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   95	100	102	java/io/IOException
    //   157	162	164	java/io/IOException
    //   9	26	177	java/io/FileNotFoundException
    //   224	228	230	java/io/IOException
    //   9	26	243	java/io/IOException
    //   290	294	296	java/io/IOException
    //   9	26	309	finally
    //   184	220	309	finally
    //   250	286	309	finally
    //   315	320	322	java/io/IOException
    //   26	45	335	finally
    //   45	54	335	finally
    //   59	85	335	finally
    //   115	152	335	finally
    //   26	45	343	java/io/IOException
    //   45	54	343	java/io/IOException
    //   59	85	343	java/io/IOException
    //   115	152	343	java/io/IOException
    //   26	45	350	java/io/FileNotFoundException
    //   45	54	350	java/io/FileNotFoundException
    //   59	85	350	java/io/FileNotFoundException
    //   115	152	350	java/io/FileNotFoundException
  }
  
  public static String getSHA1Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "SHA", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static String getStringHash(String paramString1, String paramString2)
    throws NoSuchAlgorithmException
  {
    paramString1 = paramString1.getBytes();
    paramString2 = MessageDigest.getInstance(paramString2);
    paramString2.update(paramString1, 0, paramString1.length);
    return toHexString(paramString2.digest());
  }
  
  public static String getStringHashSafely(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = getStringHash(paramString1, paramString2);
      return paramString2;
    }
    catch (NoSuchAlgorithmException paramString2)
    {
      Log.e("HashSumCalc", "", paramString2);
    }
    return String.valueOf(paramString1.hashCode());
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(sHexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(sHexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\util\HashSumCalc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */