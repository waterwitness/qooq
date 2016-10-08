import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class rpv
  implements ActionSheet.OnButtonClickListener
{
  public rpv(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.a.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.a.getResources().getString(2131363066))) {
          break label257;
        }
        if (!UniformDownloadActivity.a(this.a)) {
          break label228;
        }
        paramView = "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(UniformDownloadActivity.b(this.a)) + "&via=" + "ANDROIDQQ.POPUP.YYBDOWNAPP";
        if (QLog.isColorLevel()) {
          QLog.d(UniformDownloadActivity.jdField_a_of_type_JavaLangString, 2, "tmastUrl=" + paramView);
        }
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramView));
        paramView.setFlags(268435456);
        this.a.startActivity(paramView);
        UniformDownloadActivity.b(this.a);
        OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label228:
      UniformDownloadActivity.b(this.a).setVisibility(0);
      ThreadManager.b().post(new rpw(this));
      continue;
      label257:
      if (paramView.equals(this.a.getResources().getString(2131363068)))
      {
        if (UniformDownloadActivity.a(this.a)) {
          OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
        }
        for (;;)
        {
          if (NetworkUtil.e(this.a.getActivity()))
          {
            if (FileManagerUtil.a())
            {
              FMDialogUtil.a(this.a.getActivity(), 2131362855, 2131362883, new rpx(this));
              break;
              OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
              continue;
            }
            UniformDownloadActivity.a(this.a);
            break;
          }
        }
        FMToastUtil.a(2131362941);
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */