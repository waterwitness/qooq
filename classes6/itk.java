import android.os.SystemClock;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class itk
  implements FFmpegExecuteResponseCallback
{
  public long a;
  public String a;
  public WeakReference a;
  public long b;
  public long c;
  
  public itk(IMyStoryListView paramIMyStoryListView, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIMyStoryListView);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    FileUtils.a(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
    IMyStoryListView localIMyStoryListView = (IMyStoryListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localIMyStoryListView != null)
    {
      localIMyStoryListView.b(true);
      QQToast.a(BaseApplication.getContext(), 2, "已保存到本地相册", 0).a();
    }
    if (QLog.isColorLevel()) {
      QLog.w("FFmepg", 2, "我的日迹下载成功 \n" + paramString);
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    StoryReportor.a("mystory", "suc_download", 0, 0, new String[] { "1" });
    StoryReportor.a("home_page", "download_mystory", 0, 0, new String[0]);
    StoryReportor.a("home_page", "download_mystory_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(this.b), String.valueOf(this.c) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    IMyStoryListView localIMyStoryListView = (IMyStoryListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localIMyStoryListView != null)
    {
      localIMyStoryListView.b(false);
      QQToast.a(BaseApplication.getContext(), 1, "保存失败，请稍后重试", 0).a();
    }
    if (QLog.isColorLevel()) {
      QLog.w("FFmepg", 2, "我的日迹下载失败 \n" + paramString);
    }
    StoryReportor.a("home_page", "download_mystory", 0, 1, new String[0]);
  }
  
  public void c(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */