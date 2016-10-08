import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.troop.TroopManageCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class jdc
  extends TroopObserver
{
  public jdc(TroopMemberApiService paramTroopMemberApiService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Boolean paramBoolean)
  {
    ArrayList localArrayList;
    if ((paramBoolean.booleanValue()) && (this.a.a))
    {
      paramBoolean = (TroopAppMgr)TroopMemberApiService.a(this.a).getManager(108);
      localArrayList = new ArrayList();
      if (paramBoolean != null)
      {
        localObject = paramBoolean.a(false);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label146;
        }
        localObject = ((List)localObject).iterator();
        TroopAIOAppInfo localTroopAIOAppInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
          localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
        } while (localTroopAIOAppInfo.appid != this.a.an);
        QQToast.a(BaseApplication.getContext(), 2, 2131367459, 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
      }
    }
    return;
    label146:
    localArrayList.add(Integer.valueOf(this.a.an));
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(this.a.an));
    paramBoolean.a(localArrayList, (ArrayList)localObject);
  }
  
  protected void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 52);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, localBundle);
  }
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    paramList = new Bundle();
    paramList.putInt("type", 4);
    paramList.putBoolean("isSuccess", paramBoolean);
    paramList.putSerializable("data", new Object[] { paramString });
    paramList.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, paramList);
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 84);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("appid", paramInt1);
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putInt("seq", paramInt2);
    localBundle.putInt("retCode", paramInt3);
    localBundle.putString("uin", paramString3);
    if ((paramAllInOne != null) && ((!TextUtils.isEmpty(paramAllInOne.h)) || (!TextUtils.isEmpty(paramAllInOne.i))))
    {
      paramBoolean = true;
      localBundle.putBoolean("isFriend", paramBoolean);
      if (paramAllInOne != null) {
        break label164;
      }
      paramString1 = "";
      label123:
      localBundle.putString("nickName", paramString1);
      if (paramAllInOne != null) {
        break label173;
      }
    }
    label164:
    label173:
    for (paramString1 = "";; paramString1 = paramAllInOne.i)
    {
      localBundle.putString("remark", paramString1);
      this.a.a(60, localBundle);
      return;
      paramBoolean = false;
      break;
      paramString1 = paramAllInOne.h;
      break label123;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4, int paramInt5)
  {
    paramString3 = new Bundle();
    paramString3.putInt("type", 71);
    paramString3.putBoolean("isSuccess", paramBoolean);
    paramString3.putInt("appid", paramInt1);
    paramString3.putString("openGroupId", paramString1);
    paramString3.putString("token", paramString2);
    paramString3.putInt("freq", paramInt2);
    paramString3.putInt("expireTime", paramInt3);
    paramString3.putStringArrayList("apilist", paramArrayList);
    paramString3.putInt("seq", paramInt4);
    paramString3.putInt("retCode", paramInt5);
    this.a.a(28, paramString3);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 11);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramTroopInfo });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 25);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramTroopInfo, Integer.valueOf(paramInt2), paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    paramTroopInfo = new TroopManageCmd((QQAppInterface)TroopMemberApiService.b(this.a));
    paramString = PluginCommunicationHandler.getInstance();
    if (paramString != null) {
      paramString.register(paramTroopInfo);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", ((Integer)paramArrayOfObject[0]).intValue());
    paramTroopInfo.putString("processName", (String)paramArrayOfObject[1]);
    this.a.a(58, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 26);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 60);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), paramString2 });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", paramString2);
    this.a.a(3, localBundle);
  }
  
  protected void b(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.a.ap);
    localBundle.putInt("type", 73);
    localBundle.putBoolean("isSuccess", paramBoolean.booleanValue());
    this.a.a(43, localBundle);
  }
  
  protected void b(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 53);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */