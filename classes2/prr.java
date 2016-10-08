import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class prr
  implements View.OnClickListener
{
  public prr(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */