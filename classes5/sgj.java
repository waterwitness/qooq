import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class sgj
  implements PreviewingOfflineFileViewBase.IControllProxyInterface
{
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public sgj(PreviewingOfflineFileView paramPreviewingOfflineFileView, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (this.jdField_a_of_type_JavaLangString = paramString1;; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      this.jdField_b_of_type_JavaLangString = paramString3;
      this.c = paramString4;
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public int a()
  {
    if (3000 == PreviewingOfflineFileView.m(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).c()) {
      return 2;
    }
    if ((PreviewingOfflineFileView.n(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).f() != null) && (PreviewingOfflineFileView.o(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).f().length() > 0)) {
      return 4;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
      PreviewingOfflineFileView.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).getString(2131362941);
    }
    label217:
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        this.jdField_b_of_type_Int = Integer.parseInt(FMConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext(), PreviewingOfflineFileView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).a(), "FileType"));
        if ((1 != PreviewingOfflineFileView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).d()) && (!FileManagerUtil.a(PreviewingOfflineFileView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView)))) {
          break label217;
        }
        if (!TextUtils.isEmpty(PreviewingOfflineFileView.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).e())) {
          break;
        }
        PreviewingOfflineFileView.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).getString(2131362811);
        localFileManagerEntity = PreviewingOfflineFileView.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).a();
      } while (localFileManagerEntity == null);
      localFileManagerEntity.status = 16;
      return;
      if (3000 == PreviewingOfflineFileView.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).c())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(PreviewingOfflineFileView.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).i(), PreviewingOfflineFileView.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).e());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(PreviewingOfflineFileView.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).e());
      return;
    } while ((PreviewingOfflineFileView.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).f() == null) || (PreviewingOfflineFileView.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).f().length() <= 0));
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileView<FileAssistant>", 2, "sendPreviewRequest for weiyun file");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(PreviewingOfflineFileView.l(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).f());
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  public String c()
  {
    String str = FMConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext(), PreviewingOfflineFileView.p(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).a(), "InterfacePage");
    return "http://" + this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int + "/ftn_doc_previewer/" + str;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new sgk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public String d()
  {
    return "javascript:init('" + this.jdField_a_of_type_JavaLangString + "','" + this.jdField_a_of_type_Int + "','" + this.jdField_b_of_type_JavaLangString + "','" + this.jdField_b_of_type_Int + "')";
  }
  
  public String e()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("domain", this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put("fileType", Integer.valueOf(this.jdField_b_of_type_Int));
    ((Map)localObject).put("port", Integer.valueOf(this.jdField_a_of_type_Int));
    ((Map)localObject).put("downloadkey", this.jdField_b_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.c)) {
      ((Map)localObject).put("cookie", this.c);
    }
    localObject = "javascript:qpreview.onClientResponse('init'," + FileManagerUtil.a((Map)localObject) + ")";
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileView<FileAssistant>", 2, "getInitString:" + (String)localObject);
    }
    return (String)localObject;
  }
  
  public String f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileView<FileAssistant>", 2, "getAddMoreString:" + "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
    return "javascript:qpreview.onClientResponse('addMorePage',{})";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */