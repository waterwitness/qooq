import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class tht
  implements Runnable
{
  public tht(NearbyFlowerAnimationController paramNearbyFlowerAnimationController, NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject5 = null;
    NearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController, System.currentTimeMillis());
    Object localObject1;
    Bitmap localBitmap;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.isAnonymous)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.is1v1) {
        break label267;
      }
      localObject1 = NearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.fromUrl);
      localBitmap = NearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.toUrl);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = ImageUtil.a();
      }
      localObject1 = localBitmap;
      localObject2 = localObject3;
      if (localBitmap == null) {
        localObject1 = ImageUtil.a();
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      for (;;)
      {
        localObject3 = NearbyFlowerUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.pID);
        try
        {
          localObject3 = BitmapFactory.decodeFile((String)localObject3 + "/avatar/avatar_anim_res.png");
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidOsHandler.postDelayed(new thu(this, (Bitmap)localObject2, (Bitmap)localObject1, (Bitmap)localObject3), 300L);
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a();
          return;
          localObject3 = NearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a(32, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.sUin, (byte)2, true, 200);
          localBitmap = NearbyFlowerAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a(32, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.rUin, (byte)2, true, 200);
          if (localObject3 == null)
          {
            localObject3 = ImageUtil.a();
            localObject1 = localBitmap;
            localObject2 = localObject3;
            if (localBitmap != null) {
              continue;
            }
            localObject1 = ImageUtil.a();
            localObject2 = localObject3;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Object localObject4 = localObject5;
            if (QLog.isColorLevel())
            {
              QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "decode avatarAnimBitmap failed");
              localObject4 = localObject5;
            }
          }
        }
      }
      label267:
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */