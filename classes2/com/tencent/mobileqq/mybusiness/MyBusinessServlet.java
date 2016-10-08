package com.tencent.mobileqq.mybusiness;

import MyCarrier.Carrier;
import MyCarrier.MQQ.PreLoadCarrierReq;
import MyCarrier.RspCarrier;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import thd;

public class MyBusinessServlet
  extends MSFServlet
{
  public static final String a = "MyBusinessServlet";
  
  public MyBusinessServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)getAppRuntime();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RspCarrier)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspCarrier", new RspCarrier());
      localBundle.putSerializable("result", paramFromServiceMsg.carrrier);
      localBundle.putSerializable("refreshTime", Integer.valueOf(paramFromServiceMsg.refreshTime));
      Object localObject = paramFromServiceMsg.carrrier;
      if (QLog.isDevelopLevel())
      {
        QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess");
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierCity      " + ((Carrier)localObject).carrierCity);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierExtraInfo " + ((Carrier)localObject).carrierExtraInfo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierId        " + ((Carrier)localObject).carrierId);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierLogo      " + ((Carrier)localObject).carrierLogo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierName      " + ((Carrier)localObject).carrierName);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierProvince  " + ((Carrier)localObject).carrierProvince);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierURL       " + ((Carrier)localObject).carrierURL);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery redhotfilter     " + ((Carrier)localObject).redhotfilter);
      }
      if (paramFromServiceMsg.retWiFi == 0)
      {
        localObject = a().getApplication();
        String str = a().a();
        if (paramFromServiceMsg.wifiEnable == 1) {
          bool1 = true;
        }
        bool1 = QQWiFiHelper.a((Context)localObject, str, bool1);
        boolean bool2 = QQWiFiHelper.a(a().getApplication(), paramFromServiceMsg.vAvailSsids);
        boolean bool3 = QQWiFiHelper.a(a().getApplication(), a().a(), paramFromServiceMsg.freeTime);
        boolean bool4 = QQWiFiHelper.a(a().getApplication(), paramFromServiceMsg.mParams);
        if (QLog.isColorLevel()) {
          QLog.i("MyBusinessServlet", 2, "isUpdateEnableSuccess:" + bool1 + ",isUpdateSsidSuccess:" + bool2 + ",isUpdateFreeTimeSuccess:" + bool3 + ",isUpdateParamsSuccess:" + bool4);
        }
        if ((bool1) || (bool2) || (bool3) || (bool4))
        {
          if (QLog.isColorLevel()) {
            QLog.i("MyBusinessServlet", 2, "MyBusinessServlet send qqwifi broadcast");
          }
          paramFromServiceMsg = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
          paramFromServiceMsg.putExtra("enableChange", true);
          a().getApplication().sendBroadcast(paramFromServiceMsg);
        }
      }
      notifyObserver(paramIntent, 1, true, localBundle, MyBusinessObserver.class);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess failed");
    }
    notifyObserver(paramIntent, 1, false, localBundle, MyBusinessObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "......onReceive cmd = " + paramFromServiceMsg.getServiceCmd());
    }
    if ("CarrierEntry.queryCarrier".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("cmd_id", -1);
    if (1 == i)
    {
      SosoInterface.a(new thd(this, 0, false, true, 60000L, false, false, "MyBusinessServlet", paramIntent.getStringExtra("phone_number"), paramIntent.getIntExtra("bind_from", 0), paramIntent.getStringExtra("opt_info"), paramPacket, paramIntent));
      paramPacket.setSSOCommand(null);
    }
    while (2 != i) {
      return;
    }
    String str = "";
    int j = 0;
    Object localObject = (PhoneContactManager)a().getManager(10);
    paramIntent = str;
    i = j;
    if (((PhoneContactManager)localObject).d() > 1)
    {
      localObject = ((PhoneContactManager)localObject).a();
      paramIntent = str;
      i = j;
      if (localObject != null)
      {
        i = ((RespondQueryQQBindingStat)localObject).type;
        paramIntent = ((RespondQueryQQBindingStat)localObject).mobileNo;
      }
    }
    paramIntent = new PreLoadCarrierReq(paramIntent, i, 1, "6.5.5.2880", NetworkUtil.a(BaseApplication.getContext()));
    paramPacket.setSSOCommand("CarrierBizSvr.preLoadCarrierInfo");
    paramPacket.setServantName("MQQ.CarrierBizServer.CarrierBizObj");
    paramPacket.setFuncName("preLoadCarrierInfo");
    paramPacket.addRequestPacket("req", paramIntent);
    paramPacket.setNoResponse();
    paramPacket.setTimeout(20000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mybusiness\MyBusinessServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */