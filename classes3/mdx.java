import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

class mdx
  implements ActionSheet.OnButtonClickListener
{
  mdx(mdw parammdw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      this.a.a.t();
      continue;
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setCleanCachOnPause(false);
      if (QfavBuilder.a((float)this.a.a.jdField_a_of_type_Double, (float)this.a.a.b, this.a.a.p, this.a.a.m, null).c(this.a.a.getIntent().getStringExtra("uin")).a(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.d(this.a.a).getDimensionPixelSize(2131492908);
        QQToast.a(this.a.a, 2, this.a.a.getString(2131365895), 1).b(paramInt);
      }
      QfavReport.a(null, 65, 7);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */