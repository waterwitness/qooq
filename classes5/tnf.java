import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class tnf
  implements View.OnClickListener
{
  public tnf(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    if (localPicInfo == this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)
    {
      NearbyProfileEditPanel.a(this.a, true);
      return;
    }
    String[] arrayOfString = this.a.a.getResources().getStringArray(2131230742);
    ActionSheet localActionSheet = ActionSheet.a(this.a.a);
    localActionSheet.a(arrayOfString[22], 2130841021, 0);
    localActionSheet.c(arrayOfString[25]);
    localActionSheet.c(arrayOfString[26]);
    localActionSheet.c(arrayOfString[23]);
    if (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 2) {
      localActionSheet.a("删除头像", 3);
    }
    localActionSheet.d(arrayOfString[16]);
    localActionSheet.a(new tng(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
    ReportController.b(this.a.a.app, "dc00898", "", "", "0X8007115", "0X8007115", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */