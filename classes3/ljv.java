import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ljv
  extends FreshNewsManager.CUnpublishedFeedsListener
{
  public ljv(FreshNewsEditActivity paramFreshNewsEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FreshNewsEditActivity.a(), 2, "FreshNewsEditActivity  onUnpublishedFeedAdded info.feedId=" + paramFreshNewsInfo.feedId);
    }
    paramFreshNewsInfo.needDoAnim = true;
  }
  
  public void b(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FreshNewsEditActivity.a(), 2, "FreshNewsEditActivity  onFeedBecomesPublished info.feedId=" + paramFreshNewsInfo.feedId);
    }
    this.a.a(1, "新鲜事发布成功", 200);
    FreshNewsEditActivity.a(this.a);
  }
  
  public void c(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FreshNewsEditActivity.a(), 2, "FreshNewsEditActivity  onUnpublishedFeedStateChanged info.feedId=" + paramFreshNewsInfo.feedId);
    }
    if (paramFreshNewsInfo.publishState == 3) {
      this.a.a(1, "新鲜事发布失败", 200);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */