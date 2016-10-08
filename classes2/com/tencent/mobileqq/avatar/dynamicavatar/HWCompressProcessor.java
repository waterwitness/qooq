package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class HWCompressProcessor
  implements VideoConverter.Processor
{
  static final int jdField_a_of_type_Int = 51200;
  static final int jdField_b_of_type_Int = 460800;
  private static final String jdField_b_of_type_JavaLangString;
  static final int c = 18;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int d;
  final int e;
  final int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = HWCompressProcessor.class.getSimpleName();
  }
  
  HWCompressProcessor(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt1;
    this.f = paramInt3;
    if (paramInt2 > 0) {}
    for (this.e = paramInt2;; this.e = 18)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    int i = 18;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = localFile;
      localVideoConvertConfig.jdField_a_of_type_Float = (this.f / paramInt2);
      localVideoConvertConfig.jdField_a_of_type_Int = ((int)(this.d * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float + 0.5F));
      if (localVideoConvertConfig.jdField_a_of_type_Int <= 460800) {
        break label172;
      }
      localVideoConvertConfig.jdField_a_of_type_Int = 460800;
    }
    for (;;)
    {
      paramInt1 = i;
      if (this.e <= 18) {
        paramInt1 = this.e;
      }
      localVideoConvertConfig.b = paramInt1;
      localVideoConvertConfig.jdField_a_of_type_Boolean = a();
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_a_of_type_Boolean);
      }
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      label172:
      if (localVideoConvertConfig.jdField_a_of_type_Int < 51200) {
        localVideoConvertConfig.jdField_a_of_type_Int = 51200;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e(b, 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\HWCompressProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */