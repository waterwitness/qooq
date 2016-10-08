import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mtd
  implements Runnable
{
  public mtd(TroopMemberCardActivity paramTroopMemberCardActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.getManager(51);
    if (localObject != null) {
      ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(this.jdField_a_of_type_JavaLangString, (byte)3, true);
    if ((localObject != null) || (0 != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.runOnUiThread(new mte(this, (Bitmap)localObject, null));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */