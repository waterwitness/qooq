import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class yfy
  implements Runnable
{
  public yfy(DatalineRemoteManager paramDatalineRemoteManager, FileManagerEntity paramFileManagerEntity, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.getApplication().getApplicationContext(), FileBrowserActivity.class);
    localIntent.addFlags(268435456);
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 1))
    {
      if (!FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
        break label152;
      }
      localObject = new FileInfo();
      ((FileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
      ((FileInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
      ((FileInfo)localObject).e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      FMDataCache.a(localArrayList);
    }
    for (;;)
    {
      localIntent.putExtra("fileinfo", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo);
      this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.getApplication().getApplicationContext().startActivity(localIntent);
      return;
      label152:
      localObject = new ArrayList();
      ((ArrayList)localObject).add(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */