package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.SwipListView;
import hul;
import hum;
import hun;
import huo;
import hup;
import java.lang.ref.WeakReference;
import java.util.List;

public class EcShopRecommendView
{
  int jdField_a_of_type_Int;
  public View a;
  public ViewStub a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  EcShopRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter;
  private EcShopRecommendView.onRecommendListener jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener;
  public QQAppInterface a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public WeakReference a;
  View b;
  
  public EcShopRecommendView(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.b = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968721);
        localAnimation.setFillAfter(true);
        localAnimation.setAnimationListener(new hup(this));
        a(0);
        this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.a();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    SwipListView localSwipListView;
    do
    {
      return;
      localSwipListView = (SwipListView)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131298718);
    } while (localSwipListView == null);
    localSwipListView.setPadding(0, 0, 0, DisplayUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramInt));
  }
  
  public void a(EcShopRecommendView.onRecommendListener paramonRecommendListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener = paramonRecommendListener;
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.getCount() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.notifyDataSetChanged();
    }
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131299879));
      if (this.jdField_a_of_type_AndroidViewViewStub != null)
      {
        this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(new hul(this));
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null)
        {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299887));
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter = new EcShopRecommendAdapter((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter);
        }
        if (this.jdField_a_of_type_AndroidWidgetImageButton == null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131296906));
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new hum(this));
        }
        if (this.b == null)
        {
          this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131299884);
          this.b.setOnClickListener(new hun(this));
        }
        VipUtils.a(null, "Shop_lifeservice", "Shop_ulike", "clk_shopulike", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.a(paramList);
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView$onRecommendListener.b();
      return;
      c();
      a(216);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968722);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new huo(this));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopRecommendView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */