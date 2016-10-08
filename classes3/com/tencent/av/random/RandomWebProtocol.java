package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gkn;
import gko;
import gkp;
import gkq;
import gkr;
import gks;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RandomWebProtocol
{
  static final String jdField_a_of_type_JavaLangString = "RandomWebProtocol";
  static final String b = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/onechat";
  static final String c = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/groupchat";
  static final String d = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/grouppull";
  static final String e = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/onechat";
  static final String f = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/groupchat";
  static final String g = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/grouppull";
  public VideoAppInterface a;
  gkp jdField_a_of_type_Gkp;
  public List a;
  public Map a;
  public boolean a;
  
  RandomWebProtocol(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Gkp = new gkp(this);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: ldc 70
    //   10: astore 4
    //   12: new 72	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 79	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 81	java/net/HttpURLConnection
    //   26: astore_0
    //   27: aload_0
    //   28: iconst_1
    //   29: invokevirtual 85	java/net/HttpURLConnection:setDoInput	(Z)V
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 88	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_0
    //   38: ldc 90
    //   40: ldc 92
    //   42: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_2
    //   46: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +10 -> 59
    //   52: aload_0
    //   53: ldc 104
    //   55: aload_2
    //   56: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: ldc 106
    //   62: invokevirtual 109	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: iconst_0
    //   67: invokevirtual 112	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   70: aload_0
    //   71: sipush 5000
    //   74: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   77: aload_0
    //   78: sipush 10000
    //   81: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   84: aload_0
    //   85: invokevirtual 122	java/net/HttpURLConnection:connect	()V
    //   88: aload_1
    //   89: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +28 -> 120
    //   95: new 124	java/io/DataOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokevirtual 128	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   103: invokespecial 131	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   106: astore_2
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 134	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 137	java/io/DataOutputStream:flush	()V
    //   116: aload_2
    //   117: invokevirtual 140	java/io/DataOutputStream:close	()V
    //   120: new 142	java/io/BufferedReader
    //   123: dup
    //   124: new 144	java/io/InputStreamReader
    //   127: dup
    //   128: aload_0
    //   129: invokevirtual 148	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   132: invokespecial 151	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   135: invokespecial 154	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   138: astore_1
    //   139: new 156	java/lang/StringBuffer
    //   142: dup
    //   143: invokespecial 157	java/lang/StringBuffer:<init>	()V
    //   146: astore_2
    //   147: aload_1
    //   148: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +33 -> 186
    //   156: aload_2
    //   157: aload_3
    //   158: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   161: pop
    //   162: goto -15 -> 147
    //   165: astore_1
    //   166: aload_0
    //   167: astore_3
    //   168: aload_1
    //   169: invokevirtual 168	java/net/MalformedURLException:printStackTrace	()V
    //   172: aload 4
    //   174: astore_1
    //   175: aload_0
    //   176: ifnull +83 -> 259
    //   179: aload_0
    //   180: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   183: ldc 70
    //   185: areturn
    //   186: aload_1
    //   187: invokevirtual 172	java/io/BufferedReader:close	()V
    //   190: aload_2
    //   191: invokevirtual 175	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   194: astore_2
    //   195: aload_2
    //   196: astore_1
    //   197: aload_0
    //   198: ifnull +61 -> 259
    //   201: aload_0
    //   202: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   205: aload_2
    //   206: areturn
    //   207: astore_1
    //   208: aload 6
    //   210: astore_0
    //   211: aload_0
    //   212: astore_3
    //   213: aload_1
    //   214: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   217: aload 4
    //   219: astore_1
    //   220: aload_0
    //   221: ifnull +38 -> 259
    //   224: aload_0
    //   225: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   228: ldc 70
    //   230: areturn
    //   231: astore_1
    //   232: aload_3
    //   233: astore_0
    //   234: aload_0
    //   235: ifnull +7 -> 242
    //   238: aload_0
    //   239: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: goto -11 -> 234
    //   248: astore_1
    //   249: goto -38 -> 211
    //   252: astore_1
    //   253: aload 5
    //   255: astore_0
    //   256: goto -90 -> 166
    //   259: aload_1
    //   260: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramString1	String
    //   0	261	1	paramString2	String
    //   0	261	2	paramString3	String
    //   4	229	3	str1	String
    //   10	208	4	str2	String
    //   6	248	5	localObject1	Object
    //   1	208	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	59	165	java/net/MalformedURLException
    //   59	120	165	java/net/MalformedURLException
    //   120	147	165	java/net/MalformedURLException
    //   147	152	165	java/net/MalformedURLException
    //   156	162	165	java/net/MalformedURLException
    //   186	195	165	java/net/MalformedURLException
    //   12	27	207	java/io/IOException
    //   12	27	231	finally
    //   168	172	231	finally
    //   213	217	231	finally
    //   27	59	244	finally
    //   59	120	244	finally
    //   120	147	244	finally
    //   147	152	244	finally
    //   156	162	244	finally
    //   186	195	244	finally
    //   27	59	248	java/io/IOException
    //   59	120	248	java/io/IOException
    //   120	147	248	java/io/IOException
    //   147	152	248	java/io/IOException
    //   156	162	248	java/io/IOException
    //   186	195	248	java/io/IOException
    //   12	27	252	java/net/MalformedURLException
  }
  
  public static boolean b()
  {
    return false;
  }
  
  /* Error */
  public android.graphics.Bitmap a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 189	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   16: ldc -64
    //   18: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -59
    //   27: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 45	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   44: invokevirtual 206	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   47: aload_1
    //   48: iconst_1
    //   49: invokevirtual 211	com/tencent/av/VideoController:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +54 -> 108
    //   57: aload_3
    //   58: astore 4
    //   60: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +36 -> 99
    //   66: ldc 8
    //   68: iconst_2
    //   69: new 189	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   76: ldc -43
    //   78: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc -41
    //   87: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: astore 4
    //   99: aload 4
    //   101: areturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_3
    //   105: goto -52 -> 53
    //   108: new 189	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   115: invokestatic 219	com/tencent/av/utils/ImageResUtil:a	()Ljava/lang/String;
    //   118: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_2
    //   122: invokestatic 225	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: aload_2
    //   130: ldc -29
    //   132: invokevirtual 233	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   135: invokevirtual 237	java/lang/String:substring	(I)Ljava/lang/String;
    //   138: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 4
    //   146: aload 4
    //   148: invokestatic 242	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   151: ifne +147 -> 298
    //   154: new 244	java/io/File
    //   157: dup
    //   158: aload 4
    //   160: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore 5
    //   165: aload_0
    //   166: getfield 45	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   169: aload_2
    //   170: aload 5
    //   172: invokestatic 250	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   175: istore 6
    //   177: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +59 -> 239
    //   183: ldc 8
    //   185: iconst_2
    //   186: new 189	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   193: ldc -4
    //   195: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc -2
    //   204: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 256
    //   214: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 4
    //   219: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 258
    //   225: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iload 6
    //   230: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   233: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 4
    //   241: invokestatic 242	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   244: istore 6
    //   246: aload_3
    //   247: astore_2
    //   248: iload 6
    //   250: ifeq +29 -> 279
    //   253: new 263	java/io/BufferedInputStream
    //   256: dup
    //   257: new 265	java/io/FileInputStream
    //   260: dup
    //   261: aload 4
    //   263: invokespecial 266	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   266: invokespecial 267	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   269: astore_3
    //   270: aload_3
    //   271: invokestatic 273	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   274: astore_2
    //   275: aload_3
    //   276: invokevirtual 274	java/io/BufferedInputStream:close	()V
    //   279: aload_2
    //   280: ifnull +106 -> 386
    //   283: aload_0
    //   284: getfield 45	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   287: invokevirtual 206	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   290: aload_1
    //   291: aload_2
    //   292: iconst_1
    //   293: invokevirtual 277	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   296: aload_2
    //   297: areturn
    //   298: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -62 -> 239
    //   304: ldc 8
    //   306: iconst_2
    //   307: new 189	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   314: ldc -4
    //   316: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 279
    //   326: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 4
    //   331: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: goto -101 -> 239
    //   343: astore_2
    //   344: aload_3
    //   345: astore_2
    //   346: goto -67 -> 279
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_2
    //   352: goto -73 -> 279
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_2
    //   358: goto -79 -> 279
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -85 -> 279
    //   367: astore_2
    //   368: aload_0
    //   369: getfield 45	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   372: invokevirtual 206	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   375: aload_1
    //   376: aconst_null
    //   377: iconst_1
    //   378: invokevirtual 277	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   381: aload_3
    //   382: astore_2
    //   383: goto -104 -> 279
    //   386: aload_2
    //   387: astore 4
    //   389: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq -293 -> 99
    //   395: ldc 8
    //   397: iconst_2
    //   398: new 189	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   405: ldc -4
    //   407: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_1
    //   411: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 281
    //   417: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_2
    //   427: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	RandomWebProtocol
    //   0	428	1	paramString1	String
    //   0	428	2	paramString2	String
    //   52	45	3	localBitmap	android.graphics.Bitmap
    //   102	1	3	localException	Exception
    //   104	278	3	localBufferedInputStream	java.io.BufferedInputStream
    //   58	330	4	localObject	Object
    //   163	8	5	localFile	java.io.File
    //   175	74	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   40	53	102	java/lang/Exception
    //   108	239	343	java/lang/Exception
    //   239	246	343	java/lang/Exception
    //   298	340	343	java/lang/Exception
    //   253	279	349	java/lang/OutOfMemoryError
    //   253	279	355	java/io/IOException
    //   253	279	361	java/lang/Exception
    //   108	239	367	java/lang/OutOfMemoryError
    //   239	246	367	java/lang/OutOfMemoryError
    //   298	340	367	java/lang/OutOfMemoryError
  }
  
  public String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramString);
      }
    }
    return (String)localObject1;
  }
  
  public void a()
  {
    gko localgko = (gko)this.jdField_a_of_type_JavaUtilMap.get("[d] RequestDouble");
    if (localgko != null) {
      localgko.a();
    }
    localgko = (gko)this.jdField_a_of_type_JavaUtilMap.get("[m] RequestMulti");
    if (localgko != null) {
      localgko.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Gkp.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/grouppull";; localObject = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/grouppull")
    {
      localObject = new gks(this, this.jdField_a_of_type_Gkp, (String)localObject, paramInt1, paramInt2, paramString, paramInt3, paramLong);
      if ((gko)this.jdField_a_of_type_JavaUtilMap.get(((gks)localObject).d) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][pullhead] ====== pullMulti ====== type(" + paramInt2 + "), uin(" + paramString + "), groupId(" + paramLong + "), gender(" + paramInt3 + ")");
      }
      paramString = new gko(this, (gkp)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((gks)localObject).d, paramString);
      paramString.start();
      return;
    }
  }
  
  public void a(RandomWebProtocol.OnRequestListener paramOnRequestListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramOnRequestListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnRequestListener);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] ====== pullDouble ====== uin(" + paramString1 + "), url(" + paramString2 + ")");
    }
    new gkn(this, paramString2, paramString1).start();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchMulti~ ***");
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/groupchat";; localObject = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/groupchat")
    {
      localObject = new gkr(this, this.jdField_a_of_type_Gkp, (String)localObject, paramBoolean, paramInt);
      gko localgko = (gko)this.jdField_a_of_type_JavaUtilMap.get(((gkr)localObject).d);
      if (localgko != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchMulti~: last matching not finished, dropped it!");
        }
        localgko.a();
      }
      localgko = new gko(this, (gkp)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((gkr)localObject).d, localgko);
      localgko.start();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchDouble ***");
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/onechat";; localObject = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/onechat")
    {
      localObject = new gkq(this, this.jdField_a_of_type_Gkp, (String)localObject, paramBoolean, paramInt1, paramInt2);
      gko localgko = (gko)this.jdField_a_of_type_JavaUtilMap.get(((gkq)localObject).d);
      if (localgko != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchDouble: last matching not finished, dropped it!");
        }
        localgko.a();
      }
      localgko = new gko(this, (gkp)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((gkq)localObject).d, localgko);
      localgko.start();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Gkp.f != -1;
  }
  
  public byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      return arrayOfByte;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public void b(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (String str = "http://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/grouppull";; str = "http://play.mobile.qq.com/randchat/cgi-bin/chatplay/grouppull")
    {
      paramString = new gks(this, this.jdField_a_of_type_Gkp, str, paramInt1, paramInt2, paramString, paramInt3, paramLong);
      paramString = (gko)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
      if (paramString != null) {
        paramString.a();
      }
      return;
    }
  }
  
  public void b(RandomWebProtocol.OnRequestListener paramOnRequestListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramOnRequestListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\random\RandomWebProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */