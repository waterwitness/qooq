import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class wpi
  implements DialogInterface.OnClickListener
{
  public wpi(MSFIntChkStrike paramMSFIntChkStrike, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MSFIntChkStrike.a(this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFIntChkStrike, paramDialogInterface, paramInt, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */