import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class tnh
  implements View.OnClickListener
{
  public tnh(NearbyProfileEditPanel paramNearbyProfileEditPanel)
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
      NearbyProfileEditPanel.a(this.a, false);
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this.a.a);
    localActionSheet.c("设为头像");
    localActionSheet.c("查看大图");
    if (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 2) {
      localActionSheet.a("删除照片", 3);
    }
    localActionSheet.d(2131367262);
    localActionSheet.a(new tni(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */