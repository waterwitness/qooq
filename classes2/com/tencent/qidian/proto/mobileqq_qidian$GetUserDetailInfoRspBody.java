package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$GetUserDetailInfoRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "msg_ret", "uint32_req_type", "msg_internal_info", "msg_external_info", "msg_corp_info", "rpt_msg_config_group_info" }, new Object[] { null, Integer.valueOf(0), null, null, null, null }, GetUserDetailInfoRspBody.class);
  public mobileqq_qidian.CorpInfo msg_corp_info = new mobileqq_qidian.CorpInfo();
  public mobileqq_qidian.ExternalInfo msg_external_info = new mobileqq_qidian.ExternalInfo();
  public mobileqq_qidian.InternalInfo msg_internal_info = new mobileqq_qidian.InternalInfo();
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  public final PBRepeatMessageField rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian.ConfigGroupInfo.class);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$GetUserDetailInfoRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */