import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class mhq
  extends FriendListObserver
{
  public mhq(RecommendFriendActivity paramRecommendFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = RecommendFriendActivity.a(this.a).a();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        RecommendFriendActivity.a(this.a).a(localArrayList);
        RecommendFriendActivity.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    RecommendFriendActivity.a(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */