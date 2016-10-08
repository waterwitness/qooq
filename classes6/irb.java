import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageHashMap;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class irb
  extends irc
{
  public irb(ImageLoader paramImageLoader, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    super(paramImageView, paramString, paramInt1, paramInt2, paramTransformation);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    paramString = this.a.b.a(paramImageView);
    if ((paramString != null) && (paramString.a() != 1))
    {
      paramString.a();
      return;
    }
    this.a.b.b(paramImageView);
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */