import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class rrq
  implements Runnable
{
  public rrq(QfileCloudFileTabView paramQfileCloudFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      String str = QfileTimeUtils.b(localWeiYunFileInfo.b);
      if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localWeiYunFileInfo);
    }
    this.a.j();
    this.a.setSelect(0);
    this.a.b(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */