package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;

public class RecordManager
{
  public static RecordManager a;
  public static String a;
  private TCTimer a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceRecordManager = new RecordManager();
  }
  
  private RecordManager()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static RecordManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceRecordManager;
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
  
  public TCTimer a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer = new TCTimer(40, CodecParam.d);
    }
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer;
  }
  
  public ErrorCenter a()
  {
    return ErrorCenter.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonTCTimer = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\RecordManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */