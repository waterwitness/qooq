package com.tencent.av.funchat.magicface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceViewForAV
  extends SurfaceView
  implements SurfaceHolder.Callback, IMagicFaceViewForAV
{
  private static int jdField_a_of_type_Int = 720;
  private static final String jdField_a_of_type_JavaLangString = "MagicfaceViewForAV";
  private static int b = 1280;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private MagicfaceViewForAV.SurfaceCreateListener jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewForAV$SurfaceCreateListener;
  public volatile boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MagicfaceViewForAV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  private void a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Rect paramRect)
  {
    Object localObject2 = null;
    localCanvas2 = null;
    localCanvas1 = localCanvas2;
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        i = getWidth();
        localCanvas1 = localCanvas2;
        localObject1 = localObject2;
        j = getHeight();
        localCanvas1 = localCanvas2;
        localObject1 = localObject2;
        localCanvas2 = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas(null);
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        Paint localPaint = new Paint();
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localCanvas2.drawPaint(localPaint);
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localPaint.setFilterBitmap(true);
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localPaint.setAntiAlias(true);
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        localRect = new Rect();
        if ((paramBoolean1) && (paramBoolean2))
        {
          localCanvas1 = localCanvas2;
          localObject1 = localCanvas2;
          localRect.top = 0;
          localCanvas1 = localCanvas2;
          localObject1 = localCanvas2;
          localRect.left = 0;
          localCanvas1 = localCanvas2;
          localObject1 = localCanvas2;
          localRect.right = i;
          localCanvas1 = localCanvas2;
          localObject1 = localCanvas2;
          localRect.bottom = j;
          localObject2 = localRect;
          localCanvas1 = localCanvas2;
          localObject1 = localCanvas2;
          localCanvas2.drawBitmap(paramBitmap, null, (Rect)localObject2, localPaint);
          if (localCanvas2 != null) {
            this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas2);
          }
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        int j;
        Rect localRect;
        localObject1 = localCanvas1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localCanvas1;
        QLog.d("MagicfaceViewForAV", 2, "==frameData=error=" + paramBitmap.toString());
        if (localCanvas1 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas1);
        return;
        float f = j;
        localCanvas1 = localCanvas2;
        localObject1 = localCanvas2;
        int i = b;
        f = f * 1.0F / i;
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject1);
      }
      localObject2 = localRect;
      if (!paramBoolean1)
      {
        localObject2 = localRect;
        if (!paramBoolean2)
        {
          localObject2 = localRect;
          if (!paramBoolean3)
          {
            localObject2 = localRect;
            if (!paramBoolean4)
            {
              localObject2 = localRect;
              if (!paramBoolean3)
              {
                localObject2 = localRect;
                if (!paramBoolean4)
                {
                  localCanvas1 = localCanvas2;
                  localObject1 = localCanvas2;
                  paramRect = new Rect(paramRect);
                  localCanvas1 = localCanvas2;
                  localObject1 = localCanvas2;
                  if (b * i > jdField_a_of_type_Int * j) {
                    continue;
                  }
                  localCanvas1 = localCanvas2;
                  localObject1 = localCanvas2;
                  f = i * 1.0F / jdField_a_of_type_Int;
                  localObject2 = paramRect;
                  if (f != 1.0F)
                  {
                    localCanvas1 = localCanvas2;
                    localObject1 = localCanvas2;
                    paramRect.left = ((int)(paramRect.left * f));
                    localCanvas1 = localCanvas2;
                    localObject1 = localCanvas2;
                    paramRect.top = ((int)(paramRect.top * f));
                    localCanvas1 = localCanvas2;
                    localObject1 = localCanvas2;
                    paramRect.right = ((int)(paramRect.right * f));
                    localCanvas1 = localCanvas2;
                    localObject1 = localCanvas2;
                    paramRect.bottom = ((int)(f * paramRect.bottom));
                    localObject2 = paramRect;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceViewForAV.SurfaceCreateListener paramSurfaceCreateListener)
  {
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewForAV$SurfaceCreateListener = paramSurfaceCreateListener;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewForAV$SurfaceCreateListener != null) {
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewForAV$SurfaceCreateListener.a();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceViewForAV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */