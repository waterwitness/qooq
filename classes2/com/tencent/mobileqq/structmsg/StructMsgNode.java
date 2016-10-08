package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StructMsgNode
{
  public static final short a = 1;
  public static final short b = 3;
  public int a;
  public StructMsgNode a;
  public String a;
  public List a;
  public Map a;
  public String b;
  
  public StructMsgNode(String paramString, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public StructMsgNode a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return a(this.jdField_a_of_type_JavaUtilList.indexOf(this) + 1);
    }
    return null;
  }
  
  public StructMsgNode a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (StructMsgNode)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public void a(StructMsgNode paramStructMsgNode)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramStructMsgNode);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0);
  }
  
  public StructMsgNode b()
  {
    return a(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */