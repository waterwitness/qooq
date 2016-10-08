import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spc
  implements View.OnTouchListener
{
  public spc(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.f();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */