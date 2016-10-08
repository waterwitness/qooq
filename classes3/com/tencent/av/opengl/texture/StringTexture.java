package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.FloatMath;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class StringTexture
  extends UploadedTexture
{
  private static final String jdField_a_of_type_JavaLangString = "StringTexture";
  private float jdField_a_of_type_Float;
  private final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  protected Canvas a;
  private Paint.FontMetricsInt jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String b;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public StringTexture()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 15.0F;
    this.q = -1;
    this.r = Integer.MAX_VALUE;
    this.s = Integer.MAX_VALUE;
    this.t = Integer.MAX_VALUE;
    this.b = "";
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.q);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    d(false);
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.i, this.j, this.jdField_a_of_type_AndroidGraphicsBitmap$Config);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(0.0F, -this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.b, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    return localBitmap;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextSize textSize: " + paramFloat);
    }
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setText text: " + paramString);
    }
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  public void e()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.b))
    {
      j = CharacterUtil.a(this.b);
      i = (int)FloatMath.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.b));
      if ((j <= this.t) && (i <= this.r)) {
        break label283;
      }
    }
    label283:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        i = Math.min(Math.max((this.r - (int)FloatMath.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("..."))) / (int)FloatMath.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("M")), 1), this.t);
        this.b = (CharacterUtil.a(this.b, 0, i) + "...");
        i = (int)FloatMath.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.b));
      }
      j = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top;
      if (i <= 0) {
        i = 1;
      }
      for (;;)
      {
        if (j <= 0) {
          j = 1;
        }
        for (;;)
        {
          a(i, j);
          b(i, j);
          if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "refreshText width: " + this.i + ", height: " + this.j + ", maxLength: " + this.t + ", textSize: " + this.jdField_a_of_type_Float + ", text: " + this.b);
          }
          return;
          j = 1;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextColor textColor: " + paramInt);
    }
    this.q = paramInt;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.q);
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setMaxLength maxLength: " + paramInt);
    }
    this.t = paramInt;
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setWidth width: " + paramInt);
    }
    if (paramInt > 0) {
      this.r = paramInt;
    }
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setHeight height: " + paramInt);
    }
    if (paramInt > 0) {
      this.s = paramInt;
    }
  }
  
  public int k()
  {
    return this.r;
  }
  
  public int l()
  {
    if (this.s == Integer.MAX_VALUE) {
      return this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top;
    }
    return this.s;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\StringTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */