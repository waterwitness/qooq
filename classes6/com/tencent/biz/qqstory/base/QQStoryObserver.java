package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.ToastUtil;
import java.util.List;

public class QQStoryObserver
  implements BusinessObserver
{
  public QQStoryObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return;
    case 1003: 
      a(((Integer)paramObject).intValue());
      return;
    case 1004: 
      a(paramBoolean);
      return;
    case 1001: 
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(paramBoolean, (List)paramObject[0], (byte[])paramObject[1], ((Boolean)paramObject[2]).booleanValue());
        return;
      }
      a(false, null, null, true);
      return;
    case 1002: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    case 1005: 
      a(paramBoolean, (QQStoryUserInfo)paramObject);
      return;
    case 1006: 
      b(paramBoolean, (List)paramObject);
      return;
    case 1007: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        b(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
        return;
      }
      b(paramBoolean, 0, null);
      return;
    case 1008: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
        return;
      }
      a(paramBoolean, 0, null);
      return;
    case 1009: 
      a(paramBoolean, (UserInfo)paramObject);
      return;
    case 1010: 
      if (paramBoolean)
      {
        Object localObject3 = (Object[])paramObject;
        paramInt = ((Integer)localObject3[0]).intValue();
        paramObject = (List)localObject3[1];
        localObject1 = (Boolean)localObject3[2];
        localObject2 = (String)localObject3[3];
        localObject3 = (List)localObject3[4];
        a(paramBoolean, paramInt, (List)paramObject, ((Boolean)localObject1).booleanValue(), (String)localObject2, (List)localObject3);
        return;
      }
      a(false, 0, null, false, null, null);
      return;
    case 1011: 
      localObject1 = (Object[])paramObject;
      paramInt = ((Integer)localObject1[0]).intValue();
      paramObject = (String)localObject1[1];
      localObject1 = (Boolean)localObject1[2];
      if (paramBoolean)
      {
        a(paramBoolean, ((Boolean)localObject1).booleanValue(), paramInt, (String)paramObject);
        return;
      }
      a(paramBoolean, false, paramInt, (String)paramObject);
      return;
    case 1012: 
      if (paramBoolean)
      {
        localObject2 = (Object[])paramObject;
        paramObject = (List)localObject2[0];
        localObject1 = (Boolean)localObject2[1];
        localObject2 = (String)localObject2[2];
        a(paramBoolean, (List)paramObject, ((Boolean)localObject1).booleanValue(), (String)localObject2);
        return;
      }
      a(paramBoolean, null, false, null);
      return;
    case 1013: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (Story)paramObject[1]);
        return;
      }
      a(paramBoolean, 0, null);
      return;
    case 1014: 
      a(paramBoolean, (List)paramObject);
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    a(paramBoolean, 0, null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, Story paramStory) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean1, int paramInt, List paramList1, boolean paramBoolean2, String paramString, List paramList2) {}
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, String paramString) {}
  
  public void a(boolean paramBoolean1, List paramList, byte[] paramArrayOfByte, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        break label52;
      }
      paramString = "取消";
      if (paramInt != 0) {
        break label59;
      }
    }
    label52:
    label59:
    for (String str = "订阅";; str = "关注")
    {
      ToastUtil.a().a(paramString + str + "失败,请重试");
      return;
      paramString = "";
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void b(boolean paramBoolean, int paramInt, List paramList) {}
  
  public void b(boolean paramBoolean, List paramList) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\QQStoryObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */