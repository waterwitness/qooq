import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class vgn
  implements AdapterView.OnItemSelectedListener
{
  vgn(vgl paramvgl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (TroopAvatarWallPreviewActivity.a(this.a.a.a).isReport)
      {
        TroopAvatarWallPreviewActivity.a(this.a.a.a).addPicIndex(paramInt);
        paramAdapterView = TroopAvatarWallPreviewActivity.a(this.a.a.a);
        paramAdapterView.slide_number += 1;
      }
      this.a.a.a.jdField_a_of_type_Int = paramInt;
      paramAdapterView = this.a.a.a.jdField_a_of_type_Int + 1 + "/" + this.a.a.a.jdField_b_of_type_Int;
      this.a.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView);
      if (this.a.a.a.c) {
        ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.m, "0", "", "");
      }
      while (this.a.a.a.jdField_b_of_type_Boolean)
      {
        TroopAvatarWallPreviewActivity.a(this.a.a.a, this.a.a.a.jdField_a_of_type_Int);
        return;
        ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.m, "1", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */