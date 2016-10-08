import android.widget.ImageView;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener;
import java.util.HashMap;

public class lpa
  implements IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener
{
  public lpa(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ImageView localImageView;
    if (this.a.a != null)
    {
      localImageView = (ImageView)this.a.b.get("hongbao");
      if (localImageView != null)
      {
        if ((!this.a.a.b()) || (!this.a.a.a().b)) {
          break label65;
        }
        localImageView.setVisibility(0);
      }
    }
    return;
    label65:
    localImageView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */