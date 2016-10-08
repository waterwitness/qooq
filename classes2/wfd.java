import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class wfd
  implements BusinessObserver
{
  public wfd(HealthStepCounterPlugin paramHealthStepCounterPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    JSONObject localJSONObject;
    long l2;
    long l1;
    for (;;)
    {
      try
      {
        localObject = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        localJSONObject = new JSONObject();
        l2 = -1L;
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HealthStepCounterPlugin", 2, "SSO success!");
          }
          byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
          if (arrayOfByte != null)
          {
            WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
            localUniSsoServerRsp.mergeFrom(arrayOfByte);
            l1 = l2;
            if (localUniSsoServerRsp.comm.has())
            {
              paramBundle = paramBundle.getString("extra_cmd");
              l1 = l2;
              if (!TextUtils.isEmpty(paramBundle))
              {
                if (localUniSsoServerRsp.comm.delayms.has()) {
                  this.a.b.put(paramBundle, Long.valueOf(localUniSsoServerRsp.comm.delayms.get()));
                }
                if (localUniSsoServerRsp.comm.packagesize.has()) {
                  this.a.jdField_a_of_type_JavaUtilHashMap.put(paramBundle, Long.valueOf(localUniSsoServerRsp.comm.packagesize.get()));
                }
                l1 = l2;
                if (localUniSsoServerRsp.comm.proctime.has()) {
                  l1 = localUniSsoServerRsp.comm.proctime.get();
                }
              }
            }
            localJSONObject.put("ssoRet", 0);
            if (localUniSsoServerRsp.ret.has())
            {
              localJSONObject.put("businessRet", localUniSsoServerRsp.ret.get());
              if (!localUniSsoServerRsp.errmsg.has()) {
                break label569;
              }
              localJSONObject.put("msg", localUniSsoServerRsp.errmsg.get());
              l2 = l1;
              if (localUniSsoServerRsp.rspdata.has())
              {
                localJSONObject.put("data", localUniSsoServerRsp.rspdata.get());
                l2 = l1;
              }
              QLog.i("HealthStepCounterPlugin", 1, "result:" + localJSONObject.toString());
              if (!this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
                break label764;
              }
              this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
              localObject = new JSONObject();
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        label402:
        label440:
        if (!QLog.isColorLevel()) {
          break label960;
        }
      }
      try
      {
        if (!TextUtils.isEmpty(this.a.g)) {
          break;
        }
        paramBundle = "";
        ((JSONObject)localObject).put("msg", paramBundle);
        ((JSONObject)localObject).put("report_result", localJSONObject.toString());
        if (!TextUtils.isEmpty(this.a.h)) {
          break label753;
        }
        paramBundle = "";
        ((JSONObject)localObject).put("msf_json", paramBundle);
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "test result:" + ((JSONObject)localObject).toString());
      }
      if (TextUtils.isEmpty(this.a.f)) {
        break label960;
      }
      this.a.callJs(this.a.f, new String[] { ((JSONObject)localObject).toString() });
      return;
      QLog.e("HealthStepCounterPlugin", 2, "uniAgent, onReceive, Exception: " + paramBundle);
      return;
      localJSONObject.put("businessRet", 0);
      continue;
      label569:
      localJSONObject.put("msg", "SSO发送成功");
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("HealthStepCounterPlugin", 2, "uniAgent, onReceive, ret success but no data");
      }
      localJSONObject.put("ssoRet", 255);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "SSO返回数据包为空");
      continue;
      paramInt = paramBundle.getInt("extra_result_code");
      if (paramInt != 1001) {
        break label961;
      }
      localJSONObject.put("ssoRet", 201);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "MSF返回:发送失败");
    }
    for (;;)
    {
      label676:
      localJSONObject.put("ssoRet", 202);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "MSF返回:超时");
      break;
      label753:
      label764:
      label960:
      label961:
      do
      {
        localJSONObject.put("ssoRet", 255);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", "未知错误");
        break;
        paramBundle = this.a.g;
        break label402;
        paramBundle = this.a.h;
        break label440;
        WebSSOAgentServlet.d = System.currentTimeMillis();
        l1 = WebSSOAgentServlet.d;
        long l3 = WebSSOAgentServlet.a;
        long l4 = WebSSOAgentServlet.b - WebSSOAgentServlet.a;
        long l5 = WebSSOAgentServlet.c - WebSSOAgentServlet.b;
        long l6 = WebSSOAgentServlet.d - WebSSOAgentServlet.c;
        if (QLog.isColorLevel()) {
          QLog.d("HealthStepCounterPlugin", 2, "uniAgent, total=" + (l1 - l3) + ",pre=" + l4 + ",msf=" + l5 + ",after=" + l6);
        }
        paramBundle = new JSONObject();
        paramBundle.put("packTime", l4);
        paramBundle.put("SSONetworkTime", l5);
        paramBundle.put("unpackTime", l6);
        paramBundle.put("serverProcessTime", l2);
        localJSONObject.put("speedPoint", paramBundle);
        this.a.callJs((String)localObject, new String[] { localJSONObject.toString() });
        return;
        return;
        if (paramInt == 1002) {
          break label676;
        }
      } while (paramInt != 1013);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */