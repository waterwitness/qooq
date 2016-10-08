import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rel
  implements Runnable
{
  public rel(DatingTopListActivity paramDatingTopListActivity, DatingManager paramDatingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b(DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).listType);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onTabSelected mCurrentCityCfg.listType = ").append(DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).listType).append(", data = ");
      if (localList != null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = null;; localObject = Integer.valueOf(localList.size()))
    {
      QLog.i("DatingTopListActivity", 2, localObject);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.runOnUiThread(new rem(this, localList));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */