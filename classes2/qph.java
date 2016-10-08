import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;

public final class qph
  implements Runnable
{
  public qph(String paramString, byte paramByte, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_soLoaderName", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.jdField_a_of_type_Byte));
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    if (this.jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(null, "AREnable", bool, 0L, 0L, (HashMap)localObject, null);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("ar_native_so_load_result" + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte);
      SharedPreUtils.a((SharedPreferences.Editor)localObject);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */