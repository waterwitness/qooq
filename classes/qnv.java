import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import cooperation.readinjoy.ReadInJoyHelper;

public class qnv
  implements Runnable
{
  public qnv(ReadInJoyManager paramReadInJoyManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager) == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).edit();
    localEditor.putString("config_notify_guide_wording", this.jdField_a_of_type_JavaLangString);
    localEditor.putInt("config_notify_guide_flag", 1);
    localEditor.putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
    ReadInJoyHelper.a(localEditor, true);
    ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */