import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class rjw
  implements Runnable
{
  public rjw(EmoticonMainPanel paramEmoticonMainPanel, int paramInt, long paramLong, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str;
    SharedPreferences localSharedPreferences;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_AndroidContentContext != null) && (str != null))
      {
        localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emoticon_panel_" + str, 0);
        long l = localSharedPreferences.getLong("sp_key_emoticon_panel_last_report_time", 0L);
        i = localSharedPreferences.getInt("sp_key_emoticon_panel_report_count", 0);
        if (System.currentTimeMillis() - l <= 86400000L) {
          break label254;
        }
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("sp_key_emoticon_panel_last_report_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).putInt("sp_key_emoticon_panel_report_count", 0);
        ((SharedPreferences.Editor)localObject).commit();
        i = 0;
      }
    }
    label254:
    for (;;)
    {
      if (i < 10)
      {
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_AndroidContentContext).a(str, (String)localObject, true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", false);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("sp_key_emoticon_panel_report_count", i + 1);
        ((SharedPreferences.Editor)localObject).commit();
        return;
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
        continue;
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
        continue;
        localObject = "report_AIOEmoticonPanel_ReopenInAIO";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */