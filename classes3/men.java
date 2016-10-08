import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;

public class men
  implements PopupWindow.OnDismissListener
{
  public men(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if (this.a.s != null)
    {
      QQMapActivity.a(this.a);
      this.a.C = 0;
      this.a.a.a(this.a.getString(2131364913));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\men.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */