package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.LiveVideoDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LiveVideoEntry
  extends Entity
{
  public String coverUrl;
  public int fromId;
  @unique
  public int roomId;
  public long startTime;
  public long uin;
  
  public LiveVideoEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static LiveVideoEntry convertFrom(long paramLong, qqstory_struct.LiveVideoDes paramLiveVideoDes)
  {
    if (paramLiveVideoDes == null) {
      return null;
    }
    LiveVideoEntry localLiveVideoEntry = new LiveVideoEntry();
    localLiveVideoEntry.uin = paramLong;
    localLiveVideoEntry.roomId = paramLiveVideoDes.room_id.get();
    localLiveVideoEntry.startTime = paramLiveVideoDes.start_time.get();
    localLiveVideoEntry.fromId = paramLiveVideoDes.from_id.get();
    localLiveVideoEntry.coverUrl = paramLiveVideoDes.cover_url.get().toStringUtf8();
    return localLiveVideoEntry;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\LiveVideoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */