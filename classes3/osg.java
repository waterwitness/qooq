import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class osg
  implements AdapterView.OnItemClickListener
{
  public osg(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_b_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
        this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
      if (this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "PhotoPreviewActivity setStatusBar black");
        }
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.a(0);
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.b(0);
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramAdapterView = (RelativeLayout)this.a.findViewById(2131298651);
        if (paramAdapterView != null) {
          paramAdapterView.setSystemUiVisibility(4);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.a.jdField_b_of_type_Boolean = true;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "PhotoPreviewActivity setStatusBar blue");
          }
          paramInt = this.a.getResources().getColor(2131428295);
          this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.a(paramInt);
          this.a.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.b(paramInt);
        }
      } while (ImmersiveUtils.isSupporImmersive() != 1);
      paramAdapterView = (RelativeLayout)this.a.findViewById(2131298651);
    } while (paramAdapterView == null);
    paramAdapterView.setSystemUiVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */