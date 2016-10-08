import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;

public class xrd
  extends xrh
{
  public xrd(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
  
  public void a()
  {
    try
    {
      Thread.sleep(5000L);
      int j;
      StringBuilder localStringBuilder;
      int i;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a().indexOf("Gear") != -1)
      {
        j = 1;
        if (j == 0) {
          c();
        }
        localStringBuilder = new StringBuilder(1024);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("bluetoothHeadsetSwitchThread ");
        }
        i = 0;
      }
      for (;;)
      {
        int k;
        if (this.jdField_a_of_type_Boolean == true)
        {
          k = i + 1;
          if ((i < 10) && (j == 0)) {
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("i:");
              localStringBuilder.append(k);
              localStringBuilder.append(" sco:");
              if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
                break label266;
              }
            }
          }
        }
        label266:
        for (String str = "Y";; str = "N")
        {
          localStringBuilder.append(str);
          localStringBuilder.append(" :");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
          localStringBuilder.append("\n");
          if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
            break label272;
          }
          e();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, localStringBuilder.toString());
          }
          if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn())
          {
            if ((QLog.isColorLevel()) && (j == 0)) {
              QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(a(), false);
            a(10);
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.d();
          }
          return;
          j = 0;
          break;
        }
        try
        {
          label272:
          Thread.sleep(1000L);
          i = k;
        }
        catch (InterruptedException localInterruptedException1)
        {
          i = k;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    d();
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
    }
  }
  
  void d()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */