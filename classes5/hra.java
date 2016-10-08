import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hra
  implements Runnable
{
  public hra(PublicAccountUnfollowTask paramPublicAccountUnfollowTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PublicAccountUtil.a(PublicAccountUnfollowTask.a(this.a), PublicAccountUnfollowTask.a(this.a), PublicAccountUnfollowTask.a(this.a), false, this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */