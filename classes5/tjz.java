import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.IInterestTagItemViewCallback;

public class tjz
  implements View.OnClickListener
{
  public tjz(InterestTagItemView paramInterestTagItemView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).a(InterestTagItemView.a(this.a));
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */