import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class ohk
  implements ReadInJoySearchTipsContainer.OnTipClickListener
{
  public ohk(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    ChannelInfo localChannelInfo;
    if (paramString != null)
    {
      Iterator localIterator = this.a.c.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localChannelInfo = (ChannelInfo)localIterator.next();
      } while (!paramString.equals(localChannelInfo.mChannelName));
    }
    for (paramString = localChannelInfo;; paramString = null)
    {
      if (paramString != null)
      {
        ReadInJoyActivityHelper.a(this.a, paramString.mChannelID, paramString.mChannelName, paramString.mChannelType, 0);
        ReportController.b(this.a.app, "dc00898", "", "", "0X800691B", "0X800691B", 0, 0, "", "", "", ReadInJoyUtils.a(paramString.mChannelID));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */