import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class myj
  implements Runnable
{
  public myj(TroopTransferActivity paramTroopTransferActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\myj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */