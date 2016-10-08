import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgItemBuilder;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hdk
  implements View.OnClickListener
{
  public hdk(BitAppMsgItemBuilder paramBitAppMsgItemBuilder, MessageForBitApp paramMessageForBitApp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBitappMessageForBitApp != null) && (this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg != null))
    {
      BitAppMsgItemBuilder.a(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder, (Activity)this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
      ReportController.b(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBitappMessageForBitApp.frienduin, "0X8006376", "0X8006376", 0, 0, "" + this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.getMsgId(), "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */