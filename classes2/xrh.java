import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.HashMap;

public abstract class xrh
  extends Thread
{
  long jdField_a_of_type_Long;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  boolean jdField_a_of_type_Boolean;
  boolean[] jdField_a_of_type_ArrayOfBoolean;
  
  xrh(TraeAudioManager paramTraeAudioManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { false };
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " ++switchThread:" + a());
    }
  }
  
  public abstract String a();
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.b.b();
    AudioDeviceInterface.LogTraceEntry(a() + " err:" + paramInt + " ConnectedDevice: " + this.b.a.d());
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.b.a();
    }
    do
    {
      return;
      this.b.au = this.b.a.d();
      localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " sessonID:" + localObject + "sessionConnectedDev: " + this.b.au);
      }
      if ((localObject != null) && (((Long)localObject).longValue() != Long.MIN_VALUE)) {
        break;
      }
      this.b.a();
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
    return;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_DEVICE"));
    if (this.b.a((Intent)localObject, this.jdField_a_of_type_JavaUtilHashMap, paramInt) == 0) {
      this.b.a();
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void a(HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public abstract void b();
  
  void e()
  {
    this.b.a.d(a());
    a(0);
  }
  
  public void f()
  {
    AudioDeviceInterface.LogTraceEntry(a());
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " quit:" + a() + " _running:" + this.jdField_a_of_type_Boolean);
    }
    interrupt();
    b();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry(a());
    this.b.a.c(a());
    this.b.b();
    a();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */