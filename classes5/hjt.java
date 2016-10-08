import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public final class hjt
  implements BusinessObserver
{
  public hjt(SharedPreferences paramSharedPreferences, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    ArrayList localArrayList;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_dynamic_search.ResponseBody();
        try
        {
          ((mobileqq_dynamic_search.ResponseBody)localObject).mergeFrom(paramBundle);
          if ((((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.has()) && (((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.has()))
          {
            paramBundle = ((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.get();
            localArrayList = new ArrayList();
            Iterator localIterator = paramBundle.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localResultItem = (mobileqq_dynamic_search.ResultItem)localIterator.next();
              localWordItem = new SearchProtocol.WordItem();
            } while (!localResultItem.word.has());
            localWordItem.word = localResultItem.word.get().toStringUtf8();
            localWordItem.id = localResultItem.result_id.get().toStringUtf8();
            if (localResultItem.extension.has())
            {
              localObject = localResultItem.extension.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("SearchProtocol", 2, "extension info:" + (String)localObject);
              }
              paramBoolean = TextUtils.isEmpty((CharSequence)localObject);
              if (!paramBoolean) {
                paramBundle = null;
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          mobileqq_dynamic_search.ResultItem localResultItem;
          SearchProtocol.WordItem localWordItem;
          label255:
          label261:
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
        }
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      paramBundle = (Bundle)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      break label255;
      paramInt = paramBundle.optInt("type");
      break label261;
    }
    if (paramBundle == null)
    {
      paramInt = 0;
      if ((paramInt == 2) && (localResultItem.jmp_url.has()) && (!TextUtils.isEmpty(localResultItem.jmp_url.get().toStringUtf8())))
      {
        localWordItem.type = paramInt;
        localWordItem.jumpUrl = localResultItem.jmp_url.get().toStringUtf8();
        paramInt = SearchProtocol.a(paramBundle.optString("color"));
        if (paramInt == 0) {
          break label478;
        }
      }
    }
    for (;;)
    {
      localWordItem.textColor = paramInt;
      localArrayList.add(localWordItem);
      break;
      paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localObject = SearchProtocol.a(this.jdField_a_of_type_AndroidContentSharedPreferences);
      if (((List)localObject).size() > 0)
      {
        paramBundle.arg1 = 0;
        paramBundle.obj = localObject;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
        return;
        SearchProtocol.a(this.jdField_a_of_type_AndroidContentSharedPreferences, localArrayList);
        paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramBundle.arg1 = 0;
        paramBundle.obj = localArrayList;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
        return;
        paramBundle.arg1 = -1;
      }
      label478:
      paramInt = -16734752;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */