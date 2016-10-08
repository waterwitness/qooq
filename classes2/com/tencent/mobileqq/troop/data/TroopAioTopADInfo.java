package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TroopAioTopADInfo
  extends Entity
{
  public int adId;
  public String backgroundUrl;
  public String jumpUrl;
  public String moreUrl;
  public String picUrl;
  public int showType;
  public String strWord;
  @unique
  public String troopUin;
  public String uiUrl;
  public long validTime;
  
  public TroopAioTopADInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    Object localObject = new Date(this.validTime * 1000L);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format((Date)localObject);
    StringBuilder localStringBuilder = new StringBuilder("TroopAioTopADInfo{");
    localStringBuilder.append("troopUin='").append(this.troopUin).append('\'');
    localStringBuilder.append(", adId=").append(this.adId);
    localStringBuilder.append(", backgroundUrl='").append(this.backgroundUrl).append('\'');
    localStringBuilder.append(", moreUrl='").append(this.moreUrl).append('\'');
    localStringBuilder.append(", picUrl='").append(this.picUrl).append('\'');
    localStringBuilder.append(", validTime=").append((String)localObject);
    localStringBuilder.append(", showType=").append(this.showType);
    localStringBuilder.append(", strWord='").append(this.strWord).append('\'');
    localStringBuilder.append(", uiUrl='").append(this.uiUrl).append('\'');
    localStringBuilder.append(", jumpUrl='").append(this.jumpUrl).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAioTopADInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */