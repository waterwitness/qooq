import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class vwe
  implements AdapterView.OnItemClickListener
{
  public vwe(TroopShareUtility paramTroopShareUtility)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 1;
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131369529;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.b = -1;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        }
      }
      do
      {
        return;
        if (WXShareHelper.a().b()) {
          break label420;
        }
        i = 2131369530;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
        }
        this.a.jdField_a_of_type_Int = ((int)paramLong);
        if ((this.a.jdField_a_of_type_Int != 5) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
          break label255;
        }
        this.a.h();
      } while (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
      ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      return;
      label255:
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          this.a.jdField_a_of_type_Boolean = true;
        }
        if ((TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512)))
        {
          paramInt = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) {
            break label369;
          }
        }
        label369:
        for (i = j;; i = 0)
        {
          if ((paramInt | i) == 0) {
            break label375;
          }
          this.a.c();
          return;
          paramInt = 0;
          break;
        }
        label375:
        this.a.e();
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        this.a.jdField_a_of_type_Boolean = false;
      }
      this.a.b = 0;
      TroopShareUtility.a(this.a);
      return;
      label420:
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */