import android.content.Intent;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lho
  implements Runnable
{
  lho(lhm paramlhm, TroopMemberCard paramTroopMemberCard)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card);
      this.jdField_a_of_type_Lhm.a.setResult(-1, localIntent);
      EditInfoActivity.e(this.jdField_a_of_type_Lhm.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */