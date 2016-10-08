import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.util.ArrayList;

public class put
  implements IUploadTaskCallback
{
  public put(CardHandler paramCardHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qzonephotowall", 2, "onUploadError " + paramString + " path:" + paramAbstractUploadTask.uploadFilePath);
    }
    this.a.a(71, false, new Object[] { paramAbstractUploadTask.uploadFilePath });
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2)
    {
      this.a.n = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "onUploadProgress is 100%");
      }
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt) {}
  
  public void onUploadSucceed(AbstractUploadTask arg1, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "onUploadSucceed ");
    }
    synchronized (CardHandler.a(this.a))
    {
      if (CardHandler.a(this.a).size() != 0)
      {
        CardHandler.a(this.a);
        return;
      }
      this.a.a(71, true, new Object[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\put.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */