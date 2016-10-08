import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.open.business.base.OpenConfig;
import org.json.JSONObject;

public class wuh
  implements Runnable
{
  public wuh(OpenConfig paramOpenConfig, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(HttpBaseUtil.a("http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_policy_config", "GET", this.jdField_a_of_type_AndroidOsBundle).a);
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a(localJSONObject);
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a = 0;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */