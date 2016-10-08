import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class ntq
  implements ActionSheet.OnButtonClickListener
{
  public ntq(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (paramView.equals(AIOGalleryScene.O(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370093))) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.asBinder().pingBinder())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(paramView);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(AIOGalleryScene.P(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131362909)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.asBinder().pingBinder()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.f);
        }
        QQToast.a(AIOGalleryScene.Q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.g) + AIOGalleryScene.R(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131362814), 0).a();
      }
      else if (paramView.equals(AIOGalleryScene.S(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370099)))
      {
        AIOGalleryUtils.a(AIOGalleryScene.T(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      }
      else if (paramView.equals(AIOGalleryScene.U(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370097)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.asBinder().pingBinder()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.f);
        }
      }
      else if (paramView.equals(AIOGalleryScene.V(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370104)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
      }
      else if (paramView.equals(AIOGalleryScene.W(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370105)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */