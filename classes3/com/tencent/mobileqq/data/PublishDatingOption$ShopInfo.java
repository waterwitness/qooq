package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PublishDatingOption$ShopInfo
{
  public int poi;
  public String shopAddr;
  public String shopId;
  public String shopName;
  public String shopPicUrl;
  public int shopSp;
  public String shopUrl;
  public String shopZone;
  
  public PublishDatingOption$ShopInfo(PublishDatingOption paramPublishDatingOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shopZone = "";
    this.shopName = "";
    this.shopAddr = "";
    this.shopPicUrl = "";
    this.shopUrl = "";
    this.shopId = "";
    this.shopSp = -1;
    this.poi = -1;
  }
  
  public String toString()
  {
    return "shopName：" + this.shopName + ",shopAddr" + this.shopAddr + ",shopUrl:" + this.shopUrl;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PublishDatingOption$ShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */