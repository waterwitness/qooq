import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gmb
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  
  public gmb(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.a != null) && (paramContext.equals("homekey")) && (RandomMultiActivity.a(this.a) != null)) {
        RandomMultiActivity.a(this.a).b(this.a.isResume());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */