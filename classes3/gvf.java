import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gvf
  implements View.OnTouchListener
{
  public gvf(MultiMembersVideoUI paramMultiMembersVideoUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */