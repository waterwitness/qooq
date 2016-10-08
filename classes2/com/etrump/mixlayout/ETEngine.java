package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ETEngine
{
  private static final int ETRUMP_FONT_SIZE_MINIMUM = 24;
  public static final int STYLE_BOLD = 1;
  public static final int STYLE_CROCHET = 8;
  public static final int STYLE_REGULAR = 0;
  public static final int STYLE_SHADOW = 128;
  public static final String TAG = "ETEngine";
  private static ETEngine sInstance;
  private static ETEngine sInstanceRP;
  private static final int sMemPoolSize = 1048576;
  private Canvas mCanvas;
  private final boolean mEnableCallbackDrawing = true;
  private boolean mInitialized;
  private long mNativeFontManagerHandle;
  private Paint mPaint;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      System.loadLibrary("vipfont");
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ETEngine", 2, localThrowable.getMessage());
    }
  }
  
  public static ETEngine getInstance()
  {
    if (sInstance == null) {
      sInstance = new ETEngine();
    }
    return sInstance;
  }
  
  public static ETEngine getInstanceForRedPacket()
  {
    if (sInstanceRP == null) {
      sInstanceRP = new ETEngine();
    }
    return sInstanceRP;
  }
  
  public static native boolean native_ftf2ttf(String paramString1, String paramString2);
  
  public static native int native_getFontType(String paramString);
  
  public static native boolean native_quickCheck(String paramString1, String paramString2);
  
  public void initEngine(int paramInt1, int paramInt2)
  {
    if (!native_initEngine(paramInt1, paramInt2, true)) {
      throw new Exception("init engine fail");
    }
  }
  
  public boolean isEnableCallbackDrawing()
  {
    return true;
  }
  
  public native void native_colorDisableEffects(ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public native boolean native_containComplexScript(String paramString);
  
  public native void native_doneEngine();
  
  public native boolean native_drawBackground(String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, ETFont paramETFont);
  
  public native boolean native_drawInRect(String paramString, Bitmap paramBitmap, ETFont paramETFont);
  
  public native boolean native_drawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont);
  
  public native boolean native_getFontMetrics(Paint.FontMetrics paramFontMetrics, ETFont paramETFont);
  
  public native boolean native_initEngine(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native boolean native_isFontLoaded(int paramInt);
  
  public native boolean native_isPaintableChar(char paramChar, ETFont paramETFont);
  
  public native boolean native_loadFont(String paramString, int paramInt, boolean paramBoolean);
  
  public native boolean native_measure(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Rect paramRect);
  
  public native void native_printTrace();
  
  public native boolean native_setPersistentFont(ETFont paramETFont);
  
  public native void native_spaceDrawText(String paramString, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
  public native int native_spaceGetTextWidths(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public native int native_spaceMeasureText(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
  public native boolean native_textLayoutHasPreLine(long paramLong);
  
  public native int native_textLayoutLineHeight(long paramLong, int paramInt);
  
  public native int native_textLayoutLineRangeFrom(long paramLong, int paramInt);
  
  public native int native_textLayoutLineRangeTo(long paramLong, int paramInt);
  
  public native int native_textLayoutLineTotal(long paramLong);
  
  public native int native_textLayoutLineWidth(long paramLong, int paramInt);
  
  public native long native_textLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont);
  
  public native void native_textLayoutUnlock(long paramLong);
  
  public void printLog(String paramString)
  {
    Log.e("ETEngine", paramString);
  }
  
  public void spaceCallbackDrawText(String paramString, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    float f = paramPaint.getFontMetrics().ascent;
    paramCanvas.drawText(paramString, paramInt1, paramInt2 - f, paramPaint);
  }
  
  public int spaceCallbackGetTextWidths(String paramString, Paint paramPaint, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat = new float[paramArrayOfInt.length];
    int j = paramPaint.getTextWidths(paramString, arrayOfFloat);
    int i = 0;
    while (i < j)
    {
      paramArrayOfInt[i] = ((int)Math.ceil(arrayOfFloat[i]));
      i += 1;
    }
    return j;
  }
  
  public int spaceCallbackMeasureText(String paramString, Paint paramPaint)
  {
    return (int)Math.ceil(paramPaint.measureText(paramString));
  }
  
  public void sysDrawText(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setColor(paramInt2);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setTextSize(paramInt1);
    this.mPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.mPaint.setFakeBoldText(false);
    if ((paramInt3 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt10, paramInt8, paramInt9, paramInt7);
    }
    if (this.mCanvas == null) {
      this.mCanvas = new Canvas();
    }
    paramInt2 = Math.abs(paramInt6);
    this.mCanvas.setBitmap(paramBitmap);
    this.mCanvas.drawText(paramString, paramInt4, paramInt5 + paramInt2, this.mPaint);
    if ((paramInt3 & 0x8) > 0)
    {
      paramBitmap = new Paint(1);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setColor(paramInt11);
      paramBitmap.setStrokeWidth(paramInt12);
      paramBitmap.setTextSize(paramInt1);
      this.mCanvas.drawText(paramString, paramInt4, paramInt2 + paramInt5, paramBitmap);
    }
  }
  
  public int sysFontHeight(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setTextSize(paramInt1);
    if ((paramInt2 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt6, paramInt4, paramInt5, paramInt3);
    }
    paramString = this.mPaint.getFontMetrics();
    float f2 = paramString.bottom - paramString.top;
    float f1 = f2;
    if ((paramInt2 & 0x8) > 0)
    {
      paramString = new Paint(1);
      paramString.setStyle(Paint.Style.STROKE);
      paramString.setColor(paramInt7);
      paramString.setStrokeWidth(paramInt8);
      paramString.setTextSize(paramInt1);
      paramString = paramString.getFontMetrics();
      f1 = paramString.bottom - paramString.top;
      if (f2 <= f1) {
        break label150;
      }
      f1 = f2;
    }
    label150:
    for (;;)
    {
      return (int)f1;
    }
  }
  
  public int sysMeasureText(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setTextSize(paramInt1);
    if ((paramInt2 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt6, paramInt4, paramInt5, paramInt3);
    }
    float f2 = this.mPaint.measureText(paramString);
    float f1 = f2;
    if ((paramInt2 & 0x8) > 0)
    {
      Paint localPaint = new Paint(1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(paramInt7);
      localPaint.setStrokeWidth(paramInt8);
      localPaint.setTextSize(paramInt1);
      f1 = localPaint.measureText(paramString);
      if (f2 <= f1) {
        break label138;
      }
      f1 = f2;
    }
    label138:
    for (;;)
    {
      return (int)f1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\etrump\mixlayout\ETEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */