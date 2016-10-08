import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.GagMemInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager.MemberGagInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagTroopMemberResult;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagTroopResult;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mqj
  extends BizTroopObserver
{
  public mqj(TroopGagActivity paramTroopGagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus == null) || (!paramGagStatus.jdField_a_of_type_JavaLangString.equals(this.a.b))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + paramGagStatus.jdField_a_of_type_Int);
    }
    if (paramGagStatus.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (paramGagStatus.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramGagStatus = paramGagStatus.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramGagStatus.hasNext())
        {
          TroopManager.MemberGagInfo localMemberGagInfo = (TroopManager.MemberGagInfo)paramGagStatus.next();
          TroopGagActivity.GagMemInfo localGagMemInfo = new TroopGagActivity.GagMemInfo();
          localGagMemInfo.jdField_a_of_type_JavaLangString = localMemberGagInfo.jdField_a_of_type_JavaLangString;
          localGagMemInfo.jdField_a_of_type_Long = localMemberGagInfo.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
        }
      }
      this.a.jdField_a_of_type_Mqo.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (paramGagStatus.jdField_a_of_type_Int == 1)
      {
        paramGagStatus = paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$TroopGagInfo;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (paramGagStatus.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (paramGagStatus.jdField_a_of_type_Int == 5)
      {
        if (!paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagTroopMemberResult.jdField_a_of_type_Boolean) {
          ThreadManager.a(new mqk(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
      }
      else if (paramGagStatus.jdField_a_of_type_Int == 4)
      {
        paramGagStatus = paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagTroopResult;
        if (!paramGagStatus.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (paramGagStatus.jdField_a_of_type_Long != 0L) {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
          }
          for (;;)
          {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
            break;
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
          }
        }
      }
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */