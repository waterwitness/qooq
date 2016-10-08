import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class kaz
  implements Parcelable.Creator
{
  public kaz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageForDevShortVideo a(Parcel paramParcel)
  {
    MessageForDevShortVideo localMessageForDevShortVideo = new MessageForDevShortVideo();
    localMessageForDevShortVideo.uuid = paramParcel.readString();
    localMessageForDevShortVideo.md5 = paramParcel.readString();
    localMessageForDevShortVideo.videoFileName = paramParcel.readString();
    localMessageForDevShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForDevShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForDevShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForDevShortVideo.fileType = paramParcel.readInt();
    localMessageForDevShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForDevShortVideo.fileSource = paramParcel.readString();
    localMessageForDevShortVideo.lastModified = paramParcel.readLong();
    return localMessageForDevShortVideo;
  }
  
  public MessageForDevShortVideo[] a(int paramInt)
  {
    return new MessageForDevShortVideo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */