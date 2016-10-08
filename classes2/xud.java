import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.MovingView;

public class xud
  extends Handler
{
  public xud(MovingView paramMovingView, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.a.b) && (!this.a.jdField_c_of_type_Boolean)) {}
    }
    while (paramMessage.what != 2)
    {
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        int i = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        int j = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        int k = this.a.e;
        int m = this.a.f;
        this.a.e = i;
        this.a.f = j;
        paramMessage = this.a;
        paramMessage.jdField_c_of_type_Int += i - k;
        paramMessage = this.a;
        paramMessage.d += j - m;
        this.a.invalidate();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 40L);
        return;
      }
      this.a.a();
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */