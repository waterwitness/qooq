import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class wpc
  implements Runnable
{
  public wpc(MQPSensitiveMsgUtil paramMQPSensitiveMsgUtil, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = "sp_confirmed_sensmsg_" + MQPSensitiveMsgUtil.a();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(this.jdField_a_of_type_JavaLangString, this.b);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */