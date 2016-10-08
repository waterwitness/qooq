package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x7c4$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_get_recommend_sn_frd_list_rsp", "msg_get_sn_frd_list_rsp", "rpt_msg_recommend_reason", "msg_box" }, new Object[] { null, null, null, null }, RspBody.class);
  public cmd0x7c4.MsgBox msg_box = new cmd0x7c4.MsgBox();
  public cmd0x7c4.GetRecommendSNFrdListRsp msg_get_recommend_sn_frd_list_rsp = new cmd0x7c4.GetRecommendSNFrdListRsp();
  public cmd0x7c4.GetSNFrdListRsp msg_get_sn_frd_list_rsp = new cmd0x7c4.GetSNFrdListRsp();
  public final PBRepeatMessageField rpt_msg_recommend_reason = PBField.initRepeatMessage(cmd0x7c4.RecommendReason.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x7c4\cmd0x7c4$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */