import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.WtloginObserver;

public class mip
  extends WtloginObserver
{
  public mip(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPersonalInfoActivity", 2, "OnRegGetSMSVerifyLoginAccount ret=" + paramInt + " uin=" + paramLong);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.d();
    if (paramInt == 0)
    {
      RegisterPersonalInfoActivity.a(this.a, Long.valueOf(paramLong).toString());
      RegisterPersonalInfoActivity.a(this.a, paramArrayOfByte2);
      if (TextUtils.isEmpty(RegisterPersonalInfoActivity.a(this.a)))
      {
        this.a.a(2131368479, 1);
        return;
      }
      if ((RegisterPersonalInfoActivity.a(this.a) == null) || (RegisterPersonalInfoActivity.a(this.a).length == 0))
      {
        this.a.a(2131368479, 1);
        return;
      }
      paramArrayOfByte1 = new Intent(this.a, RegisterQQNumberActivity.class);
      paramArrayOfByte1.putExtra("phonenum", this.a.d);
      paramArrayOfByte1.putExtra("key", this.a.e);
      paramArrayOfByte1.putExtra("uin", RegisterPersonalInfoActivity.a(this.a));
      paramArrayOfByte1.putExtra("key_register_now_account", this.a.f);
      paramArrayOfByte1.putExtra("key_register_sign", RegisterPersonalInfoActivity.a(this.a));
      this.a.startActivity(paramArrayOfByte1);
      this.a.finish();
      return;
    }
    if (paramArrayOfByte3 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte1)) {
          break;
        }
        this.a.a(2131368479, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
    }
    this.a.a(paramArrayOfByte1, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */