import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ktd
  implements DialogInterface.OnClickListener
{
  public ktd(ChatActivityUtils.StartVideoListener paramStartVideoListener, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.a();
    }
    paramDialogInterface.dismiss();
    DataReport.b(this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ktd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */