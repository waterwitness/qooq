import android.os.Handler;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class srg
  extends FreshNewsManager.CUnpublishedFeedsListener
{
  public srg(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((MyFreshNewsFragment.a(this.a)) && (!MyFreshNewsFragment.a(this.a).hasMessages(0))) {
      this.a.a(0L);
    }
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshNewsFragment  onUnpublishedFeedAdded info.feedId=" + paramFreshNewsInfo.feedId);
    }
    if (MyFreshNewsFragment.a(this.a)) {
      this.a.a(0L);
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshNewsFragment onUnpublishedFeedStateChanged");
    }
    if (MyFreshNewsFragment.a(this.a)) {
      this.a.a(0L);
    }
  }
  
  public void a(boolean paramBoolean, FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshNewsFragment onFailedFeedDeleted.isSuccess = " + paramBoolean);
    }
    if (MyFreshNewsFragment.a(this.a) != null) {
      MyFreshNewsFragment.a(this.a).e();
    }
    if (!paramBoolean) {
      this.a.a(1, "删除失败", 0L);
    }
    while ((MyFreshNewsFragment.a(this.a) == null) || (paramFreshNewsInfo == null)) {
      return;
    }
    MyFreshNewsFragment.a(this.a).a(paramFreshNewsInfo.feedId);
  }
  
  public void b(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshNewsFragment  onFeedBecomesPublished info.feedId=" + paramFreshNewsInfo.feedId);
    }
    if (MyFreshNewsFragment.a(this.a)) {
      this.a.a(0L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */