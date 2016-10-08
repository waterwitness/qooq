import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class rut
  implements View.OnClickListener
{
  public rut(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
    paramView = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).jdField_a_of_type_JavaLangObject;
    if (5 != paramView.cloudType) {
      FileManagerUtil.c(paramView);
    }
    switch (((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.j();
      return;
      this.a.a.a().ad();
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131362941);
        return;
      }
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(this.a.getContext(), 2131362855, 2131362854, new ruu(this, paramView));
      }
      else if (paramView.getCloudType() == 0)
      {
        QfileBaseRecentFileTabView.t(this.a).a().a(paramView.nSessionId);
      }
      else
      {
        ArrayList localArrayList;
        if (paramView.getCloudType() == 6)
        {
          localObject = (DataLineHandler)QfileBaseRecentFileTabView.u(this.a).a(8);
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(paramView.uniseq));
          if (!((DataLineHandler)localObject).a(localArrayList)) {
            FMToastUtil.a(2131362942);
          }
        }
        else
        {
          QfileBaseRecentFileTabView.v(this.a).a().b(paramView);
          continue;
          this.a.a.a().ac();
          this.a.c(paramView);
          continue;
          this.a.a.a().ae();
          if (paramView.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).a().a(paramView.nSessionId);
          }
          else if (paramView.getCloudType() == 6)
          {
            ((DataLineHandler)QfileBaseRecentFileTabView.x(this.a).a(8)).a(0, paramView.uniseq, false);
          }
          else
          {
            QfileBaseRecentFileTabView.y(this.a).a().a(paramView.nSessionId);
            continue;
            this.a.a.a().af();
            if (!NetworkUtil.e(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131362941);
              return;
            }
            if (FileManagerUtil.a())
            {
              localObject = this.a.getContext();
              if (paramView.nOpType == 0) {}
              for (int i = 2131362851;; i = 2131362852)
              {
                FMDialogUtil.a((Context)localObject, 2131362855, i, new ruv(this, paramView));
                break;
              }
            }
            if (paramView.getCloudType() == 0)
            {
              QfileBaseRecentFileTabView.C(this.a).a().b(paramView.nSessionId);
            }
            else if (paramView.getCloudType() == 6)
            {
              localObject = (DataLineHandler)QfileBaseRecentFileTabView.D(this.a).a(8);
              localArrayList = new ArrayList();
              localArrayList.add(Long.valueOf(paramView.uniseq));
              if (!((DataLineHandler)localObject).a(localArrayList)) {
                FMToastUtil.a(2131362942);
              }
            }
            else
            {
              QfileBaseRecentFileTabView.E(this.a).a().a(paramView.nSessionId);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */