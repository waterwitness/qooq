import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.TaskListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AsyncJob;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.net.URL;

public class irg
  extends AsyncJob
{
  public irg(Task paramTask, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Task.Result a(URLDrawable... paramVarArgs)
  {
    Task.Result localResult = new Task.Result();
    localResult.jdField_a_of_type_ComTencentImageURLDrawable = paramVarArgs[0];
    Object localObject;
    if (paramVarArgs[0].getURL().toString().startsWith("file://"))
    {
      String str = paramVarArgs[0].getURL().toString().replaceFirst("file://", "");
      localObject = str;
      if (str.endsWith("/120")) {
        localObject = str.substring(0, str.length() - 4);
      }
      localObject = StoryListUtils.a((String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.h, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.i);
    }
    while (localObject == null)
    {
      SLog.e("Q.qqstory.home.Task", "bitmap is null! reqHeight:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.i + ",reqWidth:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.h + " ,url=" + paramVarArgs[0].getURL().toString());
      return localResult;
      if (paramVarArgs[0].getURL().toString().startsWith("file:")) {
        localObject = StoryListUtils.a(paramVarArgs[0].getURL().toString().replaceFirst("file:", ""), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.h, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.i);
      } else {
        localObject = StoryListUtils.a(paramVarArgs[0].getCurrDrawable(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.h, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.i);
      }
    }
    if (((Bitmap)localObject).isRecycled())
    {
      SLog.e("Q.qqstory.home.Task", "bitmap have been recycled! url=" + paramVarArgs[0].getURL().toString());
      return localResult;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation.a((Bitmap)localObject);
    if ((paramVarArgs != null) && (!paramVarArgs.isRecycled()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      localResult.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(((ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), paramVarArgs);
    }
    return localResult;
  }
  
  public void a(Task.Result paramResult)
  {
    SLog.b("Q.qqstory.home.Task", "task finish state = " + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.k);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.k == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangInteger, this.jdField_a_of_type_ComTencentImageURLDrawable, new Throwable("ImageView have been recyle!"));
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get(), paramResult.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.k = 5;
    if ((paramResult.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangInteger, paramResult.jdField_a_of_type_ComTencentImageURLDrawable, new Throwable("bitmap out of memory or local bitmap have been deleted"));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.jdField_a_of_type_JavaLangRefWeakReference.get(), paramResult.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */