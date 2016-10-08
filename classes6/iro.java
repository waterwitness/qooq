import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AsyncJob;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.FutureListener;

public class iro
  implements FutureListener
{
  public iro(AsyncJob paramAsyncJob)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Void paramVoid) {}
  
  public void onFutureCanceled() {}
  
  public void onFutureDone(Object paramObject)
  {
    AsyncJob.a.post(new irp(this, paramObject));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */