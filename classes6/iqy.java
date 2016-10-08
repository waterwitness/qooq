import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Task;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqy
  extends irc
{
  public iqy(ImageLoader paramImageLoader, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    super(paramImageView, paramString, paramInt1, paramInt2, paramTransformation);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    if (paramImageView == null)
    {
      SLog.b("Q.qqstory:ImageLoader", "run ImageLoader into:" + paramString + " ,target view was recyle!");
      return;
    }
    SLog.b("Q.qqstory:ImageLoader", "run ImageLoader into:" + paramString + " ,reqWidth=" + paramInt1 + ",reqHeight=" + paramInt2);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
    }
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    paramString = new Task(paramImageView, (URLDrawable)localObject, paramInt1, paramInt2, paramString);
    paramString.a(paramTransformation);
    if ((paramTransformation instanceof CircleTransformation))
    {
      paramString.a(paramImageView.getContext().getResources().getDrawable(2130841377));
      paramString.a(this.a);
      paramString.a(this.a.a);
      ((URLDrawable)localObject).setURLDrawableListener(paramString);
      if ((paramTransformation == null) || (!(paramTransformation instanceof CircleTransformation))) {
        break label244;
      }
      paramString.a(paramImageView.getResources().getDrawable(2130841377));
    }
    for (;;)
    {
      this.a.a(paramString);
      return;
      if (!(paramTransformation instanceof RoundedTransformation)) {
        break;
      }
      paramString.a(paramImageView.getContext().getResources().getDrawable(2130841392));
      break;
      label244:
      if ((paramTransformation != null) && ((paramTransformation instanceof RoundedTransformation))) {
        paramString.a(paramImageView.getResources().getDrawable(2130841392));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */