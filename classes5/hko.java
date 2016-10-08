import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hko
  implements Runnable
{
  public hko(EqqAccountDetailActivity paramEqqAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EqqAccountDetailActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */