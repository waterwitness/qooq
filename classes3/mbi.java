import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class mbi
  extends GameCenterObserver
{
  public mbi(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (PublicAccountListActivity.a(this.a)) {
      PublicAccountListActivity.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */