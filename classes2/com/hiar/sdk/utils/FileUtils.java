package com.hiar.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{
  public FileUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString, Resources paramResources)
  {
    try
    {
      paramString = paramResources.getAssets().open(paramString);
      paramResources = new ByteArrayOutputStream();
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        paramResources.write(i);
      }
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      paramResources = null;
    }
    for (;;)
    {
      return paramResources;
      byte[] arrayOfByte = paramResources.toByteArray();
      paramResources.close();
      paramString.close();
      paramResources = new String(arrayOfByte, "UTF-8");
      try
      {
        paramString = paramResources.replaceAll("\\r\\n", "\n");
        return paramString;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    try
    {
      String[] arrayOfString = paramContext.getResources().getAssets().list(paramString1);
      File localFile = new File(paramString2);
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        break label320;
      }
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        int i;
        if (i >= arrayOfString.length) {
          break;
        }
        Object localObject1 = arrayOfString[i];
        if (!((String)localObject1).contains("."))
        {
          if (paramString1.length() == 0) {
            a(paramContext, (String)localObject1, paramString2 + (String)localObject1 + "/", paramBoolean);
          } else {
            a(paramContext, paramString1 + "/" + (String)localObject1, paramString2 + (String)localObject1 + "/", paramBoolean);
          }
        }
        else
        {
          Object localObject2 = new File(localFile, (String)localObject1);
          if (((File)localObject2).exists())
          {
            bool1 = bool2;
            if (!paramBoolean) {
              break;
            }
            ((File)localObject2).delete();
          }
          if (paramString1.length() != 0) {}
          for (localObject1 = paramContext.getAssets().open(paramString1 + "/" + (String)localObject1);; localObject1 = paramContext.getAssets().open((String)localObject1))
          {
            localObject2 = new FileOutputStream((File)localObject2);
            byte[] arrayOfByte = new byte[' '];
            for (;;)
            {
              int j = ((InputStream)localObject1).read(arrayOfByte);
              if (j <= 0) {
                break;
              }
              ((OutputStream)localObject2).write(arrayOfByte, 0, j);
            }
          }
          ((InputStream)localObject1).close();
          ((OutputStream)localObject2).close();
          break label326;
          label320:
          i = 0;
          continue;
        }
        label326:
        i += 1;
      }
      return bool1;
    }
    catch (IOException paramContext)
    {
      bool1 = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (!a(paramArrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */