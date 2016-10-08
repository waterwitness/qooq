package cooperation.qzone.report;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.util.NetworkState;
import java.net.URLEncoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneMonitorH5ReportServlet
  extends MSFServlet
{
  public static final String a = "QZoneMonitorH5ReportServlet";
  
  public QZoneMonitorH5ReportServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    int j = paramString.length();
    int i = 0;
    while (i < 10 - j)
    {
      localStringBuilder.append("0");
      i += 1;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        paramIntent = paramIntent.getBundleExtra("bundle");
        if (paramIntent == null) {
          return;
        }
        int m = paramIntent.getInt("errorcode", 0);
        String str1 = paramIntent.getString("uin");
        if (m == 0)
        {
          k = QzoneConfig.a().a("ReportSetting", "MonitorH5ReportSamples", 10);
          long l1 = QZoneClickReport.getDaysSince1970();
          long l2 = Long.parseLong(str1);
          j = 0;
          if (k <= 1) {
            break label679;
          }
          int n = (int)(l1 % k);
          if (n != l2 % k) {
            break label673;
          }
          i = 1;
          j = i;
          if (QLog.isDevelopLevel())
          {
            QLog.d("QZoneMonitorH5ReportServlet", 4, "抽中的尾数： " + n);
            j = i;
          }
          if (j == 0) {
            break label743;
          }
          String str2 = QUA.a();
          Object localObject = paramIntent.getString("url");
          l1 = paramIntent.getLong("time", 0L);
          l2 = paramIntent.getLong("first_word", 0L);
          long l3 = paramIntent.getLong("first_screen", 0L);
          long l4 = paramIntent.getLong("page_finish", 0L);
          long l5 = paramIntent.getLong("dns_start", 0L);
          long l6 = paramIntent.getLong("dns_end", 0L);
          long l7 = paramIntent.getLong("connect_start", 0L);
          long l8 = paramIntent.getLong("connect_end", 0L);
          long l9 = paramIntent.getLong("ssl_handshake_start", 0L);
          long l10 = paramIntent.getLong("ssl_handshake_end", 0L);
          long l11 = paramIntent.getLong("send_start", 0L);
          long l12 = paramIntent.getLong("send_end", 0L);
          long l13 = paramIntent.getLong("recv_start", 0L);
          long l14 = paramIntent.getLong("recv_end", 0L);
          long l15 = paramIntent.getLong("expired_time", 0L);
          boolean bool = paramIntent.getBoolean("cached", false);
          j = paramIntent.getInt("cipher_suit", 0);
          if (m != -7) {
            break label737;
          }
          i = 1;
          if (NetworkState.d()) {
            break label691;
          }
          paramIntent = "NotNetWork";
          localObject = URLEncoder.encode((String)localObject, "UTF-8");
          localObject = new StringBuilder().append("http://h5.qzone.qq.com/statistics/webview").append("?uin=").append(str1).append("&url=").append((String)localObject).append("&errorcode=").append(m).append("&timeout=");
          if (i == 0) {
            break label731;
          }
          i = 1;
          paramIntent = new QZoneMonitorH5ReportServlet.ReportRunnable(this, (i + "&ip=" + paramString + "&apn=" + paramIntent + "&time=" + l1 + "&app=" + "qq" + "&app_version=" + str2 + "&platform=" + "android" + "&sampling=" + k + "&first_word=" + l2 + "&first_screen=" + l3 + "&page_finish=" + l4 + "&dns_start=" + l5 + "&dns_end=" + l6 + "&connect_start=" + l7 + "&connect_end=" + l8 + "&ssl_handshake_start=" + l9 + "&ssl_handshake_end=" + l10 + "&send_start=" + l11 + "&send_end=" + l12 + "&recv_start=" + l13 + "&recv_end=" + l14 + "&expired_time=" + l15 + "&cached=" + bool + "&cipher_suit=" + j).trim().replace(" ", ""), str1);
          QzoneHandlerThreadFactory.a("BackGround_HandlerThread").a(paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.w("QZoneMonitorH5ReportServlet", 2, "", paramIntent);
        return;
      }
      int k = 1;
      continue;
      label673:
      int i = 0;
      continue;
      label679:
      if (k == 1)
      {
        j = 1;
        continue;
        switch (NetworkState.b())
        {
        case 4: 
          paramIntent = "4g";
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          return;
        default: 
          paramIntent = "NetWorkTypeUnknow";
          break;
        case 1: 
          paramIntent = "wifi";
          break;
        case 3: 
          paramIntent = "2g";
          break;
        case 2: 
          label691:
          label731:
          label737:
          label743:
          paramIntent = "3g";
        }
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      String str2 = paramFromServiceMsg.getServiceCmd();
      String str1 = "";
      if (paramIntent != null)
      {
        if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(str2)) {
          str1 = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
        }
        if (TextUtils.isEmpty(str1)) {
          QLog.w("QZoneMonitorH5ReportServlet", 2, "can not get ip address");
        }
        a(paramIntent, str1);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.w("QZoneMonitorH5ReportServlet", 2, "", paramIntent);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
    paramPacket.setTimeout(30000L);
    paramPacket.setNeedCallback(true);
    paramPacket.setNeedRemindSlowNetwork(false);
    sendToMSF(paramIntent, paramPacket);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\report\QZoneMonitorH5ReportServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */