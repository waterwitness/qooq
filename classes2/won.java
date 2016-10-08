import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideTabWidget;

public class won
  extends Handler
{
  public won(SlideTabWidget paramSlideTabWidget)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      SlideTabWidget.a(this.a, 0.0F);
      SlideTabWidget.a(this.a, 0.1D);
      this.a.invalidate();
      sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      if (SlideTabWidget.a(this.a) < 1.0F)
      {
        SlideTabWidget.a(this.a, 0.1D);
        if (SlideTabWidget.a(this.a) >= 1.0F) {
          SlideTabWidget.a(this.a, false);
        }
        this.a.invalidate();
        sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(SlideTabWidget.a(this.a).obtainMessage(2), 10L);
      return;
    }
    SlideTabWidget.a(this.a, 1.0F);
    SlideTabWidget.a(this.a, SlideTabWidget.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\won.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */