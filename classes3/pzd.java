import android.os.Bundle;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.AfterDownloadCallback;

public class pzd
  implements IndividualRedPacketResDownloader.AfterDownloadCallback
{
  public pzd(IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.a.a(paramBundle.getString("aio_request_key"), paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */