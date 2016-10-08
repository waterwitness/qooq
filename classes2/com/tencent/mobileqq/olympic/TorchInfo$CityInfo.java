package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class TorchInfo$CityInfo
  implements Serializable, Cloneable
{
  public long city_id;
  public String city_name;
  public long city_pic_id;
  public String city_pic_md5;
  public String city_pic_url;
  public String cons_pic_md5;
  public String cons_pic_url;
  
  public TorchInfo$CityInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object clone()
  {
    try
    {
      CityInfo localCityInfo = (CityInfo)super.clone();
      return localCityInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("(");
    localStringBuilder.append("city_id=").append(this.city_id).append(",");
    localStringBuilder.append("city_name=").append(this.city_name).append(",");
    localStringBuilder.append("city_pic_id=").append(this.city_pic_id).append(",");
    localStringBuilder.append("city_pic_md5=").append(this.city_pic_md5).append(",");
    localStringBuilder.append("cons_pic_url=").append(this.cons_pic_url).append(",");
    localStringBuilder.append("cons_pic_md5=").append(this.cons_pic_md5);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\TorchInfo$CityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */