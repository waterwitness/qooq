package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WebShareServlet
  extends MSFServlet
{
  public static final String a = "extra_cmd";
  public static final String b = "extra_current_uin";
  public static final String c = "extra_url";
  public static final String d = "extra_ret";
  public static final String e = "extra_title";
  public static final String f = "extra_summary";
  public static final String g = "extra_images";
  private static final String h = "WebShareServlet";
  
  public WebShareServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("WebShareServlet", 2, "onReceive, cmd=" + (String)localObject1);
    }
    if ("SQQzoneSvc.getUrlInfo".equals(localObject1))
    {
      Object localObject2 = paramFromServiceMsg.getWupBuffer();
      localObject1 = new Bundle();
      localObject2 = ProtocolUtils.a((byte[])localObject2, "getUrlInfo");
      if ((paramFromServiceMsg.isSuccess()) && ((localObject2 instanceof mobile_get_urlinfo_rsp)))
      {
        localObject2 = (mobile_get_urlinfo_rsp)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("WebShareServlet", 2, "onReceive, mobile_get_urlinfo_rsp, ret=" + ((mobile_get_urlinfo_rsp)localObject2).ret + ", title=" + ((mobile_get_urlinfo_rsp)localObject2).title + ", summary=" + ((mobile_get_urlinfo_rsp)localObject2).summary + ", images=" + ((mobile_get_urlinfo_rsp)localObject2).images);
        }
        ((Bundle)localObject1).putInt("extra_ret", ((mobile_get_urlinfo_rsp)localObject2).ret);
        ((Bundle)localObject1).putString("extra_title", ((mobile_get_urlinfo_rsp)localObject2).title);
        ((Bundle)localObject1).putString("extra_summary", ((mobile_get_urlinfo_rsp)localObject2).summary);
        ((Bundle)localObject1).putStringArrayList("extra_images", ((mobile_get_urlinfo_rsp)localObject2).images);
      }
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("extra_cmd");
    if (QLog.isColorLevel()) {
      QLog.d("WebShareServlet", 2, "onSend, cmd=" + str);
    }
    if ("SQQzoneSvc.getUrlInfo".equals(str))
    {
      paramIntent = paramIntent.getStringExtra("extra_url");
      if (QLog.isColorLevel()) {
        QLog.d("WebShareServlet", 2, "onSend, CMD_GET_URL_INFO, url=" + paramIntent);
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break label116;
      }
      paramIntent = new QzoneGetUrlInfoRequest(paramIntent).encode();
      paramPacket.setSSOCommand("SQQzoneSvc.getUrlInfo");
      paramPacket.putSendData(paramIntent);
    }
    label116:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("WebShareServlet", 2, "onSend, url is null!!!");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\WebShareServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */