package cooperation.qqwifi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.qcard.QQCardService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;
import qqwifi.MQQ.ContentRequest;
import qqwifi.MQQ.ContentResponse;

public class VacContentServlet
  extends MSFServlet
{
  public static final int a = 2;
  public static final String a = "VacContentServlet";
  public static final int b = 8;
  public static final String b = "vac_content";
  public static final String c = "qqcard";
  public static final String d = "MQQ.AsyncContentMgrServer.AsyncContentMgrObj";
  public static final String e = "getContentList";
  public static final String f = "QQWifiSvc.getContentList";
  public static final String g = "key_data";
  public static final String h = "content_id";
  
  public VacContentServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("vac_content", i).getString(paramString, "");
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    Object localObject;
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = (ContentResponse)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ContentResponse());
      if ((localObject == null) || (((ContentResponse)localObject).ret != 0)) {
        break label226;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VacContentServlet", 2, "onGetQQCardInfo, " + ((ContentResponse)localObject).resource);
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(((ContentResponse)localObject).resource).getJSONArray("resource").getJSONObject(0).toString();
        localBundle.putString("key_data", (String)localObject);
        i = j;
      }
      catch (Exception localException1)
      {
        try
        {
          a("qqcard", (String)localObject);
          i = 0;
          if ((!paramFromServiceMsg.isSuccess()) || (i != 0)) {
            break label232;
          }
          bool = true;
          notifyObserver(paramIntent, 8, bool, localBundle, null);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            boolean bool;
            int j = 0;
          }
        }
        localException1 = localException1;
        j = -1;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("VacContentServlet", 2, "", localException1);
        i = j;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("VacContentServlet", 2, "onReceivePayOrder failed, " + paramFromServiceMsg.getBusinessFailCode() + "," + paramFromServiceMsg.getBusinessFailMsg());
        }
        label226:
        i = -1;
        continue;
        label232:
        bool = false;
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VacContentServlet", 2, "onGetNotificationBarActivityInfo");
    }
    paramFromServiceMsg = (ContentResponse)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ContentResponse());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.ret == 0)) {}
    try
    {
      Object localObject = new JSONObject(paramFromServiceMsg.resource).getJSONArray("resource");
      if (QLog.isColorLevel()) {
        QLog.d("VacContentServlet", 2, "resource=" + paramFromServiceMsg.resource);
      }
      paramFromServiceMsg = ((JSONArray)localObject).getJSONObject(0);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        ((BaseApplication)localObject).getSharedPreferences("qqwifi", i).edit().putInt("BarOperation_id", paramFromServiceMsg.getInt("id")).putInt("BarOperation_type", paramFromServiceMsg.getInt("type")).putString("BarOperation_url", URLDecoder.decode(paramFromServiceMsg.getString("url"), "UTF-8")).putLong("BarOperation_expiry", paramFromServiceMsg.getLong("expiry")).commit();
        return;
      }
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localBaseApplication.getSharedPreferences("vac_content", i).edit().putString(paramString1, paramString2).commit();
      return;
    }
  }
  
  private void a(Packet paramPacket)
  {
    ContentRequest localContentRequest = new ContentRequest(2L, QQCardService.a(), "6.5.5");
    paramPacket.setSSOCommand("QQWifiSvc.getContentList");
    paramPacket.setServantName("MQQ.AsyncContentMgrServer.AsyncContentMgrObj");
    paramPacket.setFuncName("getContentList");
    paramPacket.setTimeout(20000L);
    paramPacket.addRequestPacket("req", localContentRequest);
  }
  
  private void b(Packet paramPacket)
  {
    ContentRequest localContentRequest = new ContentRequest(8L, QQCardService.a(), "6.5.5");
    paramPacket.setSSOCommand("QQWifiSvc.getContentList");
    paramPacket.setServantName("MQQ.AsyncContentMgrServer.AsyncContentMgrObj");
    paramPacket.setFuncName("getContentList");
    paramPacket.setTimeout(20000L);
    paramPacket.addRequestPacket("req", localContentRequest);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VacContentServlet", 2, "onReceive, " + paramFromServiceMsg.getServiceCmd());
    }
    int i;
    if ("QQWifiSvc.getContentList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      i = paramIntent.getIntExtra("content_id", -1);
      if (i != 2) {
        break label66;
      }
      a(paramFromServiceMsg);
    }
    label66:
    while (i != 8) {
      return;
    }
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra("content_id", -1))
    {
    default: 
      return;
    case 2: 
      a(paramPacket);
      return;
    }
    b(paramPacket);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\VacContentServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */