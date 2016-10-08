import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class rol
  implements AdapterView.OnItemClickListener
{
  public rol(LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.b.get(paramInt);
    if (paramAdapterView.a()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.d(), true);
    }
    while (!this.a.f()) {
      return;
    }
    if (FMDataCache.a(paramAdapterView)) {
      FMDataCache.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.k();
      LocalFileBrowserActivity.a(this.a);
      return;
      if (this.a.f) {
        FMDataCache.b();
      }
      FMDataCache.a(paramAdapterView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */