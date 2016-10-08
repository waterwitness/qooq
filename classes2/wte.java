import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class wte
  implements Runnable
{
  public wte(BaseJsCallBack paramBaseJsCallBack, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localBundle.putString("iconType", localJSONObject.optString("iconType"));
      localBundle.putString("visible", localJSONObject.optString("visible"));
      localBundle.putString("callBackKey", localJSONObject.optString("callBackKey"));
      localBundle.putString("rightText", localJSONObject.optString("text"));
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity instanceof AppViewBaseActivity)) {
        ((AppViewBaseActivity)this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity).b(localBundle);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */