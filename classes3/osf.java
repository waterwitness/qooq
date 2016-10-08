import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class osf
  implements AdapterView.OnItemSelectedListener
{
  public osf(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.j = paramInt;
    if (this.a.c.contains(Integer.valueOf(this.a.j))) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.a.b.indexOf(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.j)) + 1);
    }
    while (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.a.d.setText(paramInt + 1 + " / " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    this.a.d.setText(this.a.getResources().getString(2131368751));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */