package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype4
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34 }, new String[] { "uint32_imsg_type", "st_story_aio_obj_msg" }, new Object[] { Integer.valueOf(0), null }, MsgElemInfo_servtype4.class);
  public hummer_commelem.StoryAioObjMsg st_story_aio_obj_msg = new hummer_commelem.StoryAioObjMsg();
  public final PBUInt32Field uint32_imsg_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\hummer\servtype\hummer_commelem$MsgElemInfo_servtype4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */