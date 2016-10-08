import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ImageCollectionGallery.OnOverScrollListener;

public class hvi
  implements ImageCollectionGallery.OnOverScrollListener
{
  public hvi(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ImageCollectionActivity", 4, "onOverScrollLeft:" + paramInt);
    }
    if (paramInt > AIOUtils.a(50.0F, this.a.getResources())) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */