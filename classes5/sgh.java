import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class sgh
  implements AdapterView.OnItemSelectedListener
{
  public sgh(PhotoFileViewBase paramPhotoFileViewBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PhotoFileViewBase.a(this.a, paramInt);
    if (PhotoFileViewBase.a(this.a) != null) {
      PhotoFileViewBase.b(this.a).a(paramInt);
    }
    paramAdapterView = (IFileViewerAdapter)PhotoFileViewBase.a(this.a).getItem(paramInt);
    if ((paramAdapterView != null) && (FileManagerUtil.a(paramAdapterView.a())) && (1 == paramAdapterView.a().getCloudType())) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131362871));
    }
    this.a.a().a(paramAdapterView);
    if ((paramAdapterView != null) && (paramAdapterView.h() == null)) {
      paramAdapterView.a(1);
    }
    PhotoFileViewBase.a(this.a).notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */