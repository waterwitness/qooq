import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Arrays;

public class kkz
  implements View.OnClickListener
{
  public kkz(AuthDevActivity paramAuthDevActivity, RelativeLayout paramRelativeLayout, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView.stDeviceItemDes);
    if (Arrays.equals(NetConnInfoCenter.GUID, paramView.vecGuid)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      AuthDevActivity localAuthDevActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
      String str1 = paramView.strDeviceName;
      String str2 = AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
      int i = this.jdField_a_of_type_Int;
      if (paramView.iLoginPlatform == 3L) {}
      for (;;)
      {
        AuthDevActivity.a(localAuthDevActivity, str1, localArrayList, str2, i, bool2, bool1, paramView.iAppId);
        return;
        bool2 = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */