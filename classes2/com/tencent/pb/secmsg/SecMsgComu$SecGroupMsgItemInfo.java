package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecGroupMsgItemInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field author_id = PBField.initInt64(0L);
  public final PBStringField content = PBField.initString("");
  public final PBInt64Field create_uts = PBField.initInt64(0L);
  public final PBStringField head = PBField.initString("");
  public final PBInt64Field localseq = PBField.initInt64(0L);
  public final PBStringField nick = PBField.initString("");
  public final PBInt64Field state = PBField.initInt64(0L);
  public final PBBytesField thumbs = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field type = PBField.initInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "create_uts", "author_id", "nick", "head", "state", "type", "content", "thumbs", "localseq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, Long.valueOf(0L) }, SecGroupMsgItemInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecGroupMsgItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */