package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QPUpdFileOperation
{
  public static final int a = 2048;
  
  public QPUpdFileOperation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    int i;
    if (a(paramString)) {
      i = paramString.length() - 1;
    }
    for (;;)
    {
      if ((i < 0) || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
      {
        str = paramString.substring(i + 1);
        return str;
      }
      i -= 1;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = new FileInputStream(paramString1);
    ZipInputStream localZipInputStream = new ZipInputStream(new BufferedInputStream(paramString1));
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = localZipInputStream.getNextEntry();
        if (localObject == null) {
          break;
        }
        if (((ZipEntry)localObject).getName().contains("..")) {
          continue;
        }
        byte[] arrayOfByte = new byte['ࠀ'];
        localObject = new BufferedOutputStream(new FileOutputStream(paramString2 + "/" + ((ZipEntry)localObject).getName()), 2048);
        int i = localZipInputStream.read(arrayOfByte, 0, 2048);
        if (i != -1)
        {
          ((BufferedOutputStream)localObject).write(arrayOfByte, 0, i);
          continue;
        }
        ((BufferedOutputStream)localObject).flush();
      }
      finally
      {
        paramString1.close();
        localZipInputStream.close();
      }
      ((BufferedOutputStream)localObject).close();
    }
    paramString1.close();
    localZipInputStream.close();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (!paramFile2.exists()) {}
    label125:
    for (;;)
    {
      return false;
      if (paramFile1.exists()) {}
      for (boolean bool = paramFile1.delete();; bool = true)
      {
        if (!bool) {
          break label125;
        }
        try
        {
          bool = paramFile1.createNewFile();
          if (!bool) {
            break;
          }
        }
        catch (IOException localIOException)
        {
          try
          {
            byte[] arrayOfByte;
            paramFile2 = new FileInputStream(paramFile2);
            paramFile1 = new FileOutputStream(paramFile1);
            int i = paramFile2.read(arrayOfByte, 0, 2048);
            if (i == -1) {
              continue;
            }
            paramFile1.write(arrayOfByte, 0, i);
            continue;
          }
          catch (FileNotFoundException paramFile1)
          {
            for (;;)
            {
              paramFile1.printStackTrace();
              return true;
              localIOException = localIOException;
              localIOException.printStackTrace();
            }
            paramFile2.close();
            paramFile1.close();
            continue;
          }
          catch (IOException paramFile1)
          {
            paramFile1.printStackTrace();
            continue;
          }
        }
        arrayOfByte = new byte['ࠀ'];
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/')) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (!a(paramFile1, paramFile2)) {}
    while (!paramFile2.delete()) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPUpdFileOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */