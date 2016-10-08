import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class tzu
  implements View.OnTouchListener
{
  public tzu(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      QCallDetailActivity.a(this.a).setPressed(true);
    }
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    QCallDetailActivity.a(this.a).setPressed(false);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */