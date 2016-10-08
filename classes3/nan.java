import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class nan
  extends WtloginObserver
{
  public nan(VerifyPhoneNumActivity paramVerifyPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VerifyPhoneNumActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("VerifyPhoneNumActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    VerifyPhoneNumActivity.a(this.a);
    VerifyPhoneNumActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */