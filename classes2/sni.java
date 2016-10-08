import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class sni
  implements ActionSheet.OnButtonClickListener
{
  public sni(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard != null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.godFlag == 1) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      label67:
      if (paramInt != 0) {
        this.a.i();
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004444", "0X8004444", 2, 0, "", "", "", "");
        break;
        paramInt = 0;
        break label67;
        if ((NetworkUtil.e(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
        {
          MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
        }
        else
        {
          QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131367481), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
        }
      }
      paramInt = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */