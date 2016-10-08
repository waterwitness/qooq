import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.RadaScanView;
import com.tencent.mobileqq.troop.widget.RadarBgView.OnBackgroundReadyListener;
import com.tencent.mobileqq.troop.widget.RadarMembersView;
import com.tencent.mobileqq.troop.widget.RadarView;

public class vtj
  implements RadarBgView.OnBackgroundReadyListener
{
  public vtj(RadarView paramRadarView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setRadius(paramInt3, paramInt4, paramInt5, paramInt6);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.invalidate();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.setSpace(paramInt1, paramInt6, paramInt5);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.setOnScanDegreeChangeListener(new vtk(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vtj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */