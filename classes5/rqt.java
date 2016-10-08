import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rqt
  implements View.OnClickListener
{
  public rqt(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
    {
      paramView = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      i = paramView.c;
      paramView = (WeiYunFileInfo)paramView.a;
    }
    for (;;)
    {
      this.a.a(paramView, i);
      do
      {
        return;
      } while (!(localObject instanceof ImageHolder));
      paramView = (WeiYunFileInfo)((ImageHolder)paramView.getTag()).a;
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */