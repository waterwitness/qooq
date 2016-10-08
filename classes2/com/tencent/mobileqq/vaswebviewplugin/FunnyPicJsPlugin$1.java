package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

class FunnyPicJsPlugin$1
  implements BusinessObserver
{
  FunnyPicJsPlugin$1(FunnyPicJsPlugin paramFunnyPicJsPlugin, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        if (paramBundle == null) {
          break label330;
        }
        Object localObject = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramBundle);
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.has()) {
          break label330;
        }
        paramBundle = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get()).getJSONArray("rstList");
        if (paramBundle.length() <= 0) {
          break label330;
        }
        paramBundle = paramBundle.getJSONObject(0);
        String str1 = paramBundle.optString("appid");
        String str2 = paramBundle.optString("itemid");
        localObject = paramBundle.optString("authRst");
        if (("0".equals(localObject)) && ("10".equals(str1)) && (this.val$pkgStr.equals(str2)))
        {
          this.this$0.mReqBundle.clear();
          this.this$0.mReqBundle.putString("jsonContent", this.val$jsonStr);
          this.this$0.mReqBundle.putInt("action", this.val$action);
          localObject = DataFactory.a("ipc_funnypic_add", this.val$innerCallBackId, this.this$0.mOnRemoteResp.key, this.this$0.mReqBundle);
          FunnyPicJsPlugin.access$001(this.this$0, (Bundle)localObject, true, true);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("FunnyPicJsPlugin", 2, "authRst->" + paramBundle);
          return;
        }
        paramBundle = new JSONObject();
        paramBundle.put("result", 1);
        paramBundle.put("authRst", localObject);
        FunnyPicJsPlugin.access$101(this.this$0, this.val$innerCallBackId + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.i("FunnyPicJsPlugin", 2, paramBundle.getMessage());
      return;
    }
    label330:
    paramBundle = new JSONObject();
    paramBundle.put("result", 1);
    FunnyPicJsPlugin.access$201(this.this$0, this.val$innerCallBackId + "(" + paramBundle.toString() + ");");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\FunnyPicJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */