import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class sas
  implements IWyFileSystem.IWyCallback
{
  public sas(WeiYunLogicCenter paramWeiYunLogicCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(IWyFileSystem.Thumbnail paramThumbnail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb onSucceed.");
    }
    this.a.a.a().a(true, 39, new Object[] { paramThumbnail });
    FileManagerEntity localFileManagerEntity;
    if ((paramThumbnail.context instanceof FileManagerEntity))
    {
      localFileManagerEntity = (FileManagerEntity)paramThumbnail.context;
      if ((paramThumbnail.filePath != null) && (paramThumbnail.filePath.length() >= 1)) {}
    }
    else
    {
      return;
    }
    if (paramThumbnail.filePath.contains("qlarge")) {
      localFileManagerEntity.strMiddleThumPath = paramThumbnail.filePath;
    }
    for (;;)
    {
      this.a.a.a().c(localFileManagerEntity);
      return;
      if (paramThumbnail.filePath.contains("qxlarge")) {
        localFileManagerEntity.strLargeThumPath = paramThumbnail.filePath;
      } else {
        localFileManagerEntity.strThumbPath = paramThumbnail.filePath;
      }
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\sas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */