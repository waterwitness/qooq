import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nzr
  implements DialogInterface.OnClickListener
{
  nzr(nzp paramnzp, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramDialogInterface.putLong("switch_city" + this.jdField_a_of_type_Nzp.a.a.a(), System.currentTimeMillis());
    paramDialogInterface.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */