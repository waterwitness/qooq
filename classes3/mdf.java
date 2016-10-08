import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx;

public class mdf
  implements View.OnTouchListener
{
  public mdf(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQLSActivity.a(this.a).setCursorVisible(true);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */