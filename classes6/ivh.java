import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryImagePlayerModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class ivh
  extends SimpleObserver
{
  public ivh(NewStoryImagePlayerModule paramNewStoryImagePlayerModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    if (paramBitmap != null)
    {
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        SLog.b("Q.qqstory.record.NewStoryImagePlayerListener", "blur current frame success");
      }
    }
    else {
      return;
    }
    SLog.d("Q.qqstory.record.NewStoryImagePlayerListener", "finish blur current frame but play-cover-view is not visible");
  }
  
  public void onError(Error paramError)
  {
    super.onError(paramError);
    SLog.d("Q.qqstory.record.NewStoryImagePlayerListener", "blur the current frame error : " + paramError);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */