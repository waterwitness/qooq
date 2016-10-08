package com.tencent.biz.troopgift;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RadioViewPager
  extends RelativeLayout
{
  protected GridListViewPager a;
  protected RadioButtonIndicator a;
  
  public RadioViewPager(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RadioViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator = new RadioButtonIndicator(paramContext);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(12);
    paramAttributeSet.bottomMargin = 20;
    paramAttributeSet.addRule(14);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager = new GridListViewPager(paramContext);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPagerSizeChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    addView(this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager);
    addView(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator, paramAttributeSet);
  }
  
  public absMultiViewPager a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\RadioViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */