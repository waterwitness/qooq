import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;

public class jwo
  extends BroadcastReceiver
{
  public jwo(SmartDeviceProxyMgr paramSmartDeviceProxyMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChang")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceDisconnected")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceLogined")))
    {
      SmartDeviceProxyMgr.a(this.a).sendEmptyMessage(1003);
      new LightAppUtil().a();
      this.a.k = 2;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChangeUI")) {
              break;
            }
            paramContext = this.a.a();
            SmartDeviceProxyMgr.a(this.a, "DeviceList @@ cache receivechange for ui list:" + paramContext);
          } while (paramContext == null);
          this.a.a(1, true, new ArrayList(Arrays.asList(paramContext)));
          return;
          if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_login"))
          {
            i = paramIntent.getExtras().getInt("logincode");
            SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr::receive qq login broadcast!!!resultCode = " + i);
            SettingCloneUtil.writeValue(this.a.b.a(), this.a.b.a(), null, "account_login_success_time", String.valueOf(MessageCache.a()));
            if (i == 0)
            {
              this.a.g = 2;
              return;
            }
            this.a.g = 3;
            return;
          }
          if ((paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.LOGOUT")) || (paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.ACCOUNT_CHANGED")))
          {
            if (this.a.a())
            {
              SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr::receive qq logout broadcast!!!");
              this.a.d();
            }
            LightAppUtil.c();
            return;
          }
          if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_clickOnDeviceList"))
          {
            if (this.a.a())
            {
              this.a.b(false);
              this.a.f();
            }
            SmartDeviceReport.a(null, "Usr_Click_MyDevice", 0, 0, 0);
            return;
          }
          if (!paramIntent.getAction().equalsIgnoreCase("onQFindLostDeviceList")) {
            break;
          }
        } while (paramIntent.getExtras().getInt("qfind_result", 1) != 0);
        this.a.a.clear();
        paramContext = paramIntent.getExtras().getLongArray("qfind_dins");
        int j = paramContext.length;
        while (i < j)
        {
          long l = paramContext[i];
          this.a.a.add(Long.valueOf(l));
          i += 1;
        }
        paramContext = this.a.a();
      } while (paramContext == null);
      this.a.a(1, true, new ArrayList(Arrays.asList(paramContext)));
      return;
    } while ((paramIntent.getAction().equals("SmartDevice_receiveDPMsg")) || (!paramIntent.getAction().equals("SmartDevice_DeviceBindRst")) || (paramIntent.getExtras().getInt("deviceoprstcode") != 0));
    SmartDeviceProxyMgr.a(this.a, 1);
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.a.b.a(), null, "qqsetting_deviceplugin_bind_flag", SmartDeviceProxyMgr.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */