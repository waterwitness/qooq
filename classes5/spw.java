import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spw
  implements View.OnClickListener
{
  public spw(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */