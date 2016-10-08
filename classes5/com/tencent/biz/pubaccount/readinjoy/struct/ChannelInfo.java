package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import java.util.List;

public class ChannelInfo
  extends Entity
  implements Cloneable
{
  public static final int GIF_CHANNEL_TYPE = 4;
  public static final int LOCAL_CHANNEL_TYPE = 1;
  public static final int NORMAL_CHANNEL_TYPE = 0;
  public static final int PICTURE_CHANNEL_TYPE = 2;
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public static final int VIDEO_CHANNEL_TYPE = 3;
  private List mArticleIDList;
  public int mChannelID = -1;
  public String mChannelName = "";
  public int mChannelType;
  public int mFontColor = -16777216;
  public int mFrameColor = -3355444;
  public boolean mIsFirstReq;
  public boolean mShow;
  public int mSortOrder;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ChannelInfo clone()
  {
    try
    {
      ChannelInfo localChannelInfo = (ChannelInfo)super.clone();
      return localChannelInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public List getArticleIDList()
  {
    return this.mArticleIDList;
  }
  
  public void setArticleIDList(List paramList)
  {
    this.mArticleIDList = paramList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\ChannelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */