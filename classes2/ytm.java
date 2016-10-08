import android.app.Dialog;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop.TroopMemberCardProxyActivity;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;
import java.io.Serializable;
import java.util.ArrayList;

class ytm
  implements TroopPluginManager.TroopPluginCallback
{
  ytm(ytl paramytl, Object[] paramArrayOfObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("troopUin", this.jdField_a_of_type_Ytl.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("memberUin", this.jdField_a_of_type_Ytl.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("fromFlag", this.jdField_a_of_type_Ytl.jdField_a_of_type_Int);
      localIntent.putExtra("troopCode", this.jdField_a_of_type_Ytl.c);
      localIntent.putExtra("troopName", this.jdField_a_of_type_Ytl.d);
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Ytl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      Object localObject1 = localTroopManager.a(this.jdField_a_of_type_Ytl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ytl.jdField_b_of_type_JavaLangString);
      Object localObject2 = (TroopMemberCard)this.jdField_a_of_type_ArrayOfJavaLangObject[2];
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        localIntent.putExtra("troopMemberCard", (Serializable)localObject1);
        localIntent.putExtra("hwCard", localTroopManager.a(this.jdField_a_of_type_Ytl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ytl.jdField_b_of_type_JavaLangString));
        localIntent.putExtra("isOrgMgr", false);
        localIntent.putExtra("isHisMgr", true);
        localIntent.putExtra("hasOrgs", true);
        localObject2 = new ArrayList();
        paramInt = 0;
        while (paramInt < ((TroopMemberCard)localObject1).mOrgIds.size())
        {
          ((ArrayList)localObject2).add(((String)((TroopMemberCard)localObject1).mOrgIds.get(paramInt)).substring(this.jdField_a_of_type_Ytl.jdField_a_of_type_JavaLangString.length()));
          paramInt += 1;
        }
      }
      this.jdField_a_of_type_Ytl.jdField_a_of_type_AndroidAppDialog.dismiss();
      QQToast.a(BaseApplicationImpl.a(), "加载失败，请稍后再试!", 0).a();
      return;
      localIntent.putExtra("orgIds", (Serializable)localObject2);
      TroopMemberCardProxyActivity.a(this.jdField_a_of_type_Ytl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_member_card_plugin.apk", "群名片", TroopMemberCardProxyActivity.class, this.jdField_a_of_type_Ytl.jdField_a_of_type_AndroidAppActivity, localIntent, this.jdField_a_of_type_Ytl.jdField_a_of_type_AndroidAppDialog, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_Ytl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_Ytl.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Ytl.jdField_a_of_type_AndroidAppDialog.dismiss();
    QQToast.a(BaseApplicationImpl.a(), "加载失败，请稍后再试!", 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */