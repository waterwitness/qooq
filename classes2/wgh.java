import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;
import java.util.Collections;

public class wgh
  extends VipFunCallObserver
{
  public wgh(VipFunCallPreviewActivity paramVipFunCallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList);
    this.a.d = this.a.jdField_a_of_type_JavaUtilArrayList.toString();
    this.a.a(false, 0);
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    int j;
    Object localObject2;
    String str;
    Object localObject1;
    if (!paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      i = ((Bundle)paramObject).getInt("result");
      j = ((Bundle)paramObject).getInt("callId", this.a.jdField_a_of_type_Int);
      localObject2 = ((Bundle)paramObject).getString("message");
      str = ((Bundle)paramObject).getString("svr_url");
      paramObject = ((Bundle)paramObject).getString("svr_actStr");
      if ((i != 1005011) && (i != 5002)) {
        break label276;
      }
      paramInt = 2;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "你选择的来电动画为超级会员专享，开通即可使用此来电动画";
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)paramObject)) {
        break label421;
      }
      localObject2 = null;
      paramObject = "立即开通";
      paramInt = 2;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        if ((i == 22001) || (i == 6002))
        {
          localObject1 = "未参加活动";
          label212:
          VipFunCallPreviewActivity localVipFunCallPreviewActivity = this.a;
          localObject3 = paramObject;
          if (!TextUtils.isEmpty(str))
          {
            localObject3 = paramObject;
            if (TextUtils.isEmpty((CharSequence)paramObject)) {
              localObject3 = "了解详情";
            }
          }
          localVipFunCallPreviewActivity.a(paramInt, j, null, (String)localObject1, (String)localObject2, (String)localObject3, str);
          this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
          return;
          label276:
          if ((i == 1005012) || (i == 4002))
          {
            paramInt = 1;
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "你选择的来电动画为QQ会员专享，开通即可使用此来电动画";
            }
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)paramObject)) {
              break label421;
            }
            localObject2 = null;
            paramObject = "立即开通";
            paramInt = 1;
            continue;
          }
          if (i == 461001)
          {
            if (!TextUtils.isEmpty((CharSequence)paramObject)) {
              break label418;
            }
            paramObject = "立即开通";
          }
        }
      }
      label418:
      for (;;)
      {
        localObject2 = "确定";
        str = IndividuationUrlHelper.a("funCallMine");
        paramInt = 6;
        localObject1 = "指定来电群组已达上限（5个）请在“我的来电”里删除其他来电群组后再添加新的分组。";
        break;
        localObject3 = null;
        paramInt = 4;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        if (i == 3002)
        {
          localObject1 = "已过试用期";
          break label212;
        }
        if (i == 8002)
        {
          localObject1 = "未开通专区会员";
          break label212;
        }
        break label212;
      }
      label421:
      Object localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */