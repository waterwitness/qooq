import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mkf
  implements Runnable
{
  public mkf(SecurityProtectActivity paramSecurityProtectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SecurityProtectActivity.a(this.a, false);
    SecurityProtectActivity.a(this.a).setText(2131370814);
    SecurityProtectActivity.b(this.a).setVisibility(0);
    SecurityProtectActivity.a(this.a).setVisibility(0);
    ((LinearLayout)this.a.findViewById(2131304895)).setVisibility(8);
    FMToastUtil.a(2131368805);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */