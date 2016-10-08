import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;

public class ukk
  implements View.OnTouchListener
{
  public ukk(ContactSearchComponentActivity paramContactSearchComponentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (TextUtils.isEmpty(this.a.d)))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */