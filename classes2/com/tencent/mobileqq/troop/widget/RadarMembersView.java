package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import vti;

public class RadarMembersView
  extends View
{
  public static final int a = 7;
  public static final String a = "RadarMembersView";
  protected static final int b = 3;
  protected static final int f = 1;
  protected double a;
  protected long a;
  protected Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  protected HandlerThread a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  RadaScanView jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView;
  RadarBgView jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView;
  protected RadarMembersView.OnDrawReadyListener a;
  protected RadarMembersView.OnFirstScanFinishListener a;
  public RadarMembersView.OnMemberIconClickListener a;
  public RadarMembersView.OnScaleListener a;
  protected RadarMembersView.WorkHandler a;
  protected HashSet a;
  public List a;
  protected Map a;
  protected AtomicInteger a;
  protected boolean a;
  protected double b;
  protected Paint b;
  Rect b;
  protected HashSet b;
  protected volatile boolean b;
  protected double c;
  public int c;
  protected HashSet c;
  protected volatile boolean c;
  protected double d;
  public int d;
  protected HashSet d;
  protected volatile boolean d;
  protected double e;
  protected int e;
  protected double f;
  protected double g;
  protected int g;
  protected double h;
  protected int h;
  public double i;
  protected int i;
  protected double j;
  protected double k;
  protected double l;
  protected double m;
  protected volatile double n;
  protected volatile double o;
  
  public RadarMembersView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_g_of_type_Double = Double.MIN_VALUE;
    this.jdField_h_of_type_Double = Double.MAX_VALUE;
    this.jdField_i_of_type_Double = 1.0D;
    this.j = 1.0D;
    this.k = 1.0D;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new vti(this));
    this.o = -1.0D;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a(paramContext);
  }
  
  public RadarMembersView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Double = Double.MIN_VALUE;
    this.jdField_h_of_type_Double = Double.MAX_VALUE;
    this.jdField_i_of_type_Double = 1.0D;
    this.j = 1.0D;
    this.k = 1.0D;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new vti(this));
    this.o = -1.0D;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a(paramContext);
  }
  
  public RadarMembersView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_g_of_type_Double = Double.MIN_VALUE;
    this.jdField_h_of_type_Double = Double.MAX_VALUE;
    this.jdField_i_of_type_Double = 1.0D;
    this.j = 1.0D;
    this.k = 1.0D;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new vti(this));
    this.o = -1.0D;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a(paramContext);
  }
  
  public static double a(int paramInt1, int paramInt2)
  {
    double d1 = 180.0D;
    if (paramInt1 == 0) {
      if (paramInt2 <= 0) {
        d1 = 270.0D;
      }
    }
    do
    {
      return d1;
      return 90.0D;
      if (paramInt2 != 0) {
        break;
      }
    } while (paramInt1 < 0);
    return 0.0D;
    d1 = Math.toDegrees(Math.atan(Math.abs(paramInt2 * 1.0D / paramInt1)));
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      return d1;
    }
    if ((paramInt1 < 0) && (paramInt2 > 0)) {
      return 180.0D - d1;
    }
    if ((paramInt1 < 0) && (paramInt2 < 0)) {
      return 180.0D + d1;
    }
    if ((paramInt1 > 0) && (paramInt2 < 0)) {
      return 360.0D - d1;
    }
    return d1;
  }
  
  public double a()
  {
    return this.jdField_i_of_type_Double;
  }
  
  public double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    paramDouble3 = Math.toRadians(paramDouble3);
    paramDouble4 = Math.toRadians(paramDouble4);
    paramDouble1 = Math.toDegrees(Math.atan2(Math.sin(paramDouble4 - paramDouble2) * Math.cos(paramDouble3), Math.cos(paramDouble1) * Math.sin(paramDouble3) - Math.sin(paramDouble1) * Math.cos(paramDouble3) * Math.cos(paramDouble4 - paramDouble2)));
    if (paramDouble1 >= 0.0D) {
      return -paramDouble1;
    }
    return -(paramDouble1 + 360.0D);
  }
  
  public Point a(long paramLong)
  {
    return (Point)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$WorkHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    if (QLog.isColorLevel()) {
      QLog.i("RadarMembersView", 2, "destroy");
    }
  }
  
  protected void a(double paramDouble)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_c_of_type_JavaUtilHashSet.clear();
    int i3 = (int)(this.jdField_c_of_type_Int - this.jdField_c_of_type_Int * 0.5D);
    int i4 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i4)
    {
      NearbyMember localNearbyMember = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i1);
      Object localObject = (Point)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((localNearbyMember.jdField_c_of_type_Double <= paramDouble) && (!this.jdField_c_of_type_JavaUtilHashSet.contains(Long.valueOf(localNearbyMember.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_AndroidGraphicsRect.set(((Point)localObject).x - i3, ((Point)localObject).y - i3, ((Point)localObject).x + i3, ((Point)localObject).y + i3);
          int i2 = 0;
          label169:
          if (i2 < i4)
          {
            localObject = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i2);
            if (localNearbyMember.jdField_a_of_type_Long != ((NearbyMember)localObject).jdField_a_of_type_Long) {
              break label214;
            }
          }
          for (;;)
          {
            i2 += 1;
            break label169;
            break;
            label214:
            if ((((NearbyMember)localObject).jdField_c_of_type_Double <= paramDouble) && (!this.jdField_c_of_type_JavaUtilHashSet.contains(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long))))
            {
              Point localPoint = (Point)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long));
              if (localPoint != null)
              {
                this.jdField_b_of_type_AndroidGraphicsRect.set(localPoint.x - i3, localPoint.y - i3, localPoint.x + i3, localPoint.y + i3);
                if (this.jdField_a_of_type_AndroidGraphicsRect.intersect(this.jdField_b_of_type_AndroidGraphicsRect)) {
                  if (localNearbyMember.jdField_e_of_type_Int == 1)
                  {
                    this.jdField_c_of_type_JavaUtilHashSet.add(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long));
                  }
                  else
                  {
                    if (((NearbyMember)localObject).jdField_e_of_type_Int == 1)
                    {
                      this.jdField_c_of_type_JavaUtilHashSet.add(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
                      break;
                    }
                    if (localNearbyMember.jdField_c_of_type_Double > ((NearbyMember)localObject).jdField_c_of_type_Double) {
                      break label408;
                    }
                    this.jdField_c_of_type_JavaUtilHashSet.add(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long));
                  }
                }
              }
            }
          }
          label408:
          this.jdField_c_of_type_JavaUtilHashSet.add(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
        }
      }
    }
    this.jdField_b_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.addAll(this.jdField_c_of_type_JavaUtilHashSet);
    this.jdField_d_of_type_Boolean = true;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("RadarMembersView.hide", 2, "calcHidePoints:" + (l2 - l1) + ", " + this.jdField_b_of_type_JavaUtilHashSet.size());
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_c_of_type_Int = DisplayUtil.a(getContext(), 7.0F);
    this.jdField_d_of_type_Int = DisplayUtil.a(getContext(), 3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#80ffffff"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(2.0F, 1.0F, 1.0F, Color.parseColor("#80ffffff"));
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RadarMembersView");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$WorkHandler = new RadarMembersView.WorkHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    try
    {
      this.jdField_e_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("RadarMembersView", 2, "init:" + paramContext.toString());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener = null;
  }
  
  protected void b(double paramDouble)
  {
    if (this.f == 0.0D) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      if (i1 < i2)
      {
        NearbyMember localNearbyMember = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i1);
        Point localPoint2 = (Point)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
        Point localPoint1 = localPoint2;
        if (localPoint2 == null) {
          localPoint1 = new Point();
        }
        double d1 = Math.max(this.jdField_c_of_type_Double, localNearbyMember.jdField_c_of_type_Double / paramDouble * this.jdField_e_of_type_Double);
        localPoint1.x = ((int)(Math.cos(localNearbyMember.jdField_e_of_type_Double) * d1 + this.jdField_g_of_type_Int));
        localPoint1.y = ((int)(d1 * Math.sin(localNearbyMember.jdField_e_of_type_Double) + this.jdField_h_of_type_Int));
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localNearbyMember.jdField_a_of_type_Long), localPoint1);
        if (localNearbyMember.jdField_c_of_type_Double > paramDouble) {
          this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localNearbyMember.jdField_a_of_type_Long));
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("RadarMembersView.xy", 2, "calcXY:" + (l2 - l1) + ", " + this.jdField_a_of_type_JavaUtilList.size() + ", curScanDis:" + paramDouble);
  }
  
  public void c(double paramDouble)
  {
    b(paramDouble);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$WorkHandler.removeMessages(1);
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Double.valueOf(paramDouble);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$WorkHandler.sendMessageDelayed(localMessage, 15L);
    invalidate();
  }
  
  public void d(double paramDouble)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) || (this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
      return;
    }
    if (this.o < 0.0D)
    {
      this.jdField_c_of_type_Boolean = true;
      this.n = paramDouble;
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.o = (paramDouble % 360.0D);
        postInvalidate();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("RadarMembersView.scanchange", 2, "isInFirstScan:" + this.jdField_c_of_type_Boolean + ", isScanRepeated:" + this.jdField_b_of_type_Boolean + ", " + paramDouble + ", " + (paramDouble - this.n));
      return;
      if (paramDouble - this.n > 360.0D)
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnFirstScanFinishListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnFirstScanFinishListener.a();
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    int i1 = -1;
    int i6 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = 0;
    Object localObject;
    if (i2 < i6)
    {
      localObject = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i2);
      l2 = ((NearbyMember)localObject).jdField_a_of_type_Long;
      int i5 = 255;
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(128);
      int i4;
      if (!this.jdField_c_of_type_Boolean) {
        i4 = i1;
      }
      Point localPoint;
      int i3;
      label240:
      label298:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                i2 += 1;
                i1 = i4;
                break;
                localPoint = (Point)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l2));
                i4 = i1;
              } while (localPoint == null);
              i4 = i1;
            } while (((NearbyMember)localObject).jdField_c_of_type_Double > this.j);
            i3 = i1;
            if (((NearbyMember)localObject).jdField_c_of_type_Double <= this.jdField_i_of_type_Double) {
              break label240;
            }
            i4 = i1;
          } while (!this.jdField_a_of_type_Boolean);
          i3 = (int)((1.0D - (((NearbyMember)localObject).jdField_c_of_type_Double - this.jdField_i_of_type_Double) / (this.j - this.jdField_i_of_type_Double) * 2.0D) * 240.0D);
          i4 = i3;
          if (i3 < 0) {
            i4 = 0;
          }
          this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(i4);
          i5 = i4;
          i3 = i1;
          if (i1 == -1)
          {
            i3 = i2;
            i5 = i4;
          }
          i4 = i3;
        } while (this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(l2)));
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) || (this.jdField_b_of_type_Boolean)) {
          break label323;
        }
        if (!this.jdField_d_of_type_JavaUtilHashSet.contains(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long))) {
          break label408;
        }
        i1 = 1;
        i4 = i3;
      } while (i1 == 0);
      this.jdField_d_of_type_JavaUtilHashSet.add(Long.valueOf(((NearbyMember)localObject).jdField_a_of_type_Long));
      label323:
      if (((NearbyMember)localObject).jdField_e_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(37026);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i5);
        paramCanvas.drawCircle(localPoint.x, localPoint.y, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawCircle(localPoint.x, localPoint.y, this.jdField_c_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
        i4 = i3;
        break;
        label408:
        double d1 = a(localPoint.x - this.jdField_g_of_type_Int, localPoint.y - this.jdField_g_of_type_Int);
        double d2 = this.o;
        double d3 = d2 - 10.0D;
        if (d3 >= 0.0D)
        {
          if ((d1 >= d3) && (d1 <= d2))
          {
            i1 = 1;
            break label298;
          }
          i1 = 0;
          break label298;
        }
        if (((d1 >= 0.0D) && (d1 <= d2)) || ((d1 >= 360.0D - (15.0D - d2)) && (d1 <= 360.0D)))
        {
          i1 = 1;
          break label298;
        }
        i1 = 0;
        break label298;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-12331521);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener != null) && (i6 > 0))
    {
      paramCanvas = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener;
      localObject = this.jdField_a_of_type_JavaUtilList;
      i2 = i1;
      if (i1 == -1) {
        i2 = 0;
      }
      paramCanvas.a(((NearbyMember)((List)localObject).get(i2)).jdField_a_of_type_Long);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("RadarMembersView.draw", 2, "onDraw:" + (l2 - l1) + ", " + this.jdField_a_of_type_JavaUtilList.size() + "," + this.jdField_a_of_type_JavaUtilHashSet.size() + "," + this.jdField_b_of_type_JavaUtilHashSet.size());
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_g_of_type_Int = (getWidth() / 2);
    this.jdField_h_of_type_Int = this.jdField_g_of_type_Int;
    this.jdField_i_of_type_Int = getWidth();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || ((this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))) {}
    label225:
    label521:
    label544:
    do
    {
      int i1;
      int i2;
      int i3;
      do
      {
        do
        {
          return true;
          i1 = paramMotionEvent.getPointerCount();
          if (i1 == 1) {
            return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
          }
        } while (i1 < 2);
        i1 = paramMotionEvent.getAction() & 0xFF;
        i2 = (int)paramMotionEvent.getX(0) - (int)paramMotionEvent.getX(1);
        i3 = (int)paramMotionEvent.getY(0) - (int)paramMotionEvent.getY(1);
        switch (i1)
        {
        case 4: 
        default: 
          return true;
        case 2: 
          i2 = (int)Math.sqrt(i2 * i2 + i3 * i3);
        }
      } while (Math.abs(i2 - this.m) < this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Boolean = true;
      if (this.l != 0.0D)
      {
        double d1 = i2 / this.l;
        this.jdField_i_of_type_Double = (this.k / d1);
        if (this.jdField_i_of_type_Double >= this.jdField_h_of_type_Double) {
          break label521;
        }
        this.jdField_i_of_type_Double = this.jdField_h_of_type_Double;
        this.j = (this.jdField_i_of_type_Double * this.jdField_d_of_type_Double / this.jdField_e_of_type_Double);
        if (QLog.isColorLevel()) {
          QLog.i("RadarMembersView.touch", 2, "ACTION_MOVE:" + Math.abs(i2 - this.m) + ", " + this.jdField_e_of_type_Int + ", " + this.jdField_i_of_type_Double);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView != null) && ((i2 <= this.m) || (this.jdField_i_of_type_Double != this.jdField_h_of_type_Double))) {
          break label544;
        }
      }
      for (;;)
      {
        this.m = i2;
        c(this.jdField_i_of_type_Double);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener.a(a(), this.jdField_a_of_type_JavaUtilHashSet);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilHashSet, this.jdField_a_of_type_JavaUtilMap);
        return true;
        this.l = Math.sqrt(i2 * i2 + i3 * i3);
        this.m = this.l;
        this.k = this.jdField_i_of_type_Double;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener.b(a(), this.jdField_a_of_type_JavaUtilHashSet);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilHashSet, this.jdField_a_of_type_JavaUtilMap);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView.a(i1, (int)this.l);
        }
        invalidate();
        return true;
        if (this.jdField_i_of_type_Double <= this.jdField_g_of_type_Double) {
          break label225;
        }
        this.jdField_i_of_type_Double = this.jdField_g_of_type_Double;
        break label225;
        if ((i2 >= this.m) || (this.jdField_i_of_type_Double != this.jdField_g_of_type_Double)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView.a(i1, i2);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView.a(i1, 0);
      }
      c(this.jdField_i_of_type_Double);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener.c(a(), this.jdField_a_of_type_JavaUtilHashSet);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilHashSet, this.jdField_a_of_type_JavaUtilMap);
    return true;
  }
  
  public void setMembers(List paramList)
  {
    long l1 = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.f();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$WorkHandler.removeMessages(1);
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilHashSet.clear();
      this.jdField_c_of_type_JavaUtilHashSet.clear();
      this.jdField_d_of_type_JavaUtilHashSet.clear();
      this.jdField_g_of_type_Double = Double.MIN_VALUE;
      this.jdField_h_of_type_Double = Double.MAX_VALUE;
      this.jdField_a_of_type_Boolean = false;
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        NearbyMember localNearbyMember = (NearbyMember)paramList.get(i1);
        if (localNearbyMember.jdField_c_of_type_Double > this.jdField_g_of_type_Double) {
          this.jdField_g_of_type_Double = localNearbyMember.jdField_c_of_type_Double;
        }
        if (localNearbyMember.jdField_c_of_type_Double < this.jdField_h_of_type_Double) {
          this.jdField_h_of_type_Double = localNearbyMember.jdField_c_of_type_Double;
        }
        localNearbyMember.jdField_d_of_type_Double = a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, localNearbyMember.jdField_a_of_type_Double, localNearbyMember.jdField_b_of_type_Double);
        localNearbyMember.jdField_e_of_type_Double = Math.toRadians(localNearbyMember.jdField_d_of_type_Double);
        this.jdField_a_of_type_JavaUtilList.add(localNearbyMember);
        i1 += 1;
      }
      if (this.jdField_g_of_type_Double < 10000.0D) {
        this.jdField_g_of_type_Double = 10000.0D;
      }
      this.jdField_i_of_type_Double = this.jdField_g_of_type_Double;
      this.j = (this.jdField_i_of_type_Double * this.jdField_d_of_type_Double / this.jdField_e_of_type_Double);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("RadarMembersView", 2, "setMembers:" + (l2 - l1) + "," + i2 + "," + this.jdField_g_of_type_Double + "," + this.jdField_h_of_type_Double);
      }
      return;
    }
  }
  
  public void setMyselfGps(double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
  }
  
  public void setOnDrawReadyListener(RadarMembersView.OnDrawReadyListener paramOnDrawReadyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener = paramOnDrawReadyListener;
  }
  
  public void setOnFirstScanFinishListener(RadarMembersView.OnFirstScanFinishListener paramOnFirstScanFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnFirstScanFinishListener = paramOnFirstScanFinishListener;
  }
  
  public void setOnMemberIconClickListener(RadarMembersView.OnMemberIconClickListener paramOnMemberIconClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnMemberIconClickListener = paramOnMemberIconClickListener;
  }
  
  public void setOnScaleListener(RadarMembersView.OnScaleListener paramOnScaleListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnScaleListener = paramOnScaleListener;
  }
  
  public void setRadaScanView(RadaScanView paramRadaScanView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView = paramRadaScanView;
  }
  
  public void setRadarBgView(RadarBgView paramRadarBgView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView = paramRadarBgView;
  }
  
  public void setRadius(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.jdField_d_of_type_Double = paramDouble2;
    this.jdField_c_of_type_Double = paramDouble1;
    this.jdField_e_of_type_Double = paramDouble3;
    this.f = paramDouble4;
  }
  
  public void setSelection(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView != null)
    {
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.setSelection(paramLong, this.jdField_a_of_type_JavaUtilHashSet, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void setShowRange(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble < this.jdField_h_of_type_Double) {
      d1 = this.jdField_h_of_type_Double;
    }
    this.jdField_i_of_type_Double = d1;
    this.j = (this.jdField_i_of_type_Double * this.jdField_d_of_type_Double / this.jdField_e_of_type_Double);
    c(this.jdField_i_of_type_Double);
    if (QLog.isColorLevel()) {
      QLog.i("RadarMembersView", 2, "setShowRange:" + d1 + "," + this.jdField_i_of_type_Double);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadarMembersView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */