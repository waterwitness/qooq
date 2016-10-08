package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mfsdk.collector.FPSCalculator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class FPSPinnedHeaderExpandableListView
  extends SwipPinnedHeaderExpandableListView
{
  private FPSCalculator jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private long h;
  
  public FPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a();
    }
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      PerformanceReportUtils.a(this.b, SystemClock.uptimeMillis());
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.h = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fpsreport\FPSPinnedHeaderExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */