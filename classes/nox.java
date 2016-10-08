import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class nox
  implements VideoConverter.Processor
{
  static final int jdField_a_of_type_Int = 393216;
  static final int b = 786432;
  static final int c = 30;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int d;
  final int e;
  
  nox(nou paramnou, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt1;
    if (paramInt2 > 0) {}
    for (this.e = paramInt2;; this.e = 30)
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
    int i = 30;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = localFile;
      localVideoConvertConfig.jdField_a_of_type_Float = (640.0F / paramInt2);
      localVideoConvertConfig.jdField_a_of_type_Int = ((int)(this.d * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float + 0.5F));
      if (localVideoConvertConfig.jdField_a_of_type_Int <= 786432) {
        break label168;
      }
      localVideoConvertConfig.jdField_a_of_type_Int = 786432;
    }
    for (;;)
    {
      paramInt1 = i;
      if (this.e <= 30) {
        paramInt1 = this.e;
      }
      localVideoConvertConfig.b = paramInt1;
      localVideoConvertConfig.jdField_a_of_type_Boolean = a();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_a_of_type_Boolean);
      }
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      label168:
      if (localVideoConvertConfig.jdField_a_of_type_Int < 393216) {
        localVideoConvertConfig.jdField_a_of_type_Int = 393216;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onFailed");
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


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */