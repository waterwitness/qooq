import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ofu
  extends DownloadListener
{
  public ofu(BlessManager paramBlessManager, String paramString1, String paramString2)
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
        QLog.d(BlessManager.jdField_a_of_type_JavaLangString, 2, "download finished " + this.b);
      }
      if ((this.b != null) && (BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager) != null) && (this.b.equals(BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).starVideo))) {
        BlessManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      return;
    }
    QLog.d(BlessManager.jdField_a_of_type_JavaLangString, 2, "downloadFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.z);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */