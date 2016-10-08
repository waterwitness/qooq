import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewReport;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;

public class seo
  implements IFileViewListener
{
  public seo(FileBrowserActivity paramFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.a.b().getHeight();
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.a.b) {
      return;
    }
    this.a.b = paramInt;
    this.a.d();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    View localView = this.a.findViewById(2131301015);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      localView.setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
      {
        int i = this.a.getResources().getColor(2131428295);
        this.a.mSystemBarComp.a(i);
        this.a.mSystemBarComp.b(i);
      }
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager == null)
    {
      return;
      localView.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
      {
        this.a.mSystemBarComp.a(-16777216);
        this.a.mSystemBarComp.b(-16777216);
      }
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.b();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.a();
  }
  
  public void b()
  {
    this.a.a(true);
  }
  
  public void b(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (!this.a.c()) {
      return;
    }
    Object localObject = this.a;
    ((FileBrowserActivity)localObject).b -= 1;
    localObject = this.a.a();
    ((IFileViewerAdapter)localObject).d(paramBoolean);
    if (this.a.b > 0)
    {
      paramBoolean = true;
      if (this.a.b >= this.a.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label143;
      }
    }
    for (;;)
    {
      ((IFileViewerAdapter)localObject).e(paramBoolean);
      ((IFileViewerAdapter)localObject).f(bool);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.a.a());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
      this.a.d();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      return;
      paramBoolean = false;
      break;
      label143:
      bool = false;
    }
  }
  
  public void c()
  {
    FileViewMusicService.a().a(this.a.jdField_a_of_type_JavaUtilList, this.a.b);
    MqqHandler localMqqHandler = this.a.app.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134026, null).sendToTarget();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!this.a.d()) {
      return;
    }
    Object localObject = this.a;
    ((FileBrowserActivity)localObject).b += 1;
    localObject = this.a.a();
    boolean bool1;
    if (this.a.b > 0)
    {
      bool1 = true;
      if (this.a.b >= this.a.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label139;
      }
    }
    for (;;)
    {
      ((IFileViewerAdapter)localObject).e(bool1);
      ((IFileViewerAdapter)localObject).f(bool2);
      ((IFileViewerAdapter)localObject).d(paramBoolean);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a((IFileViewerAdapter)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
      this.a.d();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      return;
      bool1 = false;
      break;
      label139:
      bool2 = false;
    }
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.a.findViewById(2131297139);
    if (paramBoolean)
    {
      FileManagerUtil.a(this.a, localTextView);
      return;
    }
    FileManagerUtil.a(localTextView);
  }
  
  public void e()
  {
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\seo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */