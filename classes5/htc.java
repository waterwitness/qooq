import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class htc
  implements URLDrawable.URLDrawableListener
{
  public htc(VideoUIController paramVideoUIController, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      VideoUIController.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */