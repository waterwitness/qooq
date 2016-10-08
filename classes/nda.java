import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class nda
  extends TransProcessorHandler
{
  public nda(FileTransferManager paramFileTransferManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */