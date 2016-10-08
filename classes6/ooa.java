import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ooa
  implements Runnable
{
  public ooa(BindNumberActivity paramBindNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.a.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.a.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.a.a.setSelection(this.a.a.getText().toString().length());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ooa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */