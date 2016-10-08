import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;

public class ulp
  implements View.OnClickListener
{
  public ulp(ContactSearchResultPresenter paramContactSearchResultPresenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ContactSearchResultPresenter.a(this.a).a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */