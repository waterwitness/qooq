import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.av.ui.MicSpeakerControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class guq
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  public guq(MicSpeakerControlUI paramMicSpeakerControlUI, int paramInt, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
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
      MicSpeakerControlUI.a(this.jdField_a_of_type_ComTencentAvUiMicSpeakerControlUI, this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */