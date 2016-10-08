import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

public class luc
  extends SubAccountObserver
{
  public luc(LoginVerifyCodeActivity paramLoginVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "onGetKeyBack: mainAccount=" + paramString1 + " subAccount=" + paramString2);
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.d();
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onGetKeyBack:subLogin ...has Failed key  =  null");
      }
      this.a.a(2131370540, 0);
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onGetKeyBack: key not null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "subaccount onGetKeyBack goto bind");
      }
      paramString1 = (SubAccountProtocManager)this.a.app.getManager(27);
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, LoginVerifyCodeActivity.a(this.a));
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginVerifyCodeActivity", 2, "onGetKeyBack: success .........");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */