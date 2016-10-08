package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public abstract class FNBaseItemData
{
  public int a;
  public long a;
  public FreshNewsInfo a;
  public boolean a;
  public String e;
  
  public FNBaseItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = paramFreshNewsInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo == null) {
      throw new RuntimeException("FNBaseItemData| freshNewsInfo must be not null!!");
    }
    this.e = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishState;
  }
  
  protected abstract void a(Context paramContext, AppInterface paramAppInterface);
  
  public void a(Canvas paramCanvas) {}
  
  protected void a(FreshNewsInfo paramFreshNewsInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = paramFreshNewsInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof FNBaseItemData)) && (Utils.a(((FNBaseItemData)paramObject).e, this.e)); bool = false) {
      return true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNBaseItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */