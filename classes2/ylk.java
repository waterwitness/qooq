import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneHelper;

public final class ylk
  implements DialogInterface.OnClickListener
{
  public ylk(Activity paramActivity, int paramInt, String paramString, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!QZoneHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      QZoneHelper.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sid"), this.jdField_a_of_type_AndroidAppActivity);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */