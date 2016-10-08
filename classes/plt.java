import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class plt
  implements Runnable
{
  public plt(QvipSpecialSoundManager paramQvipSpecialSoundManager, QvipSpecialSoundManager.CallBack paramCallBack, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager$CallBack.a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\plt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */