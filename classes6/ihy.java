import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ihy
  implements IVideoPreloader.OnPreloadListener
{
  private ihy(PreloadVideoSource paramPreloadVideoSource)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, int paramInt, String paramString2, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.download.preload.PreloadVideoSource", "download error! vid = " + paramString1 + " ;fileType = " + paramInt + " ;error code = " + paramErrorMessage.errorCode);
    if (paramInt != 0) {
      return;
    }
    paramString2 = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if (paramString2 != null) {
      paramString2.mPreloadState = 2;
    }
    this.a.a.a(paramString1, false);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    if (paramInt != 0) {}
    StoryVideoItem localStoryVideoItem;
    do
    {
      do
      {
        return;
        paramString2 = (StoryManager)SuperManager.a(5);
        localStoryVideoItem = paramString2.a(paramString1);
      } while (localStoryVideoItem == null);
      localStoryVideoItem.mPreloadState = 1;
    } while ((localStoryVideoItem.mLocalVideoPath != null) && (localStoryVideoItem.mLocalVideoPath.equals(paramFile.getAbsolutePath())));
    localStoryVideoItem.mLocalVideoPath = paramFile.getAbsolutePath();
    paramString2.a(paramString1, localStoryVideoItem);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, File paramFile, int paramInt2) {}
  
  public void b(String paramString1, int paramInt, String paramString2) {}
  
  public void b(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    SLog.b("Q.qqstory.download.preload.PreloadVideoSource", "download success! vid = " + paramString1 + " ;file path = " + paramFile.getAbsolutePath());
    paramString2 = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = paramString2.a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.mOwnerUid != 0L))
    {
      QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
      if (localQQUserUIItem != null) {
        SLog.b("Q.qqstory.download.preload.PreloadVideoSource", "download success! vid = " + paramString1 + " ;fileType = " + paramInt + " ;user = " + localQQUserUIItem.nickName);
      }
      if (localStoryVideoItem != null) {
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      paramString2.a(paramString1, localStoryVideoItem);
      this.a.a.a(paramString1, true);
      return;
      SLog.b("Q.qqstory.download.preload.PreloadVideoSource", "download success! vid =  ;fileType = " + paramInt + paramString1 + " ;user not found");
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


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */