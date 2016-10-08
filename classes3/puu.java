import android.graphics.Bitmap;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

public class puu
  extends VipUploadConfigImpl
{
  public puu(CardHandler paramCardHandler, long paramLong)
  {
    super(paramLong);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    paramUploadImageSize = VipUploadUtils.a(paramAbstractUploadTask.uploadFilePath);
    if (paramUploadImageSize != null)
    {
      paramAbstractUploadTask = new IUploadConfig.UploadImageSize(paramUploadImageSize.getWidth(), paramUploadImageSize.getHeight(), 100);
      paramUploadImageSize.recycle();
      return paramAbstractUploadTask;
    }
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\puu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */