import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.freshnews.FreshNewsManager.PhotoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.picbrowser.NearbyPicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class ljt
  implements ActionSheet.OnButtonClickListener
{
  public ljt(FreshNewsEditActivity paramFreshNewsEditActivity, ActionSheet paramActionSheet, View paramView, ljx paramljx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramView = new ArrayList();
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = ((FreshNewsManager.PhotoInfo)this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
          if (!"plus_sign".equals(localObject1))
          {
            localObject2 = new PicInfo();
            ((PicInfo)localObject2).c = ((String)localObject1);
            paramView.add(localObject2);
          }
          paramInt += 1;
        }
        Object localObject1 = AnimationUtils.a(this.jdField_a_of_type_AndroidViewView);
        Object localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity, NearbyPicBrowserActivity.class);
        ((Intent)localObject2).putExtra("intent_param_index", this.jdField_a_of_type_Ljx.a);
        ((Intent)localObject2).putExtra("intent_param_pic_infos", paramView);
        ((Intent)localObject2).putExtra("KEY_THUMBNAL_BOUND", (Parcelable)localObject1);
        ((Intent)localObject2).addFlags(536870912);
        this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.startActivity((Intent)localObject2);
      }
      NearbyTitleBarActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.b, "0X8005789");
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Ljx.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Ljx.a);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size() == 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!"plus_sign".equals(((FreshNewsManager.PhotoInfo)this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a)))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_JavaUtilArrayList.add(new FreshNewsManager.PhotoInfo("plus_sign", ""));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    FreshNewsEditActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */