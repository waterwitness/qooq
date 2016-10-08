import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView.UpdateProfileSetCardTask;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class tws
  implements Runnable
{
  public tws(ProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, ProfileHeaderView paramProfileHeaderView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap != null)
      {
        ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131296913);
        ImageView localImageView = (ImageView)localView.findViewById(2131303324);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131371094));
        localImageView.setContentDescription(localResources.getString(2131371094));
        localView.setTag(new DataTag(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b.set(true);
        ProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */