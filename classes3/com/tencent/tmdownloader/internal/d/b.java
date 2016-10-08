package com.tencent.tmdownloader.internal.d;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.zip.GZIPInputStream;

public class b
{
  protected String a = null;
  protected String b = null;
  protected FileOutputStream c = null;
  protected byte[] d = null;
  protected long e = 0L;
  protected int f = 0;
  public boolean g = false;
  
  public b(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = c();
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new GZIPInputStream(new FileInputStream(paramFile1));
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte['࿥'];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile1.close();
    }
    catch (IOException paramFile1)
    {
      paramFile1.printStackTrace();
      return false;
    }
    paramFile2.flush();
    paramFile2.close();
    return true;
  }
  
  private boolean a(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null))
    {
      m.c("TMAssistantFile", "fileOutputStream == null || buffer == null");
      m.c("TMAssistantFile", "exit");
      return false;
    }
    if (paramLong != this.e)
    {
      m.c("TMAssistantFile", "writeData0 failed,filelen:" + this.e + ",offset:" + paramLong + ",filename:" + this.a);
      m.c("TMAssistantFile", "exit");
      return false;
    }
    if (paramInt2 >= 16384) {}
    for (;;)
    {
      try
      {
        if (this.f > 0)
        {
          paramFileOutputStream.write(this.d, 0, this.f);
          this.f = 0;
        }
        paramFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        this.e += paramInt2;
        return true;
      }
      catch (IOException paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
        m.d("TMAssistantFile", "writeData1 failed " + paramFileOutputStream);
        return false;
      }
      if ((this.f + paramInt2 > 16384) && (this.f > 0)) {}
      try
      {
        paramFileOutputStream.write(this.d, 0, this.f);
        this.f = 0;
        System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.f, paramInt2);
        this.f += paramInt2;
        this.e += paramInt2;
      }
      catch (IOException paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
        m.d("TMAssistantFile", "writeData2 failed " + paramFileOutputStream);
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    m.c("TMAssistantFile", "enter");
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists() == true)
      {
        File localFile = new File(paramString2);
        if (this.g) {
          if (localFile.exists()) {}
        }
        for (bool = a(paramString1, localFile);; bool = paramString1.renameTo(localFile))
        {
          if (bool) {
            f.d(paramString2);
          }
          m.c("TMAssistantFile", "moveFileFromTmpToSavaPath result: " + bool);
          return bool;
        }
      }
    }
    m.c("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    m.c("TMAssistantFile", "exit");
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = f();
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public static String f()
  {
    Object localObject = f.a().b();
    if (localObject == null) {
      return null;
    }
    if (h())
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;
    }
    return ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
  }
  
  public static boolean h()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite());
  }
  
  public void a()
  {
    String str = b(this.b);
    m.c("TMAssistantFile", "deleteFile 1 finalFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      m.c("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if ((localFile != null) && (localFile.exists()))
      {
        boolean bool = localFile.delete();
        m.c("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    m.c("TMAssistantFile", "deleteFile 3");
  }
  
  void a(String paramString)
  {
    boolean bool = true;
    m.c("TMAssistantFile", "enter");
    m.c("TMAssistantFile", "fileFullPath: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      m.e("TMAssistantFile", "fileFullPath is null or the filename.size is zero.");
      throw new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
    }
    int i = paramString.lastIndexOf("/");
    if ((i == -1) || (paramString.length() == 1))
    {
      m.e("TMAssistantFile", "fileFullPath is not a valid full path. fileName: " + paramString);
      throw new InvalidParameterException("fileFullPath is not a valid full path. fileName: " + paramString);
    }
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    paramString = new File(str);
    if (!paramString.exists()) {
      bool = paramString.mkdirs();
    }
    if (!bool)
    {
      m.e("TMAssistantFile", "Failed to create directory. dir: " + str);
      throw new IOException("Failed to create directory. dir: " + str);
    }
    m.c("TMAssistantFile", "exit");
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        String str;
        if (this.c == null)
        {
          str = c(this.a);
          if (str == null) {}
        }
        else
        {
          try
          {
            a(str);
            this.c = new FileOutputStream(str, true);
            if (this.d == null)
            {
              this.d = new byte['䀀'];
              this.f = 0;
            }
            bool = a(this.c, paramArrayOfByte, paramInt1, paramInt2, paramLong);
            if (bool) {
              break label161;
            }
            paramBoolean = bool;
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            m.d("TMAssistantFile", "write failed" + paramArrayOfByte);
            paramBoolean = bool;
            continue;
          }
          return paramBoolean;
        }
      }
      finally {}
      m.d("TMAssistantFile", "write failed tmpFilePathString is null");
      m.c("TMAssistantFile", "exit");
      paramBoolean = bool;
      continue;
      label161:
      if ((paramBoolean == true) && (d() == true))
      {
        m.c("TMAssistantFile", "moveFileFromTmpToSavaPath");
        m.c("TMAssistantFile", "exit");
        paramBoolean = a(c(this.a), b(this.b));
      }
      else
      {
        paramBoolean = true;
      }
    }
  }
  
  public void b()
  {
    String str = c(this.a);
    m.c("TMAssistantFile", "deleteFile 1 tmpFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      m.c("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if ((localFile != null) && (localFile.exists()))
      {
        boolean bool = localFile.delete();
        m.c("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    m.c("TMAssistantFile", "deleteFile 3");
  }
  
  public long c()
  {
    long l = 0L;
    Object localObject = b(this.b);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        break label82;
      }
      localObject = c(this.a);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          break label71;
        }
        this.e = 0L;
      }
    }
    for (;;)
    {
      l = this.e;
      return l;
      label71:
      this.e = ((File)localObject).length();
      continue;
      label82:
      this.e = ((File)localObject).length();
    }
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = f();
    } while (str == null);
    return str + "/.tmp/" + paramString + ".tmp";
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.c != null)
      {
        int i = this.f;
        bool1 = bool2;
        if (i <= 0) {}
      }
      try
      {
        this.c.write(this.d, 0, this.f);
        this.f = 0;
        bool1 = true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          m.d("TMAssistantFile", "flush failed " + localIOException);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 268	com/tencent/tmdownloader/internal/d/b:d	()Z
    //   6: pop
    //   7: aload_0
    //   8: getfield 28	com/tencent/tmdownloader/internal/d/b:c	Ljava/io/FileOutputStream;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 28	com/tencent/tmdownloader/internal/d/b:c	Ljava/io/FileOutputStream;
    //   18: invokevirtual 74	java/io/FileOutputStream:close	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 28	com/tencent/tmdownloader/internal/d/b:c	Ljava/io/FileOutputStream;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 30	com/tencent/tmdownloader/internal/d/b:d	[B
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 32	com/tencent/tmdownloader/internal/d/b:e	J
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: ldc 77
    //   42: new 87	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 284
    //   52: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 112	com/tencent/tmassistantbase/a/m:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   69: goto -48 -> 21
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	b
    //   39	27	1	localIOException	IOException
    //   72	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	39	java/io/IOException
    //   2	7	72	finally
    //   7	21	72	finally
    //   21	36	72	finally
    //   40	69	72	finally
  }
  
  public void g()
  {
    a(c(this.a), b(this.b));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */