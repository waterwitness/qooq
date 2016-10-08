import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.cache.FileStorageHandler;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.Collection;
import java.util.Iterator;

public class ylv
  implements ThreadPool.Job
{
  public ylv(FileStorageHandler paramFileStorageHandler, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int j = localFileCacheService.a(this.jdField_a_of_type_Boolean);
        String str = localFileCacheService.a();
        int i = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler, str);
        j = FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler, j, i);
        this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler.a(i, j, str);
        QLog.w(CacheManager.a, 1, "onLowStorage clear cache service:" + localFileCacheService + ": remain=" + j);
      }
      if (FileStorageHandler.a(CacheManager.i()))
      {
        CacheManager.a(false, true);
        if (FileStorageHandler.a(CacheManager.i()))
        {
          CacheManager.a(true, true);
          FileStorageHandler.a(this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler);
        }
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */