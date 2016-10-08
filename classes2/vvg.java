import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.SpriteSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;

class vvg
  implements FaceDrawable.OnLoadingStateChangeListener
{
  vvg(vvf paramvvf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = FaceDrawable.a(TroopGiftAnimationController.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController), String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), (byte)3);
    localObject = TroopGiftAnimationController.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController, (Drawable)localObject);
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a.a(new vvh(this, (Bitmap)localObject));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */