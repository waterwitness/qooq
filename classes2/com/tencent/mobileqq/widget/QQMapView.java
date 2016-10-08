package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import wnu;
import wnv;

public class QQMapView
  extends MapView
{
  static final String jdField_a_of_type_JavaLangString = "QQMapView";
  static final int c = 0;
  static final int d = 1;
  public Handler a;
  public QQMapView.QQMapViewObserver a;
  public GeoPoint a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public Thread a;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  public boolean c;
  public boolean d;
  public int e;
  protected boolean e;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.b = false;
    this.jdField_a_of_type_AndroidOsHandler = new wnu(this);
    this.jdField_a_of_type_JavaLangRunnable = new wnv(this);
    this.jdField_a_of_type_JavaLangThread = ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, "qqmapview_calculate_position", 8);
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public Message a(int paramInt, GeoPoint paramGeoPoint)
  {
    Message localMessage = new Message();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramGeoPoint;
    return localMessage;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.jdField_e_of_type_Int += 1;
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null) && (this.jdField_a_of_type_JavaLangThread != null)) {
      synchronized (this.jdField_a_of_type_JavaLangThread)
      {
        this.jdField_a_of_type_JavaLangThread.notify();
        return;
      }
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = null;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((this.c) && (this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = false;
        this.d = true;
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = getMapCenter();
        if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver.c(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.Copy());
          continue;
          this.c = true;
          this.jdField_e_of_type_Boolean = true;
          continue;
          this.c = false;
          computeScroll();
        }
      }
    }
  }
  
  public void setObserver(QQMapView.QQMapViewObserver paramQQMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = paramQQMapViewObserver;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\QQMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */