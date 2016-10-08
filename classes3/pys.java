import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.OnVListUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pys
  implements Runnable
{
  public pys(HotChatManager paramHotChatManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isUinInVList,init");
    }
    Object localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir() + File.separator + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_nearby_hotchat_v_list");
    try
    {
      localObject1 = FileUtils.b((File)localObject1);
      this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (localObject1 == null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("vusers");
        if (localObject1 != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            str2 = ((JSONArray)localObject1).optString(i);
            if (!TextUtils.isEmpty(str2)) {
              this.a.jdField_a_of_type_JavaUtilList.add(str2);
            }
            i += 1;
            continue;
            localIOException = localIOException;
            if (QLog.isColorLevel()) {
              QLog.i("HotChatManager", 2, "isUinInVList, readFile exception:" + localIOException.getMessage());
            }
            localIOException.printStackTrace();
            Object localObject2 = null;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          String str1 = str2;
        }
      }
      this.a.c = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */