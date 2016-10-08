package com.tencent.mobileqq.ptt.processor;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.mobileqq.utils.PTTAgcWrapper;
import java.io.PipedInputStream;

public class PttAgcAndNsProcessor
  extends PttComponentProcessor
{
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
  private PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper;
  
  public PttAgcAndNsProcessor(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = PTTAgcWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(paramInt1);
    }
    this.b = NoiseSuppression.f;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.b];
    this.c = new byte['ހ'];
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData = new IPttProcessor.ProcessData(this.c, 0);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.b) == -1) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper.a(this.jdField_a_of_type_ArrayOfByte, 0, this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(this.jdField_a_of_type_ArrayOfByte, 0, this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper.b(this.jdField_a_of_type_ArrayOfByte, 0, this.b);
    }
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.b);
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\processor\PttAgcAndNsProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */