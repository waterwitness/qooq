import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ShoppingPhotoItemInfo;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping.StylePagerAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.Reference;
import java.util.List;

public class twg
  implements View.OnClickListener
{
  public twg(PhotoViewForShopping.StylePagerAdapter paramStylePagerAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (PhotoViewForShopping.a(this.a.a).get() != null)
    {
      paramView = new Intent((Context)PhotoViewForShopping.a(this.a.a).get(), QQBrowserActivity.class);
      paramView.putExtra("url", ((ShoppingPhotoItemInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(i)).b);
      ((Activity)PhotoViewForShopping.a(this.a.a).get()).startActivity(paramView);
      if (PhotoViewForShopping.a(this.a.a).a.a.equals(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_Mtemplatewindowclk", "0X8005B94", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplatewindowclk", "0X8005B98", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */