import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kxv
  implements DialogInterface.OnClickListener
{
  public kxv(ChatHistoryImageView paramChatHistoryImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.cancel();
      if (this.a.jdField_a_of_type_Kxx != null) {
        this.a.jdField_a_of_type_Kxx.a(false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */