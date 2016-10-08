import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class rxl
  implements Runnable
{
  public rxl(OfflineSendWorker paramOfflineSendWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineFileUploader<FileAssistant>", 2, "OfflineSendWorker run task sessionid[" + OfflineSendWorker.a(this.a).nSessionId + "]," + "filePath[" + OfflineSendWorker.a(this.a).getFilePath() + "]");
    }
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      OfflineSendWorker.a(this.a, 0);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 2, null);
      OfflineSendWorker.a(this.a, 0L, 9004, "NoNetWork");
      OfflineSendWorker.b(this.a, 0L, 9004, "NoNetWork");
      return;
    }
    OfflineSendWorker.a(this.a, System.currentTimeMillis());
    OfflineSendWorker.a(this.a).status = 2;
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    localfileAssistantReportData.b = "send_file_number";
    FileManagerReporter.a(OfflineSendWorker.a(this.a).a(), localfileAssistantReportData);
    OfflineSendWorker.a(this.a);
    OfflineSendWorker.a(this.a).a().a(true, 3, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */