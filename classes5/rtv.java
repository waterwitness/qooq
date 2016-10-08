import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class rtv
  implements Runnable
{
  public rtv(QfileLocalFilePicTabView paramQfileLocalFilePicTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("手机相册", new ArrayList());
    localLinkedHashMap.put("已下载图片", new ArrayList());
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      Object localObject2 = localFileInfo.a();
      if ((localObject2 != null) && (((String)localObject2).length() != 0))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("QQfile_recv")) {}
      }
      else
      {
        localObject1 = "已下载图片";
      }
      localObject2 = localObject1;
      if (((String)localObject1).equalsIgnoreCase("camera") == true) {
        localObject2 = "手机相册";
      }
      if (!localLinkedHashMap.containsKey(localObject2)) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject2)).add(localFileInfo);
    }
    Object localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getSharedPreferences("LAST_CHOOSE_", 0);
    int i = ((SharedPreferences)localObject1).getInt("GROUP", -1);
    int j = ((SharedPreferences)localObject1).getInt("CHILD", -1);
    QfileLocalFilePicTabView.a(this.a, new rtw(this, localLinkedHashMap, i, j));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */