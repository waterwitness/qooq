import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TCTransitDrawable;

public class wop
  extends Handler
{
  public wop(TCTransitDrawable paramTCTransitDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.a.jdField_a_of_type_Boolean) && (!this.a.b) && (this.a.c)) {}
    }
    while (paramMessage.what != 2)
    {
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        int i = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        int j = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        int k = this.a.f;
        int m = this.a.g;
        this.a.f = i;
        this.a.g = j;
        paramMessage = this.a;
        paramMessage.d += i - k;
        paramMessage = this.a;
        paramMessage.e += j - m;
        this.a.invalidateSelf();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 50L);
        return;
      }
      this.a.d();
      return;
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */