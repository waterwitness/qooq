import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rbz
  implements Parcelable.Creator
{
  public rbz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageForShortVideo a(Parcel paramParcel)
  {
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.uniseq = paramParcel.readLong();
    localMessageForShortVideo.istroop = paramParcel.readInt();
    localMessageForShortVideo.selfuin = paramParcel.readString();
    localMessageForShortVideo.frienduin = paramParcel.readString();
    localMessageForShortVideo.senderuin = paramParcel.readString();
    localMessageForShortVideo.uuid = paramParcel.readString();
    localMessageForShortVideo.md5 = paramParcel.readString();
    localMessageForShortVideo.videoFileName = paramParcel.readString();
    localMessageForShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForShortVideo.fileType = paramParcel.readInt();
    localMessageForShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForShortVideo.fileSource = paramParcel.readString();
    localMessageForShortVideo.lastModified = paramParcel.readLong();
    localMessageForShortVideo.thumbFileSize = paramParcel.readInt();
    localMessageForShortVideo.busiType = paramParcel.readInt();
    localMessageForShortVideo.fromChatType = paramParcel.readInt();
    localMessageForShortVideo.toChatType = paramParcel.readInt();
    localMessageForShortVideo.uiOperatorFlag = paramParcel.readInt();
    localMessageForShortVideo.mVideoFileSourceDir = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMessageForShortVideo.supportProgressive = bool;
      localMessageForShortVideo.fileWidth = paramParcel.readInt();
      localMessageForShortVideo.fileHeight = paramParcel.readInt();
      localMessageForShortVideo.transferedSize = paramParcel.readInt();
      localMessageForShortVideo.subBusiType = paramParcel.readInt();
      localMessageForShortVideo.videoAttr = paramParcel.readInt();
      localMessageForShortVideo.binarySet = paramParcel.readInt();
      return localMessageForShortVideo;
    }
  }
  
  public MessageForShortVideo[] a(int paramInt)
  {
    return new MessageForShortVideo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */