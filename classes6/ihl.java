import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ihl
  implements IVideoPreloader.OnPreloadListener
{
  private ihl(PlayingListPreloader paramPlayingListPreloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, int paramInt, String paramString2, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download error! vid = " + paramString1 + " ;fileType = " + paramInt + " ;error code = " + paramErrorMessage.errorCode);
    if (paramInt == 0)
    {
      StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString1);
      if (localStoryVideoItem != null) {
        localStoryVideoItem.mPreloadState = 2;
      }
    }
    if ((paramInt == 0) && (this.a.a != null)) {
      this.a.a.a(paramString1, paramString2, paramErrorMessage);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    if (paramInt != 0) {}
    do
    {
      StoryManager localStoryManager;
      StoryVideoItem localStoryVideoItem;
      do
      {
        return;
        localStoryManager = (StoryManager)SuperManager.a(5);
        localStoryVideoItem = localStoryManager.a(paramString1);
      } while (localStoryVideoItem == null);
      localStoryVideoItem.mPreloadState = 1;
      if ((localStoryVideoItem.mLocalVideoPath == null) || (!localStoryVideoItem.mLocalVideoPath.equals(paramFile.getAbsolutePath())))
      {
        localStoryVideoItem.mLocalVideoPath = paramFile.getAbsolutePath();
        localStoryManager.a(paramString1, localStoryVideoItem);
      }
    } while (this.a.a == null);
    this.a.a.b(paramString1, paramString2, paramFile);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, File paramFile, int paramInt2) {}
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      this.a.a.a(paramString1, paramString2);
    }
  }
  
  public void b(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download success! vid = " + paramString1 + " ;file path = " + paramFile.getAbsolutePath());
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = localStoryManager.a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.mOwnerUid != 0L))
    {
      QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
      if (localQQUserUIItem != null) {
        SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download success! vid = " + paramString1 + " ;fileType = " + paramInt + " ;user = " + localQQUserUIItem.nickName);
      }
      if (localStoryVideoItem != null) {
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      localStoryManager.a(paramString1, localStoryVideoItem);
      if ((paramInt == 0) && (this.a.a != null)) {
        this.a.a.a(paramString1, paramString2, paramFile);
      }
      return;
      SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download success! vid = " + paramString1 + " ;fileType = " + paramInt + " ;user not found");
      break;
      localStoryVideoItem.mLocalVideoPath = paramFile.getAbsolutePath();
      localStoryVideoItem.mPreloadState = 1;
      continue;
      localStoryVideoItem.mVideoLocalThumbnailPath = paramFile.getAbsolutePath();
      continue;
      localStoryVideoItem.mLocalMaskPath = paramFile.getAbsolutePath();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */