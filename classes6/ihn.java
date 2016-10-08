import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.IOnQueueStateChangeListener;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class ihn
  implements Runnable
{
  public volatile boolean a;
  
  private ihn(PreloadDownloader paramPreloadDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    Object localObject6;
    Object localObject7;
    IVideoPreloader.OnPreloadListener localOnPreloadListener;
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue == null)
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.a())) {
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.a();
        DownloadTask localDownloadTask1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
        if (localDownloadTask1 != null)
        {
          SLog.b("Q.qqstory.download.preload.PreloadDownloader", "start download task , " + localDownloadTask1);
          for (;;)
          {
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localObject6 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject6).next()).get();
              if (localObject7 != null) {
                ((IVideoPreloader.OnPreloadListener)localObject7).a(localDownloadTask1.a, localDownloadTask1.f, localDownloadTask1.b);
              }
            }
            ((Iterator)localObject6).remove();
          }
          localDownloadTask2.g = 1;
          localObject6 = PreloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader, localDownloadTask2);
          if (!((ErrorMessage)localObject6).isSuccess()) {
            break;
          }
          localObject6 = new File(localDownloadTask2.c);
          localDownloadTask2.g = 3;
          SLog.b("Q.qqstory.download.preload.PreloadDownloader", "download task success, " + localDownloadTask2);
          synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
          {
            localObject7 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject7).next()).get();
              if (localOnPreloadListener != null) {
                localOnPreloadListener.b(localDownloadTask2.a, localDownloadTask2.f, localDownloadTask2.b, (File)localObject6);
              }
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = null;
        }
      }
    }
    switch (((ErrorMessage)localObject6).errorCode)
    {
    default: 
      ((DownloadTask)localObject1).g = 4;
      SLog.d("Q.qqstory.download.preload.PreloadDownloader", "download task error , errorCode = " + ((ErrorMessage)localObject6).errorCode + " ," + localObject1);
      synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
      {
        localObject7 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject7).next()).get();
          if (localOnPreloadListener != null) {
            localOnPreloadListener.a(((DownloadTask)localObject1).a, ((DownloadTask)localObject1).f, ((DownloadTask)localObject1).b, (ErrorMessage)localObject6);
          }
        }
      }
    case 6: 
      ((DownloadTask)localObject2).g = 2;
      SLog.b("Q.qqstory.download.preload.PreloadDownloader", "download task cancel ," + localObject2);
      synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
      {
        localObject6 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject6).next()).get();
          if (localObject7 != null) {
            ((IVideoPreloader.OnPreloadListener)localObject7).b(((DownloadTask)localObject2).a, ((DownloadTask)localObject2).f, ((DownloadTask)localObject2).b);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = null;
      break;
      ((DownloadTask)localObject3).g = 3;
      SLog.b("Q.qqstory.download.preload.PreloadDownloader", "task has been downloaded before , " + localObject3);
      localObject6 = new File(((DownloadTask)localObject3).c);
      synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
      {
        localObject7 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)((Iterator)localObject7).next()).get();
          if (localOnPreloadListener != null) {
            localOnPreloadListener.a(((DownloadTask)localObject3).a, ((DownloadTask)localObject3).f, ((DownloadTask)localObject3).b, (File)localObject6);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */