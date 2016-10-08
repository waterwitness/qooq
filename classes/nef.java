import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.HbThemeConfigManager.HBThemeConfig;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

public class nef
  implements ActionSheet.OnButtonClickListener
{
  public nef(PlusPanelUtils paramPlusPanelUtils, List paramList1, QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, List paramList2, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelUtils.a();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    for (;;)
    {
      try
      {
        if (((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second == null) {
          break;
        }
        long l = System.currentTimeMillis();
        if (Math.abs(l - this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelUtils.a) < 1000L) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelUtils.a = l;
        paramInt = ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue();
        if (paramInt == PlusPanelUtils.m)
        {
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, 1);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
        }
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (paramInt == PlusPanelUtils.n) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelUtils.a();
      } else {
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (HbThemeConfigManager.HBThemeConfig)this.b.get(paramInt), 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */