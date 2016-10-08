import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

public class qnu
  implements Runnable
{
  public qnu(ReadInJoyManager paramReadInJoyManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = "";
    int i = 0;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j = ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue();
      if (i <= 0) {
        break label176;
      }
      str = str + ",";
    }
    label176:
    for (;;)
    {
      str = str + j;
      i += 1;
      break;
      if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager) == null) {}
      do
      {
        return;
        localObject = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).getString("config_new_channel_id_list", "");
      } while ((TextUtils.isEmpty(str)) || (((String)localObject).equals(str)));
      Object localObject = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).edit();
      ((SharedPreferences.Editor)localObject).putString("config_new_channel_id_list", str);
      ((SharedPreferences.Editor)localObject).putInt("config_new_channel_notify_flag", 1);
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */