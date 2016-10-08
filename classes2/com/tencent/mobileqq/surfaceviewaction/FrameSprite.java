package com.tencent.mobileqq.surfaceviewaction;

import android.graphics.Canvas;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;

public class FrameSprite
  extends Sprite
{
  public FrameSprite.OnFrameEndListener a;
  public GiftBitmapAnimaionCache a;
  public boolean a;
  
  public FrameSprite()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((this.e == 0.0F) || (this.g == 0)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache == null);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a();
      if (this.jdField_a_of_type_Boolean) {
        this.g = 0;
      }
      super.a(paramCanvas);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener == null));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener.a();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\FrameSprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */