import android.widget.ImageView;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilm
  implements URLDrawable.URLDrawableListener
{
  public ilm(BaseContentPagerView paramBaseContentPagerView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.a.post(new iln(this, paramURLDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */