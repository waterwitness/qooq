import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.StringUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

public class qnw
  implements Runnable
{
  public qnw(ReadInJoyManager paramReadInJoyManager, long paramLong, String paramString1, String paramString2, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager) == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager).edit();
    localEditor.putInt("readinjoy_push_channel_article_flag", 1);
    localEditor.putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
    localEditor.putLong("readinjoy_push_channel_article_content_channel_id", this.jdField_a_of_type_Long);
    localEditor.putString("readinjoy_push_channel_article_content_channel_name", this.jdField_a_of_type_JavaLangString);
    localEditor.putString("readinjoy_push_channel_article_content_wording", this.b);
    localEditor.putString("readinjoy_push_channel_article_content_article_id_list", StringUtil.a(this.jdField_a_of_type_JavaUtilList, ","));
    ReadInJoyHelper.a(localEditor, true);
    ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */