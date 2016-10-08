package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.net.URL;
import java.util.ArrayList;

public class BaseArticleInfo
  extends Entity
{
  public int busiType;
  public String innerUniqueID;
  @notColumn
  public boolean like;
  public int mAbandonRepeatFlag;
  public long mAlgorithmID;
  public String mArticleContentUrl;
  public String mArticleFriendLikeText;
  public long mArticleID;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  public long mChannelID;
  public String mChannelInfoDisplayName;
  public int mChannelInfoId;
  public String mChannelInfoName;
  public int mChannelInfoType;
  public long mCommentCount;
  public int mCommentIconType;
  public String mDiskLikeInfoString;
  @notColumn
  public ArrayList mDislikeInfos;
  @notColumn
  public long mFileSize;
  public String mFirstPagePicUrl;
  public int mGalleryPicNumber;
  public int mIsDispTimestamp;
  public int mIsGallery;
  public String mJsonPictureList;
  public String mJsonVideoList;
  public String mOriginalUrl;
  @notColumn
  public URL[] mPictures;
  public long mRecommendSeq;
  public long mRecommendTime;
  public String mRecommentdReason;
  public byte[] mServerContext;
  public boolean mShowBigPicture;
  @notColumn
  public URL mSinglePicture;
  public int mStrategyId;
  public String mSubscribeID;
  public String mSubscribeName;
  public String mSummary;
  public long mTime;
  public String mTitle;
  @notColumn
  public URL mVideoCoverUrl;
  @notColumn
  public int mVideoDuration;
  @notColumn
  public int mVideoJsonHeight;
  @notColumn
  public int mVideoJsonWidth;
  public int mVideoType;
  @notColumn
  public String mVideoVid;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @notColumn
  public String thirdUin;
  @notColumn
  public String thirdUinName;
  
  public BaseArticleInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mArticleID = -1L;
    this.mTitle = "";
    this.mSummary = "";
    this.mFirstPagePicUrl = "";
    this.mOriginalUrl = "";
    this.mArticleContentUrl = "";
    this.mTime = -1L;
    this.mCommentCount = -1L;
    this.mSubscribeID = "";
    this.mSubscribeName = "";
    this.mRecommendTime = -1L;
    this.mChannelID = -1L;
    this.mRecommendSeq = -1L;
    this.mAlgorithmID = -1L;
    this.mRecommentdReason = "";
    this.busiType = 1;
    this.mChannelInfoId = -1;
    this.mChannelInfoType = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\BaseArticleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */