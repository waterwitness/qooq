import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public final class yrm
  implements ThreadPool.Job
{
  public yrm(String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneOfflineCacheHelper", 2, String.format("delay 10s,url:%s,path:%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    }
    paramJobContext = new yrn(this);
    try
    {
      new Timer().schedule(paramJobContext, 10000L);
      return null;
    }
    catch (Throwable paramJobContext)
    {
      for (;;)
      {
        paramJobContext.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */