package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PreloadUtils
{
  public static final String a = ".mp4";
  public static final String b = ".png";
  public static final String c = ".file";
  public static final String d = "thumb.jpeg";
  public static final String e = "mask.png";
  public static final String f = ".tmp";
  
  public PreloadUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static File a()
  {
    File localFile = new File(QQStoryConstant.p);
    localFile.mkdirs();
    return localFile;
  }
  
  public static File a(String paramString, int paramInt)
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    if (paramInt == 0)
    {
      localObject = ((StoryManager)localObject).a(paramString);
      if ((localObject != null) && (!TextUtils.isEmpty(((StoryVideoItem)localObject).mLocalVideoPath)))
      {
        localObject = new File(((StoryVideoItem)localObject).mLocalVideoPath);
        if ((!((File)localObject).exists()) || (a((File)localObject, a()))) {}
      }
    }
    do
    {
      File localFile2;
      File localFile1;
      do
      {
        return (File)localObject;
        localObject = a(paramString);
        localFile2 = new File(QQStoryConstant.p + (String)localObject);
        localFile2.mkdirs();
        localFile1 = new File(localFile2 + "/" + a(paramString, paramInt));
        localObject = localFile1;
      } while (localFile1.exists());
      paramString = new File(localFile2 + "/" + b(paramString, paramInt));
      localObject = paramString;
    } while (paramString.exists());
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return paramString;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ".file";
    case 0: 
      return ".mp4";
    case 3: 
      return ".png";
    case 2: 
      return "thumb.jpeg";
    }
    return "mask.png";
  }
  
  public static String a(String paramString)
  {
    PreloadDownloaderManager localPreloadDownloaderManager = (PreloadDownloaderManager)SuperManager.a(6);
    String str = localPreloadDownloaderManager.a(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = b(paramString);
    localPreloadDownloaderManager.a(paramString, str);
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = a(paramInt);
    paramString = a(paramString);
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    return paramString + str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(File paramFile)
  {
    if (!a(paramFile))
    {
      String str1 = paramFile.getParentFile().getAbsolutePath();
      String str2 = paramFile.getName();
      str2 = paramFile.getName().substring(0, str2.length() - ".tmp".length());
      paramFile.renameTo(new File(str1 + "/" + str2));
    }
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {}
    while (paramFile.getName().endsWith(".tmp")) {
      return false;
    }
    return true;
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    if ((!paramFile1.exists()) || (!paramFile2.exists())) {}
    label55:
    for (;;)
    {
      return false;
      paramFile2 = paramFile2.getAbsolutePath();
      int i = 0;
      for (;;)
      {
        if (i >= 3) {
          break label55;
        }
        paramFile1 = paramFile1.getParentFile();
        if (paramFile1 == null) {
          break;
        }
        if (paramFile1.getAbsolutePath().equals(paramFile2)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static String b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return paramString + ".tmp";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */