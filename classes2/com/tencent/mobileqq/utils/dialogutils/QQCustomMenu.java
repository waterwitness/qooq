package com.tencent.mobileqq.utils.dialogutils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class QQCustomMenu
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  
  public QQCustomMenu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, String paramString)
  {
    QQCustomMenuItem localQQCustomMenuItem = new QQCustomMenuItem();
    localQQCustomMenuItem.jdField_a_of_type_Int = paramInt;
    localQQCustomMenuItem.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localQQCustomMenuItem);
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramQQCustomMenuItem);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public QQCustomMenuItem[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QQCustomMenuItem[] arrayOfQQCustomMenuItem = new QQCustomMenuItem[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfQQCustomMenuItem);
      return arrayOfQQCustomMenuItem;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\dialogutils\QQCustomMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */