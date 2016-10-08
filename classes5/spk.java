import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.freshnews.FreshNewsDetailCommentItem;
import com.tencent.mobileqq.freshnews.FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spk
  implements View.OnLongClickListener
{
  public spk(FreshNewsDetailCommentItem paramFreshNewsDetailCommentItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (FreshNewsDetailCommentItem.a(this.a) != null) {
      FreshNewsDetailCommentItem.a(this.a).a(FreshNewsDetailCommentItem.a(this.a), FreshNewsDetailCommentItem.a(this.a));
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */