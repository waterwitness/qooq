import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class min
  extends AccountObserver
{
  public min(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.d();
    if (!paramBoolean) {
      try
      {
        paramString = new String(paramArrayOfByte2, "utf-8");
        paramArrayOfByte1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte1 = this.a.getString(2131368479);
        }
        this.a.a(paramArrayOfByte1, 1);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder().append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(paramString).append(";contactsig = ");
      if (paramArrayOfByte1 != null) {
        break label197;
      }
    }
    label197:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, paramBoolean);
      if (paramInt != 0) {
        break label242;
      }
      RegisterByNicknameAndPwdActivity.a(this.a, paramString);
      RegisterByNicknameAndPwdActivity.a(this.a, paramArrayOfByte1);
      if (!TextUtils.isEmpty(RegisterByNicknameAndPwdActivity.a(this.a))) {
        break;
      }
      this.a.a(2131368479, 1);
      return;
    }
    if ((RegisterByNicknameAndPwdActivity.a(this.a) == null) || (RegisterByNicknameAndPwdActivity.a(this.a).length == 0))
    {
      this.a.a(2131368479, 1);
      return;
    }
    this.a.a();
    return;
    label242:
    this.a.a(2131368479, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\min.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */