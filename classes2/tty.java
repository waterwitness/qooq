import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.HongBaoShareActivity;

public class tty
  implements Runnable
{
  public tty(HongBaoShareActivity paramHongBaoShareActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (HongBaoShareActivity.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).getWidth() < this.jdField_a_of_type_Int) {
      HongBaoShareActivity.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).setMove(true);
    }
    while (HongBaoShareActivity.b(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).getWidth() < this.b)
    {
      HongBaoShareActivity.b(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).setMove(true);
      return;
      HongBaoShareActivity.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).setMove(false);
    }
    HongBaoShareActivity.b(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoShareActivity).setMove(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */