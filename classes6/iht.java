import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.pgc.model.VideoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class iht
  extends QQStoryObserver
{
  public iht(PGCUrlChecker paramPGCUrlChecker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.next();
        String str = localVideoInfo.a;
        if (paramBoolean)
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.a.b.get(str);
          if (localStoryVideoItem != null) {
            localStoryVideoItem.mVideoUrl = localVideoInfo.b;
          }
        }
        this.a.b.remove(str);
      }
    }
    PGCUrlChecker.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */