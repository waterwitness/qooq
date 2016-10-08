package com.tencent.biz.qqstory.pgc.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryCoverInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;

public class StoryCoverInfo
  implements Serializable
{
  public static final int TYPE_IMAGE = 1;
  public static final int TYPE_IMAGE_GIF = 3;
  public static final int TYPE_VIDEO = 2;
  public static final long serialVersionUID = 1L;
  public String coverUrl;
  public String screenshotUrl;
  public int type;
  public String vid;
  
  public StoryCoverInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StoryCoverInfo convertFrom(qqstory_pgc.StoryCoverInfo paramStoryCoverInfo)
  {
    Object localObject2 = null;
    if ((paramStoryCoverInfo == null) || (!paramStoryCoverInfo.has())) {
      return null;
    }
    StoryCoverInfo localStoryCoverInfo = new StoryCoverInfo();
    int i;
    if (paramStoryCoverInfo.type.has())
    {
      i = paramStoryCoverInfo.type.get();
      localStoryCoverInfo.type = i;
      if (!paramStoryCoverInfo.cover_url.has()) {
        break label136;
      }
      localObject1 = paramStoryCoverInfo.cover_url.get().toStringUtf8();
      label69:
      localStoryCoverInfo.coverUrl = ((String)localObject1);
      if (!paramStoryCoverInfo.vid.has()) {
        break label141;
      }
    }
    label136:
    label141:
    for (Object localObject1 = paramStoryCoverInfo.vid.get().toStringUtf8();; localObject1 = null)
    {
      localStoryCoverInfo.vid = ((String)localObject1);
      localObject1 = localObject2;
      if (paramStoryCoverInfo.screenshot_url.has()) {
        localObject1 = paramStoryCoverInfo.screenshot_url.get().toStringUtf8();
      }
      localStoryCoverInfo.screenshotUrl = ((String)localObject1);
      return localStoryCoverInfo;
      i = 1;
      break;
      localObject1 = null;
      break label69;
    }
  }
  
  public boolean checkData()
  {
    return (!TextUtils.isEmpty(this.coverUrl)) || (!TextUtils.isEmpty(this.vid));
  }
  
  public String toString()
  {
    return "StoryCoverInfo{type=" + this.type + ", coverUrl='" + this.coverUrl + '\'' + ", vid='" + this.vid + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\StoryCoverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */