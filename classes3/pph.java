import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class pph
  implements View.OnClickListener
{
  public pph(TroopListAdapter2 paramTroopListAdapter2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.c();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).c();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopInfo)) {
      return;
    }
    localObject = (TroopInfo)paramView;
    boolean bool = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(((TroopInfo)localObject).troopuin);
    if (bool) {}
    for (paramView = "Clk_uncommgrp";; paramView = "Clk_setcommgrp")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", paramView, 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
      if ((NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext) != 0) || (!(this.a.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break;
      }
      paramView = (BaseActivity)this.a.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramView, 2131364258, 0).b(paramView.getTitleBarHeight());
      return;
    }
    paramView = (BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    if (bool) {
      i = 1;
    }
    paramView.a(((TroopInfo)localObject).troopcode, i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */