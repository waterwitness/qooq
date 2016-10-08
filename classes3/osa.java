import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;

public class osa
  implements View.OnClickListener
{
  public osa(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = PresendPicMgr.a(null);
    if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.j)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int i = this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.j));
      if (i >= 0)
      {
        this.a.b.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j));
        this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if (paramView != null) {
          paramView.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j), 1014);
        }
      }
      this.a.c();
      if ((this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (!PhotoPreviewActivity.a(this.a))) {
        PhotoPreviewActivity.a(this.a, false);
      }
    }
    for (;;)
    {
      QZoneClickReport.report(this.a.g, "603", "2", "", this.a.t, true);
      return;
      if (this.a.b.size() >= this.a.jdField_c_of_type_Int)
      {
        long l = System.currentTimeMillis();
        if (l - this.a.jdField_a_of_type_Long >= 700L)
        {
          QQToast.a(this.a, "最多只能选择" + this.a.jdField_c_of_type_Int + "张图片", 1000).b(this.a.d);
          this.a.jdField_a_of_type_Long = l;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((this.a.e == 2) && (this.a.j < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.j >= 0) && (new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j)).length() > 19922944L))
      {
        QQToast.a(this.a, this.a.getResources().getString(2131370138), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((paramView != null) && (this.a.j < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.j >= 0) && (!PhotoPreviewActivity.a(this.a))) {
        paramView.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j), this.a.i);
      }
      paramView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j);
      if ((this.a.j < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.j >= 0))
      {
        this.a.b.add(paramView);
        this.a.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.j));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.a.b.indexOf(paramView) + 1);
      this.a.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */