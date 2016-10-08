import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QuickLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class mhi
  implements AdapterView.OnItemClickListener
{
  public mhi(QuickLoginActivity paramQuickLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)((HashMap)this.a.a.get(paramInt)).get("qq");
    libsafeedit.getLoginLegal((String)((HashMap)this.a.a.get(paramInt)).get("password"));
    paramView = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    this.a.getAppRuntime().login(paramAdapterView, paramView, QuickLoginActivity.a(this.a));
    Toast.makeText(this.a.getApplicationContext(), "logining...", 0).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */