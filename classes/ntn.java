import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;

public class ntn
  implements ActionSheet.OnButtonClickListener
{
  public ntn(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOImageData paramAIOImageData, File paramFile, AIORichMediaInfo paramAIORichMediaInfo)
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(AIOGalleryScene.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370093)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
      }
      else if (paramView.equals(AIOGalleryScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370103)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Qzone", 0);
        AIOGalleryUtils.a(AIOGalleryScene.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_e_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_e_of_type_JavaLangString);
      }
      else if (paramView.equals(AIOGalleryScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370112)))
      {
        if (LocalMultiProcConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_e_of_type_JavaLangString, -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c).longValue()) == 0)
        {
          paramView = new QQCustomDialog(AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 2131558973);
          paramView.setContentView(2130903241);
          paramView.setTitle(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131364348));
          paramView.setMessage(AIOGalleryScene.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131364350));
          paramView.setNegativeButton(AIOGalleryScene.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131364351), new nto(this));
          paramView.setCanceledOnTouchOutside(false);
          paramView.setCancelable(false);
          paramView.show();
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, "40", "1");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Grpalbum", 0);
          AIOGalleryUtils.a(AIOGalleryScene.s(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c, -1);
        }
      }
      else if (paramView.equals(AIOGalleryScene.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370099)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_save", 0);
        AIOGalleryUtils.a(AIOGalleryScene.u(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
      }
      else if (paramView.equals(AIOGalleryScene.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370096)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_JavaLangString);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
      }
      else
      {
        if (paramView.equals(AIOGalleryScene.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370097))) {
          for (;;)
          {
            try
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.k);
              if (paramView != null) {
                break label759;
              }
              QfavBuilder.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(AIOGalleryScene.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c);
              QfavReport.a(null, 40, 3);
            }
            catch (RemoteException paramView)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AIOGalleryScene", 2, "", paramView);
              }
              QQToast.a(AIOGalleryScene.z(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplicationContext(), AIOGalleryScene.A(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131368692), 0).a();
            }
            break;
            label759:
            new QfavBuilder(paramView).a(AIOGalleryScene.y(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c);
          }
        }
        if (paramView.equals(AIOGalleryScene.B(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370104)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
        }
        else if (paramView.equals(AIOGalleryScene.C(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131362314)))
        {
          paramView = new Intent(AIOGalleryScene.D(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), PrinterActivity.class);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_a_of_type_JavaIoFile.getPath());
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
          paramView.putExtra(AlbumConstants.i, 55);
          AIOGalleryScene.E(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).startActivityForResult(paramView, 55);
        }
        else if (paramView.equals(AIOGalleryScene.F(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131370105)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */