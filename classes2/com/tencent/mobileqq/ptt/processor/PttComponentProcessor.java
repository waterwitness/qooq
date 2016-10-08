package com.tencent.mobileqq.ptt.processor;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QPipedInputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PttComponentProcessor
  extends InputStream
  implements IPttProcessor
{
  protected Context a;
  protected IPttProcessor.ProcessData a;
  protected PipedInputStream a;
  protected PipedOutputStream a;
  protected byte[] a;
  protected int b;
  protected byte[] b;
  protected byte[] c;
  protected byte[] d;
  
  public PttComponentProcessor(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = new byte[1];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return read(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  public IPttProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData.a = 0;
    int i = paramInt2;
    while (paramInt2 > 0)
    {
      if (paramInt2 > 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available()) {
        i = 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available();
      }
      a(paramArrayOfByte, paramInt1, i);
      paramInt1 += i;
      paramInt2 -= i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoPipedOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedOutputStream.close();
      this.jdField_a_of_type_JavaIoPipedOutputStream = null;
    }
    close();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream = new PipedOutputStream();
    if (Build.VERSION.SDK_INT <= 8)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream = new QPipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
      return;
    }
    this.jdField_a_of_type_JavaIoPipedInputStream = new PipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    while (this.jdField_a_of_type_JavaIoPipedInputStream.available() >= this.b)
    {
      paramInt1 = a(this.c, this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData.a);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData;
      paramArrayOfByte.a = (paramInt1 + paramArrayOfByte.a);
    }
  }
  
  public void close()
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream.close();
      this.jdField_a_of_type_JavaIoPipedInputStream = null;
    }
  }
  
  public int read()
  {
    if (read(this.d, 0, 1) == 1) {
      return this.d[0] & 0xFF;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\processor\PttComponentProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */