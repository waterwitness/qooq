import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class wfg
  implements BusinessObserver
{
  public wfg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = -1;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "SSO sent Success!!");
      }
      paramInt = i;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        paramInt = i;
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        if (arrayOfByte != null)
        {
          paramInt = i;
          WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
          paramInt = i;
          localUniSsoServerRsp.mergeFrom(arrayOfByte);
          paramInt = i;
          if (localUniSsoServerRsp.comm.has())
          {
            paramInt = i;
            paramBundle.getString("extra_cmd");
          }
          paramInt = i;
          ((JSONObject)localObject).put("ssoRet", 0);
          paramInt = i;
          if (localUniSsoServerRsp.ret.has())
          {
            paramInt = i;
            ((JSONObject)localObject).put("businessRet", localUniSsoServerRsp.ret.get());
            paramInt = i;
            if (!localUniSsoServerRsp.errmsg.has()) {
              break label526;
            }
            paramInt = i;
            ((JSONObject)localObject).put("msg", localUniSsoServerRsp.errmsg.get());
            paramInt = i;
            if (localUniSsoServerRsp.rspdata.has())
            {
              paramInt = i;
              ((JSONObject)localObject).put("data", localUniSsoServerRsp.rspdata.get());
            }
            paramInt = i;
            QLog.i("SSOHttpUtils", 1, "result:" + ((JSONObject)localObject).toString());
            paramInt = i;
            localObject = new JSONObject(((JSONObject)localObject).getString("data"));
            paramInt = i;
            paramBundle = new JSONObject(((JSONObject)localObject).getString("content"));
            paramInt = i;
            i = paramBundle.optInt("ret");
            paramInt = i;
            paramBundle = paramBundle.optString("msg");
            if (i != 0) {
              break label584;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        paramBundle = "";
      }
      try
      {
        localObject = new NewIntent(BaseApplicationImpl.a(), StepCounterServlert.class);
        ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_update_lastreport_time");
        ((NewIntent)localObject).putExtra("last_report_time", new Long(System.currentTimeMillis()));
        ((NewIntent)localObject).putExtra("has_report_yes", new Boolean(SSOHttpUtils.jdField_a_of_type_Boolean));
        BaseApplicationImpl.a().a().startServlet((NewIntent)localObject);
        SSOHttpUtils.jdField_a_of_type_Float = SSOHttpUtils.d - SSOHttpUtils.e + SSOHttpUtils.f;
        localObject = BaseApplicationImpl.a().a().getAccount();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          SSOHttpUtils.jdField_a_of_type_JavaLangString = (String)localObject;
        }
        SSOHttpUtils.jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.i("SSOHttpUtils", 1, "SSOHttpUtils do report success steps:" + SSOHttpUtils.jdField_a_of_type_Float);
        localObject = paramBundle;
        SSOHttpUtils.a(i, (String)localObject);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramInt = i;
        }
      }
      paramInt = i;
      ((JSONObject)localObject).put("businessRet", 0);
      continue;
      Object localObject = paramBundle;
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.e("SSOHttpUtils", 2, "Exception:" + localException1.getMessage());
        localObject = paramBundle;
        i = paramInt;
        continue;
        label526:
        paramInt = i;
        ((JSONObject)localObject).put("msg", "SSO发送成功");
        continue;
        paramInt = i;
        ((JSONObject)localObject).put("ssoRet", 255);
        paramInt = i;
        ((JSONObject)localObject).put("businessRet", 0);
        paramInt = i;
        ((JSONObject)localObject).put("msg", "SSO返回数据包为空");
        continue;
        label584:
        QLog.i("SSOHttpUtils", 1, "SSOHttpUtils do report failed:" + ((JSONObject)localObject).toString());
        localObject = paramBundle;
        continue;
        QLog.i("SSOHttpUtils", 1, "SSO sent Failed!!" + paramBundle.toString());
        localObject = paramBundle.toString();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */