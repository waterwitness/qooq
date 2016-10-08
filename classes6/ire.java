import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.TaskListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ire
  extends irc
{
  public ire(Task paramTask, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation, Drawable paramDrawable)
  {
    super(paramImageView, paramString, paramInt1, paramInt2, paramTransformation);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    SLog.b("Q.qqstory.home.Task", "startLoadImageFromLocale success :" + paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask.a.a(paramImageView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */