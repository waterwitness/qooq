import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.Executor;

public class qsh
  implements Runnable
{
  public qsh(DynamicAvatarManager paramDynamicAvatarManager, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Job localJob = new Job("task_name", this.jdField_a_of_type_JavaLangRunnable, false);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.execute(localJob);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */