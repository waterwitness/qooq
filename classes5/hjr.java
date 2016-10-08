import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hjr
  implements BusinessObserver
{
  public hjr(String paramString, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if (localObject == null) {}
    }
    label555:
    label586:
    label659:
    for (paramBundle = new mobileqq_dynamic_search.ResponseBody();; paramBundle = "-1")
    {
      try
      {
        paramBundle.mergeFrom((byte[])localObject);
        com.tencent.biz.lebasearch.SearchProtocol.a = paramBundle.search_id.get();
        localJSONArray1 = new JSONArray();
        if (paramBundle.item_groups.has())
        {
          Iterator localIterator1 = paramBundle.item_groups.get().iterator();
          if (!localIterator1.hasNext()) {
            break label586;
          }
          mobileqq_dynamic_search.ResultItemGroup localResultItemGroup = (mobileqq_dynamic_search.ResultItemGroup)localIterator1.next();
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("result_type", localResultItemGroup.group_mask.get());
          localJSONObject1.put("result_name", localResultItemGroup.group_name.get().toStringUtf8());
          localJSONObject1.put("total_count", localResultItemGroup.total_result_count.get());
          localJSONObject1.put("more_url", localResultItemGroup.more_url.get().toStringUtf8());
          localJSONObject1.put("more_name", localResultItemGroup.more_name.get().toStringUtf8());
          localJSONArray2 = new JSONArray();
          if (!localResultItemGroup.result_items.has()) {
            break label555;
          }
          Iterator localIterator2 = localResultItemGroup.result_items.get().iterator();
          while (localIterator2.hasNext())
          {
            paramBundle = (mobileqq_dynamic_search.ResultItem)localIterator2.next();
            try
            {
              if (!paramBundle.extension.has()) {
                continue;
              }
              JSONObject localJSONObject2 = new JSONObject(paramBundle.extension.get().toStringUtf8());
              if (paramBundle.jmp_url.has()) {
                localJSONObject2.put("jump_url", paramBundle.jmp_url.get().toStringUtf8());
              }
              if (paramBundle.name.has()) {
                localJSONObject2.put("name", paramBundle.name.get().toStringUtf8());
              }
              if (paramBundle.pic_url.has()) {
                localJSONObject2.put("pic_url", paramBundle.pic_url.get().toStringUtf8());
              }
              if (paramBundle.word.has()) {
                localJSONObject2.put("word", paramBundle.word.get().toStringUtf8());
              }
              localJSONObject2.put("keyword", this.jdField_a_of_type_JavaLangString);
              localJSONObject2.put("result_type", localResultItemGroup.group_mask.get());
              localJSONObject2.put("clickable", true);
              if (!paramBundle.result_id.has()) {
                break label659;
              }
              paramBundle = paramBundle.result_id.get().toStringUtf8();
              localObject = paramBundle;
              if (TextUtils.isEmpty(paramBundle)) {
                localObject = "-1";
              }
              localJSONObject2.put("result_id", localObject);
              localJSONArray2.put(localJSONObject2);
            }
            catch (JSONException paramBundle) {}
            if (QLog.isColorLevel()) {
              QLog.d("SearchProtocol", 2, paramBundle.getMessage());
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        for (;;)
        {
          JSONObject localJSONObject1;
          JSONArray localJSONArray2;
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
          paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramBundle.arg1 = -1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
          return;
          localJSONObject1.put("result_extension", localJSONArray2);
          localJSONArray1.put(localJSONObject1);
        }
      }
      catch (JSONException paramBundle)
      {
        JSONArray localJSONArray1;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
        }
        paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramBundle.arg1 = 0;
        paramBundle.obj = localJSONArray1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
        return;
      }
      catch (NullPointerException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
        }
      }
      paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramBundle.arg1 = -2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */