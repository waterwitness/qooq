import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.dingdong.DingdongJsApiPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class yaq
  implements ActionSheet.OnButtonClickListener
{
  public yaq(DingdongJsApiPlugin paramDingdongJsApiPlugin, ActionSheet paramActionSheet, JSONArray paramJSONArray, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(paramInt);
    if (paramView != null) {}
    switch (paramView.optInt("id"))
    {
    default: 
      this.jdField_a_of_type_CooperationDingdongDingdongJsApiPlugin.callJs(paramView.optString("callback", null), new String[] { "" });
      return;
    }
    DingdongJsApiPlugin.a(this.jdField_a_of_type_CooperationDingdongDingdongJsApiPlugin, paramView.optString("callback", null));
    DingdongJsApiPlugin.a(this.jdField_a_of_type_CooperationDingdongDingdongJsApiPlugin, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */