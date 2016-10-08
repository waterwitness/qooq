package com.tencent.mobileqq.nearby.smooth;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ItemManager$Builder
{
  private static final int jdField_a_of_type_Int = 4;
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 2;
  private final ItemLoader jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public ItemManager$Builder(ItemLoader paramItemLoader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramItemLoader;
    this.b = false;
    this.c = 4;
    this.d = 2;
  }
  
  public Builder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public ItemManager a()
  {
    return new ItemManager(this.a, this.b, this.c, this.d, null);
  }
  
  public Builder b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\smooth\ItemManager$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */