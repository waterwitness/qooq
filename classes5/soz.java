import com.tencent.mobileqq.freshnews.FreshNewsComment;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsStranger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import java.util.List;

public class soz
  extends NearbyProcObserver
{
  public soz(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      this.a.b(1, 2131372192, 0);
      this.a.j();
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      if (paramList == null)
      {
        paramList = "";
        if (this.a.s != 0) {
          break label117;
        }
        this.a.a(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID), paramList, true);
      }
    }
    else
    {
      label43:
      if (!FreshNewsDetailActivity.a(this.a)) {
        break label183;
      }
      paramList = this.a;
      if (!paramBoolean) {
        break label176;
      }
    }
    label117:
    label176:
    for (int i = 2131372193;; i = 2131372194)
    {
      paramList.b(2, i, 0);
      this.a.j();
      return;
      if (paramList.size() <= 0)
      {
        paramList = "";
        break;
      }
      paramList = Long.toString(((Long)paramList.get(0)).longValue());
      break;
      if (this.a.s != 1) {
        break label43;
      }
      this.a.a(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.a.a), paramList, true);
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.a.a);
      break label43;
    }
    label183:
    FreshNewsDetailActivity localFreshNewsDetailActivity = this.a;
    if (paramBoolean) {}
    for (paramList = this.a.getString(2131372193);; paramList = this.a.getString(2131372194))
    {
      localFreshNewsDetailActivity.b = paramList;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
    {
      this.a.b(1, 2131372194, 0);
      this.a.j();
    }
  }
  
  public void b(boolean paramBoolean, List paramList)
  {
    long l;
    if (paramBoolean)
    {
      paramList = this.a;
      if (this.a.s == 0)
      {
        l = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID;
        paramList.a(Long.valueOf(l), "", false);
      }
    }
    else
    {
      paramList = this.a;
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 2131372191;; i = 2131372192)
    {
      paramList.b(2, i, 0);
      this.a.j();
      return;
      l = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.a.a;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\soz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */