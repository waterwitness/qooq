import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public abstract class irc
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Transformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public irc(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation = paramTransformation;
  }
  
  public abstract void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation);
  
  public void run()
  {
    a((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */