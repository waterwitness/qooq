import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager;

public class yts
  implements Runnable
{
  public yts(TroopHWFileDownloadManager paramTroopHWFileDownloadManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopHWFileDownloadManager.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */