import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class rtk
  implements Runnable
{
  public rtk(QfileLocalFileDocTabView paramQfileLocalFileDocTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(FMSettings.a().b(), ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
    Object localObject1 = FMSettings.a().a();
    if (localObject1 != null) {
      FileCategoryUtil.a((String)localObject1, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
    }
    localObject1 = new HashMap();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      String str = this.a.a((String)localObject2);
      localObject2 = (List)localHashMap.get(localObject2);
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(str)).addAll((Collection)localObject2);
    }
    FileCategoryUtil.a((Map)localObject1);
    QfileLocalFileDocTabView.a(this.a, new rtl(this, (HashMap)localObject1));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */