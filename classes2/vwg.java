import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vwg
  implements ActionSheet.OnButtonClickListener
{
  public vwg(TroopShareUtility paramTroopShareUtility)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    this.a.jdField_a_of_type_Int = -1;
    this.a.jdField_b_of_type_Int = -1;
    this.a.jdField_b_of_type_Boolean = true;
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */