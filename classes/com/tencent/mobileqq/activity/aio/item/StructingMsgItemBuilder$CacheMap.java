package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import nqi;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  private StructingMsgItemBuilder$CacheMap()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void add(nqi paramnqi)
  {
    if (paramnqi == null) {
      return;
    }
    get(paramnqi.a).add(paramnqi);
  }
  
  public ArrayList get(String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)super.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      put(paramString, localArrayList1);
    }
    return localArrayList1;
  }
  
  public void remove(nqi paramnqi)
  {
    if ((paramnqi == null) || (paramnqi.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramnqi.a);
      localArrayList.remove(paramnqi);
    } while (!localArrayList.isEmpty());
    remove(paramnqi.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\StructingMsgItemBuilder$CacheMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */