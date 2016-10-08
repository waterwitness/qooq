import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.util.ArrayList;
import java.util.List;

public class jdd
  extends BizTroopObserver
{
  public jdd(TroopMemberApiService paramTroopMemberApiService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    Bundle localBundle = new Bundle();
    localBundle.putLong("ProgressTotal", ((TroopFileStatusInfo)paramObject).jdField_b_of_type_Long);
    localBundle.putLong("ProgressValue", ((TroopFileStatusInfo)paramObject).c);
    localBundle.putString("FileName", ((TroopFileStatusInfo)paramObject).g);
    localBundle.putString("LocalFile", ((TroopFileStatusInfo)paramObject).a);
    localBundle.putString("ThumbnailFile_Small", ((TroopFileStatusInfo)paramObject).jdField_b_of_type_JavaLangString);
    localBundle.putInt("Status", ((TroopFileStatusInfo)paramObject).jdField_b_of_type_Int);
    if ((((TroopFileStatusInfo)paramObject).jdField_b_of_type_Int == 8) || (((TroopFileStatusInfo)paramObject).jdField_b_of_type_Int == 11)) {
      this.a.a(56, localBundle);
    }
    while (TextUtils.isEmpty(((TroopFileStatusInfo)paramObject).jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.a.a(57, localBundle);
  }
  
  protected void a(String paramString, List paramList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 25);
    localBundle.putString("pageUrl", paramString);
    localBundle.putStringArrayList("lstVideoUrl", (ArrayList)paramList);
    localBundle.putInt("totalTime", paramInt);
    this.a.a(5, localBundle);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 36);
      localBundle.putBoolean("isSuccess", paramBoolean);
      localBundle.putSerializable("data", (Object[])paramObject);
      localBundle.putSerializable("observer_type", Integer.valueOf(4));
      this.a.a(3, localBundle);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 30);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", Boolean.valueOf(paramBoolean2));
    localBundle.putSerializable("observer_type", Integer.valueOf(4));
    this.a.a(3, localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */