import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FetchInfoListManager;
import java.util.LinkedList;

public class vyi
  extends Handler
{
  public vyi(FetchInfoListManager paramFetchInfoListManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      FetchInfoListManager.a(this.a);
    }
    while ((paramMessage.what != 2) || (FetchInfoListManager.a(this.a) == null)) {
      return;
    }
    FetchInfoListManager.a(this.a).remove(paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */