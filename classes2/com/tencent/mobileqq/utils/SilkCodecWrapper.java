package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttSoLoader;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.PttComponentProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.PipedInputStream;

public final class SilkCodecWrapper
  extends PttComponentProcessor
{
  private static final String jdField_a_of_type_JavaLangString = "SilkCodecWrapper";
  private static boolean jdField_b_of_type_Boolean;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  int c;
  int d;
  private int e;
  
  public SilkCodecWrapper(Context paramContext)
  {
    super(paramContext);
    a(true);
  }
  
  public SilkCodecWrapper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramBoolean);
  }
  
  public static void a(Context paramContext)
  {
    if ((!jdField_b_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "codecsilk"))) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!jdField_b_of_type_Boolean)
    {
      PttSoLoader.a(this.jdField_a_of_type_AndroidContentContext, "codecsilk");
      jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = 0L;
    this.d = 0;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public native int SilkDecoderNew(int paramInt1, int paramInt2);
  
  public native int SilkEncoderNew(int paramInt1, int paramInt2);
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    if (this.jdField_c_of_type_Int == 0) {
      return 0;
    }
    try
    {
      paramInt1 = decode(this.jdField_c_of_type_Int, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
      l = SystemClock.uptimeMillis() - l;
      this.jdField_a_of_type_Long += l;
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
      this.d += 1;
      return paramInt1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return 0;
  }
  
  public IPttProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l = SystemClock.uptimeMillis() - l;
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    this.jdField_a_of_type_Long = (l + this.jdField_a_of_type_Long);
    this.d += 1;
    return paramArrayOfByte;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    try
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (this.jdField_c_of_type_Int = SilkEncoderNew(paramInt1, paramInt2);; this.jdField_c_of_type_Int = SilkDecoderNew(paramInt1, paramInt2))
      {
        this.jdField_b_of_type_Int = RecordParams.a(paramInt1);
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_Int];
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_Int];
        this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_Int];
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData = new IPttProcessor.ProcessData(this.jdField_c_of_type_ArrayOfByte, 0);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "init silk codec =" + localException.toString());
        }
        this.jdField_c_of_type_Int = 0;
        jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Int != 0) {
      deleteCodec(this.jdField_c_of_type_Int);
    }
    this.jdField_c_of_type_Int = 0;
    if ((this.jdField_a_of_type_Long > 0L) && (this.d > 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        PttInfoCollector.a(this.jdField_a_of_type_Long, this.d, this.jdField_b_of_type_Long, 0);
      }
    }
    else {
      return;
    }
    PttInfoCollector.a(this.jdField_a_of_type_Long, this.d, this.jdField_b_of_type_Long, 1);
  }
  
  public void close()
  {
    super.close();
    b();
  }
  
  public native int decode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);
  
  public native void deleteCodec(int paramInt);
  
  public native int encode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  
  protected void finalize()
  {
    if (this.jdField_c_of_type_Int != 0) {}
    try
    {
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int == 0) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_b_of_type_Int) == -1) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.e = encode(this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int);
    }
    RecordParams.a(this.e, paramArrayOfByte, paramInt1);
    System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1 + 2, this.e);
    return this.e + 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SilkCodecWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */