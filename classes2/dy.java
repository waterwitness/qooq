import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class dy
  implements DialogInterface.OnClickListener
{
  dy(dx paramdx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord.status < 3) {
      this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord);
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.b();
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */