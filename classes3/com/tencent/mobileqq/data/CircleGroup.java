package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class CircleGroup
  extends Entity
{
  public int buddyCount;
  @notColumn
  public List buddyList;
  @unique
  public int groupId;
  public String groupName;
  public int showIndex;
  
  public CircleGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\CircleGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */