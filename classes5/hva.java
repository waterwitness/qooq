import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hva
  implements Runnable
{
  public hva(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (ImageCollectionActivity.b(this.a)) {
      i = 1;
    }
    ImageCollectionActivity.a(this.a).a(ImageCollectionActivity.b(this.a), ImageCollectionActivity.f(this.a), i);
    ImageCollectionActivity.f(this.a, "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */