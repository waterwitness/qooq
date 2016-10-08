package com.tencent.mobileqq.activity;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import law;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatSettingForTroop$GetClassChoiceCallBack
  implements HttpCgiAsyncTask.Callback
{
  public Context a;
  public String a;
  
  public ChatSettingForTroop$GetClassChoiceCallBack(Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, paramException.getMessage());
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "result " + paramJSONObject);
    }
    try
    {
      ThreadManager.a(new law(this, (InputStream)paramJSONObject.get("content")), 5, null, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatSettingForTroop$GetClassChoiceCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */