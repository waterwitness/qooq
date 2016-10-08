package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EcShopData
  extends Entity
{
  public static final String TABLE_NAME = "EcShopData";
  public long bindUin;
  public int mDistance;
  public String mImgInfo;
  public long mLastDraftTime;
  public long mLastMsgTime;
  @unique
  public String mUin;
  public String msgId;
  
  public EcShopData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mImgInfo = "";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */