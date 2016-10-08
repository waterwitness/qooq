package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import vtj;

public class RadarView
  extends RelativeLayout
{
  protected Context a;
  protected DisplayMetrics a;
  public RadaScanView a;
  public RadarBgView.OnBackgroundReadyListener a;
  protected RadarBgView a;
  public RadarMembersView a;
  protected final String a;
  
  public RadarView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "RadarView";
    a(paramContext);
  }
  
  public RadarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "RadarView";
    a(paramContext);
  }
  
  public RadarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "RadarView";
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
    StartupTracker.a(null, "troop_nearby_mem_radar_view_init");
    LayoutInflater.from(getContext()).inflate(2130903925, this);
    StartupTracker.a("troop_nearby_mem_radar_view_init", "troop_nearby_mem_radar_bg_view_init");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView = ((RadarBgView)findViewById(2131300674));
    StartupTracker.a("troop_nearby_mem_radar_bg_view_init", "troop_nearby_mem_radar_view_init");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView = ((RadarMembersView)findViewById(2131300675));
    StartupTracker.a("troop_nearby_mem_radar_view_init", "troop_nearby_mem_scan_view_init");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView = ((RadaScanView)findViewById(2131300676));
    StartupTracker.a("troop_nearby_mem_scan_view_init", "troop_nearby_mem_radar_view_init");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setRadarBgView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setRadaScanView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView.setOnBackgroundReadyListenerr(new vtj(this));
    StartupTracker.a("troop_nearby_mem_radar_view_init", null);
  }
  
  public double a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.a();
    }
    return 1.0D;
  }
  
  public int a()
  {
    try
    {
      i = ((Integer)Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue();
      i = getResources().getDimensionPixelSize(i);
      int j = i;
      if (i == 0) {
        j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 26.0F);
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.b();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.d();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (j < i) {}
    for (;;)
    {
      super.onMeasure(paramInt2, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.i("RadarView", 2, "onMeasure:" + this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + "," + this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels + "," + i + "," + j);
      }
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.setApp(paramQQAppInterface);
  }
  
  public void setMyselfGps(double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setMyselfGps(paramDouble1, paramDouble2);
  }
  
  public void setNearbyMembers(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setMembers(paramList);
    paramList = new AlphaAnimation(0.0F, 1.0F);
    paramList.setDuration(500L);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.startAnimation(paramList);
  }
  
  public void setOnBackgroundReadyListener(RadarBgView.OnBackgroundReadyListener paramOnBackgroundReadyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener = paramOnBackgroundReadyListener;
  }
  
  public void setOnFirstScanFinishListener(RadarMembersView.OnFirstScanFinishListener paramOnFirstScanFinishListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setOnFirstScanFinishListener(paramOnFirstScanFinishListener);
    }
  }
  
  public void setOnMemberIconClickListener(RadarMembersView.OnMemberIconClickListener paramOnMemberIconClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setOnMemberIconClickListener(paramOnMemberIconClickListener);
    }
  }
  
  public void setOnScaleListener(RadarMembersView.OnScaleListener paramOnScaleListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setOnScaleListener(paramOnScaleListener);
    }
  }
  
  public void setSelection(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setSelection(paramLong);
  }
  
  public void setShowRange(double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setShowRange(paramDouble);
    }
  }
  
  public void setStartScan(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.b();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView.c();
  }
  
  public void setmRadarMembersViewOnDrawListener(RadarMembersView.OnDrawReadyListener paramOnDrawReadyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView.setOnDrawReadyListener(paramOnDrawReadyListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */