import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gzk
  implements QavInOutAnimation.QavOutAnimationListener
{
  gzk(gzj paramgzj, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(20, false);
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(18, false);
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(19, false);
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(21, false);
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(22, false);
      this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(23, false);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Gzj.a.d, 0);
    this.jdField_a_of_type_Gzj.a.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_Gzj.a.d, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Gzj.a.e = true;
    this.jdField_a_of_type_Gzj.a.finish();
    this.jdField_a_of_type_Gzj.a.overridePendingTransition(0, 2130968713);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */