import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.HashMap;

public class skg
  implements TabBarView.OnTabChangeListener
{
  public skg(QfileTabBarView paramQfileTabBarView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.a(paramInt2) == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(true);
      this.a.b(paramInt2);
    } while (!this.a.jdField_a_of_type_Boolean);
    try
    {
      SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_view", ((Integer)this.a.c.get(Integer.valueOf(paramInt2))).intValue());
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */