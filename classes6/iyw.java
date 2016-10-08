import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyw
  implements Runnable
{
  public iyw(RMWServiceProxy paramRMWServiceProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMWServiceProxy.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */