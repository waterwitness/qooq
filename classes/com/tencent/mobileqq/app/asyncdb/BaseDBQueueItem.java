package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class BaseDBQueueItem
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  ProxyListener a;
  public Entity a;
  public int g;
  public int h;
  
  public BaseDBQueueItem(Entity paramEntity, int paramInt1, int paramInt2, ProxyListener paramProxyListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
    this.g = paramInt1;
    this.h = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbProxyListener = paramProxyListener;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\asyncdb\BaseDBQueueItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */