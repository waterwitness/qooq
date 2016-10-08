import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.storylist.DelayUpdateDownloadQueueJob;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.strategy.StrategySet.OnDownloadQueuePrepareListener;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

class ihw
  implements StrategySet.OnDownloadQueuePrepareListener
{
  ihw(ihv paramihv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      ((PreloadDownloaderManager)SuperManager.a(6)).d();
      IVideoPreloader localIVideoPreloader = this.a.a.a.a();
      localIVideoPreloader.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        localIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.mVideoThumbnailUrl, 2, false);
        localIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.getDownloadMaskUrl(), 1, false);
        localIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.mVideoUrl, 0, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */