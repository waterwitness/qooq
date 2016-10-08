import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PopupMenuDialog;

public class xuk
  implements View.OnClickListener
{
  public xuk(PopupMenuDialog paramPopupMenuDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */