import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hzq
  extends Handler
{
  public hzq(SubscriptionInfoModule paramSubscriptionInfoModule, Looper paramLooper)
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
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */