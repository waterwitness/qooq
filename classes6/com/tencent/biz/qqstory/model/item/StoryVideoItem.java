package com.tencent.biz.qqstory.model.item;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.preload.PreloadUtils;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import ijp;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class StoryVideoItem
  extends BaseUIItem
  implements Parcelable, Copyable, Comparable
{
  public static final Parcelable.Creator CREATOR = new ijp();
  public static final String FAKE_VID_PRE = "fake_vid_";
  public static final int MAX_VIEW_COUNT = 100000;
  public static final int PRELOAD_STATE_FAIL = 2;
  public static final int PRELOAD_STATE_INIT = 0;
  public static final int PRELOAD_STATE_SUC = 1;
  public long mCreateTime;
  public String mDoodleText;
  public int mHasRelatedVideo = -1;
  public boolean mHasWatched;
  public int mIsPlaying;
  public String mLabel;
  public String mLocalMaskPath;
  public String mLocalVideoPath;
  public AddressItem mLocation;
  public String mOriginalMaskPicUrl;
  public long mOwnerUid;
  public String mPreloadMsg;
  public int mPreloadState = 0;
  public int mStrangerViewCount;
  public String mTitle;
  public int mUploadLastOffset;
  public String mUploadServerIp;
  public int mUploadStatus = 5;
  protected long mUseCacheTime;
  public String mVid;
  public long mVideoBytes;
  public long mVideoDuration;
  public int mVideoHeight;
  public String mVideoLocalThumbnailPath;
  public String mVideoThumbnailUrl;
  public String mVideoUrl;
  public int mVideoWidth;
  public int mViewCount;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StoryVideoItem() {}
  
  public StoryVideoItem(Parcel paramParcel)
  {
    this.mVideoUrl = paramParcel.readString();
    this.mVideoThumbnailUrl = paramParcel.readString();
    this.mVid = paramParcel.readString();
    this.mOriginalMaskPicUrl = paramParcel.readString();
    this.mCreateTime = paramParcel.readLong();
    this.mViewCount = paramParcel.readInt();
    this.mLocalVideoPath = paramParcel.readString();
    this.mLocalMaskPath = paramParcel.readString();
    this.mVideoLocalThumbnailPath = paramParcel.readString();
    this.mVideoDuration = paramParcel.readLong();
    this.mVideoWidth = paramParcel.readInt();
    this.mVideoHeight = paramParcel.readInt();
    this.mVideoBytes = paramParcel.readLong();
    this.mLabel = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mHasRelatedVideo = paramParcel.readInt();
    this.mDoodleText = paramParcel.readString();
    this.mOwnerUid = paramParcel.readLong();
    this.mStrangerViewCount = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.mHasWatched = bool;
      return;
      bool = false;
    }
  }
  
  public StoryVideoItem(StoryVideoEntry paramStoryVideoEntry)
  {
    this.mVid = paramStoryVideoEntry.vid;
    this.mVideoUrl = paramStoryVideoEntry.videoUrl;
    this.mVideoThumbnailUrl = paramStoryVideoEntry.videoThumbnailUrl;
    this.mOriginalMaskPicUrl = paramStoryVideoEntry.maskPicUrl;
    this.mVideoLocalThumbnailPath = paramStoryVideoEntry.localVideoThumbnailPath;
    this.mLocalVideoPath = paramStoryVideoEntry.localVideoPath;
    this.mLocalMaskPath = paramStoryVideoEntry.localMaskPicPath;
    this.mViewCount = paramStoryVideoEntry.viewCount;
    this.mCreateTime = paramStoryVideoEntry.createTime;
    this.mUploadStatus = paramStoryVideoEntry.uploadStatus;
    this.mUploadServerIp = paramStoryVideoEntry.uploadSeverIp;
    this.mUploadLastOffset = paramStoryVideoEntry.uploadLastOffset;
    this.mVideoDuration = paramStoryVideoEntry.videoDuration;
    this.mVideoWidth = paramStoryVideoEntry.videoWidth;
    this.mVideoHeight = paramStoryVideoEntry.videoHeight;
    this.mVideoBytes = paramStoryVideoEntry.videoBytes;
    this.mLabel = paramStoryVideoEntry.label;
    this.mTitle = paramStoryVideoEntry.title;
    this.mHasRelatedVideo = paramStoryVideoEntry.hasRelatedVideo;
    if (paramStoryVideoEntry.hasWatched == 1) {}
    for (;;)
    {
      this.mHasWatched = bool;
      this.mDoodleText = paramStoryVideoEntry.doodleText;
      this.mOwnerUid = paramStoryVideoEntry.owerUin;
      this.mStrangerViewCount = paramStoryVideoEntry.strangerViewCount;
      try
      {
        if (!TextUtils.isEmpty(paramStoryVideoEntry.address)) {
          this.mLocation = AddressItem.convertFromJson(paramStoryVideoEntry.address);
        }
        return;
      }
      catch (Exception paramStoryVideoEntry)
      {
        SLog.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", paramStoryVideoEntry.toString());
        paramStoryVideoEntry.printStackTrace();
      }
      bool = false;
    }
  }
  
  public static String dump(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((StoryVideoItem)paramList.next()).mVid).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String getViewCountString(int paramInt)
  {
    if (paramInt <= 100000) {
      return String.valueOf(paramInt);
    }
    return "100000+";
  }
  
  public static boolean isFakeVid(String paramString)
  {
    return paramString.contains("fake_vid_");
  }
  
  public int compareTo(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    do
    {
      return 0;
      if (paramStoryVideoItem.mCreateTime > this.mCreateTime) {
        return 1;
      }
    } while (paramStoryVideoItem.mCreateTime >= this.mCreateTime);
    return -1;
  }
  
  public void convertFrom(String paramString, qqstory_struct.StoryVideoDes paramStoryVideoDes)
  {
    this.mCreateTime = (paramStoryVideoDes.create_time.get() * 1000L);
    this.mVid = paramStoryVideoDes.vid.get().toStringUtf8();
    this.mVideoUrl = paramStoryVideoDes.video_url.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramStoryVideoDes.video_cover.get().toStringUtf8();
    this.mViewCount = paramStoryVideoDes.view_total_num.get();
    this.mVideoDuration = paramStoryVideoDes.video_total_time.get();
    Object localObject = new QQUserUIItem();
    ((QQUserUIItem)localObject).convertFrom(paramStoryVideoDes.owner);
    ((UserManager)SuperManager.a(2)).a((QQUserUIItem)localObject);
    this.mOwnerUid = ((QQUserUIItem)localObject).uid;
    localObject = paramStoryVideoDes.video_attr.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      this.mVideoWidth = ((JSONObject)localObject).optInt("video_width");
      this.mVideoHeight = ((JSONObject)localObject).optInt("video_height");
      this.mVideoBytes = ((JSONObject)localObject).optLong("video_bytes");
      this.mDoodleText = ((JSONObject)localObject).optString("video_doodle_text");
      this.mOriginalMaskPicUrl = paramStoryVideoDes.doodle_url.get().toStringUtf8();
      this.mLabel = paramStoryVideoDes.label.get().toStringUtf8();
      if (paramStoryVideoDes.has_related_videos.has()) {
        this.mHasRelatedVideo = paramStoryVideoDes.has_related_videos.get();
      }
      this.mStrangerViewCount = paramStoryVideoDes.stranger_view_total_num.get();
      if (paramStoryVideoDes.address.has()) {
        this.mLocation = AddressItem.getAddressFromProtoObject((qqstory_struct.Address)paramStoryVideoDes.address.get());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.b(paramString, "decode json fail", localException);
      }
    }
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (StoryVideoItem)paramObject;
    this.mVid = ((StoryVideoItem)paramObject).mVid;
    this.mUploadStatus = ((StoryVideoItem)paramObject).mUploadStatus;
    this.mUploadServerIp = ((StoryVideoItem)paramObject).mUploadServerIp;
    this.mUploadLastOffset = ((StoryVideoItem)paramObject).mUploadLastOffset;
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mVideoUrl)) {
      this.mVideoUrl = ((StoryVideoItem)paramObject).mVideoUrl;
    }
    if (((StoryVideoItem)paramObject).mCreateTime != 0L) {
      this.mCreateTime = ((StoryVideoItem)paramObject).mCreateTime;
    }
    if (((StoryVideoItem)paramObject).mViewCount != 0) {
      this.mViewCount = ((StoryVideoItem)paramObject).mViewCount;
    }
    if (((StoryVideoItem)paramObject).mStrangerViewCount != 0) {
      this.mStrangerViewCount = ((StoryVideoItem)paramObject).mStrangerViewCount;
    }
    if (((StoryVideoItem)paramObject).mVideoDuration != 0L) {
      this.mVideoDuration = ((StoryVideoItem)paramObject).mVideoDuration;
    }
    if (((StoryVideoItem)paramObject).mVideoWidth != 0) {
      this.mVideoWidth = ((StoryVideoItem)paramObject).mVideoWidth;
    }
    if (((StoryVideoItem)paramObject).mVideoHeight != 0) {
      this.mVideoHeight = ((StoryVideoItem)paramObject).mVideoHeight;
    }
    if (((StoryVideoItem)paramObject).mVideoBytes != 0L) {
      this.mVideoBytes = ((StoryVideoItem)paramObject).mVideoBytes;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mVideoThumbnailUrl)) {
      this.mVideoThumbnailUrl = ((StoryVideoItem)paramObject).mVideoThumbnailUrl;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mOriginalMaskPicUrl)) {
      this.mOriginalMaskPicUrl = ((StoryVideoItem)paramObject).mOriginalMaskPicUrl;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mVideoLocalThumbnailPath)) {
      this.mVideoLocalThumbnailPath = ((StoryVideoItem)paramObject).mVideoLocalThumbnailPath;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mLocalVideoPath)) {
      this.mLocalVideoPath = ((StoryVideoItem)paramObject).mLocalVideoPath;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mLabel)) {
      this.mLabel = ((StoryVideoItem)paramObject).mLabel;
    }
    if (((StoryVideoItem)paramObject).mLocation != null) {
      this.mLocation = ((StoryVideoItem)paramObject).mLocation;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)paramObject).mDoodleText)) {
      this.mDoodleText = ((StoryVideoItem)paramObject).mDoodleText;
    }
    if (((StoryVideoItem)paramObject).mOwnerUid != 0L) {
      this.mOwnerUid = ((StoryVideoItem)paramObject).mOwnerUid;
    }
    if (((StoryVideoItem)paramObject).mHasRelatedVideo != -1) {
      this.mHasRelatedVideo = ((StoryVideoItem)paramObject).mHasRelatedVideo;
    }
    this.mHasWatched = ((StoryVideoItem)paramObject).mHasWatched;
    if (((StoryVideoItem)paramObject).mPreloadState != 0) {
      this.mPreloadState = ((StoryVideoItem)paramObject).mPreloadState;
    }
    this.mPreloadMsg = ((StoryVideoItem)paramObject).mPreloadMsg;
    this.mUseCacheTime = ((StoryVideoItem)paramObject).mUseCacheTime;
  }
  
  public StoryVideoEntry cover2StoryEntry()
  {
    StoryVideoEntry localStoryVideoEntry = new StoryVideoEntry();
    localStoryVideoEntry.vid = this.mVid;
    localStoryVideoEntry.videoUrl = this.mVideoUrl;
    localStoryVideoEntry.maskPicUrl = this.mOriginalMaskPicUrl;
    localStoryVideoEntry.videoThumbnailUrl = this.mVideoThumbnailUrl;
    localStoryVideoEntry.localVideoThumbnailPath = this.mVideoLocalThumbnailPath;
    localStoryVideoEntry.localVideoPath = this.mLocalVideoPath;
    localStoryVideoEntry.localMaskPicPath = this.mLocalMaskPath;
    localStoryVideoEntry.viewCount = this.mViewCount;
    localStoryVideoEntry.createTime = this.mCreateTime;
    localStoryVideoEntry.uploadStatus = this.mUploadStatus;
    localStoryVideoEntry.uploadSeverIp = this.mUploadServerIp;
    localStoryVideoEntry.uploadLastOffset = this.mUploadLastOffset;
    localStoryVideoEntry.videoDuration = this.mVideoDuration;
    localStoryVideoEntry.videoWidth = this.mVideoWidth;
    localStoryVideoEntry.videoHeight = this.mVideoHeight;
    localStoryVideoEntry.videoBytes = this.mVideoBytes;
    localStoryVideoEntry.label = this.mLabel;
    localStoryVideoEntry.title = this.mTitle;
    localStoryVideoEntry.hasRelatedVideo = this.mHasRelatedVideo;
    if (this.mHasWatched) {}
    for (int i = 1;; i = 0)
    {
      localStoryVideoEntry.hasWatched = i;
      localStoryVideoEntry.doodleText = this.mDoodleText;
      localStoryVideoEntry.owerUin = this.mOwnerUid;
      localStoryVideoEntry.strangerViewCount = this.mStrangerViewCount;
      if (this.mLocation != null) {
        localStoryVideoEntry.address = AddressItem.convertFromItem(this.mLocation);
      }
      return localStoryVideoEntry;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (StoryVideoItem)paramObject;
    return this.mVid.equals(((StoryVideoItem)paramObject).mVid);
  }
  
  public String getDownloadMaskUrl()
  {
    if (TextUtils.isEmpty(this.mOriginalMaskPicUrl)) {
      return this.mOriginalMaskPicUrl;
    }
    if (!this.mOriginalMaskPicUrl.endsWith(File.separator)) {
      this.mOriginalMaskPicUrl += File.separator;
    }
    return this.mOriginalMaskPicUrl + "1000/";
  }
  
  public boolean hasRelativeVideo()
  {
    return this.mHasRelatedVideo == 1;
  }
  
  public int hashCode()
  {
    return this.mVid.hashCode();
  }
  
  public boolean isMaskVideo()
  {
    return ((this.mLocalMaskPath != null) && (!this.mLocalMaskPath.equals(""))) || ((this.mOriginalMaskPicUrl != null) && (!this.mOriginalMaskPicUrl.equals("")));
  }
  
  public boolean isNativeloadMask()
  {
    if (this.mLocalMaskPath != null) {
      return this.mLocalMaskPath.startsWith(QQStoryConstant.q);
    }
    return false;
  }
  
  public boolean isPreloadSuc(boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    this.mUseCacheTime += 1L;
    if ((!paramBoolean) && (this.mUseCacheTime % 30L != 0L) && (this.mPreloadState != 0))
    {
      paramBoolean = bool1;
      if (this.mPreloadState == 1) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    File localFile = PreloadUtils.a(this.mVid, 0);
    if (PreloadUtils.a(localFile))
    {
      if (TextUtils.isEmpty(this.mLocalVideoPath))
      {
        this.mLocalVideoPath = localFile.getAbsolutePath();
        ((StoryManager)SuperManager.a(5)).a(this.mVid, this);
      }
      this.mPreloadState = 1;
      return true;
    }
    if (!TextUtils.isEmpty(this.mLocalVideoPath))
    {
      if (PreloadUtils.a(new File(this.mLocalVideoPath)))
      {
        this.mPreloadState = 1;
        if (this.mPreloadState != 1) {
          break label163;
        }
      }
      label163:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        return paramBoolean;
        this.mPreloadState = 2;
        break;
      }
    }
    this.mPreloadState = 2;
    return false;
  }
  
  public boolean isUploadFail()
  {
    return (this.mUploadStatus == 6) || (this.mUploadStatus == 3);
  }
  
  public boolean isUploadSuc()
  {
    return this.mUploadStatus == 5;
  }
  
  public String toString()
  {
    return "StoryVideoItem{, mVideoUrl='" + this.mVideoUrl + '\'' + ", mVideoThumbnailUrl='" + this.mVideoThumbnailUrl + '\'' + ", mVid='" + this.mVid + '\'' + ", mOriginalMaskPicUrl='" + this.mOriginalMaskPicUrl + '\'' + ", mCreateTime=" + this.mCreateTime + ", mViewCount=" + this.mViewCount + ", mLocalVideoPath=" + this.mLocalVideoPath + '\'' + ", mLocalMaskPath=" + this.mLocalMaskPath + '\'' + ", mVideoLocalThumbnailPath=" + this.mVideoLocalThumbnailPath + '\'' + ", mUploadStatus=" + this.mUploadStatus + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mVideoUrl);
    paramParcel.writeString(this.mVideoThumbnailUrl);
    paramParcel.writeString(this.mVid);
    paramParcel.writeString(this.mOriginalMaskPicUrl);
    paramParcel.writeLong(this.mCreateTime);
    paramParcel.writeInt(this.mViewCount);
    paramParcel.writeString(this.mLocalVideoPath);
    paramParcel.writeString(this.mLocalMaskPath);
    paramParcel.writeString(this.mVideoLocalThumbnailPath);
    paramParcel.writeLong(this.mVideoDuration);
    paramParcel.writeInt(this.mVideoWidth);
    paramParcel.writeInt(this.mVideoHeight);
    paramParcel.writeLong(this.mVideoBytes);
    paramParcel.writeString(this.mLabel);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mHasRelatedVideo);
    paramParcel.writeString(this.mDoodleText);
    paramParcel.writeLong(this.mOwnerUid);
    paramParcel.writeInt(this.mStrangerViewCount);
    if (this.mHasWatched) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\StoryVideoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */