package com.tencent.pb.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class EmosmPb$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130 }, new String[] { "uint32_sub_cmd", "uint64_uin", "msg_subcmd0x1_req_deltab", "msg_subcmd0x2_req_fetchtab", "msg_subcmd0x3_req_fetchbq", "int32_plat_id", "str_app_version", "msg_subcmd0x6_req", "msg_subcmd0x7_req", "msg_subcmd0x8_req_addtab", "msg_subcmd0x9_req", "msg_subcmd0x10_req", "msg_subcmd0x5_req", "msg_subcmd0x11_req", "msg_subcmd0x12_req", "msg_subcmd0x13_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Integer.valueOf(0), "", null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public final PBInt32Field int32_plat_id = PBField.initInt32(0);
  public EmosmPb.SubCmd0x10MoveOrderReq msg_subcmd0x10_req = new EmosmPb.SubCmd0x10MoveOrderReq();
  public EmosmPb.SubCmd0x11Req msg_subcmd0x11_req = new EmosmPb.SubCmd0x11Req();
  public EmosmPb.SubCmd0x12Req msg_subcmd0x12_req = new EmosmPb.SubCmd0x12Req();
  public EmosmPb.SubCmd0x13Req msg_subcmd0x13_req = new EmosmPb.SubCmd0x13Req();
  public EmosmPb.SubCmd0x1ReqDelTab msg_subcmd0x1_req_deltab = new EmosmPb.SubCmd0x1ReqDelTab();
  public EmosmPb.SubCmd0x2ReqFetchTab msg_subcmd0x2_req_fetchtab = new EmosmPb.SubCmd0x2ReqFetchTab();
  public EmosmPb.SubCmd0x3ReqFetchBq msg_subcmd0x3_req_fetchbq = new EmosmPb.SubCmd0x3ReqFetchBq();
  public EmosmPb.SubCmd0x5ReqBQRecommend msg_subcmd0x5_req = new EmosmPb.SubCmd0x5ReqBQRecommend();
  public EmosmPb.SubCmd0x6Req msg_subcmd0x6_req = new EmosmPb.SubCmd0x6Req();
  public EmosmPb.SubCmd0x7Req msg_subcmd0x7_req = new EmosmPb.SubCmd0x7Req();
  public EmosmPb.SubCmd0x8ReqAddTab msg_subcmd0x8_req_addtab = new EmosmPb.SubCmd0x8ReqAddTab();
  public EmosmPb.SubCmd0x9BqAssocReq msg_subcmd0x9_req = new EmosmPb.SubCmd0x9BqAssocReq();
  public final PBStringField str_app_version = PBField.initString("");
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\emosm\EmosmPb$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */