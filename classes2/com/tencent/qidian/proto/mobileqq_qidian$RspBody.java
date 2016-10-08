package com.tencent.qidian.proto;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_rsp", "msg_wpa_sigt_to_sigmsg_rsp", "msg_click_reply_cmd_action_rsp", "msg_subcmd_get_user_detail_info_rsp_body", "msg_get_account_type_rsp", "msg_get_business_mobile_rsp", "msg_verify_wpa_uin_and_key_rsp", "msg_check_mpqq_refuse_flag_rsp" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, RspBody.class);
  public mobileqq_qidian.CheckMpqqRefuseFlagRsp msg_check_mpqq_refuse_flag_rsp = new mobileqq_qidian.CheckMpqqRefuseFlagRsp();
  public mobileqq_qidian.ClickReplyCmdActionRspBody msg_click_reply_cmd_action_rsp = new mobileqq_qidian.ClickReplyCmdActionRspBody();
  public mobileqq_qidian.CRMMsgHead msg_crm_common_head = new mobileqq_qidian.CRMMsgHead();
  public mobileqq_qidian.GetAccountTypeRspBody msg_get_account_type_rsp = new mobileqq_qidian.GetAccountTypeRspBody();
  public mobileqq_qidian.GetBusinessMobileRsp msg_get_business_mobile_rsp = new mobileqq_qidian.GetBusinessMobileRsp();
  public mobileqq_qidian.GetUserDetailInfoRspBody msg_subcmd_get_user_detail_info_rsp_body = new mobileqq_qidian.GetUserDetailInfoRspBody();
  public mobileqq_qidian.VerifyWpaUinAndKeyRsp msg_verify_wpa_uin_and_key_rsp = new mobileqq_qidian.VerifyWpaUinAndKeyRsp();
  public mobileqq_qidian.WpaAssignKfextRspBody msg_wpa_assign_kfext_rsp = new mobileqq_qidian.WpaAssignKfextRspBody();
  public mobileqq_qidian.WpaSigtToSigMsgRspBody msg_wpa_sigt_to_sigmsg_rsp = new mobileqq_qidian.WpaSigtToSigMsgRspBody();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\proto\mobileqq_qidian$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */