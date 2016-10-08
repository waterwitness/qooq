import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ppb
  extends FriendListObserver
{
  public ppb(RecommendFriendAdapter paramRecommendFriendAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onStatesChanged ");
    }
    RecommendFriendAdapter.a(this.a, RecommendFriendAdapter.a(this.a).a());
    this.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ppb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */