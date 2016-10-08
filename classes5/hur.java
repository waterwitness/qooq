import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.RecommendItemInfo;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class hur
  implements AdapterView.OnItemSelectedListener
{
  public hur(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ImageCollectionActivity.a(this.a, paramInt);
    if (ImageCollectionActivity.a(this.a) != null) {
      ImageCollectionActivity.a(this.a).notifyDataSetChanged();
    }
    int j;
    int i;
    int k;
    if ((ImageCollectionActivity.a(this.a).size() > 0) && (paramInt == ImageCollectionActivity.a(this.a).getCount() - 1))
    {
      ImageCollectionActivity.a(this.a);
      if (!ImageCollectionActivity.a(this.a))
      {
        j = ImageCollectionActivity.a(this.a).size();
        i = 0;
        while (i < j)
        {
          paramView = (PublicAccountArticleObserver.RecommendItemInfo)ImageCollectionActivity.a(this.a).get(i);
          paramAdapterView = ImageCollectionActivity.a(this.a);
          paramView = paramView.c;
          String str = ImageCollectionActivity.b(this.a);
          StringBuilder localStringBuilder = new StringBuilder().append("");
          i += 1;
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramAdapterView, "0X8006F82", "0X8006F82", 0, 0, paramView, str, i, "" + j);
          i += 1;
        }
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", ImageCollectionActivity.a(this.a), "0X8006F84", "0X8006F84", 0, 0, "", ImageCollectionActivity.b(this.a), "", "" + j);
      }
      ImageCollectionActivity.a(this.a, true);
      paramLong = System.currentTimeMillis();
      i = (int)(paramLong - ImageCollectionActivity.a(this.a));
      if (ImageCollectionActivity.a(this.a) >= 0)
      {
        if (ImageCollectionActivity.a(this.a) >= paramInt) {
          break label472;
        }
        j = paramInt - 1;
        if (ImageCollectionActivity.b(this.a).size() <= j) {
          break label453;
        }
        k = ((Integer)ImageCollectionActivity.b(this.a).get(j)).intValue();
        ImageCollectionActivity.b(this.a).set(j, Integer.valueOf(k + i));
        label373:
        if (QLog.isColorLevel()) {
          QLog.d("ImageCollectionActivity", 2, "remainTime = " + i + "reportPosition = " + j);
        }
      }
    }
    label453:
    label472:
    label595:
    for (;;)
    {
      ImageCollectionActivity.a(this.a, paramLong);
      ImageCollectionActivity.b(this.a, paramInt);
      ImageCollectionActivity.b(this.a);
      return;
      ImageCollectionActivity.b(this.a);
      break;
      ImageCollectionActivity.b(this.a).add(Integer.valueOf(i));
      break label373;
      j = paramInt + 1;
      if (ImageCollectionActivity.b(this.a).size() > j)
      {
        k = ((Integer)ImageCollectionActivity.b(this.a).get(j)).intValue();
        ImageCollectionActivity.b(this.a).set(j, Integer.valueOf(k + i));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label595;
        }
        QLog.d("ImageCollectionActivity", 2, "remainTime = " + i + "reportPosition = " + j);
        break;
        ImageCollectionActivity.b(this.a).add(Integer.valueOf(i));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */