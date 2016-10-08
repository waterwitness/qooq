package com.tencent.biz.qqstory.pgc.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.VideoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class VideoInfo
{
  public String a;
  public String b;
  
  public VideoInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static VideoInfo a(qqstory_pgc.VideoInfo paramVideoInfo)
  {
    Object localObject2 = null;
    if ((paramVideoInfo == null) || (!paramVideoInfo.has())) {
      return null;
    }
    VideoInfo localVideoInfo = new VideoInfo();
    if (paramVideoInfo.vid.has()) {}
    for (Object localObject1 = paramVideoInfo.vid.get().toStringUtf8();; localObject1 = null)
    {
      localVideoInfo.a = ((String)localObject1);
      localObject1 = localObject2;
      if (paramVideoInfo.url.has()) {
        localObject1 = paramVideoInfo.url.get().toStringUtf8();
      }
      localVideoInfo.b = ((String)localObject1);
      return localVideoInfo;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    return "VideoInfo{vid='" + this.a + '\'' + ", url='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\VideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */