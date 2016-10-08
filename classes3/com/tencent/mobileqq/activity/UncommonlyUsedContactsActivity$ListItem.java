package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class UncommonlyUsedContactsActivity$ListItem
{
  public static final int a = 0;
  public static final int b = 1;
  public Entity a;
  public String a;
  public int c;
  
  public UncommonlyUsedContactsActivity$ListItem(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, int paramInt, Entity paramEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\UncommonlyUsedContactsActivity$ListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */