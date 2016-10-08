import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

class mmn
  extends SubAccountObserver
{
  mmn(mmm parammmm, SimpleAccount paramSimpleAccount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Mmm.a.app.a(), "actSBDLoginGetkey", false, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack: key is empty? why? shit");
      }
      this.jdField_a_of_type_Mmm.a.runOnUiThread(new mmo(this));
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Mmm.a.app.a(), "actSBDLoginGetkey", true, 0L, 0L, paramString1, "");
      paramString1 = (SubAccountProtocManager)this.jdField_a_of_type_Mmm.a.app.getManager(27);
      if (paramString1 != null) {
        paramString1.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), paramString3, this.jdField_a_of_type_Mmm.a.a);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack:getA2 subAccount = " + paramString2 + ".....subA2 = " + paramString3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */