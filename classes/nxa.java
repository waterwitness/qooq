import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class nxa
  implements DialogInterface.OnClickListener
{
  public nxa(DeviceMsgChatPie paramDeviceMsgChatPie, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */