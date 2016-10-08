import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pkj
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  public pkj(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPlayActivity", 2, "ThirdVidoeManager UUIDToUrlCallback() url=" + paramString1 + ", vid=" + paramString2);
    }
    this.a.a(0L, null, paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */