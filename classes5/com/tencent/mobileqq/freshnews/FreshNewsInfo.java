package com.tencent.mobileqq.freshnews;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.freshnews.ad.UserInfo;
import com.tencent.mobileqq.freshnews.hotchat.HotchatFeedInfo;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import sqh;

public class FreshNewsInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new sqh();
  @notColumn
  public static final int PAGE_FRESHE_NEWS_FEED = 1;
  @notColumn
  public static final int PAGE_MY_FRESH_NEWS = 3;
  @notColumn
  public static final int PUBLISH_STATE_FAILED = 3;
  @notColumn
  public static final int PUBLISH_STATE_IN_PROGRESS = 2;
  @notColumn
  public static final int PUBLISH_STATE_SUCCESS = 1;
  public String actionUrl = "";
  public int adStyle;
  public List adTopicList;
  public String adTopicListPacked = "";
  public String attendInfo = "";
  public int commentCount;
  @notColumn
  public List commentList = new ArrayList(20);
  public String commentsPacked = "";
  public String common = "";
  public int commonId;
  public String feedContent = "";
  public String feedId;
  @unique
  public String feedPK = "";
  public long feedType;
  public int hotFlag;
  @notColumn
  public HotchatFeedInfo hotchatInfo;
  public String hotchatPacked = "";
  public int isPubNumber;
  @notColumn
  public boolean needDoAnim;
  public int ownerFlag;
  @notColumn
  public List photoPaths = new ArrayList();
  public String photoPathsString = "";
  @notColumn
  public List photoUrls = new Vector();
  public String photoUrlsString = "";
  public int praiseCount;
  public int praiseFlag;
  public List praiseIdList = new ArrayList(6);
  public String publishErrorStr = "";
  public int publishState;
  public long publishTime;
  public int publisherAge = -1;
  public int publisherCharm;
  public int publisherCharmLevel;
  public String publisherConstellation = "";
  public String publisherDistance = "";
  public int publisherGender = -1;
  public long publisherID;
  public int publisherMaritalStatus;
  public String publisherNickname;
  public int publisherProfession;
  public String publisherVip = "";
  @notColumn
  public String strTimeDistance = "4分钟前  500m";
  public int taskID;
  @notColumn
  public TopicInfo topicInfo;
  public String topicPacked = "";
  @notColumn
  public volatile AtomicInteger uploadingPhotoIndex = new AtomicInteger(0);
  public UserInfo userInfo;
  public String userInfoPacked = "";
  public int whichPage = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsInfo() {}
  
  public FreshNewsInfo(Parcel paramParcel)
  {
    this.feedId = paramParcel.readString();
    this.publishState = paramParcel.readInt();
    this.publishErrorStr = paramParcel.readString();
    this.ownerFlag = paramParcel.readInt();
    this.feedType = paramParcel.readLong();
    this.feedContent = paramParcel.readString();
    this.hotFlag = paramParcel.readInt();
    this.publishTime = paramParcel.readLong();
    this.praiseCount = paramParcel.readInt();
    this.praiseFlag = paramParcel.readInt();
    this.commentCount = paramParcel.readInt();
    this.publisherID = paramParcel.readLong();
    this.publisherNickname = paramParcel.readString();
    this.publisherAge = paramParcel.readInt();
    this.publisherGender = paramParcel.readInt();
    this.publisherConstellation = paramParcel.readString();
    this.publisherProfession = paramParcel.readInt();
    this.publisherDistance = paramParcel.readString();
    this.publisherMaritalStatus = paramParcel.readInt();
    this.publisherVip = paramParcel.readString();
    this.publisherCharm = paramParcel.readInt();
    this.publisherCharmLevel = paramParcel.readInt();
    this.commentsPacked = paramParcel.readString();
    this.topicPacked = paramParcel.readString();
    this.topicInfo = ((TopicInfo)paramParcel.readParcelable(FreshNewsInfo.class.getClassLoader()));
    this.commonId = paramParcel.readInt();
    this.common = paramParcel.readString();
    paramParcel.readList(this.photoPaths, null);
    paramParcel.readList(this.photoUrls, null);
    this.uploadingPhotoIndex.set(paramParcel.readInt());
    paramParcel.readList(this.praiseIdList, null);
    paramParcel.readList(this.commentList, FreshNewsInfo.class.getClassLoader());
    this.strTimeDistance = paramParcel.readString();
    this.isPubNumber = paramParcel.readInt();
    this.hotchatInfo = ((HotchatFeedInfo)paramParcel.readParcelable(FreshNewsInfo.class.getClassLoader()));
    this.adStyle = paramParcel.readInt();
    this.taskID = paramParcel.readInt();
    this.attendInfo = paramParcel.readString();
    this.actionUrl = paramParcel.readString();
    this.userInfo = ((UserInfo)paramParcel.readParcelable(UserInfo.class.getClassLoader()));
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.adTopicList = new ArrayList();
      while (i < j)
      {
        HotTopic localHotTopic = (HotTopic)paramParcel.readParcelable(HotTopic.class.getClassLoader());
        this.adTopicList.add(localHotTopic);
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void parseStringToList()
  {
    int j = 0;
    if (this.photoPaths == null) {
      this.photoPaths = new ArrayList();
    }
    if (this.photoUrls == null) {
      this.photoUrls = new Vector();
    }
    String[] arrayOfString;
    int k;
    int i;
    String str;
    if (this.photoPathsString != null)
    {
      arrayOfString = this.photoPathsString.split("\n");
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.photoPaths.add(str);
        }
        i += 1;
      }
    }
    if (this.photoUrlsString != null)
    {
      arrayOfString = this.photoUrlsString.split("\n");
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.photoUrls.add(str);
        }
        i += 1;
      }
    }
  }
  
  protected void postRead()
  {
    super.postRead();
    this.topicInfo = TopicInfo.a(this.topicPacked);
    if (!TextUtils.isEmpty(this.userInfoPacked)) {
      this.userInfo = UserInfo.a(this.userInfoPacked);
    }
    if (!TextUtils.isEmpty(this.adTopicListPacked)) {
      this.adTopicList = HotTopic.a(this.adTopicListPacked);
    }
    parseStringToList();
    if (this.commentList == null) {
      this.commentList = new ArrayList();
    }
    if (!TextUtils.isEmpty(this.commentsPacked)) {
      FreshNewsComment.a(this.commentList, this.commentsPacked);
    }
    HotchatFeedInfo.a(this.hotchatInfo, this.hotchatPacked);
  }
  
  protected void prewrite()
  {
    if (this.commentList != null) {}
    synchronized (this.commentList)
    {
      this.commentsPacked = FreshNewsComment.a(this.commentList);
      if (this.topicInfo != null) {
        this.topicPacked = TopicInfo.a(this.topicInfo);
      }
      if (this.userInfo != null) {
        this.userInfoPacked = UserInfo.a(this.userInfo);
      }
      if (this.adTopicList != null) {
        this.adTopicListPacked = HotTopic.a(this.adTopicList);
      }
      if (this.feedPK == null) {}
    }
    Iterator localIterator;
    for (;;)
    {
      synchronized (this.feedPK)
      {
        this.feedPK = (String.valueOf(this.whichPage) + "#" + this.feedId);
        if (this.photoPaths == null) {
          break label271;
        }
        synchronized (this.photoPaths)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          if (this.photoPaths == null) {
            break label269;
          }
          localIterator = this.photoPaths.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localStringBuilder1.append((String)localIterator.next());
          localStringBuilder1.append("\n");
        }
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
      this.feedPK = (String.valueOf(this.whichPage) + "#" + this.feedId);
    }
    this.photoPathsString = ((StringBuilder)localObject4).toString();
    label269:
    label271:
    if (this.photoUrls != null)
    {
      synchronized (this.photoUrls)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        if (this.photoUrls == null) {
          break label356;
        }
        localIterator = this.photoUrls.iterator();
        if (localIterator.hasNext())
        {
          localStringBuilder2.append((String)localIterator.next());
          localStringBuilder2.append("\n");
        }
      }
      this.photoUrlsString = ((StringBuilder)localObject5).toString();
    }
    label356:
    this.hotchatPacked = HotchatFeedInfo.a(this.hotchatInfo);
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    localStringBuilder1.append("---------------start--------------------------");
    localStringBuilder1.append("feedid:").append(this.feedId).append("\n");
    localStringBuilder1.append("publishState:").append(this.publishState).append("\n");
    localStringBuilder1.append("publishErrorStr:").append(this.publishErrorStr).append("\n");
    localStringBuilder1.append("ownerFlag:").append(this.ownerFlag).append("\n");
    localStringBuilder1.append("feedType:").append(this.feedType).append("\n");
    localStringBuilder1.append("feedContent:").append(this.feedContent).append("\n");
    localStringBuilder1.append("hotFlag:").append(this.hotFlag).append("\n");
    localStringBuilder1.append("publishTime:").append(this.publishTime).append("\n");
    localStringBuilder1.append("praiseCount:").append(this.praiseCount).append("\n");
    localStringBuilder1.append("praiseFlag:").append(this.praiseFlag).append("\n");
    localStringBuilder1.append("commentCount:").append(this.commentCount).append("\n");
    localStringBuilder1.append("publisherID:").append(this.publisherID).append("\n");
    localStringBuilder1.append("publisherNickname:").append(this.publisherNickname).append("\n");
    localStringBuilder1.append("publisherAge:").append(this.publisherAge).append("\n");
    localStringBuilder1.append("publisherGender:").append(this.publisherGender).append("\n");
    localStringBuilder1.append("publisherConstellation:").append(this.publisherConstellation).append("\n");
    localStringBuilder1.append("publisherProfession:").append(this.publisherProfession).append("\n");
    localStringBuilder1.append("commonId:").append(this.commonId).append("\n");
    localStringBuilder1.append("common:").append(this.common).append("\n");
    localStringBuilder1.append("publisherDistance:").append(this.publisherDistance).append("\n");
    localStringBuilder1.append("publisherMaritalStatus:").append(this.publisherMaritalStatus).append("\n");
    localStringBuilder1.append("publisherVip:").append(this.publisherVip).append("\n");
    localStringBuilder1.append("publisherCharm:").append(this.publisherCharm).append("\n");
    localStringBuilder1.append("publisherCharmLevel:").append(this.publisherCharmLevel).append("\n");
    localStringBuilder1.append("commentsPacked:").append(this.commentsPacked).append("\n");
    localStringBuilder1.append("topicPacked:").append(this.topicPacked).append("\n");
    localStringBuilder1.append("topic:").append(this.topicInfo).append("\n");
    localStringBuilder1.append("isPubNumber:").append(this.isPubNumber).append("\n");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("hotchatFeedInfo:");
    if (this.hotchatInfo == null) {}
    for (Object localObject = "null";; localObject = this.hotchatInfo.toString())
    {
      localStringBuilder2.append((String)localObject).append("\n");
      i = 0;
      while (i < this.photoPaths.size())
      {
        localStringBuilder1.append("photoPath").append(i).append(":").append((String)this.photoPaths.get(i)).append("\n");
        i += 1;
      }
    }
    int i = 0;
    while (i < this.photoUrls.size())
    {
      localStringBuilder1.append("photoUrl").append(i).append(":").append((String)this.photoUrls.get(i)).append("\n");
      i += 1;
    }
    localStringBuilder1.append("uploadingPhotoIndex:").append(this.uploadingPhotoIndex.get()).append("\n");
    i = 0;
    while (i < this.praiseIdList.size())
    {
      localStringBuilder1.append("praiseId").append(i).append(":").append(this.praiseIdList.get(i)).append("\n");
      i += 1;
    }
    i = 0;
    while (i < this.commentList.size())
    {
      localObject = (FreshNewsComment)this.commentList.get(i);
      localStringBuilder1.append("comment").append(i).append(":");
      localStringBuilder1.append("publisherId=").append(((FreshNewsComment)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long);
      localStringBuilder1.append(",publisherNickname=").append(((FreshNewsComment)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(",content=").append(((FreshNewsComment)localObject).c);
      localStringBuilder1.append(",pubtime=").append(((FreshNewsComment)localObject).jdField_a_of_type_Long);
      localStringBuilder1.append(",strTime=").append(((FreshNewsComment)localObject).e).append("\n");
      i += 1;
    }
    localStringBuilder1.append("strTimeDistance:").append(this.strTimeDistance).append("\n");
    localStringBuilder1.append("adStyle:").append(this.adStyle).append("\n");
    localStringBuilder1.append("taskID:").append(this.taskID).append("\n");
    localStringBuilder1.append("attendInfo:").append(this.attendInfo).append("\n");
    localStringBuilder1.append("userInfo:").append(this.userInfo).append("\n");
    if (this.adTopicList != null)
    {
      i = j;
      while (i < this.adTopicList.size())
      {
        localStringBuilder1.append("adTopic").append(i).append(":").append(this.adTopicList.get(i)).append("\n");
        i += 1;
      }
    }
    localStringBuilder1.append("---------------end--------------------------");
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeInt(this.publishState);
    paramParcel.writeString(this.publishErrorStr);
    paramParcel.writeInt(this.ownerFlag);
    paramParcel.writeLong(this.feedType);
    paramParcel.writeString(this.feedContent);
    paramParcel.writeInt(this.hotFlag);
    paramParcel.writeLong(this.publishTime);
    paramParcel.writeInt(this.praiseCount);
    paramParcel.writeInt(this.praiseFlag);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeLong(this.publisherID);
    paramParcel.writeString(this.publisherNickname);
    paramParcel.writeInt(this.publisherAge);
    paramParcel.writeInt(this.publisherGender);
    paramParcel.writeString(this.publisherConstellation);
    paramParcel.writeInt(this.publisherProfession);
    paramParcel.writeString(this.publisherDistance);
    paramParcel.writeInt(this.publisherMaritalStatus);
    paramParcel.writeString(this.publisherVip);
    paramParcel.writeInt(this.publisherCharm);
    paramParcel.writeInt(this.publisherCharmLevel);
    paramParcel.writeString(this.commentsPacked);
    paramParcel.writeString(this.topicPacked);
    paramParcel.writeParcelable(this.topicInfo, 0);
    paramParcel.writeInt(this.commonId);
    paramParcel.writeString(this.common);
    paramParcel.writeList(this.photoPaths);
    paramParcel.writeList(this.photoUrls);
    paramParcel.writeInt(this.uploadingPhotoIndex.get());
    paramParcel.writeList(this.praiseIdList);
    paramParcel.writeList(this.commentList);
    paramParcel.writeString(this.strTimeDistance);
    paramParcel.writeInt(this.isPubNumber);
    paramParcel.writeParcelable(this.hotchatInfo, 0);
    paramParcel.writeInt(this.adStyle);
    paramParcel.writeInt(this.taskID);
    paramParcel.writeString(this.attendInfo);
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeParcelable(this.userInfo, paramInt);
    if (this.adTopicList == null) {}
    for (paramInt = 0;; paramInt = this.adTopicList.size())
    {
      paramParcel.writeInt(paramInt);
      if (this.adTopicList == null) {
        break;
      }
      int i = 0;
      while (i < paramInt)
      {
        paramParcel.writeParcelable((Parcelable)this.adTopicList.get(i), 0);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */