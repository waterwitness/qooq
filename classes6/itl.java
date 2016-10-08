import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class itl
  implements FFmpegExecuteResponseCallback
{
  public String a;
  public WeakReference a;
  
  public itl(IMyStoryListView paramIMyStoryListView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIMyStoryListView);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FFmepg", 2, "单视频水印合成成功 \n" + paramString);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    IMyStoryListView localIMyStoryListView = (IMyStoryListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localIMyStoryListView != null)
    {
      localIMyStoryListView.b(false);
      QQToast.a(BaseApplication.getContext(), 1, "我的日迹下载失败", 0).a();
    }
    if (QLog.isColorLevel()) {
      QLog.w("FFmepg", 2, "单视频水印合成失败 \n" + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */