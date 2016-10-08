import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.cache.FileStorageHandler;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.Collection;
import java.util.Iterator;

public class ylz
  implements ThreadPool.Job
{
  public ylz(FileStorageHandler paramFileStorageHandler, boolean paramBoolean)
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
        Object localObject = (FileCacheService)paramJobContext.next();
        int i = ((FileCacheService)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((FileCacheService)localObject).a();
        this.jdField_a_of_type_CooperationQzoneCacheFileStorageHandler.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */