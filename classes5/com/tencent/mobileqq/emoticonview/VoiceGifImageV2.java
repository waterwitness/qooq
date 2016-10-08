package com.tencent.mobileqq.emoticonview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifIndex8;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VoiceGifImageV2
  extends NativeGifIndex8
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public VoiceGifImageV2(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = true;
  }
  
  public void a()
  {
    this.a = true;
  }
  
  public void b()
  {
    this.a = false;
    this.b = true;
  }
  
  protected void doApplyNextFrame()
  {
    super.doApplyNextFrame();
    if (this.c)
    {
      this.c = false;
      this.b = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.a) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      if (!this.b) {
        break;
      }
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
    return;
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.b)
      {
        this.c = true;
        super.reset();
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\VoiceGifImageV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */