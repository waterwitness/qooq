package tencent.im.nearfield_group;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearfield_group$RespGetGroupList
  extends MessageMicro
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_MSG_GROUP_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "rpt_msg_group_list" }, new Object[] { null, null }, RespGetGroupList.class);
  public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
  public final PBRepeatMessageField rpt_msg_group_list = PBField.initRepeatMessage(nearfield_group.GroupProfile.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_group\nearfield_group$RespGetGroupList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */