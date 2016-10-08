import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class lrx
  implements Runnable
{
  public lrx(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LebaShowListManager.a().a(this.a, this.a.app);
    List localList = LebaShowListManager.a().a();
    this.a.runOnUiThread(new lry(this, localList));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */