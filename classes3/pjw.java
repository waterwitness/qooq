import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class pjw
  implements ActionSheet.OnButtonClickListener
{
  public pjw(ShortVideoPlayActivity paramShortVideoPlayActivity, ActionSheet paramActionSheet, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label270;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
      }
      if (ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity))
      {
        if (!ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity)) {
          break label137;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8006DF2", "0X8006DF2", 0, 0, "4", null, null, paramView);
      }
      if (!ShortVideoPlayActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity)) {
        break label151;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo...... mIsPlayingPublicAccountVideo = true");
      }
      ShortVideoPlayActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
    }
    label137:
    label151:
    label270:
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      break;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity;
      Bundle localBundle = ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).getExtras();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      localBundle.putString("forward_thumb", ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_j_of_type_JavaLangString, "jpg"));
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ForwardBaseOption.a(paramView, localIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_j_of_type_Int != 0) {
        ShortVideoPlayActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
      return;
      if (paramView.equals(this.b))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext, 0, 2131371549, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
          return;
        }
        ThreadManager.a().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.i + ".mp4", false));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
        }
        for (;;)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.p, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.n);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 3000)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
          }
        }
      }
    } while (!paramView.equals(this.d));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext, 0, 2131371549, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.startActivity(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.l == 1)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */