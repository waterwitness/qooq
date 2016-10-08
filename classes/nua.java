import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

public class nua
  implements ActionSheet.OnButtonClickListener
{
  public nua(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131370851))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.o();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a("Multi_Forward_Contacts", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((AIORichMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramView.f, paramView.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.x);
        ForwardBaseOption.a(AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), paramView);
        continue;
        label195:
        if (paramView.equals(AIOImageListScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131370112)))
        {
          if (LocalMultiProcConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c, -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b).longValue()) == 0)
          {
            paramView = new QQCustomDialog(AIOImageListScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131558973);
            paramView.setContentView(2130903241);
            paramView.setTitle(AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131364348));
            paramView.setMessage(AIOImageListScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131364350));
            paramView.setNegativeButton(AIOImageListScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131364351), new nub(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b, "40", "1");
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(AIOImageListScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131370113, 0).a();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.q();
          }
        }
        else if (paramView.equals(AIOImageListScene.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131370102))) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(AIOImageListScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131370113, 0).a();
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.r();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */