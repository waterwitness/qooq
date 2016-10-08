import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class iyc
  implements URLDrawable.URLDrawableListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final WeakReference b;
  
  public iyc(String paramString, ImageView paramImageView, ProgressBar paramProgressBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    this.b = new WeakReference(paramProgressBar);
  }
  
  private boolean a(ImageView paramImageView)
  {
    paramImageView = (String)paramImageView.getTag(2131296665);
    return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.b("LocationFaceAdapter", "onLoadCanceled,url:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ProgressBar localProgressBar = (ProgressBar)this.b.get();
    if ((paramURLDrawable != null) && (localProgressBar != null) && (a(paramURLDrawable)))
    {
      localProgressBar.setVisibility(4);
      paramURLDrawable.setTag(2131296666, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadCanceled error.");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("LocationFaceAdapter", "onLoadFialed,url:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramThrowable = (ProgressBar)this.b.get();
    if ((paramURLDrawable != null) && (paramThrowable != null) && (a(paramURLDrawable)))
    {
      paramThrowable.setVisibility(0);
      paramURLDrawable.setTag(2131296666, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadFialed error.");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    SLog.b("LocationFaceAdapter", "onLoadProgressed,url:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ProgressBar localProgressBar = (ProgressBar)this.b.get();
    if ((paramURLDrawable != null) && (localProgressBar != null) && (a(paramURLDrawable)))
    {
      localProgressBar.setVisibility(0);
      paramURLDrawable.setTag(2131296666, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadProgressed error.");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("LocationFaceAdapter", "onLoadSuccessed,url:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ProgressBar localProgressBar = (ProgressBar)this.b.get();
    if ((paramURLDrawable != null) && (localProgressBar != null) && (a(paramURLDrawable)))
    {
      localProgressBar.setVisibility(4);
      paramURLDrawable.setTag(2131296666, Boolean.valueOf(true));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadSuccessed error.");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */