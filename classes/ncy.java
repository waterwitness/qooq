import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ncy
  implements Runnable
{
  ncy(ncx paramncx, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = PreloadImgManager.a().a(ncx.a(this.jdField_a_of_type_Ncx), this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      PreloadImgManager.a().a(ncx.a(this.jdField_a_of_type_Ncx), this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_a_of_type_JavaLangString, new ncz(this));
      return;
    }
    CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */