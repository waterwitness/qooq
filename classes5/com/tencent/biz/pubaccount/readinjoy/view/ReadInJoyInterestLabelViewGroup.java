package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.CirclePageIndicator;
import cooperation.readinjoy.ReadInJoyHelper;
import ibw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadInJoyInterestLabelViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ReadInJoyViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  private ibw jdField_a_of_type_Ibw;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public ReadInJoyInterestLabelViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt)
  {
    super(paramReadInJoyBaseViewController, paramInt, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a().getLayoutInflater().inflate(2130903757, this);
    paramReadInJoyBaseViewController = ReadInJoyLogicEngine.a().a();
    if ((paramReadInJoyBaseViewController != null) && (!paramReadInJoyBaseViewController.isEmpty())) {
      a();
    }
    paramReadInJoyBaseViewController = findViewById(2131299970);
    if (ThemeUtil.isInNightMode(((BaseActivity)a()).app)) {
      if (paramReadInJoyBaseViewController != null) {
        paramReadInJoyBaseViewController.setVisibility(0);
      }
    }
    while (paramReadInJoyBaseViewController == null) {
      return;
    }
    paramReadInJoyBaseViewController.setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-3355444);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839521);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840447);
  }
  
  public long a()
  {
    return 0L;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    ((LinearLayout)findViewById(2131299968)).setVisibility(8);
    Object localObject3 = ReadInJoyLogicEngine.a().a();
    Object localObject1 = ReadInJoyLogicEngine.a().a();
    if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
    }
    Object localObject2 = (TextView)findViewById(2131299963);
    localObject1 = (TextView)findViewById(2131299964);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager = ((ReadInJoyViewPager)findViewById(2131299965));
    this.jdField_a_of_type_Ibw = new ibw(this, (List)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Ibw.a(this);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131299966));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager.setAdapter(this.jdField_a_of_type_Ibw);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(ViewUtils.a(10.0F));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager);
    if (this.jdField_a_of_type_Ibw.getCount() <= 1)
    {
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299967));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (ViewUtils.a() >= 2.0F) {
        break label360;
      }
      localObject3 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.a(30.0F);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.a(8.0F);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ViewUtils.a(235.0F);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(10.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(10.0F);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(30.0F);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      f();
      return;
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(0);
      break;
      label360:
      localObject3 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.a(35.0F);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.a(8.0F);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ViewUtils.a(265.0F);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(15.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyViewPager.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(20.0F);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(50.0F);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Map paramMap) {}
  
  public void a(Map paramMap, boolean paramBoolean) {}
  
  public void a(Set paramSet, Map paramMap) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(Map paramMap) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    do
    {
      return;
      ReadInJoyHelper.b(((BaseActivity)a()).app);
      ReadInJoyLogicEngine.a().a(2, 1);
      ReportController.b(null, "CliOper", "", "", "0X80067DB", "0X80067DB", 0, 0, "", "", "", ReadInJoyUtils.c());
      if (!NetworkUtil.a(a().getApplication().getApplicationContext()))
      {
        QQToast.a(a(), a().getResources().getString(2131362978), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
        return;
      }
      paramView = new ArrayList();
      localObject1 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Integer)localIterator.next();
        localObject2 = (InterestLabelInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
        paramView.add(Integer.valueOf(((InterestLabelInfo)localObject2).mInterestLabelID));
        ((List)localObject1).add(localObject2);
      }
      ReadInJoyLogicEngine.a().b((List)localObject1);
      ReadInJoyLogicEngine.a().c(paramView);
      return;
      localObject1 = (InterestLabelInfo)paramView.getTag(2131362961);
    } while (localObject1 == null);
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if ((InterestLabelInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID)) == null) {
        break label351;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID));
      paramView.setTextColor(-15550475);
      paramView.setBackgroundResource(2130839522);
    }
    for (;;)
    {
      f();
      return;
      label351:
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID), localObject1);
      paramView.setTextColor(-1);
      paramView.setBackgroundResource(2130839523);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyInterestLabelViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */