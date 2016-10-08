import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileView;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class kws
  implements View.OnClickListener
{
  public kws(ChatHistoryFileView paramChatHistoryFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
    paramView = (FileManagerEntity)((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).jdField_a_of_type_JavaLangObject;
    if (5 != paramView.cloudType) {
      FileManagerUtil.c(paramView);
    }
    switch (((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131362941);
        return;
      }
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 2131362855, 2131362854, new kwt(this, paramView));
      }
      else if (paramView.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
      }
      else
      {
        ArrayList localArrayList;
        if (paramView.getCloudType() == 6)
        {
          localObject = (DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(paramView.uniseq));
          if (!((DataLineHandler)localObject).a(localArrayList)) {
            FMToastUtil.a(2131362942);
          }
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView);
          continue;
          this.a.a(paramView);
          continue;
          if (paramView.getCloudType() == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
          }
          else if (paramView.getCloudType() == 6)
          {
            ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, paramView.uniseq, false);
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
            continue;
            if (!NetworkUtil.e(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131362941);
              return;
            }
            if (FileManagerUtil.a())
            {
              localObject = this.a.jdField_a_of_type_AndroidContentContext;
              if (paramView.nOpType == 0) {}
              for (int i = 2131362851;; i = 2131362852)
              {
                FMDialogUtil.a((Context)localObject, 2131362855, i, new kwu(this, paramView));
                break;
              }
            }
            if (paramView.getCloudType() == 0)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.nSessionId);
            }
            else if (paramView.getCloudType() == 6)
            {
              localObject = (DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
              localArrayList = new ArrayList();
              localArrayList.add(Long.valueOf(paramView.uniseq));
              if (!((DataLineHandler)localObject).a(localArrayList)) {
                FMToastUtil.a(2131362942);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */