import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.KandianPopupWindow;

public class xtw
  implements PopupWindow.OnDismissListener
{
  public xtw(KandianPopupWindow paramKandianPopupWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    KandianPopupWindow.a(this.a, null);
    KandianPopupWindow.a(this.a, 1.0F);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */