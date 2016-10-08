import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.freshnews.data.FNADNowItemData;
import com.tencent.mobileqq.freshnews.feed.FNADNowItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class srs
  implements View.OnClickListener
{
  public srs(FNADNowItemBuilder paramFNADNowItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296515: 
    case 2131301691: 
    case 2131301692: 
      do
      {
        return;
        localObject = paramView.getTag();
      } while (!(localObject instanceof FNADNowItemData));
      localObject = (FNADNowItemData)localObject;
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", ((FNADNowItemData)localObject).d);
      paramView.getContext().startActivity(localIntent);
      return;
    }
    Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://now.qq.com/qq/recommend.html?_bid=2374&_wv=16778245&from=50034&channellink=CK1338999808411&ioschannel=50034");
    paramView.getContext().startActivity((Intent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */