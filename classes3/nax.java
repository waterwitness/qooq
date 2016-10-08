import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nax
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nax(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int[] arrayOfInt = new int[2];
    this.a.a.getLocationOnScreen(arrayOfInt);
    this.a.v = arrayOfInt[1];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */