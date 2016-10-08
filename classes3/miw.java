import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class miw
  implements View.OnLongClickListener
{
  public miw(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131305407, this.a.getString(2131369291));
    BubbleContextMenu.a(RegisterQQNumberActivity.a(this.a), paramView, new mix(this), new miy(this));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\miw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */