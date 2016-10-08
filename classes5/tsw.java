import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.UiCallBack;

public abstract interface tsw
{
  public abstract MessageRecord a(PicFowardInfo paramPicFowardInfo);
  
  public abstract MessageRecord a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void a(PicReq paramPicReq);
  
  public abstract void a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(UiCallBack paramUiCallBack);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */