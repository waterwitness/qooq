package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseListViewGroup
  extends LinearLayout
{
  public static final int a = 20;
  protected ReadInJoyBaseViewController a;
  protected ReadInJoyPageItemCache a;
  public int b;
  
  public ReadInJoyBaseListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController.a());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = paramReadInJoyBaseViewController;
    if (paramReadInJoyPageItemCache == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.a = ReadInJoyHelper.a(paramInt, (QQAppInterface)ReadInJoyUtils.a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = paramReadInJoyPageItemCache;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.g = 1;
  }
  
  public abstract long a();
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
  }
  
  public abstract String a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map paramMap);
  
  public abstract void a(Map paramMap, boolean paramBoolean);
  
  public abstract void a(Set paramSet, Map paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(Map paramMap);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyBaseListViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */