import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ServerInfo;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class sce
  extends BroadcastReceiver
{
  public sce(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
          } while (paramContext == null);
          if (!paramContext.equals("com.dataline.mpfile.download_progress")) {
            break;
          }
        } while (paramIntent.getLongExtra("token_task_id", 0L) != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        l1 = paramIntent.getLongExtra("token_current_size", 0L);
        l2 = paramIntent.getLongExtra("token_total_size", 0L);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        this.a.k();
        if (l2 != 0L) {}
        for (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)l1 / (float)l2);; this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F)
        {
          BaseActionBarDataLineFile.f(this.a);
          BaseActionBarDataLineFile.a(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
          return;
        }
      } while (!paramContext.equals("com.dataline.mpfile.download_completed"));
      l1 = paramIntent.getLongExtra("token_task_id", 0L);
    } while (l1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    BaseActionBarDataLineFile.b(this.a, NetConnInfoCenter.getServerTimeMillis());
    long l2 = paramIntent.getLongExtra("token_current_size", 0L);
    boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
    int j = paramIntent.getIntExtra("token_http_code", 0);
    QLog.d(BaseActionBarDataLineFile.a(), 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
    paramContext = new ReportItem();
    paramContext.uSessionID = l1;
    paramContext.uChannelType = 6;
    paramContext.bSend = false;
    paramContext.uNotifyTime = BaseActionBarDataLineFile.b(this.a);
    paramContext.uFileSize = l2;
    paramContext.bFileExist = false;
    paramContext.uStartPos = 0L;
    paramContext.uTaskStart = BaseActionBarDataLineFile.b(this.a);
    paramContext.uTaskEnd = BaseActionBarDataLineFile.c(this.a);
    paramContext.uDuration = (BaseActionBarDataLineFile.c(this.a) - BaseActionBarDataLineFile.b(this.a));
    paramContext.bUserRetry = false;
    paramContext.sSuffix = "";
    int i;
    if (bool)
    {
      i = 2;
      paramContext.emResult = i;
      paramContext.nFailCode = 0;
      paramContext.nUserCode = j;
      paramIntent = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a();
      if (paramIntent == null) {
        break label713;
      }
      paramContext.dwServerIP = DBNetworkUtil.a(paramIntent.jdField_a_of_type_JavaLangString);
      paramContext.wServerPort = ((short)paramIntent.jdField_a_of_type_Int);
      label447:
      paramContext.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.b());
      paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin != 0L) {
        break label726;
      }
      i = QualityReportUtil.b;
      label489:
      QualityReportUtil.a(paramIntent, paramContext, i);
      this.a.j();
      if (bool) {
        break label821;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
        break label733;
      }
      FMToastUtil.a(2131362254);
      label555:
      QLog.d(BaseActionBarDataLineFile.a(), 2, "addRetryActionbar()");
      this.a.a();
      ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
      if (BaseActionBarDataLineFile.a(this.a)) {
        break label962;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = new String("needMPFileC2C");
      QLog.d(BaseActionBarDataLineFile.a(), 2, "mConnPCSuc:" + BaseActionBarDataLineFile.a(this.a) + ",create mEntity.mContext");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      return;
      if (BaseActionBarDataLineFile.b(this.a))
      {
        i = 32;
        break;
      }
      i = 41;
      break;
      label713:
      paramContext.dwServerIP = 0;
      paramContext.wServerPort = 0;
      break label447;
      label726:
      i = QualityReportUtil.d;
      break label489;
      label733:
      if (j == 1)
      {
        FMToastUtil.a(2131362259);
        break label555;
      }
      if (j == 1004)
      {
        FMToastUtil.a(2131362258);
        break label555;
      }
      if (j == 11)
      {
        QLog.d(BaseActionBarDataLineFile.a(), 2, "cancel file download!");
        break label555;
      }
      if (j == 12)
      {
        QLog.d(BaseActionBarDataLineFile.a(), 2, "cancel file predownload!");
        break label555;
      }
      BaseActionBarDataLineFile.a(this.a, j + 2100);
      break label555;
      label821:
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      paramContext = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().b();
      if (paramContext == null) {
        if (QLog.isColorLevel()) {
          QLog.d(BaseActionBarDataLineFile.a(), 2, "doDownload , plugin service not started");
        }
      }
      for (;;)
      {
        QLog.d(BaseActionBarDataLineFile.a(), 2, "addNomalActionbar()");
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
        break;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramContext, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName }));
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      }
      label962:
      QLog.d(BaseActionBarDataLineFile.a(), 2, "mConnPCSuc:" + BaseActionBarDataLineFile.a(this.a) + "mEntity.mContext = null");
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */