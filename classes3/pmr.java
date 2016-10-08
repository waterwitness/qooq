import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pmr
  extends Handler
{
  pmr(pmq parampmq, Looper paramLooper)
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
    VipSpecialCareHandler.a(this.a.a, "-->request timeout");
    VipSpecialCareHandler.a(this.a.a, -2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */