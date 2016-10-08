import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqd
  implements View.OnTouchListener
{
  public yqd(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    if (i == 0) {}
    do
    {
      return false;
      if (i == 2)
      {
        if (f < RecordSVInteractActivity.a(this.a) * -1)
        {
          RecordSVInteractActivity.a(this.a, false, false);
          return true;
        }
        RecordSVInteractActivity.a(this.a, true, false);
        return true;
      }
      if (i == 3)
      {
        RecordSVInteractActivity.a(this.a, false, true);
        return false;
      }
    } while (i != 1);
    if (f < RecordSVInteractActivity.a(this.a) * -1)
    {
      RecordSVInteractActivity.a(this.a, false);
      RecordSVInteractActivity.a(this.a, false, true);
    }
    for (;;)
    {
      return false;
      RecordSVInteractActivity.a(this.a, true);
      RecordSVInteractActivity.a(this.a, true, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */