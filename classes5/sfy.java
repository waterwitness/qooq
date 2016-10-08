import android.os.Handler;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.Map;

public class sfy
  implements Runnable
{
  public sfy(OfflineVideoFileView paramOfflineVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "群文件debug提示：tbs播放组件没有准备好!请将tbs.apk拷贝到SD卡tbs/com.tencent.mobileqq/目录下,再进入webView下载tbs组件");
      }
    }
    FileManagerEntity localFileManagerEntity1 = OfflineVideoFileView.d(this.a).a();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = localFileManagerEntity1;
    if (localFileManagerEntity1 == null) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
    }
    for (;;)
    {
      return;
      TroopFileTransferManager localTroopFileTransferManager;
      try
      {
        localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a.get(Long.valueOf(localFileManagerEntity1.TroopUin));
        if (localTroopFileTransferManager == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineVideoFileView", 4, "bad troopUin" + localFileManagerEntity1.TroopUin);
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
          return;
        }
      }
      finally {}
      if (localFileManagerEntity2.isZipInnerFile) {
        TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app, localFileManagerEntity2.TroopUin, localFileManagerEntity2.zipFilePath, localFileManagerEntity2.busId, new sfz(this, localFileManagerEntity2));
      }
      while ((!this.a.a(localFileManagerEntity2)) && (QLog.isColorLevel()))
      {
        QLog.d("zivonchen", 2, "requestWhitelist 群的本地信息为空!!!!");
        return;
        localTroopFileTransferManager.a(localFileManagerEntity2.strTroopFilePath, localFileManagerEntity2.fileName, localFileManagerEntity2.fileSize, localFileManagerEntity2.busId, this.a.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */