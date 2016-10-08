import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;

class kon
  implements DialogInterface.OnClickListener
{
  kon(kom paramkom, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ApolloConstant.M + "&actionId=" + this.jdField_a_of_type_Int + "&_bid=2282";
    Intent localIntent = new Intent(this.jdField_a_of_type_Kom.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.jdField_a_of_type_Kom.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    VipUtils.a(this.jdField_a_of_type_Kom.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.a(this.jdField_a_of_type_Kom.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */