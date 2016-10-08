package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;

public class DynamicAvatarInfo$UinHeadInfo
{
  public int a;
  public String a;
  public ArrayList a;
  public int b;
  public int c;
  public int d;
  
  public DynamicAvatarInfo$UinHeadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static UinHeadInfo a(oidb_0x74b.HeadInfo paramHeadInfo)
  {
    Object localObject;
    if (paramHeadInfo == null) {
      localObject = null;
    }
    UinHeadInfo localUinHeadInfo;
    do
    {
      return (UinHeadInfo)localObject;
      localUinHeadInfo = new UinHeadInfo();
      if (paramHeadInfo.uint32_id.has()) {
        localUinHeadInfo.jdField_a_of_type_Int = paramHeadInfo.uint32_id.get();
      }
      if (paramHeadInfo.str_photohead.has()) {
        localUinHeadInfo.jdField_a_of_type_JavaLangString = paramHeadInfo.str_photohead.get();
      }
      if (paramHeadInfo.uint32_invalid.has()) {
        localUinHeadInfo.b = paramHeadInfo.uint32_invalid.get();
      }
      if (paramHeadInfo.uint32_timestamp.has()) {
        localUinHeadInfo.c = paramHeadInfo.uint32_timestamp.get();
      }
      if (paramHeadInfo.uint32_type.has()) {
        localUinHeadInfo.d = paramHeadInfo.uint32_type.get();
      }
      localObject = localUinHeadInfo;
    } while (!paramHeadInfo.rpt_videoheadlist.has());
    localUinHeadInfo.jdField_a_of_type_JavaUtilArrayList = DynamicAvatarInfo.VideoHeadInfo.a(paramHeadInfo.rpt_videoheadlist.get());
    return localUinHeadInfo;
  }
  
  public static ArrayList a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UinHeadInfo localUinHeadInfo = a((oidb_0x74b.HeadInfo)paramList.next());
      if (localUinHeadInfo != null) {
        localArrayList.add(localUinHeadInfo);
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarInfo$UinHeadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */