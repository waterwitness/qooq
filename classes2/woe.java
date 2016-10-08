import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.RotateableView;

public class woe
  extends Handler
{
  public woe(RotateableView paramRotateableView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    RotateableView.a(this.a, 8.0F);
    if (RotateableView.a(this.a) >= 360.0F) {
      RotateableView.b(this.a, 360.0F);
    }
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */