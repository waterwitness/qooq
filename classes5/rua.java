import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rua
  implements Runnable
{
  public rua(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB thread start");
    }
    if ((this.a.b != null) && (this.a.b.trim().length() != 0)) {}
    for (List localList = QfileBaseRecentFileTabView.a(this.a).a().a(this.a.b);; localList = QfileBaseRecentFileTabView.b(this.a).a().a())
    {
      if (localList != null) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      if (QLog.isColorLevel()) {
        QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB end size[" + this.a.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      this.a.d();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */