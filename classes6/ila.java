import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker;
import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler.GetPreloadVideoEvent;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ila
  extends UIBaseEventReceiver
{
  public ila(QQStoryDiscoverActivity paramQQStoryDiscoverActivity1, QQStoryDiscoverActivity paramQQStoryDiscoverActivity2)
  {
    super(paramQQStoryDiscoverActivity2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQStoryDiscoverActivity paramQQStoryDiscoverActivity, GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    if (paramGetPreloadVideoEvent.a != 3) {
      return;
    }
    PGCUrlChecker.a(paramGetPreloadVideoEvent.b, new ilb(this));
  }
  
  public Class acceptEventClass()
  {
    return GetPreloadVideoHandler.GetPreloadVideoEvent.class;
  }
  
  public void b(QQStoryDiscoverActivity paramQQStoryDiscoverActivity, GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ila.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */