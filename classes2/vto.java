import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.ScaleGallery;
import com.tencent.qphone.base.util.QLog;

public class vto
  implements AdapterView.OnItemSelectedListener
{
  public vto(ScaleGallery paramScaleGallery)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.a.jdField_b_of_type_Boolean) && (paramInt != this.a.d)) {
      this.a.a();
    }
    if (this.a.jdField_b_of_type_AndroidWidgetAdapterView$OnItemSelectedListener != null)
    {
      this.a.jdField_b_of_type_AndroidWidgetAdapterView$OnItemSelectedListener.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      if (QLog.isColorLevel()) {
        QLog.i("ScaleGallery", 2, "onItemSelected:" + paramInt + ", " + this.a.d);
      }
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */