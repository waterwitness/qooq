package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class PortalUtils
{
  public static final String a = "PortalManager.PortalUtils";
  protected static MessageDigest a;
  private static final int[] a;
  public static final String b = "com.tencent.msg.permission.pushnotify";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3 };
  }
  
  public static String a(long paramLong)
  {
    Object localObject = new java.sql.Date(paramLong);
    localObject = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format((java.util.Date)localObject);
    return ((String)localObject).substring(0, ((String)localObject).lastIndexOf(":"));
  }
  
  public static String a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
  }
  
  public static String a(String paramString)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = MD5.getPartfileMd5(paramString, 0L);
      paramString = (String)localObject;
      if (arrayOfByte != null) {
        paramString = MD5FileUtil.b(arrayOfByte);
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString, long paramLong)
  {
    for (i = 1;; i = j)
    {
      try
      {
        Long.valueOf(paramString);
        j = Integer.valueOf(paramString.substring(0, 1)).intValue() % 4;
        if (j != 0) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int j;
          String str;
          i = 2;
        }
      }
      paramString = new StringBuilder();
      paramString.append("factorIndex").append("=").append(i).append(",");
      paramLong <<= i;
      paramString.append("value1").append("=").append(paramLong).append(",");
      str = i + paramLong;
      paramString.append("value2").append("=").append(str).append(",");
      str = Base64Util.encodeToString(str.getBytes(), 2);
      paramString.append("value3").append("=").append(str);
      if (QLog.isColorLevel()) {
        QLog.d("PortalUtils", 2, paramString.toString());
      }
      return str;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (jdField_a_of_type_JavaSecurityMessageDigest == null) {}
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
      return MD5FileUtil.b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList a(String paramString)
  {
    paramString = paramString.split("\\|");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramString.length)
    {
      if ((TextUtils.isEmpty(paramString[i])) || (!a(paramString[i]))) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(Integer.valueOf(Integer.valueOf(paramString[i]).intValue() * 1000));
      }
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_0
    //   8: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +7 -> 18
    //   14: aload_1
    //   15: astore_0
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 8
    //   26: iconst_2
    //   27: new 123	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   34: ldc -19
    //   36: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: ldc -17
    //   52: invokevirtual 241	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   55: astore_0
    //   56: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +29 -> 88
    //   62: ldc 8
    //   64: iconst_2
    //   65: new 123	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   72: ldc -13
    //   74: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: arraylength
    //   79: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: new 245	java/io/ByteArrayInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 247	java/io/ByteArrayInputStream:<init>	([B)V
    //   96: astore_0
    //   97: new 65	java/io/ByteArrayOutputStream
    //   100: dup
    //   101: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   104: astore 5
    //   106: aload_3
    //   107: astore_1
    //   108: aload 4
    //   110: astore_2
    //   111: sipush 1024
    //   114: newarray <illegal type>
    //   116: astore 6
    //   118: aload_3
    //   119: astore_1
    //   120: aload 4
    //   122: astore_2
    //   123: new 249	java/util/zip/GZIPOutputStream
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 252	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   132: astore 7
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_2
    //   139: aload_0
    //   140: aload 6
    //   142: iconst_0
    //   143: sipush 1024
    //   146: invokevirtual 256	java/io/ByteArrayInputStream:read	([BII)I
    //   149: istore 8
    //   151: iload 8
    //   153: iconst_m1
    //   154: if_icmpeq +115 -> 269
    //   157: aload_3
    //   158: astore_1
    //   159: aload 4
    //   161: astore_2
    //   162: aload 7
    //   164: aload 6
    //   166: iconst_0
    //   167: iload 8
    //   169: invokevirtual 260	java/util/zip/GZIPOutputStream:write	([BII)V
    //   172: goto -38 -> 134
    //   175: astore_2
    //   176: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +32 -> 211
    //   182: ldc 8
    //   184: iconst_2
    //   185: new 123	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 262
    //   195: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_2
    //   199: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 5
    //   213: invokevirtual 268	java/io/ByteArrayOutputStream:close	()V
    //   216: aload_0
    //   217: invokevirtual 269	java/io/ByteArrayInputStream:close	()V
    //   220: aload_1
    //   221: areturn
    //   222: astore_2
    //   223: aload_1
    //   224: astore_0
    //   225: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq -212 -> 16
    //   231: ldc 8
    //   233: iconst_2
    //   234: new 123	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 271
    //   244: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_1
    //   261: areturn
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 273	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   267: aconst_null
    //   268: areturn
    //   269: aload_3
    //   270: astore_1
    //   271: aload 4
    //   273: astore_2
    //   274: aload 7
    //   276: invokevirtual 276	java/util/zip/GZIPOutputStream:flush	()V
    //   279: aload_3
    //   280: astore_1
    //   281: aload 4
    //   283: astore_2
    //   284: aload 7
    //   286: invokevirtual 277	java/util/zip/GZIPOutputStream:close	()V
    //   289: aload_3
    //   290: astore_1
    //   291: aload 4
    //   293: astore_2
    //   294: aload 5
    //   296: invokevirtual 82	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   299: astore_3
    //   300: aload_3
    //   301: astore_1
    //   302: aload_3
    //   303: astore_2
    //   304: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +34 -> 341
    //   310: aload_3
    //   311: astore_1
    //   312: aload_3
    //   313: astore_2
    //   314: ldc 8
    //   316: iconst_2
    //   317: new 123	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 279
    //   327: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_3
    //   331: arraylength
    //   332: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 5
    //   343: invokevirtual 268	java/io/ByteArrayOutputStream:close	()V
    //   346: aload_0
    //   347: invokevirtual 269	java/io/ByteArrayInputStream:close	()V
    //   350: aload_3
    //   351: areturn
    //   352: astore_1
    //   353: aload_3
    //   354: astore_0
    //   355: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq -342 -> 16
    //   361: ldc 8
    //   363: iconst_2
    //   364: new 123	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 271
    //   374: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload_1
    //   378: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_3
    //   391: areturn
    //   392: astore_1
    //   393: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +32 -> 428
    //   399: ldc 8
    //   401: iconst_2
    //   402: new 123	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 281
    //   412: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_1
    //   416: invokevirtual 282	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   419: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload 5
    //   430: invokevirtual 268	java/io/ByteArrayOutputStream:close	()V
    //   433: aload_0
    //   434: invokevirtual 269	java/io/ByteArrayInputStream:close	()V
    //   437: aload_2
    //   438: areturn
    //   439: astore_1
    //   440: aload_2
    //   441: astore_0
    //   442: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq -429 -> 16
    //   448: ldc 8
    //   450: iconst_2
    //   451: new 123	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 271
    //   461: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_1
    //   465: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload_2
    //   478: areturn
    //   479: astore_1
    //   480: aload 5
    //   482: invokevirtual 268	java/io/ByteArrayOutputStream:close	()V
    //   485: aload_0
    //   486: invokevirtual 269	java/io/ByteArrayInputStream:close	()V
    //   489: aload_1
    //   490: athrow
    //   491: astore_0
    //   492: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq -6 -> 489
    //   498: ldc 8
    //   500: iconst_2
    //   501: new 123	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 271
    //   511: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_0
    //   515: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   518: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: goto -38 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramString	String
    //   6	306	1	arrayOfByte1	byte[]
    //   352	26	1	localIOException1	IOException
    //   392	24	1	localOutOfMemoryError	OutOfMemoryError
    //   439	26	1	localIOException2	IOException
    //   479	11	1	localObject1	Object
    //   110	52	2	localObject2	Object
    //   175	24	2	localException	Exception
    //   222	26	2	localIOException3	IOException
    //   273	205	2	localObject3	Object
    //   1	390	3	arrayOfByte2	byte[]
    //   3	289	4	localObject4	Object
    //   104	377	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   116	49	6	arrayOfByte3	byte[]
    //   132	153	7	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   149	19	8	i	int
    // Exception table:
    //   from	to	target	type
    //   111	118	175	java/lang/Exception
    //   123	134	175	java/lang/Exception
    //   139	151	175	java/lang/Exception
    //   162	172	175	java/lang/Exception
    //   274	279	175	java/lang/Exception
    //   284	289	175	java/lang/Exception
    //   294	300	175	java/lang/Exception
    //   304	310	175	java/lang/Exception
    //   314	341	175	java/lang/Exception
    //   211	220	222	java/io/IOException
    //   49	56	262	java/io/UnsupportedEncodingException
    //   341	350	352	java/io/IOException
    //   111	118	392	java/lang/OutOfMemoryError
    //   123	134	392	java/lang/OutOfMemoryError
    //   139	151	392	java/lang/OutOfMemoryError
    //   162	172	392	java/lang/OutOfMemoryError
    //   274	279	392	java/lang/OutOfMemoryError
    //   284	289	392	java/lang/OutOfMemoryError
    //   294	300	392	java/lang/OutOfMemoryError
    //   304	310	392	java/lang/OutOfMemoryError
    //   314	341	392	java/lang/OutOfMemoryError
    //   428	437	439	java/io/IOException
    //   111	118	479	finally
    //   123	134	479	finally
    //   139	151	479	finally
    //   162	172	479	finally
    //   176	211	479	finally
    //   274	279	479	finally
    //   284	289	479	finally
    //   294	300	479	finally
    //   304	310	479	finally
    //   314	341	479	finally
    //   393	428	479	finally
    //   480	489	491	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: ldc_w 284
    //   10: areturn
    //   11: new 123	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 151	java/lang/String:getBytes	()[B
    //   23: iconst_2
    //   24: invokestatic 288	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   27: astore_0
    //   28: new 54	java/lang/String
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 289	java/lang/String:<init>	([B)V
    //   36: astore_2
    //   37: aload_1
    //   38: ldc_w 291
    //   41: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc -124
    //   46: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: ldc -119
    //   55: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: iconst_0
    //   61: iconst_1
    //   62: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
    //   65: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 121	java/lang/Integer:intValue	()I
    //   71: istore_3
    //   72: aload_1
    //   73: ldc_w 296
    //   76: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc -124
    //   81: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc -119
    //   90: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: iconst_1
    //   96: invokevirtual 299	java/lang/String:substring	(I)Ljava/lang/String;
    //   99: invokestatic 112	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   102: invokevirtual 303	java/lang/Long:longValue	()J
    //   105: lstore 4
    //   107: lload 4
    //   109: iload_3
    //   110: lshr
    //   111: lstore 4
    //   113: aload_1
    //   114: ldc_w 305
    //   117: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc -124
    //   122: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: lload 4
    //   127: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: lload 4
    //   133: lstore 6
    //   135: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +17 -> 155
    //   141: ldc -95
    //   143: iconst_2
    //   144: aload_1
    //   145: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: lload 4
    //   153: lstore 6
    //   155: lload 6
    //   157: invokestatic 307	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   160: areturn
    //   161: astore_0
    //   162: lconst_0
    //   163: lstore 4
    //   165: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +13 -> 181
    //   171: ldc -95
    //   173: iconst_2
    //   174: ldc_w 284
    //   177: aload_0
    //   178: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: lload 4
    //   183: lstore 6
    //   185: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -33 -> 155
    //   191: ldc -95
    //   193: iconst_2
    //   194: aload_1
    //   195: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: lload 4
    //   203: lstore 6
    //   205: goto -50 -> 155
    //   208: astore_0
    //   209: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +13 -> 225
    //   215: ldc -95
    //   217: iconst_2
    //   218: aload_1
    //   219: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: goto -63 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   18	201	1	localStringBuilder	StringBuilder
    //   36	59	2	str	String
    //   71	40	3	i	int
    //   105	97	4	l1	long
    //   133	71	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   19	107	161	java/lang/Exception
    //   19	107	208	finally
    //   113	131	208	finally
    //   165	181	208	finally
    //   113	131	227	java/lang/Exception
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new byte['Ѐ'];
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      for (;;)
      {
        int i = localGZIPInputStream.read(paramArrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      for (;;) {}
    }
    catch (Exception localException1)
    {
      paramArrayOfByte = null;
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + localException1.getMessage());
      }
      try
      {
        localByteArrayOutputStream.close();
        localByteArrayInputStream.close();
        arrayOfByte1 = paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager.PortalUtils", 2, "ungzip:after unzip length:" + paramArrayOfByte.length);
            }
            try
            {
              localByteArrayOutputStream.close();
              localByteArrayInputStream.close();
              arrayOfByte1 = paramArrayOfByte;
            }
            catch (IOException localIOException2)
            {
              arrayOfByte1 = paramArrayOfByte;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException2.getMessage());
            arrayOfByte1 = paramArrayOfByte;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            continue;
          }
          catch (Exception localException2) {}
          localIOException3 = localIOException3;
          arrayOfByte1 = paramArrayOfByte;
          if (QLog.isColorLevel())
          {
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException3.getMessage());
            arrayOfByte1 = paramArrayOfByte;
          }
        }
      }
      try
      {
        paramArrayOfByte = new String(arrayOfByte1, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      arrayOfByte1.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        paramArrayOfByte = null;
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + localOutOfMemoryError1.getMessage());
        }
        try
        {
          localByteArrayOutputStream.close();
          localIOException3.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException4)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException4.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localIOException4.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException1.getMessage());
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PortalUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */