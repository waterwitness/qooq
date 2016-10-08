import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class tkz
  implements ActionSheet.OnButtonClickListener
{
  public tkz(PicBrowserGalleryScene paramPicBrowserGalleryScene, ActionSheet paramActionSheet, File paramFile, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      AIOGalleryUtils.a(PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      return;
    }
    PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */