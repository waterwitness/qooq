import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQUtils;

public class rrv
  implements Runnable
{
  public rrv(QfileFileAssistantActivity paramQfileFileAssistantActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity.getSharedPreferences("Offline_Flags", 0).getBoolean("TMPFLAG", false);
    if ((!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity.getString(2131362722) })) && (!bool)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity.runOnUiThread(new rrw(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */