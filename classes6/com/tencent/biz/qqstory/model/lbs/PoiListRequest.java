package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PoiListRequest
{
  public final int a;
  public final BasicLocation a;
  public final String a;
  public final int b;
  public final String b;
  
  public PoiListRequest(BasicLocation paramBasicLocation, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 20;
    if (paramBasicLocation == null) {
      throw new IllegalArgumentException("BasicLocation should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = paramBasicLocation;
    if (paramString1 != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      if (paramString2 == null) {
        break label64;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = paramString2;
      return;
      paramString1 = "";
      break;
      label64:
      paramString2 = "";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (PoiListRequest)paramObject;
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.equals(((PoiListRequest)paramObject).jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation));
      bool1 = bool2;
    } while (!this.jdField_a_of_type_JavaLangString.equals(((PoiListRequest)paramObject).jdField_a_of_type_JavaLangString));
    return this.jdField_b_of_type_JavaLangString.equals(((PoiListRequest)paramObject).jdField_b_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.hashCode() * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.jdField_b_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return "PoiListRequest{mBasicLocation=" + this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation + ", mCoordinate=" + 0 + ", mCount=" + 20 + ", mCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mKeyWord='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\lbs\PoiListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */