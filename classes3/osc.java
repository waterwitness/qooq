import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

public class osc
  implements View.OnClickListener
{
  public osc(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      this.a.k = ((String)this.a.jdField_b_of_type_JavaUtilArrayList.get(0));
    }
    for (;;)
    {
      if (this.a.k != null)
      {
        ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.a.n) {
          ReportController.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
        }
        paramView = new Intent(BaseApplication.getContext(), PhotoPlusBridgeActivity.class);
        paramView.putExtra("photo_path", this.a.k);
        paramView.putExtra("iswaitforsult", this.a.d);
        paramView.putExtra("type", this.a.jdField_b_of_type_Int);
        paramView.putExtra("uin", this.a.g);
        paramView.putExtra("nick", this.a.h);
        paramView.putExtra("headDir", this.a.i);
        this.a.startActivityForResult(paramView, 100003);
        this.a.overridePendingTransition(2130968620, 2130968621);
        this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramView = this.a.getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
      }
      QZoneClickReport.report(this.a.g, "603", "4", "", this.a.t, true);
      return;
      int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.s();
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        this.a.k = ((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */