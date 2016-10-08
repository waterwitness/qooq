import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.view.PictureCoverView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imj
  implements URLDrawable.URLDrawableListener
{
  public imj(PictureCoverView paramPictureCoverView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StoryReportor.a("play_page_title", "suc", ((QQStoryContentActivity)this.a.getContext()).g, this.a.a.contentType, new String[] { this.a.a.getUnionId(), this.a.a.storyId, "2", StoryReportor.a(this.a.getContext()) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */