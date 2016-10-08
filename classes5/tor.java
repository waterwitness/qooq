import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

public class tor
  implements Runnable
{
  public tor(NearbyProfileEditPanel paramNearbyProfileEditPanel, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841004);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mUseMemoryCache = false;
      localObject2 = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = 10;
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      localObject1 = URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject1);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      Object localObject2;
      Object localObject1;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */