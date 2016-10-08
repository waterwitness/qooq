import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sqa
  implements Runnable
{
  sqa(spy paramspy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FreshNewsInfo localFreshNewsInfo = this.a.a.b.a;
    if (localFreshNewsInfo != null) {
      NewReportPlugin.a(this.a.a.a, true, String.valueOf(localFreshNewsInfo.publisherID), 202, "freshnews", localFreshNewsInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */