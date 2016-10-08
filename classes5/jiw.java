import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.widgets.ActiveSearchTipsContainer;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jiw
  extends Handler
{
  public jiw(ActiveSearchTipsContainer paramActiveSearchTipsContainer, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a != null)
    {
      if (paramMessage.obj != null) {
        this.a.a.a((String)paramMessage.obj);
      }
    }
    else {
      return;
    }
    this.a.a.a(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */