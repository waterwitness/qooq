package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class INetPageLoader
{
  public long a;
  public boolean a;
  public long b;
  
  public INetPageLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  @Deprecated
  public void a(int paramInt) {}
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    long l2 = System.currentTimeMillis();
    long l1 = this.b - this.jdField_a_of_type_Long;
    l2 -= this.b;
    SLog.c(paramString, "page network respond times " + l1);
    SLog.c(paramString, "page db times " + l2);
  }
  
  public void b()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\INetPageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */