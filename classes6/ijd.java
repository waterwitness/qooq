import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class ijd
  extends QQUIEventReceiver
{
  public ijd(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    super(paramDefaultPlayerVideoListSynchronizer);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer, DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    Iterator localIterator = paramDefaultPlayerVideoListSynchronizer.a.iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (paramDeleteStoryVideoEvent.a.equals(localStoryVideoItem.mVid))
        {
          paramDefaultPlayerVideoListSynchronizer.a.remove(i);
          SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "remove vid:%s", localStoryVideoItem.mVid);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */