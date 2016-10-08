package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.unique;

@PrimaryKeyJoinColumn(a="uin")
public class Ability
  extends Entity
{
  public static final int ABILITY_PHOTO = 2;
  public static final int ABILITY_VIDEO = 1;
  public int flags;
  @unique
  public String uin;
  
  public Ability()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean hasAbility(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public void addAbility(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  public void removeAbility(int paramInt)
  {
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\Ability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */