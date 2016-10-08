import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class jhy
  implements BusinessObserver
{
  public jhy(SSOWebviewPlugin paramSSOWebviewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      long l1;
      try
      {
        String str = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localJSONObject = new JSONObject();
        long l2 = -1L;
        if (!paramBoolean) {
          break label933;
        }
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        if (arrayOfByte == null) {
          break label884;
        }
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        localUniSsoServerRsp.mergeFrom(arrayOfByte);
        l1 = l2;
        if (localUniSsoServerRsp.comm.has())
        {
          paramBundle = paramBundle.getString("extra_cmd");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, cmd=" + paramBundle);
          }
          l1 = l2;
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (localUniSsoServerRsp.comm.delayms.has())
            {
              l1 = Long.valueOf(localUniSsoServerRsp.comm.delayms.get()).longValue();
              if (l1 != 0L) {
                break label838;
              }
              this.a.e.put(paramBundle, Integer.valueOf(Integer.MAX_VALUE));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, delay=" + l1 + ", cmd:" + paramBundle);
              }
            }
            if (localUniSsoServerRsp.comm.packagesize.has())
            {
              l1 = Long.valueOf(localUniSsoServerRsp.comm.packagesize.get()).longValue();
              this.a.b.put(paramBundle, Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, pkgSize=" + l1);
              }
            }
            l1 = l2;
            if (localUniSsoServerRsp.comm.proctime.has())
            {
              l2 = localUniSsoServerRsp.comm.proctime.get();
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, svrCostTime=" + l2);
                l1 = l2;
              }
            }
          }
        }
        localJSONObject.put("ssoRet", 0);
        if (!localUniSsoServerRsp.ret.has()) {
          break label859;
        }
        l2 = localUniSsoServerRsp.ret.get();
        localJSONObject.put("businessRet", l2);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, biz ret code=" + l2);
        }
        if (!localUniSsoServerRsp.errmsg.has()) {
          break label871;
        }
        paramBundle = localUniSsoServerRsp.errmsg.get();
        localJSONObject.put("msg", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, errmsg=" + paramBundle);
        }
        l2 = l1;
        if (localUniSsoServerRsp.rspdata.has())
        {
          paramBundle = localUniSsoServerRsp.rspdata.get();
          localJSONObject.put("data", paramBundle);
          l2 = l1;
          if (QLog.isColorLevel())
          {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, rspData=" + paramBundle);
            l2 = l1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, callback Json string=" + localJSONObject.toString());
        }
        WebSSOAgentServlet.d = System.currentTimeMillis();
        l1 = WebSSOAgentServlet.d;
        long l3 = WebSSOAgentServlet.a;
        long l4 = WebSSOAgentServlet.b - WebSSOAgentServlet.a;
        long l5 = WebSSOAgentServlet.c - WebSSOAgentServlet.b;
        long l6 = WebSSOAgentServlet.d - WebSSOAgentServlet.c;
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, total=" + (l1 - l3) + ",pre=" + l4 + ",msf=" + l5 + ",after=" + l6);
        }
        paramBundle = new JSONObject();
        paramBundle.put("packTime", l4);
        paramBundle.put("SSONetworkTime", l5);
        paramBundle.put("unpackTime", l6);
        paramBundle.put("serverProcessTime", l2);
        localJSONObject.put("speedPoint", paramBundle);
        this.a.callJs(str, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.e("SSOWebviewPlugin", 2, "uniAgent, onReceive, Exception: " + paramBundle);
      return;
      label838:
      this.a.e.put(paramBundle, Integer.valueOf((int)l1));
      continue;
      label859:
      localJSONObject.put("businessRet", 0);
      continue;
      label871:
      localJSONObject.put("msg", "SSO发送成功");
      continue;
      label884:
      if (QLog.isColorLevel()) {
        QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
      }
      localJSONObject.put("ssoRet", 255);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "SSO返回数据包为空");
      continue;
      label933:
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "uniAgent, msfResultCode=" + paramInt);
      }
      if (paramInt != 1001) {
        break label1083;
      }
      localJSONObject.put("ssoRet", 201);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "MSF返回:发送失败");
    }
    for (;;)
    {
      label1014:
      localJSONObject.put("ssoRet", 202);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "MSF返回:超时");
      break;
      label1083:
      do
      {
        localJSONObject.put("ssoRet", 255);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", "未知错误");
        break;
        return;
        if (paramInt == 1002) {
          break label1014;
        }
      } while (paramInt != 1013);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */