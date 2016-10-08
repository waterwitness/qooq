import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uqc
  implements Runnable
{
  public uqc(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(PtvTemplateManager.a, 4, String.format("rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaIoFile);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */