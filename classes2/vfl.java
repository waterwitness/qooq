import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;

public class vfl
  extends MessageObserver
{
  public vfl(PubAccBindTroopListActivity paramPubAccBindTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (!paramBoolean) {
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.a();
  }
  
  protected void b()
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */