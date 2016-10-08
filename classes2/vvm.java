import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.qphone.base.util.QLog;

public class vvm
  implements FrameSprite.OnFrameEndListener
{
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  public int a;
  public long a;
  public long b;
  public long c;
  
  public vvm(TroopGiftAnimationController paramTroopGiftAnimationController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift" + TroopGiftAnimationController.b, 2, "animation frame end. requestState:" + this.jdField_a_of_type_Int);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(0L);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(3000L);
      continue;
      long l = this.c - this.b;
      if (l >= 2000L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(0L);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(2000L - l);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(3000L);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */