import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jxi
  extends Handler
{
  public jxi(DeviceFileHandler paramDeviceFileHandler, Looper paramLooper)
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
    }
    this.a.a(103, true, paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */