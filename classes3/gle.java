import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gle
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  
  public gle(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.a != null) && (paramContext.equals("homekey")))
      {
        if (!this.a.a.f) {
          break label63;
        }
        RandomDoubleActivity.a(this.a);
      }
    }
    label63:
    while (RandomDoubleActivity.a(this.a) == null) {
      return;
    }
    RandomDoubleActivity.a(this.a).b(this.a.isResume());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */