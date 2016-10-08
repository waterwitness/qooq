import android.media.SoundPool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class tbe
  extends TimerTask
{
  public tbe(SoundPoolUtil paramSoundPoolUtil, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */