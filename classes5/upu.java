import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class upu
  implements Runnable
{
  public upu(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FileUtils.a(PtvTemplateManager.jdField_a_of_type_JavaIoFile.getPath() + File.separator, this.jdField_a_of_type_JavaLangString, this.b);
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "save Config to file finish.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */