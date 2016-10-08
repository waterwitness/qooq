package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.Sprite;
import com.tencent.mobileqq.surfaceviewaction.SpriteSurfaceView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.FlowerAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.util.DisplayUtil;
import vuw;

public class SendFlowerSurfaceView
  extends SpriteSurfaceView
{
  public static final int c = 400;
  private FrameSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite;
  private Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite;
  private Sprite[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite;
  private Sprite jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite;
  private boolean jdField_b_of_type_Boolean;
  private int d;
  
  public SendFlowerSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite = new FrameSprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite = new Sprite();
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite = new Sprite();
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.e = 0.0F;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite = new Sprite[6];
    int i = 0;
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i] = new Sprite();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i]);
      i += 1;
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = DisplayUtil.a(getContext(), 4.0F);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      Object localObject = new Canvas(localBitmap2);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawCircle(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, paramBitmap.getWidth() / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap = new Paint();
      paramBitmap.setColor(-1);
      paramBitmap.setAntiAlias(true);
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localObject = new Matrix();
      ((Matrix)localObject).postScale((paramInt1 - i) / localBitmap2.getWidth(), (paramInt2 - i) / localBitmap2.getHeight());
      ((Matrix)localObject).postTranslate(i / 2, i / 2);
      localCanvas.drawBitmap(localBitmap2, (Matrix)localObject, paramBitmap);
      paramBitmap = new Paint();
      paramBitmap.setColor(-16777216);
      paramBitmap.setAlpha(43);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setAntiAlias(true);
      paramBitmap.setStrokeWidth(DisplayUtil.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      if ((localBitmap1.getWidth() == paramInt1) && (localBitmap1.getHeight() == paramInt2)) {
        this.jdField_b_of_type_Boolean = false;
      }
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, Action.OnActionEndListener paramOnActionEndListener)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), new ScaleAction(200, 1.05F, 0.0F) }), new SequenceAction(new Action[] { new DelayAction(paramInt), new MoveToAction(200, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x - j / 2, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y), new MoveToAction(200, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x + j / 2 + i, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y) }) });
    ScaleAction localScaleAction = new ScaleAction(200, 1.05F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(paramInt), new ScaleAction(200, 1.0F, 1.05F), localScaleAction }), new SequenceAction(new Action[] { new MoveToAction(200, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x + j / 2, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y), new MoveToAction(200, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x - j / 2 - i, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().y) }) });
    localScaleAction.a(paramOnActionEndListener);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.e = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.e = 0.0F;
    int i = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a();
    int j = i / 10;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { new SequenceAction(new Action[] { new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { new SequenceAction(new Action[] { new DelayAction(200), new ScaleAction(200, 0.0F, 1.05F), new ScaleAction(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x);
    SequenceAction localSequenceAction1 = new SequenceAction(new Action[] { new DelayAction(500), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[0].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[0].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f) });
    SequenceAction localSequenceAction2 = new SequenceAction(new Action[] { new DelayAction(700), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[1].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[1].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f) });
    SequenceAction localSequenceAction3 = new SequenceAction(new Action[] { new DelayAction(600), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[2].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[2].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f) });
    SequenceAction localSequenceAction4 = new SequenceAction(new Action[] { new DelayAction(900), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[3].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[3].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f * 0.6F) });
    SequenceAction localSequenceAction5 = new SequenceAction(new Action[] { new DelayAction(800), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[4].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[4].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f * 0.6F) });
    SequenceAction localSequenceAction6 = new SequenceAction(new Action[] { new DelayAction(1000), new FlowerAction(600, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[5].a().x, this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[5].a().y, this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a().x, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i].g = 255;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i].a(new Action[] { new Action[] { localSequenceAction1, localSequenceAction2, localSequenceAction3, localSequenceAction4, localSequenceAction5, localSequenceAction6 }[i], new SequenceAction(new Action[] { new DelayAction(1300), new OpacityAction(300, 255, 0) }) });
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = new vuw(this, paramOnFrameEndListener);
    }
    if (a())
    {
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite);
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite);
      a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite.length)
      {
        a(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i]);
        i += 1;
      }
    }
  }
  
  public void setHeadPositionY(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    int j = paramInt1 / 6;
    this.jdField_a_of_type_Float = 1.0F;
    int i;
    if (paramInt3 < j) {
      i = j;
    }
    for (;;)
    {
      this.d = i;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.a(paramInt1 / 2, paramInt2 / 2);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.e = paramFloat;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.g = 255;
      return;
      i = paramInt3;
      if (paramInt3 + j > paramInt2) {
        i = paramInt2 - j;
      }
    }
  }
  
  public void setReceiveHeadBitmap(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a = a(paramBitmap, DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F));
  }
  
  public void setResource(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, GiftBitmapAnimaionCache paramGiftBitmapAnimaionCache)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a = a(paramBitmap1, DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F));
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a = a(paramBitmap2, DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache = paramGiftBitmapAnimaionCache;
    int i = 0;
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionSprite[i].a = paramBitmap3;
      i += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a = a(paramBitmap, DisplayUtil.a(getContext(), 70.0F), DisplayUtil.a(getContext(), 70.0F));
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a();
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionSprite.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopgift\SendFlowerSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */