import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class rqr
  implements View.OnClickListener
{
  rqr(rqq paramrqq, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof ImageHolder))
    {
      paramView = (WeiYunFileInfo)((ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((FMDataCache.a(paramView.a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.a, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.c(this.jdField_a_of_type_Rqq.a).a().a(paramView);
      this.jdField_a_of_type_Rqq.a.d();
    }
    do
    {
      return;
      if ((paramView instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
      {
        paramView = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileBaseCloudFileTabView.a, 2, "unknow Object");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */