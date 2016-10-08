import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class raf
  extends TimerTask
{
  int jdField_a_of_type_Int;
  
  public raf(ConfigManager paramConfigManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void run()
  {
    synchronized (ConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigConfigManager))
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 30)
      {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfigManager.d();
        cancel();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\raf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */