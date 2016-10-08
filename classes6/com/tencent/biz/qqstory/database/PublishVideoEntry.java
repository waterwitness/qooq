package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PublishVideoEntry
  extends Entity
{
  public int backgroundMusicDuration;
  public int backgroundMusicOffset;
  public String backgroundMusicPath;
  @unique
  public String fakeVid;
  public boolean isMuteRecordVoice;
  public String mLocalRawVideoDir;
  public byte[] mMosaicMask;
  public int mMosaicSize;
  public int recordFrames;
  public double recordTime;
  public int saveMode;
  
  public PublishVideoEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getVidSelectionNoArgs()
  {
    return "fakeVid=?";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\database\PublishVideoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */