package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

class VasWebReport$1
  implements Runnable
{
  VasWebReport$1(VasWebReport paramVasWebReport, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.this$0.monitorH5Report(this.val$jsonObject, this.val$urlString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasWebReport$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */