import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

public class mti
  implements TroopPluginManager.TroopPluginCallback
{
  public mti(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.l();
      if (this.a.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)
      {
        this.a.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
        String str = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied;
        if (TextUtils.isEmpty(str)) {
          break label119;
        }
        this.a.a(this.a.jdField_a_of_type_ArrayOfAndroidViewView[1], str, true);
        this.a.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(this.a.getString(2131364648) + str);
      }
    }
    return;
    label119:
    this.a.a(this.a.jdField_a_of_type_ArrayOfAndroidViewView[1], this.a.getString(2131365081), true);
    this.a.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(this.a.getString(2131364648) + this.a.getString(2131365081));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */