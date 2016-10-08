package com.tencent.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

@SuppressLint({"NewApi"})
public class FileEncryptUtils
{
  public static final byte[] ENCRYPE_HEAD = { 69, 78, 67, 82 };
  public static final int ENCRYPT_SIZE = 1024;
  
  public static void decryptFile(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new FileOutputStream(new File(paramString2));
      paramString2.write(decryptFile(paramString1));
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static byte[] decryptFile(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = new byte[4];
      paramInputStream.read((byte[])localObject1);
      if ((localObject1[0] == ENCRYPE_HEAD[0]) && (localObject1[1] == ENCRYPE_HEAD[1]) && (localObject1[2] == ENCRYPE_HEAD[2]) && (localObject1[3] == ENCRYPE_HEAD[3]))
      {
        localObject1 = new ByteArrayOutputStream(readInt(paramInputStream));
        int i = readInt(paramInputStream);
        localObject2 = new byte[i];
        paramInputStream.read((byte[])localObject2, 0, i);
        localObject2 = EncryptUtils.decode((byte[])localObject2);
        ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
        IOUtils.copy(paramInputStream, (OutputStream)localObject1);
        return ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject2 = new ByteArrayOutputStream();
      ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
      IOUtils.copy(paramInputStream, (OutputStream)localObject2);
      paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static byte[] decryptFile(String paramString)
  {
    try
    {
      paramString = new DataInputStream(new FileInputStream(new File(paramString)));
      byte[] arrayOfByte = decryptFile(paramString);
      paramString.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void encryptAllFile(String paramString1, String paramString2)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString1));
      paramString1 = IOUtils.toByteArray(localFileInputStream);
      localFileInputStream.close();
      paramString2 = new DataOutputStream(new FileOutputStream(new File(paramString2)));
      paramString2.write(ENCRYPE_HEAD);
      writeInt(paramString2, paramString1.length);
      paramString1 = EncryptUtils.encode(paramString1);
      writeInt(paramString2, paramString1.length);
      paramString2.write(paramString1);
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void encryptFile(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new FileInputStream(new File(paramString1));
      paramString1 = IOUtils.toByteArray((InputStream)localObject);
      ((FileInputStream)localObject).close();
      paramString2 = new DataOutputStream(new FileOutputStream(new File(paramString2)));
      paramString2.write(ENCRYPE_HEAD);
      if (paramString1.length > 1024)
      {
        writeInt(paramString2, paramString1.length);
        localObject = EncryptUtils.encode(Arrays.copyOfRange(paramString1, 0, 1024));
        writeInt(paramString2, localObject.length);
        paramString2.write((byte[])localObject);
        paramString2.write(paramString1, 1024, paramString1.length - 1024);
      }
      for (;;)
      {
        paramString2.close();
        return;
        writeInt(paramString2, paramString1.length);
        paramString1 = EncryptUtils.encode(paramString1);
        writeInt(paramString2, paramString1.length);
        paramString2.write(paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  static int readInt(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + (m << 0);
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\util\FileEncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */