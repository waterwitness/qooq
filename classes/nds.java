import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nds
  implements ActionSheet.OnButtonClickListener
{
  public nds(PlusPanel paramPlusPanel, boolean paramBoolean, ActionSheet paramActionSheet)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        PlusPanelUtils.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a());
        if (PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel) != null) {
          PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a().setCanLock(false);
        }
      }
    }
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131367256, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492908));
      return;
    }
    paramView = ((TroopManager)PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).getManager(51)).d(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a);
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      TroopMemberLbsHelper.a(paramView, bool, PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getContext());
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */