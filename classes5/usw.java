import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe.OnFrameAvailableListener;

public class usw
  extends Handler
{
  public usw(TextureDataPipe paramTextureDataPipe, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == -32361386)
    {
      if (TextureDataPipe.a(this.a) != null) {
        TextureDataPipe.a(this.a).a();
      }
    }
    else {
      return;
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */