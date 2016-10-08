import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecommendAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oyi
  implements View.OnClickListener
{
  public oyi(RecommendAdapter paramRecommendAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (RecommendAdapter.a(this.a) != null) {
      RecommendAdapter.a(this.a).a(paramView, str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */