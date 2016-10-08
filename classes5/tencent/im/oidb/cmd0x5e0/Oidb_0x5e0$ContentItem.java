package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$ContentItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "uint32_update_profile_id", "msg_nicknamefiled", "msg_genderfiled", "msg_friendremark", "msg_longnick", "msg_groupname", "msg_friend_teamlist", "msg_value_bit", "msg_general_buffer", "msg_profile_info" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, ContentItem.class);
  public Oidb_0x5e0.FriendTeamList msg_friend_teamlist = new Oidb_0x5e0.FriendTeamList();
  public Oidb_0x5e0.FriendRemark msg_friendremark = new Oidb_0x5e0.FriendRemark();
  public Oidb_0x5e0.GenderFiled msg_genderfiled = new Oidb_0x5e0.GenderFiled();
  public Oidb_0x5e0.GeneralBuffer msg_general_buffer = new Oidb_0x5e0.GeneralBuffer();
  public Oidb_0x5e0.GroupName msg_groupname = new Oidb_0x5e0.GroupName();
  public Oidb_0x5e0.LongNick msg_longnick = new Oidb_0x5e0.LongNick();
  public Oidb_0x5e0.NickNameFiled msg_nicknamefiled = new Oidb_0x5e0.NickNameFiled();
  public Oidb_0x5e0.ProfileInfo msg_profile_info = new Oidb_0x5e0.ProfileInfo();
  public Oidb_0x5e0.ValueBit msg_value_bit = new Oidb_0x5e0.ValueBit();
  public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5e0\Oidb_0x5e0$ContentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */