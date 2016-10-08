import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class opp
  extends ContactBindObserver
{
  public opp(PhoneLaunchActivity paramPhoneLaunchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    PhoneLaunchActivity.a(this.a).setEnabled(true);
    if (this.a.a != null)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.b();
    if (paramBoolean)
    {
      Object localObject = this.a;
      if (PhoneLaunchActivity.a(this.a))
      {
        Intent localIntent = new Intent((Context)localObject, PhoneFrameActivity.class);
        localIntent.putExtra("key_req_type", 4);
        localIntent.putExtra("kSrouce", 6);
        ((DialogBaseActivity)localObject).startActivity(localIntent);
        return;
      }
      if ((PhoneLaunchActivity.b(this.a)) || (PhoneLaunchActivity.c(this.a)))
      {
        this.a.setResult(-1);
        this.a.finish();
        return;
      }
      localObject = new Intent((Context)localObject, SettingActivity2.class);
      if (PhoneLaunchActivity.d(this.a)) {
        ((Intent)localObject).putExtra("kSrouce", 7);
      }
      this.a.startActivityForResult((Intent)localObject, 2);
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.a("启用失败，请重新尝试！");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */