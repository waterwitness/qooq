import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager;

public class ytt
  implements Runnable
{
  public ytt(TroopHWFileDownloadManager paramTroopHWFileDownloadManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopHWFileDownloadManager.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager).setDownloadSDKWifiOnly(this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */