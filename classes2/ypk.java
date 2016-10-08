import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class ypk
  implements View.OnTouchListener
{
  public ypk(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.a();
    if ((!this.a.b) && (this.a.a != null))
    {
      this.a.a.setHint("");
      this.a.b = true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */