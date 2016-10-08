import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.freshnews.feed.FNADHotTopicItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class srr
  implements View.OnClickListener
{
  public srr(FNADHotTopicItemBuilder paramFNADHotTopicItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof HotTopic));
    Object localObject = (HotTopic)localObject;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", ((HotTopic)localObject).c);
    paramView.getContext().startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */