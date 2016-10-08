import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mui
  implements Runnable
{
  public mui(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((TroopHandler)this.a.app.a(20)).a(this.a.k, this.a.A, this.a.K);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */