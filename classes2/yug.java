import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public final class yug
  implements IWyFileSystem.IWyCallback
{
  public yug()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "succeed to report album status, redPoint = " + paramBoolean);
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "fail to report album status, errorCode = " + paramWyErrorStatus.errorCode + ", errorMsg = " + paramWyErrorStatus.errorMsg);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */