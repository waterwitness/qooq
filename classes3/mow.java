import android.os.Handler;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class mow
  implements Runnable
{
  public mow(TroopAssisSettingActivity paramTroopAssisSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */