package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hxl;

public class ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  private int jdField_a_of_type_Int;
  private AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  private String jdField_a_of_type_JavaLangString;
  
  public ThirdDataSourceAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public int getStaus()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    this.jdField_a_of_type_Int = 1;
    paramOnPreparedCallback = ThirdVidoeManager.a();
    paramOnPreparedCallback.a(new hxl(this));
    paramOnPreparedCallback.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ThirdDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */