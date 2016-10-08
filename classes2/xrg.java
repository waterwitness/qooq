import android.media.AudioManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

public class xrg
  extends xrh
{
  public xrg(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void a()
  {
    int j = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, true);
    e();
    int i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, " _run:" + a() + " _running:" + this.jdField_a_of_type_Boolean);
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn() != true) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, true);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */