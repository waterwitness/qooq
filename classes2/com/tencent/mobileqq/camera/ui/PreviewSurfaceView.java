package com.tencent.mobileqq.camera.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PreviewSurfaceView
  extends SurfaceView
{
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.ui.PreviewSurfacView";
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  public PreviewSurfaceView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PreviewSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreviewSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setZOrderMediaOverlay(true);
    getHolder().setType(3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void a()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Canvas localCanvas = getHolder().lockCanvas(null);
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      localCanvas.drawColor(-16777216);
      if (localCanvas != null) {
        getHolder().unlockCanvasAndPost(localCanvas);
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      localException.printStackTrace();
      return;
    }
    finally
    {
      if (localObject3 != null) {
        getHolder().unlockCanvasAndPost((Canvas)localObject3);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\PreviewSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */