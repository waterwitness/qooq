package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RecTroopBusinessItem
  extends Entity
{
  public String btnText;
  public String des;
  public long endTime;
  public String iconUrl;
  @unique
  public String id;
  public String jumpParam;
  public int jumpType;
  public String jumpUrl;
  public long startTime;
  public long timeStamp;
  public String title;
  
  public RecTroopBusinessItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecTroopBusinessItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */