import android.content.Context;
import android.os.Bundle;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class hax
  implements HttpWebCgiAsyncTask.Callback
{
  public hax(QQProgressDialog paramQQProgressDialog, Context paramContext, String paramString, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    String str = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (paramInt != 2134) {
      return;
    }
    if (paramJSONObject != null)
    {
      Object localObject;
      boolean bool;
      for (;;)
      {
        try
        {
          localObject = paramJSONObject.getJSONObject("data");
          bool = ((JSONObject)localObject).getBoolean("update");
          if (bool)
          {
            paramBundle = ((JSONObject)localObject).getString("title");
            str = ((JSONObject)localObject).getString("tips");
            GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, paramBundle, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
            localObject = (hba)GVideoUpdateUtil.a.get(this.jdField_a_of_type_JavaLangString);
            if (localObject != null) {
              break;
            }
            localObject = new hba();
            ((hba)localObject).a(System.currentTimeMillis(), paramBundle, str, bool);
            GVideoUpdateUtil.a.put(this.jdField_a_of_type_JavaLangString, localObject);
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          paramJSONObject.optInt("errCode");
          GVideoUpdateUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        paramBundle = null;
      }
      ((hba)localObject).a(System.currentTimeMillis(), paramBundle, str, bool);
      return;
    }
    GVideoUpdateUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */