import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow;
import com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback;

public class tka
  implements View.OnClickListener
{
  public tka(ShowTagNamePopupWindow paramShowTagNamePopupWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (ShowTagNamePopupWindow.a(this.a) != null) {
      ShowTagNamePopupWindow.a(this.a).a(ShowTagNamePopupWindow.a(this.a));
    }
    this.a.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */