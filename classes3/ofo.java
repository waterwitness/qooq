import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

public class ofo
  implements ActionSheet.OnButtonClickListener
{
  public ofo(BlessBaseActivity paramBlessBaseActivity, List paramList, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity.z();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      return;
      try
      {
        BlessBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessBaseActivity, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (String)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Throwable paramView) {}
    } while (!QLog.isColorLevel());
    QLog.d(BlessBaseActivity.n, 2, "execute exception " + paramView.getMessage());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */