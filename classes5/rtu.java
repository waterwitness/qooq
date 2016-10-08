import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class rtu
  implements Runnable
{
  public rtu(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = (HashMap)FileCategoryUtil.a(this.jdField_a_of_type_AndroidContentContext);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      FileCategoryUtil.a(FMSettings.a().b(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      Object localObject1 = FMSettings.a().a();
      if (localObject1 != null) {
        FileCategoryUtil.a((String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      }
      FileCategoryUtil.a(localHashMap);
      if (localHashMap != null)
      {
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if ("QQfile_recv".equalsIgnoreCase((String)localObject2) != true)
          {
            localObject2 = (List)localHashMap.get(localObject2);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.addAll((Collection)localObject2);
          }
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */