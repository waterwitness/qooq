import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfi
  implements View.OnClickListener
{
  public hfi(PoiMapActivity paramPoiMapActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.cancel();
    String str = this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getText().toString();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "click_sch_cancel", paramView, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */