import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gdt
  implements View.OnTouchListener
{
  public gdt(EditMemberActivity paramEditMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.c();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */