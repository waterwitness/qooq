import android.os.Bundle;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class kat
  extends DeviceFileObserver
{
  public kat(DeviceMsgHandle paramDeviceMsgHandle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private List a(Session paramSession)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSession != null)
    {
      str1 = str2;
      if (paramSession.actionInfo != null) {
        str1 = paramSession.actionInfo.strServiceName;
      }
    }
    return a(str1);
  }
  
  private List a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      if (paramString != null) {
        return (List)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
      return null;
      paramString = "";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgProgress");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramBundle);
      }
    }
  }
  
  public void a(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionNew:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession);
      }
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionProgress:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionComplete:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramBoolean);
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgSendRet");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).b(paramBundle);
      }
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionStart:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).b(paramSession);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */