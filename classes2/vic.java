import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.UserInvokeAction;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public final class vic
  implements DialogInterface.OnClickListener
{
  public vic(Bundle paramBundle, int paramInt, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopBarPublishUtils.a().a();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_AndroidOsBundle.getString("pid") == null) {}
      for (paramDialogInterface = "pub_page_new";; paramDialogInterface = "reply_page_new")
      {
        TroopBarUtils.b(paramDialogInterface, "Clk_cancel", this.jdField_a_of_type_AndroidOsBundle.getString("bid"), "", "", "");
        return;
      }
    }
    paramDialogInterface.dismiss();
    TroopBarPublishUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */