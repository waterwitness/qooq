package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.BannerConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import wmb;

public class EcShopADView
  extends ADViewIndividuation
{
  private WorkSpaceView.OnScreenChangeListener a;
  
  public EcShopADView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EcShopADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener = new wmb(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener);
      if ((paramView instanceof FrameLayout))
      {
        paramView = (ImageView)paramView.findViewById(2131298834);
        if ((paramView != null) && ((paramView.getTag() instanceof EcShopAssistantManager.BannerConfig))) {
          ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_banner", "Pv_shopbanner", 0, 0, "", "", ((EcShopAssistantManager.BannerConfig)paramView.getTag()).d, "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\EcShopADView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */