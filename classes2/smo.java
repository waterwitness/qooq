import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class smo
  extends FreshNewsManager.CUnpublishedFeedsListener
{
  public smo(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  onCacheReady");
    }
    this.a.a(null, false);
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  onUnpublishedFeedAdded info.feedId=" + paramFreshNewsInfo.feedId);
    }
    if (!this.a.c) {
      if (this.a.a != null) {
        this.a.a.a = paramFreshNewsInfo;
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.a = paramFreshNewsInfo;
    this.a.a.d();
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  onUnpublishedFeedStateChanged infos.size=" + paramList.size());
    }
  }
  
  public void a(boolean paramBoolean, FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  onFailedFeedDeleted");
    }
    if (this.a.a != null) {
      this.a.a.e();
    }
    if (!this.a.c) {}
    do
    {
      return;
      if (!paramBoolean)
      {
        this.a.a(1, "删除失败", 0L);
        return;
      }
    } while ((this.a.a == null) || (paramFreshNewsInfo == null));
    this.a.a.a(paramFreshNewsInfo.feedId);
  }
  
  public void b(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  onFeedBecomesPublished info.feedId=" + paramFreshNewsInfo.feedId);
    }
    this.a.a(2000L);
  }
  
  public void c(FreshNewsInfo paramFreshNewsInfo)
  {
    this.a.a.a(paramFreshNewsInfo);
    this.a.a(2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */