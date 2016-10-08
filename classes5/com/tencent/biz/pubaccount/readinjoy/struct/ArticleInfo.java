package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hzt;
import java.net.URL;
import java.util.ArrayList;

public class ArticleInfo
  extends BaseArticleInfo
  implements Parcelable, Cloneable, Comparable
{
  public static final Parcelable.Creator CREATOR = new hzt();
  public static final long SUBSCRIBE_ARTICLE_ID = -3L;
  public static final long SUBSCRIBE_RECOMMEND_SEQ = -3L;
  public static final String TABLE_NAME;
  public static final String TAG;
  public static final long TOPIC_ARTICLE_ID = -2L;
  public static final long TOPIC_RECOMMEND_SEQ = -2L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    TABLE_NAME = ArticleInfo.class.getSimpleName();
    TAG = ArticleInfo.class.getSimpleName();
  }
  
  public ArticleInfo clone()
  {
    try
    {
      ArticleInfo localArticleInfo = (ArticleInfo)super.clone();
      return localArticleInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "ArticleInfo CloneNotSupportedException e= " + localCloneNotSupportedException);
      }
    }
    return null;
  }
  
  public int compareTo(ArticleInfo paramArticleInfo)
  {
    if (this.mTime == paramArticleInfo.mTime) {
      return 0;
    }
    if (this.mTime < paramArticleInfo.mTime) {
      return -1;
    }
    return 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean hasChannelInfo()
  {
    return (this.mChannelInfoId != -1) && (!TextUtils.isEmpty(this.mChannelInfoName)) && (this.mChannelInfoType != -1) && (!TextUtils.isEmpty(this.mChannelInfoDisplayName));
  }
  
  public DislikeParam makeDislikeParam(ArrayList paramArrayList)
  {
    DislikeParam localDislikeParam = new DislikeParam();
    localDislikeParam.jdField_a_of_type_Long = this.mArticleID;
    localDislikeParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return localDislikeParam;
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mArticleID);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.mFirstPagePicUrl);
    paramParcel.writeString(this.mOriginalUrl);
    paramParcel.writeString(this.mArticleContentUrl);
    paramParcel.writeLong(this.mTime);
    paramParcel.writeLong(this.mCommentCount);
    paramParcel.writeString(this.mSubscribeID);
    paramParcel.writeString(this.mSubscribeName);
    paramParcel.writeLong(this.mRecommendTime);
    paramParcel.writeLong(this.mChannelID);
    paramParcel.writeLong(this.mRecommendSeq);
    if (this.mShowBigPicture)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mStrategyId);
      paramParcel.writeLong(this.mAlgorithmID);
      paramParcel.writeString(this.mArticleFriendLikeText);
      if (this.mPictures == null) {
        break label207;
      }
    }
    Object localObject;
    label207:
    for (paramInt = this.mPictures.length;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.mPictures == null) {
        break label212;
      }
      localObject = this.mPictures;
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeString(localObject[paramInt].toString());
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
    label212:
    if (this.mSinglePicture != null)
    {
      localObject = this.mSinglePicture.toString();
      paramParcel.writeString((String)localObject);
      if (TextUtils.isEmpty(this.mJsonVideoList)) {
        break label330;
      }
      paramParcel.writeInt(1);
      if (this.mVideoCoverUrl == null) {
        break label324;
      }
      localObject = this.mVideoCoverUrl.toString();
      label262:
      paramParcel.writeString((String)localObject);
      paramParcel.writeString(this.mVideoVid);
      paramParcel.writeInt(this.mVideoDuration);
      label283:
      paramParcel.writeInt(this.mCommentIconType);
      if (this.mServerContext != null) {
        break label338;
      }
    }
    label324:
    label330:
    label338:
    for (paramInt = -1;; paramInt = this.mServerContext.length)
    {
      paramParcel.writeInt(paramInt);
      if (paramInt > 0) {
        paramParcel.writeByteArray(this.mServerContext);
      }
      return;
      localObject = "";
      break;
      localObject = "";
      break label262;
      paramParcel.writeInt(0);
      break label283;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\ArticleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */