package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PttBuffer
{
  private static int jdField_a_of_type_Int = 4000;
  private static final String jdField_a_of_type_JavaLangString = "~tmp";
  private static final Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static void a(PttBuffer.BufferTask paramBufferTask, boolean paramBoolean)
  {
    if ((paramBufferTask != null) && (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramBufferTask.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramBufferTask.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramBufferTask.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramBufferTask.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramBufferTask.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramBufferTask.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            FileUtils.a(paramBufferTask.jdField_a_of_type_JavaIoFile, localFile);
            paramBufferTask.jdField_a_of_type_JavaIoFile.delete();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFile = null;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, true);
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    PttBuffer.BufferTask localBufferTask = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localBufferTask == null) || (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      if (localBufferTask.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream.close();
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localBufferTask.jdField_a_of_type_JavaIoFile != null))
        {
          localBufferTask.jdField_a_of_type_JavaIoFile.delete();
          localBufferTask.jdField_a_of_type_JavaIoFile = null;
        }
        jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      PttBuffer.BufferTask localBufferTask = new PttBuffer.BufferTask();
      localBufferTask.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localBufferTask);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        paramString.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.size() < jdField_a_of_type_Int) {}
    }
    try
    {
      a(paramString, false);
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  public static boolean b(String paramString)
  {
    PttBuffer.BufferTask localBufferTask = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localBufferTask != null) && (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localBufferTask, true);
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      a(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */