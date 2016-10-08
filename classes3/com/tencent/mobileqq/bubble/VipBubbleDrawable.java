package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import qup;

public class VipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  static final String jdField_a_of_type_JavaLangString = "VipBubbleDrawable";
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BubbleConfig.DiyTextConfig jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig;
  public boolean a;
  private int jdField_b_of_type_Int;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VipBubbleDrawable(Resources paramResources, NinePatch paramNinePatch1, NinePatch paramNinePatch2, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_AndroidGraphicsNinePatch = paramNinePatch1;
    this.jdField_b_of_type_AndroidGraphicsNinePatch = paramNinePatch2;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null)
    {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
      this.jdField_b_of_type_Int = AIOUtils.a(65.0F, paramResources);
      this.jdField_c_of_type_Int = AIOUtils.a(57.0F, paramResources);
    }
  }
  
  private float a(Paint paramPaint)
  {
    if (paramPaint == null) {
      return 0.0F;
    }
    paramPaint = paramPaint.getFontMetrics();
    return paramPaint.descent - paramPaint.ascent;
  }
  
  private float a(Paint paramPaint, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null)) {
      return 0.0F;
    }
    return paramPaint.measureText(paramString);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = 0;
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      Object localObject1 = null;
      String str = "bubblechartlet://" + "0_bubble_chartlet_" + this.jdField_b_of_type_JavaLangString;
      if (BaseApplicationImpl.a != null) {
        localObject1 = (Bitmap)BaseApplicationImpl.a.get(str);
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = BitmapManager.a(this.jdField_b_of_type_JavaLangString);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject2, this.jdField_b_of_type_ArrayOfInt[2], this.jdField_b_of_type_ArrayOfInt[3], true);
          localObject2 = localBitmap;
          localObject1 = localBitmap;
          if (BaseApplicationImpl.a != null)
          {
            localObject1 = localBitmap;
            BaseApplicationImpl.a.put(str, localBitmap);
            localObject2 = localBitmap;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject3 = localObject1;
          continue;
          int j = 0;
        }
      }
    }
    localObject1 = new Paint();
    if (this.jdField_c_of_type_JavaLangString.equals("TL")) {
      if (this.jdField_c_of_type_Boolean)
      {
        j = paramCanvas.getWidth() - this.jdField_b_of_type_ArrayOfInt[2] - this.jdField_b_of_type_ArrayOfInt[0];
        i = this.jdField_b_of_type_ArrayOfInt[1];
      }
    }
    for (;;)
    {
      paramCanvas.drawBitmap((Bitmap)localObject2, j, i, (Paint)localObject1);
      return;
      j = this.jdField_b_of_type_ArrayOfInt[0];
      i = this.jdField_b_of_type_ArrayOfInt[1];
      continue;
      if (this.jdField_c_of_type_JavaLangString.equals("BL"))
      {
        if (this.jdField_c_of_type_Boolean)
        {
          j = paramCanvas.getWidth() - this.jdField_b_of_type_ArrayOfInt[2] - this.jdField_b_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_b_of_type_ArrayOfInt[1];
        }
        else
        {
          j = this.jdField_b_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_b_of_type_ArrayOfInt[1];
        }
      }
      else if (this.jdField_c_of_type_JavaLangString.equals("TR"))
      {
        if (this.jdField_c_of_type_Boolean)
        {
          j = -this.jdField_b_of_type_ArrayOfInt[2] - this.jdField_b_of_type_ArrayOfInt[0];
          i = this.jdField_b_of_type_ArrayOfInt[1];
        }
        else
        {
          j = paramCanvas.getWidth() + this.jdField_b_of_type_ArrayOfInt[0];
          i = this.jdField_b_of_type_ArrayOfInt[1];
        }
      }
      else
      {
        if (!this.jdField_c_of_type_JavaLangString.equals("BR")) {
          break;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          j = -this.jdField_b_of_type_ArrayOfInt[2] - this.jdField_b_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_b_of_type_ArrayOfInt[1];
        }
        else
        {
          j = paramCanvas.getWidth() + this.jdField_b_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_b_of_type_ArrayOfInt[1];
        }
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = 0;
    if (paramCanvas == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt.length <= 3) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_JavaLangString))) {
      return;
    }
    Paint localPaint = new Paint();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_Int != -1) {
      localPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_Int != 0) {
      localPaint.setTextSize(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_Int);
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_JavaLangString.equals("TL")) {
      if (this.jdField_c_of_type_Boolean)
      {
        j = paramCanvas.getWidth() - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
      }
    }
    for (;;)
    {
      float f2 = i + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[3];
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[3] - a(localPaint)) / 2.0F;
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_JavaLangString.equals("left")) {
        f1 = j;
      }
      for (;;)
      {
        paramCanvas.drawText(this.jdField_e_of_type_JavaLangString, f1, f2 - f3, localPaint);
        return;
        j = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_JavaLangString.equals("BL"))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            j = paramCanvas.getWidth() - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
            i = paramCanvas.getHeight() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
            break;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_JavaLangString.equals("TR"))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            j = -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
            i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
            break;
          }
          j = paramCanvas.getWidth() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
          i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_b_of_type_JavaLangString.equals("BR")) {
          break label646;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          j = -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
          i = paramCanvas.getHeight() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
          break;
        }
        j = paramCanvas.getWidth() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[0];
        i = paramCanvas.getHeight() + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[1];
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_JavaLangString.equals("center")) {
          f1 = j + (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] - a(localPaint, this.jdField_e_of_type_JavaLangString)) / 2.0F;
        } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_JavaLangString.equals("right")) {
          f1 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_a_of_type_ArrayOfInt[2] + j - a(localPaint, this.jdField_e_of_type_JavaLangString);
        } else {
          f1 = 0.0F;
        }
      }
      label646:
      j = 0;
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    label226:
    for (;;)
    {
      return;
      String str = "bubblebg://" + "0_local_default_" + this.jdField_c_of_type_Boolean;
      Object localObject;
      if (BaseApplicationImpl.a != null)
      {
        localObject = (NinePatch)BaseApplicationImpl.a.get(str);
        if (localObject != null) {
          ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label226;
        }
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 2130842999;; i = 2130843067)
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inDensity = 320;
          ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
          try
          {
            localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, i, (BitmapFactory.Options)localObject);
            if (localObject == null) {
              break;
            }
            byte[] arrayOfByte = ((Bitmap)localObject).getNinePatchChunk();
            if (arrayOfByte == null) {
              break;
            }
            localObject = new NinePatch((Bitmap)localObject, arrayOfByte, null);
            if (localObject == null) {
              break;
            }
            ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
            if (BaseApplicationImpl.a == null) {
              break;
            }
            BaseApplicationImpl.a.put(str, localObject);
            return;
          }
          catch (OutOfMemoryError paramCanvas)
          {
            QLog.e("VipBubbleDrawable", 1, "drawDefaultBubbleBg, decode default bubble bg error, bubbleId=" + this.jdField_d_of_type_Int, paramCanvas);
            return;
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new qup(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BubbleConfig.DiyTextConfig paramDiyTextConfig, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig = paramDiyTextConfig;
    this.jdField_d_of_type_JavaLangString = BubbleDiyText.makeKey(paramString, paramInt);
    this.jdField_e_of_type_JavaLangString = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig != null) && (!"0_0".equals(this.jdField_d_of_type_JavaLangString)) && (paramInt > 0))
    {
      paramQQAppInterface = BubbleDiyFetcher.a().a(this, this.jdField_d_of_type_JavaLangString);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.equals(this.jdField_e_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_JavaLangString = paramQQAppInterface;
        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int > 0) && (this.jdField_e_of_type_JavaLangString.length() > this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int)) {
          this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.substring(0, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int);
        }
        invalidateSelf();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.jdField_d_of_type_JavaLangString)) && (paramString2 != null) && (!paramString2.equals(this.jdField_e_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_JavaLangString = paramString2;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int > 0) && (this.jdField_e_of_type_JavaLangString.length() > this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.substring(0, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig.jdField_c_of_type_Int);
      }
      invalidateSelf();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_c_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    c(paramBoolean);
    a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    NinePatch localNinePatch;
    if ((this.f) && (this.jdField_b_of_type_AndroidGraphicsNinePatch != null))
    {
      localNinePatch = this.jdField_b_of_type_AndroidGraphicsNinePatch;
      if (localNinePatch == null) {
        break label111;
      }
      if (this.jdField_c_of_type_Boolean) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      localNinePatch.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      if ((!this.f) && (this.jdField_d_of_type_Boolean))
      {
        a(paramCanvas);
        b(paramCanvas);
      }
      return;
      localNinePatch = this.jdField_a_of_type_AndroidGraphicsNinePatch;
      break;
      label111:
      QLog.e("VipBubbleDrawable", 1, "draw, ninePatch null, use default, mUseAnimationBg=" + this.f + ", mNormalNinePatch=" + this.jdField_a_of_type_AndroidGraphicsNinePatch + ", mAnimationNinePath" + this.jdField_b_of_type_AndroidGraphicsNinePatch + ", bubbleId=" + this.jdField_d_of_type_Int + ", drawable=" + this);
      c(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    if (this.jdField_a_of_type_AndroidGraphicsNinePatch != null) {
      if (!this.jdField_a_of_type_AndroidGraphicsNinePatch.hasAlpha()) {}
    }
    while ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255))
    {
      return -3;
      return -1;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    boolean bool2 = StateSet.stateSetMatches(jdField_a_of_type_ArrayOfInt, paramArrayOfInt);
    if (this.jdField_b_of_type_Boolean != bool2)
    {
      this.jdField_b_of_type_Boolean = bool2;
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        break label61;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      invalidateSelf();
      bool1 = true;
      return bool1;
      label61:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\VipBubbleDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */