import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.TaskListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class irk
  implements Runnable
{
  public irk(Task paramTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((ImageView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setImageDrawable(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.a.jdField_a_of_type_JavaLangInteger, this.a.jdField_a_of_type_ComTencentImageURLDrawable, new Throwable("bitmap have been recycled!"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */