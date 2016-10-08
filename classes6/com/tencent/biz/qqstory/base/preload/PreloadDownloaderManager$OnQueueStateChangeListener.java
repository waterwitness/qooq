package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class PreloadDownloaderManager$OnQueueStateChangeListener
  implements PreloadDownloaderManager.IOnQueueStateChangeListener
{
  public PreloadDownloaderManager$OnQueueStateChangeListener(PreloadDownloaderManager paramPreloadDownloaderManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((((PreloadQueue)this.a.jdField_a_of_type_JavaUtilList.get(i)).a() == paramInt) && (i + 1 < j))
        {
          PreloadQueue localPreloadQueue = (PreloadQueue)this.a.jdField_a_of_type_JavaUtilList.get(i + 1);
          SLog.b("Q.qqstory.download.preload.PreloadDownloaderManager", "queue " + paramInt + " download completed , turn to " + localPreloadQueue.a());
          this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PreloadDownloaderManager$OnQueueStateChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */