package com.tencent.mobileqq.data;

import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PublishDatingOption
{
  public appoint_define.LocaleInfo depLocal;
  public int depLocalState;
  public appoint_define.LocaleInfo desLocal;
  public int destType;
  public int genderId;
  public boolean hasIntro;
  public int introId;
  public String introKey;
  public String introduce;
  public String maxTimeReqErr;
  public int maxTimeRequest;
  public int partCountId;
  public int payTypeId;
  public PublishDatingOption.ShopInfo shopInfo;
  public int themeId;
  public String themeName;
  public long time;
  public int vehicleId;
  
  public PublishDatingOption()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.themeId = -1;
    this.time = -1L;
    this.genderId = -1;
    this.introduce = "";
    this.introId = 64535;
    this.introKey = "";
    this.payTypeId = -1;
    this.shopInfo = new PublishDatingOption.ShopInfo(this);
    this.vehicleId = -1;
    this.partCountId = -1;
    this.themeName = "";
    this.maxTimeRequest = -1;
    this.maxTimeReqErr = "";
    this.depLocalState = -1;
    this.destType = -1;
  }
  
  public String getPartCountKey()
  {
    switch (this.partCountId)
    {
    default: 
      return "";
    case 0: 
      return "1412150901";
    case 1: 
      return "1412150902";
    case 2: 
      return "1412150903";
    case 3: 
      return "1412150904";
    }
    return "1412150905";
  }
  
  public String getVehicleKey()
  {
    switch (this.vehicleId)
    {
    default: 
      return "";
    case 0: 
      return "1412150802";
    case 1: 
      return "1412150803";
    case 2: 
      return "1412150804";
    case 3: 
      return "1412150807";
    case 4: 
    case 5: 
      return "1412150806";
    case 6: 
      return "1412150800";
    }
    return "1412150801";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("themeId:" + this.themeId);
    localStringBuilder.append(",time:" + this.time);
    localStringBuilder.append(",genderId:" + this.genderId);
    localStringBuilder.append(",introduce:" + this.introduce);
    localStringBuilder.append(",introId:" + this.introId);
    localStringBuilder.append(",introKey:" + this.introKey);
    localStringBuilder.append(",payTypeId:" + this.payTypeId);
    localStringBuilder.append(",vehicleId:" + this.vehicleId);
    localStringBuilder.append(",partCountId:" + this.partCountId);
    if (this.shopInfo != null) {
      localStringBuilder.append(",shopInfo:" + this.shopInfo.toString());
    }
    if (this.depLocal != null) {
      localStringBuilder.append(",depLocal:" + this.depLocal.str_name);
    }
    if (this.desLocal != null) {
      localStringBuilder.append(",desLocal:" + this.desLocal.str_name);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PublishDatingOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */