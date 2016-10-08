package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GameCenterManagerImp$UnreadData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  
  public GameCenterManagerImp$UnreadData(GameCenterManagerImp paramGameCenterManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mUnread=" + this.jdField_a_of_type_Long);
    localStringBuilder.append(",mNewMsg=" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append("mText=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mIconPath=" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("mRedPoint=" + this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",mTab=" + this.c);
    localStringBuilder.append(",mType=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\GameCenterManagerImp$UnreadData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */