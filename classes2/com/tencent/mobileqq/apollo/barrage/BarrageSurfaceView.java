package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Iterator;
import java.util.List;

public class BarrageSurfaceView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback, BarrageUI
{
  private static final String jdField_a_of_type_JavaLangString = "BarrageSurfaceView";
  private static final int b = 13;
  private static final int c = 14;
  private static final int d = 15;
  private static final int e = 16;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  private AbsDrawer jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private int f;
  private int g;
  
  public BarrageSurfaceView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BarrageSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b();
  }
  
  private void b()
  {
    super.setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = super.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-3);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public AbsBarrageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  }
  
  public void a()
  {
    super.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a(true);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder.removeCallback(this);
  }
  
  public void a(Barrage paramBarrage)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {}
    while (paramBarrage == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(14);
    localMessage.obj = paramBarrage;
    localMessage.sendToTarget();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {}
    while (paramList == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(13);
    localMessage.obj = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(15).sendToTarget();
  }
  
  public int b()
  {
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null);
          localObject = (List)paramMessage.obj;
          if (paramMessage.arg1 > 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a(false);
          }
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            paramMessage = ((List)localObject).iterator();
            while (paramMessage.hasNext()) {
              ((Barrage)paramMessage.next()).a();
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a((List)localObject);
          c();
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null);
        paramMessage = (Barrage)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a(paramMessage);
        c();
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a(false);
      c();
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null);
    long l = System.currentTimeMillis();
    localObject = null;
    paramMessage = null;
    boolean bool2 = true;
    SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceHolder;
    bool1 = bool2;
    for (;;)
    {
      try
      {
        localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.save();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer.a(localCanvas, 1.0F);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.restore();
        bool3 = bool2;
        if (localCanvas == null) {}
      }
      catch (Exception localException)
      {
        Canvas localCanvas;
        localObject = paramMessage;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = paramMessage;
        QLog.e("BarrageSurfaceView", 2, localException.getMessage());
        boolean bool3 = bool1;
        if (paramMessage == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramMessage);
        bool3 = bool1;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject);
      }
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        bool3 = bool2;
        if ((bool3) && (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)) {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(16, 20L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("BarrageSurfaceView", 2, "handle MSG_CODE_DRAW_BARRAGE use->" + (System.currentTimeMillis() - l));
        }
        return false;
      }
      finally {}
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer = new CanvasDrawer();
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Barrage-Surface-Thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\barrage\BarrageSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */