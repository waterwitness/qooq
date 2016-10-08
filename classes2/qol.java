import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;

public class qol
  implements Runnable
{
  public qol(ARDeviceController paramARDeviceController, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "AREnable", this.jdField_a_of_type_Boolean, 0L, 0L, (HashMap)localObject, null);
    localObject = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("ar_incompatible_reason", this.jdField_a_of_type_Int);
    SharedPreUtils.a((SharedPreferences.Editor)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */