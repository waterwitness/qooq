import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache;

public class vol
  extends Handler
{
  public vol(RollangleImageView.ImageCache paramImageCache, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a) {}
    Object localObject;
    String str;
    do
    {
      return;
      localObject = (Object[])paramMessage.obj;
      paramMessage = (RollangleImageView)localObject[0];
      str = (String)localObject[1];
      localObject = (Bitmap)localObject[2];
    } while ((paramMessage == null) || (str == null) || (localObject == null) || (!str.equals(paramMessage.b)));
    paramMessage.setImageBitmap((Bitmap)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */