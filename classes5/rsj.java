import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rsj
  implements View.OnClickListener
{
  public rsj(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)paramView.a;
    switch (paramView.c)
    {
    }
    for (;;)
    {
      this.a.j();
      return;
      this.a.a.a().ac();
      this.a.c(localFileInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */