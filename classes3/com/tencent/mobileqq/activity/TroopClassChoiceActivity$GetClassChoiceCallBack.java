package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import mpz;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopClassChoiceActivity$GetClassChoiceCallBack
  implements HttpCgiAsyncTask.Callback
{
  protected TroopClassChoiceActivity$GetClassChoiceCallBack(TroopClassChoiceActivity paramTroopClassChoiceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, paramException.getMessage());
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "result " + paramJSONObject);
    }
    try
    {
      paramJSONObject = (InputStream)paramJSONObject.get("content");
      if ((paramJSONObject != null) && (GroupCatalogTool.a(this.a).a(this.a, paramJSONObject)))
      {
        this.a.a = GroupCatalogTool.a(this.a).b(this.a, TroopClassChoiceActivity.a(this.a));
        this.a.runOnUiThread(new mpz(this));
        GroupCatalogTool.a(this.a).a(this.a, System.currentTimeMillis());
        boolean bool = GroupCatalogTool.a(this.a).a(this.a);
        if ((!bool) && (QLog.isColorLevel())) {
          QLog.d("IphoneTitleBarActivity", 2, "isMoveSuccess " + bool);
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopClassChoiceActivity$GetClassChoiceCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */