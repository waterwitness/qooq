import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vwi
  implements ActionSheet.OnButtonClickListener
{
  public vwi(TroopShareUtility paramTroopShareUtility)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + paramInt);
    }
    this.a.c = true;
    switch (paramInt)
    {
    default: 
      this.a.jdField_a_of_type_Int = -1;
      this.a.jdField_b_of_type_Int = -1;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.jdField_b_of_type_Int = 1;
      TroopShareUtility.a(this.a);
      continue;
      this.a.jdField_b_of_type_Int = 0;
      TroopShareUtility.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */