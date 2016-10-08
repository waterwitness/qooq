import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqn
  implements View.OnFocusChangeListener
{
  public lqn(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SearchActivity.a(this.a.a(), Leba.a(this.a), (SearchProtocol.WordItem)Leba.a(this.a).getTag());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */