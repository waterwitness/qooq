package com.tencent.biz.qqstory.pgc.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryPostDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;

public class StoryPostDes
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public long id;
  public String url;
  
  public StoryPostDes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StoryPostDes convertFrom(qqstory_pgc.StoryPostDes paramStoryPostDes)
  {
    if ((paramStoryPostDes == null) || (!paramStoryPostDes.has())) {
      return null;
    }
    StoryPostDes localStoryPostDes = new StoryPostDes();
    long l;
    if (paramStoryPostDes.post_id.has())
    {
      l = paramStoryPostDes.post_id.get();
      localStoryPostDes.id = l;
      if (!paramStoryPostDes.post_url.has()) {
        break label77;
      }
    }
    label77:
    for (paramStoryPostDes = paramStoryPostDes.post_url.get().toStringUtf8();; paramStoryPostDes = null)
    {
      localStoryPostDes.url = paramStoryPostDes;
      return localStoryPostDes;
      l = 0L;
      break;
    }
  }
  
  public boolean checkData()
  {
    return !TextUtils.isEmpty(this.url);
  }
  
  public String toString()
  {
    return "StoryPostDes{id=" + this.id + ", url='" + this.url + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\StoryPostDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */