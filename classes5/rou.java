import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class rou
  implements View.OnClickListener
{
  rou(rot paramrot, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Rot.a.d = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Rot.a.b.get(this.jdField_a_of_type_Rot.a.d);
    if ((!FileUtil.a(paramView.d())) || (FileUtil.c(paramView.d())))
    {
      FileManagerUtil.d(paramView.d());
      this.jdField_a_of_type_Rot.a.b.remove(this.jdField_a_of_type_Rot.a.d);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Rot.a);
      return;
    }
    FMToastUtil.a(2131362771);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */