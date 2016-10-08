package com.tencent.mobileqq.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.Locale;

public abstract class AbsDownloader
  extends ProtocolDownloader.Adapter
  implements ProtocolDownloaderConstants
{
  protected static final String b_ = AbsDownloader.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final File a(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.startsWith("regionalthumb")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring("regionalthumb:".length());
      }
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
      try
      {
        if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring("file:".length());
        }
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = b(paramString);
          if (paramString != null) {
            return a(paramString) != null;
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static final File b(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString) + "_sp");
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d(b_, 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d(b_, 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static final String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("pubaccountimage"))
      {
        int i = paramString.lastIndexOf("?busiType");
        str = paramString;
        if (i != -1) {
          str = paramString.substring(0, i);
        }
      }
    }
    return "Cache_" + Utils.Crc64String(str);
  }
  
  public static final String d(String paramString)
  {
    String str2 = URLDrawableHelper.a + "/" + c(paramString);
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.startsWith("chatthumb"))
      {
        if (!new File(str2 + "_hd").exists()) {
          break label100;
        }
        str1 = str2 + "_hd";
      }
    }
    label100:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (new File(str2).exists());
        str1 = str2;
      } while (!GeneralConfigUtils.a());
      paramString = str2 + "_big400";
      str1 = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("big_thumb", 2, "getFilePath==" + paramString);
    return paramString;
  }
  
  public static String e(String paramString)
  {
    return d(paramString) + "_dp";
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!a()) {
      return false;
    }
    return a(paramDownloadParams.urlStr);
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 169	com/tencent/mobileqq/transfile/AbsDownloader:a	()Z
    //   10: ifeq +322 -> 332
    //   13: aload_1
    //   14: getfield 174	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   17: astore 6
    //   19: aload 6
    //   21: invokestatic 94	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +37 -> 63
    //   29: getstatic 24	com/tencent/mobileqq/transfile/AbsDownloader:b_	Ljava/lang/String;
    //   32: ldc -73
    //   34: new 96	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   41: ldc -71
    //   43: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_3
    //   47: invokevirtual 188	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   50: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 193	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_3
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: aload 6
    //   65: invokestatic 150	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 7
    //   70: getstatic 198	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   73: aload 7
    //   75: invokevirtual 203	com/tencent/mobileqq/transfile/DiskCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   78: astore 8
    //   80: aload_0
    //   81: invokevirtual 205	com/tencent/mobileqq/transfile/AbsDownloader:b	()Z
    //   84: istore 10
    //   86: iload 10
    //   88: ifeq +277 -> 365
    //   91: aload 4
    //   93: astore_3
    //   94: aload_1
    //   95: aload 8
    //   97: getfield 208	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   100: invokevirtual 211	java/io/File:length	()J
    //   103: putfield 215	com/tencent/image/DownloadParams:downloaded	J
    //   106: aload 4
    //   108: astore_3
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 217	com/tencent/mobileqq/transfile/AbsDownloader:a	(Lcom/tencent/image/DownloadParams;)Z
    //   114: istore 11
    //   116: iload 11
    //   118: ifne +107 -> 225
    //   121: iconst_1
    //   122: istore 9
    //   124: iload 10
    //   126: iload 9
    //   128: iand
    //   129: istore 10
    //   131: aload 4
    //   133: astore_3
    //   134: new 219	java/io/FileOutputStream
    //   137: dup
    //   138: aload 8
    //   140: getfield 208	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   143: iload 10
    //   145: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   148: astore 4
    //   150: aload_0
    //   151: aload 4
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 224	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   158: pop
    //   159: aload 6
    //   161: invokestatic 94	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +65 -> 231
    //   169: getstatic 24	com/tencent/mobileqq/transfile/AbsDownloader:b_	Ljava/lang/String;
    //   172: ldc -73
    //   174: new 96	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   181: ldc -30
    //   183: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 188	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   190: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 193	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 8
    //   201: getfield 208	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   204: invokevirtual 229	java/io/File:delete	()Z
    //   207: pop
    //   208: aload_2
    //   209: astore_1
    //   210: aload 4
    //   212: ifnull -151 -> 61
    //   215: aload 4
    //   217: invokevirtual 234	java/io/OutputStream:close	()V
    //   220: aload_2
    //   221: areturn
    //   222: astore_1
    //   223: aload_2
    //   224: areturn
    //   225: iconst_0
    //   226: istore 9
    //   228: goto -104 -> 124
    //   231: aload 8
    //   233: invokevirtual 237	com/tencent/mobileqq/transfile/DiskCache$Editor:a	()Ljava/io/File;
    //   236: astore_2
    //   237: aload_2
    //   238: astore_1
    //   239: aload 4
    //   241: ifnull -180 -> 61
    //   244: aload 4
    //   246: invokevirtual 234	java/io/OutputStream:close	()V
    //   249: aload_2
    //   250: areturn
    //   251: astore_1
    //   252: aload_2
    //   253: areturn
    //   254: astore_1
    //   255: aload 5
    //   257: astore_2
    //   258: aload 8
    //   260: ifnull +12 -> 272
    //   263: aload_2
    //   264: astore_3
    //   265: aload 8
    //   267: iload 10
    //   269: invokevirtual 240	com/tencent/mobileqq/transfile/DiskCache$Editor:a	(Z)V
    //   272: aload_2
    //   273: astore_3
    //   274: ldc -14
    //   276: ldc -73
    //   278: new 96	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   285: ldc -12
    //   287: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 7
    //   292: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc -10
    //   297: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 6
    //   302: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 248	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_2
    //   312: astore_3
    //   313: aload_1
    //   314: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   317: aload_2
    //   318: astore_3
    //   319: aload_1
    //   320: athrow
    //   321: astore_1
    //   322: aload_3
    //   323: ifnull +7 -> 330
    //   326: aload_3
    //   327: invokevirtual 234	java/io/OutputStream:close	()V
    //   330: aload_1
    //   331: athrow
    //   332: aload_0
    //   333: aconst_null
    //   334: aload_1
    //   335: aload_2
    //   336: invokevirtual 224	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   339: areturn
    //   340: astore_2
    //   341: goto -11 -> 330
    //   344: astore_1
    //   345: aload 4
    //   347: astore_3
    //   348: goto -26 -> 322
    //   351: astore_1
    //   352: aload 5
    //   354: astore_2
    //   355: goto -97 -> 258
    //   358: astore_1
    //   359: aload 4
    //   361: astore_2
    //   362: goto -104 -> 258
    //   365: goto -234 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	AbsDownloader
    //   0	368	1	paramDownloadParams	DownloadParams
    //   0	368	2	paramURLDrawableHandler	URLDrawableHandler
    //   24	324	3	localObject1	Object
    //   1	359	4	localFileOutputStream	java.io.FileOutputStream
    //   4	349	5	localObject2	Object
    //   17	284	6	str1	String
    //   68	223	7	str2	String
    //   78	188	8	localEditor	DiskCache.Editor
    //   122	105	9	bool1	boolean
    //   84	184	10	bool2	boolean
    //   114	3	11	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   215	220	222	java/io/IOException
    //   244	249	251	java/io/IOException
    //   94	106	254	java/lang/Exception
    //   109	116	254	java/lang/Exception
    //   94	106	321	finally
    //   109	116	321	finally
    //   134	150	321	finally
    //   265	272	321	finally
    //   274	311	321	finally
    //   313	317	321	finally
    //   319	321	321	finally
    //   326	330	340	java/io/IOException
    //   150	165	344	finally
    //   169	208	344	finally
    //   231	237	344	finally
    //   134	150	351	java/lang/Exception
    //   150	165	358	java/lang/Exception
    //   169	208	358	java/lang/Exception
    //   231	237	358	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\AbsDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */