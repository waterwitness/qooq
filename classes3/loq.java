import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class loq
  implements View.OnTouchListener
{
  public loq(HongbaoShowerActivity paramHongbaoShowerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\loq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */