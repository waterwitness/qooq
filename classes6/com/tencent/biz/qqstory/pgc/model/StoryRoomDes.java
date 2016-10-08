package com.tencent.biz.qqstory.pgc.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryRoomDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;

public class StoryRoomDes
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public String cover;
  public long id;
  
  public StoryRoomDes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StoryRoomDes convertFrom(qqstory_pgc.StoryRoomDes paramStoryRoomDes)
  {
    if ((paramStoryRoomDes == null) || (!paramStoryRoomDes.has())) {
      return null;
    }
    StoryRoomDes localStoryRoomDes = new StoryRoomDes();
    long l;
    if (paramStoryRoomDes.room_id.has())
    {
      l = paramStoryRoomDes.room_id.get();
      localStoryRoomDes.id = l;
      if (!paramStoryRoomDes.room_cover.has()) {
        break label77;
      }
    }
    label77:
    for (paramStoryRoomDes = paramStoryRoomDes.room_cover.get().toStringUtf8();; paramStoryRoomDes = null)
    {
      localStoryRoomDes.cover = paramStoryRoomDes;
      return localStoryRoomDes;
      l = 0L;
      break;
    }
  }
  
  public boolean checkData()
  {
    return !TextUtils.isEmpty(this.cover);
  }
  
  public String toString()
  {
    return "StoryRoomDes{id=" + this.id + ", cover='" + this.cover + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\StoryRoomDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */