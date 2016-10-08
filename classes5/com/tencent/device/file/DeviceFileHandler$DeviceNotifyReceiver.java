package com.tencent.device.file;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.HashMap;
import java.util.HashSet;

public class DeviceFileHandler$DeviceNotifyReceiver
  extends BroadcastReceiver
{
  public DeviceFileHandler$DeviceNotifyReceiver(DeviceFileHandler paramDeviceFileHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    label296:
    label382:
    int j;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                long l1;
                do
                {
                  long l2;
                  long l3;
                  do
                  {
                    do
                    {
                      return;
                      paramContext = paramIntent.getAction();
                    } while (paramContext == null);
                    if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress")) {
                      break;
                    }
                    paramContext = paramIntent.getExtras();
                    l1 = paramContext.getLong("cookie", 0L);
                    l2 = paramContext.getLong("progress", 0L);
                    l3 = paramContext.getLong("total", 0L);
                    paramContext = (Session)DeviceFileHandler.a(this.a).get(Long.valueOf(l1));
                  } while (paramContext == null);
                  if (paramContext.uFileSizeSrc == 0L) {
                    paramContext.uFileSizeSrc = l3;
                  }
                  this.a.a(102, true, new Object[] { paramContext, Float.valueOf((float)((float)l2 * 1.0D / (float)l3)) });
                  return;
                  if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete")) {
                    break;
                  }
                  paramContext = paramIntent.getExtras();
                  l1 = paramContext.getLong("cookie", 0L);
                  i = paramContext.getInt("err_code", 0);
                  str = paramContext.getString("filepath");
                  paramIntent = (Session)DeviceFileHandler.b(this.a).get(Long.valueOf(l1));
                } while (paramIntent == null);
                if (this.a.b.contains(Long.valueOf(l1))) {
                  if (!TextUtils.isEmpty(str))
                  {
                    if (str.lastIndexOf(".") > 0)
                    {
                      paramContext = str.substring(str.lastIndexOf("."));
                      paramContext = AppConstants.bj + "/smart_device/" + System.currentTimeMillis() + paramContext;
                      FileUtils.b(str, paramContext);
                      paramIntent.strFilePathSrc = paramContext;
                      this.a.b.remove(Long.valueOf(l1));
                    }
                  }
                  else
                  {
                    if (i == -5103058) {
                      this.a.c.put(Long.valueOf(paramIntent.uSessionID), Integer.valueOf(-5103058));
                    }
                    paramContext = this.a;
                    if (i != 0) {
                      break label382;
                    }
                  }
                }
                for (boolean bool = true;; bool = false)
                {
                  paramContext.a(103, bool, paramIntent);
                  return;
                  paramContext = ".amr";
                  break;
                  if (!paramIntent.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.c)) {
                    break label296;
                  }
                  paramIntent.vFileMD5Src = str.getBytes();
                  break label296;
                }
                if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress")) {
                  break;
                }
                paramContext = paramIntent.getExtras();
              } while (paramContext == null);
              this.a.a(104, true, paramContext);
              return;
              if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet")) {
                break;
              }
              paramContext = paramIntent.getExtras();
            } while (paramContext == null);
            this.a.a(105, true, paramContext);
            return;
          } while (!paramContext.equalsIgnoreCase("CloudPrintJobNotifyEvent"));
          paramIntent = paramIntent.getExtras();
        } while (paramIntent == null);
        i = paramIntent.getInt("nType", 0);
        String str = paramIntent.getString("strJobId");
        j = paramIntent.getInt("nEventValue", 0);
        paramContext = null;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramContext = (Session)DeviceFileHandler.c(this.a).get(Long.valueOf(Long.parseLong(str)));
      } while (paramContext == null);
      switch (i)
      {
      default: 
        return;
      }
    } while (j == 0);
    this.a.a(103, false, paramContext);
    return;
    if (j == 100)
    {
      this.a.a(103, true, paramContext);
      return;
    }
    this.a.a(102, true, new Object[] { paramContext, Float.valueOf((float)(j / 100.0D)) });
    return;
    this.a.c.put(Long.valueOf(paramContext.uSessionID), Integer.valueOf(j));
    this.a.a(103, false, paramContext);
    return;
    paramContext = ((SmartDeviceProxyMgr)this.a.a.a(51)).a(paramIntent.getLong("uDin", 0L));
    if (j == 3)
    {
      paramContext.userStatus = 20;
      return;
    }
    paramContext.userStatus = 10;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceFileHandler$DeviceNotifyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */