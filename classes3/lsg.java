import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsg
  implements Runnable
{
  public lsg(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LebaListMgrActivity.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */