package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;

public class MayKnowRecommend
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public short age;
  public byte[] algBuffer;
  public String category;
  public String city;
  public String country;
  public int friendStatus;
  public short gender;
  public boolean hasQZoneUpdate;
  public String nick;
  public String province;
  public String recommendReason;
  public String remark;
  @Deprecated
  public String richBuffer;
  public byte[] richSingature;
  @notColumn
  public RichStatus richStatus;
  public String uin;
  
  public MayKnowRecommend()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.gender = 255;
  }
  
  public RichStatus getRichStatus()
  {
    if (this.richStatus == null) {
      this.richStatus = RichStatus.parseStatus(this.richSingature);
    }
    return this.richStatus;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MayKnowRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */