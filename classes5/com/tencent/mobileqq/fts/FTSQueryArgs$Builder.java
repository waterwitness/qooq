package com.tencent.mobileqq.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FTSQueryArgs$Builder
{
  private int jdField_a_of_type_Int;
  private Class jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  FTSQueryArgs.MatchKey[] jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey;
  private String b;
  
  public FTSQueryArgs$Builder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(Class paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder a(FTSQueryArgs.MatchKey... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey = paramVarArgs;
    return this;
  }
  
  public FTSQueryArgs a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new FTSQueryArgs(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public Builder b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\FTSQueryArgs$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */