import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gie
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public gie(GaInviteActivity paramGaInviteActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.n()) {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.g(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.b();
        break;
        if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.e) {
          this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.y();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.c != 1)
      {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
        continue;
        if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.c != 1) {
          this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */