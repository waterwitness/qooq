import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;
import java.util.Arrays;

public class jwj
  implements Handler.Callback
{
  public jwj(SmartDeviceProxyMgr paramSmartDeviceProxyMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.a();
      return true;
      try
      {
        paramMessage = (QQAppInterface)BaseApplicationImpl.a().a();
        boolean bool1 = SmartDevicePluginLoader.a().a(paramMessage);
        boolean bool2 = NetworkUtil.i(BaseApplicationImpl.getContext());
        SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr check plugin: isInstalled " + bool1 + " isWifiConnected " + bool2);
        if ((bool1) || (!bool2)) {
          continue;
        }
        SmartDevicePluginLoader.a().a();
        return true;
      }
      catch (Exception paramMessage)
      {
        return true;
      }
      try
      {
        if (SmartDeviceProxyMgr.a(this.a) != null)
        {
          paramMessage = new Bundle();
          paramMessage.putString("notify_cmd", "getServerDeviceList");
          paramMessage = SmartDeviceProxyMgr.a(this.a).a(paramMessage);
          if (paramMessage != null)
          {
            paramMessage = paramMessage.getParcelableArray("devicelist");
            if (paramMessage != null)
            {
              DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[paramMessage.length];
              int i = 0;
              while (i < paramMessage.length)
              {
                arrayOfDeviceInfo[i] = ((DeviceInfo)paramMessage[i]);
                i += 1;
              }
              SmartDeviceProxyMgr.a(this.a, arrayOfDeviceInfo);
              if (arrayOfDeviceInfo != null)
              {
                this.a.a(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramMessage) {}
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */