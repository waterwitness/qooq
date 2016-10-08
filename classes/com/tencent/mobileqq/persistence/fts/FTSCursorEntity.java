package com.tencent.mobileqq.persistence.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSCursorEntity
{
  private static final String a = "Q.fts.ftscursor";
  public int a;
  public int b;
  private String b;
  
  public FTSCursorEntity(int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\fts\FTSCursorEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */