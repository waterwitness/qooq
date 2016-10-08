import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class hed
  implements BusinessObserver
{
  hed(hec paramhec)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "onReceive whitelist:" + paramBoolean);
    }
    if (paramBoolean)
    {
      Object localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.WebviewWhiteListResponse();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.ret_info.ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "sso status code: " + String.valueOf(paramInt));
          }
          if (paramInt == 0)
          {
            localObject = new JSONObject(paramBundle.data.get());
            ThreadManager.b().post(new hee(this, paramBundle, (JSONObject)localObject));
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_success", 0, 1, 0, "", "", "", "");
            return;
          }
          if (paramInt == 304)
          {
            this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
            this.a.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
            this.a.a.b();
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 0, 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "update error: " + paramBundle);
          }
        }
      }
    }
    this.a.a.b();
    this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */