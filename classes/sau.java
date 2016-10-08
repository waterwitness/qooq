import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class sau
  implements IWyFileSystem.IWyCallback
{
  public sau(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunFileInfo paramWeiYunFileInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Void paramVoid)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b, Boolean.valueOf(false) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b) + "]errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(false, 20, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b, Boolean.valueOf(false) });
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\sau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */