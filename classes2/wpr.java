import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import org.json.JSONObject;

public class wpr
  implements DialogInterface.OnClickListener
{
  public wpr(AuthorityActivity paramAuthorityActivity, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */