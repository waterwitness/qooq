import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;

public final class hzt
  implements Parcelable.Creator
{
  public hzt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArticleInfo a(Parcel paramParcel)
  {
    int j = 1;
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mArticleID = paramParcel.readLong();
    localArticleInfo.mTitle = paramParcel.readString();
    localArticleInfo.mSummary = paramParcel.readString();
    localArticleInfo.mFirstPagePicUrl = paramParcel.readString();
    localArticleInfo.mOriginalUrl = paramParcel.readString();
    localArticleInfo.mArticleContentUrl = paramParcel.readString();
    localArticleInfo.mTime = paramParcel.readLong();
    localArticleInfo.mCommentCount = paramParcel.readLong();
    localArticleInfo.mSubscribeID = paramParcel.readString();
    localArticleInfo.mSubscribeName = paramParcel.readString();
    localArticleInfo.mRecommendTime = paramParcel.readLong();
    localArticleInfo.mChannelID = paramParcel.readLong();
    localArticleInfo.mRecommendSeq = paramParcel.readLong();
    if (paramParcel.readByte() == 0) {}
    int i;
    for (boolean bool = false;; bool = true)
    {
      localArticleInfo.mShowBigPicture = bool;
      localArticleInfo.mStrategyId = paramParcel.readInt();
      localArticleInfo.mAlgorithmID = paramParcel.readLong();
      localArticleInfo.mArticleFriendLikeText = paramParcel.readString();
      int k = paramParcel.readInt();
      if (k <= 0) {
        break;
      }
      localArticleInfo.mPictures = new URL[k];
      i = 0;
      while (i < k)
      {
        localArticleInfo.mPictures[i] = ReadInJoyUtils.b(paramParcel.readString());
        i += 1;
      }
    }
    localArticleInfo.mSinglePicture = ReadInJoyUtils.b(paramParcel.readString());
    if (paramParcel.readInt() == 1)
    {
      i = j;
      if (i != 0)
      {
        localArticleInfo.mVideoCoverUrl = ReadInJoyUtils.b(paramParcel.readString());
        localArticleInfo.mVideoVid = paramParcel.readString();
        localArticleInfo.mVideoDuration = paramParcel.readInt();
      }
      localArticleInfo.mCommentIconType = paramParcel.readInt();
      i = paramParcel.readInt();
      if (i != -1) {
        break label292;
      }
      localArticleInfo.mServerContext = null;
    }
    label292:
    do
    {
      return localArticleInfo;
      i = 0;
      break;
      localArticleInfo.mServerContext = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(localArticleInfo.mServerContext);
    return localArticleInfo;
  }
  
  public ArticleInfo[] a(int paramInt)
  {
    return new ArticleInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */