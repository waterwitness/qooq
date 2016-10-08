import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.RecommendItemInfo;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ImageCollectionGallery;
import java.util.ArrayList;

public class hvc
  implements AdapterView.OnItemClickListener
{
  public hvc(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < ImageCollectionActivity.c(this.a).size()) {
      ImageCollectionActivity.c(this.a);
    }
    do
    {
      do
      {
        return;
        paramAdapterView = ImageCollectionActivity.a(this.a).findViewById(2131298714);
      } while (paramAdapterView == null);
      paramView = new Rect();
      paramAdapterView.getGlobalVisibleRect(paramView);
      if (!paramView.contains((int)ImageCollectionActivity.a(this.a), (int)ImageCollectionActivity.b(this.a))) {
        break;
      }
      paramInt = 0;
      if (ImageCollectionActivity.a(this.a) > paramView.centerX()) {
        paramInt = 1;
      }
      int i = paramView.height() / 3;
      paramInt = (int)(ImageCollectionActivity.b(this.a) - paramView.top) / i * 2 + paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("ImageCollectionActivity", 2, "clickRecommendItem index:" + paramInt);
      }
    } while ((paramInt < 0) || (paramInt >= ImageCollectionActivity.a(this.a).size()));
    this.a.a((PublicAccountArticleObserver.RecommendItemInfo)ImageCollectionActivity.a(this.a).get(paramInt), paramInt + 1);
    return;
    ImageCollectionActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */