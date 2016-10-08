import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;

public class tvs
  implements IUploadTaskCallback
{
  public tvs(VipBaseUploadTask paramVipBaseUploadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.a.n = 1002;
    this.a.i = paramInt;
    this.a.h = paramString;
    this.a.a(1002, new Object[0]);
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (this.a.n != paramInt)
    {
      this.a.n = paramInt;
      this.a.a(this.a.n, new Object[0]);
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    this.a.n = 1001;
    this.a.a = paramObject;
    this.a.a(1001, new Object[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */