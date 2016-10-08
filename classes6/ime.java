import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ime
  implements URLDrawable.URLDrawableListener
{
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public ime(DiscoverItem paramDiscoverItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("Q.qqstory.pgc", 2, "onLoadCanceled" + paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("Q.qqstory.pgc", 2, "onLoadFialed" + paramURLDrawable + "  throwable" + paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.d("Q.qqstory.pgc", 2, "onLoadProgressed" + paramURLDrawable + " progress:" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("Q.qqstory.pgc", 2, "onLoadSuccessed" + paramURLDrawable.getURL());
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.a.post(new imf(this, paramURLDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */