import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class rtn
  implements Runnable
{
  public rtn(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, int paramInt, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap;
    Iterator localIterator;
    String str;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      localMap = FileCategoryUtil.c(this.jdField_a_of_type_AndroidContentContext);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("QQfile_recv") != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_Int & 0x2) > 0)
    {
      localMap = FileCategoryUtil.b(this.jdField_a_of_type_AndroidContentContext);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("QQfile_recv") != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */