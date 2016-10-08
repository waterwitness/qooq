import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.now.NowVideoController;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hkh
  extends Handler
{
  public hkh(NowVideoController paramNowVideoController, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a = true;
      NowVideoController.a(this.a);
      return;
    }
    QQLiveImage.pauseAll();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */