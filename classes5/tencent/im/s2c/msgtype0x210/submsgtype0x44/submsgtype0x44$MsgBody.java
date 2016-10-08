package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0x44$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_friend_msg_sync", "msg_group_msg_sync", "msg_clean_count_msg", "msg_modify_msg_sync", "msg_waiting_msg_sync" }, new Object[] { null, null, null, null, null }, MsgBody.class);
  public submsgtype0x44.ClearCountMsg msg_clean_count_msg = new submsgtype0x44.ClearCountMsg();
  public submsgtype0x44.FriendSyncMsg msg_friend_msg_sync = new submsgtype0x44.FriendSyncMsg();
  public submsgtype0x44.GroupSyncMsg msg_group_msg_sync = new submsgtype0x44.GroupSyncMsg();
  public submsgtype0x44.ModifySyncMsg msg_modify_msg_sync = new submsgtype0x44.ModifySyncMsg();
  public submsgtype0x44.WaitingSyncMsg msg_waiting_msg_sync = new submsgtype0x44.WaitingSyncMsg();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x44\submsgtype0x44$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */