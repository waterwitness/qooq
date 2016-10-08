import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mqs
  implements Runnable
{
  public mqs(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
    {
      localObject1 = ContactUtils.k(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    else
    {
      label109:
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 2)) {
          break label571;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      }
    }
    label472:
    label530:
    label571:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      this.a.app.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      localObject1 = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
      if (localObject1 != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((GroupCatalogBean)localObject1).a();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.g(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      str = null;
      Object localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject2 == null)
      {
        localObject2 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        localObject1 = str;
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
            break label472;
          }
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label530;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        localObject1 = str;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject2).nick;
          }
          else
          {
            localObject1 = str;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject2).name;
            }
          }
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        break label109;
      }
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      break label109;
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {}
    for (boolean bool = true;; bool = false)
    {
      ((TroopHandler)localObject1).b(str, bool);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */