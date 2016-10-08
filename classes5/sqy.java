import appoint.define.appoint_define.FeedInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.FreshNewsPublisher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.os.MqqHandler;

public class sqy
  extends FreshNewsObserver
{
  public sqy(FreshNewsPublisher paramFreshNewsPublisher)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, appoint_define.FeedInfo paramFeedInfo)
  {
    FreshNewsPublisher.a(this.a).b(FreshNewsPublisher.a(this.a));
    if (paramBoolean)
    {
      FreshNewsPublisher.a(this.a).publishState = 1;
      FreshNewsPublisher.a(this.a).whichPage = 1;
      FreshNewsPublisher.a(this.a).feedId = paramFeedInfo.str_feed_id.get();
      FreshNewsPublisher.a(this.a).publishTime = paramFeedInfo.uint32_publish_time.get();
      FreshNewsPublisher.a(this.a).feedType = paramFeedInfo.uint64_feed_type.get();
      FreshNewsPublisher.a(this.a).e(FreshNewsPublisher.a(this.a));
      FreshNewsPublisher.a(this.a).c(FreshNewsPublisher.a(this.a));
    }
    for (;;)
    {
      ThreadManager.a().post(new sqz(this, paramBoolean));
      FreshNewsPublisher.a(this.a).c();
      return;
      FreshNewsPublisher.a(this.a).publishState = 3;
      FreshNewsPublisher.a(this.a).d(FreshNewsPublisher.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */