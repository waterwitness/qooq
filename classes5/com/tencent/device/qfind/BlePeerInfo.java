package com.tencent.device.qfind;

import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class BlePeerInfo
{
  public static final String a = "0000feba-0000-1000-8000-00805f9b34fb";
  private static int g = 1000000000;
  public int a;
  public long a;
  public SosoInterface.SosoLbsInfo a;
  public List a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public byte[] b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BlePeerInfo()
  {
    g += 1;
    this.jdField_c_of_type_Int = g;
  }
  
  public static void a(byte[] paramArrayOfByte, BlePeerInfo paramBlePeerInfo)
  {
    try
    {
      paramBlePeerInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      int j;
      int i;
      if (paramArrayOfByte.remaining() > 2)
      {
        j = paramArrayOfByte.get();
        if (j == 0) {
          return;
        }
        i = j;
        switch (paramArrayOfByte.get())
        {
        }
      }
      for (;;)
      {
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        while (i >= 2)
        {
          paramBlePeerInfo.jdField_a_of_type_JavaUtilList.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
          i = (byte)(i - 2);
        }
        if (j > 10)
        {
          if (j > 11) {
            paramArrayOfByte.get(new byte[j - 1 - 10]);
          }
          paramBlePeerInfo.jdField_a_of_type_Int = paramArrayOfByte.getInt();
          paramBlePeerInfo.jdField_a_of_type_ArrayOfByte = new byte[6];
          paramArrayOfByte.get(paramBlePeerInfo.jdField_a_of_type_ArrayOfByte);
          break;
        }
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        if (j > 2)
        {
          try
          {
            if (paramArrayOfByte.getShort() != 513) {
              break;
            }
            paramBlePeerInfo.f = paramArrayOfByte.getShort();
            paramBlePeerInfo.e = paramArrayOfByte.getShort();
          }
          catch (Exception localException) {}
          break;
        }
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte) {}
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString.replaceAll(":", "") + "0000";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\qfind\BlePeerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */