package com.tencent.mobileqq.nearby.redtouch;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RedTouchUtil
{
  public static final SparseIntArray a;
  public static final SparseIntArray b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new SparseIntArray(4);
    b = new SparseIntArray(4);
    a.put(1, 0);
    a.put(2, 5);
    a.put(3, 3);
    a.put(4, 4);
    b.put(0, 1);
    b.put(5, 2);
    b.put(3, 3);
    b.put(4, 4);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 4)) {
      return a.get(paramInt);
    }
    return a.get(1);
  }
  
  public static RedTouchItem a(RedTouchItem paramRedTouchItem1, RedTouchItem paramRedTouchItem2)
  {
    RedTouchItem localRedTouchItem = new RedTouchItem();
    localRedTouchItem.unReadFlag = false;
    if ((paramRedTouchItem1 != null) && (paramRedTouchItem1.unReadFlag)) {
      if ((paramRedTouchItem2 != null) && (paramRedTouchItem2.unReadFlag))
      {
        i = a(paramRedTouchItem1.redtouchType);
        j = a(paramRedTouchItem2.redtouchType);
        if (i > j) {
          a(localRedTouchItem, paramRedTouchItem1);
        }
      }
    }
    while ((paramRedTouchItem2 == null) || (!paramRedTouchItem2.unReadFlag))
    {
      do
      {
        int i;
        int j;
        return localRedTouchItem;
        if (i != j) {
          break;
        }
        a(localRedTouchItem, paramRedTouchItem1);
      } while (paramRedTouchItem1.redtouchType != 2);
      localRedTouchItem.count += paramRedTouchItem2.count;
      return localRedTouchItem;
      a(localRedTouchItem, paramRedTouchItem2);
      return localRedTouchItem;
      a(localRedTouchItem, paramRedTouchItem1);
      return localRedTouchItem;
    }
    a(localRedTouchItem, paramRedTouchItem2);
    return localRedTouchItem;
  }
  
  public static RedTouchItem a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.red_display_info.has()) && (paramAppInfo.red_display_info.red_type_info.has()))
    {
      Object localObject1 = paramAppInfo.red_display_info.red_type_info.get();
      if (((List)localObject1).size() > 0)
      {
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next();
          if (b.get(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get()) != 0)
          {
            localObject2 = new RedTouchItem();
            ((RedTouchItem)localObject2).redtouchType = b.get(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get());
            try
            {
              ((RedTouchItem)localObject2).count = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
              ((RedTouchItem)localObject2).tips = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get();
              ((RedTouchItem)localObject2).icon = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get();
              if (paramAppInfo.iNewFlag.get() == 0) {}
              for (boolean bool = false;; bool = true)
              {
                ((RedTouchItem)localObject2).unReadFlag = bool;
                return (RedTouchItem)localObject2;
              }
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }
      }
    }
    return null;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString1);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    localAppInfo.appset.set(paramInt3);
    localAppInfo.buffer.set(paramString3);
    localAppInfo.uiAppId.set(paramInt2);
    localAppInfo.type.set(paramInt1);
    localAppInfo.iNewFlag.set(1);
    localAppInfo.appset.set(paramInt3);
    localAppInfo.mission_level.set(0);
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
      paramString3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString3.red_type.set(9);
      paramString3.red_content.set("-1");
      paramString3.red_desc.set("");
      paramString1.red_type_info.add(paramString3);
      paramString3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString3.red_type.set(paramInt1);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString3.red_content.set(paramString2);
        paramString3.red_desc.set("{'cn':'#FF0000'}");
      }
      paramString1.tab_display_info.set(paramString3);
      paramString1.red_type_info.add(paramString3);
      localAppInfo.red_display_info.set(paramString1);
    }
    while (paramInt1 != 0) {
      return localAppInfo;
    }
    paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
    paramString2 = new BusinessInfoCheckUpdate.RedTypeInfo();
    paramString2.red_type.set(0);
    paramString1.red_type_info.add(paramString2);
    localAppInfo.red_display_info.set(paramString1);
    return localAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt3, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (!paramBoolean2)) {
      return new BusinessInfoCheckUpdate.AppInfo();
    }
    if (QLog.isColorLevel()) {
      QLog.i(LocalRedTouchManager.a, 2, "buildRedTouchAppInfo, appset:" + paramInt3 + " path:" + paramString1);
    }
    paramString1 = a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
    if ((paramBoolean1) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (RedTouchManager)paramAppInterface.getManager(35);
      if (paramAppInterface != null) {
        paramAppInterface.a(paramString1, true);
      }
    }
    return paramString1;
  }
  
  public static void a(RedTouchItem paramRedTouchItem1, RedTouchItem paramRedTouchItem2)
  {
    paramRedTouchItem1.count = paramRedTouchItem2.count;
    paramRedTouchItem1.receiveTime = paramRedTouchItem2.receiveTime;
    paramRedTouchItem1.redtouchType = paramRedTouchItem2.redtouchType;
    paramRedTouchItem1.curSeq = paramRedTouchItem2.curSeq;
    paramRedTouchItem1.icon = paramRedTouchItem2.icon;
    paramRedTouchItem1.unReadFlag = paramRedTouchItem2.unReadFlag;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\redtouch\RedTouchUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */