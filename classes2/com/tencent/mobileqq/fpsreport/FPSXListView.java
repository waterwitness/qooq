package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mfsdk.collector.FPSCalculator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class FPSXListView
  extends XListView
{
  private FPSCalculator jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator;
  private String jdField_a_of_type_JavaLangString;
  
  public FPSXListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    if ("actFPSLeba".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (paramInt == 0) {
        DropFrameMonitor.a().a("list_leba", false);
      }
    }
    else {
      return;
    }
    DropFrameMonitor.a().a("list_leba");
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.b();
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fpsreport\FPSXListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */