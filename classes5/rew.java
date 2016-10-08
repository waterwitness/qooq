import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rew
  implements View.OnClickListener
{
  public rew(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DatingTopListActivity", 2, "DatingTopListActivity onClick more mCurrentList = " + DatingTopListActivity.c(this.a));
    }
    if (DatingTopListActivity.c(this.a) == 1) {
      DatingTopListActivity.a(this.a, DatingTopListActivity.b(this.a), false, false, true);
    }
    for (;;)
    {
      DatingTopListActivity.a(this.a).a();
      return;
      DatingTopListActivity.a(this.a, DatingTopListActivity.a(this.a), false, false, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */