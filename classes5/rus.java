import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rus
  implements View.OnClickListener
{
  public rus(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    FileManagerEntity localFileManagerEntity = null;
    if ((localObject instanceof QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)) {
      localFileManagerEntity = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    }
    for (;;)
    {
      this.a.c(localFileManagerEntity);
      return;
      if ((localObject instanceof ImageHolder)) {
        localFileManagerEntity = (FileManagerEntity)((ImageHolder)paramView.getTag()).a;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */