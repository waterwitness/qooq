import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.TaskListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class irf
  implements Runnable
{
  public irf(Task paramTask, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangInteger, this.jdField_a_of_type_ComTencentImageURLDrawable, new Throwable("ImageView have been recyle!"));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */