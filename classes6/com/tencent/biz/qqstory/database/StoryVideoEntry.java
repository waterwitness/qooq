package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class StoryVideoEntry
  extends Entity
{
  public String address;
  public long createTime;
  public long databaseTime;
  public String doodleText;
  public int hasRelatedVideo;
  public int hasWatched;
  public String label;
  public String localMaskPicPath;
  public String localVideoPath;
  public String localVideoThumbnailPath;
  public String maskPicUrl;
  public long owerUin;
  public int strangerViewCount;
  public String title;
  public int uploadLastOffset;
  public String uploadSeverIp;
  public int uploadStatus;
  @unique
  public String vid;
  public long videoBytes;
  public long videoDuration;
  public int videoHeight;
  public String videoThumbnailUrl;
  public String videoUrl;
  public int videoWidth;
  public int viewCount;
  
  public StoryVideoEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.databaseTime = System.currentTimeMillis();
  }
  
  public static String getLocalVideo()
  {
    return "uploadStatus<>5";
  }
  
  public static String getVidSelectionNoArgs()
  {
    return "vid=?";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\StoryVideoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */