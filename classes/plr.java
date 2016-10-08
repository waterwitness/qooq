import android.content.Context;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class plr
  implements Runnable
{
  public plr(QvipSpecialSoundManager paramQvipSpecialSoundManager, plq paramplq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Plq.c))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager).getFilesDir(), this.jdField_a_of_type_Plq.c);
      if (localFile != null) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(l);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.b("updateSpecialSound down fial, id=" + this.jdField_a_of_type_Plq.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\plr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */