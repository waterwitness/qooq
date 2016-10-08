import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.IFaceBitmaprGetter;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class vvf
  implements Runnable
{
  public vvf(TroopGiftAnimationController paramTroopGiftAnimationController, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController, System.currentTimeMillis());
    Object localObject1;
    Object localObject4;
    if (TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) != null)
    {
      localObject1 = FaceDrawable.a(1, 3);
      localObject4 = FaceDrawable.a(TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController), 1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), 3, (Drawable)localObject1, (Drawable)localObject1, new vvg(this));
      localObject4 = TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController, (Drawable)localObject4);
      localObject1 = FaceDrawable.a(TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController), 1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin), 3, (Drawable)localObject1, (Drawable)localObject1, new vvi(this));
      localObject1 = TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController, (Drawable)localObject1);
    }
    for (;;)
    {
      Object localObject5 = localObject4;
      if (localObject4 == null) {
        localObject5 = ImageUtil.a();
      }
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject4 = ImageUtil.a();
      }
      String str = TroopGiftUtil.a(TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips));
      try
      {
        localObject1 = BitmapFactory.decodeFile(str + "/avatar/avatar_anim_res.png");
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_AndroidOsHandler.postDelayed(new vvk(this, str, (Bitmap)localObject5, (Bitmap)localObject4, (Bitmap)localObject1), 300L);
        if (!TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController).isToAll()) {}
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          Thread.sleep(500L);
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a();
          return;
          if ((TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) != null) && ((TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) instanceof TroopGiftAnimationController.IFaceBitmaprGetter)))
          {
            localObject1 = (TroopGiftAnimationController.IFaceBitmaprGetter)TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController);
            localObject4 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
            localObject1 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
            continue;
            localOutOfMemoryError = localOutOfMemoryError;
            if (QLog.isColorLevel()) {
              QLog.d(TroopGiftAnimationController.b, 2, "decode avatarAnimRes failed");
            }
            Object localObject2 = null;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
          Object localObject3 = null;
          localObject4 = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */