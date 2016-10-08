import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task.TaskListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class irm
  extends irc
{
  public irm(Task paramTask, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    super(paramImageView, paramString, paramInt1, paramInt2, paramTransformation);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    SLog.e("Q.qqstory.home.Task", "bitmap have been recyle after transformation!url=" + paramString);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.a.jdField_a_of_type_JavaLangInteger, this.a.jdField_a_of_type_ComTencentImageURLDrawable, new Throwable("bitmap have been recycled!"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */