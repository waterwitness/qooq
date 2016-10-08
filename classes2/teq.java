import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class teq
  implements Runnable
{
  public teq(EmoticonManager paramEmoticonManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TAG", 2, "EmoticonKeyword IO:" + ClubContentJsonTask.f.b);
        }
        JSONObject localJSONObject = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.f, false);
        if (localJSONObject == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localJSONObject = localJSONObject.getJSONObject("keywords");
        JSONArray localJSONArray1 = localJSONObject.names();
        int j = localJSONArray1.length();
        localSparseArrayCompat = new SparseArrayCompat(j);
        if (i < j)
        {
          String str = localJSONArray1.getString(i);
          if ((str == null) || (str.length() < 2)) {
            break label209;
          }
          JSONArray localJSONArray2 = localJSONObject.getJSONArray(str);
          localSparseArrayCompat.put(str.toUpperCase().hashCode(), Integer.valueOf(localJSONArray2.getInt(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_Int)));
        }
      }
      catch (JSONException localJSONException)
      {
        SparseArrayCompat localSparseArrayCompat;
        if (QLog.isColorLevel())
        {
          QLog.e("EmoticonManager", 2, "云联想 json parse error", localJSONException);
          return;
          new Handler(Looper.getMainLooper()).post(new ter(this, localSparseArrayCompat));
        }
        return;
      }
      label209:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\teq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */