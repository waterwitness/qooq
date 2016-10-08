import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.RoamSettingController;
import java.util.List;

public class mpo
  implements View.OnClickListener
{
  public mpo(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      ReportController.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_confirm", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.a.app.getManager(30));
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(2130838321, 0, 0, 0);
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        paramView = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
        this.a.a(paramView, 4);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */