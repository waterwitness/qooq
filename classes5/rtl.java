import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class rtl
  implements Runnable
{
  rtl(rtk paramrtk, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Rtk.a.a.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localList.size() != 0) {
        this.jdField_a_of_type_Rtk.a.a.put(str, localList);
      }
    }
    this.jdField_a_of_type_Rtk.a.j();
    this.jdField_a_of_type_Rtk.a.setSelect(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */