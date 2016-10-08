import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class rxa
  implements Runnable
{
  public rxa(FileManagerRSWorker paramFileManagerRSWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.a.c) + "]," + " actionType[" + String.valueOf(this.a.jdField_b_of_type_Int) + "], " + "strUin[" + this.a.e == null) {
        break label347;
      }
      localObject = FileManagerUtil.e(this.a.e);
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      if (NetworkUtil.e(BaseApplicationImpl.getContext())) {
        break;
      }
      this.a.a(0);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.a.d, "", "", FileManagerRSWorker.a(this.a), "NoNetWork", null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.j, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.a.d, "", "", FileManagerRSWorker.b(this.a), "NoNetWork", null);
      return;
      label347:
      if ("null], filePath[" + this.a.jdField_b_of_type_JavaLangString != null) {
        localObject = this.a.jdField_b_of_type_JavaLangString;
      } else {
        localObject = "null], uniseq[" + String.valueOf(this.a.jdField_b_of_type_Long) + "]";
      }
    }
    this.a.jdField_g_of_type_Long = System.currentTimeMillis();
    this.a.jdField_i_of_type_Long = 0L;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    switch (this.a.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      return;
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file_number";
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      this.a.b();
      continue;
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_number";
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      this.a.a();
      continue;
      this.a.h();
      continue;
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */