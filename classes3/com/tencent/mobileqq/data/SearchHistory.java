package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class SearchHistory
  extends Entity
{
  public int count;
  public String displayName;
  public String extralInfo;
  @unique
  public String key;
  public long time;
  public String troopUin;
  public int type;
  public String uin;
  
  public SearchHistory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\SearchHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */