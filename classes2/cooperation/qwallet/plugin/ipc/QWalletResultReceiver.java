package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QWalletResultReceiver
  extends ResultReceiver
{
  private static Handler handler;
  private static QWalletResultReceiver instance;
  
  public QWalletResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void clear()
  {
    instance = null;
    handler = null;
  }
  
  public static QWalletResultReceiver getInstance()
  {
    if (instance == null)
    {
      if (Looper.myLooper() != null) {
        handler = new Handler(Looper.myLooper());
      }
      instance = new QWalletResultReceiver(handler);
    }
    return instance;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = BaseReq.getReq(paramBundle);
    if (paramBundle != null) {
      paramBundle.onReceive();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\QWalletResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */