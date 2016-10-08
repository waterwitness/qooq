package com.tencent.qidian.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qidian.proto.mobileqq_qidian.GroupItem;

public class GroupItem
{
  private static final String b = "GroupItem";
  public int a;
  public long a;
  public String a;
  
  public GroupItem() {}
  
  public GroupItem(mobileqq_qidian.GroupItem paramGroupItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramGroupItem);
  }
  
  public mobileqq_qidian.GroupItem a()
  {
    mobileqq_qidian.GroupItem localGroupItem = new mobileqq_qidian.GroupItem();
    localGroupItem.uint64_groupid.set(this.jdField_a_of_type_Long);
    localGroupItem.uint32_group_level.set(this.jdField_a_of_type_Int);
    localGroupItem.str_group_name.set(this.jdField_a_of_type_JavaLangString);
    return localGroupItem;
  }
  
  public void a(mobileqq_qidian.GroupItem paramGroupItem)
  {
    if (paramGroupItem.uint64_groupid.has()) {
      this.jdField_a_of_type_Long = paramGroupItem.uint64_groupid.get();
    }
    if (paramGroupItem.uint32_group_level.has()) {
      this.jdField_a_of_type_Int = paramGroupItem.uint32_group_level.get();
    }
    if (paramGroupItem.str_group_name.has()) {
      this.jdField_a_of_type_JavaLangString = paramGroupItem.str_group_name.get();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\GroupItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */