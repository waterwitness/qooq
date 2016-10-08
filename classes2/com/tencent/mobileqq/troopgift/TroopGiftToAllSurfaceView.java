package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.ImageButton;
import com.tencent.mobileqq.surfaceviewaction.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.Label;
import com.tencent.mobileqq.surfaceviewaction.Sprite;
import com.tencent.mobileqq.surfaceviewaction.SpriteSurfaceView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import vvn;
import vvo;
import vvp;
import vvq;
import vvr;

public class TroopGiftToAllSurfaceView
  extends SpriteSurfaceView
{
  public static final String a;
  private FrameSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite;
  private ImageButton jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel;
  private Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite;
  private TroopGiftToAllSurfaceView.Options jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options;
  private float jdField_b_of_type_Float;
  private ImageButton jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton;
  private int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopGiftToAllSurfaceView.class.getSimpleName();
  }
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, GiftBitmapAnimaionCache paramGiftBitmapAnimaionCache, ImageButton.OnClickListener paramOnClickListener, TroopGiftToAllSurfaceView.Options paramOptions)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options = paramOptions;
    this.c = (paramOptions.jdField_b_of_type_Int * paramOptions.c / 100);
    this.jdField_b_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramGiftBitmapAnimaionCache.a(true);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite = new FrameSprite();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache = paramGiftBitmapAnimaionCache;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_e_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.f = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int / 2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_e_of_type_Float = paramOptions.jdField_a_of_type_Float;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!paramOptions.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      paramGiftBitmapAnimaionCache = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(paramGiftBitmapAnimaionCache);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(paramOptions.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((paramGiftBitmapAnimaionCache.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(paramOptions.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramOptions.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(paramOptions.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = paramOptions.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < paramOptions.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + paramOptions.jdField_a_of_type_JavaLangString.charAt(i));
          if (f1 + f3 + f2 > 475.0F) {
            break;
          }
          f1 += f3;
          j += 1;
          i += 1;
        }
        if (j <= 0) {
          break label684;
        }
        if (j != paramOptions.jdField_a_of_type_JavaLangString.length()) {
          break label629;
        }
        paramBitmap1 = paramOptions.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label629:
    label684:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, paramGiftBitmapAnimaionCache.getWidth() / 2 - f1 / 2.0F, 359.2F, localPaint);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite = new Sprite(paramGiftBitmapAnimaionCache);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.jdField_e_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.f = this.c;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.jdField_e_of_type_Float = 0.0F;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton = new ImageButton(paramBitmap3, false);
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.f / 100);
      }
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton = new ImageButton(BitmapFactory.decodeResource(getResources(), 2130841739), true);
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a((int)(paramOptions.jdField_a_of_type_Int - DisplayUtils.a(getContext(), 40.0F)), (int)DisplayUtils.a(getContext(), 120.0F));
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(paramOnClickListener);
        this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton.jdField_e_of_type_Float = 0.75F;
        a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton);
        return;
        paramBitmap1 = paramOptions.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, this.jdField_b_of_type_Float * 1.1F), new ScaleAction(200, this.jdField_b_of_type_Float * 1.1F, this.jdField_b_of_type_Float * 0.95F), new ScaleAction(200, this.jdField_b_of_type_Float * 0.95F, this.jdField_b_of_type_Float * 1.05F), new ScaleAction(200, this.jdField_b_of_type_Float * 1.05F, this.jdField_b_of_type_Float * 1.0F) });
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { localSequenceAction });
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = new vvn(this, paramOnFrameEndListener);
    }
    paramOnFrameEndListener = new DelayAction(500);
    paramOnFrameEndListener.a(new vvo(this));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { paramOnFrameEndListener });
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(paramOnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.jdField_e_of_type_Float = 0.0F;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton);
      paramOnClickListener = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, this.jdField_b_of_type_Float * 1.1F), new ScaleAction(200, this.jdField_b_of_type_Float * 1.1F, this.jdField_b_of_type_Float * 0.88F), new ScaleAction(200, this.jdField_b_of_type_Float * 0.88F, this.jdField_b_of_type_Float) });
      paramOnClickListener.a(new vvp(this));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(new Action[] { paramOnClickListener });
    }
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    OpacityAction localOpacityAction = new OpacityAction(500, 255, 0, 1);
    localOpacityAction.a(paramOnActionEndListener);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSprite.a(new Action[] { localOpacityAction });
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton != null) {
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(new Action[] { new OpacityAction(500, 255, 0, 1) });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel = new Label(paramString, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_a_of_type_Int / 2, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$Options.f / 100);
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel.g = 0;
    paramString = new DelayAction(500);
    paramString.a(new vvr(this));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel.a(new Action[] { paramString });
  }
  
  public void b()
  {
    OpacityAction localOpacityAction = new OpacityAction(500, 255, 0);
    localOpacityAction.a(new vvq(this));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton.a(new Action[] { localOpacityAction });
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionLabel);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopgift\TroopGiftToAllSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */