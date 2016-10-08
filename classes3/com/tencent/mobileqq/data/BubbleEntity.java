package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class BubbleEntity
  extends Entity
{
  public int bubble_id;
  public long expire;
  public String hash;
  public int opType;
  public int power;
  public String resUrl;
  public int version;
  
  public BubbleEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.version = 1;
    this.hash = "";
  }
  
  public BubbleEntity(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    this.version = 1;
    this.hash = "";
    this.bubble_id = paramInt1;
    this.opType = paramInt2;
    this.resUrl = paramString;
    this.power = paramInt3;
    this.expire = paramLong;
  }
  
  public BubbleEntity(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong, int paramInt4)
  {
    this.version = 1;
    this.hash = "";
    this.bubble_id = paramInt1;
    this.opType = paramInt2;
    this.resUrl = paramString;
    this.power = paramInt3;
    this.expire = paramLong;
    this.version = paramInt4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\BubbleEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */