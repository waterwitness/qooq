package cooperation.qzone.video;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
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
import cooperation.qzone.util.NetworkState;
import java.net.URLEncoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TcSdkDownloadReportServlet
  extends MSFServlet
{
  public static final String TAG = TcSdkDownloadReportServlet.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void report(Intent paramIntent, String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        String str1 = QzoneConfig.a().a("QZoneSetting", "TcSDKReportURL", "http://btrace.qq.com/kvcollect");
        String str2 = paramIntent.getStringExtra("uin");
        String str3 = QUA.a();
        String str4 = Build.MODEL;
        String str5 = Build.VERSION.RELEASE;
        paramIntent = paramIntent.getStringExtra("report_msg");
        int j;
        if (!NetworkState.d())
        {
          j = 0;
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          paramIntent = new TcSdkDownloadReportServlet.ReportRunnable(this, (str1 + "?BossId=3590&Pwd=1432018701" + "&userLocalIP=" + paramString + "&uin=" + str2 + "&apn=" + i + "&netStatus=" + j + "&deviceID=" + str4 + "&deviceOS=" + str5 + "&SDKReportDetailJSONStr=" + paramIntent + "&QUA=" + str3 + "&_dc=" + Math.random()).trim().replace(" ", ""));
          QzoneHandlerThreadFactory.a("BackGround_HandlerThread").a(paramIntent);
          return;
        }
        int k;
        switch (NetworkState.b())
        {
        case 1: 
          j = NetworkState.a();
          switch (j)
          {
          default: 
            k = 4;
            j = i;
            i = k;
            continue;
            i = 1;
          }
          break;
        case 3: 
          i = 2;
          break;
        case 2: 
          i = 3;
          break;
        case 4: 
          i = 4;
          continue;
          k = 1;
          j = i;
          i = k;
          continue;
          k = 2;
          j = i;
          i = k;
          continue;
          k = 3;
          j = i;
          i = k;
          continue;
          k = 5;
          j = i;
          i = k;
          break;
        default: 
          i = 5;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.w(TAG, 2, "", paramIntent);
        return;
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
          QLog.w(TAG, 2, "can not get ip address");
        }
        report(paramIntent, str1);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.w(TAG, 2, "", paramIntent);
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\TcSdkDownloadReportServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */