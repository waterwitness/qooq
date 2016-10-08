package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class FirstVideoEntry
  extends Entity
  implements Copyable
{
  public String category;
  @unique
  public String key;
  public String uin;
  public String vid;
  
  public FirstVideoEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getCoordinateSelectionWithoutArg()
  {
    return "vid =?";
  }
  
  public static String getKey(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static String getVidSelection()
  {
    return "category =? AND uin =?";
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof FirstVideoEntry))
    {
      paramObject = (FirstVideoEntry)paramObject;
      this.key = ((FirstVideoEntry)paramObject).key;
      this.category = ((FirstVideoEntry)paramObject).category;
      this.uin = ((FirstVideoEntry)paramObject).uin;
      this.vid = ((FirstVideoEntry)paramObject).vid;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\FirstVideoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */