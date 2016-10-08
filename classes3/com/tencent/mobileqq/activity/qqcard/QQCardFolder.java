package com.tencent.mobileqq.activity.qqcard;

import QCARD.CouponMobileFolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QQCardFolder
  extends Entity
{
  public int aboutExpireNum;
  public int couponsNum;
  public int folderId;
  public String iconUrl;
  @unique
  public int localFolderId;
  public String unavailableUrl;
  
  public QQCardFolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQCardFolder(int paramInt, CouponMobileFolder paramCouponMobileFolder)
  {
    this.localFolderId = paramInt;
    this.folderId = paramCouponMobileFolder.folder_id;
    this.iconUrl = paramCouponMobileFolder.icon_url;
    this.unavailableUrl = paramCouponMobileFolder.unavailable_url;
    this.couponsNum = paramCouponMobileFolder.coupons_num;
    this.aboutExpireNum = paramCouponMobileFolder.aboutexpire_num;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */