package com.tencent.mobileqq.activity.shortvideo;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoPreviewActivity$HWCompressProcessor
  implements VideoConverter.Processor
{
  static final int jdField_a_of_type_Int = 30;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  final int c;
  
  public ShortVideoPreviewActivity$HWCompressProcessor(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.c = paramInt2;; this.c = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString == null) {}
      return;
    }
  }
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    int i = 30;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = localFile;
      if (paramInt2 >= 640) {
        break label233;
      }
    }
    label233:
    for (localVideoConvertConfig.jdField_a_of_type_Int = ((int)(524288 * 1.0D / 'ʀ' * paramInt2));; localVideoConvertConfig.jdField_a_of_type_Int = 524288)
    {
      localVideoConvertConfig.jdField_a_of_type_Float = ('ʀ' / paramInt2);
      paramInt1 = i;
      if (this.c <= 30) {
        paramInt1 = this.c;
      }
      localVideoConvertConfig.jdField_b_of_type_Int = paramInt1;
      localVideoConvertConfig.jdField_a_of_type_Boolean = a();
      localVideoConvertConfig.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localVideoConvertConfig.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_a_of_type_Boolean + ", scaleRate=" + localVideoConvertConfig.jdField_a_of_type_Float + ", videoBitRate=" + localVideoConvertConfig.jdField_a_of_type_Int + ", videoFrameRate=" + localVideoConvertConfig.jdField_b_of_type_Int + ", beginTime=" + localVideoConvertConfig.jdField_a_of_type_Long + ", endTime=" + localVideoConvertConfig.jdField_b_of_type_Long);
      }
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\ShortVideoPreviewActivity$HWCompressProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */