package com.tencent.mobileqq.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Arrays;

public class FTSQueryArgs
{
  public int a;
  public Class a;
  public String a;
  public boolean a;
  public FTSQueryArgs.MatchKey[] a;
  public String b;
  
  public FTSQueryArgs(Class paramClass, FTSQueryArgs.MatchKey[] paramArrayOfMatchKey, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey = paramArrayOfMatchKey;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "FTSQueryArgs{entityClazz=" + this.jdField_a_of_type_JavaLangClass + ", matchKeys=" + Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey) + ", matchKeysOr=" + this.jdField_a_of_type_Boolean + ", limit=" + this.jdField_a_of_type_Int + ", selectionSql='" + this.jdField_a_of_type_JavaLangString + '\'' + ", orderBySql='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\FTSQueryArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */