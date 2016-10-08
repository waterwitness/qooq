package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class ReadInJoyEntityManagerFactory$VerifyEntity
  extends Entity
{
  public String flags;
  public String name;
  
  public ReadInJoyEntityManagerFactory$VerifyEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.flags = "readinjoy_message_node_verify_entity";
    this.name = "";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyEntityManagerFactory$VerifyEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */