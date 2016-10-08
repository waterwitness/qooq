import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mym
  implements View.OnTouchListener
{
  public mym(TroopTransferActivity paramTroopTransferActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.b();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */