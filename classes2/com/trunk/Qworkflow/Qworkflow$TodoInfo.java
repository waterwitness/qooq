package com.trunk.Qworkflow;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Qworkflow$TodoInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "msg_todo_title", "msg_todo_content", "uint32_template_type", "msg_default_button", "rpt_button_list" }, new Object[] { null, null, Integer.valueOf(0), null, null }, TodoInfo.class);
  public Qworkflow.Button msg_default_button = new Qworkflow.Button();
  public Qworkflow.Text msg_todo_content = new Qworkflow.Text();
  public Qworkflow.Text msg_todo_title = new Qworkflow.Text();
  public final PBRepeatMessageField rpt_button_list = PBField.initRepeatMessage(Qworkflow.Button.class);
  public final PBUInt32Field uint32_template_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\trunk\Qworkflow\Qworkflow$TodoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */