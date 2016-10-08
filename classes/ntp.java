import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ntp
  implements ActionSheet.OnButtonClickListener
{
  public ntp(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOShortVideoData paramAIOShortVideoData, File paramFile)
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
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    Object localObject = AIOGalleryScene.G(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources();
    if (paramView.equals(((Resources)localObject).getString(2131370093))) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h);
        if (paramView != null)
        {
          paramView.putExtra("NeedReportForwardShortVideo", true);
          ForwardBaseOption.a(AIOGalleryScene.H(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), paramView);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(((Resources)localObject).getString(2131370104)))
      {
        ReportController.b(null, "CliOper", "", "", "0X8005623", "0X8005623", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
      }
      else if (paramView.equals(((Resources)localObject).getString(2131370099)))
      {
        paramView = this.jdField_a_of_type_JavaIoFile.getParentFile().getName().toLowerCase(Locale.US) + ".mp4";
        ThreadManager.a().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_MqqOsMqqHandler, paramView, false));
        ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
        try
        {
          paramView = (PeakActivity)AIOGalleryScene.I(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene);
          localObject = AIOGalleryScene.J(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getIntent();
          if (localObject == null) {
            continue;
          }
          paramInt = ((Intent)localObject).getIntExtra("forward_source_uin_type", -1);
          localObject = ((Intent)localObject).getStringExtra("uin");
          new DCShortVideo(AIOGalleryScene.K(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplication().getBaseContext()).a(paramView.a, 2001, paramInt, (String)localObject);
        }
        catch (ClassCastException paramView) {}
      }
      else if (paramView.equals(((Resources)localObject).getString(2131370100)))
      {
        ShortVideoUtils.a(AIOGalleryScene.L(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile);
      }
      else if (paramView.equals(((Resources)localObject).getString(2131370097)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h);
          if (paramView != null)
          {
            QfavBuilder.a(paramView).a(AIOGalleryScene.M(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), BaseApplicationImpl.a().a().getAccount());
            QfavReport.a(BaseApplicationImpl.a().a(), 6, 5);
          }
        }
      }
      else if (paramView.equals(AIOGalleryScene.N(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370105)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */