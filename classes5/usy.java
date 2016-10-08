import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConverterImpl;
import java.io.File;

public class usy
  implements VideoConverter.VideoConverterImpl
{
  static final int jdField_a_of_type_Int = 262144;
  static final String jdField_a_of_type_JavaLangString = "JBMR2VideoConverterImpl";
  static final boolean jdField_a_of_type_Boolean = false;
  static final int jdField_b_of_type_Int = 2130708361;
  static final String jdField_b_of_type_JavaLangString = "video/avc";
  boolean jdField_b_of_type_Boolean;
  boolean c;
  
  public usy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
    this.c = false;
  }
  
  public boolean a()
  {
    if ((this.b) && (!this.c))
    {
      this.c = true;
      return true;
    }
    return false;
  }
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (!this.b)
    {
      this.b = true;
      paramFile = new Thread(new usz(this, paramFile, paramProcessor), "VideoConvert");
      paramFile.start();
      if (paramBoolean) {}
      try
      {
        paramFile.join();
        return true;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */