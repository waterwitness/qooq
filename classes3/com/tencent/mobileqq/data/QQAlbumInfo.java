package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQAlbumInfo
{
  public String _id;
  public long coverDate;
  public LocalMediaInfo mCoverInfo;
  public int mMediaFileCount;
  public String name;
  
  public QQAlbumInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mCoverInfo = new LocalMediaInfo();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\QQAlbumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */