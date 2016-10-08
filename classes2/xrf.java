import android.media.AudioManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.sharp.jni.TraeAudioManager;

public class xrf
  extends xrh
{
  public xrf(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setWiredHeadsetOn(true);
    e();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn()) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */