package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DetailLocation
  extends BasicLocation
{
  public final String a;
  public final String b;
  public final int c;
  public final String c;
  public final String d;
  public final String e;
  
  public DetailLocation(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = Coordinate.a(paramInt3);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DetailLocation)paramObject;
      if (this.jdField_a_of_type_Int != ((DetailLocation)paramObject).jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_b_of_type_Int != ((DetailLocation)paramObject).jdField_b_of_type_Int) {
        return false;
      }
    } while (this.jdField_c_of_type_Int == ((DetailLocation)paramObject).jdField_c_of_type_Int);
    return false;
  }
  
  public int hashCode()
  {
    return ((super.hashCode() * 31 + this.jdField_a_of_type_Int) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_c_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\lbs\DetailLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */