import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class opv
  extends ContactBindObserver
{
  public opv(RebindActivity paramRebindActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b();
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("k_number", this.a.d);
      paramBundle.putExtra("kBindType", RebindActivity.a(this.a));
      paramBundle.putExtra("keyReqBindMode", 1);
      paramBundle.putExtra("k_country_code", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_uni", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", RebindActivity.b(this.a));
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      paramBundle.putExtra("key_is_from_qav_multi_call", this.a.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      this.a.startActivityForResult(paramBundle, 1);
      return;
    }
    this.a.b(2131368649);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */