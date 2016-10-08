package com.tencent.biz.qqstory.pgc.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;

public class StoryVideoDes
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public Address address;
  public long createTime;
  public String doodleUrl;
  public String lable;
  public String title;
  public String vid;
  public String videoCover;
  public long videoTotalTime;
  public String videoUrl;
  public int viewTotalNum;
  
  public StoryVideoDes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StoryVideoDes convertFrom(qqstory_pgc.StoryVideoDes paramStoryVideoDes)
  {
    long l2 = 0L;
    Object localObject2 = null;
    if ((paramStoryVideoDes == null) || (!paramStoryVideoDes.has())) {
      return null;
    }
    StoryVideoDes localStoryVideoDes = new StoryVideoDes();
    Object localObject1;
    label73:
    label99:
    label125:
    label151:
    long l1;
    if (paramStoryVideoDes.vid.has())
    {
      localObject1 = paramStoryVideoDes.vid.get().toStringUtf8();
      localStoryVideoDes.vid = ((String)localObject1);
      if (!paramStoryVideoDes.video_url.has()) {
        break label297;
      }
      localObject1 = paramStoryVideoDes.video_url.get().toStringUtf8();
      localStoryVideoDes.videoUrl = ((String)localObject1);
      if (!paramStoryVideoDes.video_cover.has()) {
        break label302;
      }
      localObject1 = paramStoryVideoDes.video_cover.get().toStringUtf8();
      localStoryVideoDes.videoCover = ((String)localObject1);
      if (!paramStoryVideoDes.title.has()) {
        break label307;
      }
      localObject1 = paramStoryVideoDes.title.get().toStringUtf8();
      localStoryVideoDes.title = ((String)localObject1);
      if (!paramStoryVideoDes.doodle_url.has()) {
        break label312;
      }
      localObject1 = paramStoryVideoDes.doodle_url.get().toStringUtf8();
      localStoryVideoDes.doodleUrl = ((String)localObject1);
      if (!paramStoryVideoDes.create_time.has()) {
        break label317;
      }
      l1 = paramStoryVideoDes.create_time.get();
      label175:
      localStoryVideoDes.createTime = l1;
      if (!paramStoryVideoDes.view_total_num.has()) {
        break label323;
      }
    }
    label297:
    label302:
    label307:
    label312:
    label317:
    label323:
    for (int i = paramStoryVideoDes.view_total_num.get();; i = 0)
    {
      localStoryVideoDes.viewTotalNum = i;
      localObject1 = localObject2;
      if (paramStoryVideoDes.label.has()) {
        localObject1 = paramStoryVideoDes.label.get().toStringUtf8();
      }
      localStoryVideoDes.lable = ((String)localObject1);
      l1 = l2;
      if (paramStoryVideoDes.video_total_time.has()) {
        l1 = paramStoryVideoDes.video_total_time.get();
      }
      localStoryVideoDes.videoTotalTime = l1;
      if (paramStoryVideoDes.address.has()) {
        localStoryVideoDes.address = Address.convertFrom((qqstory_struct.Address)paramStoryVideoDes.address.get());
      }
      return localStoryVideoDes;
      localObject1 = null;
      break;
      localObject1 = null;
      break label73;
      localObject1 = null;
      break label99;
      localObject1 = null;
      break label125;
      localObject1 = null;
      break label151;
      l1 = 0L;
      break label175;
    }
  }
  
  public boolean checkData()
  {
    return (!TextUtils.isEmpty(this.videoUrl)) || (!TextUtils.isEmpty(this.vid));
  }
  
  public String toString()
  {
    return "StoryVideoDes{vid='" + this.vid + '\'' + ", videoUrl='" + this.videoUrl + '\'' + ", videoCover='" + this.videoCover + '\'' + ", title='" + this.title + '\'' + ", doodleUrl='" + this.doodleUrl + '\'' + ", createTime=" + this.createTime + ", viewTotalNum=" + this.viewTotalNum + ", lable='" + this.lable + '\'' + ", videoTotalTime=" + this.videoTotalTime + ", address=" + this.address + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\StoryVideoDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */