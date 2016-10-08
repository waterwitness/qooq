import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class rei
  implements Runnable
{
  public rei(DatingTopListActivity paramDatingTopListActivity, DatingManager paramDatingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b(DatingTopListActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).listType);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.runOnUiThread(new rej(this, localList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */