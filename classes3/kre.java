import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class kre
  implements View.OnClickListener
{
  public kre(BookShareAdviceEditActivity paramBookShareAdviceEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.c < 0)
    {
      QQToast.a(this.a, 1, this.a.getString(2131370609), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, 2131367256, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (this.a.a == null)
    {
      QQToast.a(this.a, 2131370615, 0).b(this.a.getTitleBarHeight());
      return;
    }
    BookShareAdviceEditActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */