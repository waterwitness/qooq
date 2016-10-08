package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator<TMAssistantDownloadTaskInfo>
{
  public TMAssistantDownloadTaskInfo a(Parcel paramParcel)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
    localTMAssistantDownloadTaskInfo.mAppId = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mTaskPackageName = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mTaskVersionCode = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mIconUrl = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mAppName = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mStartTime = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mEndTime = paramParcel.readLong();
    localTMAssistantDownloadTaskInfo.mVia = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.mChannelid = paramParcel.readString();
    localTMAssistantDownloadTaskInfo.showNotification = paramParcel.readInt();
    return localTMAssistantDownloadTaskInfo;
  }
  
  public TMAssistantDownloadTaskInfo[] a(int paramInt)
  {
    return new TMAssistantDownloadTaskInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\aidl\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */