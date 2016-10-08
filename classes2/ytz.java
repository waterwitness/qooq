import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ytz
  implements Runnable
{
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public ytz(TroopHWJsPlugin paramTroopHWJsPlugin, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramHashMap.clone());
  }
  
  public void run()
  {
    Object localObject1 = new File(TroopHWJsPlugin.e);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        try
        {
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.f, new String[] { this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(i, 1, "select", null, -1).toString() });
          localObject2 = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(i, (String)localObject2, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.p);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label192;
          }
          TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(0);
        }
        continue;
        label192:
        this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localException);
        ((HashMap)localObject1).put(Integer.valueOf(i), localException);
      }
      else
      {
        TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(3);
      }
    }
    ThreadManager.a(new yua(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, 1, (HashMap)localObject1), null, false);
    ((HashMap)localObject1).clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */