import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.UiCallBack;

public abstract interface uqe
{
  public abstract MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo);
  
  public abstract MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo);
  
  public abstract void a(ShortVideoForwardInfo paramShortVideoForwardInfo);
  
  public abstract void a(ShortVideoUploadInfo paramShortVideoUploadInfo);
  
  public abstract void a(UiCallBack paramUiCallBack);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */