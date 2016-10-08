package cooperation.huangye;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import ybz;

public class C2BAuthorityActivity
  extends AuthorityActivity
{
  public static final String G = "com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH";
  BroadcastReceiver a;
  
  public C2BAuthorityActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ybz(this);
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.a);
    super.doOnDestroy();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.a, localIntentFilter);
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\C2BAuthorityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */