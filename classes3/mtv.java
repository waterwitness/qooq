import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mtv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mtv(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.a.h.getViewTreeObserver().removeGlobalOnLayoutListener(this.a.a);
    this.a.v();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */