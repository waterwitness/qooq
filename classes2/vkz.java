import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;

class vkz
  implements DialogInterface.OnClickListener
{
  vkz(vkx paramvkx, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Vkx.a.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    VideoRecordActivity.b(this.jdField_a_of_type_Vkx.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */