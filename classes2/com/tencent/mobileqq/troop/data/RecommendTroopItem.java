package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class RecommendTroopItem
  extends Entity
{
  public String intro;
  public List labelList;
  public int memberNum;
  public String name;
  public String recommendReason;
  public int troopType;
  @unique
  public String uin;
  public byte[] x9fbRgroupInfo;
  
  public RecommendTroopItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\RecommendTroopItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */