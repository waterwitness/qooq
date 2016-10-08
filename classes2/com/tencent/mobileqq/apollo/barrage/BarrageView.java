package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;
import prb;

public class BarrageView
  extends View
  implements Handler.Callback, BarrageUI
{
  private static final float jdField_a_of_type_Float = 500.0F;
  private static final String jdField_a_of_type_JavaLangString = "BarrageView";
  private static final int b = 255;
  private static final int c = 256;
  private static final int d = 257;
  private static final int e = 258;
  private static final int f = 259;
  private static final int g = 0;
  private static final int h = 1;
  private long jdField_a_of_type_Long;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  private CanvasDrawer jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  private int i;
  
  public BarrageView(Context paramContext)
  {
    super(paramContext);
    this.i = 0;
    c();
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = 0;
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer = new CanvasDrawer();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(259);
  }
  
  public int a()
  {
    return super.getWidth();
  }
  
  public AbsBarrageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(true);
  }
  
  public void a(Barrage paramBarrage)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(257, paramBarrage).sendToTarget();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.b().post(new prb(paramList, this));
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReferenceHandler localWeakReferenceHandler;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a())
    {
      localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int j = 1;; j = 0)
    {
      localWeakReferenceHandler.obtainMessage(258, j, 0).sendToTarget();
      return;
    }
  }
  
  public int b()
  {
    return super.getHeight();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 256: 
      List localList = (List)paramMessage.obj;
      if (paramMessage.arg1 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(localList);
      this.i = 0;
      super.setVisibility(0);
      d();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 257: 
      paramMessage = (Barrage)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramMessage);
      this.i = 0;
      d();
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 258: 
      if (paramMessage.arg1 > 0) {
        this.i = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        d();
        this.jdField_a_of_type_Boolean = false;
        return false;
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
        super.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(259);
    invalidate();
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    System.currentTimeMillis();
    super.onDraw(paramCanvas);
    if (this.i == 1)
    {
      f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 500.0F;
      if (f1 < 1.0F) {
        f1 = 1.0F - f1;
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(paramCanvas, f1)) {
        break label94;
      }
      if (!this.jdField_a_of_type_Boolean) {
        super.invalidate();
      }
    }
    label94:
    do
    {
      return;
      this.i = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageCanvasDrawer.a(false);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(259, 20L);
      return;
      super.setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("BarrageView", 2, "BarrageView setVisibility(GONE)");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\barrage\BarrageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */