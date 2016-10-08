import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rrp
  extends FMObserver
{
  public rrp(QfileCloudFileTabView paramQfileCloudFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.b(false);
  }
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.a, true);
    QfileCloudFileTabView.c(this.a, paramBoolean);
    this.a.g = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (FileManagerUtil.a(localWeiYunFileInfo.jdField_b_of_type_JavaLangString) == 0)
      {
        String str = QfileCloudFileTabView.a(this.a).a().a(localWeiYunFileInfo.a, localWeiYunFileInfo.jdField_b_of_type_JavaLangString, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.g = str;
        }
      }
    }
    if (!paramString.equals(this.a.jdField_b_of_type_JavaLangString)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.a)) {
      this.a.a.clear();
    }
    this.a.a.addAll(paramList);
    if (!this.a.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    this.a.jdField_b_of_type_Long = paramLong;
    this.a.d = true;
    this.a.h();
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */