import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;

public class wqt
  extends Handler
{
  public wqt(CardContainer paramCardContainer, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.b.setImageDrawable(this.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */