package com.tencent.mobileqq.troopinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class GroupCatalogBean
{
  public int a;
  public GroupCatalogBean a;
  public String a;
  public ArrayList a;
  public String b;
  
  private GroupCatalogBean()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupCatalogBean(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    GroupCatalogBean localGroupCatalogBean = this;
    while (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null)
    {
      localGroupCatalogBean = localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
      str = localGroupCatalogBean.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramGroupCatalogBean);
  }
  
  public boolean a(GroupCatalogBean paramGroupCatalogBean)
  {
    if ((paramGroupCatalogBean != null) && (paramGroupCatalogBean.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramGroupCatalogBean;
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopinfo\GroupCatalogBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */