import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView;

public class woq
  extends Handler
{
  public woq(TabBarView paramTabBarView)
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
      TabBarView.a(this.a, 0.0F);
      TabBarView.a(this.a, 0.1D);
      this.a.invalidate();
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      if (TabBarView.a(this.a) < 1.0F)
      {
        TabBarView.a(this.a, 0.1D);
        this.a.invalidate();
        sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(2), 10L);
      return;
    }
    TabBarView.a(this.a, TabBarView.a(this.a));
    TabBarView.a(this.a, TabBarView.b(this.a), TabBarView.a(this.a));
    TabBarView.a(this.a, 1.0F);
    TabBarView.b(this.a, TabBarView.b(this.a), TabBarView.a(this.a));
    TabBarView.a(this.a, TabBarView.a(this.a));
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */