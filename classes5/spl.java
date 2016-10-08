import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.FreshNewsDetailCommentItem;
import com.tencent.mobileqq.freshnews.FreshNewsStranger;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spl
  implements View.OnClickListener
{
  public spl(FreshNewsDetailCommentItem paramFreshNewsDetailCommentItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (FreshNewsStranger)paramView.getTag();
    if ((paramView != null) && (paramView.a > 0L)) {
      FreshNewsUtil.a(FreshNewsDetailCommentItem.a(this.a), paramView.a, null, 0, 0, 34);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */