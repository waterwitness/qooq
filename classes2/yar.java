import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongJsApiPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class yar
  implements View.OnClickListener
{
  public yar(DingdongJsApiPlugin paramDingdongJsApiPlugin, long paramLong, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    DingdongJsApiPlugin.a(this.jdField_a_of_type_CooperationDingdongDingdongJsApiPlugin, this.jdField_a_of_type_Long, this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_OrgJsonJSONObject.optString("cancelCallback"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */