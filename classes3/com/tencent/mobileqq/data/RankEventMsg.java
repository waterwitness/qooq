package com.tencent.mobileqq.data;

import android.text.TextUtils;
import appoint.define.appoint_define.RankEvent;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RankEventMsg
  extends Entity
{
  public byte bDeleted;
  public byte bReaded;
  public long eventtime;
  @unique
  public int listtype;
  public String notify_tips;
  public int notifytype;
  public long seq;
  
  public RankEventMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static RankEventMsg convertFrom(appoint_define.RankEvent paramRankEvent)
  {
    String str = null;
    if (paramRankEvent == null) {
      return null;
    }
    RankEventMsg localRankEventMsg = new RankEventMsg();
    localRankEventMsg.listtype = paramRankEvent.uint32_listtype.get();
    localRankEventMsg.notifytype = paramRankEvent.uint32_notifytype.get();
    localRankEventMsg.eventtime = paramRankEvent.uint32_eventtime.get();
    localRankEventMsg.seq = paramRankEvent.uint32_seq.get();
    localRankEventMsg.notify_tips = paramRankEvent.str_notify_tips.get();
    if (TextUtils.isEmpty(localRankEventMsg.notify_tips))
    {
      if ((localRankEventMsg.listtype != 0) && (localRankEventMsg.listtype != 2)) {
        break label168;
      }
      str = "男神榜";
      switch (localRankEventMsg.notifytype)
      {
      }
    }
    for (;;)
    {
      DatingUtil.a("RankEventMsg.convertFrom", new Object[] { paramRankEvent.str_notify_tips.get(), localRankEventMsg.notify_tips });
      return localRankEventMsg;
      label168:
      if ((localRankEventMsg.listtype != 1) && (localRankEventMsg.listtype != 3)) {
        break;
      }
      str = "女神榜";
      break;
      localRankEventMsg.notify_tips = ("恭喜闯入" + str);
      continue;
      localRankEventMsg.notify_tips = ("很遗憾你已退出" + str + "。");
      continue;
      localRankEventMsg.notify_tips = ("恭喜赢得" + str + "第一名！");
      continue;
      localRankEventMsg.notify_tips = ("恭喜闯入" + str + "前三名！");
      continue;
      localRankEventMsg.notify_tips = ("你已降至" + str + "后三名，要继续努力哦~");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RankEventMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */