import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.RoamSettingController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class qfl
  implements Runnable
{
  public qfl(RoamSettingManager paramRoamSettingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    ArrayList localArrayList = (ArrayList)this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, false, null, null, null, null, null, null);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        if (i < localArrayList.size())
        {
          RoamSetting localRoamSetting = (RoamSetting)localArrayList.get(i);
          if (RoamSettingController.a(localRoamSetting.path) == 1) {
            RoamSettingManager.a(this.a).put(localRoamSetting.path, localRoamSetting);
          } else {
            RoamSettingManager.b(this.a).put(localRoamSetting.path, localRoamSetting);
          }
        }
      }
      finally
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      RoamSettingManager.a(this.a, true);
      return;
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */