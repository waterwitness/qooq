import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class oft
  extends DownloadListener
{
  public oft(BlessManager paramBlessManager, String paramString, BlessPtvModule paramBlessPtvModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d(BlessManager.jdField_a_of_type_JavaLangString, 2, "download finished " + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.id);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.broken = false;
        BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(BlessManager.jdField_a_of_type_JavaLangString, 2, "downloadZipFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.z);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */