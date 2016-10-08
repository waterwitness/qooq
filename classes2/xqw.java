import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;

public class xqw
  extends xqy
{
  public xqw(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "BluetoohHeadsetCheckFake";
  }
  
  public void a() {}
  
  void a(Context paramContext, Intent paramIntent) {}
  
  void a(IntentFilter paramIntentFilter) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */