import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;

class nvc
  implements Runnable
{
  nvc(nvb paramnvb, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a, this.jdField_a_of_type_Nvb.a.findViewById(2131301289));
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setBackgroundResource(2130843089);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setVisibility(0);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a, (CheckBox)this.jdField_a_of_type_Nvb.a.findViewById(2131301739));
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a, (TextView)this.jdField_a_of_type_Nvb.a.findViewById(2131301741));
    PhotoListPanel.b(this.jdField_a_of_type_Nvb.a, (TextView)this.jdField_a_of_type_Nvb.a.findViewById(2131301740));
    PhotoListPanel.b(this.jdField_a_of_type_Nvb.a, this.jdField_a_of_type_Nvb.a.findViewById(2131301738));
    PhotoListPanel.c(this.jdField_a_of_type_Nvb.a, this.jdField_a_of_type_Nvb.a.findViewById(2131301742));
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnClickListener(this.jdField_a_of_type_Nvb.a);
    PhotoListPanel.b(this.jdField_a_of_type_Nvb.a).setOnClickListener(this.jdField_a_of_type_Nvb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnClickListener(this.jdField_a_of_type_Nvb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnClickListener(this.jdField_a_of_type_Nvb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a, PhotoListPanel.a(this.jdField_a_of_type_Nvb.a), PhotoListPanel.b(this.jdField_a_of_type_Nvb.a));
    Object localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).a = Long.valueOf(this.jdField_a_of_type_Nvb.a.b).longValue();
    ((QZoneClickReport.ReportInfo)localObject).c = "459";
    ((QZoneClickReport.ReportInfo)localObject).d = "1";
    QZoneClickReport.report(this.jdField_a_of_type_Nvb.a.b, (QZoneClickReport.ReportInfo)localObject, true);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnCheckedChangeListener(null);
    PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setChecked(this.jdField_a_of_type_Boolean);
    CheckBox localCheckBox;
    StringBuilder localStringBuilder;
    if (AppSetting.j)
    {
      localCheckBox = PhotoListPanel.a(this.jdField_a_of_type_Nvb.a);
      localStringBuilder = new StringBuilder().append("上传到").append(PhotoListPanel.b(this.jdField_a_of_type_Nvb.a)).append(" ");
      if (!this.jdField_a_of_type_Boolean) {
        break label493;
      }
    }
    label493:
    for (localObject = "已选中";; localObject = "未选中")
    {
      localCheckBox.setContentDescription((String)localObject);
      PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnCheckedChangeListener(this.jdField_a_of_type_Nvb.a);
      PhotoListPanel.a(this.jdField_a_of_type_Nvb.a).setOnClickListener(this.jdField_a_of_type_Nvb.a);
      this.jdField_a_of_type_Nvb.a.h();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */